package com.avito.android.service_subscription.lf_packages;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.service_subscription_legacy.ServiceSubscriptionResponse;
import com.avito.android.service_subscription.ServiceSubscriptionInteractor;
import com.avito.android.service_subscription.remote.ServiceSubscriptionApi;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/service_subscription/lf_packages/LfPackagesInteractorImpl;", "Lcom/avito/android/service_subscription/ServiceSubscriptionInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/service_subscription_legacy/ServiceSubscriptionResponse;", "loadServiceSubscription", "()Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/SuccessResult;", "orderCallback", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/service_subscription/remote/ServiceSubscriptionApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/service_subscription/remote/ServiceSubscriptionApi;", "subscriptionApi", "<init>", "(Lcom/avito/android/service_subscription/remote/ServiceSubscriptionApi;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/util/SchedulersFactory;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class LfPackagesInteractorImpl implements ServiceSubscriptionInteractor {
    public final ServiceSubscriptionApi a;
    public final TypedErrorThrowableConverter b;
    public final SchedulersFactory c;

    public static final class a<T, R> implements Function<ServiceSubscriptionResponse, LoadingState<? super ServiceSubscriptionResponse>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super ServiceSubscriptionResponse> apply(ServiceSubscriptionResponse serviceSubscriptionResponse) {
            ServiceSubscriptionResponse serviceSubscriptionResponse2 = serviceSubscriptionResponse;
            Intrinsics.checkNotNullParameter(serviceSubscriptionResponse2, "it");
            return new LoadingState.Loaded(serviceSubscriptionResponse2);
        }
    }

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super ServiceSubscriptionResponse>> {
        public final /* synthetic */ LfPackagesInteractorImpl a;

        public b(LfPackagesInteractorImpl lfPackagesInteractorImpl) {
            this.a = lfPackagesInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super ServiceSubscriptionResponse> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.b.convert(th2));
        }
    }

    public static final class c<T, R> implements Function<SuccessResult, LoadingState<? super SuccessResult>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super SuccessResult> apply(SuccessResult successResult) {
            SuccessResult successResult2 = successResult;
            Intrinsics.checkNotNullParameter(successResult2, "it");
            return new LoadingState.Loaded(successResult2);
        }
    }

    public static final class d<T, R> implements Function<Throwable, LoadingState<? super SuccessResult>> {
        public final /* synthetic */ LfPackagesInteractorImpl a;

        public d(LfPackagesInteractorImpl lfPackagesInteractorImpl) {
            this.a = lfPackagesInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super SuccessResult> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.b.convert(th2));
        }
    }

    @Inject
    public LfPackagesInteractorImpl(@NotNull ServiceSubscriptionApi serviceSubscriptionApi, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(serviceSubscriptionApi, "subscriptionApi");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.a = serviceSubscriptionApi;
        this.b = typedErrorThrowableConverter;
        this.c = schedulersFactory;
    }

    @Override // com.avito.android.service_subscription.ServiceSubscriptionInteractor
    @NotNull
    public Observable<LoadingState<ServiceSubscriptionResponse>> loadServiceSubscription() {
        Observable<LoadingState<ServiceSubscriptionResponse>> onErrorReturn = InteropKt.toV2(this.a.getLfPackages()).subscribeOn(this.c.io()).map(a.a).startWith((Observable) LoadingState.Loading.INSTANCE).onErrorReturn(new b(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "subscriptionApi\n        …onvert(it))\n            }");
        return onErrorReturn;
    }

    @Override // com.avito.android.service_subscription.ServiceSubscriptionInteractor
    @NotNull
    public Observable<LoadingState<SuccessResult>> orderCallback() {
        Observable<LoadingState<SuccessResult>> onErrorReturn = InteropKt.toV2(this.a.orderCallback()).subscribeOn(this.c.io()).map(c.a).onErrorReturn(new d(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "subscriptionApi\n        …onvert(it))\n            }");
        return onErrorReturn;
    }
}
