package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.avito.android.remote.model.Sort;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.vk.sdk.api.VKApiConst;
import org.json.JSONException;
import org.json.JSONObject;
public class VKApiMessage extends VKApiModel implements Identifiable, Parcelable {
    public static Parcelable.Creator<VKApiMessage> CREATOR = new a();
    public VKAttachments attachments = new VKAttachments();
    public String body;
    public long date;
    public boolean deleted;
    public boolean emoji;
    public VKList<VKApiMessage> fwd_messages;
    public int id;
    public boolean out;
    public boolean read_state;
    public String title;
    public int user_id;

    public static class a implements Parcelable.Creator<VKApiMessage> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiMessage createFromParcel(Parcel parcel) {
            return new VKApiMessage(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiMessage[] newArray(int i) {
            return new VKApiMessage[i];
        }
    }

    public VKApiMessage(JSONObject jSONObject) throws JSONException {
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
        parcel.writeInt(this.user_id);
        parcel.writeLong(this.date);
        parcel.writeByte(this.read_state ? (byte) 1 : 0);
        parcel.writeByte(this.out ? (byte) 1 : 0);
        parcel.writeString(this.title);
        parcel.writeString(this.body);
        parcel.writeParcelable(this.attachments, i);
        parcel.writeParcelable(this.fwd_messages, i);
        parcel.writeByte(this.emoji ? (byte) 1 : 0);
        parcel.writeByte(this.deleted ? (byte) 1 : 0);
    }

    @Override // com.vk.sdk.api.model.VKApiModel
    public VKApiMessage parse(JSONObject jSONObject) throws JSONException {
        this.id = jSONObject.optInt("id");
        this.user_id = jSONObject.optInt("user_id");
        this.date = jSONObject.optLong(Sort.DATE);
        this.read_state = AppCompatDelegateImpl.i.t1(jSONObject, "read_state");
        this.out = AppCompatDelegateImpl.i.t1(jSONObject, VKApiConst.OUT);
        this.title = jSONObject.optString("title");
        this.body = jSONObject.optString(SDKConstants.PARAM_A2U_BODY);
        this.attachments.fill(jSONObject.optJSONArray(VKApiConst.ATTACHMENTS));
        this.fwd_messages = new VKList<>(jSONObject.optJSONArray("fwd_messages"), VKApiMessage.class);
        this.emoji = AppCompatDelegateImpl.i.t1(jSONObject, "emoji");
        this.deleted = AppCompatDelegateImpl.i.t1(jSONObject, "deleted");
        return this;
    }

    public VKApiMessage(Parcel parcel) {
        this.id = parcel.readInt();
        this.user_id = parcel.readInt();
        this.date = parcel.readLong();
        boolean z = true;
        this.read_state = parcel.readByte() != 0;
        this.out = parcel.readByte() != 0;
        this.title = parcel.readString();
        this.body = parcel.readString();
        this.attachments = (VKAttachments) parcel.readParcelable(VKAttachments.class.getClassLoader());
        this.fwd_messages = (VKList) parcel.readParcelable(VKList.class.getClassLoader());
        this.emoji = parcel.readByte() != 0;
        this.deleted = parcel.readByte() == 0 ? false : z;
    }

    public VKApiMessage() {
    }
}
