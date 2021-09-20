package ru.yalta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Configuration
public class AppConfig {

    @Bean
    public BotSession botSession(TelegramBotCore core) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        return telegramBotsApi.registerBot(core);
    }

    @Bean
    public Queue<Update> receiveQueue() {
        return new ConcurrentLinkedQueue<>();
    }

    @Bean
    public Queue<SendMessage> sendQueue() {
        return new ConcurrentLinkedQueue<>();
    }

}
