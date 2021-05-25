package com.avito.android.remote;
public class InvalidSchemaException extends Exception {
    private static final long serialVersionUID = 1;

    public InvalidSchemaException() {
    }

    public InvalidSchemaException(String str) {
        super(str);
    }

    public InvalidSchemaException(String str, Throwable th) {
        super(str, th);
    }

    public InvalidSchemaException(Throwable th) {
        super(th);
    }
}
