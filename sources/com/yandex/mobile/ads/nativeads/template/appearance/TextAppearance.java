package com.yandex.mobile.ads.nativeads.template.appearance;

import android.os.Parcel;
import android.os.Parcelable;
public final class TextAppearance implements Parcelable {
    public static final Parcelable.Creator<TextAppearance> CREATOR = new Parcelable.Creator<TextAppearance>() { // from class: com.yandex.mobile.ads.nativeads.template.appearance.TextAppearance.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TextAppearance createFromParcel(Parcel parcel) {
            return new TextAppearance(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TextAppearance[] newArray(int i) {
            return new TextAppearance[i];
        }
    };
    private final int a;
    private final float b;
    private final String c;
    private final int d;

    public static final class Builder {
        private int a;
        private float b;
        private String c;
        private int d;

        public final TextAppearance build() {
            return new TextAppearance(this, (byte) 0);
        }

        public final Builder setFontFamilyName(String str) {
            this.c = str;
            return this;
        }

        public final Builder setFontStyle(int i) {
            this.d = i;
            return this;
        }

        public final Builder setTextColor(int i) {
            this.a = i;
            return this;
        }

        public final Builder setTextSize(float f) {
            this.b = f;
            return this;
        }
    }

    public /* synthetic */ TextAppearance(Builder builder, byte b2) {
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
        if (obj != null && TextAppearance.class == obj.getClass()) {
            TextAppearance textAppearance = (TextAppearance) obj;
            if (this.a != textAppearance.a || Float.compare(textAppearance.b, this.b) != 0 || this.d != textAppearance.d) {
                return false;
            }
            String str = this.c;
            if (str == null ? textAppearance.c == null : str.equals(textAppearance.c)) {
                return true;
            }
        }
        return false;
    }

    public final String getFontFamilyName() {
        return this.c;
    }

    public final int getFontStyle() {
        return this.d;
    }

    public final int getTextColor() {
        return this.a;
    }

    public final float getTextSize() {
        return this.b;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        int i = this.a * 31;
        float f = this.b;
        int i2 = 0;
        int floatToIntBits = (i + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
        String str = this.c;
        if (str != null) {
            i2 = str.hashCode();
        }
        return ((floatToIntBits + i2) * 31) + this.d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeFloat(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
    }

    private TextAppearance(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
    }

    public TextAppearance(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readFloat();
        this.c = parcel.readString();
        this.d = parcel.readInt();
    }
}
