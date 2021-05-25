package androidx.core.os;

import android.os.Parcel;
import android.os.Parcelable;
@Deprecated
public final class ParcelableCompat {

    public static class a<T> implements Parcelable.ClassLoaderCreator<T> {
        public final ParcelableCompatCreatorCallbacks<T> a;

        public a(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
            this.a = parcelableCompatCreatorCallbacks;
        }

        @Override // android.os.Parcelable.Creator
        public T createFromParcel(Parcel parcel) {
            return this.a.createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public T[] newArray(int i) {
            return this.a.newArray(i);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return this.a.createFromParcel(parcel, classLoader);
        }
    }

    @Deprecated
    public static <T> Parcelable.Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        return new a(parcelableCompatCreatorCallbacks);
    }
}
