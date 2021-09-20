package ru.yalta.config;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Queue;

@Getter
@Service
@RequiredArgsConstructor
public class TelegramBotCore extends TelegramLongPollingBot {

    @Value("${bot.telegram.username}")
    private String botUsername;

    @Value("${bot.telegram.token}")
    private String botToken;

    private final Queue<Update> receiveQueue;

    @Override
    public void onUpdateReceived(Update update) {
        receiveQueue.add(update);
    }
}
