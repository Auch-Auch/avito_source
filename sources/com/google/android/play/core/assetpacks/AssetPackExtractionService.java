package com.google.android.play.core.assetpacks;

import a2.j.b.e.a.b.a0;
import a2.j.b.e.a.b.k2;
import a2.j.b.e.a.b.y;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import com.facebook.share.internal.ShareConstants;
import com.google.android.play.core.internal.aa;
public class AssetPackExtractionService extends Service {
    public final aa a = new aa("AssetPackExtractionService");
    public Context b;
    public k2 c;
    public a0 d;
    public y e;
    public NotificationManager f;

    public final synchronized Bundle a(Bundle bundle) {
        int i = bundle.getInt(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE);
        aa aaVar = this.a;
        Integer valueOf = Integer.valueOf(i);
        aaVar.a("updateServiceState: %d", valueOf);
        if (i == 1) {
            c(bundle);
        } else if (i != 2) {
            this.a.b("Unknown action type received: %d", valueOf);
        } else {
            b();
        }
        return new Bundle();
    }

    public final synchronized void b() {
        this.a.c("Stopping service.", new Object[0]);
        k2 k2Var = this.c;
        k2Var.c.b();
        k2Var.c.a(false);
        stopForeground(true);
        stopSelf();
    }

    public final synchronized void c(Bundle bundle) {
        String string = bundle.getString("notification_title");
        String string2 = bundle.getString("notification_subtext");
        long j = bundle.getLong("notification_timeout");
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("notification_on_click_intent");
        int i = Build.VERSION.SDK_INT;
        Notification.Builder timeoutAfter = i >= 26 ? new Notification.Builder(this.b, "playcore-assetpacks-service-notification-channel").setTimeoutAfter(j) : new Notification.Builder(this.b).setPriority(-2);
        if (pendingIntent != null) {
            timeoutAfter.setContentIntent(pendingIntent);
        }
        timeoutAfter.setSmallIcon(17301633).setOngoing(false).setContentTitle(string).setSubText(string2);
        timeoutAfter.setColor(bundle.getInt("notification_color")).setVisibility(-1);
        Notification build = timeoutAfter.build();
        this.a.c("Starting foreground service.", new Object[0]);
        k2 k2Var = this.c;
        boolean b2 = k2Var.c.b();
        k2Var.c.a(true);
        if (!b2) {
            k2Var.a();
        }
        if (i >= 26) {
            this.f.createNotificationChannel(new NotificationChannel("playcore-assetpacks-service-notification-channel", bundle.getString("notification_channel_name"), 2));
        }
        startForeground(-1883842196, build);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.e;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.a.a("onCreate", new Object[0]);
        dd.c(getApplicationContext()).a(this);
        this.e = new y(this.b, this, this.d);
        this.f = (NotificationManager) this.b.getSystemService("notification");
    }
}
