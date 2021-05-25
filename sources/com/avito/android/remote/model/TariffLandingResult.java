package com.avito.android.remote.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u00020\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/TariffLandingResult;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/TariffLandingSection;", "list", "Ljava/util/List;", "getList", "()Ljava/util/List;", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Action;Ljava/util/List;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffLandingResult {
    @SerializedName("action")
    @NotNull
    private final Action action;
    @SerializedName("list")
    @NotNull
    private final List<TariffLandingSection> list;
    @SerializedName("title")
    @NotNull
    private final String title;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.avito.android.remote.model.TariffLandingSection> */
    /* JADX WARN: Multi-variable type inference failed */
    public TariffLandingResult(@NotNull String str, @NotNull Action action2, @NotNull List<? extends TariffLandingSection> list2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(action2, "action");
        Intrinsics.checkNotNullParameter(list2, "list");
        this.title = str;
        this.action = action2;
        this.list = list2;
    }

    @NotNull
    public final Action getAction() {
        return this.action;
    }

    @NotNull
    public final List<TariffLandingSection> getList() {
        return this.list;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
