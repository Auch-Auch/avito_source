package com.avito.android.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/model/VasUnionTab;", "", "", "selected", "Z", "getSelected", "()Z", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/VasUnionItemType;", "item", "Lcom/avito/android/remote/model/VasUnionItemType;", "getItem", "()Lcom/avito/android/remote/model/VasUnionItemType;", "<init>", "(Ljava/lang/String;ZLcom/avito/android/remote/model/VasUnionItemType;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class VasUnionTab {
    @SerializedName("item")
    @NotNull
    private final VasUnionItemType item;
    @SerializedName("selected")
    private final boolean selected;
    @SerializedName("title")
    @NotNull
    private final String title;

    public VasUnionTab(@NotNull String str, boolean z, @NotNull VasUnionItemType vasUnionItemType) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(vasUnionItemType, "item");
        this.title = str;
        this.selected = z;
        this.item = vasUnionItemType;
    }

    @NotNull
    public final VasUnionItemType getItem() {
        return this.item;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
