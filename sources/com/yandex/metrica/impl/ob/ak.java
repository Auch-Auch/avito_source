package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.ut;
public class ak implements nh<aj, ut.a> {
    @NonNull
    /* renamed from: a */
    public ut.a b(@NonNull aj ajVar) {
        ut.a aVar = new ut.a();
        String str = ajVar.a;
        if (str != null) {
            aVar.b = str.getBytes();
        }
        return aVar;
    }

    @NonNull
    public aj a(@NonNull ut.a aVar) {
        return new aj(new String(aVar.b));
    }
}
