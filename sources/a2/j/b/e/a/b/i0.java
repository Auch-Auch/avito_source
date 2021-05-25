package a2.j.b.e.a.b;

import a2.b.a.a.a;
import java.util.Arrays;
public final class i0 extends f2 {
    public final String a;
    public final long b;
    public final int c;
    public final boolean d;
    public final byte[] e;

    public i0(String str, long j, int i, boolean z, byte[] bArr) {
        this.a = str;
        this.b = j;
        this.c = i;
        this.d = z;
        this.e = bArr;
    }

    @Override // a2.j.b.e.a.b.f2
    public final String a() {
        return this.a;
    }

    @Override // a2.j.b.e.a.b.f2
    public final long b() {
        return this.b;
    }

    @Override // a2.j.b.e.a.b.f2
    public final int c() {
        return this.c;
    }

    @Override // a2.j.b.e.a.b.f2
    public final boolean d() {
        return this.d;
    }

    @Override // a2.j.b.e.a.b.f2
    public final byte[] e() {
        return this.e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f2) {
            f2 f2Var = (f2) obj;
            String str = this.a;
            if (str == null ? f2Var.a() == null : str.equals(f2Var.a())) {
                if (this.b == f2Var.b() && this.c == f2Var.c() && this.d == f2Var.d()) {
                    if (Arrays.equals(this.e, f2Var instanceof i0 ? ((i0) f2Var).e : f2Var.e())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.a;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.b;
        return ((((((((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.c) * 1000003) ^ (!this.d ? 1237 : 1231)) * 1000003) ^ Arrays.hashCode(this.e);
    }

    public final String toString() {
        String str = this.a;
        long j = this.b;
        int i = this.c;
        boolean z = this.d;
        String arrays = Arrays.toString(this.e);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 104 + String.valueOf(arrays).length());
        a.m1(sb, "ZipEntry{name=", str, ", size=");
        sb.append(j);
        sb.append(", compressionMethod=");
        sb.append(i);
        sb.append(", isPartial=");
        sb.append(z);
        sb.append(", headerBytes=");
        sb.append(arrays);
        sb.append("}");
        return sb.toString();
    }
}
