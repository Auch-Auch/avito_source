package com.avito.android.payment;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/avito/android/payment/DecoratedItems;", "", "", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getDecorations", "()Ljava/util/List;", "decorations", "Lcom/avito/konveyor/blueprint/Item;", AuthSource.SEND_ABUSE, "getItems", "items", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
public final class DecoratedItems {
    @NotNull
    public final List<Item> a;
    @NotNull
    public final List<RecyclerView.ItemDecoration> b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.konveyor.blueprint.Item> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends androidx.recyclerview.widget.RecyclerView$ItemDecoration> */
    /* JADX WARN: Multi-variable type inference failed */
    public DecoratedItems(@NotNull List<? extends Item> list, @NotNull List<? extends RecyclerView.ItemDecoration> list2) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(list2, "decorations");
        this.a = list;
        this.b = list2;
    }

    @NotNull
    public final List<RecyclerView.ItemDecoration> getDecorations() {
        return this.b;
    }

    @NotNull
    public final List<Item> getItems() {
        return this.a;
    }
}
