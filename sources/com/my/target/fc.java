package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.my.target.common.MyTargetVersion;
import java.util.Map;
public final class fc extends fb {
    @NonNull
    public static final fc l = new fc();
    @NonNull
    public final ez b = new ez();
    @NonNull
    public final fa c = new fa();
    @NonNull
    public final fd d = new fd();
    @NonNull
    public final ff e = new ff();
    @NonNull
    public final fe f = new fe();
    @NonNull
    public final ey g = new ey();
    @NonNull
    public final ex h = new ex();
    @NonNull
    public final ew i = new ew();
    @Nullable
    public volatile String j = null;
    public boolean k = true;

    @NonNull
    public static fc dP() {
        return l;
    }

    public void C(boolean z) {
        this.k = z;
    }

    @WorkerThread
    public void K(@NonNull Context context) {
        if (af.isMainThread()) {
            ae.a("FingerprintDataProvider: You must not call collectData method from main thread");
            return;
        }
        this.b.collectData(context);
        this.d.collectData(context);
        this.f.collectData(context);
    }

    @Override // com.my.target.fb
    @WorkerThread
    public synchronized void collectData(@NonNull Context context) {
        if (af.isMainThread()) {
            ae.a("FingerprintDataProvider: You must not call collectData method from main thread");
            return;
        }
        removeAll();
        this.b.collectData(context);
        if (this.k) {
            this.c.collectData(context);
            this.d.collectData(context);
            this.e.collectData(context);
            this.f.collectData(context);
            this.h.collectData(context);
            this.i.collectData(context);
            this.g.collectData(context);
        }
        Map<String, String> map = getMap();
        this.b.putDataTo(map);
        if (this.k) {
            this.c.putDataTo(map);
            this.d.putDataTo(map);
            this.e.putDataTo(map);
            this.f.putDataTo(map);
            this.h.putDataTo(map);
            this.i.putDataTo(map);
            this.g.putDataTo(map);
        }
    }

    @NonNull
    public fa dQ() {
        return this.c;
    }

    @NonNull
    public String getBidderToken(@NonNull Context context) {
        if (af.isMainThread()) {
            ae.a("FingerprintDataProvider: You must not call getBidderToken method from main thread");
            return "";
        }
        if (this.j == null) {
            synchronized (fc.class) {
                if (this.j == null) {
                    removeAll();
                    this.b.collectData(context);
                    if (this.k) {
                        this.d.collectData(context);
                        this.f.collectData(context);
                    }
                    Map<String, String> map = getMap();
                    this.b.putDataTo(map);
                    if (this.k) {
                        this.d.putDataTo(map);
                        this.f.putDataTo(map);
                    }
                    map.put("sdk_ver_int", MyTargetVersion.VERSION_INT);
                    this.j = hz.ai(in.a(map));
                }
            }
        }
        String str = this.j;
        return str != null ? str : "";
    }
}
