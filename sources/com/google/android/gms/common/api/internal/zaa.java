package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
public final class zaa extends ActivityLifecycleObserver {
    private final WeakReference<C0188zaa> zaa;

    @VisibleForTesting(otherwise = 2)
    /* renamed from: com.google.android.gms.common.api.internal.zaa$zaa  reason: collision with other inner class name */
    public static class C0188zaa extends LifecycleCallback {
        private List<Runnable> zaa = new ArrayList();

        private C0188zaa(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final synchronized void zaa(Runnable runnable) {
            this.zaa.add(runnable);
        }

        /* access modifiers changed from: private */
        public static C0188zaa zab(Activity activity) {
            C0188zaa zaa2;
            synchronized (activity) {
                LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
                zaa2 = (C0188zaa) fragment.getCallbackOrNull("LifecycleObserverOnStop", C0188zaa.class);
                if (zaa2 == null) {
                    zaa2 = new C0188zaa(fragment);
                }
            }
            return zaa2;
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        @MainThread
        public void onStop() {
            List<Runnable> list;
            synchronized (this) {
                list = this.zaa;
                this.zaa = new ArrayList();
            }
            for (Runnable runnable : list) {
                runnable.run();
            }
        }
    }

    public zaa(Activity activity) {
        this(C0188zaa.zab(activity));
    }

    @Override // com.google.android.gms.common.api.internal.ActivityLifecycleObserver
    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        C0188zaa zaa2 = this.zaa.get();
        if (zaa2 != null) {
            zaa2.zaa(runnable);
            return this;
        }
        throw new IllegalStateException("The target activity has already been GC'd");
    }

    @VisibleForTesting(otherwise = 2)
    private zaa(C0188zaa zaa2) {
        this.zaa = new WeakReference<>(zaa2);
    }
}
