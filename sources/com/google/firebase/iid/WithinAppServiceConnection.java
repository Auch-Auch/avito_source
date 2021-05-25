package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.iid.WithinAppServiceConnection;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class WithinAppServiceConnection implements ServiceConnection {
    public final Context a;
    public final Intent b;
    public final ScheduledExecutorService c;
    public final Queue<a> d = new ArrayDeque();
    @Nullable
    public WithinAppServiceBinder e;
    @GuardedBy("this")
    public boolean f = false;

    public static class a {
        public final Intent a;
        public final TaskCompletionSource<Void> b = new TaskCompletionSource<>();

        public a(Intent intent) {
            this.a = intent;
        }

        public void a() {
            this.b.trySetResult(null);
        }
    }

    public WithinAppServiceConnection(Context context, String str) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection"));
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = new Intent(str).setPackage(applicationContext.getPackageName());
        this.c = scheduledThreadPoolExecutor;
    }

    @GuardedBy("this")
    public final void a() {
        while (!this.d.isEmpty()) {
            this.d.poll().a();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004f, code lost:
        if (com.google.android.gms.common.stats.ConnectionTracker.getInstance().bindService(r4.a, r4.b, r4, 65) != false) goto L_0x0058;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "FirebaseInstanceId"
            r1 = 3
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x005c }
        L_0x0008:
            java.util.Queue<com.google.firebase.iid.WithinAppServiceConnection$a> r0 = r4.d     // Catch:{ all -> 0x005c }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x005c }
            if (r0 != 0) goto L_0x005a
            java.lang.String r0 = "FirebaseInstanceId"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x005c }
            com.google.firebase.iid.WithinAppServiceBinder r0 = r4.e     // Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x0034
            boolean r0 = r0.isBinderAlive()     // Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x0034
            java.lang.String r0 = "FirebaseInstanceId"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x005c }
            java.util.Queue<com.google.firebase.iid.WithinAppServiceConnection$a> r0 = r4.d     // Catch:{ all -> 0x005c }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x005c }
            com.google.firebase.iid.WithinAppServiceConnection$a r0 = (com.google.firebase.iid.WithinAppServiceConnection.a) r0     // Catch:{ all -> 0x005c }
            com.google.firebase.iid.WithinAppServiceBinder r2 = r4.e     // Catch:{ all -> 0x005c }
            r2.a(r0)     // Catch:{ all -> 0x005c }
            goto L_0x0008
        L_0x0034:
            java.lang.String r0 = "FirebaseInstanceId"
            android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x005c }
            boolean r0 = r4.f     // Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x003e
            goto L_0x0058
        L_0x003e:
            r0 = 1
            r4.f = r0     // Catch:{ all -> 0x005c }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ SecurityException -> 0x0052 }
            android.content.Context r1 = r4.a     // Catch:{ SecurityException -> 0x0052 }
            android.content.Intent r2 = r4.b     // Catch:{ SecurityException -> 0x0052 }
            r3 = 65
            boolean r0 = r0.bindService(r1, r2, r4, r3)     // Catch:{ SecurityException -> 0x0052 }
            if (r0 == 0) goto L_0x0052
            goto L_0x0058
        L_0x0052:
            r0 = 0
            r4.f = r0
            r4.a()
        L_0x0058:
            monitor-exit(r4)
            return
        L_0x005a:
            monitor-exit(r4)
            return
        L_0x005c:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.WithinAppServiceConnection.b():void");
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String.valueOf(componentName).length();
        }
        this.f = false;
        if (!(iBinder instanceof WithinAppServiceBinder)) {
            String.valueOf(iBinder).length();
            a();
            return;
        }
        this.e = (WithinAppServiceBinder) iBinder;
        b();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String.valueOf(componentName).length();
        }
        b();
    }

    public synchronized Task<Void> sendIntent(Intent intent) {
        a aVar;
        Log.isLoggable("FirebaseInstanceId", 3);
        aVar = new a(intent);
        ScheduledExecutorService scheduledExecutorService = this.c;
        aVar.b.getTask().addOnCompleteListener(scheduledExecutorService, new OnCompleteListener(scheduledExecutorService.schedule(new Runnable(aVar) { // from class: a2.j.e.i.l0
            public final WithinAppServiceConnection.a a;

            {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                WithinAppServiceConnection.a aVar2 = this.a;
                String.valueOf(aVar2.a.getAction()).length();
                aVar2.a();
            }
        }, 9000, TimeUnit.MILLISECONDS)) { // from class: a2.j.e.i.m0
            public final ScheduledFuture a;

            {
                this.a = r1;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.a.cancel(false);
            }
        });
        this.d.add(aVar);
        b();
        return aVar.b.getTask();
    }
}
