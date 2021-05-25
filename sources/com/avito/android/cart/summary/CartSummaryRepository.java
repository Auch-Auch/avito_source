package com.avito.android.cart.summary;

import com.avito.android.remote.cart.model.CartSummary;
import com.avito.android.remote.cart.model.CheckQuantityResponse;
import com.avito.android.remote.cart.model.DeleteItemResponse;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00030\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/cart/summary/CartSummaryRepository;", "", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/cart/model/CartSummary;", "getCart", "()Lio/reactivex/rxjava3/core/Single;", "", "itemId", "Lcom/avito/android/remote/cart/model/DeleteItemResponse;", "deleteItem", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "", "Lcom/avito/android/cart/summary/ItemQuantity;", "products", "Lcom/avito/android/remote/cart/model/CheckQuantityResponse;", "checkQuantity", "(Ljava/util/List;)Lio/reactivex/rxjava3/core/Single;", "cart_release"}, k = 1, mv = {1, 4, 2})
public interface CartSummaryRepository {
    @NotNull
    Single<TypedResult<CheckQuantityResponse>> checkQuantity(@NotNull List<ItemQuantity> list);

    @NotNull
    Single<TypedResult<DeleteItemResponse>> deleteItem(@NotNull String str);

    @NotNull
    Single<TypedResult<CartSummary>> getCart();
}
