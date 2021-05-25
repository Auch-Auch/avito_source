package com.avito.android.user_advert.soa_with_price;

import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\u0006R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR(\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u00100\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/user_advert/soa_with_price/PriceSheetDialogView;", "", "", "message", "", "setMessage", "(Ljava/lang/CharSequence;)V", "text", "setInputText", "Lio/reactivex/Observable;", "", "getPriceChangingEvents", "()Lio/reactivex/Observable;", "priceChangingEvents", "getPriceSubmittedEvents", "priceSubmittedEvents", "Lkotlin/Pair;", "", "getPriceInputFocusChanges", "priceInputFocusChanges", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public interface PriceSheetDialogView {
    @NotNull
    Observable<String> getPriceChangingEvents();

    @NotNull
    Observable<Pair<Boolean, String>> getPriceInputFocusChanges();

    @NotNull
    Observable<Unit> getPriceSubmittedEvents();

    void setInputText(@Nullable CharSequence charSequence);

    void setMessage(@Nullable CharSequence charSequence);
}
