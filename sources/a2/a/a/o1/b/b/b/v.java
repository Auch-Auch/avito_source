package a2.a.a.o1.b.b.b;

import org.jetbrains.annotations.Nullable;
public final class v extends Exception {
    @Nullable
    public final Throwable a;

    public v(@Nullable Throwable th) {
        this.a = th;
    }

    @Override // java.lang.Throwable
    @Nullable
    public Throwable getCause() {
        return this.a;
    }
}
