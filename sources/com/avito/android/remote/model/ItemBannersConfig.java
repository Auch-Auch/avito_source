package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ItemBannersConfig implements Parcelable, Serializable {
    public static final int[] BANNER_TYPES = {0};
    public static final Parcelable.Creator<ItemBannersConfig> CREATOR = new Parcelable.Creator<ItemBannersConfig>() { // from class: com.avito.android.remote.model.ItemBannersConfig.1
        @Override // android.os.Parcelable.Creator
        public ItemBannersConfig createFromParcel(Parcel parcel) {
            return new ItemBannersConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ItemBannersConfig[] newArray(int i) {
            return new ItemBannersConfig[i];
        }
    };
    public static final int FALLBACK_VERSION = Integer.MAX_VALUE;
    private static final long serialVersionUID = 1;
    private final int[] mVersions;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ItemBannerType {
        public static final int DFP_APP_INSTALL = 0;
    }

    public static ItemBannersConfig getDefault() {
        return new ItemBannersConfig();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public List<Integer> getEnabledBanners(int i) {
        int[] iArr = BANNER_TYPES;
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i2 : iArr) {
            if (isBannerEnabled(i2, i)) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        return arrayList;
    }

    public int getVersion(int i) {
        return this.mVersions[i];
    }

    public boolean isAnyBannerEnabled(int i) {
        for (int i2 : BANNER_TYPES) {
            if (isBannerEnabled(i2, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean isBannerEnabled(int i, int i2) {
        return i2 >= getVersion(i);
    }

    public void setVersion(int i, int i2) {
        this.mVersions[i] = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.mVersions);
    }

    private ItemBannersConfig() {
        int[] iArr = new int[BANNER_TYPES.length];
        this.mVersions = iArr;
        Arrays.fill(iArr, Integer.MAX_VALUE);
    }

    private ItemBannersConfig(Parcel parcel) {
        int[] iArr = new int[BANNER_TYPES.length];
        this.mVersions = iArr;
        parcel.readIntArray(iArr);
    }
}
