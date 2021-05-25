package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.CounterConfiguration;
public class et {
    @Nullable
    private final eu a;
    @NonNull
    private final CounterConfiguration b;

    public et(@NonNull Bundle bundle) {
        this.a = eu.a(bundle);
        this.b = CounterConfiguration.c(bundle);
    }

    public static boolean a(@Nullable et etVar, @NonNull Context context) {
        return etVar == null || etVar.g() == null || !context.getPackageName().equals(etVar.g().i()) || etVar.g().h() != 87;
    }

    @NonNull
    public eu g() {
        return this.a;
    }

    @NonNull
    public CounterConfiguration h() {
        return this.b;
    }

    public String toString() {
        StringBuilder L = a.L("ClientConfiguration{mProcessConfiguration=");
        L.append(this.a);
        L.append(", mCounterConfiguration=");
        L.append(this.b);
        L.append('}');
        return L.toString();
    }

    public et(@NonNull eu euVar, @NonNull CounterConfiguration counterConfiguration) {
        this.a = euVar;
        this.b = counterConfiguration;
    }
}
