package com.kaisyq.app.core;

import io.github.cdimascio.dotenv.Dotenv;

public final class Env {

    private static Dotenv env = null;

    public static Dotenv getEnv() {
        check();

        return env;
    }

    public static String get(String key) {
        check();

        return env.get(key);
    }

    private static void check() {
        if (env == null) {
            env = Dotenv.configure().load();
        }
    }
}
