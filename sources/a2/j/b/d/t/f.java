package a2.j.b.d.t;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
public class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new a();
    public final d a;
    public final d b;
    public final int c;
    public int d;
    public int e;
    public int f;
    public int g;

    public static class a implements Parcelable.Creator<f> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public f createFromParcel(Parcel parcel) {
            return new f(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public f[] newArray(int i) {
            return new f[i];
        }
    }

    public f() {
        this(0, 0, 10, 0);
    }

    public static String a(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    public int b() {
        if (this.c == 1) {
            return this.d % 24;
        }
        int i = this.d;
        if (i % 12 == 0) {
            return 12;
        }
        return this.g == 1 ? i - 12 : i;
    }

    public void c(int i) {
        if (this.c == 1) {
            this.d = i;
            return;
        }
        int i2 = 12;
        int i3 = i % 12;
        if (this.g != 1) {
            i2 = 0;
        }
        this.d = i3 + i2;
    }

    public void d(int i) {
        if (i != this.g) {
            this.g = i;
            int i2 = this.d;
            if (i2 < 12 && i == 1) {
                this.d = i2 + 12;
            } else if (i2 >= 12 && i == 0) {
                this.d = i2 - 12;
            }
        }
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
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.d == fVar.d && this.e == fVar.e && this.c == fVar.c && this.f == fVar.f) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.c);
    }

    public f(int i, int i2, int i3, int i4) {
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.c = i4;
        int i5 = 12;
        this.g = i >= 12 ? 1 : 0;
        this.a = new d(59);
        this.b = new d(i4 == 1 ? 24 : i5);
    }
}
