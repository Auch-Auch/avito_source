package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
public class ka {
    @NonNull
    public mq a;
    @NonNull
    private final ex b;
    @NonNull
    private String c;
    @NonNull
    private jz d;

    public ka(@NonNull Context context) {
        this(context.getPackageName(), new mq(lv.a(context).c()), new jz());
    }

    @NonNull
    public Bundle a() {
        Bundle bundle = new Bundle();
        this.d.a(bundle, this.c, this.a.g());
        return bundle;
    }

    @VisibleForTesting
    public ka(@NonNull String str, @NonNull mq mqVar, @NonNull jz jzVar) {
        this.c = str;
        this.a = mqVar;
        this.d = jzVar;
        this.b = new ex(str);
    }
}
