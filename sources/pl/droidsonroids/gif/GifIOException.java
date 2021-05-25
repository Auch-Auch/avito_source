package pl.droidsonroids.gif;

import androidx.annotation.NonNull;
import java.io.IOException;
public class GifIOException extends IOException {
    public static final /* synthetic */ int b = 0;
    private static final long serialVersionUID = 13038402904505L;
    public final String a;
    @NonNull
    public final GifError reason;

    public GifIOException(int i, String str) {
        this.reason = GifError.a(i);
        this.a = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.a == null) {
            return this.reason.b();
        }
        return this.reason.b() + ": " + this.a;
    }
}
