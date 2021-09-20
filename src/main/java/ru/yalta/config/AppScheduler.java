package ru.yalta.config;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.yalta.service.MessageReceiver;
import ru.yalta.service.MessageSender;

@Service
@EnableScheduling
@RequiredArgsConstructor
public class AppScheduler {

    private final MessageReceiver messageReceiver;
    private final MessageSender messageSender;

    @Scheduled(initialDelayString = "${bot.config.scheduler-init-delay:10000}",
            fixedDelayString = "${bot.config.message-receive-delay:3000}")
    public void receiver() {
        messageReceiver.checkNewMessages();
    }

    @Scheduled(initialDelayString = "${bot.config.scheduler-init-delay:10000}",
            fixedDelayString = "${bot.config.message-send-delay:3000}")
    public void sender() {
        messageSender.sendMessages();
    }
}
