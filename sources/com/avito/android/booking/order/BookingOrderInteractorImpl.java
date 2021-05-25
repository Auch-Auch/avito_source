package com.avito.android.booking.order;

import com.avito.android.booking.remote.BookingApi;
import com.avito.android.booking.remote.model.BookingOrderCreationResponse;
import com.avito.android.booking.remote.model.BookingOrderResponse;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/booking/order/BookingOrderInteractorImpl;", "Lcom/avito/android/booking/order/BookingOrderInteractor;", "", "itemId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/booking/remote/model/BookingOrderResponse;", "loadBookingOrderData", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "email", "Lcom/avito/android/booking/remote/model/BookingOrderCreationResponse;", "createBookingOrder", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "converter", "Lcom/avito/android/booking/remote/BookingApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/booking/remote/BookingApi;", "api", "<init>", "(Lcom/avito/android/booking/remote/BookingApi;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class BookingOrderInteractorImpl implements BookingOrderInteractor {
    public final BookingApi a;
    public final TypedErrorThrowableConverter b;

    public static final class a<T, R> implements Function<TypedResult<BookingOrderCreationResponse>, LoadingState<? super BookingOrderCreationResponse>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super BookingOrderCreationResponse> apply(TypedResult<BookingOrderCreationResponse> typedResult) {
            TypedResult<BookingOrderCreationResponse> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super BookingOrderCreationResponse>> {
        public final /* synthetic */ BookingOrderInteractorImpl a;

        public b(BookingOrderInteractorImpl bookingOrderInteractorImpl) {
            this.a = bookingOrderInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super BookingOrderCreationResponse> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.b;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    public static final class c<T, R> implements Function<TypedResult<BookingOrderResponse>, LoadingState<? super BookingOrderResponse>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super BookingOrderResponse> apply(TypedResult<BookingOrderResponse> typedResult) {
            TypedResult<BookingOrderResponse> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class d<T, R> implements Function<Throwable, LoadingState<? super BookingOrderResponse>> {
        public final /* synthetic */ BookingOrderInteractorImpl a;

        public d(BookingOrderInteractorImpl bookingOrderInteractorImpl) {
            this.a = bookingOrderInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super BookingOrderResponse> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.b;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public BookingOrderInteractorImpl(@NotNull BookingApi bookingApi, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter) {
        Intrinsics.checkNotNullParameter(bookingApi, "api");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "converter");
        this.a = bookingApi;
        this.b = typedErrorThrowableConverter;
    }

    @Override // com.avito.android.booking.order.BookingOrderInteractor
    @NotNull
    public Observable<LoadingState<BookingOrderCreationResponse>> createBookingOrder(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str2, "email");
        Observable<R> startWithItem = this.a.createBookingOrder(str, r.hashMapOf(new Pair("email", str2))).map(a.a).onErrorReturn(new b(this)).startWithItem((R) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWithItem, "api.createBookingOrder(i…tem(LoadingState.Loading)");
        return startWithItem;
    }

    @Override // com.avito.android.booking.order.BookingOrderInteractor
    @NotNull
    public Observable<LoadingState<BookingOrderResponse>> loadBookingOrderData(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Observable<R> startWithItem = this.a.loadBookingOrderData(str).map(c.a).onErrorReturn(new d(this)).startWithItem((R) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWithItem, "api.loadBookingOrderData…tem(LoadingState.Loading)");
        return startWithItem;
    }
}
