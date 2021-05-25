package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.ScanFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.xi;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
@TargetApi(21)
public class dy {
    @NonNull
    public List<ScanFilter> a(@NonNull List<xi.a> list) {
        ArrayList arrayList = new ArrayList();
        for (xi.a aVar : list) {
            ScanFilter a = a(aVar);
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    @Nullable
    private ScanFilter a(@NonNull xi.a aVar) {
        boolean z;
        boolean z2;
        boolean z3;
        ScanFilter.Builder builder = new ScanFilter.Builder();
        boolean z4 = true;
        boolean z5 = false;
        if (!TextUtils.isEmpty(aVar.b)) {
            builder.setDeviceName(aVar.b);
            z = false;
        } else {
            z = true;
        }
        if (!TextUtils.isEmpty(aVar.a) && BluetoothAdapter.checkBluetoothAddress(aVar.a.toUpperCase(Locale.US))) {
            builder.setDeviceAddress(aVar.a);
            z = false;
        }
        xi.a.C0363a aVar2 = aVar.c;
        if (aVar2 != null) {
            z3 = a(builder, aVar2);
            z2 = false;
        } else {
            z2 = z;
            z3 = true;
        }
        xi.a.b bVar = aVar.d;
        if (bVar != null) {
            if (!z3 || !a(builder, bVar)) {
                z4 = false;
            }
            z3 = z4;
            z2 = false;
        }
        xi.a.c cVar = aVar.e;
        if (cVar != null) {
            builder.setServiceUuid(cVar.a, cVar.b);
        } else {
            z5 = z2;
        }
        if (!z3 || z5) {
            return null;
        }
        return builder.build();
    }

    private boolean a(@NonNull ScanFilter.Builder builder, @NonNull xi.a.C0363a aVar) {
        if (aVar.a < 0) {
            return false;
        }
        byte[] bArr = aVar.b;
        if ((bArr == null && aVar.c != null) || a(bArr, aVar.c)) {
            return false;
        }
        builder.setManufacturerData(aVar.a, aVar.b, aVar.c);
        return true;
    }

    private boolean a(@NonNull ScanFilter.Builder builder, @NonNull xi.a.b bVar) {
        if (bVar.a == null) {
            return false;
        }
        byte[] bArr = bVar.b;
        if ((bArr == null && bVar.c != null) || a(bArr, bVar.c)) {
            return false;
        }
        builder.setServiceData(bVar.a, bVar.b, bVar.c);
        return true;
    }

    private boolean a(byte[] bArr, byte[] bArr2) {
        return (bArr == null || bArr2 == null || bArr.length == bArr2.length) ? false : true;
    }
}
