package com.collince.rolexcore.util.exception;



public class EngineRuntimeException extends RuntimeException {

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public EngineRuntimeException() {
        super();
    }

    public EngineRuntimeException(String message) {
        super(message);
    }

    public EngineRuntimeException(Throwable cause) {
        super(cause);
    }

    public EngineRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
    //========================================================

}
