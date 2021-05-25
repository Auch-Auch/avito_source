package com.avito.android.booking.order;

import com.avito.android.booking.order.BookingOrderScreenState;
import com.avito.android.booking.remote.model.BookingInput;
import com.avito.android.booking.remote.model.BookingOrderInfo;
import com.avito.android.booking.remote.model.BookingOrderResponse;
import com.avito.android.lib.design.input.Input;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/avito/android/booking/order/BookingOrderPresenterImpl;", "Lcom/avito/android/booking/order/BookingOrderPresenter;", "Lcom/avito/android/booking/order/BookingOrderView;", "view", "", "bindView", "(Lcom/avito/android/booking/order/BookingOrderView;)V", "Lcom/avito/android/booking/order/BookingOrderScreenState;", "state", "resolveScreenState", "(Lcom/avito/android/booking/order/BookingOrderScreenState;)V", "unbindView", "()V", "Lcom/avito/android/booking/order/BookingOrderResourceProvider;", "c", "Lcom/avito/android/booking/order/BookingOrderResourceProvider;", "resourceProvider", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "inputDescriptionMessage", AuthSource.SEND_ABUSE, "Lcom/avito/android/booking/order/BookingOrderView;", "<init>", "(Lcom/avito/android/booking/order/BookingOrderResourceProvider;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class BookingOrderPresenterImpl implements BookingOrderPresenter {
    public BookingOrderView a;
    public String b;
    public final BookingOrderResourceProvider c;

    @Inject
    public BookingOrderPresenterImpl(@NotNull BookingOrderResourceProvider bookingOrderResourceProvider) {
        Intrinsics.checkNotNullParameter(bookingOrderResourceProvider, "resourceProvider");
        this.c = bookingOrderResourceProvider;
    }

    @Override // com.avito.android.booking.order.BookingOrderPresenter
    public void bindView(@NotNull BookingOrderView bookingOrderView) {
        Intrinsics.checkNotNullParameter(bookingOrderView, "view");
        this.a = bookingOrderView;
    }

    @Override // com.avito.android.booking.order.BookingOrderPresenter
    public void resolveScreenState(@NotNull BookingOrderScreenState bookingOrderScreenState) {
        Intrinsics.checkNotNullParameter(bookingOrderScreenState, "state");
        BookingOrderView bookingOrderView = this.a;
        if (bookingOrderView != null) {
            bookingOrderView.setVisible(true);
            if (bookingOrderScreenState instanceof BookingOrderScreenState.OrderInfoLoaded) {
                bookingOrderView.showContent();
                BookingOrderResponse data = ((BookingOrderScreenState.OrderInfoLoaded) bookingOrderScreenState).getData();
                BookingOrderView bookingOrderView2 = this.a;
                if (bookingOrderView2 != null) {
                    bookingOrderView2.setScreenTitle(data.getTitle());
                    BookingInput input = data.getInput();
                    this.b = input.getDescription();
                    bookingOrderView2.setInputParams(input.getTitle(), input.getText(), input.getPlaceholder(), input.getDescription());
                    BookingOrderInfo orderInfo = data.getOrderInfo();
                    bookingOrderView2.setBookingInfo(orderInfo.getTitle(), orderInfo.getDescription());
                    bookingOrderView2.setButtonText(data.getButtonTitle());
                }
            } else if (bookingOrderScreenState instanceof BookingOrderScreenState.Loading) {
                bookingOrderView.showProgress();
            } else if (bookingOrderScreenState instanceof BookingOrderScreenState.Content) {
                bookingOrderView.showContent();
            } else if (bookingOrderScreenState instanceof BookingOrderScreenState.LoadingError) {
                bookingOrderView.showError(((BookingOrderScreenState.LoadingError) bookingOrderScreenState).getErrorMessage());
            } else if (bookingOrderScreenState instanceof BookingOrderScreenState.Message) {
                bookingOrderView.showContent();
                bookingOrderView.showMessage(((BookingOrderScreenState.Message) bookingOrderScreenState).getMessage());
            } else if (bookingOrderScreenState instanceof BookingOrderScreenState.InputError) {
                bookingOrderView.showContent();
                bookingOrderView.setInputState(Input.Companion.getSTATE_ERROR(), ((BookingOrderScreenState.InputError) bookingOrderScreenState).getErrorMessage(), Integer.valueOf(this.c.inputDescriptionErrorTextColor()));
            } else if (bookingOrderScreenState instanceof BookingOrderScreenState.InputNormal) {
                bookingOrderView.showContent();
                bookingOrderView.setInputState(Input.Companion.getSTATE_NORMAL(), this.b, Integer.valueOf(this.c.inputDescriptionNormalTextColor()));
            }
        }
    }

    @Override // com.avito.android.booking.order.BookingOrderPresenter
    public void unbindView() {
        this.a = null;
    }
}
