package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.avito.android.remote.model.Navigation;
import org.json.JSONObject;
public class VKApiCommunity extends VKApiOwner implements Parcelable, Identifiable {
    public static Parcelable.Creator<VKApiCommunity> CREATOR = new a();
    public int admin_level;
    public boolean is_admin;
    public int is_closed;
    public boolean is_member;
    public String name;
    public VKPhotoSizes photo = new VKPhotoSizes();
    public String photo_100;
    public String photo_200;
    public String photo_50;
    public String screen_name;
    public int type;

    public static class AdminLevel {
        public static final int ADMIN = 3;
        public static final int EDITOR = 2;
        public static final int MODERATOR = 1;
    }

    public static class Status {
        public static final int CLOSED = 1;
        public static final int OPEN = 0;
        public static final int PRIVATE = 2;
    }

    public static class Type {
        public static final int EVENT = 2;
        public static final int GROUP = 0;
        public static final int PAGE = 1;
    }

    public static class a implements Parcelable.Creator<VKApiCommunity> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiCommunity createFromParcel(Parcel parcel) {
            return new VKApiCommunity(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiCommunity[] newArray(int i) {
            return new VKApiCommunity[i];
        }
    }

    public VKApiCommunity(JSONObject jSONObject) {
        parse(jSONObject);
    }

    @Override // com.vk.sdk.api.model.VKApiOwner, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.name;
    }

    @Override // com.vk.sdk.api.model.VKApiOwner, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.name);
        parcel.writeString(this.screen_name);
        parcel.writeInt(this.is_closed);
        parcel.writeByte(this.is_admin ? (byte) 1 : 0);
        parcel.writeInt(this.admin_level);
        parcel.writeByte(this.is_member ? (byte) 1 : 0);
        parcel.writeInt(this.type);
        parcel.writeString(this.photo_50);
        parcel.writeString(this.photo_100);
        parcel.writeString(this.photo_200);
        parcel.writeParcelable(this.photo, i);
    }

    @Override // com.vk.sdk.api.model.VKApiOwner, com.vk.sdk.api.model.VKApiModel
    public VKApiCommunity parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.name = jSONObject.optString("name");
        this.screen_name = jSONObject.optString(VKApiUserFull.SCREEN_NAME, String.format("club%d", Integer.valueOf(Math.abs(this.id))));
        this.is_closed = jSONObject.optInt("is_closed");
        this.is_admin = AppCompatDelegateImpl.i.t1(jSONObject, "is_admin");
        this.admin_level = jSONObject.optInt("admin_level");
        this.is_member = AppCompatDelegateImpl.i.t1(jSONObject, "is_member");
        String optString = jSONObject.optString(VKApiUser.FIELD_PHOTO_50, "http://vk.com/images/community_50.gif");
        this.photo_50 = optString;
        if (!TextUtils.isEmpty(optString)) {
            this.photo.add((VKPhotoSizes) VKApiPhotoSize.create(this.photo_50, 50));
        }
        String optString2 = jSONObject.optString(VKApiUser.FIELD_PHOTO_100, "http://vk.com/images/community_100.gif");
        this.photo_100 = optString2;
        if (!TextUtils.isEmpty(optString2)) {
            this.photo.add((VKPhotoSizes) VKApiPhotoSize.create(this.photo_100, 100));
        }
        String optString3 = jSONObject.optString(VKApiUser.FIELD_PHOTO_200, null);
        this.photo_200 = optString3;
        if (!TextUtils.isEmpty(optString3)) {
            this.photo.add((VKPhotoSizes) VKApiPhotoSize.create(this.photo_200, 200));
        }
        this.photo.sort();
        String optString4 = jSONObject.optString("type", Navigation.GROUP);
        if (Navigation.GROUP.equals(optString4)) {
            this.type = 0;
        } else if ("page".equals(optString4)) {
            this.type = 1;
        } else if ("event".equals(optString4)) {
            this.type = 2;
        }
        return this;
    }

    public VKApiCommunity(Parcel parcel) {
        super(parcel);
        this.name = parcel.readString();
        this.screen_name = parcel.readString();
        this.is_closed = parcel.readInt();
        boolean z = true;
        this.is_admin = parcel.readByte() != 0;
        this.admin_level = parcel.readInt();
        this.is_member = parcel.readByte() == 0 ? false : z;
        this.type = parcel.readInt();
        this.photo_50 = parcel.readString();
        this.photo_100 = parcel.readString();
        this.photo_200 = parcel.readString();
        this.photo = (VKPhotoSizes) parcel.readParcelable(VKPhotoSizes.class.getClassLoader());
    }

    public VKApiCommunity() {
    }
}
