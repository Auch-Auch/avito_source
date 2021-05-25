package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.al;
import java.util.List;
public class im extends in<hu> {
    public im(@NonNull ix ixVar) {
        super(ixVar);
    }

    private boolean b(@NonNull al.a aVar) {
        return al.a(aVar);
    }

    @Override // com.yandex.metrica.impl.ob.in
    public void a(@NonNull al.a aVar, @NonNull List<hu> list) {
        if (a(aVar)) {
            list.add(a().h());
        }
        if (b(aVar)) {
            list.add(a().d());
        }
    }

    private boolean a(@NonNull al.a aVar) {
        return al.b(aVar);
    }
}
