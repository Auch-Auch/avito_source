package com.avito.android.basket.checkout.item.prolongation;

import android.view.View;
import com.avito.android.basket.R;
import com.avito.android.basket.checkout.item.prolongation.ProlongationItemView;
import com.avito.android.lib.design.list_item.SwitcherListItem;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/avito/android/basket/checkout/item/prolongation/ProlongationItemViewImpl;", "Lcom/avito/android/basket/checkout/item/prolongation/ProlongationItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "description", "setDescription", "", "isSwitchOn", "setSwitcherOn", "(Z)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "padding", "setStartPadding", "(I)V", "s", "Lkotlin/jvm/functions/Function0;", "Lcom/avito/android/lib/design/list_item/SwitcherListItem;", "t", "Lcom/avito/android/lib/design/list_item/SwitcherListItem;", "switcher", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class ProlongationItemViewImpl extends BaseViewHolder implements ProlongationItemView {
    public Function0<Unit> s;
    public final SwitcherListItem t;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ProlongationItemViewImpl a;

        public a(ProlongationItemViewImpl prolongationItemViewImpl) {
            this.a = prolongationItemViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0 = this.a.s;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProlongationItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.prolongation_switcher);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.list_item.SwitcherListItem");
        SwitcherListItem switcherListItem = (SwitcherListItem) findViewById;
        this.t = switcherListItem;
        switcherListItem.setOnClickListener(new a(this));
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ProlongationItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.basket.checkout.item.prolongation.ProlongationItemView
    public void setDescription(@Nullable String str) {
        this.t.setMessage(str);
    }

    @Override // com.avito.android.basket.checkout.item.prolongation.ProlongationItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s = function0;
    }

    @Override // com.avito.android.basket.checkout.item.prolongation.ProlongationItemView
    public void setStartPadding(int i) {
        Views.changePadding$default(this.t, i, 0, 0, 0, 14, null);
    }

    @Override // com.avito.android.basket.checkout.item.prolongation.ProlongationItemView
    public void setSwitcherOn(boolean z) {
        this.t.setChecked(z);
    }

    @Override // com.avito.android.basket.checkout.item.prolongation.ProlongationItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.t.setTitle(str);
    }
}
