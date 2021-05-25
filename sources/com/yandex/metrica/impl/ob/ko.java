package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
@TargetApi(26)
public class ko extends kp {
    @NonNull
    private final act a;
    @NonNull
    private ed b;
    @NonNull
    private xl c;

    public ko(@NonNull Context context, @NonNull act act) {
        this(context, act, new ed(), new xl());
    }

    private void b(@Nullable final kn knVar) {
        if (knVar != null) {
            this.a.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.ko.1
                @Override // java.lang.Runnable
                public void run() {
                    knVar.a();
                }
            }, TimeUnit.SECONDS.toMillis(5));
        }
    }

    @Override // com.yandex.metrica.impl.ob.kp
    public void a(@Nullable Bundle bundle, @Nullable kn knVar) {
        if (bundle == null || bundle.isEmpty()) {
            a(knVar);
            return;
        }
        int i = bundle.getInt("android.bluetooth.le.extra.ERROR_CODE", Integer.MIN_VALUE);
        int i2 = bundle.getInt("android.bluetooth.le.extra.CALLBACK_TYPE", Integer.MIN_VALUE);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("android.bluetooth.le.extra.LIST_SCAN_RESULT");
        xi xiVar = this.c.a(a()).I;
        if (xiVar != null) {
            ec a3 = this.b.a(xiVar.c);
            if (i > 0) {
                a(a3, i);
            } else if (!dl.a((Collection) parcelableArrayList)) {
                if (parcelableArrayList.size() == 1) {
                    a(a3, parcelableArrayList.get(0), i2);
                } else {
                    a(a3, parcelableArrayList);
                }
            }
            b(knVar);
            return;
        }
        a(knVar);
    }

    @VisibleForTesting
    public ko(@NonNull Context context, @NonNull act act, @NonNull ed edVar, @NonNull xl xlVar) {
        super(context);
        this.a = act;
        this.b = edVar;
        this.c = xlVar;
    }

    private void a(@NonNull ec ecVar, @NonNull List<ScanResult> list) {
        ecVar.a(list);
    }

    private void a(@NonNull ec ecVar, ScanResult scanResult, int i) {
        ecVar.a(scanResult, i > 0 ? Integer.valueOf(i) : null);
    }

    private void a(ec ecVar, int i) {
        ecVar.a(i);
    }

    private void a(@Nullable kn knVar) {
        if (knVar != null) {
            knVar.a();
        }
    }
}
