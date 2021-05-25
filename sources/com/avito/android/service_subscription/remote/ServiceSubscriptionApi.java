package com.avito.android.service_subscription.remote;

import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.service_subscription_legacy.ServiceSubscriptionResponse;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.POST;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H'¢\u0006\u0004\b\t\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/avito/android/service_subscription/remote/ServiceSubscriptionApi;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/service_subscription_legacy/ServiceSubscriptionResponse;", "getLegacyServiceSubscriptions", "()Lio/reactivex/rxjava3/core/Observable;", "getServiceSubscriptions", "getLfPackages", "Lcom/avito/android/remote/model/SuccessResult;", "orderCallback", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public interface ServiceSubscriptionApi {
    @GET("3/serviceSubscriptions")
    @NotNull
    Observable<ServiceSubscriptionResponse> getLegacyServiceSubscriptions();

    @GET("1/lf/packages")
    @NotNull
    Observable<ServiceSubscriptionResponse> getLfPackages();

    @GET("4/serviceSubscriptions")
    @NotNull
    Observable<ServiceSubscriptionResponse> getServiceSubscriptions();

    @POST("1/phones/orderCallback")
    @NotNull
    Observable<SuccessResult> orderCallback();
}
