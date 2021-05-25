package com.google.android.datatransport;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;
public final class Encoding {
    public final String a;

    public Encoding(@NonNull String str) {
        Objects.requireNonNull(str, "name is null");
        this.a = str;
    }

    public static Encoding of(@NonNull String str) {
        return new Encoding(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Encoding)) {
            return false;
        }
        return this.a.equals(((Encoding) obj).a);
    }

    public String getName() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    @NonNull
    public String toString() {
        return a.t(a.L("Encoding{name=\""), this.a, "\"}");
    }
}
