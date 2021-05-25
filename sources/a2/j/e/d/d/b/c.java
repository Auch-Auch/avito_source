package a2.j.e.d.d.b;

import com.avito.android.BuildConfig;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.log.QueueFile;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;
public class c implements a {
    public static final Charset d = Charset.forName("UTF-8");
    public final File a;
    public final int b;
    public QueueFile c;

    public class a {
        public final byte[] a;
        public final int b;

        public a(c cVar, byte[] bArr, int i) {
            this.a = bArr;
            this.b = i;
        }
    }

    public c(File file, int i) {
        this.a = file;
        this.b = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003e  */
    @Override // a2.j.e.d.d.b.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] a() {
        /*
            r7 = this;
            java.io.File r0 = r7.a
            boolean r0 = r0.exists()
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            r4 = r1
            goto L_0x003b
        L_0x000c:
            r7.f()
            com.google.firebase.crashlytics.internal.log.QueueFile r0 = r7.c
            if (r0 != 0) goto L_0x0014
            goto L_0x000a
        L_0x0014:
            r3 = 1
            int[] r3 = new int[r3]
            r3[r2] = r2
            int r0 = r0.l()
            byte[] r0 = new byte[r0]
            com.google.firebase.crashlytics.internal.log.QueueFile r4 = r7.c     // Catch:{ IOException -> 0x002a }
            a2.j.e.d.d.b.b r5 = new a2.j.e.d.d.b.b     // Catch:{ IOException -> 0x002a }
            r5.<init>(r7, r0, r3)     // Catch:{ IOException -> 0x002a }
            r4.e(r5)     // Catch:{ IOException -> 0x002a }
            goto L_0x0034
        L_0x002a:
            r4 = move-exception
            com.google.firebase.crashlytics.internal.Logger r5 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.String r6 = "A problem occurred while reading the Crashlytics log file."
            r5.e(r6, r4)
        L_0x0034:
            a2.j.e.d.d.b.c$a r4 = new a2.j.e.d.d.b.c$a
            r3 = r3[r2]
            r4.<init>(r7, r0, r3)
        L_0x003b:
            if (r4 != 0) goto L_0x003e
            return r1
        L_0x003e:
            int r0 = r4.b
            byte[] r1 = new byte[r0]
            byte[] r3 = r4.a
            java.lang.System.arraycopy(r3, r2, r1, r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.e.d.d.b.c.a():byte[]");
    }

    @Override // a2.j.e.d.d.b.a
    public void b() {
        CommonUtils.closeOrLog(this.c, "There was a problem closing the Crashlytics log file.");
        this.c = null;
        this.a.delete();
    }

    @Override // a2.j.e.d.d.b.a
    public void c(long j, String str) {
        f();
        if (this.c != null) {
            if (str == null) {
                str = BuildConfig.ADJUST_DEFAULT_TRACKER;
            }
            try {
                int i = this.b / 4;
                if (str.length() > i) {
                    str = "..." + str.substring(str.length() - i);
                }
                this.c.b(String.format(Locale.US, "%d %s%n", Long.valueOf(j), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(d));
                while (!this.c.f() && this.c.l() > this.b) {
                    this.c.i();
                }
            } catch (IOException e) {
                Logger.getLogger().e("There was a problem writing to the Crashlytics log.", e);
            }
        }
    }

    @Override // a2.j.e.d.d.b.a
    public void d() {
        CommonUtils.closeOrLog(this.c, "There was a problem closing the Crashlytics log file.");
        this.c = null;
    }

    @Override // a2.j.e.d.d.b.a
    public String e() {
        byte[] a3 = a();
        if (a3 != null) {
            return new String(a3, d);
        }
        return null;
    }

    public final void f() {
        if (this.c == null) {
            try {
                this.c = new QueueFile(this.a);
            } catch (IOException e) {
                Logger logger = Logger.getLogger();
                StringBuilder L = a2.b.a.a.a.L("Could not open log file: ");
                L.append(this.a);
                logger.e(L.toString(), e);
            }
        }
    }
}
