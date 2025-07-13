package com.collince.rolexcore.util.exception;



public class CoreException extends Exception {

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public CoreException() {
        super();
    }

    public CoreException(String message) {
        super(message);
    }

    public CoreException(Throwable cause) {
        super(cause);
    }

    public CoreException(String message, Throwable cause) {
        super(message, cause);
    }
    //========================================================

}
