package com.avito.android.remote;

import com.avito.android.remote.model.CheckoutCommitResult;
import com.avito.android.remote.model.CheckoutContentsResult;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Observable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ;\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u00042\b\b\u0001\u0010\t\u001a\u00020\u00022\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\nH'¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/CheckoutApi;", "", "", "context", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/CheckoutContentsResult;", "getCheckoutContent", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "checkoutContext", "", "images", "Lcom/avito/android/remote/model/CheckoutCommitResult;", "commitCheckout", "(Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "checkout_release"}, k = 1, mv = {1, 4, 2})
public interface CheckoutApi {
    @NotNull
    @FormUrlEncoded
    @POST("1/checkout")
    Observable<TypedResult<CheckoutCommitResult>> commitCheckout(@Field("checkoutContext") @NotNull String str, @FieldMap @NotNull Map<String, String> map);

    @GET("2/checkout")
    @NotNull
    Observable<TypedResult<CheckoutContentsResult>> getCheckoutContent(@NotNull @Query("checkoutContext") String str);
}
