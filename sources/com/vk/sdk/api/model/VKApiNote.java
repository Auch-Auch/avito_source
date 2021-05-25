package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Sort;
import com.vk.sdk.api.model.VKAttachments;
import org.json.JSONException;
import org.json.JSONObject;
public class VKApiNote extends VKAttachments.VKApiAttachment implements Identifiable, Parcelable {
    public static Parcelable.Creator<VKApiNote> CREATOR = new a();
    public int comments;
    public long date;
    public int id;
    public int read_comments;
    public String text;
    public String title;
    public int user_id;
    public String view_url;

    public static class a implements Parcelable.Creator<VKApiNote> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiNote createFromParcel(Parcel parcel) {
            return new VKApiNote(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiNote[] newArray(int i) {
            return new VKApiNote[i];
        }
    }

    public VKApiNote(JSONObject jSONObject) throws JSONException {
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
        return VKAttachments.TYPE_NOTE;
    }

    @Override // com.vk.sdk.api.model.VKAttachments.VKApiAttachment
    public CharSequence toAttachmentString() {
        StringBuilder sb = new StringBuilder(VKAttachments.TYPE_NOTE);
        sb.append(this.user_id);
        sb.append('_');
        sb.append(this.id);
        return sb;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeInt(this.user_id);
        parcel.writeString(this.title);
        parcel.writeString(this.text);
        parcel.writeLong(this.date);
        parcel.writeInt(this.comments);
        parcel.writeInt(this.read_comments);
        parcel.writeString(this.view_url);
    }

    @Override // com.vk.sdk.api.model.VKApiModel
    public VKApiNote parse(JSONObject jSONObject) {
        this.id = jSONObject.optInt("id");
        this.user_id = jSONObject.optInt("user_id");
        this.title = jSONObject.optString("title");
        this.text = jSONObject.optString("text");
        this.date = jSONObject.optLong(Sort.DATE);
        this.comments = jSONObject.optInt("comments");
        this.read_comments = jSONObject.optInt("read_comments");
        this.view_url = jSONObject.optString("view_url");
        return this;
    }

    public VKApiNote(Parcel parcel) {
        this.id = parcel.readInt();
        this.user_id = parcel.readInt();
        this.title = parcel.readString();
        this.text = parcel.readString();
        this.date = parcel.readLong();
        this.comments = parcel.readInt();
        this.read_comments = parcel.readInt();
        this.view_url = parcel.readString();
    }

    public VKApiNote() {
    }
}
