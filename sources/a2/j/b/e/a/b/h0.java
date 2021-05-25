package a2.j.b.e.a.b;

import a2.b.a.a.a;
public final class h0 extends z1 {
    public final int a;
    public final String b;
    public final long c;
    public final long d;
    public final int e;

    public h0(int i, String str, long j, long j2, int i2) {
        this.a = i;
        this.b = str;
        this.c = j;
        this.d = j2;
        this.e = i2;
    }

    @Override // a2.j.b.e.a.b.z1
    public final int a() {
        return this.a;
    }

    @Override // a2.j.b.e.a.b.z1
    public final String b() {
        return this.b;
    }

    @Override // a2.j.b.e.a.b.z1
    public final long c() {
        return this.c;
    }

    @Override // a2.j.b.e.a.b.z1
    public final long d() {
        return this.d;
    }

    @Override // a2.j.b.e.a.b.z1
    public final int e() {
        return this.e;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof z1) {
            z1 z1Var = (z1) obj;
            if (this.a == z1Var.a() && ((str = this.b) == null ? z1Var.b() == null : str.equals(z1Var.b())) && this.c == z1Var.c() && this.d == z1Var.d() && this.e == z1Var.e()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (this.a ^ 1000003) * 1000003;
        String str = this.b;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.c;
        long j2 = this.d;
        return ((((((i ^ hashCode) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.e;
    }

    public final String toString() {
        int i = this.a;
        String str = this.b;
        long j = this.c;
        long j2 = this.d;
        int i2 = this.e;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 157);
        sb.append("SliceCheckpoint{fileExtractionStatus=");
        sb.append(i);
        sb.append(", filePath=");
        sb.append(str);
        a.l1(sb, ", fileOffset=", j, ", remainingBytes=");
        sb.append(j2);
        sb.append(", previousChunk=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }
}
