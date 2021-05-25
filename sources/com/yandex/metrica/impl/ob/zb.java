package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrength;
import java.util.concurrent.TimeUnit;
public class zb {
    @Nullable
    private Integer a;
    @Nullable
    private final Integer b;
    @Nullable
    private final Integer c;
    @Nullable
    private final Integer d;
    @Nullable
    private final Integer e;
    @Nullable
    private final String f;
    @Nullable
    private final String g;
    private final boolean h;
    private final int i;
    @Nullable
    private final Integer j;
    @Nullable
    private final Long k;

    @TargetApi(17)
    public static class a extends b {
        @Override // com.yandex.metrica.impl.ob.zb.b
        public zb a(CellInfo cellInfo) {
            CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
            return a(null, null, cellInfoCdma.getCellSignalStrength(), null, null, cellInfoCdma.isRegistered(), 2, null, cellInfoCdma.getTimeStamp());
        }
    }

    @TargetApi(17)
    public static abstract class b {
        @NonNull
        private final abr a;

        public b() {
            this(new abr());
        }

        public abstract zb a(CellInfo cellInfo);

        @TargetApi(17)
        public zb a(@Nullable Integer num, @Nullable Integer num2, @Nullable CellSignalStrength cellSignalStrength, @Nullable Integer num3, @Nullable Integer num4, boolean z, int i, @Nullable Integer num5, long j) {
            Integer a3 = a(num, Integer.MAX_VALUE);
            Integer a4 = a(num2, Integer.MAX_VALUE);
            return new zb(a(num4, Integer.MAX_VALUE), a(num3, Integer.MAX_VALUE), a4, a3, null, null, cellSignalStrength != null ? a(Integer.valueOf(cellSignalStrength.getDbm()), Integer.MAX_VALUE) : null, z, i, a(num5, Integer.MAX_VALUE), a(j));
        }

        @VisibleForTesting
        public b(@NonNull abr abr) {
            this.a = abr;
        }

        @Nullable
        private Integer a(@Nullable Integer num, int i) {
            if (num == null || num.intValue() == i) {
                return null;
            }
            return num;
        }

        @Nullable
        private Long a(long j) {
            Long l = null;
            if (j <= 0) {
                return null;
            }
            abr abr = this.a;
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            long d = abr.d(j, timeUnit);
            if (d > 0 && d < TimeUnit.HOURS.toSeconds(1)) {
                l = Long.valueOf(d);
            }
            if (l != null) {
                return l;
            }
            long a3 = this.a.a(j, timeUnit);
            return (a3 <= 0 || a3 >= TimeUnit.HOURS.toSeconds(1)) ? l : Long.valueOf(a3);
        }
    }

    @TargetApi(17)
    public static class c extends b {
        @Override // com.yandex.metrica.impl.ob.zb.b
        public zb a(CellInfo cellInfo) {
            CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
            CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
            return a(Integer.valueOf(cellIdentity.getCid()), Integer.valueOf(cellIdentity.getLac()), cellInfoGsm.getCellSignalStrength(), Integer.valueOf(cellIdentity.getMnc()), Integer.valueOf(cellIdentity.getMcc()), cellInfoGsm.isRegistered(), 1, null, cellInfoGsm.getTimeStamp());
        }
    }

    @TargetApi(17)
    public static class d extends b {
        @Override // com.yandex.metrica.impl.ob.zb.b
        public zb a(CellInfo cellInfo) {
            CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
            CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
            return a(Integer.valueOf(cellIdentity.getCi()), Integer.valueOf(cellIdentity.getTac()), cellInfoLte.getCellSignalStrength(), Integer.valueOf(cellIdentity.getMnc()), Integer.valueOf(cellIdentity.getMcc()), cellInfoLte.isRegistered(), 4, Integer.valueOf(cellIdentity.getPci()), cellInfoLte.getTimeStamp());
        }
    }

    @TargetApi(18)
    public static class e extends b {
        @Override // com.yandex.metrica.impl.ob.zb.b
        public zb a(CellInfo cellInfo) {
            CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
            CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
            return a(Integer.valueOf(cellIdentity.getCid()), Integer.valueOf(cellIdentity.getLac()), cellInfoWcdma.getCellSignalStrength(), Integer.valueOf(cellIdentity.getMnc()), Integer.valueOf(cellIdentity.getMcc()), cellInfoWcdma.isRegistered(), 3, Integer.valueOf(cellIdentity.getPsc()), cellInfoWcdma.getTimeStamp());
        }
    }

    public zb(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable String str, @Nullable String str2, @Nullable Integer num5, boolean z, int i2, @Nullable Integer num6, @Nullable Long l) {
        this.b = num;
        this.c = num2;
        this.d = num3;
        this.e = num4;
        this.f = str;
        this.g = str2;
        this.a = num5;
        this.h = z;
        this.i = i2;
        this.j = num6;
        this.k = l;
    }

    @TargetApi(17)
    public static zb a(CellInfo cellInfo) {
        b b2 = b(cellInfo);
        if (b2 == null) {
            return null;
        }
        return b2.a(cellInfo);
    }

    @TargetApi(17)
    public static b b(CellInfo cellInfo) {
        if (cellInfo instanceof CellInfoGsm) {
            return new c();
        }
        if (cellInfo instanceof CellInfoCdma) {
            return new a();
        }
        if (cellInfo instanceof CellInfoLte) {
            return new d();
        }
        if (!dl.a(18) || !(cellInfo instanceof CellInfoWcdma)) {
            return null;
        }
        return new e();
    }

    @Nullable
    public Integer c() {
        return this.c;
    }

    @Nullable
    public Integer d() {
        return this.d;
    }

    @Nullable
    public Integer e() {
        return this.e;
    }

    @Nullable
    public String f() {
        return this.f;
    }

    @Nullable
    public String g() {
        return this.g;
    }

    public boolean h() {
        return this.h;
    }

    public int i() {
        return this.i;
    }

    @Nullable
    public Integer j() {
        return this.j;
    }

    @Nullable
    public Long k() {
        return this.k;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("CellDescription{mSignalStrength=");
        L.append(this.a);
        L.append(", mMobileCountryCode=");
        L.append(this.b);
        L.append(", mMobileNetworkCode=");
        L.append(this.c);
        L.append(", mLocationAreaCode=");
        L.append(this.d);
        L.append(", mCellId=");
        L.append(this.e);
        L.append(", mOperatorName='");
        a2.b.a.a.a.k1(L, this.f, '\'', ", mNetworkType='");
        a2.b.a.a.a.k1(L, this.g, '\'', ", mConnected=");
        L.append(this.h);
        L.append(", mCellType=");
        L.append(this.i);
        L.append(", mPci=");
        L.append(this.j);
        L.append(", mLastVisibleTimeOffset=");
        L.append(this.k);
        L.append('}');
        return L.toString();
    }

    @Nullable
    public Integer a() {
        return this.a;
    }

    public void a(@Nullable Integer num) {
        this.a = num;
    }

    @Nullable
    public Integer b() {
        return this.b;
    }
}
