package com.avito.android.payment.remote;

import com.avito.android.remote.NetworkRequestEventId;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.payment.form.PaymentGenericFormResult;
import com.avito.android.remote.model.payment.generic.PaymentGenericResult;
import com.avito.android.remote.model.payment.history.PaymentDetails;
import com.avito.android.remote.model.payment.history.PaymentHistoryPage;
import com.avito.android.remote.model.payment.service.PaymentSessionResult;
import com.avito.android.remote.model.payment.status.PaymentStatusResult;
import com.avito.android.remote.model.payment.status.form.PaymentStatusFormResult;
import com.avito.android.remote.model.payment.top_up.TopUpForm;
import com.avito.android.remote.model.payment.wallet.WalletPage;
import io.reactivex.rxjava3.core.Observable;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JE\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H'¢\u0006\u0004\b\n\u0010\u000bJE\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H'¢\u0006\u0004\b\f\u0010\u000bJ]\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\u00072\b\b\u0001\u0010\r\u001a\u00020\u00022\u0014\b\u0001\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0014\b\u0003\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H'¢\u0006\u0004\b\u0012\u0010\u0013JS\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\u00072\u0014\b\u0001\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0014\b\u0003\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H'¢\u0006\u0004\b\u0015\u0010\u0016JG\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\u00072\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\u0014\b\u0003\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H'¢\u0006\u0004\b\u0017\u0010\u0018JG\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\u00072\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\u0014\b\u0003\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H'¢\u0006\u0004\b\u0019\u0010\u0018J/\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H'¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H'¢\u0006\u0004\b\u001d\u0010\u001cJ1\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\b0\u00072\b\b\u0001\u0010\u001e\u001a\u00020\u00022\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b!\u0010\u001cJ%\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\b0\u00072\b\b\u0001\u0010\"\u001a\u00020\u0002H'¢\u0006\u0004\b$\u0010%J%\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\b0\u00072\b\b\u0001\u0010&\u001a\u00020\u0002H'¢\u0006\u0004\b(\u0010%J%\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\b0\u00072\b\b\u0001\u0010\"\u001a\u00020\u0002H'¢\u0006\u0004\b*\u0010%J%\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\b0\u00072\b\b\u0001\u0010\"\u001a\u00020\u0002H'¢\u0006\u0004\b,\u0010%J\u001b\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\b0\u0007H'¢\u0006\u0004\b.\u0010/J\u001b\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\b0\u0007H'¢\u0006\u0004\b1\u0010/¨\u00062"}, d2 = {"Lcom/avito/android/payment/remote/PaymentApi;", "", "", "paymentSessionId", "methodSignature", "", "params", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/payment/generic/PaymentGenericResult;", "legacyCreatePayment", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "createPayment", "itemId", "serviceId", "context", "nativeMethods", "Lcom/avito/android/remote/model/payment/service/PaymentSessionResult;", "legacyCreateServicePaymentSession", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "orderItems", "createServicePaymentSession", "(Ljava/util/Map;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "createWalletPaymentSession", "(Ljava/util/Map;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "createWalletPaymentSessionV4", "Lcom/avito/android/remote/model/payment/form/PaymentGenericFormResult;", "legacyGetPaymentForm", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "getPaymentForm", "historyId", "pageToken", "Lcom/avito/android/remote/model/payment/history/PaymentHistoryPage;", "getPaymentHistory", AnalyticFieldsName.orderId, "Lcom/avito/android/remote/model/payment/history/PaymentDetails$OrderDetails;", "getOrderDetails", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "operationId", "Lcom/avito/android/remote/model/payment/history/PaymentDetails$OperationDetails;", "getOperationDetails", "Lcom/avito/android/remote/model/payment/status/PaymentStatusResult;", "getPaymentStatus", "Lcom/avito/android/remote/model/payment/status/form/PaymentStatusFormResult;", "getPaymentStatusForm", "Lcom/avito/android/remote/model/payment/top_up/TopUpForm;", "getWalletTopUpForm", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/payment/wallet/WalletPage;", "getWalletPage", "payment_release"}, k = 1, mv = {1, 4, 2})
public interface PaymentApi {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.payment.remote.PaymentApi */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable createServicePaymentSession$default(PaymentApi paymentApi, Map map, String str, Map map2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    map2 = r.emptyMap();
                }
                return paymentApi.createServicePaymentSession(map, str, map2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createServicePaymentSession");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.payment.remote.PaymentApi */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable createWalletPaymentSession$default(PaymentApi paymentApi, Map map, Map map2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    map2 = r.emptyMap();
                }
                return paymentApi.createWalletPaymentSession(map, map2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createWalletPaymentSession");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.payment.remote.PaymentApi */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable createWalletPaymentSessionV4$default(PaymentApi paymentApi, Map map, Map map2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    map2 = r.emptyMap();
                }
                return paymentApi.createWalletPaymentSessionV4(map, map2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createWalletPaymentSessionV4");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.payment.remote.PaymentApi */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable legacyCreateServicePaymentSession$default(PaymentApi paymentApi, String str, Map map, String str2, Map map2, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    map2 = r.emptyMap();
                }
                return paymentApi.legacyCreateServicePaymentSession(str, map, str2, map2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: legacyCreateServicePaymentSession");
        }
    }

    @NotNull
    @NetworkRequestEventId(eventId = 3707)
    @FormUrlEncoded
    @POST("2/payment/generic")
    Observable<TypedResult<PaymentGenericResult>> createPayment(@Field("paymentSessionId") @NotNull String str, @Field("methodSignature") @NotNull String str2, @FieldMap @NotNull Map<String, String> map);

    @NotNull
    @NetworkRequestEventId(eventId = 3713)
    @FormUrlEncoded
    @POST("4/payment/session/service")
    Observable<TypedResult<PaymentSessionResult>> createServicePaymentSession(@FieldMap @NotNull Map<String, String> map, @Field("context") @Nullable String str, @FieldMap @NotNull Map<String, String> map2);

    @NotNull
    @FormUrlEncoded
    @POST("3/payment/session/wallet")
    Observable<TypedResult<PaymentSessionResult>> createWalletPaymentSession(@FieldMap @NotNull Map<String, String> map, @FieldMap @NotNull Map<String, String> map2);

    @NotNull
    @FormUrlEncoded
    @POST("4/payment/session/wallet")
    Observable<TypedResult<PaymentSessionResult>> createWalletPaymentSessionV4(@FieldMap @NotNull Map<String, String> map, @FieldMap @NotNull Map<String, String> map2);

    @GET("1/payment/operation/{operationId}")
    @NotNull
    @NetworkRequestEventId(eventId = 3710)
    Observable<TypedResult<PaymentDetails.OperationDetails>> getOperationDetails(@Path("operationId") @NotNull String str);

    @GET("1/payment/order/{orderId}")
    @NotNull
    Observable<TypedResult<PaymentDetails.OrderDetails>> getOrderDetails(@Path("orderId") @NotNull String str);

    @GET("2/payment/generic/form")
    @NotNull
    @NetworkRequestEventId(eventId = 3708)
    Observable<TypedResult<PaymentGenericFormResult>> getPaymentForm(@NotNull @Query("paymentSessionId") String str, @NotNull @Query("methodSignature") String str2);

    @GET("1/payment/history/{historyId}")
    @NotNull
    @NetworkRequestEventId(eventId = 3709)
    Observable<TypedResult<PaymentHistoryPage>> getPaymentHistory(@Path("historyId") @NotNull String str, @Nullable @Query("pageToken") String str2);

    @GET("1/payment/order/{orderId}/status")
    @NotNull
    @NetworkRequestEventId(eventId = 3711)
    Observable<TypedResult<PaymentStatusResult>> getPaymentStatus(@Path("orderId") @NotNull String str);

    @GET("1/payment/order/{orderId}/status/form")
    @NotNull
    @NetworkRequestEventId(eventId = 3712)
    Observable<TypedResult<PaymentStatusFormResult>> getPaymentStatusForm(@Path("orderId") @NotNull String str);

    @GET("1/wallet/info")
    @NotNull
    @NetworkRequestEventId(eventId = 3602)
    Observable<TypedResult<WalletPage>> getWalletPage();

    @GET("1/payment/wallet/form")
    @NotNull
    @NetworkRequestEventId(eventId = 3715)
    Observable<TypedResult<TopUpForm>> getWalletTopUpForm();

    @NotNull
    @Deprecated(message = "Deprecated in BILL-4537. Use createPayment instead.")
    @NetworkRequestEventId(eventId = 3707)
    @FormUrlEncoded
    @POST("1/payment/generic")
    Observable<TypedResult<PaymentGenericResult>> legacyCreatePayment(@Field("paymentSessionId") @NotNull String str, @Field("methodSignature") @NotNull String str2, @FieldMap @NotNull Map<String, String> map);

    @NotNull
    @Deprecated(message = "Deprecated in BILL-4537. Use createServicePaymentSession() instead.")
    @NetworkRequestEventId(eventId = 3713)
    @FormUrlEncoded
    @POST("3/payment/session/service")
    Observable<TypedResult<PaymentSessionResult>> legacyCreateServicePaymentSession(@Field("itemId") @NotNull String str, @FieldMap @NotNull Map<String, String> map, @Field("context") @Nullable String str2, @FieldMap @NotNull Map<String, String> map2);

    @GET("1/payment/generic/form")
    @NotNull
    @Deprecated(message = "Deprecated in BILL-4537. Use getPaymentForm() instead.")
    @NetworkRequestEventId(eventId = 3708)
    Observable<TypedResult<PaymentGenericFormResult>> legacyGetPaymentForm(@NotNull @Query("paymentSessionId") String str, @NotNull @Query("methodSignature") String str2);
}
