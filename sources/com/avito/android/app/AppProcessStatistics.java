package com.avito.android.app;

import android.os.Process;
import android.os.SystemClock;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.WorkerThread;
import com.avito.android.remote.auth.AuthSource;
import com.jaredrummler.android.processes.AndroidProcesses;
import com.jaredrummler.android.processes.models.AndroidAppProcess;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/app/AppProcessStatistics;", "", "", "startupRealMs", "()J", "startupElapsedMs", AuthSource.SEND_ABUSE, "J", "appStartupElapsedMs", "<init>", "(J)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
public final class AppProcessStatistics {
    public final long a;

    public AppProcessStatistics(long j) {
        this.a = j;
    }

    @WorkerThread
    public final long startupElapsedMs() {
        boolean z;
        T t;
        boolean z2;
        try {
            long j = this.a;
            int myPid = Process.myPid();
            List<AndroidAppProcess> runningAppProcesses = AndroidProcesses.getRunningAppProcesses();
            Intrinsics.checkNotNullExpressionValue(runningAppProcesses, "AndroidProcesses.getRunningAppProcesses()");
            Iterator<T> it = runningAppProcesses.iterator();
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (t.pid == myPid) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    break;
                }
            }
            T t2 = t;
            if (t2 != null) {
                j = (long) ((1000.0f / ((float) Os.sysconf(OsConstants._SC_CLK_TCK))) * ((float) t2.stat().starttime()));
            }
            if (Math.abs(this.a - j) >= ((long) 1000)) {
                z = false;
            }
            if (z) {
                return j;
            }
            return this.a;
        } catch (Exception unused) {
            return this.a;
        }
    }

    @WorkerThread
    public final long startupRealMs() {
        return startupElapsedMs() + (System.currentTimeMillis() - SystemClock.elapsedRealtime());
    }
}
