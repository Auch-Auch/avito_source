package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.bluetooth.le.ScanResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.util.LruCache;
import com.yandex.metrica.d;
import java.util.Iterator;
import java.util.List;
@TargetApi(21)
public class ec {
    @NonNull
    private final dz a;
    @NonNull
    private final LruCache<String, Long> b;
    @NonNull
    private final abt c;
    private final long d;

    public ec(long j) {
        this(j, new dz(), new abs());
    }

    private boolean b(@NonNull ScanResult scanResult, @Nullable Integer num) {
        try {
            if (!a(scanResult)) {
                return false;
            }
            a().reportEvent("beacon_scan_result", this.a.a(scanResult, num).toString());
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(int i) {
        try {
            xa.a().reportEvent("beacon_scan_error", this.a.a(i).toString());
        } catch (Throwable unused) {
        }
    }

    @VisibleForTesting
    public ec(long j, @NonNull dz dzVar, @NonNull abt abt) {
        this.d = j;
        this.a = dzVar;
        this.c = abt;
        this.b = new LruCache<>(1000);
    }

    public void a(@NonNull List<ScanResult> list) {
        boolean z;
        Iterator<ScanResult> it = list.iterator();
        loop0:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                } else if (b(it.next(), null) || z) {
                    z = true;
                }
            }
        }
        if (z) {
            a().sendEventsBuffer();
        }
    }

    public void a(@NonNull ScanResult scanResult, @Nullable Integer num) {
        if (b(scanResult, num)) {
            a().sendEventsBuffer();
        }
    }

    private d a() {
        return xa.a();
    }

    private boolean a(@NonNull ScanResult scanResult) {
        boolean z = false;
        if (scanResult.getDevice() != null) {
            String address = scanResult.getDevice().getAddress();
            long a3 = this.c.a();
            if (!TextUtils.isEmpty(address)) {
                Long l = this.b.get(address);
                if (l == null || a3 - l.longValue() > this.d) {
                    z = true;
                }
                if (z) {
                    this.b.put(address, Long.valueOf(a3));
                }
            }
        }
        return z;
    }
}
