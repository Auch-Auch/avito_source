package com.avito.android.remote.model.vas.performance;

import a2.b.a.a.a;
import com.avito.android.remote.model.Action;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0014\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/avito/android/remote/model/vas/performance/VasPerformanceResult;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/vas/performance/VasTab;", "tabs", "Ljava/util/List;", "getTabs", "()Ljava/util/List;", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "infoAction", "getInfoAction", "description", "getDescription", "actionTitle", "getActionTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/Action;Lcom/avito/android/remote/model/Action;)V", "vas_release"}, k = 1, mv = {1, 4, 2})
public final class VasPerformanceResult {
    @SerializedName("action")
    @Nullable
    private final Action action;
    @SerializedName("actionTitle")
    @Nullable
    private final String actionTitle;
    @SerializedName("description")
    @NotNull
    private final String description;
    @SerializedName("infoAction")
    @Nullable
    private final Action infoAction;
    @SerializedName("tabs")
    @NotNull
    private final List<VasTab> tabs;
    @SerializedName("title")
    @NotNull
    private final String title;

    public VasPerformanceResult(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull List<VasTab> list, @Nullable Action action2, @Nullable Action action3) {
        a.c1(str, "title", str2, "description", list, "tabs");
        this.title = str;
        this.description = str2;
        this.actionTitle = str3;
        this.tabs = list;
        this.infoAction = action2;
        this.action = action3;
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @Nullable
    public final String getActionTitle() {
        return this.actionTitle;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Action getInfoAction() {
        return this.infoAction;
    }

    @NotNull
    public final List<VasTab> getTabs() {
        return this.tabs;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
