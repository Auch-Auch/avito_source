package com.avito.android.short_term_rent.confirm_booking;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.RequestPayUrlResponse;
import com.avito.android.remote.model.StrBookingCalculationReviewResponse;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.short_term_rent.di.qualifier.Workflow;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.validation.LocalPretendInteractor;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B5\b\u0007\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b,\u0010-J;\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0010\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000f0\t0\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011Jg\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\t0\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000f2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingInteractorImpl;", "Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingInteractor;", "", "checkInDate", "checkOutDate", "", "guestCount", BookingInfoActivity.EXTRA_ITEM_ID, "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/StrBookingCalculationReviewResponse;", "getBookingCalculationReview", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "parametersTree", "", "validateFields", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Lio/reactivex/Observable;", "contactsMap", "guestsCount", "rangeMap", "redirectMap", "Lcom/avito/android/remote/model/RequestPayUrlResponse;", "requestPayUrl", "(Ljava/util/Map;ILjava/lang/String;Ljava/util/Map;Ljava/util/Map;)Lio/reactivex/Observable;", "Lcom/avito/android/validation/LocalPretendInteractor;", "d", "Lcom/avito/android/validation/LocalPretendInteractor;", "localPretendInteractor", "e", "Ljava/lang/String;", "workflow", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "c", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/remote/ShortTermRentApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ShortTermRentApi;", "api", "<init>", "(Lcom/avito/android/remote/ShortTermRentApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/validation/LocalPretendInteractor;Ljava/lang/String;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrConfirmBookingInteractorImpl implements StrConfirmBookingInteractor {
    public final ShortTermRentApi a;
    public final SchedulersFactory b;
    public final TypedErrorThrowableConverter c;
    public final LocalPretendInteractor d;
    public final String e;

    public static final class a<T, R> implements Function<TypedResult<StrBookingCalculationReviewResponse>, LoadingState<? super StrBookingCalculationReviewResponse>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super StrBookingCalculationReviewResponse> apply(TypedResult<StrBookingCalculationReviewResponse> typedResult) {
            TypedResult<StrBookingCalculationReviewResponse> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super StrBookingCalculationReviewResponse>> {
        public final /* synthetic */ StrConfirmBookingInteractorImpl a;

        public b(StrConfirmBookingInteractorImpl strConfirmBookingInteractorImpl) {
            this.a = strConfirmBookingInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super StrBookingCalculationReviewResponse> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.c.convert(th2));
        }
    }

    public static final class c<T, R> implements Function<TypedResult<RequestPayUrlResponse>, LoadingState<? super RequestPayUrlResponse>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super RequestPayUrlResponse> apply(TypedResult<RequestPayUrlResponse> typedResult) {
            TypedResult<RequestPayUrlResponse> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class d<T, R> implements Function<Throwable, LoadingState<? super RequestPayUrlResponse>> {
        public final /* synthetic */ StrConfirmBookingInteractorImpl a;

        public d(StrConfirmBookingInteractorImpl strConfirmBookingInteractorImpl) {
            this.a = strConfirmBookingInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super RequestPayUrlResponse> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.c.convert(th2));
        }
    }

    public static final class e<T, R> implements Function<Throwable, LoadingState<? super Map<String, ? extends String>>> {
        public final /* synthetic */ StrConfirmBookingInteractorImpl a;

        public e(StrConfirmBookingInteractorImpl strConfirmBookingInteractorImpl) {
            this.a = strConfirmBookingInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super Map<String, ? extends String>> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.c.convert(th2));
        }
    }

    @Inject
    public StrConfirmBookingInteractorImpl(@NotNull ShortTermRentApi shortTermRentApi, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull LocalPretendInteractor localPretendInteractor, @Workflow @Nullable String str) {
        Intrinsics.checkNotNullParameter(shortTermRentApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(localPretendInteractor, "localPretendInteractor");
        this.a = shortTermRentApi;
        this.b = schedulersFactory;
        this.c = typedErrorThrowableConverter;
        this.d = localPretendInteractor;
        this.e = str;
    }

    public static final LoadingState.Loaded access$toLoadedObservable(StrConfirmBookingInteractorImpl strConfirmBookingInteractorImpl, Map map) {
        Objects.requireNonNull(strConfirmBookingInteractorImpl);
        return new LoadingState.Loaded(map);
    }

    @Override // com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingInteractor
    @NotNull
    public Observable<LoadingState<StrBookingCalculationReviewResponse>> getBookingCalculationReview(@NotNull String str, @NotNull String str2, int i, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "checkInDate", str2, "checkOutDate", str3, BookingInfoActivity.EXTRA_ITEM_ID);
        Observable<LoadingState<StrBookingCalculationReviewResponse>> onErrorReturn = InteropKt.toV2(this.a.getBookingCalculateReview(str, str2, i, str3, this.e)).subscribeOn(this.b.io()).map(a.a).startWith((Observable) LoadingState.Loading.INSTANCE).onErrorReturn(new b(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.getBookingCalculateR…eConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingInteractor
    @NotNull
    public Observable<LoadingState<RequestPayUrlResponse>> requestPayUrl(@NotNull Map<String, String> map, int i, @NotNull String str, @NotNull Map<String, String> map2, @NotNull Map<String, String> map3) {
        Intrinsics.checkNotNullParameter(map, "contactsMap");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(map2, "rangeMap");
        Intrinsics.checkNotNullParameter(map3, "redirectMap");
        Observable<LoadingState<RequestPayUrlResponse>> startWith = InteropKt.toV2(this.a.requestPayUrl(map, i, str, map2, map3, this.e)).subscribeOn(this.b.io()).map(c.a).onErrorReturn(new d(this)).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "api.requestPayUrl(\n     …ith(LoadingState.Loading)");
        return startWith;
    }

    @Override // com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingInteractor
    @NotNull
    public Observable<LoadingState<Map<String, String>>> validateFields(@NotNull ParametersTree parametersTree) {
        Intrinsics.checkNotNullParameter(parametersTree, "parametersTree");
        Observable map = Observable.just(parametersTree).flatMap(new a2.a.a.v2.a.a(this)).map(a2.a.a.v2.a.b.a).map(new a2.a.a.v2.a.c(this));
        Intrinsics.checkNotNullExpressionValue(map, "Observable.just(paramete…it.toLoadedObservable() }");
        Observable<LoadingState<Map<String, String>>> startWith = map.onErrorReturn(new e(this)).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "localFieldsValidate(para…ith(LoadingState.Loading)");
        return startWith;
    }
}
