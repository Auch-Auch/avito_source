package com.avito.android.bundles.vas_union.viewmodel;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.VasUnionResult;
import com.avito.android.util.LoadingState;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B)\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ2\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005R!\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\t¨\u0006 "}, d2 = {"Lcom/avito/android/bundles/vas_union/viewmodel/VasUnionViewState;", "", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/VasUnionResult;", "component1", "()Lcom/avito/android/util/LoadingState;", "", "Lcom/avito/conveyor_item/Item;", "component2", "()Ljava/util/List;", "loadingState", "items", "copy", "(Lcom/avito/android/util/LoadingState;Ljava/util/List;)Lcom/avito/android/bundles/vas_union/viewmodel/VasUnionViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/LoadingState;", "getLoadingState", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getItems", "<init>", "(Lcom/avito/android/util/LoadingState;Ljava/util/List;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class VasUnionViewState {
    @NotNull
    public final LoadingState<VasUnionResult> a;
    @Nullable
    public final List<Item> b;

    public VasUnionViewState() {
        this(null, null, 3, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.android.util.LoadingState<? super com.avito.android.remote.model.VasUnionResult> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.conveyor_item.Item> */
    /* JADX WARN: Multi-variable type inference failed */
    public VasUnionViewState(@NotNull LoadingState<? super VasUnionResult> loadingState, @Nullable List<? extends Item> list) {
        Intrinsics.checkNotNullParameter(loadingState, "loadingState");
        this.a = loadingState;
        this.b = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.bundles.vas_union.viewmodel.VasUnionViewState */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VasUnionViewState copy$default(VasUnionViewState vasUnionViewState, LoadingState loadingState, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            loadingState = vasUnionViewState.a;
        }
        if ((i & 2) != 0) {
            list = vasUnionViewState.b;
        }
        return vasUnionViewState.copy(loadingState, list);
    }

    @NotNull
    public final LoadingState<VasUnionResult> component1() {
        return this.a;
    }

    @Nullable
    public final List<Item> component2() {
        return this.b;
    }

    @NotNull
    public final VasUnionViewState copy(@NotNull LoadingState<? super VasUnionResult> loadingState, @Nullable List<? extends Item> list) {
        Intrinsics.checkNotNullParameter(loadingState, "loadingState");
        return new VasUnionViewState(loadingState, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VasUnionViewState)) {
            return false;
        }
        VasUnionViewState vasUnionViewState = (VasUnionViewState) obj;
        return Intrinsics.areEqual(this.a, vasUnionViewState.a) && Intrinsics.areEqual(this.b, vasUnionViewState.b);
    }

    @Nullable
    public final List<Item> getItems() {
        return this.b;
    }

    @NotNull
    public final LoadingState<VasUnionResult> getLoadingState() {
        return this.a;
    }

    public int hashCode() {
        LoadingState<VasUnionResult> loadingState = this.a;
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
        StringBuilder L = a.L("VasUnionViewState(loadingState=");
        L.append(this.a);
        L.append(", items=");
        return a.w(L, this.b, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VasUnionViewState(LoadingState loadingState, List list, int i, j jVar) {
        this((i & 1) != 0 ? LoadingState.Loading.INSTANCE : loadingState, (i & 2) != 0 ? null : list);
    }
}
