package com.avito.android.cart.summary.konveyor.product;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.cart.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B+\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0010\u0010\u000e\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000b¢\u0006\u0004\b \u0010!J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR \u0010\u000e\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001f\u001a\u00020\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/cart/summary/konveyor/product/ProductItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/cart/summary/konveyor/product/ProductItemView;", "Lcom/avito/android/cart/summary/konveyor/product/ProductItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/cart/summary/HideSwipeLayoutObservable;", "d", "Lio/reactivex/rxjava3/core/Observable;", "hideSwipeLayoutObservable", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/cart/summary/konveyor/product/ProductItemViewHolder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/util/text/AttributedTextFormatter;", "c", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/cart/summary/konveyor/product/ProductItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/cart/summary/konveyor/product/ProductItemPresenter;", "getPresenter", "()Lcom/avito/android/cart/summary/konveyor/product/ProductItemPresenter;", "presenter", "<init>", "(Lcom/avito/android/cart/summary/konveyor/product/ProductItemPresenter;Lcom/avito/android/util/text/AttributedTextFormatter;Lio/reactivex/rxjava3/core/Observable;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class ProductItemBlueprint implements ItemBlueprint<ProductItemView, ProductItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<ProductItemViewHolder> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.cart_product_swipeable_item, new a(this));
    @NotNull
    public final ProductItemPresenter b;
    public final AttributedTextFormatter c;
    public final Observable<Integer> d;

    public static final class a extends Lambda implements Function2<ViewGroup, View, ProductItemViewHolder> {
        public final /* synthetic */ ProductItemBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ProductItemBlueprint productItemBlueprint) {
            super(2);
            this.a = productItemBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public ProductItemViewHolder invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new ProductItemViewHolder(view2, this.a.c, this.a.d);
        }
    }

    @Inject
    public ProductItemBlueprint(@NotNull ProductItemPresenter productItemPresenter, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull Observable<Integer> observable) {
        Intrinsics.checkNotNullParameter(productItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(observable, "hideSwipeLayoutObservable");
        this.b = productItemPresenter;
        this.c = attributedTextFormatter;
        this.d = observable;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<ProductItemViewHolder> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof ProductItem;
    }

    /* Return type fixed from 'com.avito.android.cart.summary.konveyor.product.ProductItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<ProductItemView, ProductItem> getPresenter() {
        return this.b;
    }
}
