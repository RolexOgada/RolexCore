package com.collince.rolexcore.util.exception;



public class CoreRuntimeException extends RuntimeException {

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public CoreRuntimeException() {
        super();
    }

    public CoreRuntimeException(String message) {
        super(message);
    }

    public CoreRuntimeException(Throwable cause) {
        super(cause);
    }

    public CoreRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
    //========================================================

}
