package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012JX\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001d\u0010\nJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u001c\u0010\u0015\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b#\u0010\nR\u001c\u0010\u0016\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b%\u0010\u0004R\u001c\u0010\u0017\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b'\u0010\u000eR\u001c\u0010\u0014\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010\u0007R\u001c\u0010\u0013\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b*\u0010\u0004R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b,\u0010\u0012R\u001c\u0010\u0018\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b-\u0010\u000e¨\u00060"}, d2 = {"Lcom/avito/android/remote/model/Draft;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "", "component3", "()I", "component4", "Lcom/avito/android/remote/model/Navigation;", "component5", "()Lcom/avito/android/remote/model/Navigation;", "component6", "Lcom/avito/android/remote/model/DraftState;", "component7", "()Lcom/avito/android/remote/model/DraftState;", "draftId", "daysLeft", "version", "publishSessionId", "navigation", "rootNavigation", "state", "copy", "(Ljava/lang/String;JILjava/lang/String;Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/DraftState;)Lcom/avito/android/remote/model/Draft;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getVersion", "Ljava/lang/String;", "getPublishSessionId", "Lcom/avito/android/remote/model/Navigation;", "getNavigation", "J", "getDaysLeft", "getDraftId", "Lcom/avito/android/remote/model/DraftState;", "getState", "getRootNavigation", "<init>", "(Ljava/lang/String;JILjava/lang/String;Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/DraftState;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class Draft {
    @SerializedName("daysLeft")
    private final long daysLeft;
    @SerializedName("id")
    @NotNull
    private final String draftId;
    @SerializedName("navigation")
    @NotNull
    private final Navigation navigation;
    @SerializedName("publishSessionId")
    @NotNull
    private final String publishSessionId;
    @SerializedName("rootNavigation")
    @NotNull
    private final Navigation rootNavigation;
    @SerializedName("state")
    @Nullable
    private final DraftState state;
    @SerializedName("version")
    private final int version;

    public Draft(@NotNull String str, long j, int i, @NotNull String str2, @NotNull Navigation navigation2, @NotNull Navigation navigation3, @Nullable DraftState draftState) {
        Intrinsics.checkNotNullParameter(str, "draftId");
        Intrinsics.checkNotNullParameter(str2, "publishSessionId");
        Intrinsics.checkNotNullParameter(navigation2, "navigation");
        Intrinsics.checkNotNullParameter(navigation3, "rootNavigation");
        this.draftId = str;
        this.daysLeft = j;
        this.version = i;
        this.publishSessionId = str2;
        this.navigation = navigation2;
        this.rootNavigation = navigation3;
        this.state = draftState;
    }

    public static /* synthetic */ Draft copy$default(Draft draft, String str, long j, int i, String str2, Navigation navigation2, Navigation navigation3, DraftState draftState, int i2, Object obj) {
        return draft.copy((i2 & 1) != 0 ? draft.draftId : str, (i2 & 2) != 0 ? draft.daysLeft : j, (i2 & 4) != 0 ? draft.version : i, (i2 & 8) != 0 ? draft.publishSessionId : str2, (i2 & 16) != 0 ? draft.navigation : navigation2, (i2 & 32) != 0 ? draft.rootNavigation : navigation3, (i2 & 64) != 0 ? draft.state : draftState);
    }

    @NotNull
    public final String component1() {
        return this.draftId;
    }

    public final long component2() {
        return this.daysLeft;
    }

    public final int component3() {
        return this.version;
    }

    @NotNull
    public final String component4() {
        return this.publishSessionId;
    }

    @NotNull
    public final Navigation component5() {
        return this.navigation;
    }

    @NotNull
    public final Navigation component6() {
        return this.rootNavigation;
    }

    @Nullable
    public final DraftState component7() {
        return this.state;
    }

    @NotNull
    public final Draft copy(@NotNull String str, long j, int i, @NotNull String str2, @NotNull Navigation navigation2, @NotNull Navigation navigation3, @Nullable DraftState draftState) {
        Intrinsics.checkNotNullParameter(str, "draftId");
        Intrinsics.checkNotNullParameter(str2, "publishSessionId");
        Intrinsics.checkNotNullParameter(navigation2, "navigation");
        Intrinsics.checkNotNullParameter(navigation3, "rootNavigation");
        return new Draft(str, j, i, str2, navigation2, navigation3, draftState);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Draft)) {
            return false;
        }
        Draft draft = (Draft) obj;
        return Intrinsics.areEqual(this.draftId, draft.draftId) && this.daysLeft == draft.daysLeft && this.version == draft.version && Intrinsics.areEqual(this.publishSessionId, draft.publishSessionId) && Intrinsics.areEqual(this.navigation, draft.navigation) && Intrinsics.areEqual(this.rootNavigation, draft.rootNavigation) && Intrinsics.areEqual(this.state, draft.state);
    }

    public final long getDaysLeft() {
        return this.daysLeft;
    }

    @NotNull
    public final String getDraftId() {
        return this.draftId;
    }

    @NotNull
    public final Navigation getNavigation() {
        return this.navigation;
    }

    @NotNull
    public final String getPublishSessionId() {
        return this.publishSessionId;
    }

    @NotNull
    public final Navigation getRootNavigation() {
        return this.rootNavigation;
    }

    @Nullable
    public final DraftState getState() {
        return this.state;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.draftId;
        int i = 0;
        int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + c.a(this.daysLeft)) * 31) + this.version) * 31;
        String str2 = this.publishSessionId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Navigation navigation2 = this.navigation;
        int hashCode3 = (hashCode2 + (navigation2 != null ? navigation2.hashCode() : 0)) * 31;
        Navigation navigation3 = this.rootNavigation;
        int hashCode4 = (hashCode3 + (navigation3 != null ? navigation3.hashCode() : 0)) * 31;
        DraftState draftState = this.state;
        if (draftState != null) {
            i = draftState.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Draft(draftId=");
        L.append(this.draftId);
        L.append(", daysLeft=");
        L.append(this.daysLeft);
        L.append(", version=");
        L.append(this.version);
        L.append(", publishSessionId=");
        L.append(this.publishSessionId);
        L.append(", navigation=");
        L.append(this.navigation);
        L.append(", rootNavigation=");
        L.append(this.rootNavigation);
        L.append(", state=");
        L.append(this.state);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Draft(String str, long j, int i, String str2, Navigation navigation2, Navigation navigation3, DraftState draftState, int i2, j jVar) {
        this(str, (i2 & 2) != 0 ? 0 : j, i, str2, navigation2, navigation3, (i2 & 64) != 0 ? null : draftState);
    }
}
