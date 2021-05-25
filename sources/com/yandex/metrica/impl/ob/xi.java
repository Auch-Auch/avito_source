package com.yandex.metrica.impl.ob;

import android.os.ParcelUuid;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
public class xi {
    @NonNull
    public final b a;
    @NonNull
    public final List<a> b;
    public final long c;
    public final long d;

    public static class a {
        @Nullable
        public final String a;
        @Nullable
        public final String b;
        @Nullable
        public final C0363a c;
        @Nullable
        public final b d;
        @Nullable
        public final c e;

        /* renamed from: com.yandex.metrica.impl.ob.xi$a$a  reason: collision with other inner class name */
        public static class C0363a {
            public final int a;
            @Nullable
            public final byte[] b;
            @Nullable
            public final byte[] c;

            public C0363a(int i, @Nullable byte[] bArr, @Nullable byte[] bArr2) {
                this.a = i;
                this.b = bArr;
                this.c = bArr2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                C0363a aVar = (C0363a) obj;
                if (this.a == aVar.a && Arrays.equals(this.b, aVar.b)) {
                    return Arrays.equals(this.c, aVar.c);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = Arrays.hashCode(this.b);
                return Arrays.hashCode(this.c) + ((hashCode + (this.a * 31)) * 31);
            }

            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("ManufacturerData{manufacturerId=");
                L.append(this.a);
                L.append(", data=");
                L.append(Arrays.toString(this.b));
                L.append(", dataMask=");
                L.append(Arrays.toString(this.c));
                L.append('}');
                return L.toString();
            }
        }

        public static class b {
            @NonNull
            public final ParcelUuid a;
            @Nullable
            public final byte[] b;
            @Nullable
            public final byte[] c;

            public b(@NonNull String str, @Nullable byte[] bArr, @Nullable byte[] bArr2) {
                this.a = ParcelUuid.fromString(str);
                this.b = bArr;
                this.c = bArr2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                b bVar = (b) obj;
                if (this.a.equals(bVar.a) && Arrays.equals(this.b, bVar.b)) {
                    return Arrays.equals(this.c, bVar.c);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = Arrays.hashCode(this.b);
                return Arrays.hashCode(this.c) + ((hashCode + (this.a.hashCode() * 31)) * 31);
            }

            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("ServiceData{uuid=");
                L.append(this.a);
                L.append(", data=");
                L.append(Arrays.toString(this.b));
                L.append(", dataMask=");
                L.append(Arrays.toString(this.c));
                L.append('}');
                return L.toString();
            }
        }

        public static class c {
            @NonNull
            public final ParcelUuid a;
            @Nullable
            public final ParcelUuid b;

            public c(@NonNull ParcelUuid parcelUuid, @Nullable ParcelUuid parcelUuid2) {
                this.a = parcelUuid;
                this.b = parcelUuid2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                c cVar = (c) obj;
                if (!this.a.equals(cVar.a)) {
                    return false;
                }
                ParcelUuid parcelUuid = this.b;
                ParcelUuid parcelUuid2 = cVar.b;
                if (parcelUuid != null) {
                    return parcelUuid.equals(parcelUuid2);
                }
                if (parcelUuid2 == null) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                int hashCode = this.a.hashCode() * 31;
                ParcelUuid parcelUuid = this.b;
                return hashCode + (parcelUuid != null ? parcelUuid.hashCode() : 0);
            }

            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("ServiceUuid{uuid=");
                L.append(this.a);
                L.append(", uuidMask=");
                L.append(this.b);
                L.append('}');
                return L.toString();
            }
        }

