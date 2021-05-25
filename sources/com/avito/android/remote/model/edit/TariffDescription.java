package com.avito.android.remote.model.edit;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/edit/TariffDescription;", "", "", "state", "Ljava/lang/String;", "getState", "()Ljava/lang/String;", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffDescription {
    @SerializedName("state")
    @Nullable
    private final String state;
    @SerializedName("title")
    @NotNull
    private final String title;

    public TariffDescription(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
        this.state = str2;
    }

    @Nullable
    public final String getState() {
        return this.state;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
