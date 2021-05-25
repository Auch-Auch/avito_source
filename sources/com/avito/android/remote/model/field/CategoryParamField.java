package com.avito.android.remote.model.field;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.avito.android.remote.model.CategoryParam;
import com.avito.android.remote.model.SplitSearchParamKt;
public abstract class CategoryParamField<T> implements Field<T>, ErrorHolder, TitleHolder, Parcelable {
    private String mError;
    private OnFieldValueChangedListener mListener;
    private final CategoryParam mParam;
    @Nullable
    public final String mParentId;
    public T mValue;

    public CategoryParamField(CategoryParam categoryParam, @Nullable String str, @Nullable T t, OnFieldValueChangedListener onFieldValueChangedListener) {
        this.mParam = categoryParam;
        this.mParentId = str;
        this.mValue = t;
        this.mListener = onFieldValueChangedListener;
    }

    @Nullable
    public static String getFromId(String str) {
        if (str.endsWith(SplitSearchParamKt.SPLIT_FROM)) {
            return a.O2(str, -5, 0);
        }
        return null;
    }

    @Nullable
    public static String getToId(String str) {
        if (str.endsWith(SplitSearchParamKt.SPLIT_TO)) {
            return a.O2(str, -3, 0);
        }
        return null;
    }

    @Override // com.avito.android.remote.model.field.ErrorHolder
    public void clearError() {
        this.mError = null;
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
        return (obj instanceof CategoryParamField) && this.mParam.equals(((CategoryParamField) obj).mParam);
    }

    @Override // com.avito.android.remote.model.field.ErrorHolder
    public String getError() {
        return this.mError;
    }

    @Override // com.avito.android.remote.model.field.Field
    public String getId() {
        return this.mParam.getId();
    }

    public CategoryParam getParam() {
        return this.mParam;
    }

    public String getParentId() {
        return this.mParentId;
    }

    @Override // com.avito.android.remote.model.field.TitleHolder
    public String getTitle() {
        return this.mParam.getTitle();
    }

    @Override // com.avito.android.remote.model.field.Field
    public T getValue() {
        return this.mValue;
    }

    @Override // com.avito.android.remote.model.field.ErrorHolder
    public boolean hasError() {
        return !TextUtils.isEmpty(this.mError);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.mParam.hashCode();
    }

    public boolean isImmutable() {
        return this.mParam.isImmutable();
    }

    @Override // com.avito.android.remote.model.field.ErrorHolder
    public void setError(String str) {
        this.mError = str;
    }

    public void setListener(@NonNull OnFieldValueChangedListener onFieldValueChangedListener) {
        this.mListener = onFieldValueChangedListener;
    }

    @Override // com.avito.android.remote.model.field.Field
    public void setValue(T t) {
        this.mValue = t;
        OnFieldValueChangedListener onFieldValueChangedListener = this.mListener;
        if (onFieldValueChangedListener != null) {
            onFieldValueChangedListener.onFieldValueChanged(this);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mParentId);
        parcel.writeParcelable(this.mParam, i);
        parcel.writeString(this.mError);
    }

    public CategoryParamField(Parcel parcel) {
        this.mParentId = parcel.readString();
        this.mParam = (CategoryParam) parcel.readParcelable(CategoryParam.class.getClassLoader());
        this.mError = parcel.readString();
    }
}
