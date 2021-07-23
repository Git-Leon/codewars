package com.github.git_leon.exercises.sherlockandanagrams;

import javafx.util.Pair;

import java.util.Collection;

public abstract class AbstractSherlockAndAnagrams implements SherlockAndAnagramsInterface {
    protected final String originalString;

    public AbstractSherlockAndAnagrams(String s) {
        this.originalString = s;
    }
}
