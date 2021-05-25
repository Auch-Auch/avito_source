package com.avito.android.remote.model.field;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.avito.android.remote.model.CategoryParam;
public class CategoryParamInputField extends CategoryParamField<String> {
    public static final Parcelable.Creator<CategoryParamInputField> CREATOR = new Parcelable.Creator<CategoryParamInputField>() { // from class: com.avito.android.remote.model.field.CategoryParamInputField.1
        @Override // android.os.Parcelable.Creator
        public CategoryParamInputField createFromParcel(Parcel parcel) {
            return new CategoryParamInputField(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CategoryParamInputField[] newArray(int i) {
            return new CategoryParamInputField[i];
        }
    };

    public CategoryParamInputField(CategoryParam categoryParam, @Nullable String str, @Nullable String str2, OnFieldValueChangedListener onFieldValueChangedListener) {
        super(categoryParam, str, str2, onFieldValueChangedListener);
    }

    @Override // com.avito.android.remote.model.field.CategoryParamField, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mValue);
    }

    public CategoryParamInputField(Parcel parcel) {
        super(parcel);
        this.mValue = (T) parcel.readString();
    }
}
