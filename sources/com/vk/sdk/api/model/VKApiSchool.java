package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
public class VKApiSchool extends VKApiModel implements Parcelable, Identifiable {
    public static Parcelable.Creator<VKApiSchool> CREATOR = new a();
    public String c;
    public int city_id;
    public String clazz;
    public int country_id;
    public int id;
    public String name;
    public String speciality;
    public int year_from;
    public int year_graduated;
    public int year_to;

    public static class a implements Parcelable.Creator<VKApiSchool> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiSchool createFromParcel(Parcel parcel) {
            return new VKApiSchool(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiSchool[] newArray(int i) {
            return new VKApiSchool[i];
        }
    }

    public VKApiSchool(JSONObject jSONObject) throws JSONException {
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
            if (this.year_graduated != 0) {
                sb.append(" '");
                sb.append(String.format("%02d", Integer.valueOf(this.year_graduated % 100)));
            }
            if (!(this.year_from == 0 || this.year_to == 0)) {
                sb.append(", ");
                sb.append(this.year_from);
                sb.append('-');
                sb.append(this.year_to);
            }
            if (!TextUtils.isEmpty(this.clazz)) {
                sb.append('(');
                sb.append(this.clazz);
                sb.append(')');
            }
            if (!TextUtils.isEmpty(this.speciality)) {
                sb.append(", ");
                sb.append(this.speciality);
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
        parcel.writeInt(this.year_from);
        parcel.writeInt(this.year_to);
        parcel.writeInt(this.year_graduated);
        parcel.writeString(this.clazz);
        parcel.writeString(this.speciality);
    }

    @Override // com.vk.sdk.api.model.VKApiModel
    public VKApiSchool parse(JSONObject jSONObject) {
        this.id = jSONObject.optInt("id");
        this.country_id = jSONObject.optInt("country_id");
        this.city_id = jSONObject.optInt("city_id");
        this.name = jSONObject.optString("name");
        this.year_from = jSONObject.optInt("year_from");
        this.year_to = jSONObject.optInt("year_to");
        this.year_graduated = jSONObject.optInt("year_graduated");
        this.clazz = jSONObject.optString("class");
        this.speciality = jSONObject.optString("speciality");
        return this;
    }

    public VKApiSchool(Parcel parcel) {
        this.id = parcel.readInt();
        this.country_id = parcel.readInt();
        this.city_id = parcel.readInt();
        this.name = parcel.readString();
        this.year_from = parcel.readInt();
        this.year_to = parcel.readInt();
        this.year_graduated = parcel.readInt();
        this.clazz = parcel.readString();
        this.speciality = parcel.readString();
    }

    public VKApiSchool() {
    }
}
