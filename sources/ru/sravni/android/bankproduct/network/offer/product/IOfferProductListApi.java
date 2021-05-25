package ru.sravni.android.bankproduct.network.offer.product;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import ru.sravni.android.bankproduct.network.offer.entity.request.OfferFilterRequest;
import ru.sravni.android.bankproduct.network.offer.product.request.OfferSendRequest;
import ru.sravni.android.bankproduct.network.offer.product.response.OfferProductCountResponse;
import ru.sravni.android.bankproduct.network.offer.product.response.OfferProductDetailResponse;
import ru.sravni.android.bankproduct.network.offer.product.response.OfferProductListResponse;
import ru.sravni.android.bankproduct.network.offer.product.response.OfferProductStatusResponse;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J3\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\t\u0010\nJ3\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\f\u0010\nJ3\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u000e\u0010\nJ3\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u000f\u0010\nJ)\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u0015H'¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0018\u001a\u00020\u0002H'¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u001b\u001a\u00020\u0002H'¢\u0006\u0004\b\u001d\u0010\u001a¨\u0006\u001e"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/product/IOfferProductListApi;", "", "", SDKConstants.PARAM_ACCESS_TOKEN, "savedSearchID", "Lru/sravni/android/bankproduct/network/offer/entity/request/OfferFilterRequest;", "filters", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/network/offer/product/response/legacy/OfferProductListResponse;", "getOfferProductListLegacy", "(Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/network/offer/entity/request/OfferFilterRequest;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse;", "getOfferProductList", "Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductCountResponse;", "getCountOfferProductWithNewParamLegacy", "getCountOfferProductWithNewParam", "Lru/sravni/android/bankproduct/network/offer/product/request/legacy/OfferSendRequest;", BaseAnalyticKt.ANALYTIC_MODULE_OFFER, "Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductStatusResponse;", "sendProductOrderToBankLegacy", "(Ljava/lang/String;Lru/sravni/android/bankproduct/network/offer/product/request/legacy/OfferSendRequest;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/network/offer/product/request/OfferSendRequest;", "sendProductOrderToBank", "(Ljava/lang/String;Lru/sravni/android/bankproduct/network/offer/product/request/OfferSendRequest;)Lio/reactivex/Observable;", "orderID", "getProductStatus", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", AnalyticFieldsName.conversationID, "Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductDetailResponse;", "getProductDetail", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IOfferProductListApi {
    @POST("v4/saved_search/credit/{savedSearchID}/count")
    @NotNull
    Observable<OfferProductCountResponse> getCountOfferProductWithNewParam(@Header("bearer") @NotNull String str, @Path("savedSearchID") @NotNull String str2, @Body @NotNull OfferFilterRequest offerFilterRequest);

    @POST("v3/saved_search/{savedSearchID}/count")
    @NotNull
    Observable<OfferProductCountResponse> getCountOfferProductWithNewParamLegacy(@Header("bearer") @NotNull String str, @Path("savedSearchID") @NotNull String str2, @Body @NotNull OfferFilterRequest offerFilterRequest);

    @POST("v4/saved_search/credit/{savedSearchID}")
    @NotNull
    Observable<OfferProductListResponse> getOfferProductList(@Header("bearer") @NotNull String str, @Path("savedSearchID") @NotNull String str2, @Body @NotNull OfferFilterRequest offerFilterRequest);

    @POST("v3/saved_search/{savedSearchID}")
    @NotNull
    Observable<ru.sravni.android.bankproduct.network.offer.product.response.legacy.OfferProductListResponse> getOfferProductListLegacy(@Header("bearer") @NotNull String str, @Path("savedSearchID") @NotNull String str2, @Body @NotNull OfferFilterRequest offerFilterRequest);

    @GET("v4/credit/product/{conversationId}")
    @NotNull
    Observable<OfferProductDetailResponse> getProductDetail(@Header("bearer") @NotNull String str, @Path("conversationId") @NotNull String str2);

    @GET("v3/credit_order/{orderID}/status")
    @NotNull
    Observable<OfferProductStatusResponse> getProductStatus(@Header("bearer") @NotNull String str, @Path("orderID") @NotNull String str2);

    @POST("v4/credit_order")
    @NotNull
    Observable<OfferProductStatusResponse> sendProductOrderToBank(@Header("bearer") @NotNull String str, @Body @NotNull OfferSendRequest offerSendRequest);

    @POST("v3/credit_order")
    @NotNull
    Observable<OfferProductStatusResponse> sendProductOrderToBankLegacy(@Header("bearer") @NotNull String str, @Body @NotNull ru.sravni.android.bankproduct.network.offer.product.request.legacy.OfferSendRequest offerSendRequest);
}
