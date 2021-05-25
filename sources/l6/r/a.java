package l6.r;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavBackStackEntry;
import java.util.UUID;
@SuppressLint({"BanParcelableUsage"})
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0534a();
    public final UUID a;
    public final int b;
    public final Bundle c;
    public final Bundle d;

    /* renamed from: l6.r.a$a  reason: collision with other inner class name */
    public static class C0534a implements Parcelable.Creator<a> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public a[] newArray(int i) {
            return new a[i];
        }
    }

    public a(NavBackStackEntry navBackStackEntry) {
        this.a = navBackStackEntry.f;
        this.b = navBackStackEntry.getDestination().getId();
        this.c = navBackStackEntry.getArguments();
        Bundle bundle = new Bundle();
        this.d = bundle;
        navBackStackEntry.e.performSave(bundle);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.a.toString());
        parcel.writeInt(this.b);
        parcel.writeBundle(this.c);
        parcel.writeBundle(this.d);
    }

    public a(Parcel parcel) {
        this.a = UUID.fromString(parcel.readString());
        this.b = parcel.readInt();
        this.c = parcel.readBundle(a.class.getClassLoader());
        this.d = parcel.readBundle(a.class.getClassLoader());
    }
}
