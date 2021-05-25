package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.yandex.metrica.i;
import com.yandex.metrica.impl.ob.abv;
public class ii extends hu {
    public ii(fe feVar) {
        super(feVar);
    }

    private boolean c(i iVar, i iVar2) {
        return !TextUtils.isEmpty(iVar.a()) && TextUtils.isEmpty(iVar2.a());
    }

    @Override // com.yandex.metrica.impl.ob.hq
    public boolean a(@NonNull aa aaVar) {
        b(aaVar);
        return true;
    }

    public void b(aa aaVar) {
        String l = aaVar.l();
        i a = abv.a(l);
        String h = a().h();
        i a3 = abv.a(h);
        if (!a.equals(a3)) {
            if (a(a, a3)) {
                aaVar.a(h);
                a(aaVar, abv.a.LOGOUT);
            } else if (c(a, a3)) {
                a(aaVar, abv.a.LOGIN);
            } else if (b(a, a3)) {
                a(aaVar, abv.a.SWITCH);
            } else {
                a(aaVar, abv.a.UPDATE);
            }
            a().a(l);
        }
    }

    private void a(aa aaVar, abv.a aVar) {
        aaVar.c(abv.a(aVar));
        a().e().e(aaVar);
    }

    private boolean a(i iVar, i iVar2) {
        return TextUtils.isEmpty(iVar.a()) && !TextUtils.isEmpty(iVar2.a());
    }

    private boolean b(i iVar, i iVar2) {
        return !TextUtils.isEmpty(iVar.a()) && !iVar.a().equals(iVar2.a());
    }
}
