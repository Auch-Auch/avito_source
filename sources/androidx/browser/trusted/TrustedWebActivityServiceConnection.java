package androidx.browser.trusted;

import a2.b.a.a.a;
import android.app.Notification;
import android.content.ComponentName;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.customtabs.trusted.ITrustedWebActivityService;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
public final class TrustedWebActivityServiceConnection {
    public final ITrustedWebActivityService a;
    public final ComponentName b;

    public TrustedWebActivityServiceConnection(@NonNull ITrustedWebActivityService iTrustedWebActivityService, @NonNull ComponentName componentName) {
        this.a = iTrustedWebActivityService;
        this.b = componentName;
    }

    public static void a(Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            throw new IllegalArgumentException(a.c3("Bundle must contain ", str));
        }
    }

    public boolean areNotificationsEnabled(@NonNull String str) throws RemoteException {
        Bundle areNotificationsEnabled = this.a.areNotificationsEnabled(a.y1("android.support.customtabs.trusted.CHANNEL_NAME", str));
        a(areNotificationsEnabled, "android.support.customtabs.trusted.NOTIFICATION_SUCCESS");
        return areNotificationsEnabled.getBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS");
    }

    public void cancel(@NonNull String str, int i) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("android.support.customtabs.trusted.PLATFORM_TAG", str);
        bundle.putInt("android.support.customtabs.trusted.PLATFORM_ID", i);
        this.a.cancelNotification(bundle);
    }

    @NonNull
    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Parcelable[] getActiveNotifications() throws RemoteException {
        Bundle activeNotifications = this.a.getActiveNotifications();
        a(activeNotifications, "android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS");
        return activeNotifications.getParcelableArray("android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS");
    }

    @NonNull
    public ComponentName getComponentName() {
        return this.b;
    }

    @Nullable
    public Bitmap getSmallIconBitmap() throws RemoteException {
        return (Bitmap) this.a.getSmallIconBitmap().getParcelable(TrustedWebActivityService.KEY_SMALL_ICON_BITMAP);
    }

    public int getSmallIconId() throws RemoteException {
        return this.a.getSmallIconId();
    }

    public boolean notify(@NonNull String str, int i, @NonNull Notification notification, @NonNull String str2) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("android.support.customtabs.trusted.PLATFORM_TAG", str);
        bundle.putInt("android.support.customtabs.trusted.PLATFORM_ID", i);
        bundle.putParcelable("android.support.customtabs.trusted.NOTIFICATION", notification);
        bundle.putString("android.support.customtabs.trusted.CHANNEL_NAME", str2);
        Bundle notifyNotificationWithChannel = this.a.notifyNotificationWithChannel(bundle);
        a(notifyNotificationWithChannel, "android.support.customtabs.trusted.NOTIFICATION_SUCCESS");
        return notifyNotificationWithChannel.getBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS");
    }
}
