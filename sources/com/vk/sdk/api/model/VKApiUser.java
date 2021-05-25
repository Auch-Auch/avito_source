package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatDelegateImpl;
import org.json.JSONException;
import org.json.JSONObject;
public class VKApiUser extends VKApiOwner implements Parcelable {
    public static Parcelable.Creator<VKApiUser> CREATOR = new a();
    public static final String FIELDS_DEFAULT = TextUtils.join(",", new String[]{"online", FIELD_ONLINE_MOBILE, FIELD_PHOTO_50, FIELD_PHOTO_100, FIELD_PHOTO_200});
    public static final String FIELD_ONLINE = "online";
    public static final String FIELD_ONLINE_MOBILE = "online_mobile";
    public static final String FIELD_PHOTO_100 = "photo_100";
    public static final String FIELD_PHOTO_200 = "photo_200";
    public static final String FIELD_PHOTO_400_ORIGIN = "photo_400_orig";
    public static final String FIELD_PHOTO_50 = "photo_50";
    public static final String FIELD_PHOTO_BIG = "photo_big";
    public static final String FIELD_PHOTO_MAX = "photo_max";
    public static final String FIELD_PHOTO_MAX_ORIGIN = "photo_max_orig";
    public String c;
    public String first_name = "DELETED";
    public String last_name = "DELETED";
    public boolean online;
    public boolean online_mobile;
    public VKPhotoSizes photo = new VKPhotoSizes();
    public String photo_100 = "http://vk.com/images/camera_b.gif";
    public String photo_200 = "http://vk.com/images/camera_a.gif";
    public String photo_200_orig = "http://vk.com/images/camera_a.gif";
    public String photo_400_orig = "";
    public String photo_50 = "http://vk.com/images/camera_c.gif";
    public String photo_big = "";
    public String photo_max = "http://vk.com/images/camera_b.gif";
    public String photo_max_orig = "http://vk.com/images/camera_a.gif";

    public static class a implements Parcelable.Creator<VKApiUser> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiUser createFromParcel(Parcel parcel) {
            return new VKApiUser(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiUser[] newArray(int i) {
            return new VKApiUser[i];
        }
    }

    public VKApiUser(JSONObject jSONObject) throws JSONException {
        parse(jSONObject);
    }

    public String addSquarePhoto(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.photo.add((VKPhotoSizes) VKApiPhotoSize.create(str, i));
        }
        return str;
    }

    @Override // com.vk.sdk.api.model.VKApiOwner, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        if (this.c == null) {
            this.c = this.first_name + ' ' + this.last_name;
        }
        return this.c;
    }

    @Override // com.vk.sdk.api.model.VKApiOwner, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.first_name);
        parcel.writeString(this.last_name);
        parcel.writeByte(this.online ? (byte) 1 : 0);
        parcel.writeByte(this.online_mobile ? (byte) 1 : 0);
        parcel.writeString(this.photo_50);
        parcel.writeString(this.photo_100);
        parcel.writeString(this.photo_200);
        parcel.writeParcelable(this.photo, i);
        parcel.writeString(this.c);
        parcel.writeString(this.photo_400_orig);
        parcel.writeString(this.photo_max);
        parcel.writeString(this.photo_max_orig);
        parcel.writeString(this.photo_big);
    }

    @Override // com.vk.sdk.api.model.VKApiOwner, com.vk.sdk.api.model.VKApiModel
    public VKApiUser parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.first_name = jSONObject.optString("first_name", this.first_name);
        this.last_name = jSONObject.optString("last_name", this.last_name);
        this.online = AppCompatDelegateImpl.i.t1(jSONObject, "online");
        this.online_mobile = AppCompatDelegateImpl.i.t1(jSONObject, FIELD_ONLINE_MOBILE);
        this.photo_50 = addSquarePhoto(jSONObject.optString(FIELD_PHOTO_50, this.photo_50), 50);
        this.photo_100 = addSquarePhoto(jSONObject.optString(FIELD_PHOTO_100, this.photo_100), 100);
        this.photo_200 = addSquarePhoto(jSONObject.optString(FIELD_PHOTO_200, this.photo_200), 200);
        this.photo_400_orig = jSONObject.optString(FIELD_PHOTO_400_ORIGIN, this.photo_400_orig);
        this.photo_max = jSONObject.optString(FIELD_PHOTO_MAX, this.photo_max);
        this.photo_max_orig = jSONObject.optString(FIELD_PHOTO_MAX_ORIGIN, this.photo_max_orig);
        this.photo_big = jSONObject.optString(FIELD_PHOTO_BIG, this.photo_big);
        this.photo.sort();
        return this;
    }

    public VKApiUser(Parcel parcel) {
        super(parcel);
        this.first_name = parcel.readString();
        this.last_name = parcel.readString();
        boolean z = true;
        this.online = parcel.readByte() != 0;
        this.online_mobile = parcel.readByte() == 0 ? false : z;
        this.photo_50 = parcel.readString();
        this.photo_100 = parcel.readString();
        this.photo_200 = parcel.readString();
        this.photo = (VKPhotoSizes) parcel.readParcelable(VKPhotoSizes.class.getClassLoader());
        this.c = parcel.readString();
        this.photo_400_orig = parcel.readString();
        this.photo_max = parcel.readString();
        this.photo_max_orig = parcel.readString();
        this.photo_big = parcel.readString();
    }

    public VKApiUser() {
    }
}
