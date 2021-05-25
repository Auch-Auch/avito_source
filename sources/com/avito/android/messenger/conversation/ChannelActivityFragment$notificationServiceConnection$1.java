package com.avito.android.messenger.conversation;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.notification.NotificationProvider;
import com.avito.android.remote.notification.NotificationService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"com/avito/android/messenger/conversation/ChannelActivityFragment$notificationServiceConnection$1", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "className", "Landroid/os/IBinder;", NotificationCompat.CATEGORY_SERVICE, "", "onServiceConnected", "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", "arg0", "onServiceDisconnected", "(Landroid/content/ComponentName;)V", "onUnbind", "()V", "Lcom/avito/android/remote/notification/NotificationProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/notification/NotificationProvider;", "notificationProvider", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelActivityFragment$notificationServiceConnection$1 implements ServiceConnection {
    public NotificationProvider a;
    public final /* synthetic */ ChannelActivityFragment b;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public ChannelActivityFragment$notificationServiceConnection$1(ChannelActivityFragment channelActivityFragment) {
        this.b = channelActivityFragment;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(@NotNull ComponentName componentName, @NotNull IBinder iBinder) {
        Intrinsics.checkNotNullParameter(componentName, "className");
        Intrinsics.checkNotNullParameter(iBinder, NotificationCompat.CATEGORY_SERVICE);
        NotificationProvider notificationProvider = ((NotificationService.LocalBinder) iBinder).getNotificationProvider();
        this.a = notificationProvider;
        if (notificationProvider != null) {
            notificationProvider.setHandler(this.b);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(@NotNull ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "arg0");
        onUnbind();
    }

    public final void onUnbind() {
        NotificationProvider notificationProvider = this.a;
        if (notificationProvider != null) {
            notificationProvider.setHandler(null);
        }
    }
}
