package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;
@TargetApi(16)
public class st implements sq {
    private final Context a;
    private final ado b;

    public st(Context context) {
        this(context, new ado());
    }

    @Override // com.yandex.metrica.impl.ob.sq
    @NonNull
    public List<sr> a() {
        ArrayList arrayList = new ArrayList();
        ado ado = this.b;
        Context context = this.a;
        PackageInfo a3 = ado.a(context, context.getPackageName(), 4096);
        if (a3 != null) {
            int i = 0;
            while (true) {
                String[] strArr = a3.requestedPermissions;
                if (i >= strArr.length) {
                    break;
                }
                String str = strArr[i];
                if ((a3.requestedPermissionsFlags[i] & 2) != 0) {
                    arrayList.add(new sr(str, true));
                } else {
                    arrayList.add(new sr(str, false));
                }
                i++;
            }
        }
        return arrayList;
    }

    @VisibleForTesting
    public st(Context context, @NonNull ado ado) {
        this.a = context;
        this.b = ado;
    }
}
