package com.avito.android.remote.model.edit;

import com.avito.android.remote.model.InfoListElement;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010+\u001a\u00020&\u0012\u0006\u0010'\u001a\u00020&\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u0007\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010$\u001a\u00020\u001c\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b,\u0010-R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u00020\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b#\u0010\fR\u001c\u0010$\u001a\u00020\u001c8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 R\u001c\u0010'\u001a\u00020&8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010+\u001a\u00020&8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b+\u0010(\u001a\u0004\b+\u0010*¨\u0006."}, d2 = {"Lcom/avito/android/remote/model/edit/Period;", "", "Lcom/avito/android/remote/model/edit/TariffProlongation;", AnalyticFieldsName.prolongation, "Lcom/avito/android/remote/model/edit/TariffProlongation;", "getProlongation", "()Lcom/avito/android/remote/model/edit/TariffProlongation;", "", "Lcom/avito/android/remote/model/edit/PackageElement;", "packagesList", "Ljava/util/List;", "getPackagesList", "()Ljava/util/List;", "Lcom/avito/android/remote/model/text/AttributedText;", "periodTitle", "Lcom/avito/android/remote/model/text/AttributedText;", "getPeriodTitle", "()Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/avito/android/remote/model/edit/TariffDescription;", "description", "Lcom/avito/android/remote/model/edit/TariffDescription;", "getDescription", "()Lcom/avito/android/remote/model/edit/TariffDescription;", "Lcom/avito/android/remote/model/edit/ManagerCallInfo;", "managerCallInfo", "Lcom/avito/android/remote/model/edit/ManagerCallInfo;", "getManagerCallInfo", "()Lcom/avito/android/remote/model/edit/ManagerCallInfo;", "", "tariffTitle", "Ljava/lang/String;", "getTariffTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/InfoListElement;", "infoList", "getInfoList", "packagesTitle", "getPackagesTitle", "", "hasRedBadge", "Z", "getHasRedBadge", "()Z", "isSelected", "<init>", "(Lcom/avito/android/remote/model/text/AttributedText;ZZLjava/util/List;Ljava/lang/String;Lcom/avito/android/remote/model/edit/TariffDescription;Lcom/avito/android/remote/model/edit/TariffProlongation;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/edit/ManagerCallInfo;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class Period {
    @SerializedName("description")
    @Nullable
    private final TariffDescription description;
    @SerializedName("hasRedBadge")
    private final boolean hasRedBadge;
    @SerializedName("infoList")
    @NotNull
    private final List<InfoListElement> infoList;
    @SerializedName("isSelected")
    private final boolean isSelected;
    @SerializedName("managerCallInfo")
    @Nullable
    private final ManagerCallInfo managerCallInfo;
    @SerializedName("packages")
    @NotNull
    private final List<PackageElement> packagesList;
    @SerializedName("packagesTitle")
    @NotNull
    private final String packagesTitle;
    @SerializedName("periodTitle")
    @NotNull
    private final AttributedText periodTitle;
    @SerializedName(AnalyticFieldsName.prolongation)
    @Nullable
    private final TariffProlongation prolongation;
    @SerializedName("tariffTitle")
    @Nullable
    private final String tariffTitle;

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.util.List<? extends com.avito.android.remote.model.edit.PackageElement> */
    /* JADX WARN: Multi-variable type inference failed */
    public Period(@NotNull AttributedText attributedText, boolean z, boolean z2, @NotNull List<InfoListElement> list, @Nullable String str, @Nullable TariffDescription tariffDescription, @Nullable TariffProlongation tariffProlongation, @NotNull String str2, @NotNull List<? extends PackageElement> list2, @Nullable ManagerCallInfo managerCallInfo2) {
        Intrinsics.checkNotNullParameter(attributedText, "periodTitle");
        Intrinsics.checkNotNullParameter(list, "infoList");
        Intrinsics.checkNotNullParameter(str2, "packagesTitle");
        Intrinsics.checkNotNullParameter(list2, "packagesList");
        this.periodTitle = attributedText;
        this.isSelected = z;
        this.hasRedBadge = z2;
        this.infoList = list;
        this.tariffTitle = str;
        this.description = tariffDescription;
        this.prolongation = tariffProlongation;
        this.packagesTitle = str2;
        this.packagesList = list2;
        this.managerCallInfo = managerCallInfo2;
    }

    @Nullable
    public final TariffDescription getDescription() {
        return this.description;
    }

    public final boolean getHasRedBadge() {
        return this.hasRedBadge;
    }

    @NotNull
    public final List<InfoListElement> getInfoList() {
        return this.infoList;
    }

    @Nullable
    public final ManagerCallInfo getManagerCallInfo() {
        return this.managerCallInfo;
    }

    @NotNull
    public final List<PackageElement> getPackagesList() {
        return this.packagesList;
    }

    @NotNull
    public final String getPackagesTitle() {
        return this.packagesTitle;
    }

    @NotNull
    public final AttributedText getPeriodTitle() {
        return this.periodTitle;
    }

    @Nullable
    public final TariffProlongation getProlongation() {
        return this.prolongation;
    }

    @Nullable
    public final String getTariffTitle() {
        return this.tariffTitle;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }
}
