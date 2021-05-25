package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.gms.internal.ads.zzoy;
import java.io.IOException;
@SuppressLint({"HandlerLeak"})
public final class zzov<T extends zzoy> extends Handler implements Runnable {
    private volatile boolean zzage;
    private final T zzbjf;
    private final zzow<T> zzbjg;
    public final int zzbjh;
    private final long zzbji;
    private IOException zzbjj;
    private int zzbjk;
    private volatile Thread zzbjl;
    private final /* synthetic */ zzot zzbjm;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzov(zzot zzot, Looper looper, T t, zzow<T> zzow, int i, long j) {
        super(looper);
        this.zzbjm = zzot;
        this.zzbjf = t;
        this.zzbjg = zzow;
        this.zzbjh = i;
        this.zzbji = j;
    }

    private final void execute() {
        this.zzbjj = null;
        this.zzbjm.zzbja.execute(this.zzbjm.zzbjb);
    }

    private final void finish() {
        this.zzbjm.zzbjb = null;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i;
        if (!this.zzage) {
            int i2 = message.what;
            if (i2 == 0) {
                execute();
            } else if (i2 != 4) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = elapsedRealtime - this.zzbji;
                if (this.zzbjf.zzhv()) {
                    this.zzbjg.zza((zzow<T>) this.zzbjf, elapsedRealtime, j, false);
                    return;
                }
                int i3 = message.what;
                if (i3 == 1) {
                    this.zzbjg.zza((zzow<T>) this.zzbjf, elapsedRealtime, j, false);
                } else if (i3 == 2) {
                    this.zzbjg.zza(this.zzbjf, elapsedRealtime, j);
                } else if (i3 == 3) {
                    IOException iOException = (IOException) message.obj;
                    this.zzbjj = iOException;
                    int zza = this.zzbjg.zza((zzow<T>) this.zzbjf, elapsedRealtime, j, iOException);
                    if (zza == 3) {
                        this.zzbjm.zzbjc = this.zzbjj;
                    } else if (zza != 2) {
                        if (zza == 1) {
                            i = 1;
                        } else {
                            i = this.zzbjk + 1;
                        }
                        this.zzbjk = i;
                        zzek((long) Math.min((i - 1) * 1000, 5000));
                    }
                }
            } else {
                throw ((Error) message.obj);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzbjl = Thread.currentThread();
            if (!this.zzbjf.zzhv()) {
                String simpleName = this.zzbjf.getClass().getSimpleName();
                zzpn.beginSection(simpleName.length() != 0 ? "load:".concat(simpleName) : new String("load:"));
                try {
                    this.zzbjf.zzhw();
                } finally {
                    zzpn.endSection();
                }
            }
            if (!this.zzage) {
                sendEmptyMessage(2);
            }
        } catch (IOException e) {
            if (!this.zzage) {
                obtainMessage(3, e).sendToTarget();
            }
        } catch (InterruptedException unused) {
            zzoz.checkState(this.zzbjf.zzhv());
            if (!this.zzage) {
                sendEmptyMessage(2);
            }
        } catch (Exception e2) {
            if (!this.zzage) {
                obtainMessage(3, new zzox(e2)).sendToTarget();
            }
        } catch (OutOfMemoryError e3) {
            if (!this.zzage) {
                obtainMessage(3, new zzox(e3)).sendToTarget();
            }
        } catch (Error e4) {
            if (!this.zzage) {
                obtainMessage(4, e4).sendToTarget();
            }
            throw e4;
        }
    }

    public final void zzbj(int i) throws IOException {
        IOException iOException = this.zzbjj;
        if (iOException != null && this.zzbjk > i) {
            throw iOException;
        }
    }

    public final void zzek(long j) {
        zzoz.checkState(this.zzbjm.zzbjb == null);
        this.zzbjm.zzbjb = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            execute();
        }
    }

    public final void zzl(boolean z) {
        this.zzage = z;
        this.zzbjj = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.zzbjf.cancelLoad();
            if (this.zzbjl != null) {
                this.zzbjl.interrupt();
            }
        }
        if (z) {
            finish();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzbjg.zza((zzow<T>) this.zzbjf, elapsedRealtime, elapsedRealtime - this.zzbji, true);
        }
    }
}
