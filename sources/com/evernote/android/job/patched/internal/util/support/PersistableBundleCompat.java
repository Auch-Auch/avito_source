package com.evernote.android.job.patched.internal.util.support;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.evernote.android.job.patched.internal.util.JobCat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;
public final class PersistableBundleCompat {
    public static final JobCat b = new JobCat("PersistableBundleCompat");
    public final Map<String, Object> a;

    public PersistableBundleCompat() {
        this.a = new HashMap();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0033 A[SYNTHETIC, Splitter:B:20:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0046 A[SYNTHETIC, Splitter:B:27:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x004c A[SYNTHETIC, Splitter:B:32:0x004c] */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.evernote.android.job.patched.internal.util.support.PersistableBundleCompat fromXml(@androidx.annotation.NonNull java.lang.String r3) {
        /*
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0037, VerifyError -> 0x0026 }
            java.lang.String r2 = "UTF-8"
            byte[] r3 = r3.getBytes(r2)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0037, VerifyError -> 0x0026 }
            r1.<init>(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0037, VerifyError -> 0x0026 }
            java.util.HashMap r3 = androidx.appcompat.app.AppCompatDelegateImpl.i.J1(r1)     // Catch:{ XmlPullParserException -> 0x0021, IOException -> 0x001f, VerifyError -> 0x001c, all -> 0x0019 }
            com.evernote.android.job.patched.internal.util.support.PersistableBundleCompat r0 = new com.evernote.android.job.patched.internal.util.support.PersistableBundleCompat     // Catch:{ XmlPullParserException -> 0x0021, IOException -> 0x001f, VerifyError -> 0x001c, all -> 0x0019 }
            r0.<init>(r3)     // Catch:{ XmlPullParserException -> 0x0021, IOException -> 0x001f, VerifyError -> 0x001c, all -> 0x0019 }
            r1.close()     // Catch:{ IOException -> 0x0018 }
        L_0x0018:
            return r0
        L_0x0019:
            r3 = move-exception
            r0 = r1
            goto L_0x004a
        L_0x001c:
            r3 = move-exception
            r0 = r1
            goto L_0x0027
        L_0x001f:
            r3 = move-exception
            goto L_0x0022
        L_0x0021:
            r3 = move-exception
        L_0x0022:
            r0 = r1
            goto L_0x003a
        L_0x0024:
            r3 = move-exception
            goto L_0x004a
        L_0x0026:
            r3 = move-exception
        L_0x0027:
            com.evernote.android.job.patched.internal.util.JobCat r1 = com.evernote.android.job.patched.internal.util.support.PersistableBundleCompat.b     // Catch:{ all -> 0x0024 }
            r1.e(r3)     // Catch:{ all -> 0x0024 }
            com.evernote.android.job.patched.internal.util.support.PersistableBundleCompat r3 = new com.evernote.android.job.patched.internal.util.support.PersistableBundleCompat     // Catch:{ all -> 0x0024 }
            r3.<init>()     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0036
            r0.close()     // Catch:{ IOException -> 0x0036 }
        L_0x0036:
            return r3
        L_0x0037:
            r3 = move-exception
            goto L_0x003a
        L_0x0039:
            r3 = move-exception
        L_0x003a:
            com.evernote.android.job.patched.internal.util.JobCat r1 = com.evernote.android.job.patched.internal.util.support.PersistableBundleCompat.b
            r1.e(r3)
            com.evernote.android.job.patched.internal.util.support.PersistableBundleCompat r3 = new com.evernote.android.job.patched.internal.util.support.PersistableBundleCompat
            r3.<init>()
            if (r0 == 0) goto L_0x0049
            r0.close()     // Catch:{ IOException -> 0x0049 }
        L_0x0049:
            return r3
        L_0x004a:
            if (r0 == 0) goto L_0x004f
            r0.close()     // Catch:{ IOException -> 0x004f }
        L_0x004f:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.evernote.android.job.patched.internal.util.support.PersistableBundleCompat.fromXml(java.lang.String):com.evernote.android.job.patched.internal.util.support.PersistableBundleCompat");
    }

    public void clear() {
        this.a.clear();
    }

    public boolean containsKey(String str) {
        return this.a.containsKey(str);
    }

    public Object get(String str) {
        return this.a.get(str);
    }

    public boolean getBoolean(String str, boolean z) {
        Object obj = this.a.get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
    }

    public double getDouble(String str, double d) {
        Object obj = this.a.get(str);
        return obj instanceof Double ? ((Double) obj).doubleValue() : d;
    }

    public double[] getDoubleArray(String str) {
        Object obj = this.a.get(str);
        if (obj instanceof double[]) {
            return (double[]) obj;
        }
        return null;
    }

    public int getInt(String str, int i) {
        Object obj = this.a.get(str);
        return obj instanceof Integer ? ((Integer) obj).intValue() : i;
    }

    public int[] getIntArray(String str) {
        Object obj = this.a.get(str);
        if (obj instanceof int[]) {
            return (int[]) obj;
        }
        return null;
    }

    public long getLong(String str, long j) {
        Object obj = this.a.get(str);
        return obj instanceof Long ? ((Long) obj).longValue() : j;
    }

    public long[] getLongArray(String str) {
        Object obj = this.a.get(str);
        if (obj instanceof long[]) {
            return (long[]) obj;
        }
        return null;
    }

    public PersistableBundleCompat getPersistableBundleCompat(String str) {
        Object obj = this.a.get(str);
        if (obj instanceof Map) {
            return new PersistableBundleCompat((Map) obj);
        }
        return null;
    }

    public String getString(String str, String str2) {
        Object obj = this.a.get(str);
        return obj instanceof String ? (String) obj : str2;
    }

    public String[] getStringArray(String str) {
        Object obj = this.a.get(str);
        if (obj instanceof String[]) {
            return (String[]) obj;
        }
        return null;
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public Set<String> keySet() {
        return this.a.keySet();
    }

    public void putAll(PersistableBundleCompat persistableBundleCompat) {
        this.a.putAll(persistableBundleCompat.a);
    }

    public void putBoolean(String str, boolean z) {
        this.a.put(str, Boolean.valueOf(z));
    }

    public void putDouble(String str, double d) {
        this.a.put(str, Double.valueOf(d));
    }

    public void putDoubleArray(String str, double[] dArr) {
        this.a.put(str, dArr);
    }

    public void putInt(String str, int i) {
        this.a.put(str, Integer.valueOf(i));
    }

    public void putIntArray(String str, int[] iArr) {
        this.a.put(str, iArr);
    }

    public void putLong(String str, long j) {
        this.a.put(str, Long.valueOf(j));
    }

    public void putLongArray(String str, long[] jArr) {
        this.a.put(str, jArr);
    }

    public void putPersistableBundleCompat(String str, PersistableBundleCompat persistableBundleCompat) {
        this.a.put(str, persistableBundleCompat == null ? null : persistableBundleCompat.a);
    }

    public void putString(String str, String str2) {
        this.a.put(str, str2);
    }

    public void putStringArray(String str, String[] strArr) {
        this.a.put(str, strArr);
    }

    public void remove(String str) {
        this.a.remove(str);
    }

    @NonNull
    public String saveToXml() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            AppCompatDelegateImpl.i.q2(this.a, byteArrayOutputStream);
            String byteArrayOutputStream2 = byteArrayOutputStream.toString("UTF-8");
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
            }
            return byteArrayOutputStream2;
        } catch (IOException | XmlPullParserException e) {
            b.e(e);
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused2) {
            }
            return "";
        } catch (Error e2) {
            b.e(e2);
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused3) {
            }
            return "";
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused4) {
            }
            throw th;
        }
    }

    public int size() {
        return this.a.size();
    }

    public PersistableBundleCompat(PersistableBundleCompat persistableBundleCompat) {
        this.a = new HashMap(persistableBundleCompat.a);
    }

    public PersistableBundleCompat(Map<String, Object> map) {
        this.a = map;
    }
}
