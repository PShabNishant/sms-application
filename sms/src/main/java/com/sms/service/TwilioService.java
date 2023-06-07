package com.sms.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


    @Service
    public class TwilioService {
        private final String accountSid;
        private final String authToken;
        private final String fromPhoneNumber;

        public TwilioService(@Value("${twilio.account.sid}") String accountSid,
                             @Value("${twilio.auth.token}") String authToken,
                             @Value("${twilio.phone.number}") String fromPhoneNumber) {
            this.accountSid = accountSid;
            this.authToken = authToken;
            this.fromPhoneNumber = fromPhoneNumber;
            Twilio.init(accountSid, authToken);
        }

        public void sendSMS(String toPhoneNumber, String message) {
            Message.creator(new PhoneNumber(toPhoneNumber), new PhoneNumber(fromPhoneNumber), message).create();
        }
    }





