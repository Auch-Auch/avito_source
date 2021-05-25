package com.avito.android.app;

import android.app.Activity;
import com.avito.android.remote.auth.AuthSource;
import java.lang.ref.WeakReference;
import javax.inject.Provider;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/app/ActivityProvider;", "Ljavax/inject/Provider;", "Landroid/app/Activity;", "get", "()Landroid/app/Activity;", "activity", "", "set", "(Landroid/app/Activity;)V", "Ljava/lang/ref/WeakReference;", AuthSource.SEND_ABUSE, "Ljava/lang/ref/WeakReference;", "activityReference", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
public class ActivityProvider implements Provider<Activity> {
    public WeakReference<Activity> a;

    public final void set(@Nullable Activity activity) {
        this.a = activity == null ? null : new WeakReference<>(activity);
    }

    @Override // javax.inject.Provider
    @Nullable
    public Activity get() {
        WeakReference<Activity> weakReference = this.a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
