package com.vendesilk.ui.exception;


public class ComponentMatchException extends FrameworkException {

    public ComponentMatchException(String message) {
        super(message);
//        log.error(message);
    }

    /**
     * Constructor passing message and com.cambio.qa.utils.exception object
     *
     * @param message error message
     * @param e com.cambio.qa.utils.exception object
     */
    public ComponentMatchException(String message, Exception e) {
        super(message, e);
//        log.error(message, e);
    }
}
