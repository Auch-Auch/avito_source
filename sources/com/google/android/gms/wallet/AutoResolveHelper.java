package com.google.android.gms.wallet;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.internal.wallet.zzf;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
public class AutoResolveHelper {
    public static final int RESULT_ERROR = 1;
    private static final long zzv = TimeUnit.MINUTES.toMillis(10);
    @VisibleForTesting
    public static long zzw = SystemClock.elapsedRealtime();

    public static class zzb extends Fragment {
        private static String zzac = "resolveCallId";
        private static String zzad = "requestCode";
        private static String zzae = "initializationElapsedRealtime";
        private static String zzaf = "delivered";
        private int zzag;
        private zza<?> zzah;
        @VisibleForTesting
        private boolean zzai;

        /* access modifiers changed from: private */
        public static Fragment zza(int i, int i2) {
            Bundle bundle = new Bundle();
            bundle.putInt(zzac, i);
            bundle.putInt(zzad, i2);
            bundle.putLong(zzae, AutoResolveHelper.zzw);
            zzb zzb = new zzb();
            zzb.setArguments(bundle);
            return zzb;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(@Nullable Task<? extends AutoResolvableResult> task) {
            if (!this.zzai) {
                this.zzai = true;
                Activity activity = getActivity();
                activity.getFragmentManager().beginTransaction().remove(this).commit();
                if (task != null) {
                    AutoResolveHelper.zza(activity, this.zzag, task);
                } else {
                    AutoResolveHelper.zza(activity, this.zzag, 0, new Intent());
                }
            }
        }

        private final void zzc() {
            zza<?> zza = this.zzah;
            if (zza != null) {
                zza.zzb(this);
            }
        }

        @Override // android.app.Fragment
        public final void onCreate(@Nullable Bundle bundle) {
            super.onCreate(bundle);
            this.zzag = getArguments().getInt(zzad);
            if (AutoResolveHelper.zzw != getArguments().getLong(zzae)) {
                this.zzah = null;
            } else {
                this.zzah = zza.zzq.get(getArguments().getInt(zzac));
            }
            this.zzai = bundle != null && bundle.getBoolean(zzaf);
        }

        @Override // android.app.Fragment
        public final void onPause() {
            super.onPause();
            zzc();
        }

        @Override // android.app.Fragment
        public final void onResume() {
            super.onResume();
            zza<?> zza = this.zzah;
            if (zza != null) {
                zza.zza(this);
                return;
            }
            Log.isLoggable("AutoResolveHelper", 5);
            zzb(null);
        }

        @Override // android.app.Fragment
        public final void onSaveInstanceState(Bundle bundle) {
            super.onSaveInstanceState(bundle);
            bundle.putBoolean(zzaf, this.zzai);
            zzc();
        }
    }

    private AutoResolveHelper() {
    }

    @Nullable
    public static Status getStatusFromIntent(@Nullable Intent intent) {
        if (intent == null) {
            return null;
        }
        return (Status) intent.getParcelableExtra("com.google.android.gms.common.api.AutoResolveHelper.status");
    }

    public static void putStatusIntoIntent(@NonNull Intent intent, @Nullable Status status) {
        if (status == null) {
            intent.removeExtra("com.google.android.gms.common.api.AutoResolveHelper.status");
        } else {
            intent.putExtra("com.google.android.gms.common.api.AutoResolveHelper.status", status);
        }
    }

    @MainThread
    public static <TResult extends AutoResolvableResult> void resolveTask(@NonNull Task<TResult> task, @NonNull Activity activity, int i) {
        zza zza2 = zza.zza(task);
        FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
        Fragment zza3 = zzb.zza(zza2.zzs, i);
        int i2 = zza2.zzs;
        StringBuilder sb = new StringBuilder(58);
        sb.append("com.google.android.gms.wallet.AutoResolveHelper");
        sb.append(i2);
        beginTransaction.add(zza3, sb.toString()).commit();
    }

    public static <TResult> void zza(Status status, TResult tresult, TaskCompletionSource<TResult> taskCompletionSource) {
        if (status.isSuccess()) {
            taskCompletionSource.setResult(tresult);
        } else {
            taskCompletionSource.setException(ApiExceptionUtil.fromStatus(status));
        }
    }

    /* access modifiers changed from: private */
    public static void zza(Activity activity, int i, Task<? extends AutoResolvableResult> task) {
        if (activity.isFinishing()) {
            if (!Log.isLoggable("AutoResolveHelper", 3)) {
            }
        } else if (task.getException() instanceof ResolvableApiException) {
            try {
                ((ResolvableApiException) task.getException()).startResolutionForResult(activity, i);
            } catch (IntentSender.SendIntentException unused) {
                Log.isLoggable("AutoResolveHelper", 6);
            }
        } else {
            Intent intent = new Intent();
            int i2 = 1;
            if (task.isSuccessful()) {
                i2 = -1;
                ((AutoResolvableResult) task.getResult()).putIntoIntent(intent);
            } else if (task.getException() instanceof ApiException) {
                ApiException apiException = (ApiException) task.getException();
                putStatusIntoIntent(intent, new Status(apiException.getStatusCode(), apiException.getMessage(), (PendingIntent) null));
            } else {
                if (Log.isLoggable("AutoResolveHelper", 6)) {
                    task.getException();
                }
                putStatusIntoIntent(intent, new Status(8, "Unexpected non API exception when trying to deliver the task result to an activity!"));
            }
            zza(activity, i, i2, intent);
        }
    }

    @VisibleForTesting
    public static class zza<TResult extends AutoResolvableResult> implements OnCompleteListener<TResult>, Runnable {
        @VisibleForTesting
        private static final Handler zzp = new zzf(Looper.getMainLooper());
        @VisibleForTesting
        public static final SparseArray<zza<?>> zzq = new SparseArray<>(2);
        private static final AtomicInteger zzr = new AtomicInteger();
        public int zzs;
        private zzb zzt;
        private Task<TResult> zzu;

        public static <TResult extends AutoResolvableResult> zza<TResult> zza(Task<TResult> task) {
            zza<TResult> zza = new zza<>();
            int incrementAndGet = zzr.incrementAndGet();
            zza.zzs = incrementAndGet;
            zzq.put(incrementAndGet, zza);
            zzp.postDelayed(zza, AutoResolveHelper.zzv);
            task.addOnCompleteListener(zza);
            return zza;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public final void onComplete(@NonNull Task<TResult> task) {
            this.zzu = task;
            zza();
        }

        @Override // java.lang.Runnable
        public final void run() {
            zzq.delete(this.zzs);
        }

        public final void zzb(zzb zzb) {
            if (this.zzt == zzb) {
                this.zzt = null;
            }
        }

        public final void zza(zzb zzb) {
            this.zzt = zzb;
            zza();
        }

        private final void zza() {
            if (this.zzu != null && this.zzt != null) {
                zzq.delete(this.zzs);
                zzp.removeCallbacks(this);
                this.zzt.zzb(this.zzu);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void zza(Activity activity, int i, int i2, Intent intent) {
        PendingIntent createPendingResult = activity.createPendingResult(i, intent, 1073741824);
        if (createPendingResult != null) {
            try {
                createPendingResult.send(i2);
            } catch (PendingIntent.CanceledException unused) {
                Log.isLoggable("AutoResolveHelper", 6);
            }
        } else if (!Log.isLoggable("AutoResolveHelper", 5)) {
        }
    }
}
