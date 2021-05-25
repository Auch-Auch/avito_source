package com.avito.android.basket.checkout.item.checkout;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.avito.android.basket.R;
import com.avito.android.basket.checkout.item.checkout.CheckoutItemView;
import com.avito.android.image_loader.Picture;
import com.avito.android.util.AnimationUtils;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00018B\u000f\u0012\u0006\u0010-\u001a\u00020*¢\u0006\u0004\b6\u00107J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001f\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010\"R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010\"R\u0016\u00101\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010\"R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00069"}, d2 = {"Lcom/avito/android/basket/checkout/item/checkout/CheckoutItemViewImpl;", "Lcom/avito/android/basket/checkout/item/checkout/CheckoutItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "price", "setPrice", "", "oldPrice", "setOldPrice", "(Ljava/lang/CharSequence;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setPicture", "(Lcom/avito/android/image_loader/Picture;)V", "", "padding", "setBottomPadding", "(I)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnCrossClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setOnBackToBasketClickListener", "", "isCancellable", "setItemActive", "(Z)V", "setItemInactive", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "oldPriceView", "Landroid/widget/ImageButton;", "w", "Landroid/widget/ImageButton;", "crossButton", "x", "backToBasketButton", "Landroid/view/View;", "y", "Landroid/view/View;", "view", "s", "titleView", "t", "priceView", "Lcom/facebook/drawee/view/SimpleDraweeView;", VKApiConst.VERSION, "Lcom/facebook/drawee/view/SimpleDraweeView;", "icon", "<init>", "(Landroid/view/View;)V", "Companion", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class CheckoutItemViewImpl extends BaseViewHolder implements CheckoutItemView {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final SimpleDraweeView v;
    public final ImageButton w;
    public final TextView x;
    public final View y;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/basket/checkout/item/checkout/CheckoutItemViewImpl$Companion;", "", "", "ACTIVE_ITEM_ALPHA", "F", "INACTIVE_ITEM_ALPHA", "<init>", "()V", "basket_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckoutItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.y = view;
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.price);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.old_price);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.icon);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.v = (SimpleDraweeView) findViewById4;
        View findViewById5 = view.findViewById(R.id.icon_cross);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.ImageButton");
        this.w = (ImageButton) findViewById5;
        View findViewById6 = view.findViewById(R.id.back_to_basket_button);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.x = (TextView) findViewById6;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        CheckoutItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.basket.checkout.item.checkout.CheckoutItemView
    public void setBottomPadding(int i) {
        Views.changePadding$default(this.y, 0, 0, 0, i, 7, null);
    }

    @Override // com.avito.android.basket.checkout.item.checkout.CheckoutItemView
    public void setItemActive(boolean z) {
        if (z) {
            AnimationUtils animationUtils = AnimationUtils.INSTANCE;
            animationUtils.setAlpha(this.s, 1.0f);
            animationUtils.setAlpha(this.t, 1.0f);
            animationUtils.setAlpha(this.u, 1.0f);
            animationUtils.setAlpha(this.v, 1.0f);
            Views.show(this.w);
            Views.hide(this.x);
            return;
        }
        Views.hide(this.w);
        Views.hide(this.x);
    }

    @Override // com.avito.android.basket.checkout.item.checkout.CheckoutItemView
    public void setItemInactive(boolean z) {
        if (z) {
            AnimationUtils animationUtils = AnimationUtils.INSTANCE;
            animationUtils.setAlpha(this.s, 0.3f);
            animationUtils.setAlpha(this.t, 0.3f);
            animationUtils.setAlpha(this.u, 0.3f);
            animationUtils.setAlpha(this.v, 0.3f);
            Views.hide(this.w);
            Views.show(this.x);
            return;
        }
        Views.hide(this.w);
        Views.hide(this.x);
    }

    @Override // com.avito.android.basket.checkout.item.checkout.CheckoutItemView
    public void setOldPrice(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.u, charSequence, false, 2, null);
    }

    @Override // com.avito.android.basket.checkout.item.checkout.CheckoutItemView
    public void setOnBackToBasketClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.x.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.basket.checkout.item.checkout.CheckoutItemView
    public void setOnCrossClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.w.setOnClickListener(new b(function0));
    }

    @Override // com.avito.android.basket.checkout.item.checkout.CheckoutItemView
    public void setPicture(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        SimpleDraweeViewsKt.loadPicture$default(this.v, picture, null, null, 6, null);
    }

    @Override // com.avito.android.basket.checkout.item.checkout.CheckoutItemView
    public void setPrice(@Nullable String str) {
        TextViews.bindText$default(this.t, str, false, 2, null);
    }

    @Override // com.avito.android.basket.checkout.item.checkout.CheckoutItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setText(str);
    }
}
