package com.avito.android.remote.model;

import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0013\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u001a\u0010\u000bR\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018¨\u0006 "}, d2 = {"Lcom/avito/android/remote/model/TariffInfoResult;", "", "Lcom/avito/android/remote/model/text/AttributedText;", "description", "Lcom/avito/android/remote/model/text/AttributedText;", "getDescription", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "disclaimer", "Ljava/lang/String;", "getDisclaimer", "()Ljava/lang/String;", "title", "getTitle", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "", "Lcom/avito/android/remote/model/InfoListElement;", "infoList", "Ljava/util/List;", "getInfoList", "()Ljava/util/List;", "packagesTitle", "getPackagesTitle", "Lcom/avito/android/remote/model/TariffPackage;", "packagesList", "getPackagesList", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffInfoResult {
    @SerializedName("action")
    @NotNull
    private final Action action;
    @SerializedName("description")
    @Nullable
    private final AttributedText description;
    @SerializedName("disclaimer")
    @NotNull
    private final String disclaimer;
    @SerializedName("infoList")
    @NotNull
    private final List<InfoListElement> infoList;
    @SerializedName("packagesList")
    @NotNull
    private final List<TariffPackage> packagesList;
    @SerializedName("packagesTitle")
    @NotNull
    private final String packagesTitle;
    @SerializedName("title")
    @NotNull
    private final String title;

    public TariffInfoResult(@NotNull String str, @Nullable AttributedText attributedText, @NotNull List<InfoListElement> list, @NotNull String str2, @NotNull List<TariffPackage> list2, @NotNull String str3, @NotNull Action action2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "infoList");
        Intrinsics.checkNotNullParameter(str2, "packagesTitle");
        Intrinsics.checkNotNullParameter(list2, "packagesList");
        Intrinsics.checkNotNullParameter(str3, "disclaimer");
        Intrinsics.checkNotNullParameter(action2, "action");
        this.title = str;
        this.description = attributedText;
        this.infoList = list;
        this.packagesTitle = str2;
        this.packagesList = list2;
        this.disclaimer = str3;
        this.action = action2;
    }

    @NotNull
    public final Action getAction() {
        return this.action;
    }

    @Nullable
    public final AttributedText getDescription() {
        return this.description;
    }

    @NotNull
    public final String getDisclaimer() {
        return this.disclaimer;
    }

    @NotNull
    public final List<InfoListElement> getInfoList() {
        return this.infoList;
    }

    @NotNull
    public final List<TariffPackage> getPackagesList() {
        return this.packagesList;
    }

    @NotNull
    public final String getPackagesTitle() {
        return this.packagesTitle;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
