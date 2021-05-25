package com.avito.android.bundles.viewmodel;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.VasBundlesResult;
import com.avito.android.util.LoadingState;
import com.avito.konveyor.blueprint.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B)\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ2\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005R!\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\t¨\u0006 "}, d2 = {"Lcom/avito/android/bundles/viewmodel/VasBundlesViewState;", "", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/VasBundlesResult;", "component1", "()Lcom/avito/android/util/LoadingState;", "", "Lcom/avito/konveyor/blueprint/Item;", "component2", "()Ljava/util/List;", "loadingState", "bundles", "copy", "(Lcom/avito/android/util/LoadingState;Ljava/util/List;)Lcom/avito/android/bundles/viewmodel/VasBundlesViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/LoadingState;", "getLoadingState", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getBundles", "<init>", "(Lcom/avito/android/util/LoadingState;Ljava/util/List;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class VasBundlesViewState {
    @NotNull
    public final LoadingState<VasBundlesResult> a;
    @Nullable
    public final List<Item> b;

    public VasBundlesViewState() {
        this(null, null, 3, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.android.util.LoadingState<? super com.avito.android.remote.model.VasBundlesResult> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.konveyor.blueprint.Item> */
    /* JADX WARN: Multi-variable type inference failed */
    public VasBundlesViewState(@NotNull LoadingState<? super VasBundlesResult> loadingState, @Nullable List<? extends Item> list) {
        Intrinsics.checkNotNullParameter(loadingState, "loadingState");
        this.a = loadingState;
        this.b = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.bundles.viewmodel.VasBundlesViewState */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VasBundlesViewState copy$default(VasBundlesViewState vasBundlesViewState, LoadingState loadingState, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            loadingState = vasBundlesViewState.a;
        }
        if ((i & 2) != 0) {
            list = vasBundlesViewState.b;
        }
        return vasBundlesViewState.copy(loadingState, list);
    }

    @NotNull
    public final LoadingState<VasBundlesResult> component1() {
        return this.a;
    }

    @Nullable
    public final List<Item> component2() {
        return this.b;
    }

    @NotNull
    public final VasBundlesViewState copy(@NotNull LoadingState<? super VasBundlesResult> loadingState, @Nullable List<? extends Item> list) {
        Intrinsics.checkNotNullParameter(loadingState, "loadingState");
        return new VasBundlesViewState(loadingState, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VasBundlesViewState)) {
            return false;
        }
        VasBundlesViewState vasBundlesViewState = (VasBundlesViewState) obj;
        return Intrinsics.areEqual(this.a, vasBundlesViewState.a) && Intrinsics.areEqual(this.b, vasBundlesViewState.b);
    }

    @Nullable
    public final List<Item> getBundles() {
        return this.b;
    }

    @NotNull
    public final LoadingState<VasBundlesResult> getLoadingState() {
        return this.a;
    }

    public int hashCode() {
        LoadingState<VasBundlesResult> loadingState = this.a;
        int i = 0;
        int hashCode = (loadingState != null ? loadingState.hashCode() : 0) * 31;
        List<Item> list = this.b;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("VasBundlesViewState(loadingState=");
        L.append(this.a);
        L.append(", bundles=");
        return a.w(L, this.b, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VasBundlesViewState(LoadingState loadingState, List list, int i, j jVar) {
        this((i & 1) != 0 ? LoadingState.Loading.INSTANCE : loadingState, (i & 2) != 0 ? null : list);
    }
}
