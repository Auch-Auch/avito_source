package l6.h.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class a extends c {
    public static Class<?> b = null;
    public static Constructor<?> c = null;
    public static Method d = null;
    public static Method e = null;
    public static boolean f = false;

    public static boolean b(Object obj, String str, int i, boolean z) {
        c();
        try {
            return ((Boolean) d.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void c() {
        Method method;
        Class<?> cls;
        Method method2;
        if (!f) {
            f = true;
            Constructor<?> constructor = null;
            try {
                cls = Class.forName("android.graphics.FontFamily");
                Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
                method = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
                method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
                constructor = constructor2;
            } catch (ClassNotFoundException | NoSuchMethodException e2) {
                e2.getClass().getName();
                method2 = null;
                cls = null;
                method = null;
            }
            c = constructor;
            b = cls;
            d = method;
            e = method2;
        }
    }

    @Override // l6.h.c.c
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        c();
        try {
            Object newInstance = c.newInstance(new Object[0]);
            FontResourcesParserCompat.FontFileResourceEntry[] entries = fontFamilyFilesResourceEntry.getEntries();
            for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : entries) {
                File tempFile = TypefaceCompatUtil.getTempFile(context);
                if (tempFile == null) {
                    return null;
                }
                try {
                    if (!TypefaceCompatUtil.copyToFile(tempFile, resources, fontFileResourceEntry.getResourceId())) {
                        tempFile.delete();
                        return null;
                    } else if (!b(newInstance, tempFile.getPath(), fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic())) {
                        return null;
                    } else {
                        tempFile.delete();
                    }
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    tempFile.delete();
                }
            }
            c();
            try {
                Object newInstance2 = Array.newInstance(b, 1);
                Array.set(newInstance2, 0, newInstance);
                return (Typeface) e.invoke(null, newInstance2);
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050 A[SYNTHETIC, Splitter:B:18:0x0050] */
    @Override // l6.h.c.c
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Typeface createFromFontInfo(android.content.Context r4, android.os.CancellationSignal r5, @androidx.annotation.NonNull androidx.core.provider.FontsContractCompat.FontInfo[] r6, int r7) {
        /*
            r3 = this;
            int r0 = r6.length
            r1 = 0
            r2 = 1
            if (r0 >= r2) goto L_0x0006
            return r1
        L_0x0006:
            androidx.core.provider.FontsContractCompat$FontInfo r6 = r3.findBestInfo(r6, r7)
            android.content.ContentResolver r7 = r4.getContentResolver()
            android.net.Uri r6 = r6.getUri()     // Catch:{ IOException -> 0x0086 }
            java.lang.String r0 = "r"
            android.os.ParcelFileDescriptor r5 = r7.openFileDescriptor(r6, r0, r5)     // Catch:{ IOException -> 0x0086 }
            if (r5 != 0) goto L_0x0020
            if (r5 == 0) goto L_0x001f
            r5.close()     // Catch:{ IOException -> 0x0086 }
        L_0x001f:
            return r1
        L_0x0020:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ ErrnoException -> 0x004d }
            r6.<init>()     // Catch:{ ErrnoException -> 0x004d }
            java.lang.String r7 = "/proc/self/fd/"
            r6.append(r7)     // Catch:{ ErrnoException -> 0x004d }
            int r7 = r5.getFd()     // Catch:{ ErrnoException -> 0x004d }
            r6.append(r7)     // Catch:{ ErrnoException -> 0x004d }
            java.lang.String r6 = r6.toString()     // Catch:{ ErrnoException -> 0x004d }
            java.lang.String r6 = android.system.Os.readlink(r6)     // Catch:{ ErrnoException -> 0x004d }
            android.system.StructStat r7 = android.system.Os.stat(r6)     // Catch:{ ErrnoException -> 0x004d }
            int r7 = r7.st_mode     // Catch:{ ErrnoException -> 0x004d }
            boolean r7 = android.system.OsConstants.S_ISREG(r7)     // Catch:{ ErrnoException -> 0x004d }
            if (r7 == 0) goto L_0x004d
            java.io.File r7 = new java.io.File     // Catch:{ ErrnoException -> 0x004d }
            r7.<init>(r6)     // Catch:{ ErrnoException -> 0x004d }
            goto L_0x004e
        L_0x004b:
            r4 = move-exception
            goto L_0x007d
        L_0x004d:
            r7 = r1
        L_0x004e:
            if (r7 == 0) goto L_0x005f
            boolean r6 = r7.canRead()     // Catch:{ all -> 0x004b }
            if (r6 != 0) goto L_0x0057
            goto L_0x005f
        L_0x0057:
            android.graphics.Typeface r4 = android.graphics.Typeface.createFromFile(r7)     // Catch:{ all -> 0x004b }
            r5.close()
            return r4
        L_0x005f:
            java.io.FileInputStream r6 = new java.io.FileInputStream
            java.io.FileDescriptor r7 = r5.getFileDescriptor()
            r6.<init>(r7)
            android.graphics.Typeface r4 = super.createFromInputStream(r4, r6)     // Catch:{ all -> 0x0073 }
            r6.close()
            r5.close()
            return r4
        L_0x0073:
            r4 = move-exception
            r6.close()     // Catch:{ all -> 0x0078 }
            goto L_0x007c
        L_0x0078:
            r6 = move-exception
            r4.addSuppressed(r6)
        L_0x007c:
            throw r4
        L_0x007d:
            r5.close()     // Catch:{ all -> 0x0081 }
            goto L_0x0085
        L_0x0081:
            r5 = move-exception
            r4.addSuppressed(r5)
        L_0x0085:
            throw r4
        L_0x0086:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l6.h.c.a.createFromFontInfo(android.content.Context, android.os.CancellationSignal, androidx.core.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }
}
