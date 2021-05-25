package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.vk.sdk.api.model.VKAttachments;
import org.json.JSONException;
import org.json.JSONObject;
public class VKApiWikiPage extends VKAttachments.VKApiAttachment implements Parcelable {
    public static Parcelable.Creator<VKApiWikiPage> CREATOR = new a();
    public long created;
    public int creator_id;
    public boolean current_user_can_edit;
    public boolean current_user_can_edit_access;
    public long edited;
    public int editor_id;
    public int group_id;
    public int id;
    public String parent;
    public String parent2;
    public String source;
    public String title;
    public int who_can_edit;
    public int who_can_view;

    public static class a implements Parcelable.Creator<VKApiWikiPage> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiWikiPage createFromParcel(Parcel parcel) {
            return new VKApiWikiPage(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiWikiPage[] newArray(int i) {
            return new VKApiWikiPage[i];
        }
    }

    public VKApiWikiPage(JSONObject jSONObject) throws JSONException {
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
        return "page";
    }

    @Override // com.vk.sdk.api.model.VKAttachments.VKApiAttachment
    public CharSequence toAttachmentString() {
        StringBuilder sb = new StringBuilder("page");
        sb.append(this.group_id);
        sb.append('_');
        sb.append(this.id);
        return sb;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeInt(this.group_id);
        parcel.writeInt(this.creator_id);
        parcel.writeString(this.title);
        parcel.writeString(this.source);
        parcel.writeByte(this.current_user_can_edit ? (byte) 1 : 0);
        parcel.writeByte(this.current_user_can_edit_access ? (byte) 1 : 0);
        parcel.writeInt(this.who_can_view);
        parcel.writeInt(this.who_can_edit);
        parcel.writeInt(this.editor_id);
        parcel.writeLong(this.edited);
        parcel.writeLong(this.created);
        parcel.writeString(this.parent);
        parcel.writeString(this.parent2);
    }

    @Override // com.vk.sdk.api.model.VKApiModel
    public VKApiWikiPage parse(JSONObject jSONObject) {
        this.id = jSONObject.optInt("id");
        this.group_id = jSONObject.optInt("group_id");
        this.creator_id = jSONObject.optInt("creator_id");
        this.title = jSONObject.optString("title");
        this.source = jSONObject.optString("source");
        this.current_user_can_edit = AppCompatDelegateImpl.i.t1(jSONObject, "current_user_can_edit");
        this.current_user_can_edit_access = AppCompatDelegateImpl.i.t1(jSONObject, "current_user_can_edit_access");
        this.who_can_view = jSONObject.optInt("who_can_view");
        this.who_can_edit = jSONObject.optInt("who_can_edit");
        this.editor_id = jSONObject.optInt("editor_id");
        this.edited = jSONObject.optLong("edited");
        this.created = jSONObject.optLong("created");
        this.parent = jSONObject.optString("parent");
        this.parent2 = jSONObject.optString("parent2");
        return this;
    }

    public VKApiWikiPage(Parcel parcel) {
        this.id = parcel.readInt();
        this.group_id = parcel.readInt();
        this.creator_id = parcel.readInt();
        this.title = parcel.readString();
        this.source = parcel.readString();
        boolean z = true;
        this.current_user_can_edit = parcel.readByte() != 0;
        this.current_user_can_edit_access = parcel.readByte() == 0 ? false : z;
        this.who_can_view = parcel.readInt();
        this.who_can_edit = parcel.readInt();
        this.editor_id = parcel.readInt();
        this.edited = parcel.readLong();
        this.created = parcel.readLong();
        this.parent = parcel.readString();
        this.parent2 = parcel.readString();
    }

    public VKApiWikiPage() {
    }
}
