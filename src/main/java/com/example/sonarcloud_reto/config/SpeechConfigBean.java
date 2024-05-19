package com.example.sonarcloud_reto.config;

import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.SpeechSynthesizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpeechConfigBean
{

    @Bean
    public SpeechConfig speechConfig()
    {
        String speechKey = "7d9d78756acf4e94975e1d944975e95e";
        String speechRegion = "eastus";
        return SpeechConfig.fromSubscription(speechKey, speechRegion);
    }

    @Bean
    public SpeechSynthesizer speechSynthesizer(SpeechConfig speechConfig)
    {
        return new SpeechSynthesizer(speechConfig);
    }
}