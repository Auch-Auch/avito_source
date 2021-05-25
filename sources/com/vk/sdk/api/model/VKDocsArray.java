package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
public class VKDocsArray extends VKList<VKApiDocument> {
    public static Parcelable.Creator<VKDocsArray> CREATOR = new a();

    public static class a implements Parcelable.Creator<VKDocsArray> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKDocsArray createFromParcel(Parcel parcel) {
            return new VKDocsArray(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKDocsArray[] newArray(int i) {
            return new VKDocsArray[i];
        }
    }

    public VKDocsArray() {
    }

    @Override // com.vk.sdk.api.model.VKList, com.vk.sdk.api.model.VKApiModel
    public VKApiModel parse(JSONObject jSONObject) throws JSONException {
        fill(jSONObject, VKApiDocument.class);
        return this;
    }

    public VKDocsArray(Parcel parcel) {
        super(parcel);
    }
}
