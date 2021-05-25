package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/avito/android/remote/model/TariffRegionResult;", "", "Lcom/avito/android/remote/model/text/AttributedText;", "description", "Lcom/avito/android/remote/model/text/AttributedText;", "getDescription", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "actionTitle", "getActionTitle", "", "Lcom/avito/android/remote/model/TariffRegion;", "list", "Ljava/util/List;", "getList", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/util/List;Ljava/lang/String;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffRegionResult {
    @SerializedName("actionTitle")
    @NotNull
    private final String actionTitle;
    @SerializedName("description")
    @Nullable
    private final AttributedText description;
    @SerializedName("list")
    @NotNull
    private final List<TariffRegion> list;
    @SerializedName("title")
    @NotNull
    private final String title;

    public TariffRegionResult(@NotNull String str, @Nullable AttributedText attributedText, @NotNull List<TariffRegion> list2, @NotNull String str2) {
        a.d1(str, "title", list2, "list", str2, "actionTitle");
        this.title = str;
        this.description = attributedText;
        this.list = list2;
        this.actionTitle = str2;
    }

    @NotNull
    public final String getActionTitle() {
        return this.actionTitle;
    }

    @Nullable
    public final AttributedText getDescription() {
        return this.description;
    }

    @NotNull
    public final List<TariffRegion> getList() {
        return this.list;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
