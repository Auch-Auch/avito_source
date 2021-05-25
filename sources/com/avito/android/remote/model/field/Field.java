package com.avito.android.remote.model.field;
public interface Field<T> {
    String getId();

    T getValue();

    void setValue(T t);
}
