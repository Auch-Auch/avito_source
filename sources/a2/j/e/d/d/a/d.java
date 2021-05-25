package a2.j.e.d.d.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
public class d implements n0 {
    @Nullable
    public final byte[] a;
    @NonNull
    public final String b;
    @NonNull
    public final String c;

    public d(@NonNull String str, @NonNull String str2, @Nullable byte[] bArr) {
        this.b = str;
        this.c = str2;
        this.a = bArr;
    }

    @Override // a2.j.e.d.d.a.n0
    @NonNull
    public String a() {
        return this.c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @Override // a2.j.e.d.d.a.n0
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File b() {
        /*
            r4 = this;
            byte[] r0 = r4.a
            if (r0 == 0) goto L_0x000a
            int r0 = r0.length
            if (r0 != 0) goto L_0x0008
            goto L_0x000a
        L_0x0008:
            r0 = 0
            goto L_0x000b
        L_0x000a:
            r0 = 1
        L_0x000b:
            r1 = 0
            if (r0 == 0) goto L_0x0010
        L_0x000e:
            r3 = r1
            goto L_0x0037
        L_0x0010:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x000e }
            r0.<init>()     // Catch:{ IOException -> 0x000e }
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x0032 }
            r2.<init>(r0)     // Catch:{ all -> 0x0032 }
            byte[] r3 = r4.a     // Catch:{ all -> 0x002d }
            r2.write(r3)     // Catch:{ all -> 0x002d }
            r2.finish()     // Catch:{ all -> 0x002d }
            byte[] r3 = r0.toByteArray()     // Catch:{ all -> 0x002d }
            r2.close()
            r0.close()
            goto L_0x0037
        L_0x002d:
            r3 = move-exception
            r2.close()     // Catch:{ all -> 0x0031 }
        L_0x0031:
            throw r3
        L_0x0032:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x0036 }
        L_0x0036:
            throw r2
        L_0x0037:
            if (r3 != 0) goto L_0x003a
            goto L_0x004c
        L_0x003a:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File$Builder r0 = com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.builder()
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File$Builder r0 = r0.setContents(r3)
            java.lang.String r1 = r4.b
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File$Builder r0 = r0.setFilename(r1)
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File r1 = r0.build()
        L_0x004c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.e.d.d.a.d.b():com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File");
    }

    @Override // a2.j.e.d.d.a.n0
    @Nullable
    public InputStream getStream() {
        byte[] bArr = this.a;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return new ByteArrayInputStream(this.a);
    }
}
