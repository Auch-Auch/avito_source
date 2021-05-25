package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.IReporter;
import java.util.HashMap;
public class hv extends hu {
    @NonNull
    private final IReporter a;

    public hv(@NonNull fe feVar, @NonNull IReporter iReporter) {
        super(feVar);
        this.a = iReporter;
    }

    @Override // com.yandex.metrica.impl.ob.hq
    public boolean a(@NonNull aa aaVar) {
        kv a3 = kv.a(aaVar.g());
        HashMap hashMap = new HashMap();
        hashMap.put("type", a3.a);
        hashMap.put("delivery_method", a3.b);
        this.a.reportEvent("crash_saved", hashMap);
        return false;
    }
}
