package com.avito.android.cart.summary;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.cart.CartApi;
import com.avito.android.remote.cart.model.CartSummary;
import com.avito.android.remote.cart.model.CheckQuantityResponse;
import com.avito.android.remote.cart.model.DeleteItemResponse;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Single;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00030\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00030\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/cart/summary/CartSummaryRepositoryImpl;", "Lcom/avito/android/cart/summary/CartSummaryRepository;", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/cart/model/CartSummary;", "getCart", "()Lio/reactivex/rxjava3/core/Single;", "", "Lcom/avito/android/cart/summary/ItemQuantity;", "products", "Lcom/avito/android/remote/cart/model/CheckQuantityResponse;", "checkQuantity", "(Ljava/util/List;)Lio/reactivex/rxjava3/core/Single;", "", "itemId", "Lcom/avito/android/remote/cart/model/DeleteItemResponse;", "deleteItem", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/cart/CartApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/cart/CartApi;", "api", "<init>", "(Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/cart/CartApi;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class CartSummaryRepositoryImpl implements CartSummaryRepository {
    public final SchedulersFactory3 a;
    public final CartApi b;

    @Inject
    public CartSummaryRepositoryImpl(@NotNull SchedulersFactory3 schedulersFactory3, @NotNull CartApi cartApi) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(cartApi, "api");
        this.a = schedulersFactory3;
        this.b = cartApi;
    }

    @Override // com.avito.android.cart.summary.CartSummaryRepository
    @NotNull
    public Single<TypedResult<CheckQuantityResponse>> checkQuantity(@NotNull List<ItemQuantity> list) {
        Intrinsics.checkNotNullParameter(list, "products");
        return a.e2(this.a, this.b.checkItemsQuantity(CollectionsKt___CollectionsKt.joinToString$default(list, null, "{", "}", 0, null, null, 57, null)), "api.checkItemsQuantity(i…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.cart.summary.CartSummaryRepository
    @NotNull
    public Single<TypedResult<DeleteItemResponse>> deleteItem(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        return a.e2(this.a, this.b.deleteItem(str), "api.deleteItem(itemId).s…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.cart.summary.CartSummaryRepository
    @NotNull
    public Single<TypedResult<CartSummary>> getCart() {
        return a.e2(this.a, this.b.getCart(), "api.getCart().subscribeOn(schedulers.io())");
    }
}
