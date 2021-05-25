package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;
public final class zzq<TResult> {
    private final Object zza = new Object();
    @GuardedBy("mLock")
    private Queue<zzr<TResult>> zzb;
    @GuardedBy("mLock")
    private boolean zzc;

    public final void zza(@NonNull zzr<TResult> zzr) {
        synchronized (this.zza) {
            if (this.zzb == null) {
                this.zzb = new ArrayDeque();
            }
            this.zzb.add(zzr);
        }
    }

    public final void zza(@NonNull Task<TResult> task) {
        zzr<TResult> poll;
        synchronized (this.zza) {
            if (this.zzb != null) {
                if (!this.zzc) {
                    this.zzc = true;
                }
            }
            return;
        }
        while (true) {
            synchronized (this.zza) {
                poll = this.zzb.poll();
                if (poll == null) {
                    this.zzc = false;
                    return;
                }
            }
            poll.zza(task);
        }
    }
}
