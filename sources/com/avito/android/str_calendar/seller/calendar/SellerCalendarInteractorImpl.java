package com.avito.android.str_calendar.seller.calendar;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.StrItemBookingSellerCalendarResponse;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.str_calendar.seller.calendar.model.SellerCalendarInfo;
import com.avito.android.str_calendar.seller.calendar.model.SellerCalendarInfoKt;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarInteractorImpl;", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarInteractor;", "", BookingInfoActivity.EXTRA_ITEM_ID, "currentDate", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/str_calendar/seller/calendar/model/SellerCalendarInfo;", "getSellerCalendar", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "c", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/remote/ShortTermRentApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ShortTermRentApi;", "api", "<init>", "(Lcom/avito/android/remote/ShortTermRentApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerCalendarInteractorImpl implements SellerCalendarInteractor {
    public final ShortTermRentApi a;
    public final SchedulersFactory b;
    public final TypedErrorThrowableConverter c;

    public static final class a<T, R> implements Function<TypedResult<StrItemBookingSellerCalendarResponse>, LoadingState<? super SellerCalendarInfo>> {
        public final /* synthetic */ SellerCalendarInteractorImpl a;

        public a(SellerCalendarInteractorImpl sellerCalendarInteractorImpl) {
            this.a = sellerCalendarInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super SellerCalendarInfo> apply(TypedResult<StrItemBookingSellerCalendarResponse> typedResult) {
            TypedResult<StrItemBookingSellerCalendarResponse> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            return SellerCalendarInteractorImpl.access$toLoadingState(this.a, typedResult2);
        }
    }

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super SellerCalendarInfo>> {
        public final /* synthetic */ SellerCalendarInteractorImpl a;

        public b(SellerCalendarInteractorImpl sellerCalendarInteractorImpl) {
            this.a = sellerCalendarInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super SellerCalendarInfo> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.c.convert(th2));
        }
    }

    @Inject
    public SellerCalendarInteractorImpl(@NotNull ShortTermRentApi shortTermRentApi, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter) {
        Intrinsics.checkNotNullParameter(shortTermRentApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        this.a = shortTermRentApi;
        this.b = schedulersFactory;
        this.c = typedErrorThrowableConverter;
    }

    public static final LoadingState access$toLoadingState(SellerCalendarInteractorImpl sellerCalendarInteractorImpl, TypedResult typedResult) {
        Objects.requireNonNull(sellerCalendarInteractorImpl);
        if (typedResult instanceof TypedResult.OfResult) {
            return new LoadingState.Loaded(SellerCalendarInfoKt.convert((StrItemBookingSellerCalendarResponse) ((TypedResult.OfResult) typedResult).getResult()));
        }
        if (typedResult instanceof TypedResult.OfError) {
            return new LoadingState.Error(((TypedResult.OfError) typedResult).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.avito.android.str_calendar.seller.calendar.SellerCalendarInteractor
    @NotNull
    public Observable<LoadingState<SellerCalendarInfo>> getSellerCalendar(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "currentDate");
        Observable<LoadingState<SellerCalendarInfo>> onErrorReturn = InteropKt.toV2(this.a.getSellerCalendar(str, str2)).subscribeOn(this.b.io()).map(new a(this)).startWith((Observable) LoadingState.Loading.INSTANCE).onErrorReturn(new b(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.getSellerCalendar(ad…eConverter.convert(it)) }");
        return onErrorReturn;
    }
}
