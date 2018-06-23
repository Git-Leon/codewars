package utils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.*;
import java.util.List;

@SuppressWarnings("unchecked")
@Deprecated
public class Utils {

    public static boolean chance(int percentChance) {
        return randint(100) < percentChance;
    }

    public static String dialogueInput(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }

    public static String generalException(Exception e) {
        StackTraceElement ste = lastMethodCall(3);
        String steClass = ste.getClassName();
        String steMethod = ste.getMethodName();
        int lineNumber = ste.getLineNumber();

        steClass = steClass.substring(steClass.lastIndexOf('.') + 1);

        return print(">> " + e.getClass().getSimpleName() + " caught by " + steClass + " in " + steMethod
            + " method call on line " + lineNumber + "\n\t^ " + e.getMessage());
    }

    public static String getColumnVal(long number) {
        StringBuilder sb = new StringBuilder();
        while (number-- > 0) {
            sb.append((char) ('a' + (number % 26)));
            number /= 26;
        }
        return sb.reverse().toString();
    }

    public static String getDate() {
        return Calendar.getInstance().getTime().toString().replace(":", ".");
    }

    public static double getElapsedTime(double t0) {
        return (((double) System.nanoTime()) - t0) / 1000000.0;
    }

    public static String getFirstNChars(String str, int n) {
        return str.substring(0, Math.min(str.length(), n));
    }

    public static String getLastNChars(String str, int n) {
        return str.substring(Math.max(str.length() - n, 0));
    }

    public static <T> String getObjectId(T obj) {
        return obj.getClass().getSimpleName() + " - " + Math.abs(obj.hashCode());
    }

    public static <T> T getRandomItem(T... args) {
        return args[randint(args.length - 1)];
    }

    private static String klickable(StackTraceElement ste) {
        String className = ste.getClassName();
        String methodName = ste.getMethodName();
        className = className.substring(className.lastIndexOf('.') + 1);
        return "(" + className + ".java:" + ste.getLineNumber() + ")." + methodName;
    }

    public static StackTraceElement lastMethodCall(int n) {
        return Thread.currentThread().getStackTrace()[n];
    }

    // Add log dialogue to report corresponding to specified exception
    public static String logException(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));

        StackTraceElement ste = lastMethodCall(3);
        String exceptionName = e.getClass().getSimpleName();
        String header = "\n" + exceptionName + " caught by " + klickable(ste);
        String border = repeatStr("-", 100);
        return print("\n\n" + border + header + "\n" + parseStackTrace(e) + "\n" + border + "\n\n");
    }

    public static void makeMissingDirectories(String directory) {
        if (directory != null) {
            try {
                new File(directory).mkdirs();
            } catch (Exception e) {
                logException(e);
            }
        }
    }

    public static File openFile(File file) {
        return openFile(file.getAbsolutePath());
    }

    public static File openFile(String fullpath) {
        File file = new File(fullpath);
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            } else {
                throw new Exception("Awt Desktop is not supported!");
            }
        } catch (Exception e) {
            logException(e);
        }
        return file;
    }

    public static String padLeft(String s, int n) {
        return String.format("%1$" + n + "s", s);
    }

    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    // Parse and neatly display stack trace elements
    public static String parseStackTrace(Throwable t) {
        StringBuilder result = new StringBuilder();
        String tmessage = t.getMessage() == null ? "Exception Message = null" : t.getMessage();
        String[] details = tmessage.split("\n");
        String delimiter = "\n";
        String message = details[0];
        String info = String.join("\n", Arrays.copyOfRange(details, 1, details.length));

        result.append(message);
        result.append(delimiter + info + delimiter);
        result.append("Stacktrace:");

        StackTraceElement[] ste = t.getStackTrace();
        Collections.reverse(Arrays.asList(ste));
        for (int i = 1; i < ste.length; i++) {
            StackTraceElement sti = ste[i];
            if (sti.getLineNumber() < 0) {
                continue;
            }
            result.append(delimiter + "\t>> " + klickable(sti));
        }
        return result.toString();
    }

    public static <T> T[] print(T... args) {
        try {
            for (T arg : args) {
                print(arg);
            }
        } catch (Exception e) {
            logException(e);
        }
        return args;
    }

    public static <T> T print(T arg) {
        System.out.println(arg);
        return arg;
    }

    public static String printElapsedTime(double t0) {
        return print("Elapsed Time: " + getElapsedTime(t0) + " milliseconds");
    }

    public static <T> T printFields(T object) {
        try {
            String objectId = getObjectId(object);
            print("[" + objectId + "]");
            for (Field field : object.getClass().getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    print("\t" + field.getName() + " = " + field.get(object).toString());
                    field.setAccessible(false);
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {

        }
        print("\n");
        return object;
    }

    public static <T> void printIterable(List<T> iterable) {
        printIterable(iterable.toArray());
    }

    public static <T> void printIterable(T... iterable) {
        for (T t : iterable) {
            print(t.toString());
        }
    }

    public static <T> T[] printObjectFields(T... objects) {
        String objId = null;
        boolean isList = false;
        boolean isArray = false;
        for (T obj : objects) {
            isList = obj instanceof Iterable;
            isArray = obj instanceof Object[];
            printFields(obj);
            if (!(isList || isArray)) {
                continue;
            }

            objId = getObjectId(obj);
            if (isList) {
                List<T> objList = (List<T>) obj;
                if (objList.isEmpty()) {
                    continue;
                }
                print("Printing elements from List [" + objId + "]");
                for (T o : objList) {
                    printFields(o);
                }
            }

            if (isArray) {
                T[] objArray = (T[]) obj;
                if (objArray.length < 1) {
                    continue;
                }
                print("Printing elements from Array [" + objId + "]");
                for (T o : objArray) {
                    printFields(o);
                }
            }
        }
        return objects;
    }

    public static int randint(int max) {
        return randint(0, max);
    }

    public static int randint(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    @SafeVarargs
    public static <T> T randomItem(T... args) {
        return args[randint(args.length - 1)];
    }

    public static String repeatStr(String string, int repeats) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeats; i++) {
            sb.append(string);
        }
        return sb.toString();
    }

    public static <E> E[] reverseArray(E[] array) {
        ArrayList<E> list = toArrayList(array);
        Collections.reverse(list);
        return toArray(list);
    }

    public static <E> E[] sortArrayAscending(E[] array) {
        Arrays.sort(array);
        return array;
    }

    public static <E> E[] sortArrayDescending(E[] array) {
        return reverseArray(sortArrayAscending(array));	
    }

    @SuppressWarnings("unchecked")
    public static <E> E[] toArray(List<E> list) {
        return list.toArray((E[]) new Object[list.size()]);
    }

    public static <E> ArrayList<E> toArrayList(E[] array) {
        return new ArrayList<E>(Arrays.asList(array));
    }
}
