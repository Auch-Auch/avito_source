package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.vk.sdk.api.VKApiConst;
import org.json.JSONException;
import org.json.JSONObject;
public class VKApiDialog extends VKApiModel implements Identifiable, Parcelable {
    public static Parcelable.Creator<VKApiDialog> CREATOR = new a();
    public VKApiMessage message;
    public int unread;

    public static class a implements Parcelable.Creator<VKApiDialog> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiDialog createFromParcel(Parcel parcel) {
            return new VKApiDialog(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiDialog[] newArray(int i) {
            return new VKApiDialog[i];
        }
    }

    public VKApiDialog(JSONObject jSONObject) throws JSONException {
        parse(jSONObject);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.vk.sdk.api.model.Identifiable
    public int getId() {
        return this.message.getId();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.unread);
        parcel.writeParcelable(this.message, i);
    }

    @Override // com.vk.sdk.api.model.VKApiModel
    public VKApiDialog parse(JSONObject jSONObject) throws JSONException {
        this.unread = jSONObject.optInt(VKApiConst.UNREAD);
        this.message = new VKApiMessage(jSONObject.optJSONObject("message"));
        return this;
    }

    public VKApiDialog(Parcel parcel) {
        this.unread = parcel.readInt();
        this.message = (VKApiMessage) parcel.readParcelable(VKApiMessage.class.getClassLoader());
    }

    public VKApiDialog() {
    }
}
