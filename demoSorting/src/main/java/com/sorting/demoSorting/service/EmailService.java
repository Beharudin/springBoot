package com.sorting.demoSorting.service;

import com.sorting.demoSorting.response.ResponseHandler;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;
    private final ResponseHandler responseHandler;

    public ResponseEntity<Object> sendEmail(@NonNull String recipientEmail, @NonNull String emailSubject, @NonNull String emailBody) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setTo(recipientEmail);
            helper.setFrom("Beharudin <beharudinmm@gmail.com>");
            helper.setSubject(emailSubject);
            helper.setText(emailBody, true);
            mailSender.send(mimeMessage);
            return responseHandler.responseBuilder("Success",
                    HttpStatus.OK, "Email sent successfully.");
        } catch (MailException | MessagingException ex) {
            return responseHandler.responseBuilder("Failed",
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Cannot send email due to Internal Server Error. Please try again later.");
        }
    }
}

