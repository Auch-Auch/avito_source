package androidx.work;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public final class Data {
    public static final Data EMPTY = new Builder().build();
    @SuppressLint({"MinMaxConstant"})
    public static final int MAX_DATA_BYTES = 10240;
    public static final String b = Logger.tagWithPrefix("Data");
    public Map<String, Object> a;

    public static final class Builder {
        public Map<String, Object> a = new HashMap();

        @NonNull
        public Data build() {
            Data data = new Data(this.a);
            Data.toByteArrayInternal(data);
            return data;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder put(@NonNull String str, @Nullable Object obj) {
            if (obj == null) {
                this.a.put(str, null);
            } else {
                Class<?> cls = obj.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    this.a.put(str, obj);
                } else if (cls == boolean[].class) {
                    this.a.put(str, Data.a((boolean[]) obj));
                } else if (cls == byte[].class) {
                    this.a.put(str, Data.b((byte[]) obj));
                } else if (cls == int[].class) {
                    this.a.put(str, Data.e((int[]) obj));
                } else if (cls == long[].class) {
                    this.a.put(str, Data.f((long[]) obj));
                } else if (cls == float[].class) {
                    this.a.put(str, Data.d((float[]) obj));
                } else if (cls == double[].class) {
                    this.a.put(str, Data.c((double[]) obj));
                } else {
                    throw new IllegalArgumentException(String.format("Key %s has invalid type %s", str, cls));
                }
            }
            return this;
        }

        @NonNull
        public Builder putAll(@NonNull Data data) {
            putAll(data.a);
            return this;
        }

        @NonNull
        public Builder putBoolean(@NonNull String str, boolean z) {
            this.a.put(str, Boolean.valueOf(z));
            return this;
        }

        @NonNull
        public Builder putBooleanArray(@NonNull String str, @NonNull boolean[] zArr) {
            this.a.put(str, Data.a(zArr));
            return this;
        }

        @NonNull
        public Builder putByte(@NonNull String str, byte b) {
            this.a.put(str, Byte.valueOf(b));
            return this;
        }

        @NonNull
        public Builder putByteArray(@NonNull String str, @NonNull byte[] bArr) {
            this.a.put(str, Data.b(bArr));
            return this;
        }

        @NonNull
        public Builder putDouble(@NonNull String str, double d) {
            this.a.put(str, Double.valueOf(d));
            return this;
        }

        @NonNull
        public Builder putDoubleArray(@NonNull String str, @NonNull double[] dArr) {
            this.a.put(str, Data.c(dArr));
            return this;
        }

        @NonNull
        public Builder putFloat(@NonNull String str, float f) {
            this.a.put(str, Float.valueOf(f));
            return this;
        }

        @NonNull
        public Builder putFloatArray(@NonNull String str, @NonNull float[] fArr) {
            this.a.put(str, Data.d(fArr));
            return this;
        }

        @NonNull
        public Builder putInt(@NonNull String str, int i) {
            this.a.put(str, Integer.valueOf(i));
            return this;
        }

        @NonNull
        public Builder putIntArray(@NonNull String str, @NonNull int[] iArr) {
            this.a.put(str, Data.e(iArr));
            return this;
        }

        @NonNull
        public Builder putLong(@NonNull String str, long j) {
            this.a.put(str, Long.valueOf(j));
            return this;
        }

        @NonNull
        public Builder putLongArray(@NonNull String str, @NonNull long[] jArr) {
            this.a.put(str, Data.f(jArr));
            return this;
        }

        @NonNull
        public Builder putString(@NonNull String str, @Nullable String str2) {
            this.a.put(str, str2);
            return this;
        }

        @NonNull
        public Builder putStringArray(@NonNull String str, @NonNull String[] strArr) {
            this.a.put(str, strArr);
            return this;
        }

        @NonNull
        public Builder putAll(@NonNull Map<String, Object> map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
            return this;
        }
    }

    public Data() {
    }

    @NonNull
    public static Boolean[] a(@NonNull boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i = 0; i < zArr.length; i++) {
            boolArr[i] = Boolean.valueOf(zArr[i]);
        }
        return boolArr;
    }

    @NonNull
    public static Byte[] b(@NonNull byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = Byte.valueOf(bArr[i]);
        }
        return bArr2;
    }

    @NonNull
    public static Double[] c(@NonNull double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = Double.valueOf(dArr[i]);
        }
        return dArr2;
    }

    @NonNull
    public static Float[] d(@NonNull float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = Float.valueOf(fArr[i]);
        }
        return fArr2;
    }

    @NonNull
    public static Integer[] e(@NonNull int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    @NonNull
    public static Long[] f(@NonNull long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return lArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036 A[SYNTHETIC, Splitter:B:18:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0040  */
    @androidx.annotation.NonNull
    @androidx.room.TypeConverter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.work.Data fromByteArray(@androidx.annotation.NonNull byte[] r5) {
        /*
            int r0 = r5.length
            r1 = 10240(0x2800, float:1.4349E-41)
            if (r0 > r1) goto L_0x004c
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r5)
            r5 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch:{ IOException | ClassNotFoundException -> 0x003d, all -> 0x0033 }
            r2.<init>(r1)     // Catch:{ IOException | ClassNotFoundException -> 0x003d, all -> 0x0033 }
            int r5 = r2.readInt()     // Catch:{ IOException | ClassNotFoundException -> 0x0031, all -> 0x002d }
        L_0x0019:
            if (r5 <= 0) goto L_0x0029
            java.lang.String r3 = r2.readUTF()     // Catch:{ IOException | ClassNotFoundException -> 0x0031, all -> 0x002d }
            java.lang.Object r4 = r2.readObject()     // Catch:{ IOException | ClassNotFoundException -> 0x0031, all -> 0x002d }
            r0.put(r3, r4)     // Catch:{ IOException | ClassNotFoundException -> 0x0031, all -> 0x002d }
            int r5 = r5 + -1
            goto L_0x0019
        L_0x0029:
            r2.close()     // Catch:{ IOException -> 0x0043 }
            goto L_0x0043
        L_0x002d:
            r5 = move-exception
            r0 = r5
            r5 = r2
            goto L_0x0034
        L_0x0031:
            r5 = r2
            goto L_0x003e
        L_0x0033:
            r0 = move-exception
        L_0x0034:
            if (r5 == 0) goto L_0x0039
            r5.close()     // Catch:{ IOException -> 0x0039 }
        L_0x0039:
            r1.close()     // Catch:{ IOException -> 0x003c }
        L_0x003c:
            throw r0
        L_0x003d:
        L_0x003e:
            if (r5 == 0) goto L_0x0043
            r5.close()
        L_0x0043:
            r1.close()     // Catch:{ IOException -> 0x0046 }
        L_0x0046:
            androidx.work.Data r5 = new androidx.work.Data
            r5.<init>(r0)
            return r5
        L_0x004c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.fromByteArray(byte[]):androidx.work.Data");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0063 A[SYNTHETIC, Splitter:B:29:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006c A[SYNTHETIC, Splitter:B:37:0x006c] */
    @androidx.annotation.NonNull
    @androidx.room.TypeConverter
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] toByteArrayInternal(@androidx.annotation.NonNull androidx.work.Data r4) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x005d }
            r2.<init>(r0)     // Catch:{ IOException -> 0x005d }
            int r1 = r4.size()     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            r2.writeInt(r1)     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            java.util.Map<java.lang.String, java.lang.Object> r4 = r4.a     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            java.util.Set r4 = r4.entrySet()     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
        L_0x001c:
            boolean r1 = r4.hasNext()     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            if (r1 == 0) goto L_0x0039
            java.lang.Object r1 = r4.next()     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            java.lang.Object r3 = r1.getKey()     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            r2.writeUTF(r3)     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            r2.writeObject(r1)     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            goto L_0x001c
        L_0x0039:
            r2.close()     // Catch:{ IOException -> 0x003c }
        L_0x003c:
            r0.close()     // Catch:{ IOException -> 0x0040 }
            goto L_0x0041
        L_0x0040:
        L_0x0041:
            int r4 = r0.size()
            r1 = 10240(0x2800, float:1.4349E-41)
            if (r4 > r1) goto L_0x004e
            byte[] r4 = r0.toByteArray()
            return r4
        L_0x004e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r4.<init>(r0)
            throw r4
        L_0x0056:
            r4 = move-exception
            r1 = r2
            goto L_0x006a
        L_0x0059:
            r1 = r2
            goto L_0x005d
        L_0x005b:
            r4 = move-exception
            goto L_0x006a
        L_0x005d:
            byte[] r4 = r0.toByteArray()     // Catch:{ all -> 0x005b }
            if (r1 == 0) goto L_0x0066
            r1.close()     // Catch:{ IOException -> 0x0066 }
        L_0x0066:
            r0.close()     // Catch:{ IOException -> 0x0069 }
        L_0x0069:
            return r4
        L_0x006a:
            if (r1 == 0) goto L_0x006f
            r1.close()     // Catch:{ IOException -> 0x006f }
        L_0x006f:
            r0.close()     // Catch:{ IOException -> 0x0072 }
        L_0x0072:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.toByteArrayInternal(androidx.work.Data):byte[]");
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj == null || Data.class != obj.getClass()) {
            return false;
        }
        Data data = (Data) obj;
        Set<String> keySet = this.a.keySet();
        if (!keySet.equals(data.a.keySet())) {
            return false;
        }
        for (String str : keySet) {
            Object obj2 = this.a.get(str);
            Object obj3 = data.a.get(str);
            if (obj2 == null || obj3 == null) {
                if (obj2 == obj3) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
            } else if (!(obj2 instanceof Object[]) || !(obj3 instanceof Object[])) {
                z = obj2.equals(obj3);
                continue;
            } else {
                z = Arrays.deepEquals((Object[]) obj2, (Object[]) obj3);
                continue;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public boolean getBoolean(@NonNull String str, boolean z) {
        Object obj = this.a.get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
    }

    @Nullable
    public boolean[] getBooleanArray(@NonNull String str) {
        Object obj = this.a.get(str);
        if (!(obj instanceof Boolean[])) {
            return null;
        }
        Boolean[] boolArr = (Boolean[]) obj;
        boolean[] zArr = new boolean[boolArr.length];
        for (int i = 0; i < boolArr.length; i++) {
            zArr[i] = boolArr[i].booleanValue();
        }
        return zArr;
    }

    public byte getByte(@NonNull String str, byte b2) {
        Object obj = this.a.get(str);
        return obj instanceof Byte ? ((Byte) obj).byteValue() : b2;
    }

    @Nullable
    public byte[] getByteArray(@NonNull String str) {
        Object obj = this.a.get(str);
        if (!(obj instanceof Byte[])) {
            return null;
        }
        Byte[] bArr = (Byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = bArr[i].byteValue();
        }
        return bArr2;
    }

    public double getDouble(@NonNull String str, double d) {
        Object obj = this.a.get(str);
        return obj instanceof Double ? ((Double) obj).doubleValue() : d;
    }

    @Nullable
    public double[] getDoubleArray(@NonNull String str) {
        Object obj = this.a.get(str);
        if (!(obj instanceof Double[])) {
            return null;
        }
        Double[] dArr = (Double[]) obj;
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = dArr[i].doubleValue();
        }
        return dArr2;
    }

    public float getFloat(@NonNull String str, float f) {
        Object obj = this.a.get(str);
        return obj instanceof Float ? ((Float) obj).floatValue() : f;
    }

    @Nullable
    public float[] getFloatArray(@NonNull String str) {
        Object obj = this.a.get(str);
        if (!(obj instanceof Float[])) {
            return null;
        }
        Float[] fArr = (Float[]) obj;
        float[] fArr2 = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = fArr[i].floatValue();
        }
        return fArr2;
    }

    public int getInt(@NonNull String str, int i) {
        Object obj = this.a.get(str);
        return obj instanceof Integer ? ((Integer) obj).intValue() : i;
    }

    @Nullable
    public int[] getIntArray(@NonNull String str) {
        Object obj = this.a.get(str);
        if (!(obj instanceof Integer[])) {
            return null;
        }
        Integer[] numArr = (Integer[]) obj;
        int[] iArr = new int[numArr.length];
        for (int i = 0; i < numArr.length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        return iArr;
    }

    @NonNull
    public Map<String, Object> getKeyValueMap() {
        return Collections.unmodifiableMap(this.a);
    }

    public long getLong(@NonNull String str, long j) {
        Object obj = this.a.get(str);
        return obj instanceof Long ? ((Long) obj).longValue() : j;
    }

    @Nullable
    public long[] getLongArray(@NonNull String str) {
        Object obj = this.a.get(str);
        if (!(obj instanceof Long[])) {
            return null;
        }
        Long[] lArr = (Long[]) obj;
        long[] jArr = new long[lArr.length];
        for (int i = 0; i < lArr.length; i++) {
            jArr[i] = lArr[i].longValue();
        }
        return jArr;
    }

    @Nullable
    public String getString(@NonNull String str) {
        Object obj = this.a.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    @Nullable
    public String[] getStringArray(@NonNull String str) {
        Object obj = this.a.get(str);
        if (obj instanceof String[]) {
            return (String[]) obj;
        }
        return null;
    }

    public <T> boolean hasKeyWithValueOfType(@NonNull String str, @NonNull Class<T> cls) {
        Object obj = this.a.get(str);
        return obj != null && cls.isAssignableFrom(obj.getClass());
    }

    public int hashCode() {
        return this.a.hashCode() * 31;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public int size() {
        return this.a.size();
    }

    @NonNull
    public byte[] toByteArray() {
        return toByteArrayInternal(this);
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        if (!this.a.isEmpty()) {
            for (String str : this.a.keySet()) {
                sb.append(str);
                sb.append(" : ");
                Object obj = this.a.get(str);
                if (obj instanceof Object[]) {
                    sb.append(Arrays.toString((Object[]) obj));
                } else {
                    sb.append(obj);
                }
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public Data(@NonNull Data data) {
        this.a = new HashMap(data.a);
    }

    public Data(@NonNull Map<String, ?> map) {
        this.a = new HashMap(map);
    }
}
