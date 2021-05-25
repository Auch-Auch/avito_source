package com.google.zxing;
public final class FormatException extends ReaderException {
    public static final FormatException a;

    static {
        FormatException formatException = new FormatException();
        a = formatException;
        formatException.setStackTrace(ReaderException.NO_TRACE);
    }

    private FormatException() {
    }

    public static FormatException getFormatInstance() {
        return ReaderException.isStackTrace ? new FormatException() : a;
    }

    public FormatException(Throwable th) {
        super(th);
    }

    public static FormatException getFormatInstance(Throwable th) {
        return ReaderException.isStackTrace ? new FormatException(th) : a;
    }
}
