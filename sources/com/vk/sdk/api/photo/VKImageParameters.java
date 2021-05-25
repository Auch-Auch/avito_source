package com.vk.sdk.api.photo;

import android.os.Parcel;
import android.os.Parcelable;
import com.vk.sdk.VKObject;
import net.gotev.uploadservice.extensions.StringExtensionsKt;
public class VKImageParameters extends VKObject implements Parcelable {
    public static final Parcelable.Creator<VKImageParameters> CREATOR = new a();
    public b mImageType = b.Png;
    public float mJpegQuality;

    public static class a implements Parcelable.Creator<VKImageParameters> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKImageParameters createFromParcel(Parcel parcel) {
            return new VKImageParameters(parcel, null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKImageParameters[] newArray(int i) {
            return new VKImageParameters[i];
        }
    }

    public enum b {
        Jpg,
        Png
    }

    public VKImageParameters() {
    }

    public static VKImageParameters jpgImage(float f) {
        VKImageParameters vKImageParameters = new VKImageParameters();
        vKImageParameters.mImageType = b.Jpg;
        vKImageParameters.mJpegQuality = f;
        return vKImageParameters;
    }

    public static VKImageParameters pngImage() {
        VKImageParameters vKImageParameters = new VKImageParameters();
        vKImageParameters.mImageType = b.Png;
        return vKImageParameters;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String fileExtension() {
        int ordinal = this.mImageType.ordinal();
        if (ordinal != 0) {
            return ordinal != 1 ? "file" : "png";
        }
        return "jpg";
    }

    public String mimeType() {
        int ordinal = this.mImageType.ordinal();
        if (ordinal != 0) {
            return ordinal != 1 ? StringExtensionsKt.APPLICATION_OCTET_STREAM : "image/png";
        }
        return "image/jpeg";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        b bVar = this.mImageType;
        parcel.writeInt(bVar == null ? -1 : bVar.ordinal());
        parcel.writeFloat(this.mJpegQuality);
    }

    public VKImageParameters(Parcel parcel, a aVar) {
        b bVar;
        int readInt = parcel.readInt();
        if (readInt == -1) {
            bVar = null;
        } else {
            bVar = b.values()[readInt];
        }
        this.mImageType = bVar;
        this.mJpegQuality = parcel.readFloat();
    }
}
