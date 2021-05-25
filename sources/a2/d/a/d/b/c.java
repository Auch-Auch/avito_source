package a2.d.a.d.b;
public final class c extends RuntimeException {
    private static final long serialVersionUID = -7530898992688511851L;

    public c(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
