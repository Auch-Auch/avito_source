package a2.j.e.k;

import java.util.Objects;
import javax.annotation.Nonnull;
public final class a extends c {
    public final String a;
    public final String b;

    public a(String str, String str2) {
        Objects.requireNonNull(str, "Null libraryName");
        this.a = str;
        Objects.requireNonNull(str2, "Null version");
        this.b = str2;
    }

    @Override // a2.j.e.k.c
    @Nonnull
    public String a() {
        return this.a;
    }

    @Override // a2.j.e.k.c
    @Nonnull
    public String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!this.a.equals(cVar.a()) || !this.b.equals(cVar.b())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("LibraryVersion{libraryName=");
        L.append(this.a);
        L.append(", version=");
        return a2.b.a.a.a.t(L, this.b, "}");
    }
}
