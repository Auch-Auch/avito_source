package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
public class VKCommentArray extends VKList<VKApiComment> {
    public static Parcelable.Creator<VKCommentArray> CREATOR = new a();

    public static class a implements Parcelable.Creator<VKCommentArray> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKCommentArray createFromParcel(Parcel parcel) {
            return new VKCommentArray(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKCommentArray[] newArray(int i) {
            return new VKCommentArray[i];
        }
    }

    public VKCommentArray() {
    }

    @Override // com.vk.sdk.api.model.VKList, com.vk.sdk.api.model.VKApiModel
    public VKApiModel parse(JSONObject jSONObject) throws JSONException {
        fill(jSONObject, VKApiComment.class);
        return this;
    }

    public VKCommentArray(Parcel parcel) {
        super(parcel);
    }
}
