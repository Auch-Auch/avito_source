package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.avito.android.remote.model.Sort;
import com.vk.sdk.api.VKApiConst;
import org.json.JSONObject;
public class VKApiComment extends VKApiModel implements Identifiable, Parcelable {
    public static Parcelable.Creator<VKApiComment> CREATOR = new a();
    public VKAttachments attachments = new VKAttachments();
    public boolean can_like;
    public long date;
    public int from_id;
    public int id;
    public int likes;
    public int reply_to_comment;
    public int reply_to_user;
    public String text;
    public boolean user_likes;

    public static class a implements Parcelable.Creator<VKApiComment> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiComment createFromParcel(Parcel parcel) {
            return new VKApiComment(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiComment[] newArray(int i) {
            return new VKApiComment[i];
        }
    }

    public VKApiComment(JSONObject jSONObject) {
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeInt(this.from_id);
        parcel.writeLong(this.date);
        parcel.writeString(this.text);
        parcel.writeInt(this.reply_to_user);
        parcel.writeInt(this.reply_to_comment);
        parcel.writeInt(this.likes);
        parcel.writeByte(this.user_likes ? (byte) 1 : 0);
        parcel.writeByte(this.can_like ? (byte) 1 : 0);
        parcel.writeParcelable(this.attachments, i);
    }

    @Override // com.vk.sdk.api.model.VKApiModel
    public VKApiComment parse(JSONObject jSONObject) {
        this.id = jSONObject.optInt("id");
        this.from_id = jSONObject.optInt("from_id");
        this.date = jSONObject.optLong(Sort.DATE);
        this.text = jSONObject.optString("text");
        this.reply_to_user = jSONObject.optInt("reply_to_user");
        this.reply_to_comment = jSONObject.optInt("reply_to_comment");
        this.attachments.fill(jSONObject.optJSONArray(VKApiConst.ATTACHMENTS));
        JSONObject optJSONObject = jSONObject.optJSONObject("likes");
        this.likes = AppCompatDelegateImpl.i.u1(optJSONObject, "count");
        this.user_likes = AppCompatDelegateImpl.i.t1(optJSONObject, "user_likes");
        this.can_like = AppCompatDelegateImpl.i.t1(optJSONObject, "can_like");
        return this;
    }

    public VKApiComment(Parcel parcel) {
        this.id = parcel.readInt();
        this.from_id = parcel.readInt();
        this.date = parcel.readLong();
        this.text = parcel.readString();
        this.reply_to_user = parcel.readInt();
        this.reply_to_comment = parcel.readInt();
        this.likes = parcel.readInt();
        boolean z = true;
        this.user_likes = parcel.readByte() != 0;
        this.can_like = parcel.readByte() == 0 ? false : z;
        this.attachments = (VKAttachments) parcel.readParcelable(VKAttachments.class.getClassLoader());
    }

    public VKApiComment() {
    }
}
