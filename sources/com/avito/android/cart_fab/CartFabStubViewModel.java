package com.avito.android.cart_fab;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR$\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/avito/android/cart_fab/CartFabStubViewModel;", "Lcom/avito/android/cart_fab/CartFabViewModel;", "", "loadCartSize", "()V", "onFabClicked", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/deep_linking/links/DeepLink;", "d", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getOpenDeepLinkChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "openDeepLinkChanges", "Lio/reactivex/rxjava3/core/Single;", "", "f", "Lio/reactivex/rxjava3/core/Single;", "getCurrentQuantity", "()Lio/reactivex/rxjava3/core/Single;", "currentQuantity", "Lio/reactivex/rxjava3/functions/Consumer;", "e", "Lio/reactivex/rxjava3/functions/Consumer;", "getQuantityConsumer", "()Lio/reactivex/rxjava3/functions/Consumer;", "quantityConsumer", "Landroidx/lifecycle/LiveData;", "c", "Landroidx/lifecycle/LiveData;", "getQuantityChanges", "()Landroidx/lifecycle/LiveData;", "quantityChanges", "<init>", "cart-fab_release"}, k = 1, mv = {1, 4, 2})
public final class CartFabStubViewModel extends CartFabViewModel {
    @NotNull
    public final LiveData<Integer> c = new MutableLiveData();
    @NotNull
    public final SingleLiveEvent<DeepLink> d = new SingleLiveEvent<>();
    @NotNull
    public final Consumer<Integer> e;
    @NotNull
    public final Single<Integer> f;

    public CartFabStubViewModel() {
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.e = create;
        Single<Integer> error = Single.error(new IllegalStateException("CartFab feature is disabled"));
        Intrinsics.checkNotNullExpressionValue(error, "Single.error(IllegalStat…ab feature is disabled\"))");
        this.f = error;
    }

    @Override // com.avito.android.cart_fab.CartFabViewModel
    @NotNull
    public Single<Integer> getCurrentQuantity() {
        return this.f;
    }

    @Override // com.avito.android.cart_fab.CartFabViewModel
    @NotNull
    public LiveData<Integer> getQuantityChanges() {
        return this.c;
    }

    @Override // com.avito.android.cart_fab.CartFabViewModel
    @NotNull
    public Consumer<Integer> getQuantityConsumer() {
        return this.e;
    }

    @Override // com.avito.android.cart_fab.CartFabViewModel
    public void loadCartSize() {
    }

    @Override // com.avito.android.cart_fab.CartFabViewModel
    public void onFabClicked() {
    }

    @Override // com.avito.android.cart_fab.CartFabViewModel
    @NotNull
    public SingleLiveEvent<DeepLink> getOpenDeepLinkChanges() {
        return this.d;
    }
}
