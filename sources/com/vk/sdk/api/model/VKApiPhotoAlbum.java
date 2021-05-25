package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.share.internal.ShareConstants;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKAttachments;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.avito.android.persistence.messenger.ChannelEntity;
public class VKApiPhotoAlbum extends VKAttachments.VKApiAttachment implements Parcelable, Identifiable {
    public static final String COVER_M = "http://vk.com/images/m_noalbum.png";
    public static final String COVER_S = "http://vk.com/images/s_noalbum.png";
    public static final String COVER_X = "http://vk.com/images/x_noalbum.png";
    public static Parcelable.Creator<VKApiPhotoAlbum> CREATOR = new a();
    public boolean can_upload;
    public long created;
    public String description;
    public int id;
    public int owner_id;
    public VKPhotoSizes photo = new VKPhotoSizes();
    public int privacy;
    public int size;
    public int thumb_id;
    public String thumb_src;
    public String title;
    public long updated;

    public static class a implements Parcelable.Creator<VKApiPhotoAlbum> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiPhotoAlbum createFromParcel(Parcel parcel) {
            return new VKApiPhotoAlbum(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiPhotoAlbum[] newArray(int i) {
            return new VKApiPhotoAlbum[i];
        }
    }

    public VKApiPhotoAlbum(JSONObject jSONObject) throws JSONException {
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
        return VKAttachments.TYPE_ALBUM;
    }

    public boolean isClosed() {
        return this.privacy != 0;
    }

    @Override // com.vk.sdk.api.model.VKAttachments.VKApiAttachment
    public CharSequence toAttachmentString() {
        StringBuilder sb = new StringBuilder(VKAttachments.TYPE_ALBUM);
        sb.append(this.owner_id);
        sb.append('_');
        sb.append(this.id);
        return sb;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.title);
        parcel.writeInt(this.size);
        parcel.writeInt(this.privacy);
        parcel.writeString(this.description);
        parcel.writeInt(this.owner_id);
        parcel.writeByte(this.can_upload ? (byte) 1 : 0);
        parcel.writeLong(this.updated);
        parcel.writeLong(this.created);
        parcel.writeInt(this.thumb_id);
        parcel.writeString(this.thumb_src);
        parcel.writeParcelable(this.photo, i);
    }

    @Override // com.vk.sdk.api.model.VKApiModel
    public VKApiPhotoAlbum parse(JSONObject jSONObject) {
        this.id = jSONObject.optInt("id");
        this.thumb_id = jSONObject.optInt("thumb_id");
        this.owner_id = jSONObject.optInt(VKApiConst.OWNER_ID);
        this.title = jSONObject.optString("title");
        this.description = jSONObject.optString("description");
        this.created = jSONObject.optLong("created");
        this.updated = jSONObject.optLong(ChannelEntity.COLUMN_UPDATED);
        this.size = jSONObject.optInt("size");
        this.can_upload = AppCompatDelegateImpl.i.t1(jSONObject, "can_upload");
        this.thumb_src = jSONObject.optString("thumb_src");
        if (jSONObject.has(ShareConstants.WEB_DIALOG_PARAM_PRIVACY)) {
            this.privacy = jSONObject.optInt(ShareConstants.WEB_DIALOG_PARAM_PRIVACY);
        } else {
            this.privacy = VKPrivacy.parsePrivacy(jSONObject.optJSONObject("privacy_view"));
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("sizes");
        if (optJSONArray != null) {
            this.photo.fill(optJSONArray);
        } else {
            this.photo.add((VKPhotoSizes) VKApiPhotoSize.create(COVER_S, 75, 55));
            this.photo.add((VKPhotoSizes) VKApiPhotoSize.create(COVER_M, 130, 97));
            this.photo.add((VKPhotoSizes) VKApiPhotoSize.create(COVER_X, 432, 249));
            this.photo.sort();
        }
        return this;
    }

    public VKApiPhotoAlbum(Parcel parcel) {
        this.id = parcel.readInt();
        this.title = parcel.readString();
        this.size = parcel.readInt();
        this.privacy = parcel.readInt();
        this.description = parcel.readString();
        this.owner_id = parcel.readInt();
        this.can_upload = parcel.readByte() != 0;
        this.updated = parcel.readLong();
        this.created = parcel.readLong();
        this.thumb_id = parcel.readInt();
        this.thumb_src = parcel.readString();
        this.photo = (VKPhotoSizes) parcel.readParcelable(VKPhotoSizes.class.getClassLoader());
    }

    public VKApiPhotoAlbum() {
    }
}
