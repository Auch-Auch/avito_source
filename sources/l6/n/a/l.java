package l6.n.a;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
@SuppressLint({"BanParcelableUsage"})
public final class l implements Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new a();
    public ArrayList<n> a;
    public ArrayList<String> b;
    public b[] c;
    public int d;
    public String e = null;

    public static class a implements Parcelable.Creator<l> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public l createFromParcel(Parcel parcel) {
            return new l(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public l[] newArray(int i) {
            return new l[i];
        }
    }

    public l() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.a);
        parcel.writeStringList(this.b);
        parcel.writeTypedArray(this.c, i);
        parcel.writeInt(this.d);
        parcel.writeString(this.e);
    }

    public l(Parcel parcel) {
        this.a = parcel.createTypedArrayList(n.CREATOR);
        this.b = parcel.createStringArrayList();
        this.c = (b[]) parcel.createTypedArray(b.CREATOR);
        this.d = parcel.readInt();
        this.e = parcel.readString();
    }
}
