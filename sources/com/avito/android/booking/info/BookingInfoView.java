package com.avito.android.booking.info;

import com.avito.android.booking.remote.model.BookingInfoActionStyle;
import com.facebook.internal.AnalyticsEvents;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H&¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H&¢\u0006\u0004\b\u000e\u0010\bJ-\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/booking/info/BookingInfoView;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "backClicks", "()Lio/reactivex/rxjava3/core/Observable;", "retryClicks", "showLoading", "()V", "showContent", "", "error", "showError", "(Ljava/lang/String;)V", "notifyDataChanged", "title", "Lcom/avito/android/booking/remote/model/BookingInfoActionStyle;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lkotlin/Function0;", "onClick", "showActionButton", "(Ljava/lang/String;Lcom/avito/android/booking/remote/model/BookingInfoActionStyle;Lkotlin/jvm/functions/Function0;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
public interface BookingInfoView {
    @NotNull
    Observable<Unit> backClicks();

    void notifyDataChanged();

    @NotNull
    Observable<Unit> retryClicks();

    void showActionButton(@NotNull String str, @NotNull BookingInfoActionStyle bookingInfoActionStyle, @NotNull Function0<Unit> function0);

    void showContent();

    void showError(@NotNull String str);

    void showLoading();
}
