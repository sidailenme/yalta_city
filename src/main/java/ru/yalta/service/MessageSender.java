package ru.yalta.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.yalta.config.TelegramBotCore;

import java.util.Queue;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageSender {

    private final TelegramBotCore core;
    private final Queue<SendMessage> sendQueue;

    public void sendMessages() {
        for (SendMessage message = sendQueue.poll(); message != null; message = sendQueue.poll()) {
            try {
                send(message);
            } catch (TelegramApiException e) {
                log.error("sendMessage: error send \"{}\" to userId {}. Message returned to queue", message.getText(), message.getChatId());
                sendQueue.add(message);
            }
        }
    }

    private void send(SendMessage message) throws TelegramApiException {
        log.trace(">>> chatId: {}, text: {}", message.getChatId(), message.getText());
        core.execute(message);
    }

}
