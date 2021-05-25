package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;
public class VKApiPostedPhoto extends VKApiPhoto {
    public static Parcelable.Creator<VKApiPostedPhoto> CREATOR = new a();

    public static class a implements Parcelable.Creator<VKApiPostedPhoto> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiPostedPhoto createFromParcel(Parcel parcel) {
            return new VKApiPostedPhoto(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiPostedPhoto[] newArray(int i) {
            return new VKApiPostedPhoto[i];
        }
    }

    public VKApiPostedPhoto(Parcel parcel) {
        super(parcel);
    }

    @Override // com.vk.sdk.api.model.VKApiPhoto, com.vk.sdk.api.model.VKAttachments.VKApiAttachment
    public String getType() {
        return VKAttachments.TYPE_POSTED_PHOTO;
    }

    public VKApiPostedPhoto() {
    }

    @Override // com.vk.sdk.api.model.VKApiPhoto, com.vk.sdk.api.model.VKApiModel
    public VKApiPostedPhoto parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        return this;
    }
}
