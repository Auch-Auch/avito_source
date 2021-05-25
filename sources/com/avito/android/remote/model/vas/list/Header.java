package com.avito.android.remote.model.vas.list;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/vas/list/Header;", "Lcom/avito/android/remote/model/vas/list/VasElement;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "vas_release"}, k = 1, mv = {1, 4, 2})
public final class Header implements VasElement {
    @SerializedName("title")
    @NotNull
    private final String title;

    public Header(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
