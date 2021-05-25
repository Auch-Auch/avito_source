package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
public class VKUsersArray extends VKList<VKApiUserFull> {
    public static Parcelable.Creator<VKUsersArray> CREATOR = new a();

    public static class a implements Parcelable.Creator<VKUsersArray> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKUsersArray createFromParcel(Parcel parcel) {
            return new VKUsersArray(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKUsersArray[] newArray(int i) {
            return new VKUsersArray[i];
        }
    }

    public VKUsersArray() {
    }

    @Override // com.vk.sdk.api.model.VKList, com.vk.sdk.api.model.VKApiModel
    public VKApiModel parse(JSONObject jSONObject) throws JSONException {
        fill(jSONObject, VKApiUserFull.class);
        return this;
    }

    public VKUsersArray(Parcel parcel) {
        super(parcel);
    }
}
