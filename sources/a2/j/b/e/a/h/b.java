package a2.j.b.e.a.h;

import a2.b.a.a.a;
import java.io.File;
import java.util.Objects;
public final class b extends n {
    public final File a;
    public final String b;

    public b(File file, String str) {
        this.a = file;
        Objects.requireNonNull(str, "Null splitId");
        this.b = str;
    }

    @Override // a2.j.b.e.a.h.n
    public final File a() {
        return this.a;
    }

    @Override // a2.j.b.e.a.h.n
    public final String b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (this.a.equals(nVar.a()) && this.b.equals(nVar.b())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.a);
        String str = this.b;
        StringBuilder sb = new StringBuilder(valueOf.length() + 35 + str.length());
        a.n1(sb, "SplitFileInfo{splitFile=", valueOf, ", splitId=", str);
        sb.append("}");
        return sb.toString();
    }
}
