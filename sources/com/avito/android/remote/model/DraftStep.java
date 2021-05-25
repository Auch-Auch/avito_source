package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\n\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0018\u0010\u0007R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/DraftStep;", "", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Navigation;", "component2", "()Lcom/avito/android/remote/model/Navigation;", "component3", "id", "navigation", "wizardPreFinalNavigation", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/Navigation;)Lcom/avito/android/remote/model/DraftStep;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/Navigation;", "getNavigation", "getWizardPreFinalNavigation", "Ljava/lang/String;", "getId", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/Navigation;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class DraftStep {
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("navigation")
    @NotNull
    private final Navigation navigation;
    @SerializedName("finalNavigation")
    @Nullable
    private final Navigation wizardPreFinalNavigation;

    public DraftStep(@NotNull String str, @NotNull Navigation navigation2, @Nullable Navigation navigation3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(navigation2, "navigation");
        this.id = str;
        this.navigation = navigation2;
        this.wizardPreFinalNavigation = navigation3;
    }

    public static /* synthetic */ DraftStep copy$default(DraftStep draftStep, String str, Navigation navigation2, Navigation navigation3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = draftStep.id;
        }
        if ((i & 2) != 0) {
            navigation2 = draftStep.navigation;
        }
        if ((i & 4) != 0) {
            navigation3 = draftStep.wizardPreFinalNavigation;
        }
        return draftStep.copy(str, navigation2, navigation3);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final Navigation component2() {
        return this.navigation;
    }

    @Nullable
    public final Navigation component3() {
        return this.wizardPreFinalNavigation;
    }

    @NotNull
    public final DraftStep copy(@NotNull String str, @NotNull Navigation navigation2, @Nullable Navigation navigation3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(navigation2, "navigation");
        return new DraftStep(str, navigation2, navigation3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DraftStep)) {
            return false;
        }
        DraftStep draftStep = (DraftStep) obj;
        return Intrinsics.areEqual(this.id, draftStep.id) && Intrinsics.areEqual(this.navigation, draftStep.navigation) && Intrinsics.areEqual(this.wizardPreFinalNavigation, draftStep.wizardPreFinalNavigation);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final Navigation getNavigation() {
        return this.navigation;
    }

    @Nullable
    public final Navigation getWizardPreFinalNavigation() {
        return this.wizardPreFinalNavigation;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Navigation navigation2 = this.navigation;
        int hashCode2 = (hashCode + (navigation2 != null ? navigation2.hashCode() : 0)) * 31;
        Navigation navigation3 = this.wizardPreFinalNavigation;
        if (navigation3 != null) {
            i = navigation3.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("DraftStep(id=");
        L.append(this.id);
        L.append(", navigation=");
        L.append(this.navigation);
        L.append(", wizardPreFinalNavigation=");
        L.append(this.wizardPreFinalNavigation);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DraftStep(String str, Navigation navigation2, Navigation navigation3, int i, j jVar) {
        this(str, navigation2, (i & 4) != 0 ? null : navigation3);
    }
}
