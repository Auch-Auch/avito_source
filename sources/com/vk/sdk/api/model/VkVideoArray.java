package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
public class VkVideoArray extends VKList<VKApiVideo> {
    public static Parcelable.Creator<VkVideoArray> CREATOR = new a();

    public static class a implements Parcelable.Creator<VkVideoArray> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VkVideoArray createFromParcel(Parcel parcel) {
            return new VkVideoArray(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VkVideoArray[] newArray(int i) {
            return new VkVideoArray[i];
        }
    }

    public VkVideoArray() {
    }

    @Override // com.vk.sdk.api.model.VKList, com.vk.sdk.api.model.VKApiModel
    public VKApiModel parse(JSONObject jSONObject) throws JSONException {
        fill(jSONObject, VKApiVideo.class);
        return this;
    }

    public VkVideoArray(Parcel parcel) {
        super(parcel);
    }
}
