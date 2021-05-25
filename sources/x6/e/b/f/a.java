package x6.e.b.f;

import java.io.IOException;
public final class a extends IllegalStateException {
    public final /* synthetic */ IOException a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(String str, IOException iOException) {
        super(str);
        this.a = iOException;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }
}
