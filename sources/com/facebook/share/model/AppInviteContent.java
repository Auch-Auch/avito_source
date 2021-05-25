package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
@Deprecated
public final class AppInviteContent implements ShareModel {
    @Deprecated
    public static final Parcelable.Creator<AppInviteContent> CREATOR = new a();
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final Builder.Destination e;

    @Deprecated
    public static class Builder implements ShareModelBuilder<AppInviteContent, Builder> {
        public String a;
        public String b;
        public String c;
        public String d;
        public Destination e;

        @Deprecated
        public enum Destination {
            FACEBOOK("facebook"),
            MESSENGER("messenger");
            
            public final String a;

            /* access modifiers changed from: public */
            Destination(String str) {
                this.a = str;
            }

            public boolean equalsName(String str) {
                if (str == null) {
                    return false;
                }
                return this.a.equals(str);
            }

            @Override // java.lang.Enum, java.lang.Object
            public String toString() {
                return this.a;
            }
        }

        public final boolean a(String str) {
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (!(Character.isDigit(charAt) || Character.isLetter(charAt) || Character.isSpaceChar(charAt))) {
                    return false;
                }
            }
            return true;
        }

        @Deprecated
        public Builder setApplinkUrl(String str) {
            this.a = str;
            return this;
        }

        @Deprecated
        public Builder setDestination(Destination destination) {
            this.e = destination;
            return this;
        }

        @Deprecated
        public Builder setPreviewImageUrl(String str) {
            this.b = str;
            return this;
        }

        @Deprecated
        public Builder setPromotionDetails(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (str.length() > 80) {
                    throw new IllegalArgumentException("Invalid promotion text, promotionText needs to be between1 and 80 characters long");
                } else if (!a(str)) {
                    throw new IllegalArgumentException("Invalid promotion text, promotionText can only contain alphanumericcharacters and spaces.");
                } else if (!TextUtils.isEmpty(str2)) {
                    if (str2.length() > 10) {
                        throw new IllegalArgumentException("Invalid promotion code, promotionCode can be between1 and 10 characters long");
                    } else if (!a(str2)) {
                        throw new IllegalArgumentException("Invalid promotion code, promotionCode can only contain alphanumeric characters and spaces.");
                    }
                }
            } else if (!TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("promotionCode cannot be specified without a valid promotionText");
            }
            this.c = str2;
            this.d = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        @Deprecated
        public AppInviteContent build() {
            return new AppInviteContent(this, null);
        }

        @Deprecated
        public Builder readFrom(AppInviteContent appInviteContent) {
            if (appInviteContent == null) {
                return this;
            }
            return setApplinkUrl(appInviteContent.getApplinkUrl()).setPreviewImageUrl(appInviteContent.getPreviewImageUrl()).setPromotionDetails(appInviteContent.getPromotionText(), appInviteContent.getPromotionCode()).setDestination(appInviteContent.getDestination());
        }
    }

    public static class a implements Parcelable.Creator<AppInviteContent> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public AppInviteContent createFromParcel(Parcel parcel) {
            return new AppInviteContent(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public AppInviteContent[] newArray(int i) {
            return new AppInviteContent[i];
        }
    }

    public AppInviteContent(Builder builder, a aVar) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public String getApplinkUrl() {
        return this.a;
    }

    @Deprecated
    public Builder.Destination getDestination() {
        Builder.Destination destination = this.e;
        if (destination != null) {
            return destination;
        }
        return Builder.Destination.FACEBOOK;
    }

    @Deprecated
    public String getPreviewImageUrl() {
        return this.b;
    }

    @Deprecated
    public String getPromotionCode() {
        return this.c;
    }

    @Deprecated
    public String getPromotionText() {
        return this.d;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.d);
        parcel.writeString(this.c);
        parcel.writeString(this.e.toString());
    }

    @Deprecated
    public AppInviteContent(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.d = parcel.readString();
        this.c = parcel.readString();
        String readString = parcel.readString();
        if (readString.length() > 0) {
            this.e = Builder.Destination.valueOf(readString);
        } else {
            this.e = Builder.Destination.FACEBOOK;
        }
    }
}
