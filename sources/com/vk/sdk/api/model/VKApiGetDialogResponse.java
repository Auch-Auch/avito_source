package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
public class VKApiGetDialogResponse extends VKApiModel implements Parcelable {
    public static Parcelable.Creator<VKApiGetDialogResponse> CREATOR = new a();
    public int count;
    public VKList<VKApiDialog> items;
    public int unread_dialogs;

    public static class a implements Parcelable.Creator<VKApiGetDialogResponse> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiGetDialogResponse createFromParcel(Parcel parcel) {
            return new VKApiGetDialogResponse(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiGetDialogResponse[] newArray(int i) {
            return new VKApiGetDialogResponse[i];
        }
    }

    public VKApiGetDialogResponse(JSONObject jSONObject) {
        parse(jSONObject);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.count);
        parcel.writeInt(this.unread_dialogs);
        parcel.writeParcelable(this.items, i);
    }

    @Override // com.vk.sdk.api.model.VKApiModel
    public VKApiGetDialogResponse parse(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(CommonKt.EXTRA_RESPONSE);
        this.count = optJSONObject.optInt("count");
        this.unread_dialogs = optJSONObject.optInt("unread_dialogs");
        this.items = new VKList<>(optJSONObject.optJSONArray("items"), VKApiDialog.class);
        return this;
    }

    public VKApiGetDialogResponse(Parcel parcel) {
        this.count = parcel.readInt();
        this.unread_dialogs = parcel.readInt();
        this.items = (VKList) parcel.readParcelable(VKList.class.getClassLoader());
    }

    public VKApiGetDialogResponse() {
    }
}
