package com.vendesilk.ui.exception;

import com.vendesilk.ui.support.ScreeCapture;

public class FrameworkException extends Exception{
//    private static final Logger log = Logger.getLogger(FrameworkException.class);

    /**
     * Constructor passing message only
     * @param message
     */
    public FrameworkException(String message) {
        super(message);
        try {
            ScreeCapture.captureDesktopScreenshot(ScreeCapture.getFileName());
        } catch (FrameworkException e) {
            e.printStackTrace();
        }
//        log.error(message);
    }

    /**
     * Constructor passing message and com.cambio.qa.utils.exception object
     * @param message error message
     * @param e com.cambio.qa.utils.exception object
     */
    public FrameworkException(String message, Exception e) {
        super(message, e);
//        log.error(message, e);
    }
}
