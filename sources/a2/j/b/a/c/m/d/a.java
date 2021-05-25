package a2.j.b.a.c.m.d;
public final class a extends c {
    public final long b;
    public final int c;
    public final int d;
    public final long e;
    public final int f;

    public a(long j, int i, int i2, long j2, int i3, C0035a aVar) {
        this.b = j;
        this.c = i;
        this.d = i2;
        this.e = j2;
        this.f = i3;
    }

    @Override // a2.j.b.a.c.m.d.c
    public int a() {
        return this.d;
    }

    @Override // a2.j.b.a.c.m.d.c
    public long b() {
        return this.e;
    }

    @Override // a2.j.b.a.c.m.d.c
    public int c() {
        return this.c;
    }

    @Override // a2.j.b.a.c.m.d.c
    public int d() {
        return this.f;
    }

    @Override // a2.j.b.a.c.m.d.c
    public long e() {
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
        if (this.b == cVar.e() && this.c == cVar.c() && this.d == cVar.a() && this.e == cVar.b() && this.f == cVar.d()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.b;
        long j2 = this.e;
        return this.f ^ ((((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("EventStoreConfig{maxStorageSizeInBytes=");
        L.append(this.b);
        L.append(", loadBatchSize=");
        L.append(this.c);
        L.append(", criticalSectionEnterTimeoutMs=");
        L.append(this.d);
        L.append(", eventCleanUpAge=");
        L.append(this.e);
        L.append(", maxBlobByteSizePerRow=");
        return a2.b.a.a.a.j(L, this.f, "}");
    }
}
