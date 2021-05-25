package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class StartWorkRunnable implements Runnable {
    public WorkManagerImpl a;
    public String b;
    public WorkerParameters.RuntimeExtras c;

    public StartWorkRunnable(WorkManagerImpl workManagerImpl, String str, WorkerParameters.RuntimeExtras runtimeExtras) {
        this.a = workManagerImpl;
        this.b = str;
        this.c = runtimeExtras;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.getProcessor().startWork(this.b, this.c);
    }
}
