package a2.g.k;

import a2.g.k.a;
import com.facebook.appevents.AppEvent;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
@AutoHandleExceptions
public class l {
    public static final /* synthetic */ int a = 0;

    public static class a extends ObjectInputStream {
        public a(InputStream inputStream) throws IOException {
            super(inputStream);
        }

        @Override // java.io.ObjectInputStream
        public ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
            ObjectStreamClass readClassDescriptor = super.readClassDescriptor();
            if (readClassDescriptor.getName().equals("com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1")) {
                return ObjectStreamClass.lookup(a.b.class);
            }
            return readClassDescriptor.getName().equals("com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1") ? ObjectStreamClass.lookup(AppEvent.b.class) : readClassDescriptor;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized a2.g.k.s a() {
        /*
            java.lang.Class<a2.g.k.l> r0 = a2.g.k.l.class
            monitor-enter(r0)
            com.facebook.appevents.internal.AppEventUtility.assertIsNotMainThread()     // Catch:{ all -> 0x0065 }
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x0065 }
            r2 = 0
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.FileInputStream r3 = r1.openFileInput(r3)     // Catch:{ FileNotFoundException -> 0x0051, Exception -> 0x0041, all -> 0x0031 }
            a2.g.k.l$a r4 = new a2.g.k.l$a     // Catch:{ FileNotFoundException -> 0x0051, Exception -> 0x0041, all -> 0x0031 }
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x0051, Exception -> 0x0041, all -> 0x0031 }
            r5.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0051, Exception -> 0x0041, all -> 0x0031 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0051, Exception -> 0x0041, all -> 0x0031 }
            java.lang.Object r3 = r4.readObject()     // Catch:{ FileNotFoundException -> 0x0052, Exception -> 0x0042, all -> 0x002f }
            a2.g.k.s r3 = (a2.g.k.s) r3     // Catch:{ FileNotFoundException -> 0x0052, Exception -> 0x0042, all -> 0x002f }
            com.facebook.internal.Utility.closeQuietly(r4)
            java.lang.String r2 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r2)     // Catch:{ Exception -> 0x002d }
            r1.delete()     // Catch:{ Exception -> 0x002d }
        L_0x002d:
            r2 = r3
            goto L_0x005c
        L_0x002f:
            r2 = move-exception
            goto L_0x0034
        L_0x0031:
            r3 = move-exception
            r4 = r2
            r2 = r3
        L_0x0034:
            com.facebook.internal.Utility.closeQuietly(r4)
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x0040 }
            r1.delete()     // Catch:{ Exception -> 0x0040 }
        L_0x0040:
            throw r2
        L_0x0041:
            r4 = r2
        L_0x0042:
            com.facebook.internal.Utility.closeQuietly(r4)
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x004f }
        L_0x004b:
            r1.delete()     // Catch:{ Exception -> 0x004f }
            goto L_0x005c
        L_0x004f:
            goto L_0x005c
        L_0x0051:
            r4 = r2
        L_0x0052:
            com.facebook.internal.Utility.closeQuietly(r4)
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)
            goto L_0x004b
        L_0x005c:
            if (r2 != 0) goto L_0x0063
            a2.g.k.s r2 = new a2.g.k.s
            r2.<init>()
        L_0x0063:
            monitor-exit(r0)
            return r2
        L_0x0065:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.g.k.l.a():a2.g.k.s");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        r6 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0021 A[ExcHandler: all (th java.lang.Throwable), PHI: r2 
      PHI: (r2v2 java.io.ObjectOutputStream) = (r2v0 java.io.ObjectOutputStream), (r2v1 java.io.ObjectOutputStream), (r2v1 java.io.ObjectOutputStream), (r2v0 java.io.ObjectOutputStream) binds: [B:1:0x0007, B:10:0x0023, B:12:?, B:2:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x0007] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(a2.g.k.s r6) {
        /*
            java.lang.String r0 = "AppEventsLogger.persistedevents"
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()
            r2 = 0
            java.io.ObjectOutputStream r3 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x0023, all -> 0x0021 }
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0023, all -> 0x0021 }
            r5 = 0
            java.io.FileOutputStream r5 = r1.openFileOutput(r0, r5)     // Catch:{ Exception -> 0x0023, all -> 0x0021 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0023, all -> 0x0021 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0023, all -> 0x0021 }
            r3.writeObject(r6)     // Catch:{ Exception -> 0x001f, all -> 0x001d }
            com.facebook.internal.Utility.closeQuietly(r3)
            goto L_0x0033
        L_0x001d:
            r6 = move-exception
            goto L_0x002c
        L_0x001f:
            r2 = r3
            goto L_0x0023
        L_0x0021:
            r6 = move-exception
            goto L_0x002b
        L_0x0023:
            java.io.File r6 = r1.getFileStreamPath(r0)     // Catch:{ Exception -> 0x0030, all -> 0x0021 }
            r6.delete()     // Catch:{ Exception -> 0x0030, all -> 0x0021 }
            goto L_0x0030
        L_0x002b:
            r3 = r2
        L_0x002c:
            com.facebook.internal.Utility.closeQuietly(r3)
            throw r6
        L_0x0030:
            com.facebook.internal.Utility.closeQuietly(r2)
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.g.k.l.b(a2.g.k.s):void");
    }
}
