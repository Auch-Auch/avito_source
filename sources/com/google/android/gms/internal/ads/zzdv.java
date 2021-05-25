package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzby;
import com.google.android.gms.internal.ads.zzcf;
import java.util.Iterator;
import java.util.LinkedList;
public abstract class zzdv implements zzdw {
    public static volatile zzex zzwg;
    public MotionEvent zzwl;
    public LinkedList<MotionEvent> zzwm = new LinkedList<>();
    public long zzwn = 0;
    public long zzwo = 0;
    public long zzwp = 0;
    public long zzwq = 0;
    public long zzwr = 0;
    public long zzws = 0;
    public long zzwt = 0;
    public double zzwu;
    private double zzwv;
    private double zzww;
    public float zzwx;
    public float zzwy;
    public float zzwz;
    public float zzxa;
    private boolean zzxb = false;
    public boolean zzxc = false;
    public DisplayMetrics zzxd;

    public zzdv(Context context) {
        try {
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcqu)).booleanValue()) {
                zzcx.zzbo();
            } else {
                zzfe.zzb(zzwg);
            }
            this.zzxd = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    private final void zzbx() {
        this.zzwr = 0;
        this.zzwn = 0;
        this.zzwo = 0;
        this.zzwp = 0;
        this.zzwq = 0;
        this.zzws = 0;
        this.zzwt = 0;
        if (this.zzwm.size() > 0) {
            Iterator<MotionEvent> it = this.zzwm.iterator();
            while (it.hasNext()) {
                it.next().recycle();
            }
            this.zzwm.clear();
        } else {
            MotionEvent motionEvent = this.zzwl;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        }
        this.zzwl = null;
    }

    public abstract long zza(StackTraceElement[] stackTraceElementArr) throws zzeu;

    public abstract zzcf.zza.C0192zza zza(Context context, zzby.zza zza);

    @Override // com.google.android.gms.internal.ads.zzdw
    public String zza(Context context, View view, Activity activity) {
        return zza(context, null, zzcw.zzno, view, activity, null);
    }

    public abstract zzcf.zza.C0192zza zzb(Context context, View view, Activity activity);

    public abstract zzfd zzb(MotionEvent motionEvent) throws zzeu;

    @Override // com.google.android.gms.internal.ads.zzdw
    public String zzb(Context context) {
        if (!zzfg.isMainThread()) {
            return zza(context, null, zzcw.zznn, null, null, null);
        }
        throw new IllegalStateException("The caller must not be called from the UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public void zzb(View view) {
    }

    public abstract zzcf.zza.C0192zza zzc(Context context, View view, Activity activity);

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public String zza(Context context, String str, View view, Activity activity) {
        return zza(context, str, zzcw.zznp, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public void zza(MotionEvent motionEvent) {
        boolean z = false;
        if (this.zzxb) {
            zzbx();
            this.zzxb = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.zzwu = 0.0d;
            this.zzwv = (double) motionEvent.getRawX();
            this.zzww = (double) motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = (double) motionEvent.getRawX();
            double rawY = (double) motionEvent.getRawY();
            double d = rawX - this.zzwv;
            double d2 = rawY - this.zzww;
            this.zzwu = Math.sqrt((d2 * d2) + (d * d)) + this.zzwu;
            this.zzwv = rawX;
            this.zzww = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 == 0) {
            this.zzwx = motionEvent.getX();
            this.zzwy = motionEvent.getY();
            this.zzwz = motionEvent.getRawX();
            this.zzxa = motionEvent.getRawY();
            this.zzwn++;
        } else if (action2 == 1) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            this.zzwl = obtain;
            this.zzwm.add(obtain);
            if (this.zzwm.size() > 6) {
                this.zzwm.remove().recycle();
            }
            this.zzwp++;
            this.zzwr = zza(new Throwable().getStackTrace());
        } else if (action2 == 2) {
            this.zzwo += (long) (motionEvent.getHistorySize() + 1);
            try {
                zzfd zzb = zzb(motionEvent);
                if ((zzb == null || zzb.zzzs == null || zzb.zzzv == null) ? false : true) {
                    this.zzws = zzb.zzzs.longValue() + zzb.zzzv.longValue() + this.zzws;
                }
                if (!(this.zzxd == null || zzb == null || zzb.zzzt == null || zzb.zzzw == null)) {
                    z = true;
                }
                if (z) {
                    this.zzwt = zzb.zzzt.longValue() + zzb.zzzw.longValue() + this.zzwt;
                }
            } catch (zzeu unused) {
            }
        } else if (action2 == 3) {
            this.zzwq++;
        }
        this.zzxc = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public void zza(int i, int i2, int i3) {
        if (this.zzwl != null) {
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcqh)).booleanValue()) {
                zzbx();
            } else {
                this.zzwl.recycle();
            }
        }
        DisplayMetrics displayMetrics = this.zzxd;
        if (displayMetrics != null) {
            float f = displayMetrics.density;
            this.zzwl = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * f, ((float) i2) * f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.zzwl = null;
        }
        this.zzxc = false;
    }

    private final String zza(Context context, String str, int i, View view, Activity activity, byte[] bArr) {
        String str2;
        zzdu zzdu;
        int i2;
        int i3;
        int i4;
        int i5;
        long currentTimeMillis = System.currentTimeMillis();
        boolean booleanValue = ((Boolean) zzwe.zzpu().zzd(zzaat.zzcqj)).booleanValue();
        zzcf.zza.C0192zza zza = null;
        if (booleanValue) {
            zzdu = zzwg != null ? zzwg.zzcl() : null;
            str2 = ((Boolean) zzwe.zzpu().zzd(zzaat.zzcqu)).booleanValue() ? "be" : "te";
        } else {
            zzdu = null;
            str2 = null;
        }
        try {
            if (i == zzcw.zznp) {
                zza = zzb(context, view, activity);
                this.zzxb = true;
                i5 = 1002;
            } else if (i == zzcw.zzno) {
                zza = zzc(context, view, activity);
                i5 = 1008;
            } else {
                zza = zza(context, null);
                i5 = 1000;
            }
            if (booleanValue && zzdu != null) {
                zzdu.zza(i5, -1, System.currentTimeMillis() - currentTimeMillis, str2);
            }
        } catch (Exception e) {
            if (booleanValue && zzdu != null) {
                if (i == zzcw.zznp) {
                    i4 = 1003;
                } else if (i == zzcw.zzno) {
                    i4 = 1009;
                } else {
                    i4 = i == zzcw.zznn ? 1001 : -1;
                }
                zzdu.zza(i4, -1, System.currentTimeMillis() - currentTimeMillis, str2, e);
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (zza != null) {
            try {
                if (((zzcf.zza) ((zzegp) zza.zzbfx())).zzbfl() != 0) {
                    String zzj = zzcx.zzj((zzcf.zza) ((zzegp) zza.zzbfx()), str);
                    if (!booleanValue || zzdu == null) {
                        return zzj;
                    }
                    if (i == zzcw.zznp) {
                        i3 = 1006;
                    } else if (i == zzcw.zzno) {
                        i3 = 1010;
                    } else {
                        i3 = i == zzcw.zznn ? 1004 : -1;
                    }
                    zzdu.zza(i3, -1, System.currentTimeMillis() - currentTimeMillis2, str2);
                    return zzj;
                }
            } catch (Exception e2) {
                String num = Integer.toString(7);
                if (!booleanValue || zzdu == null) {
                    return num;
                }
                if (i == zzcw.zznp) {
                    i2 = 1007;
                } else if (i == zzcw.zzno) {
                    i2 = 1011;
                } else {
                    i2 = i == zzcw.zznn ? 1005 : -1;
                }
                zzdu.zza(i2, -1, System.currentTimeMillis() - currentTimeMillis2, str2, e2);
                return num;
            }
        }
        return Integer.toString(5);
    }
}
