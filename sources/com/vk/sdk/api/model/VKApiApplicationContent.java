package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.vk.sdk.api.model.VKAttachments;
import org.json.JSONObject;
public class VKApiApplicationContent extends VKAttachments.VKApiAttachment implements Parcelable {
    public static Parcelable.Creator<VKApiApplicationContent> CREATOR = new a();
    public int id;
    public String name;
    public VKPhotoSizes photo = new VKPhotoSizes();
    public String photo_130;
    public String photo_604;

    public static class a implements Parcelable.Creator<VKApiApplicationContent> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiApplicationContent createFromParcel(Parcel parcel) {
            return new VKApiApplicationContent(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiApplicationContent[] newArray(int i) {
            return new VKApiApplicationContent[i];
        }
    }

    public VKApiApplicationContent(JSONObject jSONObject) {
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
        return "app";
    }

    @Override // com.vk.sdk.api.model.VKAttachments.VKApiAttachment
    public CharSequence toAttachmentString() {
        throw new UnsupportedOperationException("Attaching app info is not supported by VK.com API");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.photo_130);
        parcel.writeString(this.photo_604);
        parcel.writeParcelable(this.photo, i);
    }

    @Override // com.vk.sdk.api.model.VKApiModel
    public VKApiApplicationContent parse(JSONObject jSONObject) {
        this.id = jSONObject.optInt("id");
        this.name = jSONObject.optString("name");
        String optString = jSONObject.optString("photo_130");
        this.photo_130 = optString;
        if (!TextUtils.isEmpty(optString)) {
            this.photo.add((VKPhotoSizes) VKApiPhotoSize.create(this.photo_130, 130));
        }
        String optString2 = jSONObject.optString("photo_604");
        this.photo_604 = optString2;
        if (!TextUtils.isEmpty(optString2)) {
            this.photo.add((VKPhotoSizes) VKApiPhotoSize.create(this.photo_604, 604));
        }
        return this;
    }

    public VKApiApplicationContent(Parcel parcel) {
        this.id = parcel.readInt();
        this.name = parcel.readString();
        this.photo_130 = parcel.readString();
        this.photo_604 = parcel.readString();
        this.photo = (VKPhotoSizes) parcel.readParcelable(VKPhotoSizes.class.getClassLoader());
    }

    public VKApiApplicationContent() {
    }
}
