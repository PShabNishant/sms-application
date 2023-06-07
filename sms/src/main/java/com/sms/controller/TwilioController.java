package com.sms.controller;

import com.sms.payload.SmsRequestDto;
import com.sms.service.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    public class TwilioController {
        private final TwilioService twilioService;

        @Autowired
        public TwilioController(TwilioService twilioService) {
            this.twilioService = twilioService;
        }

        @PostMapping("/send-sms")
        public void sendSms(@RequestBody SmsRequestDto smsRequest) {
            twilioService.sendSMS(smsRequest.getPhoneNumber(), smsRequest.getMessage());
        }
    }


