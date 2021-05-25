package com.google.android.gms.internal.vision;

import a2.b.a.a.a;
import java.util.Map;
import kotlin.UShort;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzes<K, V> extends zzef<K, V> {
    public static final zzef<Object, Object> zznn = new zzes(null, new Object[0], 0);
    private final transient int size;
    private final transient Object[] zznd;
    private final transient Object zzno;

    private zzes(Object obj, Object[] objArr, int i) {
        this.zzno = obj;
        this.zznd = objArr;
        this.size = i;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x006c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [int[]] */
    /* JADX WARN: Type inference failed for: r8v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [short[]] */
    /* JADX WARN: Type inference failed for: r7v5, types: [short] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r7v7, types: [byte] */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0056, code lost:
        r2[r6] = (byte) r3;
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0097, code lost:
        r2[r6] = (short) r3;
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00cc, code lost:
        r2[r7] = r3;
        r1 = r1 + 1;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <K, V> com.google.android.gms.internal.vision.zzes<K, V> zza(int r10, java.lang.Object[] r11) {
        /*
        // Method dump skipped, instructions count: 231
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzes.zza(int, java.lang.Object[]):com.google.android.gms.internal.vision.zzes");
    }

    @Override // com.google.android.gms.internal.vision.zzef, java.util.Map
    @NullableDecl
    public final V get(@NullableDecl Object obj) {
        Object obj2 = this.zzno;
        Object[] objArr = this.zznd;
        int i = this.size;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (objArr[0].equals(obj)) {
                return (V) objArr[1];
            }
            return null;
        } else if (obj2 == null) {
            return null;
        } else {
            if (obj2 instanceof byte[]) {
                byte[] bArr = (byte[]) obj2;
                int length = bArr.length - 1;
                int zzx = zzec.zzx(obj.hashCode());
                while (true) {
                    int i2 = zzx & length;
                    int i3 = bArr[i2] & 255;
                    if (i3 == 255) {
                        return null;
                    }
                    if (objArr[i3].equals(obj)) {
                        return (V) objArr[i3 ^ 1];
                    }
                    zzx = i2 + 1;
                }
            } else if (obj2 instanceof short[]) {
                short[] sArr = (short[]) obj2;
                int length2 = sArr.length - 1;
                int zzx2 = zzec.zzx(obj.hashCode());
                while (true) {
                    int i4 = zzx2 & length2;
                    int i5 = sArr[i4] & UShort.MAX_VALUE;
                    if (i5 == 65535) {
                        return null;
                    }
                    if (objArr[i5].equals(obj)) {
                        return (V) objArr[i5 ^ 1];
                    }
                    zzx2 = i4 + 1;
                }
            } else {
                int[] iArr = (int[]) obj2;
                int length3 = iArr.length - 1;
                int zzx3 = zzec.zzx(obj.hashCode());
                while (true) {
                    int i6 = zzx3 & length3;
                    int i7 = iArr[i6];
                    if (i7 == -1) {
                        return null;
                    }
                    if (objArr[i7].equals(obj)) {
                        return (V) objArr[i7 ^ 1];
                    }
                    zzx3 = i6 + 1;
                }
            }
        }
    }

    @Override // java.util.Map
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.vision.zzef
    public final zzej<Map.Entry<K, V>> zzcw() {
        return new zzer(this, this.zznd, 0, this.size);
    }

    @Override // com.google.android.gms.internal.vision.zzef
    public final zzej<K> zzcx() {
        return new zzet(this, new zzew(this.zznd, 0, this.size));
    }

    @Override // com.google.android.gms.internal.vision.zzef
    public final zzeb<V> zzcy() {
        return new zzew(this.zznd, 1, this.size);
    }

    private static IllegalArgumentException zza(Object obj, Object obj2, Object[] objArr, int i) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i]);
        String valueOf4 = String.valueOf(objArr[i ^ 1]);
        return new IllegalArgumentException(a.v(a.K(valueOf4.length() + valueOf3.length() + valueOf2.length() + valueOf.length() + 39, "Multiple entries with same key: ", valueOf, "=", valueOf2), " and ", valueOf3, "=", valueOf4));
    }
}
