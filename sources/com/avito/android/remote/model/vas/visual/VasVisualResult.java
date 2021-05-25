package com.avito.android.remote.model.vas.visual;

import com.avito.android.remote.model.Action;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/vas/visual/VasVisualResult;", "", "", "selectedActionTitle", "Ljava/lang/String;", "getSelectedActionTitle", "()Ljava/lang/String;", "description", "getDescription", "", "Lcom/avito/android/remote/model/vas/visual/VisualVas;", "vasList", "Ljava/util/List;", "getVasList", "()Ljava/util/List;", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "actionTitle", "getActionTitle", "title", "getTitle", "emptyActionTitle", "getEmptyActionTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/Action;Ljava/lang/String;)V", "vas_release"}, k = 1, mv = {1, 4, 2})
public final class VasVisualResult {
    @SerializedName("action")
    @Nullable
    private final Action action;
    @SerializedName("actionTitle")
    @Nullable
    private final String actionTitle;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("emptyActionTitle")
    @Nullable
    private final String emptyActionTitle;
    @SerializedName("selectedActionTitle")
    @Nullable
    private final String selectedActionTitle;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("list")
    @NotNull
    private final List<VisualVas> vasList;

    public VasVisualResult(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull List<VisualVas> list, @Nullable Action action2, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "vasList");
        this.title = str;
        this.description = str2;
        this.actionTitle = str3;
        this.selectedActionTitle = str4;
        this.vasList = list;
        this.action = action2;
        this.emptyActionTitle = str5;
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @Nullable
    public final String getActionTitle() {
        return this.actionTitle;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getEmptyActionTitle() {
        return this.emptyActionTitle;
    }

    @Nullable
    public final String getSelectedActionTitle() {
        return this.selectedActionTitle;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final List<VisualVas> getVasList() {
        return this.vasList;
    }
}
