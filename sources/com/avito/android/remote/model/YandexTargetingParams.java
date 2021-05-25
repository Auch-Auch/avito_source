package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;
public class YandexTargetingParams implements Parcelable {
    public static final Parcelable.Creator<YandexTargetingParams> CREATOR = new Parcelable.Creator<YandexTargetingParams>() { // from class: com.avito.android.remote.model.YandexTargetingParams.1
        @Override // android.os.Parcelable.Creator
        public YandexTargetingParams createFromParcel(Parcel parcel) {
            return new YandexTargetingParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public YandexTargetingParams[] newArray(int i) {
            return new YandexTargetingParams[i];
        }
    };
    @Nullable
    private Category mCategory;
    @Nullable
    private List<String> mItemTitles = Collections.emptyList();
    @Nullable
    private String mSearchQuery;

    public YandexTargetingParams() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public Category getCategory() {
        return this.mCategory;
    }

    @Nullable
    public List<String> getItemTitles() {
        return this.mItemTitles;
    }

    @Nullable
    public String getSearchQuery() {
        return this.mSearchQuery;
    }

    public YandexTargetingParams setCategory(@Nullable Category category) {
        if (category == null || category.isNull()) {
            this.mCategory = null;
        } else {
            this.mCategory = category;
        }
        return this;
    }

    public YandexTargetingParams setItemTitles(@Nullable List<String> list) {
        this.mItemTitles = list;
        return this;
    }

    public YandexTargetingParams setSearchQuery(@Nullable String str) {
        this.mSearchQuery = str;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mSearchQuery);
        parcel.writeParcelable(this.mCategory, i);
        parcel.writeStringList(this.mItemTitles);
    }

    public YandexTargetingParams(@NonNull TargetingParams targetingParams) {
        setCategory(targetingParams.getCategory());
        setSearchQuery(targetingParams.getSearchQuery());
    }

    public YandexTargetingParams(Parcel parcel) {
        this.mSearchQuery = parcel.readString();
        this.mCategory = (Category) parcel.readParcelable(Category.class.getClassLoader());
        this.mItemTitles = parcel.createStringArrayList();
    }
}
