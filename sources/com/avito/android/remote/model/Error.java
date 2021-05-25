package com.avito.android.remote.model;

import androidx.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
public class Error implements Serializable {
    private static final long serialVersionUID = 1;
    @SerializedName("code")
    public int code;
    @Nullable
    public Map<String, String> paramsMessages;
    @Nullable
    @SerializedName("message")
    public String simpleMessage;

    public Error() {
    }

    public boolean isPlural() {
        return this.paramsMessages != null;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.simpleMessage;
    }

    public Error(int i, @Nullable String str) {
        this.code = i;
        this.simpleMessage = str;
    }
}
