package hu.akarnokd.rxjava3.debug.validator;
public final class MultipleTerminationsException extends ProtocolNonConformanceException {
    private static final long serialVersionUID = -6096755460680899745L;

    public MultipleTerminationsException() {
    }

    public MultipleTerminationsException(Throwable th) {
        super(th);
    }
}
