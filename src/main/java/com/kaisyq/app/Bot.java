package com.kaisyq.app;

import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import com.kaisyq.app.core.Env;

public class Bot implements LongPollingSingleThreadUpdateConsumer {

    private final TelegramClient client = new OkHttpTelegramClient(Env.get("TELEGRAM_API_KEY"));

    @Override
    public void consume(Update update) {
        System.out.println("Update");

        if (update.hasMessage() && update.getMessage().hasText()) {
            var message = SendMessage.builder()
                .chatId(update.getMessage().getChatId())
                .text(update.getMessage().getText())
                .build();

            try {
                client.execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
    
}