        public a(@Nullable String str, @Nullable String str2, @Nullable C0363a aVar, @Nullable b bVar, @Nullable c cVar) {
            this.a = str;
            this.b = str2;
            this.c = aVar;
            this.d = bVar;
            this.e = cVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            String str = this.a;
            if (str == null ? aVar.a != null : !str.equals(aVar.a)) {
                return false;
            }
            String str2 = this.b;
            if (str2 == null ? aVar.b != null : !str2.equals(aVar.b)) {
                return false;
            }
            C0363a aVar2 = this.c;
            if (aVar2 == null ? aVar.c != null : !aVar2.equals(aVar.c)) {
                return false;
            }
            b bVar = this.d;
            if (bVar == null ? aVar.d != null : !bVar.equals(aVar.d)) {
                return false;
            }
            c cVar = this.e;
            c cVar2 = aVar.e;
            if (cVar != null) {
                return cVar.equals(cVar2);
            }
            if (cVar2 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            C0363a aVar = this.c;
            int hashCode3 = (hashCode2 + (aVar != null ? aVar.hashCode() : 0)) * 31;
            b bVar = this.d;
            int hashCode4 = (hashCode3 + (bVar != null ? bVar.hashCode() : 0)) * 31;
            c cVar = this.e;
            if (cVar != null) {
                i = cVar.hashCode();
            }
            return hashCode4 + i;
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Filter{deviceAddress='");
            a2.b.a.a.a.k1(L, this.a, '\'', ", deviceName='");
            a2.b.a.a.a.k1(L, this.b, '\'', ", data=");
            L.append(this.c);
            L.append(", serviceData=");
            L.append(this.d);
            L.append(", serviceUuid=");
            L.append(this.e);
            L.append('}');
            return L.toString();
        }
    }

    public static class b {
        @NonNull
        public final a a;
        @NonNull
        public final EnumC0364b b;
        @NonNull
        public final c c;
        @NonNull
        public final d d;
        public final long e;

        public enum a {
            ALL_MATCHES,
            FIRST_MATCH,
            MATCH_LOST
        }

        /* renamed from: com.yandex.metrica.impl.ob.xi$b$b  reason: collision with other inner class name */
        public enum EnumC0364b {
            AGGRESSIVE,
            STICKY
        }

        public enum c {
            ONE_AD,
            FEW_AD,
            MAX_AD
        }

        public enum d {
            LOW_POWER,
            BALANCED,
            LOW_LATENCY
        }

        public b(@NonNull a aVar, @NonNull EnumC0364b bVar, @NonNull c cVar, @NonNull d dVar, long j) {
            this.a = aVar;
            this.b = bVar;
            this.c = cVar;
            this.d = dVar;
            this.e = j;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.e == bVar.e && this.a == bVar.a && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.b.hashCode();
            int hashCode2 = this.c.hashCode();
            int hashCode3 = this.d.hashCode();
            long j = this.e;
            return ((hashCode3 + ((hashCode2 + ((hashCode + (this.a.hashCode() * 31)) * 31)) * 31)) * 31) + ((int) (j ^ (j >>> 32)));
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Settings{callbackType=");
            L.append(this.a);
            L.append(", matchMode=");
            L.append(this.b);
            L.append(", numOfMatches=");
            L.append(this.c);
            L.append(", scanMode=");
            L.append(this.d);
            L.append(", reportDelay=");
            return a2.b.a.a.a.k(L, this.e, '}');
        }
    }

    public xi(@NonNull b bVar, @NonNull List<a> list, long j, long j2) {
        this.a = bVar;
        this.b = list;
        this.c = j;
        this.d = j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        xi xiVar = (xi) obj;
        if (this.c == xiVar.c && this.d == xiVar.d && this.a.equals(xiVar.a)) {
            return this.b.equals(xiVar.b);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.b.hashCode();
        long j = this.c;
        long j2 = this.d;
        return ((((hashCode + (this.a.hashCode() * 31)) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("BleCollectingConfig{settings=");
        L.append(this.a);
        L.append(", scanFilters=");
        L.append(this.b);
        L.append(", sameBeaconMinReportingInterval=");
        L.append(this.c);
        L.append(", firstDelay=");
        return a2.b.a.a.a.k(L, this.d, '}');
    }
}
