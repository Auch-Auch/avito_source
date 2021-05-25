package com.avito.android.advert_core.short_term_rent;

import com.avito.android.di.module.AdvertId;
import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.AdvertStrSwitchResponse;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\b\u0007\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockInteractorImpl;", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockInteractor;", "", "isEnabled", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/AdvertStrSwitchResponse;", "toggleOnlineBooking", "(Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/ShortTermRentApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/ShortTermRentApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "itemId", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "d", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/ShortTermRentApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertStrBlockInteractorImpl implements AdvertStrBlockInteractor {
    public final String a;
    public final ShortTermRentApi b;
    public final SchedulersFactory3 c;
    public final TypedErrorThrowableConverter d;

    public static final class a<T, R> implements Function<TypedResult<AdvertStrSwitchResponse>, LoadingState<? super AdvertStrSwitchResponse>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super AdvertStrSwitchResponse> apply(TypedResult<AdvertStrSwitchResponse> typedResult) {
            TypedResult<AdvertStrSwitchResponse> typedResult2 = typedResult;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super AdvertStrSwitchResponse>> {
        public final /* synthetic */ AdvertStrBlockInteractorImpl a;

        public b(AdvertStrBlockInteractorImpl advertStrBlockInteractorImpl) {
            this.a = advertStrBlockInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super AdvertStrSwitchResponse> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.d;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public AdvertStrBlockInteractorImpl(@AdvertId @NotNull String str, @NotNull ShortTermRentApi shortTermRentApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(shortTermRentApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        this.a = str;
        this.b = shortTermRentApi;
        this.c = schedulersFactory3;
        this.d = typedErrorThrowableConverter;
    }

    @Override // com.avito.android.advert_core.short_term_rent.AdvertStrBlockInteractor
    @NotNull
    public Observable<LoadingState<AdvertStrSwitchResponse>> toggleOnlineBooking(boolean z) {
        return a2.b.a.a.a.a2(this.c, this.b.onlineBookingToggle(z, this.a).map(a.a).onErrorReturn(new b(this)).startWith(Observable.just(LoadingState.Loading.INSTANCE)), "api.onlineBookingToggle(…scribeOn(schedulers.io())");
    }
}
