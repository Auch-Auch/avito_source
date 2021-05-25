package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.telephony.CellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.yandex.metrica.impl.ob.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public class ze extends za implements r {
    @Nullable
    private final TelephonyManager a;
    private PhoneStateListener b;
    private boolean c;
    private yb d;
    private final r.a<zm> e;
    private final r.a<zb[]> f;
    @NonNull
    private final act g;
    private final Context h;
    private final zd i;
    private final zj j;
    private final zg k;
    @NonNull
    private final su l;
    @NonNull
    private so m;

    public class a extends PhoneStateListener {
        private a() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            ze.this.c(signalStrength);
        }
    }

    public ze(@NonNull Context context, @NonNull act act) {
        this(context, new su(), act);
    }

    private synchronized zb[] j() {
        zb[] zbVarArr;
        if (!this.f.b()) {
            if (!this.f.c()) {
                zbVarArr = this.f.a();
            }
        }
        zbVarArr = f();
        this.f.a((r.a<zb[]>) zbVarArr);
        return zbVarArr;
    }

    private synchronized boolean k() {
        return this.d != null;
    }

    public Context d() {
        return this.h;
    }

    @VisibleForTesting
    public synchronized zm e() {
        zm zmVar;
        zb b2;
        if (!this.e.b()) {
            if (!this.e.c()) {
                zmVar = this.e.a();
            }
        }
        zmVar = new zm(this.i, this.j, this.k);
        zb b3 = zmVar.b();
        if (b3 != null && b3.a() == null && !this.e.b() && (b2 = this.e.a().b()) != null) {
            zmVar.b().a(b2.a());
        }
        this.e.a((r.a<zm>) zmVar);
        return zmVar;
    }

    @VisibleForTesting
    @NonNull
    @SuppressLint({"MissingPermission"})
    public zb[] f() {
        ArrayList arrayList = new ArrayList();
        if (dl.a(17) && this.m.a(this.h)) {
            try {
                List<CellInfo> allCellInfo = this.a.getAllCellInfo();
                if (!dl.a((Collection) allCellInfo)) {
                    for (int i2 = 0; i2 < allCellInfo.size(); i2++) {
                        zb a3 = a(allCellInfo.get(i2));
                        if (a3 != null) {
                            arrayList.add(a3);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        if (arrayList.size() >= 1) {
            return (zb[]) arrayList.toArray(new zb[arrayList.size()]);
        }
        zb b2 = e().b();
        return b2 == null ? new zb[0] : new zb[]{b2};
    }

    public synchronized boolean g() {
        return k() && this.d.o.w;
    }

    public synchronized boolean h() {
        return k() && this.d.o.v;
    }

    public synchronized boolean i() {
        return k() && this.d.o.u;
    }

    public ze(@NonNull Context context, @NonNull su suVar, @NonNull act act) {
        this(context, suVar, new so(suVar.a()), act);
    }

    @Override // com.yandex.metrica.impl.ob.zh
    public synchronized void b() {
        this.g.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.ze.3
            @Override // java.lang.Runnable
            public void run() {
                if (ze.this.c) {
                    ze.this.c = false;
                    eh.a().a(ze.this);
                    if (ze.this.b != null && ze.this.a != null) {
                        try {
                            ze.this.a.listen(ze.this.b, 0);
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        });
    }

    @Nullable
    public TelephonyManager c() {
        return this.a;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void c(SignalStrength signalStrength) {
        zb b2;
        if (!this.e.b() && !this.e.c() && (b2 = this.e.a().b()) != null) {
            b2.a(Integer.valueOf(a(signalStrength)));
        }
    }

    @VisibleForTesting
    public static int b(SignalStrength signalStrength) {
        int gsmSignalStrength = signalStrength.getGsmSignalStrength();
        if (99 == gsmSignalStrength) {
            return -1;
        }
        return (gsmSignalStrength * 2) - 113;
    }

    public ze(@NonNull Context context, @NonNull su suVar, @NonNull so soVar, @NonNull act act) {
        TelephonyManager telephonyManager;
        this.c = false;
        this.e = new r.a<>();
        this.f = new r.a<>();
        this.h = context;
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Throwable unused) {
            telephonyManager = null;
        }
        this.a = telephonyManager;
        this.g = act;
        act.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.ze.1
            @Override // java.lang.Runnable
            public void run() {
                ze.this.b = new a();
            }
        });
        this.i = new zd(this, soVar);
        this.j = new zj(this, soVar);
        this.k = new zg(this, soVar);
        this.l = suVar;
        this.m = soVar;
    }

    @Override // com.yandex.metrica.impl.ob.zh
    public synchronized void a() {
        this.g.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.ze.2
            @Override // java.lang.Runnable
            public void run() {
                if (!ze.this.c) {
                    ze.this.c = true;
                    if (ze.this.b != null && ze.this.a != null) {
                        try {
                            ze.this.a.listen(ze.this.b, 256);
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        });
    }

    @Override // com.yandex.metrica.impl.ob.za
    public synchronized void a(zn znVar) {
        if (znVar != null) {
            znVar.a(e());
        }
    }

    @Override // com.yandex.metrica.impl.ob.za
    public synchronized void a(zc zcVar) {
        if (zcVar != null) {
            zcVar.a(j());
        }
    }

    @TargetApi(17)
    @Nullable
    private zb a(CellInfo cellInfo) {
        return zb.a(cellInfo);
    }

    @VisibleForTesting
    public static int a(SignalStrength signalStrength) {
        if (signalStrength.isGsm()) {
            return b(signalStrength);
        }
        int cdmaDbm = signalStrength.getCdmaDbm();
        int evdoDbm = signalStrength.getEvdoDbm();
        if (-120 == evdoDbm) {
            return cdmaDbm;
        }
        return -120 == cdmaDbm ? evdoDbm : Math.min(cdmaDbm, evdoDbm);
    }

    @Override // com.yandex.metrica.impl.ob.za
    public void a(@NonNull yb ybVar) {
        this.d = ybVar;
        this.l.a(ybVar);
        this.m.a(this.l.a());
    }

    @Override // com.yandex.metrica.impl.ob.za
    public void a(boolean z) {
        this.l.a(z);
        this.m.a(this.l.a());
    }
}
