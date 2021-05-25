package com.avito.android.remote.model.field;

import com.avito.android.remote.model.field.Field;
public interface OnFieldValueChangedListener<T extends Field> {
    void onFieldValueChanged(T t);
}
