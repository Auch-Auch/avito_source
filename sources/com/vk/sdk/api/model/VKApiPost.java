package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.avito.android.remote.model.Sort;
import com.avito.android.util.preferences.Names;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKAttachments;
import org.json.JSONException;
import org.json.JSONObject;
public class VKApiPost extends VKAttachments.VKApiAttachment implements Identifiable, Parcelable {
    public static Parcelable.Creator<VKApiPost> CREATOR = new a();
    public VKAttachments attachments = new VKAttachments();
    public boolean can_like;
    public boolean can_post_comment;
    public boolean can_publish;
    public int comments_count;
    public VKList<VKApiPost> copy_history;
    public long date;
    public boolean friends_only;
    public int from_id;
    public VKApiPlace geo;
    public int id;
    public int likes_count;
    public String post_type;
    public int reply_owner_id;
    public int reply_post_id;
    public int reposts_count;
    public int signer_id;
    public String text;
    public int to_id;
    public boolean user_likes;
    public boolean user_reposted;

    public static class a implements Parcelable.Creator<VKApiPost> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiPost createFromParcel(Parcel parcel) {
            return new VKApiPost(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiPost[] newArray(int i) {
            return new VKApiPost[i];
        }
    }

    public VKApiPost(JSONObject jSONObject) throws JSONException {
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
        return "wall";
    }

    @Override // com.vk.sdk.api.model.VKAttachments.VKApiAttachment
    public CharSequence toAttachmentString() {
        StringBuilder sb = new StringBuilder("wall");
        sb.append(this.to_id);
        sb.append('_');
        sb.append(this.id);
        return sb;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeInt(this.to_id);
        parcel.writeInt(this.from_id);
        parcel.writeLong(this.date);
        parcel.writeString(this.text);
        parcel.writeInt(this.reply_owner_id);
        parcel.writeInt(this.reply_post_id);
        parcel.writeByte(this.friends_only ? (byte) 1 : 0);
        parcel.writeInt(this.comments_count);
        parcel.writeByte(this.can_post_comment ? (byte) 1 : 0);
        parcel.writeInt(this.likes_count);
        parcel.writeByte(this.user_likes ? (byte) 1 : 0);
        parcel.writeByte(this.can_like ? (byte) 1 : 0);
        parcel.writeByte(this.can_publish ? (byte) 1 : 0);
        parcel.writeInt(this.reposts_count);
        parcel.writeByte(this.user_reposted ? (byte) 1 : 0);
        parcel.writeString(this.post_type);
        parcel.writeParcelable(this.attachments, i);
        parcel.writeParcelable(this.geo, i);
        parcel.writeInt(this.signer_id);
    }

    @Override // com.vk.sdk.api.model.VKApiModel
    public VKApiPost parse(JSONObject jSONObject) throws JSONException {
        this.id = jSONObject.optInt("id");
        this.to_id = jSONObject.optInt("to_id");
        this.from_id = jSONObject.optInt("from_id");
        this.date = jSONObject.optLong(Sort.DATE);
        this.text = jSONObject.optString("text");
        this.reply_owner_id = jSONObject.optInt("reply_owner_id");
        this.reply_post_id = jSONObject.optInt("reply_post_id");
        this.friends_only = AppCompatDelegateImpl.i.t1(jSONObject, VKApiConst.FRIENDS_ONLY);
        JSONObject optJSONObject = jSONObject.optJSONObject("comments");
        if (optJSONObject != null) {
            this.comments_count = optJSONObject.optInt("count");
            this.can_post_comment = AppCompatDelegateImpl.i.t1(optJSONObject, "can_post");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("likes");
        if (optJSONObject2 != null) {
            this.likes_count = optJSONObject2.optInt("count");
            this.user_likes = AppCompatDelegateImpl.i.t1(optJSONObject2, "user_likes");
            this.can_like = AppCompatDelegateImpl.i.t1(optJSONObject2, "can_like");
            this.can_publish = AppCompatDelegateImpl.i.t1(optJSONObject2, "can_publish");
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("reposts");
        if (optJSONObject3 != null) {
            this.reposts_count = optJSONObject3.optInt("count");
            this.user_reposted = AppCompatDelegateImpl.i.t1(optJSONObject3, "user_reposted");
        }
        this.post_type = jSONObject.optString("post_type");
        this.attachments.fill(jSONObject.optJSONArray(VKApiConst.ATTACHMENTS));
        JSONObject optJSONObject4 = jSONObject.optJSONObject(Names.GEO);
        if (optJSONObject4 != null) {
            this.geo = new VKApiPlace().parse(optJSONObject4);
        }
        this.signer_id = jSONObject.optInt("signer_id");
        this.copy_history = new VKList<>(jSONObject.optJSONArray("copy_history"), VKApiPost.class);
        return this;
    }

    public VKApiPost(Parcel parcel) {
        this.id = parcel.readInt();
        this.to_id = parcel.readInt();
        this.from_id = parcel.readInt();
        this.date = parcel.readLong();
        this.text = parcel.readString();
        this.reply_owner_id = parcel.readInt();
        this.reply_post_id = parcel.readInt();
        boolean z = true;
        this.friends_only = parcel.readByte() != 0;
        this.comments_count = parcel.readInt();
        this.can_post_comment = parcel.readByte() != 0;
        this.likes_count = parcel.readInt();
        this.user_likes = parcel.readByte() != 0;
        this.can_like = parcel.readByte() != 0;
        this.can_publish = parcel.readByte() != 0;
        this.reposts_count = parcel.readInt();
        this.user_reposted = parcel.readByte() == 0 ? false : z;
        this.post_type = parcel.readString();
        this.attachments = (VKAttachments) parcel.readParcelable(VKAttachments.class.getClassLoader());
        this.geo = (VKApiPlace) parcel.readParcelable(VKApiPlace.class.getClassLoader());
        this.signer_id = parcel.readInt();
    }

    public VKApiPost() {
    }
}
