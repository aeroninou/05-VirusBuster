package com.virusbuster.view;

import java.io.IOException;

public class Console {
    private static final String os = System.getProperty("os.name").toLowerCase();

    private Console() {
    }

    public static void clear() {
        ProcessBuilder process = os.contains("windows") ? new ProcessBuilder(new String[]{"cmd", "/c", "cls"}) : new ProcessBuilder(new String[]{"clear"});

        try {
            process.inheritIO().start().waitFor();
        } catch (IOException var3) {
            var3.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
