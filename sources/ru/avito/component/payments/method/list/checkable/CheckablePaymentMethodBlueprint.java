package ru.avito.component.payments.method.list.checkable;

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
import ru.avito.component.payments.method.list.CheckablePaymentMethodItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lru/avito/component/payments/method/list/checkable/CheckablePaymentMethodBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lru/avito/component/payments/method/list/checkable/CheckablePaymentMethodViewHolder;", "Lru/avito/component/payments/method/list/CheckablePaymentMethodItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lru/avito/component/payments/method/list/checkable/CheckablePaymentMethodViewHolderImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lru/avito/component/payments/method/list/checkable/CheckablePaymentMethodItemPresenter;", AuthSource.BOOKING_ORDER, "Lru/avito/component/payments/method/list/checkable/CheckablePaymentMethodItemPresenter;", "getPresenter", "()Lru/avito/component/payments/method/list/checkable/CheckablePaymentMethodItemPresenter;", "presenter", "<init>", "(Lru/avito/component/payments/method/list/checkable/CheckablePaymentMethodItemPresenter;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class CheckablePaymentMethodBlueprint implements ItemBlueprint<CheckablePaymentMethodViewHolder, CheckablePaymentMethodItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<CheckablePaymentMethodViewHolderImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.payment_method_list_card_checkable, a.a);
    @NotNull
    public final CheckablePaymentMethodItemPresenter b;

    public static final class a extends Lambda implements Function2<ViewGroup, View, CheckablePaymentMethodViewHolderImpl> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public CheckablePaymentMethodViewHolderImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new CheckablePaymentMethodViewHolderImpl(view2);
        }
    }

    public CheckablePaymentMethodBlueprint(@NotNull CheckablePaymentMethodItemPresenter checkablePaymentMethodItemPresenter) {
        Intrinsics.checkNotNullParameter(checkablePaymentMethodItemPresenter, "presenter");
        this.b = checkablePaymentMethodItemPresenter;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<CheckablePaymentMethodViewHolderImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof CheckablePaymentMethodItem;
    }

    /* Return type fixed from 'ru.avito.component.payments.method.list.checkable.CheckablePaymentMethodItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<CheckablePaymentMethodViewHolder, CheckablePaymentMethodItem> getPresenter() {
        return this.b;
    }
}
