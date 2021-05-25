package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.preferences.GeoContract;
import com.facebook.appevents.integrity.IntegrityManager;
import org.json.JSONException;
import org.json.JSONObject;
import ru.avito.android.persistence.messenger.ChannelEntity;
public class VKApiPlace extends VKApiModel implements Parcelable, Identifiable {
    public static Parcelable.Creator<VKApiPlace> CREATOR = new a();
    public String address;
    public int checkins;
    public int city_id;
    public int country_id;
    public long created;
    public int id;
    public double latitude;
    public double longitude;
    public String title;
    public long updated;

    public static class a implements Parcelable.Creator<VKApiPlace> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiPlace createFromParcel(Parcel parcel) {
            return new VKApiPlace(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiPlace[] newArray(int i) {
            return new VKApiPlace[i];
        }
    }

    public VKApiPlace(JSONObject jSONObject) throws JSONException {
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
        return this.address;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.title);
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeLong(this.created);
        parcel.writeInt(this.checkins);
        parcel.writeLong(this.updated);
        parcel.writeInt(this.country_id);
        parcel.writeInt(this.city_id);
        parcel.writeString(this.address);
    }

    @Override // com.vk.sdk.api.model.VKApiModel
    public VKApiPlace parse(JSONObject jSONObject) {
        this.id = jSONObject.optInt("id");
        this.title = jSONObject.optString("title");
        this.latitude = jSONObject.optDouble(GeoContract.LATITUDE);
        this.longitude = jSONObject.optDouble(GeoContract.LONGITUDE);
        this.created = jSONObject.optLong("created");
        this.checkins = jSONObject.optInt("checkins");
        this.updated = jSONObject.optLong(ChannelEntity.COLUMN_UPDATED);
        this.country_id = jSONObject.optInt("country");
        this.city_id = jSONObject.optInt("city");
        this.address = jSONObject.optString(IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        return this;
    }

    public VKApiPlace(Parcel parcel) {
        this.id = parcel.readInt();
        this.title = parcel.readString();
        this.latitude = parcel.readDouble();
        this.longitude = parcel.readDouble();
        this.created = parcel.readLong();
        this.checkins = parcel.readInt();
        this.updated = parcel.readLong();
        this.country_id = parcel.readInt();
        this.city_id = parcel.readInt();
        this.address = parcel.readString();
    }

    public VKApiPlace() {
    }
}
