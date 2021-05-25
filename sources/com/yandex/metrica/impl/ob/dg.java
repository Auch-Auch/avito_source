package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.avito.android.util.preferences.db_preferences.Types;
public class dg extends cu<String> {
    public dg(@NonNull Context context, @NonNull String str) {
        super(context, str, Types.STRING);
    }

    @Nullable
    /* renamed from: a */
    public String b(int i) {
        return this.a.getString(i);
    }
}
