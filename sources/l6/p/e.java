package l6.p;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.ReportFragment;
import java.util.concurrent.atomic.AtomicBoolean;
public class e {
    public static AtomicBoolean a = new AtomicBoolean(false);

    @VisibleForTesting
    public static class a extends c {
        @Override // l6.p.c, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            ReportFragment.injectIfNeededIn(activity);
        }

        @Override // l6.p.c, android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // l6.p.c, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }
}
