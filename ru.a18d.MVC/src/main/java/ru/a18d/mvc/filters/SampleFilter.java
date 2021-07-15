package ru.a18d.mvc.filters;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class SampleFilter extends Filter<ILoggingEvent> {

    @Override
    public FilterReply decide(ILoggingEvent event) {
        String loggerName = event.getLoggerName().toUpperCase();

        if (!loggerName.contains("a18d".toUpperCase())) {
            return FilterReply.DENY;
        }
        else {
            return FilterReply.NEUTRAL;
        }
    }
}