package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
public class VkAudioArray extends VKList<VKApiAudio> {
    public static Parcelable.Creator<VkAudioArray> CREATOR = new a();

    public static class a implements Parcelable.Creator<VkAudioArray> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VkAudioArray createFromParcel(Parcel parcel) {
            return new VkAudioArray(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VkAudioArray[] newArray(int i) {
            return new VkAudioArray[i];
        }
    }

    public VkAudioArray() {
    }

    @Override // com.vk.sdk.api.model.VKList, com.vk.sdk.api.model.VKApiModel
    public VKApiModel parse(JSONObject jSONObject) throws JSONException {
        fill(jSONObject, VKApiAudio.class);
        return this;
    }

    public VkAudioArray(Parcel parcel) {
        super(parcel);
    }
}
