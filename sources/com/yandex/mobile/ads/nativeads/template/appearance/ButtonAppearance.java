package com.yandex.mobile.ads.nativeads.template.appearance;

import android.os.Parcel;
import android.os.Parcelable;
public final class ButtonAppearance implements Parcelable {
    public static final Parcelable.Creator<ButtonAppearance> CREATOR = new Parcelable.Creator<ButtonAppearance>() { // from class: com.yandex.mobile.ads.nativeads.template.appearance.ButtonAppearance.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ButtonAppearance createFromParcel(Parcel parcel) {
            return new ButtonAppearance(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ButtonAppearance[] newArray(int i) {
            return new ButtonAppearance[i];
        }
    };
    private final int a;
    private final float b;
    private final int c;
    private final int d;
    private final TextAppearance e;

    public static final class Builder {
        private int a;
        private float b;
        private int c;
        private int d;
        private TextAppearance e;

        public final ButtonAppearance build() {
            return new ButtonAppearance(this, (byte) 0);
        }

        public final Builder setBorderColor(int i) {
            this.a = i;
            return this;
        }

        public final Builder setBorderWidth(float f) {
            this.b = f;
            return this;
        }

        public final Builder setNormalColor(int i) {
            this.c = i;
            return this;
        }

        public final Builder setPressedColor(int i) {
            this.d = i;
            return this;
        }

        public final Builder setTextAppearance(TextAppearance textAppearance) {
            this.e = textAppearance;
            return this;
        }
    }

    public /* synthetic */ ButtonAppearance(Builder builder, byte b2) {
        this(builder);
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
        if (obj != null && ButtonAppearance.class == obj.getClass()) {
            ButtonAppearance buttonAppearance = (ButtonAppearance) obj;
            if (this.a != buttonAppearance.a || Float.compare(buttonAppearance.b, this.b) != 0 || this.c != buttonAppearance.c || this.d != buttonAppearance.d) {
                return false;
            }
            TextAppearance textAppearance = this.e;
            if (textAppearance == null ? buttonAppearance.e == null : textAppearance.equals(buttonAppearance.e)) {
                return true;
            }
        }
        return false;
    }

    public final int getBorderColor() {
        return this.a;
    }

    public final float getBorderWidth() {
        return this.b;
    }

    public final int getNormalColor() {
        return this.c;
    }

    public final int getPressedColor() {
        return this.d;
    }

    public final TextAppearance getTextAppearance() {
        return this.e;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        int i = this.a * 31;
        float f = this.b;
        int i2 = 0;
        int floatToIntBits = (((((i + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31) + this.c) * 31) + this.d) * 31;
        TextAppearance textAppearance = this.e;
        if (textAppearance != null) {
            i2 = textAppearance.hashCode();
        }
        return floatToIntBits + i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeFloat(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeParcelable(this.e, 0);
    }

    private ButtonAppearance(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
    }

    public ButtonAppearance(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readFloat();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = (TextAppearance) parcel.readParcelable(TextAppearance.class.getClassLoader());
    }
}
