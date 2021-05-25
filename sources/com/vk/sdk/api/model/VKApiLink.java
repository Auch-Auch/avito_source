package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.vk.sdk.api.model.VKAttachments;
import org.json.JSONException;
import org.json.JSONObject;
public class VKApiLink extends VKAttachments.VKApiAttachment implements Parcelable {
    public static Parcelable.Creator<VKApiLink> CREATOR = new a();
    public String description;
    public String image_src;
    public String preview_page;
    public String title;
    public String url;

    public static class a implements Parcelable.Creator<VKApiLink> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiLink createFromParcel(Parcel parcel) {
            return new VKApiLink(parcel, null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiLink[] newArray(int i) {
            return new VKApiLink[i];
        }
    }

    public VKApiLink(String str) {
        this.url = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.vk.sdk.api.model.Identifiable
    public int getId() {
        return 0;
    }

    @Override // com.vk.sdk.api.model.VKAttachments.VKApiAttachment
    public String getType() {
        return "link";
    }

    @Override // com.vk.sdk.api.model.VKAttachments.VKApiAttachment
    public CharSequence toAttachmentString() {
        return this.url;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.image_src);
        parcel.writeString(this.preview_page);
    }

    @Override // com.vk.sdk.api.model.VKApiModel
    public VKApiLink parse(JSONObject jSONObject) {
        this.url = jSONObject.optString("url");
        this.title = jSONObject.optString("title");
        this.description = jSONObject.optString("description");
        this.image_src = jSONObject.optString("image_src");
        this.preview_page = jSONObject.optString("preview_page");
        return this;
    }

    public VKApiLink(JSONObject jSONObject) throws JSONException {
        parse(jSONObject);
    }

    public VKApiLink(Parcel parcel, a aVar) {
        this.url = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.image_src = parcel.readString();
        this.preview_page = parcel.readString();
    }

    public VKApiLink() {
    }
}
