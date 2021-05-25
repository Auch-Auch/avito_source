package com.avito.android.cart.summary.konveyor.header.store;

import android.view.View;
import android.widget.TextView;
import com.avito.android.cart.R;
import com.avito.android.cart.summary.konveyor.header.store.StoreHeaderItemView;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/cart/summary/konveyor/header/store/StoreHeaderItemViewHolder;", "Lcom/avito/android/cart/summary/konveyor/header/store/StoreHeaderItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "bindTitle", "(Ljava/lang/String;)V", "message", "bindMessage", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "messageView", "s", "titleView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class StoreHeaderItemViewHolder extends BaseViewHolder implements StoreHeaderItemView {
    public final TextView s;
    public final TextView t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoreHeaderItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.header);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.message);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
    }

    @Override // com.avito.android.cart.summary.konveyor.header.store.StoreHeaderItemView
    public void bindMessage(@Nullable String str) {
        TextViews.bindText$default(this.t, str, false, 2, null);
    }

    @Override // com.avito.android.cart.summary.konveyor.header.store.StoreHeaderItemView
    public void bindTitle(@Nullable String str) {
        TextViews.bindText$default(this.s, str, false, 2, null);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        StoreHeaderItemView.DefaultImpls.onUnbind(this);
    }
}
