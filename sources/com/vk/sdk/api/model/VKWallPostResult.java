package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
public class VKWallPostResult extends VKApiModel {
    public static Parcelable.Creator<VKWallPostResult> CREATOR = new a();
    public int post_id;

    public static class a implements Parcelable.Creator<VKWallPostResult> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKWallPostResult createFromParcel(Parcel parcel) {
            VKWallPostResult vKWallPostResult = new VKWallPostResult();
            vKWallPostResult.post_id = parcel.readInt();
            return vKWallPostResult;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKWallPostResult[] newArray(int i) {
            return new VKWallPostResult[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.post_id);
    }
}
