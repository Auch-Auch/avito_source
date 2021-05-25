package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
public class aag implements Parcelable {
    public static final Parcelable.Creator<aag> CREATOR = new Parcelable.Creator<aag>() { // from class: com.yandex.metrica.impl.ob.aag.1
        /* renamed from: a */
        public aag createFromParcel(Parcel parcel) {
            return new aag(parcel);
        }

        /* renamed from: a */
        public aag[] newArray(int i) {
            return new aag[i];
        }
    };
    public final boolean a;
    public final boolean b;
    public final boolean c;
    @Nullable
    public final aap d;
    @Nullable
    public final aah e;
    @Nullable
    public final aah f;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public aag(@android.support.annotation.NonNull com.yandex.metrica.impl.ob.yb r9) {
        /*
            r8 = this;
            com.yandex.metrica.impl.ob.xk r0 = r9.o
            boolean r2 = r0.l
            boolean r3 = r0.n
            boolean r4 = r0.m
            com.yandex.metrica.impl.ob.aap r5 = r9.J
            com.yandex.metrica.impl.ob.aah r6 = r9.K
            com.yandex.metrica.impl.ob.aah r7 = r9.L
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.aag.<init>(com.yandex.metrica.impl.ob.yb):void");
    }

    public boolean a() {
        return (this.d == null || this.e == null || this.f == null) ? false : true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        aag aag = (aag) obj;
        if (this.a != aag.a || this.b != aag.b || this.c != aag.c) {
            return false;
        }
        aap aap = this.d;
        if (aap == null ? aag.d != null : !aap.equals(aag.d)) {
            return false;
        }
        aah aah = this.e;
        if (aah == null ? aag.e != null : !aah.equals(aag.e)) {
            return false;
        }
        aah aah2 = this.f;
        if (aah2 != null) {
            return aah2.equals(aag.f);
        }
        if (aag.f == null) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = (((((this.a ? 1 : 0) * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31;
        aap aap = this.d;
        int i2 = 0;
        int hashCode = (i + (aap != null ? aap.hashCode() : 0)) * 31;
        aah aah = this.e;
        int hashCode2 = (hashCode + (aah != null ? aah.hashCode() : 0)) * 31;
        aah aah2 = this.f;
        if (aah2 != null) {
            i2 = aah2.hashCode();
        }
        return hashCode2 + i2;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder L = a.L("UiAccessConfig{uiParsingEnabled=");
        L.append(this.a);
        L.append(", uiEventSendingEnabled=");
        L.append(this.b);
        L.append(", uiCollectingForBridgeEnabled=");
        L.append(this.c);
        L.append(", uiParsingConfig=");
        L.append(this.d);
        L.append(", uiEventSendingConfig=");
        L.append(this.e);
        L.append(", uiCollectingForBridgeConfig=");
        L.append(this.f);
        L.append('}');
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.a ? (byte) 1 : 0);
        parcel.writeByte(this.b ? (byte) 1 : 0);
        parcel.writeByte(this.c ? (byte) 1 : 0);
        parcel.writeParcelable(this.d, i);
        parcel.writeParcelable(this.e, i);
        parcel.writeParcelable(this.f, i);
    }

    public aag(boolean z, boolean z2, boolean z3, @Nullable aap aap, @Nullable aah aah, @Nullable aah aah2) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = aap;
        this.e = aah;
        this.f = aah2;
    }

    public aag(Parcel parcel) {
        boolean z = true;
        this.a = parcel.readByte() != 0;
        this.b = parcel.readByte() != 0;
        this.c = parcel.readByte() == 0 ? false : z;
        this.d = (aap) parcel.readParcelable(aap.class.getClassLoader());
        this.e = (aah) parcel.readParcelable(aah.class.getClassLoader());
        this.f = (aah) parcel.readParcelable(aah.class.getClassLoader());
    }
}
