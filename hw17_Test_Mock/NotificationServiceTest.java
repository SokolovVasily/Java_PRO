package org.example.Lessons19.Mockito.taski_hw17_Test_Mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NotificationServiceTest {
    @Mock
    private EmailService emailService;
    private NotificationService notificationService;
    private final User user = new User("Vasy", "berlin.de");
    private final String subject = "ABC";
    private final String message = "Hello World!";

    @BeforeEach
    public void init() {
        notificationService = new NotificationService(emailService);
    }

    @Test
    void notifyUserTrueTest() {
        Mockito.when(emailService.sendEmail(user.getEmail(), subject, message)).thenReturn(true);
        Assertions.assertTrue(notificationService.notifyUser(user, subject, message));
        Mockito.verify(emailService).sendEmail(user.getEmail(), subject, message);
    }

    @Test
    void notifyUserFalseTest() {
        Mockito.when(emailService.sendEmail(user.getEmail(), subject, message)).thenReturn(false);
        Assertions.assertFalse(notificationService.notifyUser(user, subject, message));
        Mockito.verify(emailService).sendEmail(user.getEmail(), subject, message);
    }

}