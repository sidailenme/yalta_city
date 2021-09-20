package ru.yalta.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Queue;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageReceiver {

    private final RegistrationService registrationService;
    private final Queue<Update> receiveQueue;
    private final Queue<SendMessage> sendQueue;

    public void checkNewMessages() {
        for (Update message = receiveQueue.poll(); message != null; message = receiveQueue.poll()) {
            log.trace("<<< chatId: {}, text: {}", message.getMessage().getChatId(), message.getMessage().getText());
            receive(message);
        }
    }

    private void receive(Update message) {
        String userId = message.getMessage().getChatId().toString();


    }


}