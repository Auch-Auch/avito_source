package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.avito.android.util.UrlParams;
public class PageParams implements Parcelable {
    public static final Parcelable.Creator<PageParams> CREATOR = new Parcelable.Creator<PageParams>() { // from class: com.avito.android.remote.model.PageParams.1
        @Override // android.os.Parcelable.Creator
        public PageParams createFromParcel(Parcel parcel) {
            return new PageParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PageParams[] newArray(int i) {
            return new PageParams[i];
        }
    };
    public static final int FIRST_PAGE = 1;
    @Nullable
    private final Long mLastStamp;
    @Nullable
    private final Integer mLimit;
    @Nullable
    private final String mNextPageId;
    private final int mPage;

    public static class Builder {
        @Nullable
        private Long mLastStamp;
        @Nullable
        private Integer mLimit;
        @Nullable
        private String mNextPageId;
        private int mPage;

        public PageParams build() {
            return new PageParams(this.mPage, this.mLastStamp, this.mLimit, this.mNextPageId);
        }

        public Builder incrementPage() {
            this.mPage++;
            return this;
        }

        public Builder lastStamp(@Nullable Long l) {
            this.mLastStamp = l;
            return this;
        }

        public Builder limit(@Nullable Integer num) {
            this.mLimit = num;
            return this;
        }

        public Builder nextPageId(@Nullable String str) {
            this.mNextPageId = str;
            return this;
        }

        public Builder page(int i) {
            if (i < 1) {
                this.mPage = 1;
            } else {
                this.mPage = i;
            }
            return this;
        }

        public Builder() {
            this.mLimit = 30;
        }

        private Builder(@NonNull PageParams pageParams) {
            this.mLimit = 30;
            this.mPage = pageParams.mPage;
            this.mLastStamp = pageParams.mLastStamp;
            this.mLimit = pageParams.mLimit;
            this.mNextPageId = pageParams.mNextPageId;
        }
    }

    public static PageParams newLimitParams(int i) {
        return new Builder().page(1).limit(Integer.valueOf(i)).build();
    }

    public static Bundle toBundle(@Nullable PageParams pageParams) {
        Bundle bundle = new Bundle();
        if (pageParams == null) {
            return bundle;
        }
        bundle.putInt("page", pageParams.getPage());
        if (pageParams.getLastStamp() != null) {
            bundle.putLong(UrlParams.LAST_STAMP, pageParams.getLastStamp().longValue());
        }
        if (pageParams.getLimit() != null) {
            bundle.putInt("limit", pageParams.getLimit().intValue());
        }
        if (pageParams.getNextPageId() != null) {
            bundle.putString(UrlParams.NEXT_PAGE_ID, pageParams.mNextPageId);
        }
        return bundle;
    }

    @NonNull
    public Builder builder() {
        return new Builder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PageParams)) {
            return false;
        }
        PageParams pageParams = (PageParams) obj;
        if (this.mPage != pageParams.mPage) {
            return false;
        }
        Long l = this.mLastStamp;
        if (l == null ? pageParams.mLastStamp != null : !l.equals(pageParams.mLastStamp)) {
            return false;
        }
        Integer num = this.mLimit;
        Integer num2 = pageParams.mLimit;
        return num == null ? num2 == null : num.equals(num2);
    }

    @Nullable
    public Long getLastStamp() {
        return this.mLastStamp;
    }

    @Nullable
    public Integer getLimit() {
        return this.mLimit;
    }

    @Nullable
    public String getNextPageId() {
        return this.mNextPageId;
    }

    public int getPage() {
        return this.mPage;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = this.mPage * 31;
        Long l = this.mLastStamp;
        int i2 = 0;
        int hashCode = (i + (l != null ? l.hashCode() : 0)) * 31;
        Integer num = this.mLimit;
        if (num != null) {
            i2 = num.hashCode();
        }
        return hashCode + i2;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder L = a.L("PageParams{mPage=");
        L.append(this.mPage);
        L.append(", mLimit=");
        L.append(this.mLimit);
        L.append(", mLastStamp=");
        L.append(this.mLastStamp);
        L.append(", mNextPageId=");
        L.append(this.mNextPageId);
        L.append(", ");
        return a.s(L, super.toString(), '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mPage);
        parcel.writeValue(this.mLastStamp);
        parcel.writeValue(this.mLimit);
        parcel.writeString(this.mNextPageId);
    }

    private PageParams(int i, @Nullable Long l, @Nullable Integer num, @Nullable String str) {
        this.mPage = i;
        this.mLastStamp = l;
        this.mLimit = num;
        this.mNextPageId = str;
    }

    private PageParams(Parcel parcel) {
        this.mPage = parcel.readInt();
        this.mLastStamp = (Long) parcel.readValue(Long.class.getClassLoader());
        this.mLimit = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.mNextPageId = parcel.readString();
    }
}
