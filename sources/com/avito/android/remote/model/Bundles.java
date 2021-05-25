package com.avito.android.remote.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/avito/android/remote/model/Bundles;", "", "Lcom/avito/android/remote/model/Action;", "emptyAction", "Lcom/avito/android/remote/model/Action;", "getEmptyAction", "()Lcom/avito/android/remote/model/Action;", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/VasBundle;", "list", "Ljava/util/List;", "getList", "()Ljava/util/List;", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/Action;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class Bundles {
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("emptyAction")
    @Nullable
    private final Action emptyAction;
    @SerializedName("list")
    @NotNull
    private final List<VasBundle> list;
    @SerializedName("title")
    @Nullable
    private final String title;

    public Bundles(@Nullable String str, @Nullable String str2, @NotNull List<VasBundle> list2, @Nullable Action action) {
        Intrinsics.checkNotNullParameter(list2, "list");
        this.title = str;
        this.description = str2;
        this.list = list2;
        this.emptyAction = action;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Action getEmptyAction() {
        return this.emptyAction;
    }

    @NotNull
    public final List<VasBundle> getList() {
        return this.list;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }
}
