package ru.sravni.android.bankproduct.network.offer.osago;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.sravni.android.bankproduct.network.offer.entity.request.OfferFilterRequest;
import ru.sravni.android.bankproduct.network.offer.osago.response.OfferOsagoListCompanyResponse;
import ru.sravni.android.bankproduct.network.offer.osago.response.OfferOsagoListResponse;
import ru.sravni.android.bankproduct.network.offer.osago.response.OsagoCompanyOrderResponse;
import ru.sravni.android.bankproduct.network.offer.osago.response.OsagoOrderCompanyInfoResponse;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J3\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\t\u0010\nJ)\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u0002H'¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H'¢\u0006\u0004\b\u0010\u0010\u000eJ=\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u00022\b\b\u0001\u0010\u0012\u001a\u00020\u0002H'¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\u0015\u001a\u00020\u0002H'¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/osago/IOfferOsagoApi;", "", "", SDKConstants.PARAM_ACCESS_TOKEN, "savedSearchID", "Lru/sravni/android/bankproduct/network/offer/entity/request/OfferFilterRequest;", "filters", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoListResponse;", "getOsagoListCompany", "(Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/network/offer/entity/request/OfferFilterRequest;)Lio/reactivex/Observable;", "pollingID", "Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoListCompanyResponse;", "getPollingListCompany", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoCompanyOrderResponse;", "getOsagoOrder", "productID", "companyID", "getAlternativeOsagoOrder", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "savedSearchId", "Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoOrderCompanyInfoResponse;", "getPollingOrderCompany", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IOfferOsagoApi {
    @GET("v1/osago/order/start/{savedSearchID}")
    @NotNull
    Observable<OsagoCompanyOrderResponse> getAlternativeOsagoOrder(@Header("bearer") @NotNull String str, @Path("savedSearchID") @NotNull String str2, @NotNull @Query("productId") String str3, @NotNull @Query("companyId") String str4);

    @POST("v3/osago/start/{savedSearchID}")
    @NotNull
    Observable<OfferOsagoListResponse> getOsagoListCompany(@Header("bearer") @NotNull String str, @Path("savedSearchID") @NotNull String str2, @Body @NotNull OfferFilterRequest offerFilterRequest);

    @GET("v1/osago/order/start/{savedSearchID}")
    @NotNull
    Observable<OsagoCompanyOrderResponse> getOsagoOrder(@Header("bearer") @NotNull String str, @Path("savedSearchID") @NotNull String str2);

    @GET("v3/osago/polling/{pollingID}")
    @NotNull
    Observable<OfferOsagoListCompanyResponse> getPollingListCompany(@Header("bearer") @NotNull String str, @Path("pollingID") @NotNull String str2);

    @GET("v1/osago/order/polling/{pollingID}")
    @NotNull
    Observable<OsagoOrderCompanyInfoResponse> getPollingOrderCompany(@Header("bearer") @NotNull String str, @Path("pollingID") @NotNull String str2, @NotNull @Query("savedSearchId") String str3);
}
