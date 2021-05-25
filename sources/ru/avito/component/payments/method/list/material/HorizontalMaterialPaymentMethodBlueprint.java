package ru.avito.component.payments.method.list.material;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.payments.method.list.MaterialPaymentMethodItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lru/avito/component/payments/method/list/material/HorizontalMaterialPaymentMethodBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lru/avito/component/payments/method/list/material/MaterialPaymentMethodViewHolder;", "Lru/avito/component/payments/method/list/MaterialPaymentMethodItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lru/avito/component/payments/method/list/material/PaymentMethodWidthProvider;", "c", "Lru/avito/component/payments/method/list/material/PaymentMethodWidthProvider;", "paymentMethodWidthProvider", "Lru/avito/component/payments/method/list/material/MaterialPaymentMethodItemPresenter;", AuthSource.BOOKING_ORDER, "Lru/avito/component/payments/method/list/material/MaterialPaymentMethodItemPresenter;", "getPresenter", "()Lru/avito/component/payments/method/list/material/MaterialPaymentMethodItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lru/avito/component/payments/method/list/material/HorizontalMaterialPaymentMethodViewHolderImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "<init>", "(Lru/avito/component/payments/method/list/material/MaterialPaymentMethodItemPresenter;Lru/avito/component/payments/method/list/material/PaymentMethodWidthProvider;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class HorizontalMaterialPaymentMethodBlueprint implements ItemBlueprint<MaterialPaymentMethodViewHolder, MaterialPaymentMethodItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<HorizontalMaterialPaymentMethodViewHolderImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.payment_method_list_card_material_horizontal, new a(this));
    @NotNull
    public final MaterialPaymentMethodItemPresenter b;
    public final PaymentMethodWidthProvider c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, HorizontalMaterialPaymentMethodViewHolderImpl> {
        public final /* synthetic */ HorizontalMaterialPaymentMethodBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(HorizontalMaterialPaymentMethodBlueprint horizontalMaterialPaymentMethodBlueprint) {
            super(2);
            this.a = horizontalMaterialPaymentMethodBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public HorizontalMaterialPaymentMethodViewHolderImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.width = this.a.c.provideMethodWidth();
            view2.setLayoutParams(layoutParams);
            return new HorizontalMaterialPaymentMethodViewHolderImpl(view2);
        }
    }

    public HorizontalMaterialPaymentMethodBlueprint(@NotNull MaterialPaymentMethodItemPresenter materialPaymentMethodItemPresenter, @NotNull PaymentMethodWidthProvider paymentMethodWidthProvider) {
        Intrinsics.checkNotNullParameter(materialPaymentMethodItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(paymentMethodWidthProvider, "paymentMethodWidthProvider");
        this.b = materialPaymentMethodItemPresenter;
        this.c = paymentMethodWidthProvider;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<HorizontalMaterialPaymentMethodViewHolderImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof MaterialPaymentMethodItem;
    }

    /* Return type fixed from 'ru.avito.component.payments.method.list.material.MaterialPaymentMethodItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<MaterialPaymentMethodViewHolder, MaterialPaymentMethodItem> getPresenter() {
        return this.b;
    }
}
