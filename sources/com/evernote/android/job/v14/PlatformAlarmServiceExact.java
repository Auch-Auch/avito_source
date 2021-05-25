package com.evernote.android.job.v14;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.evernote.android.job.JobConfig;
import com.evernote.android.job.JobProxy;
import com.evernote.android.job.util.JobCat;
import java.util.HashSet;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class PlatformAlarmServiceExact extends Service {
    public static final JobCat d = new JobCat("PlatformAlarmServiceExact");
    public final Object a = new Object();
    public volatile Set<Integer> b;
    public volatile int c;

    public class a implements Runnable {
        public final /* synthetic */ Intent a;
        public final /* synthetic */ int b;

        public a(Intent intent, int i) {
            this.a = intent;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                PlatformAlarmService.f(this.a, PlatformAlarmServiceExact.this, PlatformAlarmServiceExact.d);
            } finally {
                JobProxy.Common.completeWakefulIntent(this.a);
                PlatformAlarmServiceExact.a(PlatformAlarmServiceExact.this, this.b);
            }
        }
    }

    public static void a(PlatformAlarmServiceExact platformAlarmServiceExact, int i) {
        synchronized (platformAlarmServiceExact.a) {
            Set<Integer> set = platformAlarmServiceExact.b;
            if (set != null) {
                set.remove(Integer.valueOf(i));
                if (set.isEmpty()) {
                    platformAlarmServiceExact.stopSelfResult(platformAlarmServiceExact.c);
                }
            }
        }
    }

    public static Intent createIntent(Context context, int i, @Nullable Bundle bundle) {
        Intent intent = new Intent(context, PlatformAlarmServiceExact.class);
        intent.putExtra("EXTRA_JOB_ID", i);
        if (bundle != null) {
            intent.putExtra("EXTRA_TRANSIENT_EXTRAS", bundle);
        }
        return intent;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.b = new HashSet();
    }

    @Override // android.app.Service
    public void onDestroy() {
        synchronized (this.a) {
            this.b = null;
            this.c = 0;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i, int i2) {
        synchronized (this.a) {
            this.b.add(Integer.valueOf(i2));
            this.c = i2;
        }
        JobConfig.getExecutorService().execute(new a(intent, i2));
        return 2;
    }
}
