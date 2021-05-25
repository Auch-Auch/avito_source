package com.avito.android.remote.model;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.avito.android.BuildConfig;
public class DfpTargetingParams implements Parcelable {
    private static final String CITY_ID = "g_city";
    public static final Parcelable.Creator<DfpTargetingParams> CREATOR = new Parcelable.Creator<DfpTargetingParams>() { // from class: com.avito.android.remote.model.DfpTargetingParams.1
        @Override // android.os.Parcelable.Creator
        public DfpTargetingParams createFromParcel(Parcel parcel) {
            return new DfpTargetingParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DfpTargetingParams[] newArray(int i) {
            return new DfpTargetingParams[i];
        }
    };
    private static final String MASTER_CATEGORY = "master_category";
    private static final String PAGE_TYPE = "page_type";
    private static final String REGION_ID = "g_reg";
    private static final String SLAVE_CATEGORY = "slave_category";
    @NonNull
    private final Bundle mBundle;

    private DfpTargetingParams() {
        this.mBundle = new Bundle(5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public Bundle getBundle() {
        return this.mBundle;
    }

    public DfpTargetingParams setCategory(@Nullable Category category) {
        if (category == null || category.isNull()) {
            this.mBundle.putString(MASTER_CATEGORY, BuildConfig.ADJUST_DEFAULT_TRACKER);
        } else if (category.getHasParent()) {
            this.mBundle.putString(SLAVE_CATEGORY, category.getId());
            this.mBundle.putString(MASTER_CATEGORY, category.getParentId());
        } else {
            this.mBundle.putString(MASTER_CATEGORY, category.getId());
        }
        return this;
    }

    public DfpTargetingParams setLocation(@Nullable Location location) {
        if (location == null) {
            return this;
        }
        this.mBundle.putString(CITY_ID, location.getId());
        if (location.getParent() != null) {
            this.mBundle.putString(REGION_ID, location.getParent().getId());
        } else if (location.getHasChildren()) {
            this.mBundle.putString(REGION_ID, location.getId());
        }
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.mBundle);
    }

    public DfpTargetingParams(@NonNull String str) {
        this();
        this.mBundle.putString(PAGE_TYPE, str);
    }

    public DfpTargetingParams(@Nullable Bundle bundle) {
        this();
        if (bundle != null) {
            this.mBundle.putAll(bundle);
        }
    }

    public DfpTargetingParams(@NonNull TargetingParams targetingParams) {
        this(targetingParams.getPageType());
        setCategory(targetingParams.getCategory());
        setLocation(targetingParams.getLocation());
    }

    @SuppressLint({"ParcelClassLoader"})
    public DfpTargetingParams(Parcel parcel) {
        this.mBundle = parcel.readBundle();
    }
}
