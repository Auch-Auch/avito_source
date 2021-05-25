package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.util.Map;
import kotlin.UShort;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdtt<K, V> extends zzdtk<K, V> {
    private static final zzdtk<Object, Object> zzhnr = new zzdtt(null, new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzhnp;
    private final transient Object zzhns;

    private zzdtt(Object obj, Object[] objArr, int i) {
        this.zzhns = obj;
        this.zzhnp = objArr;
        this.size = i;
    }

    private static IllegalArgumentException zza(Object obj, Object obj2, Object[] objArr, int i) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i]);
        String valueOf4 = String.valueOf(objArr[i ^ 1]);
        return new IllegalArgumentException(a.v(a.K(valueOf4.length() + valueOf3.length() + valueOf2.length() + valueOf.length() + 39, "Multiple entries with same key: ", valueOf, "=", valueOf2), " and ", valueOf3, "=", valueOf4));
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
    public static <K, V> com.google.android.gms.internal.ads.zzdtt<K, V> zzc(int r10, java.lang.Object[] r11) {
        /*
        // Method dump skipped, instructions count: 231
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdtt.zzc(int, java.lang.Object[]):com.google.android.gms.internal.ads.zzdtt");
    }

    @Override // com.google.android.gms.internal.ads.zzdtk, java.util.Map
    @NullableDecl
    public final V get(@NullableDecl Object obj) {
        Object obj2 = this.zzhns;
        Object[] objArr = this.zzhnp;
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
                int zzel = zzdtc.zzel(obj.hashCode());
                while (true) {
                    int i2 = zzel & length;
                    int i3 = bArr[i2] & 255;
                    if (i3 == 255) {
                        return null;
                    }
                    if (objArr[i3].equals(obj)) {
                        return (V) objArr[i3 ^ 1];
                    }
                    zzel = i2 + 1;
                }
            } else if (obj2 instanceof short[]) {
                short[] sArr = (short[]) obj2;
                int length2 = sArr.length - 1;
                int zzel2 = zzdtc.zzel(obj.hashCode());
                while (true) {
                    int i4 = zzel2 & length2;
                    int i5 = sArr[i4] & UShort.MAX_VALUE;
                    if (i5 == 65535) {
                        return null;
                    }
                    if (objArr[i5].equals(obj)) {
                        return (V) objArr[i5 ^ 1];
                    }
                    zzel2 = i4 + 1;
                }
            } else {
                int[] iArr = (int[]) obj2;
                int length3 = iArr.length - 1;
                int zzel3 = zzdtc.zzel(obj.hashCode());
                while (true) {
                    int i6 = zzel3 & length3;
                    int i7 = iArr[i6];
                    if (i7 == -1) {
                        return null;
                    }
                    if (objArr[i7].equals(obj)) {
                        return (V) objArr[i7 ^ 1];
                    }
                    zzel3 = i6 + 1;
                }
            }
        }
    }

    @Override // java.util.Map
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdtk
    public final zzdtn<Map.Entry<K, V>> zzawu() {
        return new zzdts(this, this.zzhnp, 0, this.size);
    }

    @Override // com.google.android.gms.internal.ads.zzdtk
    public final zzdtn<K> zzawv() {
        return new zzdtu(this, new zzdtx(this.zzhnp, 0, this.size));
    }

    @Override // com.google.android.gms.internal.ads.zzdtk
    public final zzdtf<V> zzaww() {
        return new zzdtx(this.zzhnp, 1, this.size);
    }
}
