package com.avito.android.short_term_rent.start_booking;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.StrBookingCalculateDetailsResponse;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.short_term_rent.di.qualifier.Workflow;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ;\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/short_term_rent/start_booking/StrStartBookingInteractorImpl;", "Lcom/avito/android/short_term_rent/start_booking/StrStartBookingInteractor;", "", "checkInDate", "checkOutDate", "", "guestCount", BookingInfoActivity.EXTRA_ITEM_ID, "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/StrBookingCalculateDetailsResponse;", "getBookingCalculateDetails", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "c", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "d", "Ljava/lang/String;", "workflow", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/remote/ShortTermRentApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ShortTermRentApi;", "api", "<init>", "(Lcom/avito/android/remote/ShortTermRentApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Ljava/lang/String;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrStartBookingInteractorImpl implements StrStartBookingInteractor {
    public final ShortTermRentApi a;
    public final SchedulersFactory b;
    public final TypedErrorThrowableConverter c;
    public final String d;

    public static final class a<T, R> implements Function<TypedResult<StrBookingCalculateDetailsResponse>, LoadingState<? super StrBookingCalculateDetailsResponse>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super StrBookingCalculateDetailsResponse> apply(TypedResult<StrBookingCalculateDetailsResponse> typedResult) {
            TypedResult<StrBookingCalculateDetailsResponse> typedResult2 = typedResult;
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

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super StrBookingCalculateDetailsResponse>> {
        public final /* synthetic */ StrStartBookingInteractorImpl a;

        public b(StrStartBookingInteractorImpl strStartBookingInteractorImpl) {
            this.a = strStartBookingInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super StrBookingCalculateDetailsResponse> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.c.convert(th2));
        }
    }

    @Inject
    public StrStartBookingInteractorImpl(@NotNull ShortTermRentApi shortTermRentApi, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @Workflow @Nullable String str) {
        Intrinsics.checkNotNullParameter(shortTermRentApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        this.a = shortTermRentApi;
        this.b = schedulersFactory;
        this.c = typedErrorThrowableConverter;
        this.d = str;
    }

    @Override // com.avito.android.short_term_rent.start_booking.StrStartBookingInteractor
    @NotNull
    public Observable<LoadingState<StrBookingCalculateDetailsResponse>> getBookingCalculateDetails(@NotNull String str, @NotNull String str2, int i, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "checkInDate", str2, "checkOutDate", str3, BookingInfoActivity.EXTRA_ITEM_ID);
        Observable<LoadingState<StrBookingCalculateDetailsResponse>> onErrorReturn = InteropKt.toV2(this.a.getBookingCalculateDetails(str, str2, i, str3, this.d)).subscribeOn(this.b.io()).map(a.a).startWith((Observable) LoadingState.Loading.INSTANCE).onErrorReturn(new b(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.getBookingCalculateD…eConverter.convert(it)) }");
        return onErrorReturn;
    }
}
