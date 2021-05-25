package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
public class aap implements Parcelable {
    public static final Parcelable.Creator<aap> CREATOR = new Parcelable.Creator<aap>() { // from class: com.yandex.metrica.impl.ob.aap.1
        /* renamed from: a */
        public aap createFromParcel(Parcel parcel) {
            return new aap(parcel);
        }

        /* renamed from: a */
        public aap[] newArray(int i) {
            return new aap[i];
        }
    };
    public final int a;
    public final int b;
    public final int c;
    public final long d;
    public final boolean e;

    public aap(int i, int i2, int i3, long j, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = j;
        this.e = z;
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
        aap aap = (aap) obj;
        if (this.a == aap.a && this.b == aap.b && this.c == aap.c && this.d == aap.d && this.e == aap.e) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        long j = this.d;
        return (((((((this.a * 31) + this.b) * 31) + this.c) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + (this.e ? 1 : 0);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder L = a.L("UiParsingConfig{tooLongTextBound=");
        L.append(this.a);
        L.append(", truncatedTextBound=");
        L.append(this.b);
        L.append(", maxVisitedChildrenInLevel=");
        L.append(this.c);
        L.append(", afterCreateTimeout=");
        L.append(this.d);
        L.append(", relativeTextSizeCalculation=");
        return a.A(L, this.e, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeLong(this.d);
        parcel.writeByte(this.e ? (byte) 1 : 0);
    }

    public aap(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readLong();
        this.e = parcel.readByte() != 0;
    }
}
