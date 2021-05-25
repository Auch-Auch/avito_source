package com.avito.android.remote.model.field;
public interface ErrorHolder {
    void clearError();

    String getError();

    boolean hasError();

    void setError(String str);
}
