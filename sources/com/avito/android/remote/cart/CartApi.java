package com.avito.android.remote.cart;

import com.avito.android.remote.cart.model.CartQuantity;
import com.avito.android.remote.cart.model.CartSummary;
import com.avito.android.remote.cart.model.CheckQuantityResponse;
import com.avito.android.remote.cart.model.DeleteItemResponse;
import com.avito.android.remote.model.AdvertAction;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00030\u00022\b\b\u0001\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00030\u00022\b\b\u0001\u0010\f\u001a\u00020\u0007H'¢\u0006\u0004\b\u000e\u0010\u000bJ1\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00030\u00022\b\b\u0001\u0010\b\u001a\u00020\u00072\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0007H'¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00030\u0002H'¢\u0006\u0004\b\u0014\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/cart/CartApi;", "", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/cart/model/CartSummary;", "getCart", "()Lio/reactivex/rxjava3/core/Single;", "", "itemId", "Lcom/avito/android/remote/cart/model/DeleteItemResponse;", "deleteItem", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "itemsQuantities", "Lcom/avito/android/remote/cart/model/CheckQuantityResponse;", "checkItemsQuantity", "context", "Lcom/avito/android/remote/model/AdvertAction$Cart;", "addItemToCart", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/cart/model/CartQuantity;", "getCartSize", "cart_release"}, k = 1, mv = {1, 4, 2})
public interface CartApi {
    @POST("1/cart/item/add")
    @NotNull
    Single<TypedResult<AdvertAction.Cart>> addItemToCart(@NotNull @Query("itemId") String str, @Nullable @Query("context") String str2);

    @NotNull
    @FormUrlEncoded
    @POST("1/cart/update")
    Single<TypedResult<CheckQuantityResponse>> checkItemsQuantity(@Field("items") @NotNull String str);

    @NotNull
    @FormUrlEncoded
    @POST("1/cart/item/delete")
    Single<TypedResult<DeleteItemResponse>> deleteItem(@Field("itemId") @NotNull String str);

    @GET("1/cart/details")
    @NotNull
    Single<TypedResult<CartSummary>> getCart();

    @GET("1/cart/quantity")
    @NotNull
    Single<TypedResult<CartQuantity>> getCartSize();
}
