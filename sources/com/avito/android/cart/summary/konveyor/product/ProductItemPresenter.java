package com.avito.android.cart.summary.konveyor.product;

import com.avito.android.cart.analytics.summary.StepperUsageType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.rambler.libs.swipe_layout.SwipeLayout;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B{\b\u0007\u0012\u001c\u0010\u0010\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\f0\u000bj\u0002`\r\u0012\u0010\u0010\u0016\u001a\f\u0012\u0004\u0012\u00020\u00030\u000bj\u0002`\u0014\u0012\u0010\u0010\u001a\u001a\f\u0012\u0004\u0012\u00020\u00170\u000bj\u0002`\u0018\u0012\u0010\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\u00060\u000bj\u0002`\u0011\u0012\u001c\u0010\u001e\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\f0\u000bj\u0002`\u001c¢\u0006\u0004\b\u001f\u0010 J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR,\u0010\u0010\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\f0\u000bj\u0002`\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR \u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\u00060\u000bj\u0002`\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR \u0010\u0016\u001a\f\u0012\u0004\u0012\u00020\u00030\u000bj\u0002`\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR \u0010\u001a\u001a\f\u0012\u0004\u0012\u00020\u00170\u000bj\u0002`\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u000fR,\u0010\u001e\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\f0\u000bj\u0002`\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u000f¨\u0006!"}, d2 = {"Lcom/avito/android/cart/summary/konveyor/product/ProductItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/cart/summary/konveyor/product/ProductItemView;", "Lcom/avito/android/cart/summary/konveyor/product/ProductItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/cart/summary/konveyor/product/ProductItemView;Lcom/avito/android/cart/summary/konveyor/product/ProductItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lkotlin/Pair;", "Lcom/avito/android/cart/summary/QuantityChangesConsumer;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "quantityChangesConsumer", "Lcom/avito/android/cart/summary/HideSwipeLayoutConsumer;", "d", "hideSwipeLayoutsConsumer", "Lcom/avito/android/cart/summary/DeleteItemConsumer;", AuthSource.BOOKING_ORDER, "deleteItemConsumer", "", "Lcom/avito/android/cart/summary/OpenAdvertDetailsConsumer;", "c", "openAdvertDetailsConsumer", "Lcom/avito/android/cart/analytics/summary/StepperUsageType;", "Lcom/avito/android/cart/summary/StepperUsageConsumer;", "e", "stepperUsageConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;Lio/reactivex/rxjava3/functions/Consumer;Lio/reactivex/rxjava3/functions/Consumer;Lio/reactivex/rxjava3/functions/Consumer;Lio/reactivex/rxjava3/functions/Consumer;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class ProductItemPresenter implements ItemPresenter<ProductItemView, ProductItem> {
    public final Consumer<Pair<ProductItem, Integer>> a;
    public final Consumer<ProductItem> b;
    public final Consumer<String> c;
    public final Consumer<Integer> d;
    public final Consumer<Pair<ProductItem, StepperUsageType>> e;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((ProductItemPresenter) this.b).e.accept(TuplesKt.to((ProductItem) this.c, StepperUsageType.MINUS));
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((ProductItemPresenter) this.b).e.accept(TuplesKt.to((ProductItem) this.c, StepperUsageType.PLUS));
                return Unit.INSTANCE;
            } else if (i == 2) {
                ((ProductItemPresenter) this.b).c.accept(((ProductItem) this.c).getStringId());
                return Unit.INSTANCE;
            } else if (i == 3) {
                ((ProductItemPresenter) this.b).b.accept((ProductItem) this.c);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ ProductItemView a;
        public final /* synthetic */ ProductItemPresenter b;
        public final /* synthetic */ ProductItem c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ProductItemView productItemView, ProductItemPresenter productItemPresenter, ProductItem productItem) {
            super(1);
            this.a = productItemView;
            this.b = productItemPresenter;
            this.c = productItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0029, code lost:
            if (r3 != false) goto L_0x002d;
         */
        @Override // kotlin.jvm.functions.Function1
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public kotlin.Unit invoke(java.lang.Integer r5) {
            /*
                r4 = this;
                java.lang.Number r5 = (java.lang.Number) r5
                int r5 = r5.intValue()
                com.avito.android.cart.summary.konveyor.product.ProductItemPresenter r0 = r4.b
                io.reactivex.rxjava3.functions.Consumer r0 = com.avito.android.cart.summary.konveyor.product.ProductItemPresenter.access$getQuantityChangesConsumer$p(r0)
                com.avito.android.cart.summary.konveyor.product.ProductItem r1 = r4.c
                java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
                kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r2)
                r0.accept(r1)
                com.avito.android.cart.summary.konveyor.product.ProductItemView r0 = r4.a
                com.avito.android.cart.summary.konveyor.product.ProductItem r1 = r4.c
                com.avito.android.remote.model.text.AttributedText r1 = r1.getPricePerPiece()
                r2 = 0
                if (r1 == 0) goto L_0x002c
                r3 = 1
                if (r5 <= r3) goto L_0x0028
                goto L_0x0029
            L_0x0028:
                r3 = 0
            L_0x0029:
                if (r3 == 0) goto L_0x002c
                goto L_0x002d
            L_0x002c:
                r1 = r2
            L_0x002d:
                r0.setPricePerPiece(r1)
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.cart.summary.konveyor.product.ProductItemPresenter.b.invoke(java.lang.Object):java.lang.Object");
        }
    }

    public static final class c extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ ProductItemPresenter a;
        public final /* synthetic */ ProductItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ProductItemPresenter productItemPresenter, ProductItem productItem) {
            super(1);
            this.a = productItemPresenter;
            this.b = productItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            num.intValue();
            this.a.e.accept(TuplesKt.to(this.b, StepperUsageType.PICKER_SELECT));
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ProductItemPresenter(@NotNull Consumer<Pair<ProductItem, Integer>> consumer, @NotNull Consumer<ProductItem> consumer2, @NotNull Consumer<String> consumer3, @NotNull Consumer<Integer> consumer4, @NotNull Consumer<Pair<ProductItem, StepperUsageType>> consumer5) {
        Intrinsics.checkNotNullParameter(consumer, "quantityChangesConsumer");
        Intrinsics.checkNotNullParameter(consumer2, "deleteItemConsumer");
        Intrinsics.checkNotNullParameter(consumer3, "openAdvertDetailsConsumer");
        Intrinsics.checkNotNullParameter(consumer4, "hideSwipeLayoutsConsumer");
        Intrinsics.checkNotNullParameter(consumer5, "stepperUsageConsumer");
        this.a = consumer;
        this.b = consumer2;
        this.c = consumer3;
        this.d = consumer4;
        this.e = consumer5;
    }

    public void bindView(@NotNull ProductItemView productItemView, @NotNull ProductItem productItem, int i) {
        Intrinsics.checkNotNullParameter(productItemView, "view");
        Intrinsics.checkNotNullParameter(productItem, "item");
        productItemView.setImage(productItem.getImage());
        productItemView.setTitle(productItem.getTitle());
        productItemView.setPrice(productItem.getPrice());
        productItemView.setItemsLeft(productItem.getItemsLeft());
        productItemView.setStepper(productItem.getStepper());
        productItemView.setPricePerPiece(productItem.getPricePerPiece());
        productItemView.setOnStepperValueChangesListener(new b(productItemView, this, productItem));
        productItemView.setOnStepperMinusClickListener(new a(0, this, productItem));
        productItemView.setOnStepperPlusClickListener(new a(1, this, productItem));
        productItemView.setOnPickerValueSelectedListener(new c(this, productItem));
        productItemView.setOnLongClickListener(new a(2, this, productItem));
        productItemView.setOnDeleteClickListener(new a(3, this, productItem));
        productItemView.setSwipeListener(new SwipeLayout.OnSwipeListener(this, productItem) { // from class: com.avito.android.cart.summary.konveyor.product.ProductItemPresenter$bindView$$inlined$with$lambda$7
            public final /* synthetic */ ProductItemPresenter a;

            {
                this.a = r1;
            }

            @Override // ru.rambler.libs.swipe_layout.SwipeLayout.OnSwipeListener
            public void onBeginSwipe(@NotNull SwipeLayout swipeLayout, boolean z) {
                Intrinsics.checkNotNullParameter(swipeLayout, "swipeLayout");
                if (!z) {
                    this.a.d.accept(Integer.valueOf(swipeLayout.hashCode()));
                }
            }

            @Override // ru.rambler.libs.swipe_layout.SwipeLayout.OnSwipeListener
            public void onLeftStickyEdge(@Nullable SwipeLayout swipeLayout, boolean z) {
            }

            @Override // ru.rambler.libs.swipe_layout.SwipeLayout.OnSwipeListener
            public void onRightStickyEdge(@Nullable SwipeLayout swipeLayout, boolean z) {
            }

            @Override // ru.rambler.libs.swipe_layout.SwipeLayout.OnSwipeListener
            public void onSwipeClampReached(@Nullable SwipeLayout swipeLayout, boolean z) {
            }
        });
    }
}
