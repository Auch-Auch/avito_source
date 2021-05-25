package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
public class sw implements sq {
    @NonNull
    private final Context a;
    @NonNull
    private final String b;
    @NonNull
    private final ado c;

    public sw(@NonNull Context context) {
        this(context, context.getPackageName(), new ado());
    }

    @Override // com.yandex.metrica.impl.ob.sq
    @NonNull
    public List<sr> a() {
        ArrayList arrayList = new ArrayList();
        PackageInfo a3 = this.c.a(this.a, this.b, 4096);
        if (a3 != null) {
            for (String str : a3.requestedPermissions) {
                arrayList.add(new sr(str, true));
            }
        }
        return arrayList;
    }

    public sw(@NonNull Context context, @NonNull String str, @NonNull ado ado) {
        this.a = context;
        this.b = str;
        this.c = ado;
    }
}
