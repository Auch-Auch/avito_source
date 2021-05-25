package com.avito.android.short_term_rent.confirm_booking;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.RequestPayUrlResponse;
import com.avito.android.remote.model.StrBookingCalculationReviewResponse;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J;\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0010\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000f0\t0\b2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u0011Jg\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\t0\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000f2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000fH&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingInteractor;", "", "", "checkInDate", "checkOutDate", "", "guestCount", BookingInfoActivity.EXTRA_ITEM_ID, "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/StrBookingCalculationReviewResponse;", "getBookingCalculationReview", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "parametersTree", "", "validateFields", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Lio/reactivex/Observable;", "contactsMap", "guestsCount", "rangeMap", "redirectMap", "Lcom/avito/android/remote/model/RequestPayUrlResponse;", "requestPayUrl", "(Ljava/util/Map;ILjava/lang/String;Ljava/util/Map;Ljava/util/Map;)Lio/reactivex/Observable;", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public interface StrConfirmBookingInteractor {
    @NotNull
    Observable<LoadingState<StrBookingCalculationReviewResponse>> getBookingCalculationReview(@NotNull String str, @NotNull String str2, int i, @NotNull String str3);

    @NotNull
    Observable<LoadingState<RequestPayUrlResponse>> requestPayUrl(@NotNull Map<String, String> map, int i, @NotNull String str, @NotNull Map<String, String> map2, @NotNull Map<String, String> map3);

    @NotNull
    Observable<LoadingState<Map<String, String>>> validateFields(@NotNull ParametersTree parametersTree);
}
