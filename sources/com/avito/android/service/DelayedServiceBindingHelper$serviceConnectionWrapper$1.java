package com.avito.android.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/avito/android/service/DelayedServiceBindingHelper$serviceConnectionWrapper$1", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "name", "", "onServiceDisconnected", "(Landroid/content/ComponentName;)V", "Landroid/os/IBinder;", NotificationCompat.CATEGORY_SERVICE, "onServiceConnected", "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class DelayedServiceBindingHelper$serviceConnectionWrapper$1 implements ServiceConnection {
    public final /* synthetic */ DelayedServiceBindingHelper a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public DelayedServiceBindingHelper$serviceConnectionWrapper$1(DelayedServiceBindingHelper delayedServiceBindingHelper) {
        this.a = delayedServiceBindingHelper;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(@Nullable ComponentName componentName, @Nullable IBinder iBinder) {
        ServiceConnection access$getServiceConnection$p = DelayedServiceBindingHelper.access$getServiceConnection$p(this.a);
        if (access$getServiceConnection$p != null) {
            access$getServiceConnection$p.onServiceConnected(componentName, iBinder);
        }
        DelayedServiceBindingHelper.access$getOnConnected$p(this.a).invoke(componentName, iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(@Nullable ComponentName componentName) {
        ServiceConnection access$getServiceConnection$p = DelayedServiceBindingHelper.access$getServiceConnection$p(this.a);
        if (access$getServiceConnection$p != null) {
            access$getServiceConnection$p.onServiceDisconnected(componentName);
        }
        DelayedServiceBindingHelper.access$getOnDisconnected$p(this.a).invoke(componentName);
    }
}
