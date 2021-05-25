package hu.akarnokd.rxjava3.debug.validator;
public final class OnSubscribeNotCalledException extends ProtocolNonConformanceException {
    private static final long serialVersionUID = -6096755460680899745L;

    public OnSubscribeNotCalledException() {
    }

    public OnSubscribeNotCalledException(Throwable th) {
        super(th);
    }
}
