package com.google.firebase.iid;

import a2.j.e.i.a;
import a2.j.e.i.d;
import a2.j.e.i.f;
import a2.j.e.i.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.FcmBroadcastProcessor;
import com.google.firebase.iid.ServiceStarter;
import com.google.firebase.messaging.Constants;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;
@KeepForSdk
public class FcmBroadcastProcessor implements a {
    public static final Object c = new Object();
    @GuardedBy("lock")
    public static WithinAppServiceConnection d;
    public final Context a;
    public final ExecutorService b;

    public FcmBroadcastProcessor(Context context, ExecutorService executorService) {
        this.a = context;
        this.b = executorService;
    }

    public static Task<Integer> a(Context context, Intent intent) {
        WithinAppServiceConnection withinAppServiceConnection;
        Log.isLoggable("FirebaseInstanceId", 3);
        synchronized (c) {
            if (d == null) {
                d = new WithinAppServiceConnection(context, "com.google.firebase.MESSAGING_EVENT");
            }
            withinAppServiceConnection = d;
        }
        Task<Void> sendIntent = withinAppServiceConnection.sendIntent(intent);
        Executor executor = g.a;
        return sendIntent.continueWith(f.a, d.a);
    }

    @VisibleForTesting
    public static void reset() {
        synchronized (c) {
            d = null;
        }
    }

    @Override // a2.j.e.i.a
    @KeepForSdk
    public Task<Integer> process(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra(Constants.MessagePayloadKeys.RAW_DATA, Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        return startMessagingService(this.a, intent);
    }

    @SuppressLint({"InlinedApi"})
    public Task<Integer> startMessagingService(Context context, Intent intent) {
        boolean z = true;
        boolean z2 = PlatformVersion.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26;
        if ((intent.getFlags() & 268435456) == 0) {
            z = false;
        }
        if (!z2 || z) {
            return Tasks.call(this.b, new Callable(context, intent) { // from class: a2.j.e.i.b
                public final Context a;
                public final Intent b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Context context2 = this.a;
                    Intent intent2 = this.b;
                    Object obj = FcmBroadcastProcessor.c;
                    return Integer.valueOf(ServiceStarter.getInstance().startMessagingService(context2, intent2));
                }
            }).continueWithTask(this.b, new Continuation(context, intent) { // from class: a2.j.e.i.c
                public final Context a;
                public final Intent b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    Context context2 = this.a;
                    Intent intent2 = this.b;
                    Object obj = FcmBroadcastProcessor.c;
                    if (!PlatformVersion.isAtLeastO() || ((Integer) task.getResult()).intValue() != 402) {
                        return task;
                    }
                    Task<Integer> a3 = FcmBroadcastProcessor.a(context2, intent2);
                    Executor executor = g.a;
                    return a3.continueWith(f.a, e.a);
                }
            });
        }
        return a(context, intent);
    }
}
