package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
public class VKApiUniversity extends VKApiModel implements Parcelable, Identifiable {
    public static Parcelable.Creator<VKApiUniversity> CREATOR = new a();
    public String c;
    public int chair;
    public String chair_name;
    public int city_id;
    public int country_id;
    public String education_form;
    public String education_status;
    public String faculty;
    public String faculty_name;
    public int graduation;
    public int id;
    public String name;

    public static class a implements Parcelable.Creator<VKApiUniversity> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiUniversity createFromParcel(Parcel parcel) {
            return new VKApiUniversity(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiUniversity[] newArray(int i) {
            return new VKApiUniversity[i];
        }
    }

    public VKApiUniversity(JSONObject jSONObject) throws JSONException {
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
        if (this.c == null) {
            StringBuilder sb = new StringBuilder(this.name);
            sb.append(" '");
            sb.append(String.format("%02d", Integer.valueOf(this.graduation % 100)));
            if (!TextUtils.isEmpty(this.faculty_name)) {
                sb.append(", ");
                sb.append(this.faculty_name);
            }
            if (!TextUtils.isEmpty(this.chair_name)) {
                sb.append(", ");
                sb.append(this.chair_name);
            }
            this.c = sb.toString();
        }
        return this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeInt(this.country_id);
        parcel.writeInt(this.city_id);
        parcel.writeString(this.name);
        parcel.writeString(this.faculty);
        parcel.writeString(this.faculty_name);
        parcel.writeInt(this.chair);
        parcel.writeString(this.chair_name);
        parcel.writeInt(this.graduation);
        parcel.writeString(this.education_form);
        parcel.writeString(this.education_status);
    }

    @Override // com.vk.sdk.api.model.VKApiModel
    public VKApiUniversity parse(JSONObject jSONObject) {
        this.id = jSONObject.optInt("id");
        this.country_id = jSONObject.optInt("country_id");
        this.city_id = jSONObject.optInt("city_id");
        this.name = jSONObject.optString("name");
        this.faculty = jSONObject.optString("faculty");
        this.faculty_name = jSONObject.optString("faculty_name");
        this.chair = jSONObject.optInt("chair");
        this.chair_name = jSONObject.optString("chair_name");
        this.graduation = jSONObject.optInt("graduation");
        this.education_form = jSONObject.optString("education_form");
        this.education_status = jSONObject.optString("education_status");
        return this;
    }

    public VKApiUniversity(Parcel parcel) {
        this.id = parcel.readInt();
        this.country_id = parcel.readInt();
        this.city_id = parcel.readInt();
        this.name = parcel.readString();
        this.faculty = parcel.readString();
        this.faculty_name = parcel.readString();
        this.chair = parcel.readInt();
        this.chair_name = parcel.readString();
        this.graduation = parcel.readInt();
        this.education_form = parcel.readString();
        this.education_status = parcel.readString();
    }

    public VKApiUniversity() {
    }
}
