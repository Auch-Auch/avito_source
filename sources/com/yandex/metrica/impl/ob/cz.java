package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.metrica.CounterConfiguration;
import java.util.HashMap;
import java.util.Map;
public class cz {
    @NonNull
    private final da a;
    @NonNull
    private final Context b;
    @NonNull
    private final Map<String, cy> c = new HashMap();

    public cz(@NonNull Context context, @NonNull da daVar) {
        this.b = context;
        this.a = daVar;
    }

    @NonNull
    public synchronized cy a(@NonNull String str, @NonNull CounterConfiguration.a aVar) {
        cy cyVar;
        cyVar = this.c.get(str);
        if (cyVar == null) {
            cyVar = new cy(str, this.b, aVar, this.a);
            this.c.put(str, cyVar);
        }
        return cyVar;
    }
}
