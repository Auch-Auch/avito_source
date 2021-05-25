package a2.j.e.d.d.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
public class j0 implements n0 {
    @NonNull
    public final File a;
    @NonNull
    public final String b;
    @NonNull
    public final String c;

    public j0(@NonNull String str, @NonNull String str2, @NonNull File file) {
        this.b = str;
        this.c = str2;
        this.a = file;
    }

    @Override // a2.j.e.d.d.a.n0
    @NonNull
    public String a() {
        return this.c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    @Override // a2.j.e.d.d.a.n0
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File b() {
        /*
            r7 = this;
            r0 = 8192(0x2000, float:1.14794E-41)
            byte[] r0 = new byte[r0]
            r1 = 0
            java.io.InputStream r2 = r7.getStream()     // Catch:{ IOException -> 0x004e }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0047 }
            r3.<init>()     // Catch:{ all -> 0x0047 }
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x0042 }
            r4.<init>(r3)     // Catch:{ all -> 0x0042 }
            if (r2 != 0) goto L_0x0021
            r4.close()     // Catch:{ all -> 0x0042 }
            r3.close()
            if (r2 == 0) goto L_0x004e
            r2.close()
            goto L_0x004e
        L_0x0021:
            int r5 = r2.read(r0)     // Catch:{ all -> 0x003d }
            if (r5 <= 0) goto L_0x002c
            r6 = 0
            r4.write(r0, r6, r5)     // Catch:{ all -> 0x003d }
            goto L_0x0021
        L_0x002c:
            r4.finish()     // Catch:{ all -> 0x003d }
            byte[] r0 = r3.toByteArray()     // Catch:{ all -> 0x003d }
            r4.close()
            r3.close()
            r2.close()
            goto L_0x004f
        L_0x003d:
            r0 = move-exception
            r4.close()     // Catch:{ all -> 0x0041 }
        L_0x0041:
            throw r0
        L_0x0042:
            r0 = move-exception
            r3.close()     // Catch:{ all -> 0x0046 }
        L_0x0046:
            throw r0
        L_0x0047:
            r0 = move-exception
            if (r2 == 0) goto L_0x004d
            r2.close()     // Catch:{ all -> 0x004d }
        L_0x004d:
            throw r0
        L_0x004e:
            r0 = r1
        L_0x004f:
            if (r0 == 0) goto L_0x0063
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File$Builder r1 = com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.builder()
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File$Builder r0 = r1.setContents(r0)
            java.lang.String r1 = r7.b
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File$Builder r0 = r0.setFilename(r1)
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File r1 = r0.build()
        L_0x0063:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.e.d.d.a.j0.b():com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File");
    }

    @Override // a2.j.e.d.d.a.n0
    @Nullable
    public InputStream getStream() {
        if (this.a.exists() && this.a.isFile()) {
            try {
                return new FileInputStream(this.a);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }
}
