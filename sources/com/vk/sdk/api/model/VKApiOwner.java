package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
public class VKApiOwner extends VKApiModel implements Identifiable, Parcelable {
    public static Parcelable.Creator<VKApiOwner> CREATOR = new a();
    public int id;

    public static class a implements Parcelable.Creator<VKApiOwner> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiOwner createFromParcel(Parcel parcel) {
            return new VKApiOwner(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiOwner[] newArray(int i) {
            return new VKApiOwner[i];
        }
    }

    public VKApiOwner() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.vk.sdk.api.model.Identifiable
    public int getId() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
    }

    public VKApiOwner(JSONObject jSONObject) throws JSONException {
        parse(jSONObject);
    }

    @Override // com.vk.sdk.api.model.VKApiModel
    public VKApiOwner parse(JSONObject jSONObject) {
        this.fields = jSONObject;
        this.id = jSONObject.optInt("id");
        return this;
    }

    public VKApiOwner(int i) {
        this.id = i;
    }

    public VKApiOwner(Parcel parcel) {
        this.id = parcel.readInt();
    }
}
