package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
public class aah implements Parcelable {
    public static final Parcelable.Creator<aah> CREATOR = new Parcelable.Creator<aah>() { // from class: com.yandex.metrica.impl.ob.aah.1
        /* renamed from: a */
        public aah createFromParcel(Parcel parcel) {
            return new aah(parcel);
        }

        /* renamed from: a */
        public aah[] newArray(int i2) {
            return new aah[i2];
        }
    };
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;

    public aah(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z7, boolean z8, int i2, int i3, int i4, int i5) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
        this.f = z7;
        this.g = z8;
        this.h = i2;
        this.i = i3;
        this.j = i4;
        this.k = i5;
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
        aah aah = (aah) obj;
        if (this.a == aah.a && this.b == aah.b && this.c == aah.c && this.d == aah.d && this.e == aah.e && this.f == aah.f && this.g == aah.g && this.h == aah.h && this.i == aah.i && this.j == aah.j && this.k == aah.k) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((((((((((((((((((((this.a ? 1 : 0) * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + this.h) * 31) + this.i) * 31) + this.j) * 31) + this.k;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder L = a.L("UiCollectingConfig{textSizeCollecting=");
        L.append(this.a);
        L.append(", relativeTextSizeCollecting=");
        L.append(this.b);
        L.append(", textVisibilityCollecting=");
        L.append(this.c);
        L.append(", textStyleCollecting=");
        L.append(this.d);
        L.append(", infoCollecting=");
        L.append(this.e);
        L.append(", nonContentViewCollecting=");
        L.append(this.f);
        L.append(", textLengthCollecting=");
        L.append(this.g);
        L.append(", tooLongTextBound=");
        L.append(this.h);
        L.append(", truncatedTextBound=");
        L.append(this.i);
        L.append(", maxEntitiesCount=");
        L.append(this.j);
        L.append(", maxFullContentLength=");
        return a.i(L, this.k, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.a ? (byte) 1 : 0);
        parcel.writeByte(this.b ? (byte) 1 : 0);
        parcel.writeByte(this.c ? (byte) 1 : 0);
        parcel.writeByte(this.d ? (byte) 1 : 0);
        parcel.writeByte(this.e ? (byte) 1 : 0);
        parcel.writeByte(this.f ? (byte) 1 : 0);
        parcel.writeByte(this.g ? (byte) 1 : 0);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
    }

    public aah(Parcel parcel) {
        boolean z = true;
        this.a = parcel.readByte() != 0;
        this.b = parcel.readByte() != 0;
        this.c = parcel.readByte() != 0;
        this.d = parcel.readByte() != 0;
        this.e = parcel.readByte() != 0;
        this.f = parcel.readByte() != 0;
        this.g = parcel.readByte() == 0 ? false : z;
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readInt();
    }
}
