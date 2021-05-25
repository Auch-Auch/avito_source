package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.avito.android.analytics.screens.InternalConstsKt;
import java.util.Locale;
public class am implements Parcelable {
    public static final Parcelable.Creator<am> CREATOR = new Parcelable.Creator<am>() { // from class: com.yandex.mobile.ads.impl.am.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ am createFromParcel(@NonNull Parcel parcel) {
            return new am(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ am[] newArray(int i) {
            return new am[i];
        }
    };
    private final int a;
    private final int b;
    @NonNull
    private final String c;
    @NonNull
    private final a d;

    public enum a {
        FIXED("fixed"),
        FLEXIBLE("flexible"),
        SCREEN(InternalConstsKt.SCREEN),
        STICKY("sticky");
        
        @NonNull
        private final String e;

        private a(String str) {
            this.e = str;
        }

        @NonNull
        public final String a() {
            return this.e;
        }
    }

    public am(int i, int i2, @NonNull a aVar) {
        this.a = (i >= 0 || -1 == i) ? i : 0;
        this.b = (i2 >= 0 || -2 == i2) ? i2 : 0;
        this.d = aVar;
        this.c = String.format(Locale.US, "%dx%d", Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final int c(@NonNull Context context) {
        int i = this.b;
        if (-2 == i) {
            return eg.b(context);
        }
        return dv.a(context, (float) i);
    }

    public final int d(@NonNull Context context) {
        int i = this.a;
        if (-1 == i) {
            return eg.a(context);
        }
        return dv.a(context, (float) i);
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
        if (obj != null && getClass() == obj.getClass()) {
            am amVar = (am) obj;
            if (this.a == amVar.a && this.b == amVar.b && this.d == amVar.d) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.d.hashCode() + a2.b.a.a.a.B0(this.c, ((this.a * 31) + this.b) * 31, 31);
    }

    @Override // java.lang.Object
    public String toString() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.d.ordinal());
        parcel.writeString(this.c);
    }

    public final int a(@NonNull Context context) {
        int i = this.b;
        return -2 == i ? eg.d(context) : i;
    }

    public final int b(@NonNull Context context) {
        int i = this.a;
        return -1 == i ? eg.c(context) : i;
    }

    @NonNull
    public final a c() {
        return this.d;
    }

    public am(@NonNull Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.d = a.values()[parcel.readInt()];
        this.c = parcel.readString();
    }
}
