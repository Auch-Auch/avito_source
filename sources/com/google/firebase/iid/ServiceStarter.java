package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.messaging.Constants;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;
@KeepForSdk
public class ServiceStarter {
    public static final String ACTION_MESSAGING_EVENT = "com.google.firebase.MESSAGING_EVENT";
    @KeepForSdk
    public static final int ERROR_UNKNOWN = 500;
    public static final int SUCCESS = -1;
    public static ServiceStarter e;
    @Nullable
    @GuardedBy("this")
    public String a = null;
    public Boolean b = null;
    public Boolean c = null;
    public final Queue<Intent> d = new ArrayDeque();

    public static PendingIntent createMessagingPendingIntent(Context context, int i, Intent intent, int i2) {
        Intent intent2 = new Intent(context, FirebaseInstanceIdReceiver.class);
        intent2.setAction("com.google.firebase.MESSAGING_EVENT");
        intent2.putExtra(Constants.IntentKeys.WRAPPED_INTENT, intent);
        return PendingIntent.getBroadcast(context, i, intent2, i2);
    }

    @KeepForSdk
    public static synchronized ServiceStarter getInstance() {
        ServiceStarter serviceStarter;
        synchronized (ServiceStarter.class) {
            if (e == null) {
                e = new ServiceStarter();
            }
            serviceStarter = e;
        }
        return serviceStarter;
    }

    @VisibleForTesting
    public static void setForTesting(ServiceStarter serviceStarter) {
        e = serviceStarter;
    }

    @KeepForSdk
    public static void startMessagingServiceViaReceiver(Context context, Intent intent) {
        Intent intent2 = new Intent(context, FirebaseInstanceIdReceiver.class);
        intent2.setAction("com.google.firebase.MESSAGING_EVENT");
        intent2.putExtra(Constants.IntentKeys.WRAPPED_INTENT, intent);
        context.sendBroadcast(intent2);
    }

    @Nullable
    public static Intent unwrapServiceIntent(Intent intent) {
        Parcelable parcelableExtra = intent.getParcelableExtra(Constants.IntentKeys.WRAPPED_INTENT);
        if (parcelableExtra instanceof Intent) {
            return (Intent) parcelableExtra;
        }
        return null;
    }

    public boolean a(Context context) {
        if (this.c == null) {
            this.c = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.b.booleanValue()) {
            Log.isLoggable("FirebaseInstanceId", 3);
        }
        return this.c.booleanValue();
    }

    public boolean b(Context context) {
        if (this.b == null) {
            this.b = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.b.booleanValue()) {
            Log.isLoggable("FirebaseInstanceId", 3);
        }
        return this.b.booleanValue();
    }

    @KeepForSdk
    @MainThread
    public Intent getMessagingEvent() {
        return this.d.poll();
    }

    @MainThread
    public int startMessagingService(Context context, Intent intent) {
        String str;
        ComponentName componentName;
        ServiceInfo serviceInfo;
        String str2;
        Log.isLoggable("FirebaseInstanceId", 3);
        this.d.offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        synchronized (this) {
            str = this.a;
            if (str == null) {
                ResolveInfo resolveService = context.getPackageManager().resolveService(intent2, 0);
                if (resolveService != null && (serviceInfo = resolveService.serviceInfo) != null) {
                    if (!context.getPackageName().equals(serviceInfo.packageName) || (str2 = serviceInfo.name) == null) {
                        String str3 = serviceInfo.packageName;
                        String str4 = serviceInfo.name;
                        String.valueOf(str3).length();
                        String.valueOf(str4).length();
                    } else {
                        if (str2.startsWith(".")) {
                            String valueOf = String.valueOf(context.getPackageName());
                            String valueOf2 = String.valueOf(serviceInfo.name);
                            this.a = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                        } else {
                            this.a = serviceInfo.name;
                        }
                        str = this.a;
                    }
                }
                str = null;
            }
        }
        if (str != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                if (str.length() != 0) {
                    "Restricting intent to a specific service: ".concat(str);
                } else {
                    new String("Restricting intent to a specific service: ");
                }
            }
            intent2.setClassName(context.getPackageName(), str);
        }
        try {
            if (b(context)) {
                componentName = WakeLockHolder.startWakefulService(context, intent2);
            } else {
                componentName = context.startService(intent2);
            }
            return componentName == null ? 404 : -1;
        } catch (SecurityException unused) {
            return 401;
        } catch (IllegalStateException e2) {
            String.valueOf(e2).length();
            return 402;
        }
    }
}
