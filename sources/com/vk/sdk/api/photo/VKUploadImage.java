package com.vk.sdk.api.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.vk.sdk.VKObject;
import com.vk.sdk.VKUIHelper;
import com.vk.sdk.api.photo.VKImageParameters;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class VKUploadImage extends VKObject implements Parcelable {
    public static final Parcelable.Creator<VKUploadImage> CREATOR = new a();
    public final Bitmap mImageData;
    public final VKImageParameters mParameters;

    public static class a implements Parcelable.Creator<VKUploadImage> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKUploadImage createFromParcel(Parcel parcel) {
            return new VKUploadImage(parcel, (a) null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKUploadImage[] newArray(int i) {
            return new VKUploadImage[i];
        }
    }

    public VKUploadImage(Bitmap bitmap, VKImageParameters vKImageParameters) {
        this.mImageData = bitmap;
        this.mParameters = vKImageParameters;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public File getTmpFile() {
        File file;
        Context applicationContext = VKUIHelper.getApplicationContext();
        File file2 = null;
        if (applicationContext != null) {
            file = applicationContext.getExternalCacheDir();
            if (file == null || !file.canWrite()) {
                file = applicationContext.getCacheDir();
            }
        } else {
            file = null;
        }
        try {
            file2 = File.createTempFile("tmpImg", String.format(".%s", this.mParameters.fileExtension()), file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            VKImageParameters vKImageParameters = this.mParameters;
            if (vKImageParameters.mImageType == VKImageParameters.b.Png) {
                this.mImageData.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            } else {
                this.mImageData.compress(Bitmap.CompressFormat.JPEG, (int) (vKImageParameters.mJpegQuality * 100.0f), fileOutputStream);
            }
            fileOutputStream.close();
        } catch (IOException unused) {
        }
        return file2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mImageData, 0);
        parcel.writeParcelable(this.mParameters, 0);
    }

    public VKUploadImage(Parcel parcel, a aVar) {
        this.mImageData = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.mParameters = (VKImageParameters) parcel.readParcelable(VKImageParameters.class.getClassLoader());
    }
}
