package org.example.java_practice.chainResponsibilityLLD;

public class LogProcessor {

    private LogProcessor nextProcessor;

    public void setNextProcessor(LogProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void processLog(LogProcessor log) {
        if (nextProcessor != null) {
            nextProcessor.processLog(log);
        }
    }
}
