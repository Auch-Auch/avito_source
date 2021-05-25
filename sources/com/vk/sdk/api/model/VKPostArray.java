package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
public class VKPostArray extends VKList<VKApiPost> {
    public static Parcelable.Creator<VKPostArray> CREATOR = new a();

    public static class a implements Parcelable.Creator<VKPostArray> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKPostArray createFromParcel(Parcel parcel) {
            return new VKPostArray(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKPostArray[] newArray(int i) {
            return new VKPostArray[i];
        }
    }

    public VKPostArray() {
    }

    @Override // com.vk.sdk.api.model.VKList, com.vk.sdk.api.model.VKApiModel
    public VKApiModel parse(JSONObject jSONObject) throws JSONException {
        fill(jSONObject, VKApiPost.class);
        return this;
    }

    public VKPostArray(Parcel parcel) {
        super(parcel);
    }
}
