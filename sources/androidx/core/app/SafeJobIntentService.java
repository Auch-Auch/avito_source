package androidx.core.app;

import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.core.app.JobIntentService;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public abstract class SafeJobIntentService extends JobIntentService {
    @Override // androidx.core.app.JobIntentService
    public JobIntentService.e a() {
        try {
            return super.a();
        } catch (SecurityException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // androidx.core.app.JobIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.a = new SafeJobServiceEngineImpl(this);
        } else {
            this.a = null;
        }
    }
}
