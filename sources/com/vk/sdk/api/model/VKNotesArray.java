package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
public class VKNotesArray extends VKList<VKApiNote> {
    public static Parcelable.Creator<VKNotesArray> CREATOR = new a();

    public static class a implements Parcelable.Creator<VKNotesArray> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKNotesArray createFromParcel(Parcel parcel) {
            return new VKNotesArray(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKNotesArray[] newArray(int i) {
            return new VKNotesArray[i];
        }
    }

    public VKNotesArray() {
    }

    @Override // com.vk.sdk.api.model.VKList, com.vk.sdk.api.model.VKApiModel
    public VKApiModel parse(JSONObject jSONObject) throws JSONException {
        fill(jSONObject, VKApiNote.class);
        return this;
    }

    public VKNotesArray(Parcel parcel) {
        super(parcel);
    }
}
