package com.avito.android.remote.model.vas.performance;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/vas/performance/VasTab;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "selected", "Z", "getSelected", "()Z", "", "Lcom/avito/android/remote/model/vas/performance/PerformanceVas;", "vasList", "Ljava/util/List;", "getVasList", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;ZLjava/util/List;)V", "vas_release"}, k = 1, mv = {1, 4, 2})
public final class VasTab {
    @SerializedName("selected")
    private final boolean selected;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("list")
    @NotNull
    private final List<PerformanceVas> vasList;

    public VasTab(@NotNull String str, boolean z, @NotNull List<PerformanceVas> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "vasList");
        this.title = str;
        this.selected = z;
        this.vasList = list;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final List<PerformanceVas> getVasList() {
        return this.vasList;
    }
}
