package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONArray;
import org.json.JSONObject;
public class VKApiChat extends VKApiModel implements Identifiable, Parcelable {
    public static Parcelable.Creator<VKApiChat> CREATOR = new a();
    public int admin_id;
    public int id;
    public String title;
    public String type;
    public int[] users;

    public static class a implements Parcelable.Creator<VKApiChat> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiChat createFromParcel(Parcel parcel) {
            return new VKApiChat(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiChat[] newArray(int i) {
            return new VKApiChat[i];
        }
    }

    public VKApiChat(JSONObject jSONObject) {
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.type);
        parcel.writeString(this.title);
        parcel.writeInt(this.admin_id);
        parcel.writeIntArray(this.users);
    }

    @Override // com.vk.sdk.api.model.VKApiModel
    public VKApiChat parse(JSONObject jSONObject) {
        this.id = jSONObject.optInt("id");
        this.type = jSONObject.optString("type");
        this.title = jSONObject.optString("title");
        this.admin_id = jSONObject.optInt("admin_id");
        JSONArray optJSONArray = jSONObject.optJSONArray("users");
        if (optJSONArray != null) {
            this.users = new int[optJSONArray.length()];
            int i = 0;
            while (true) {
                int[] iArr = this.users;
                if (i >= iArr.length) {
                    break;
                }
                iArr[i] = optJSONArray.optInt(i);
                i++;
            }
        }
        return this;
    }

    public VKApiChat(Parcel parcel) {
        this.id = parcel.readInt();
        this.type = parcel.readString();
        this.title = parcel.readString();
        this.admin_id = parcel.readInt();
        this.users = parcel.createIntArray();
    }

    public VKApiChat() {
    }
}
