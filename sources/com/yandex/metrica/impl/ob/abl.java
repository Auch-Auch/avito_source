package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.uu;
public class abl extends abe {
    private static final int[] a = {3, 6, 4};
    private static final abl b = new abl();

    public abl(@Nullable String str) {
        super(str);
    }

    private String b(uu.c.e.a aVar) {
        if (aVar.d == 3 && TextUtils.isEmpty(aVar.e)) {
            return "Native crash of app";
        }
        if (aVar.d != 4) {
            return aVar.e;
        }
        StringBuilder sb = new StringBuilder(aVar.e);
        if (aVar.f != null) {
            String str = new String(aVar.f);
            if (!TextUtils.isEmpty(str)) {
                sb.append(" with value ");
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static abl h() {
        return b;
    }

    public void a(aa aaVar, String str) {
        if (al.b(aaVar.g())) {
            StringBuilder sb = new StringBuilder(str);
            sb.append(": ");
            sb.append(aaVar.d());
            if (al.c(aaVar.g()) && !TextUtils.isEmpty(aaVar.e())) {
                sb.append(" with value ");
                sb.append(aaVar.e());
            }
            a(sb.toString());
        }
    }

    @Override // com.yandex.metrica.impl.ob.aat
    public String f() {
        return "AppMetrica";
    }

    public abl() {
        this("");
    }

    public void a(uu.c.e.a aVar, String str) {
        if (a(aVar)) {
            StringBuilder Q = a.Q(str, ": ");
            Q.append(b(aVar));
            a(Q.toString());
        }
    }

    private boolean a(uu.c.e.a aVar) {
        for (int i : a) {
            if (aVar.d == i) {
                return true;
            }
        }
        return false;
    }

    public void a(uu.c.e eVar, String str) {
        for (uu.c.e.a aVar : eVar.d) {
            a(aVar, str);
        }
    }
}
