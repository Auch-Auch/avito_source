package com.avito.android.cart_fab;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.cart.CartApi;
import com.avito.android.remote.cart.model.CartQuantity;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/cart_fab/CartFabRepositoryImpl;", "Lcom/avito/android/cart_fab/CartFabRepository;", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/cart/model/CartQuantity;", "cartSizeUpdates", "()Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/cart/CartApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/cart/CartApi;", "api", "<init>", "(Lcom/avito/android/remote/cart/CartApi;Lcom/avito/android/util/SchedulersFactory3;)V", "cart-fab_release"}, k = 1, mv = {1, 4, 2})
public final class CartFabRepositoryImpl implements CartFabRepository {
    public final CartApi a;
    public final SchedulersFactory3 b;

    @Inject
    public CartFabRepositoryImpl(@NotNull CartApi cartApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(cartApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = cartApi;
        this.b = schedulersFactory3;
    }

    @Override // com.avito.android.cart_fab.CartFabRepository
    @NotNull
    public Single<TypedResult<CartQuantity>> cartSizeUpdates() {
        return a.e2(this.b, this.a.getCartSize(), "api.getCartSize().subscribeOn(schedulers.io())");
    }
}
