package com.yandex.mobile.ads.nativeads.template;

import android.os.Parcel;
import android.os.Parcelable;
public final class HorizontalOffset implements Parcelable {
    public static final Parcelable.Creator<HorizontalOffset> CREATOR = new Parcelable.Creator<HorizontalOffset>() { // from class: com.yandex.mobile.ads.nativeads.template.HorizontalOffset.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ HorizontalOffset createFromParcel(Parcel parcel) {
            return new HorizontalOffset(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ HorizontalOffset[] newArray(int i) {
            return new HorizontalOffset[i];
        }
    };
    private final float a;
    private final float b;

    public HorizontalOffset(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && HorizontalOffset.class == obj.getClass()) {
            HorizontalOffset horizontalOffset = (HorizontalOffset) obj;
            if (Float.compare(horizontalOffset.a, this.a) == 0 && Float.compare(horizontalOffset.b, this.b) == 0) {
                return true;
            }
        }
        return false;
    }

    public final float getLeft() {
        return this.a;
    }

    public final float getRight() {
        return this.b;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        float f = this.a;
        int i = 0;
        int floatToIntBits = (f != 0.0f ? Float.floatToIntBits(f) : 0) * 31;
        float f2 = this.b;
        if (f2 != 0.0f) {
            i = Float.floatToIntBits(f2);
        }
        return floatToIntBits + i;
    }

    @Override // java.lang.Object
    public final String toString() {
        return this.a + ", " + this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.a);
        parcel.writeFloat(this.b);
    }

    public HorizontalOffset(Parcel parcel) {
        this.a = parcel.readFloat();
        this.b = parcel.readFloat();
    }
}
