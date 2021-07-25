package com.github.git_leon.hackerrank.sherlockandanagrams;

public abstract class AbstractSherlockAndAnagrams implements SherlockAndAnagramsInterface {
    protected final String originalString;

    public AbstractSherlockAndAnagrams(String s) {
        this.originalString = s;
    }
}
