package a2.j.e.d.d.a;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.proto.ClsFileOutputStream;
import com.google.firebase.crashlytics.internal.proto.CodedOutputStream;
import java.util.Date;
public class l implements Runnable {
    public final /* synthetic */ Date a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ Thread c;
    public final /* synthetic */ u d;

    public l(u uVar, Date date, Throwable th, Thread thread) {
        this.d = uVar;
        this.a = date;
        this.b = th;
        this.c = thread;
    }

    @Override // java.lang.Runnable
    public void run() {
        ClsFileOutputStream clsFileOutputStream;
        Throwable th;
        Exception e;
        if (!this.d.n()) {
            long time = this.a.getTime() / 1000;
            this.d.t.a(this.b, this.c, "error", time, false);
            u uVar = this.d;
            Thread thread = this.c;
            Throwable th2 = this.b;
            String g = uVar.g();
            if (g == null) {
                Logger.getLogger().d("Tried to write a non-fatal exception while no session was open.");
                return;
            }
            CodedOutputStream codedOutputStream = null;
            try {
                Logger.getLogger().d("Crashlytics is logging non-fatal exception \"" + th2 + "\" from thread " + thread.getName());
                ClsFileOutputStream clsFileOutputStream2 = new ClsFileOutputStream(uVar.j(), g + "SessionEvent" + CommonUtils.padWithZerosToMaxIntWidth(uVar.a.getAndIncrement()));
                try {
                    CodedOutputStream newInstance = CodedOutputStream.newInstance(clsFileOutputStream2);
                    clsFileOutputStream = clsFileOutputStream2;
                    try {
                        uVar.w(newInstance, thread, th2, time, "error", false);
                        CommonUtils.flushOrLog(newInstance, "Failed to flush to non-fatal file.");
                    } catch (Exception e2) {
                        e = e2;
                        codedOutputStream = newInstance;
                        try {
                            Logger.getLogger().e("An error occurred in the non-fatal exception logger", e);
                            CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to non-fatal file.");
                            CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                            uVar.s(g, 64);
                        } catch (Throwable th3) {
                            th = th3;
                            CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to non-fatal file.");
                            CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        codedOutputStream = newInstance;
                        CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to non-fatal file.");
                        CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    clsFileOutputStream = clsFileOutputStream2;
                    Logger.getLogger().e("An error occurred in the non-fatal exception logger", e);
                    CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to non-fatal file.");
                    CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                    uVar.s(g, 64);
                } catch (Throwable th5) {
                    th = th5;
                    clsFileOutputStream = clsFileOutputStream2;
                    CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to non-fatal file.");
                    CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                clsFileOutputStream = null;
                Logger.getLogger().e("An error occurred in the non-fatal exception logger", e);
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to non-fatal file.");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                uVar.s(g, 64);
            } catch (Throwable th6) {
                th = th6;
                clsFileOutputStream = null;
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to non-fatal file.");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                throw th;
            }
            CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
            try {
                uVar.s(g, 64);
            } catch (Exception e5) {
                Logger.getLogger().e("An error occurred when trimming non-fatal files.", e5);
            }
        }
    }
}
