package com.avito.android.remote.model;

import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/TariffCountResult;", "", "", "sumTitle", "Ljava/lang/String;", "getSumTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/text/AttributedText;", "description", "Lcom/avito/android/remote/model/text/AttributedText;", "getDescription", "()Lcom/avito/android/remote/model/text/AttributedText;", "actionTitle", "getActionTitle", "title", "getTitle", "", "Lcom/avito/android/remote/model/TariffCount;", "list", "Ljava/util/List;", "getList", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffCountResult {
    @SerializedName("actionTitle")
    @NotNull
    private final String actionTitle;
    @SerializedName("description")
    @Nullable
    private final AttributedText description;
    @SerializedName("list")
    @NotNull
    private final List<TariffCount> list;
    @SerializedName("sumTitle")
    @NotNull
    private final String sumTitle;
    @SerializedName("title")
    @NotNull
    private final String title;

    public TariffCountResult(@NotNull String str, @Nullable AttributedText attributedText, @NotNull List<TariffCount> list2, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list2, "list");
        Intrinsics.checkNotNullParameter(str2, "actionTitle");
        Intrinsics.checkNotNullParameter(str3, "sumTitle");
        this.title = str;
        this.description = attributedText;
        this.list = list2;
        this.actionTitle = str2;
        this.sumTitle = str3;
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
    public final List<TariffCount> getList() {
        return this.list;
    }

    @NotNull
    public final String getSumTitle() {
        return this.sumTitle;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
