package androidx.browser.trusted;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.customtabs.trusted.ITrustedWebActivityService;
import androidx.annotation.BinderThread;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.app.NotificationManagerCompat;
import java.util.Locale;
public abstract class TrustedWebActivityService extends Service {
    @SuppressLint({"ActionValue", "ServiceName"})
    public static final String ACTION_TRUSTED_WEB_ACTIVITY_SERVICE = "android.support.customtabs.trusted.TRUSTED_WEB_ACTIVITY_SERVICE";
    public static final String KEY_SMALL_ICON_BITMAP = "android.support.customtabs.trusted.SMALL_ICON_BITMAP";
    public static final String META_DATA_NAME_SMALL_ICON = "android.support.customtabs.trusted.SMALL_ICON";
    public static final int SMALL_ICON_NOT_SET = -1;
    public NotificationManager a;
    public int b = -1;
    public final ITrustedWebActivityService.Stub c = new a();

    public class a extends ITrustedWebActivityService.Stub {
        public a() {
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle areNotificationsEnabled(Bundle bundle) {
            c();
            TrustedWebActivityServiceConnection.a(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            boolean onAreNotificationsEnabled = TrustedWebActivityService.this.onAreNotificationsEnabled(bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", onAreNotificationsEnabled);
            return bundle2;
        }

        public final void c() {
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            if (trustedWebActivityService.b == -1) {
                String[] packagesForUid = trustedWebActivityService.getPackageManager().getPackagesForUid(Binder.getCallingUid());
                int i = 0;
                if (packagesForUid == null) {
                    packagesForUid = new String[0];
                }
                Token load = TrustedWebActivityService.this.getTokenStore().load();
                PackageManager packageManager = TrustedWebActivityService.this.getPackageManager();
                if (load != null) {
                    int length = packagesForUid.length;
                    while (true) {
                        if (i >= length) {
                            break;
                        } else if (load.matches(packagesForUid[i], packageManager)) {
                            TrustedWebActivityService.this.b = Binder.getCallingUid();
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            if (TrustedWebActivityService.this.b != Binder.getCallingUid()) {
                throw new SecurityException("Caller is not verified as Trusted Web Activity provider.");
            }
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public void cancelNotification(Bundle bundle) {
            c();
            TrustedWebActivityServiceConnection.a(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            TrustedWebActivityServiceConnection.a(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            TrustedWebActivityService.this.onCancelNotification(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"));
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle getActiveNotifications() {
            c();
            Parcelable[] onGetActiveNotifications = TrustedWebActivityService.this.onGetActiveNotifications();
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS", onGetActiveNotifications);
            return bundle;
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle getSmallIconBitmap() {
            c();
            return TrustedWebActivityService.this.onGetSmallIconBitmap();
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public int getSmallIconId() {
            c();
            return TrustedWebActivityService.this.onGetSmallIconId();
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle notifyNotificationWithChannel(Bundle bundle) {
            c();
            TrustedWebActivityServiceConnection.a(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            TrustedWebActivityServiceConnection.a(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            TrustedWebActivityServiceConnection.a(bundle, "android.support.customtabs.trusted.NOTIFICATION");
            TrustedWebActivityServiceConnection.a(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            String string = bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME");
            boolean onNotifyNotificationWithChannel = TrustedWebActivityService.this.onNotifyNotificationWithChannel(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"), (Notification) bundle.getParcelable("android.support.customtabs.trusted.NOTIFICATION"), string);
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", onNotifyNotificationWithChannel);
            return bundle2;
        }
    }

    public static String a(String str) {
        return str.toLowerCase(Locale.ROOT).replace(' ', '_') + "_channel_id";
    }

    public final void b() {
        if (this.a == null) {
            throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
        }
    }

    @NonNull
    @BinderThread
    public abstract TokenStore getTokenStore();

    @BinderThread
    public boolean onAreNotificationsEnabled(@NonNull String str) {
        b();
        if (!NotificationManagerCompat.from(this).areNotificationsEnabled()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        return AppCompatDelegateImpl.i.V0(this.a, a(str));
    }

    @Override // android.app.Service
    @Nullable
    @MainThread
    public final IBinder onBind(@Nullable Intent intent) {
        return this.c;
    }

    @BinderThread
    public void onCancelNotification(@NonNull String str, int i) {
        b();
        this.a.cancel(str, i);
    }

    @Override // android.app.Service
    @CallSuper
    @MainThread
    public void onCreate() {
        super.onCreate();
        this.a = (NotificationManager) getSystemService("notification");
    }

    @NonNull
    @BinderThread
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Parcelable[] onGetActiveNotifications() {
        b();
        if (Build.VERSION.SDK_INT >= 23) {
            return this.a.getActiveNotifications();
        }
        throw new IllegalStateException("onGetActiveNotifications cannot be called pre-M.");
    }

    @NonNull
    @BinderThread
    public Bundle onGetSmallIconBitmap() {
        int onGetSmallIconId = onGetSmallIconId();
        Bundle bundle = new Bundle();
        if (onGetSmallIconId == -1) {
            return bundle;
        }
        bundle.putParcelable(KEY_SMALL_ICON_BITMAP, BitmapFactory.decodeResource(getResources(), onGetSmallIconId));
        return bundle;
    }

    @BinderThread
    public int onGetSmallIconId() {
        try {
            Bundle bundle = getPackageManager().getServiceInfo(new ComponentName(this, getClass()), 128).metaData;
            if (bundle == null) {
                return -1;
            }
            return bundle.getInt(META_DATA_NAME_SMALL_ICON, -1);
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    @BinderThread
    public boolean onNotifyNotificationWithChannel(@NonNull String str, int i, @NonNull Notification notification, @NonNull String str2) {
        b();
        if (!NotificationManagerCompat.from(this).areNotificationsEnabled()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            String a3 = a(str2);
            NotificationManager notificationManager = this.a;
            notificationManager.createNotificationChannel(new NotificationChannel(a3, str2, 3));
            if (notificationManager.getNotificationChannel(a3).getImportance() == 0) {
                notification = null;
            } else {
                Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(this, notification);
                recoverBuilder.setChannelId(a3);
                notification = recoverBuilder.build();
            }
            if (!AppCompatDelegateImpl.i.V0(this.a, a3)) {
                return false;
            }
        }
        this.a.notify(str, i, notification);
        return true;
    }

    @Override // android.app.Service
    @MainThread
    public final boolean onUnbind(@Nullable Intent intent) {
        this.b = -1;
        return super.onUnbind(intent);
    }
}
