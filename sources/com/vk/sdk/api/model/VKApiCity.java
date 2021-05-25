package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;
public class VKApiCity extends VKApiModel implements Parcelable, Identifiable {
    public static Parcelable.Creator<VKApiCity> CREATOR = new a();
    public int id;
    public String title;

    public static class a implements Parcelable.Creator<VKApiCity> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiCity createFromParcel(Parcel parcel) {
            return new VKApiCity(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiCity[] newArray(int i) {
            return new VKApiCity[i];
        }
    }

    public VKApiCity(JSONObject jSONObject) {
        parse(jSONObject);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.vk.sdk.api.model.Identifiable
    public int getId() {
        return this.id;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.title);
    }

    @Override // com.vk.sdk.api.model.VKApiModel
    public VKApiCity parse(JSONObject jSONObject) {
        this.id = jSONObject.optInt("id");
        this.title = jSONObject.optString("title");
        return this;
    }

    public VKApiCity(Parcel parcel) {
        this.id = parcel.readInt();
        this.title = parcel.readString();
    }

    public VKApiCity() {
    }
}
