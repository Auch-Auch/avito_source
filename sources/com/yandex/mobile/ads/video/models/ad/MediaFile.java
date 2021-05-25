package com.yandex.mobile.ads.video.models.ad;

import android.os.Parcel;
import android.os.Parcelable;
public final class MediaFile implements Parcelable {
    public static final Parcelable.Creator<MediaFile> CREATOR = new Parcelable.Creator<MediaFile>() { // from class: com.yandex.mobile.ads.video.models.ad.MediaFile.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MediaFile createFromParcel(Parcel parcel) {
            return new MediaFile(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MediaFile[] newArray(int i) {
            return new MediaFile[i];
        }
    };
    public int mBitrate;
    private DeliveryMethod mDeliveryMethod;
    private int mHeight;
    private String mId;
    private String mMimeType;
    private String mUri;
    private int mWidth;

    public enum DeliveryMethod {
        STREAMING("streaming"),
        PROGRESSIVE("progressive");
        
        private String mDeliveryMethod;

        private DeliveryMethod(String str) {
            this.mDeliveryMethod = str;
        }

        public static DeliveryMethod getByMethod(String str) {
            DeliveryMethod[] values = values();
            for (int i = 0; i < 2; i++) {
                DeliveryMethod deliveryMethod = values[i];
                if (deliveryMethod.mDeliveryMethod.equals(str)) {
                    return deliveryMethod;
                }
            }
            return null;
        }
    }

    private void setBitrate(String str) {
        try {
            this.mBitrate = Integer.valueOf(str).intValue();
        } catch (Exception unused) {
        }
    }

    private void setDeliveryMethod(String str) {
        this.mDeliveryMethod = DeliveryMethod.getByMethod(str);
    }

    private void setHeight(String str) {
        try {
            this.mHeight = Integer.valueOf(str).intValue();
        } catch (Exception unused) {
        }
    }

    private void setId(String str) {
        this.mId = str;
    }

    private void setUri(String str) {
        this.mUri = str;
    }

    private void setWidth(String str) {
        try {
            this.mWidth = Integer.valueOf(str).intValue();
        } catch (Exception unused) {
        }
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
        if (obj == null || MediaFile.class != obj.getClass()) {
            return false;
        }
        MediaFile mediaFile = (MediaFile) obj;
        if (this.mHeight != mediaFile.mHeight || this.mWidth != mediaFile.mWidth || this.mDeliveryMethod != mediaFile.mDeliveryMethod) {
            return false;
        }
        String str = this.mId;
        if (str == null ? mediaFile.mId != null : !str.equals(mediaFile.mId)) {
            return false;
        }
        String str2 = this.mMimeType;
        if (str2 == null ? mediaFile.mMimeType != null : !str2.equals(mediaFile.mMimeType)) {
            return false;
        }
        String str3 = this.mUri;
        String str4 = mediaFile.mUri;
        return str3 == null ? str4 == null : str3.equals(str4);
    }

    public final int getBitrate() {
        return this.mBitrate;
    }

    public final DeliveryMethod getDeliveryMethod() {
        return this.mDeliveryMethod;
    }

    public final int getHeight() {
        return this.mHeight;
    }

    public final String getId() {
        return this.mId;
    }

    public final String getMimeType() {
        return this.mMimeType;
    }

    public final String getUri() {
        return this.mUri;
    }

    public final int getWidth() {
        return this.mWidth;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        String str = this.mId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.mUri;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        DeliveryMethod deliveryMethod = this.mDeliveryMethod;
        int hashCode3 = (((((hashCode2 + (deliveryMethod != null ? deliveryMethod.hashCode() : 0)) * 31) + this.mHeight) * 31) + this.mWidth) * 31;
        String str3 = this.mMimeType;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    public final void setMimeType(String str) {
        this.mMimeType = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mUri);
        DeliveryMethod deliveryMethod = this.mDeliveryMethod;
        parcel.writeInt(deliveryMethod == null ? -1 : deliveryMethod.ordinal());
        parcel.writeInt(this.mHeight);
        parcel.writeInt(this.mWidth);
        parcel.writeString(this.mMimeType);
    }

    private MediaFile() {
    }

    private MediaFile(Parcel parcel) {
        DeliveryMethod deliveryMethod;
        this.mId = parcel.readString();
        this.mUri = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt == -1) {
            deliveryMethod = null;
        } else {
            deliveryMethod = DeliveryMethod.values()[readInt];
        }
        this.mDeliveryMethod = deliveryMethod;
        this.mHeight = parcel.readInt();
        this.mWidth = parcel.readInt();
        this.mMimeType = parcel.readString();
    }
}
