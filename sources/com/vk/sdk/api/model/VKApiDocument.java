package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.avito.android.remote.model.Sort;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKAttachments;
import org.json.JSONException;
import org.json.JSONObject;
public class VKApiDocument extends VKAttachments.VKApiAttachment implements Parcelable, Identifiable {
    public static Parcelable.Creator<VKApiDocument> CREATOR = new a();
    public String access_key;
    public boolean c;
    public boolean d;
    public long date = 0;
    public String ext;
    public int id;
    public int owner_id;
    public VKPhotoSizes photo = new VKPhotoSizes();
    public String photo_100;
    public String photo_130;
    public long size;
    public String title;
    public String url;

    public static class a implements Parcelable.Creator<VKApiDocument> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiDocument createFromParcel(Parcel parcel) {
            return new VKApiDocument(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiDocument[] newArray(int i) {
            return new VKApiDocument[i];
        }
    }

    public VKApiDocument(JSONObject jSONObject) throws JSONException {
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
        return VKAttachments.TYPE_DOC;
    }

    public boolean isGif() {
        boolean z = this.c || "gif".equals(this.ext);
        this.c = z;
        return z;
    }

    public boolean isImage() {
        boolean z = this.d || "jpg".equals(this.ext) || "jpeg".equals(this.ext) || "png".equals(this.ext) || "bmp".equals(this.ext);
        this.d = z;
        return z;
    }

    @Override // com.vk.sdk.api.model.VKAttachments.VKApiAttachment
    public CharSequence toAttachmentString() {
        StringBuilder sb = new StringBuilder(VKAttachments.TYPE_DOC);
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
        parcel.writeString(this.title);
        parcel.writeLong(this.size);
        parcel.writeString(this.ext);
        parcel.writeString(this.url);
        parcel.writeLong(this.date);
        parcel.writeString(this.photo_100);
        parcel.writeString(this.photo_130);
        parcel.writeParcelable(this.photo, i);
        parcel.writeString(this.access_key);
        parcel.writeByte(this.d ? (byte) 1 : 0);
        parcel.writeByte(this.c ? (byte) 1 : 0);
    }

    @Override // com.vk.sdk.api.model.VKApiModel
    public VKApiDocument parse(JSONObject jSONObject) {
        this.id = jSONObject.optInt("id");
        this.owner_id = jSONObject.optInt(VKApiConst.OWNER_ID);
        this.title = jSONObject.optString("title");
        this.size = jSONObject.optLong("size");
        this.ext = jSONObject.optString("ext");
        this.url = jSONObject.optString("url");
        this.access_key = jSONObject.optString("access_key");
        this.date = jSONObject.optLong(Sort.DATE, 0) * 1000;
        String optString = jSONObject.optString(VKApiUser.FIELD_PHOTO_100);
        this.photo_100 = optString;
        if (!TextUtils.isEmpty(optString)) {
            this.photo.add((VKPhotoSizes) VKApiPhotoSize.create(this.photo_100, 100, 75));
        }
        String optString2 = jSONObject.optString("photo_130");
        this.photo_130 = optString2;
        if (!TextUtils.isEmpty(optString2)) {
            this.photo.add((VKPhotoSizes) VKApiPhotoSize.create(this.photo_130, 130, 100));
        }
        this.photo.sort();
        return this;
    }

    public VKApiDocument(Parcel parcel) {
        this.id = parcel.readInt();
        this.owner_id = parcel.readInt();
        this.title = parcel.readString();
        this.size = parcel.readLong();
        this.ext = parcel.readString();
        this.url = parcel.readString();
        this.date = parcel.readLong();
        this.photo_100 = parcel.readString();
        this.photo_130 = parcel.readString();
        this.photo = (VKPhotoSizes) parcel.readParcelable(VKPhotoSizes.class.getClassLoader());
        this.access_key = parcel.readString();
        boolean z = true;
        this.d = parcel.readByte() != 0;
        this.c = parcel.readByte() == 0 ? false : z;
    }

    public VKApiDocument() {
    }
}
