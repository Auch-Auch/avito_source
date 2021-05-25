package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.f;
public class bk extends o {
    public bk(Context context, eu euVar, @NonNull f fVar, cs csVar) {
        this(context, csVar, new co(euVar, new CounterConfiguration(fVar)), new am(context));
    }

    @VisibleForTesting
    public bk(Context context, cs csVar, co coVar, @NonNull am amVar) {
        super(context, csVar, coVar, amVar);
    }
}
