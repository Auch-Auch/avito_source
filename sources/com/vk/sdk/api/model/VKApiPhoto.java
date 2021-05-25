package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.avito.android.remote.model.Sort;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKAttachments;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class VKApiPhoto extends VKAttachments.VKApiAttachment implements Parcelable, Identifiable {
    public static Parcelable.Creator<VKApiPhoto> CREATOR = new a();
    public String access_key;
    public int album_id;
    public boolean can_comment;
    public int comments;
    public long date;
    public int height;
    public int id;
    public int likes;
    public int owner_id;
    public String photo_1280;
    public String photo_130;
    public String photo_2560;
    public String photo_604;
    public String photo_75;
    public String photo_807;
    public VKPhotoSizes src = new VKPhotoSizes();
    public int tags;
    public String text;
    public boolean user_likes;
    public int width;

    public static class a implements Parcelable.Creator<VKApiPhoto> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiPhoto createFromParcel(Parcel parcel) {
            return new VKApiPhoto(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiPhoto[] newArray(int i) {
            return new VKApiPhoto[i];
        }
    }

    public VKApiPhoto(JSONObject jSONObject) throws JSONException {
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
        return "photo";
    }

    @Override // com.vk.sdk.api.model.VKAttachments.VKApiAttachment
    public CharSequence toAttachmentString() {
        StringBuilder sb = new StringBuilder("photo");
        sb.append(this.owner_id);
        sb.append('_');
        sb.append(this.id);
        if (!TextUtils.isEmpty(this.access_key)) {
            sb.append('_');
            sb.append(this.access_key);
        }
        return sb;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeInt(this.album_id);
        parcel.writeInt(this.owner_id);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeString(this.text);
        parcel.writeLong(this.date);
        parcel.writeParcelable(this.src, i);
        parcel.writeString(this.photo_75);
        parcel.writeString(this.photo_130);
        parcel.writeString(this.photo_604);
        parcel.writeString(this.photo_807);
        parcel.writeString(this.photo_1280);
        parcel.writeString(this.photo_2560);
        parcel.writeByte(this.user_likes ? (byte) 1 : 0);
        parcel.writeByte(this.can_comment ? (byte) 1 : 0);
        parcel.writeInt(this.likes);
        parcel.writeInt(this.comments);
        parcel.writeInt(this.tags);
        parcel.writeString(this.access_key);
    }

    @Override // com.vk.sdk.api.model.VKApiModel
    public VKApiPhoto parse(JSONObject jSONObject) {
        this.album_id = jSONObject.optInt(VKApiConst.ALBUM_ID);
        this.date = jSONObject.optLong(Sort.DATE);
        this.height = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        this.width = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        this.owner_id = jSONObject.optInt(VKApiConst.OWNER_ID);
        this.id = jSONObject.optInt("id");
        this.text = jSONObject.optString("text");
        this.access_key = jSONObject.optString("access_key");
        this.photo_75 = jSONObject.optString("photo_75");
        this.photo_130 = jSONObject.optString("photo_130");
        this.photo_604 = jSONObject.optString("photo_604");
        this.photo_807 = jSONObject.optString("photo_807");
        this.photo_1280 = jSONObject.optString("photo_1280");
        this.photo_2560 = jSONObject.optString("photo_2560");
        JSONObject optJSONObject = jSONObject.optJSONObject("likes");
        this.likes = AppCompatDelegateImpl.i.u1(optJSONObject, "count");
        this.user_likes = AppCompatDelegateImpl.i.t1(optJSONObject, "user_likes");
        this.comments = AppCompatDelegateImpl.i.u1(jSONObject.optJSONObject("comments"), "count");
        this.tags = AppCompatDelegateImpl.i.u1(jSONObject.optJSONObject("tags"), "count");
        this.can_comment = AppCompatDelegateImpl.i.t1(jSONObject, "can_comment");
        this.src.setOriginalDimension(this.width, this.height);
        JSONArray optJSONArray = jSONObject.optJSONArray("sizes");
        if (optJSONArray != null) {
            this.src.fill(optJSONArray);
        } else {
            if (!TextUtils.isEmpty(this.photo_75)) {
                this.src.add((VKPhotoSizes) VKApiPhotoSize.create(this.photo_75, VKApiPhotoSize.S, this.width, this.height));
            }
            if (!TextUtils.isEmpty(this.photo_130)) {
                this.src.add((VKPhotoSizes) VKApiPhotoSize.create(this.photo_130, VKApiPhotoSize.M, this.width, this.height));
            }
            if (!TextUtils.isEmpty(this.photo_604)) {
                this.src.add((VKPhotoSizes) VKApiPhotoSize.create(this.photo_604, VKApiPhotoSize.X, this.width, this.height));
            }
            if (!TextUtils.isEmpty(this.photo_807)) {
                this.src.add((VKPhotoSizes) VKApiPhotoSize.create(this.photo_807, VKApiPhotoSize.Y, this.width, this.height));
            }
            if (!TextUtils.isEmpty(this.photo_1280)) {
                this.src.add((VKPhotoSizes) VKApiPhotoSize.create(this.photo_1280, VKApiPhotoSize.Z, this.width, this.height));
            }
            if (!TextUtils.isEmpty(this.photo_2560)) {
                this.src.add((VKPhotoSizes) VKApiPhotoSize.create(this.photo_2560, VKApiPhotoSize.W, this.width, this.height));
            }
            this.src.sort();
        }
        return this;
    }

    public VKApiPhoto(Parcel parcel) {
        this.id = parcel.readInt();
        this.album_id = parcel.readInt();
        this.owner_id = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.text = parcel.readString();
        this.date = parcel.readLong();
        this.src = (VKPhotoSizes) parcel.readParcelable(VKPhotoSizes.class.getClassLoader());
        this.photo_75 = parcel.readString();
        this.photo_130 = parcel.readString();
        this.photo_604 = parcel.readString();
        this.photo_807 = parcel.readString();
        this.photo_1280 = parcel.readString();
        this.photo_2560 = parcel.readString();
        boolean z = true;
        this.user_likes = parcel.readByte() != 0;
        this.can_comment = parcel.readByte() == 0 ? false : z;
        this.likes = parcel.readInt();
        this.comments = parcel.readInt();
        this.tags = parcel.readInt();
        this.access_key = parcel.readString();
    }

    public VKApiPhoto(String str) {
        if (str.startsWith("photo")) {
            String[] split = str.substring(5).split("_");
            this.owner_id = Integer.parseInt(split[0]);
            this.id = Integer.parseInt(split[1]);
        }
    }

    public VKApiPhoto() {
    }
}
