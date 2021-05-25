package com.yandex.mobile.ads.nativeads.template;

import android.os.Parcel;
import android.os.Parcelable;
public final class SizeConstraint implements Parcelable {
    public static final Parcelable.Creator<SizeConstraint> CREATOR = new Parcelable.Creator<SizeConstraint>() { // from class: com.yandex.mobile.ads.nativeads.template.SizeConstraint.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SizeConstraint createFromParcel(Parcel parcel) {
            return new SizeConstraint(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SizeConstraint[] newArray(int i) {
            return new SizeConstraint[i];
        }
    };
    private final float a;
    private final SizeConstraintType b;

    public enum SizeConstraintType {
        FIXED,
        FIXED_RATIO,
        PREFERRED_RATIO
    }

    public SizeConstraint(SizeConstraintType sizeConstraintType, float f) {
        this.b = sizeConstraintType;
        this.a = f;
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
        if (obj != null && SizeConstraint.class == obj.getClass()) {
            SizeConstraint sizeConstraint = (SizeConstraint) obj;
            if (Float.compare(sizeConstraint.a, this.a) == 0 && this.b == sizeConstraint.b) {
                return true;
            }
        }
        return false;
    }

    public final SizeConstraintType getSizeConstraintType() {
        return this.b;
    }

    public final float getValue() {
        return this.a;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        float f = this.a;
        int i = 0;
        int floatToIntBits = (f != 0.0f ? Float.floatToIntBits(f) : 0) * 31;
        SizeConstraintType sizeConstraintType = this.b;
        if (sizeConstraintType != null) {
            i = sizeConstraintType.hashCode();
        }
        return floatToIntBits + i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.a);
        SizeConstraintType sizeConstraintType = this.b;
        parcel.writeInt(sizeConstraintType == null ? -1 : sizeConstraintType.ordinal());
    }

    public SizeConstraint(Parcel parcel) {
        SizeConstraintType sizeConstraintType;
        this.a = parcel.readFloat();
        int readInt = parcel.readInt();
        if (readInt == -1) {
            sizeConstraintType = null;
        } else {
            sizeConstraintType = SizeConstraintType.values()[readInt];
        }
        this.b = sizeConstraintType;
    }
}
