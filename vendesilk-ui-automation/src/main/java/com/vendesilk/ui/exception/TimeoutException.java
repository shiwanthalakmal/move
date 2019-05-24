package com.vendesilk.ui.exception;

public class TimeoutException extends FrameworkException {
    //private static final Logger log = Logger.getLogger(TimeoutException.class);

    /**
     * Constructor passing message only
     *
     * @param message error message
     */
    public TimeoutException(String message) {
        super(message);
        //log.error(message);
    }

    /**
     * Constructor passing message and com.cambio.qa.utils.exception object
     *
     * @param message error message
     * @param e com.cambio.qa.utils.exception object
     */
    public TimeoutException(String message, Exception e) {
        super(message, e);
        //log.error(message, e);
    }
}

