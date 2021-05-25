package com.avito.android.booking.info;

import com.avito.android.booking.remote.BookingApi;
import com.avito.android.booking.remote.model.BookingInfoModel;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/booking/info/BookingInfoInteractorImpl;", "Lcom/avito/android/booking/info/BookingInfoInteractor;", "", "itemId", BookingInfoActivity.EXTRA_FROM_BLOCK, "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/booking/remote/model/BookingInfoModel;", "loadBookingInfo", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/booking/remote/BookingApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/booking/remote/BookingApi;", "api", "<init>", "(Lcom/avito/android/booking/remote/BookingApi;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class BookingInfoInteractorImpl implements BookingInfoInteractor {
    public final BookingApi a;

    @Inject
    public BookingInfoInteractorImpl(@NotNull BookingApi bookingApi) {
        Intrinsics.checkNotNullParameter(bookingApi, "api");
        this.a = bookingApi;
    }

    @Override // com.avito.android.booking.info.BookingInfoInteractor
    @NotNull
    public Observable<TypedResult<BookingInfoModel>> loadBookingInfo(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str2, BookingInfoActivity.EXTRA_FROM_BLOCK);
        return this.a.getBookingInfo(str, str2);
    }
}
