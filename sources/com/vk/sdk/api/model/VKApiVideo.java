package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.Sort;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKAttachments;
import org.json.JSONException;
import org.json.JSONObject;
public class VKApiVideo extends VKAttachments.VKApiAttachment implements Parcelable, Identifiable {
    public static Parcelable.Creator<VKApiVideo> CREATOR = new a();
    public String access_key;
    public int album_id;
    public boolean can_comment;
    public boolean can_repost;
    public int comments;
    public long date;
    public String description;
    public int duration;
    public String external;
    public int id;
    public int likes;
    public String link;
    public String mp4_240;
    public String mp4_360;
    public String mp4_480;
    public String mp4_720;
    public int owner_id;
    public VKPhotoSizes photo = new VKPhotoSizes();
    public String photo_130;
    public String photo_320;
    public String photo_640;
    public String player;
    public int privacy_comment;
    public int privacy_view;
    public boolean repeat;
    public String title;
    public boolean user_likes;
    public int views;

    public static class a implements Parcelable.Creator<VKApiVideo> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiVideo createFromParcel(Parcel parcel) {
            return new VKApiVideo(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiVideo[] newArray(int i) {
            return new VKApiVideo[i];
        }
    }

    public VKApiVideo(JSONObject jSONObject) throws JSONException {
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

    @Override // com.vk.sdk.api.model.VKAttachments.VKApiAttachment
    public String getType() {
        return "video";
    }

    @Override // com.vk.sdk.api.model.VKAttachments.VKApiAttachment
    public CharSequence toAttachmentString() {
        StringBuilder sb = new StringBuilder("video");
        sb.append(this.owner_id);
        sb.append('_');
        sb.append(this.id);
        if (!TextUtils.isEmpty(this.access_key)) {
            sb.append('_');
            sb.append(this.access_key);
        }
        return sb;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeInt(this.owner_id);
        parcel.writeInt(this.album_id);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeInt(this.duration);
        parcel.writeString(this.link);
        parcel.writeLong(this.date);
        parcel.writeInt(this.views);
        parcel.writeString(this.player);
        parcel.writeString(this.photo_130);
        parcel.writeString(this.photo_320);
        parcel.writeString(this.photo_640);
        parcel.writeParcelable(this.photo, i);
        parcel.writeString(this.access_key);
        parcel.writeInt(this.comments);
        parcel.writeByte(this.can_comment ? (byte) 1 : 0);
        parcel.writeByte(this.can_repost ? (byte) 1 : 0);
        parcel.writeByte(this.user_likes ? (byte) 1 : 0);
        parcel.writeByte(this.repeat ? (byte) 1 : 0);
        parcel.writeInt(this.likes);
        parcel.writeInt(this.privacy_view);
        parcel.writeInt(this.privacy_comment);
        parcel.writeString(this.mp4_240);
        parcel.writeString(this.mp4_360);
        parcel.writeString(this.mp4_480);
        parcel.writeString(this.mp4_720);
        parcel.writeString(this.external);
    }

    @Override // com.vk.sdk.api.model.VKApiModel
    public VKApiVideo parse(JSONObject jSONObject) {
        this.id = jSONObject.optInt("id");
        this.owner_id = jSONObject.optInt(VKApiConst.OWNER_ID);
        this.title = jSONObject.optString("title");
        this.description = jSONObject.optString("description");
        this.duration = jSONObject.optInt("duration");
        this.link = jSONObject.optString("link");
        this.date = jSONObject.optLong(Sort.DATE);
        this.views = jSONObject.optInt("views");
        this.comments = jSONObject.optInt("comments");
        this.player = jSONObject.optString(ScreenPublicConstsKt.CONTENT_TYPE_PLAYER);
        this.access_key = jSONObject.optString("access_key");
        this.album_id = jSONObject.optInt(VKApiConst.ALBUM_ID);
        JSONObject optJSONObject = jSONObject.optJSONObject("likes");
        if (optJSONObject != null) {
            this.likes = optJSONObject.optInt("count");
            this.user_likes = AppCompatDelegateImpl.i.t1(optJSONObject, "user_likes");
        }
        this.can_comment = AppCompatDelegateImpl.i.t1(jSONObject, "can_comment");
        this.can_repost = AppCompatDelegateImpl.i.t1(jSONObject, "can_repost");
        this.repeat = AppCompatDelegateImpl.i.t1(jSONObject, "repeat");
        this.privacy_view = VKPrivacy.parsePrivacy(jSONObject.optJSONObject("privacy_view"));
        this.privacy_comment = VKPrivacy.parsePrivacy(jSONObject.optJSONObject("privacy_comment"));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("files");
        if (optJSONObject2 != null) {
            this.mp4_240 = optJSONObject2.optString("mp4_240");
            this.mp4_360 = optJSONObject2.optString("mp4_360");
            this.mp4_480 = optJSONObject2.optString("mp4_480");
            this.mp4_720 = optJSONObject2.optString("mp4_720");
            this.external = optJSONObject2.optString("external");
        }
        String optString = jSONObject.optString("photo_130");
        this.photo_130 = optString;
        if (!TextUtils.isEmpty(optString)) {
            this.photo.add((VKPhotoSizes) VKApiPhotoSize.create(this.photo_130, 130));
        }
        String optString2 = jSONObject.optString("photo_320");
        this.photo_320 = optString2;
        if (!TextUtils.isEmpty(optString2)) {
            this.photo.add((VKPhotoSizes) VKApiPhotoSize.create(this.photo_320, 320));
        }
        String optString3 = jSONObject.optString("photo_640");
        this.photo_640 = optString3;
        if (!TextUtils.isEmpty(optString3)) {
            this.photo.add((VKPhotoSizes) VKApiPhotoSize.create(this.photo_640, 640));
        }
        return this;
    }

    public VKApiVideo(Parcel parcel) {
        this.id = parcel.readInt();
        this.owner_id = parcel.readInt();
        this.album_id = parcel.readInt();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.duration = parcel.readInt();
        this.link = parcel.readString();
        this.date = parcel.readLong();
        this.views = parcel.readInt();
        this.player = parcel.readString();
        this.photo_130 = parcel.readString();
        this.photo_320 = parcel.readString();
        this.photo_640 = parcel.readString();
        this.photo = (VKPhotoSizes) parcel.readParcelable(VKPhotoSizes.class.getClassLoader());
        this.access_key = parcel.readString();
        this.comments = parcel.readInt();
        boolean z = true;
        this.can_comment = parcel.readByte() != 0;
        this.can_repost = parcel.readByte() != 0;
        this.user_likes = parcel.readByte() != 0;
        this.repeat = parcel.readByte() == 0 ? false : z;
        this.likes = parcel.readInt();
        this.privacy_view = parcel.readInt();
        this.privacy_comment = parcel.readInt();
        this.mp4_240 = parcel.readString();
        this.mp4_360 = parcel.readString();
        this.mp4_480 = parcel.readString();
        this.mp4_720 = parcel.readString();
        this.external = parcel.readString();
    }

    public VKApiVideo() {
    }
}
