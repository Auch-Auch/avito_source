package com.avito.android.remote.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/model/VasUnionResult;", "", "", "Lcom/avito/android/remote/model/VasUnionTab;", "tabs", "Ljava/util/List;", "getTabs", "()Ljava/util/List;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "description", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class VasUnionResult {
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("tabs")
    @NotNull
    private final List<VasUnionTab> tabs;
    @SerializedName("title")
    @NotNull
    private final String title;

    public VasUnionResult(@NotNull String str, @Nullable String str2, @NotNull List<VasUnionTab> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "tabs");
        this.title = str;
        this.description = str2;
        this.tabs = list;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final List<VasUnionTab> getTabs() {
        return this.tabs;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
