package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
public class VKApiGetMessagesResponse extends VKApiModel implements Parcelable {
    public static Parcelable.Creator<VKApiGetMessagesResponse> CREATOR = new a();
    public int count;
    public VKList<VKApiMessage> items;

    public static class a implements Parcelable.Creator<VKApiGetMessagesResponse> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiGetMessagesResponse createFromParcel(Parcel parcel) {
            return new VKApiGetMessagesResponse(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiGetMessagesResponse[] newArray(int i) {
            return new VKApiGetMessagesResponse[i];
        }
    }

    public VKApiGetMessagesResponse(JSONObject jSONObject) {
        parse(jSONObject);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.count);
        parcel.writeParcelable(this.items, i);
    }

    @Override // com.vk.sdk.api.model.VKApiModel
    public VKApiGetMessagesResponse parse(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(CommonKt.EXTRA_RESPONSE);
        this.count = optJSONObject.optInt("count");
        this.items = new VKList<>(optJSONObject.optJSONArray("items"), VKApiMessage.class);
        return this;
    }

    public VKApiGetMessagesResponse(Parcel parcel) {
        this.count = parcel.readInt();
        this.items = (VKList) parcel.readParcelable(VKList.class.getClassLoader());
    }

    public VKApiGetMessagesResponse() {
    }
}
