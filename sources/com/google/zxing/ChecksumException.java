package com.google.zxing;
public final class ChecksumException extends ReaderException {
    public static final ChecksumException a;

    static {
        ChecksumException checksumException = new ChecksumException();
        a = checksumException;
        checksumException.setStackTrace(ReaderException.NO_TRACE);
    }

    private ChecksumException() {
    }

    public static ChecksumException getChecksumInstance() {
        return ReaderException.isStackTrace ? new ChecksumException() : a;
    }

    public ChecksumException(Throwable th) {
        super(th);
    }

    public static ChecksumException getChecksumInstance(Throwable th) {
        return ReaderException.isStackTrace ? new ChecksumException(th) : a;
    }
}
