package com.avito.android.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/ParamKeyValue;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "value", "getValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class ParamKeyValue {
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("value")
    @NotNull
    private final String value;

    public ParamKeyValue(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "value");
        this.id = str;
        this.value = str2;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
