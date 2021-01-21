package com.github.tschierv.memorygame;

/**
 * Workaround to fix issue with jar not starting correctly
 * Wraps actual main class
 */
public class LauncherMain {
    public static void main(String[] args) {
        Main.main(args);
    }
}
