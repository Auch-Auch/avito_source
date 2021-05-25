package com.avito.android.cart_fab;

import a2.a.a.b0.b;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010 \u001a\u00020\u001b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b!\u0010\"J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0019\u0010 \u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/cart_fab/CartFabView;", "", "", "isVisible", "", "setVisible", "(Z)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "f", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Landroidx/lifecycle/LifecycleOwner;", "c", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/avito/android/cart_fab/CartFabViewModel;", "d", "Lcom/avito/android/cart_fab/CartFabViewModel;", "viewModel", "Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "e", "Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "quantityChangesHandler", "", AuthSource.SEND_ABUSE, "Ljava/lang/Integer;", "currentQuantity", "Lcom/avito/android/cart_fab/CartFloatingActionButton;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/cart_fab/CartFloatingActionButton;", "getFab", "()Lcom/avito/android/cart_fab/CartFloatingActionButton;", "fab", "<init>", "(Lcom/avito/android/cart_fab/CartFloatingActionButton;Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/cart_fab/CartFabViewModel;Lcom/avito/android/cart_fab/CartQuantityChangesHandler;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "cart-fab_release"}, k = 1, mv = {1, 4, 2})
public final class CartFabView {
    public Integer a = 0;
    @NotNull
    public final CartFloatingActionButton b;
    public final LifecycleOwner c;
    public final CartFabViewModel d;
    public final CartQuantityChangesHandler e;
    public final DeepLinkIntentFactory f;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ CartFabView a;

        public a(CartFabView cartFabView) {
            this.a = cartFabView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.d.onFabClicked();
        }
    }

    public CartFabView(@NotNull CartFloatingActionButton cartFloatingActionButton, @NotNull LifecycleOwner lifecycleOwner, @NotNull CartFabViewModel cartFabViewModel, @NotNull CartQuantityChangesHandler cartQuantityChangesHandler, @NotNull DeepLinkIntentFactory deepLinkIntentFactory) {
        Intrinsics.checkNotNullParameter(cartFloatingActionButton, "fab");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(cartFabViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(cartQuantityChangesHandler, "quantityChangesHandler");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        this.b = cartFloatingActionButton;
        this.c = lifecycleOwner;
        this.d = cartFabViewModel;
        this.e = cartQuantityChangesHandler;
        this.f = deepLinkIntentFactory;
        cartFabViewModel.getQuantityChanges().observe(lifecycleOwner, new a2.a.a.b0.a(this));
        cartFabViewModel.getOpenDeepLinkChanges().observe(lifecycleOwner, new b(this));
        cartFloatingActionButton.getButton().setOnClickListener(new a(this));
    }

    public static final void access$openDeepLink(CartFabView cartFabView, Context context, DeepLink deepLink) {
        Intent intent = cartFabView.f.getIntent(deepLink);
        if (intent != null) {
            context.startActivity(intent);
        } else {
            ToastsKt.showToast(context, R.string.cart_intent_not_found, 1);
        }
    }

    @NotNull
    public final CartFloatingActionButton getFab() {
        return this.b;
    }

    public final void setVisible(boolean z) {
        CartFloatingActionButton cartFloatingActionButton = this.b;
        Integer num = this.a;
        Views.setVisible(cartFloatingActionButton, (num == null || num.intValue() != 0) && z);
    }
}
