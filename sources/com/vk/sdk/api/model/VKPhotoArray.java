package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
public class VKPhotoArray extends VKList<VKApiPhoto> {
    public static Parcelable.Creator<VKPhotoArray> CREATOR = new a();

    public static class a implements Parcelable.Creator<VKPhotoArray> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKPhotoArray createFromParcel(Parcel parcel) {
            return new VKPhotoArray(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKPhotoArray[] newArray(int i) {
            return new VKPhotoArray[i];
        }
    }

    public VKPhotoArray() {
    }

    @Override // com.vk.sdk.api.model.VKList, com.vk.sdk.api.model.VKApiModel
    public VKApiModel parse(JSONObject jSONObject) throws JSONException {
        fill(jSONObject, VKApiPhoto.class);
        return this;
    }

    public VKPhotoArray(Parcel parcel) {
        super(parcel);
    }
}
