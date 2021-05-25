package a2.j.d.g;

import a2.j.d.g.v;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public final class p extends v implements Serializable, n {
    private static final long serialVersionUID = 7249069246863182397L;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.c = 0;
        this.a = null;
        this.b = objectInputStream.readLong();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(a());
    }

    @Override // a2.j.d.g.n
    public long a() {
        long j = this.b;
        v.b[] bVarArr = this.a;
        if (bVarArr != null) {
            for (v.b bVar : bVarArr) {
                if (bVar != null) {
                    j += bVar.a;
                }
            }
        }
        return j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00b2, code lost:
        if (r13.a != r6) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00b4, code lost:
        r5 = new a2.j.d.g.v.b[(r7 << 1)];
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00b9, code lost:
        if (r8 >= r7) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00bb, code lost:
        r5[r8] = r6[r8];
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00c2, code lost:
        r13.a = r5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0049 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0111 A[SYNTHETIC] */
    @Override // a2.j.d.g.n
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void add(long r14) {
        /*
        // Method dump skipped, instructions count: 274
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.d.g.p.add(long):void");
    }

    @Override // a2.j.d.g.n
    public void b() {
        add(1);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return (double) a();
    }

    public final long f(long j, long j2) {
        return j + j2;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) a();
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) a();
    }

    @Override // java.lang.Number
    public long longValue() {
        return a();
    }

    @Override // java.lang.Object
    public String toString() {
        return Long.toString(a());
    }
}
