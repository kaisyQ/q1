package com.kaisyq.app;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

import com.kaisyq.app.core.Env;

public final class App {
    public static void main(String[] args) {

        final var token = Env.get("TELEGRAM_API_KEY");

        final var bot = new Bot();
    
        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
            botsApplication.registerBot(token, bot);

            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
