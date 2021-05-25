package com.yandex.mobile.ads.nativeads;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.mobile.ads.impl.an;
import com.yandex.mobile.ads.impl.lm;
import com.yandex.mobile.ads.impl.oq;
import com.yandex.mobile.ads.nativeads.au;
import java.util.List;
public class m implements au {
    public final ao a;
    private final List<oq> b;
    private String c;
    private ag d;

    public m(@Nullable List<oq> list, @NonNull ao aoVar) {
        this.b = list;
        this.a = aoVar;
    }

    @VisibleForTesting
    public boolean b() {
        return !a(new au.b() { // from class: com.yandex.mobile.ads.nativeads.m.1
            @Override // com.yandex.mobile.ads.nativeads.au.b
            public final boolean a(@NonNull List<oq> list) {
                lm a3;
                for (oq oqVar : list) {
                    if (oqVar.f() && (a3 = m.this.d.a(oqVar)) != null && a3.d()) {
                        return true;
                    }
                }
                return false;
            }
        });
    }

    @VisibleForTesting
    public boolean c() {
        return !a(new au.b() { // from class: com.yandex.mobile.ads.nativeads.m.2
            @Override // com.yandex.mobile.ads.nativeads.au.b
            public final boolean a(@NonNull List<oq> list) {
                lm a3;
                for (oq oqVar : list) {
                    if (oqVar.f() && ((a3 = m.this.d.a(oqVar)) == null || !a3.c())) {
                        m.this.c = oqVar.a();
                        return false;
                    }
                }
                return true;
            }
        });
    }

    public boolean d() {
        return !a(new au.b() { // from class: com.yandex.mobile.ads.nativeads.m.3
            @Override // com.yandex.mobile.ads.nativeads.au.b
            public final boolean a(@NonNull List<oq> list) {
                for (oq oqVar : list) {
                    if (oqVar.f()) {
                        lm a3 = m.this.d.a(oqVar);
                        Object c2 = oqVar.c();
                        if (a3 == null || !a3.b(c2)) {
                            m.this.c = oqVar.a();
                            return false;
                        }
                    }
                }
                return true;
            }
        });
    }

    @Override // com.yandex.mobile.ads.nativeads.au
    @NonNull
    public bk e() {
        return new bk(a(new au.b() { // from class: com.yandex.mobile.ads.nativeads.m.4
            @Override // com.yandex.mobile.ads.nativeads.au.b
            public final boolean a(@NonNull List<oq> list) {
                lm a3;
                for (oq oqVar : list) {
                    if (oqVar.f() && ((a3 = m.this.d.a(oqVar)) == null || !a3.b())) {
                        m.this.c = oqVar.a();
                        return false;
                    }
                }
                return true;
            }
        }), this.c);
    }

    @Override // com.yandex.mobile.ads.nativeads.au
    public void a(ag agVar) {
        this.d = agVar;
    }

    private boolean a(@NonNull au.b bVar) {
        return this.d != null && a(bVar, this.b);
    }

    @SuppressLint({"VisibleForTests"})
    public boolean a(@NonNull au.b bVar, @Nullable List<oq> list) {
        if (!this.a.b()) {
            return true;
        }
        if (list == null || !bVar.a(list)) {
            return false;
        }
        return true;
    }

    @Override // com.yandex.mobile.ads.nativeads.au
    public au.a a() {
        int i;
        an.a aVar;
        List<oq> list = this.b;
        boolean z = false;
        if (list != null) {
            i = 0;
            for (oq oqVar : list) {
                if (oqVar.f()) {
                    i++;
                }
            }
        } else {
            i = 0;
        }
        if ((i >= 2) && b()) {
            z = true;
        }
        if (z) {
            aVar = an.a.NO_VISIBLE_REQUIRED_ASSETS;
        } else if (c()) {
            aVar = an.a.REQUIRED_ASSET_CAN_NOT_BE_VISIBLE;
        } else if (d()) {
            aVar = an.a.INCONSISTENT_ASSET_VALUE;
        } else {
            aVar = an.a.SUCCESS;
        }
        return new at(aVar, this.c);
    }
}
