package com.avito.android.cart_fab;

import androidx.annotation.MainThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.deep_linking.links.DeepLink;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0004R\u001e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/avito/android/cart_fab/CartFabViewModel;", "Landroidx/lifecycle/ViewModel;", "", "loadCartSize", "()V", "onFabClicked", "Lio/reactivex/rxjava3/core/Single;", "", "getCurrentQuantity", "()Lio/reactivex/rxjava3/core/Single;", "currentQuantity", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/deep_linking/links/DeepLink;", "getOpenDeepLinkChanges", "()Landroidx/lifecycle/LiveData;", "openDeepLinkChanges", "Lio/reactivex/rxjava3/functions/Consumer;", "getQuantityConsumer", "()Lio/reactivex/rxjava3/functions/Consumer;", "quantityConsumer", "getQuantityChanges", "quantityChanges", "<init>", "cart-fab_release"}, k = 1, mv = {1, 4, 2})
public abstract class CartFabViewModel extends ViewModel {
    @NotNull
    public abstract Single<Integer> getCurrentQuantity();

    @NotNull
    public abstract LiveData<DeepLink> getOpenDeepLinkChanges();

    @NotNull
    public abstract LiveData<Integer> getQuantityChanges();

    @NotNull
    public abstract Consumer<Integer> getQuantityConsumer();

    public abstract void loadCartSize();

    @MainThread
    public abstract void onFabClicked();
}
