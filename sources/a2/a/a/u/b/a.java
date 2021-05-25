package a2.a.a.u.b;

import com.avito.android.booking.order.BookingOrderScreenState;
import com.avito.android.booking.order.BookingOrderViewModelImpl;
import com.avito.android.booking.remote.model.BookingOrderCreationResponse;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Objects;
public final class a<T> implements Consumer<LoadingState<? super BookingOrderCreationResponse>> {
    public final /* synthetic */ BookingOrderViewModelImpl a;

    public a(BookingOrderViewModelImpl bookingOrderViewModelImpl) {
        this.a = bookingOrderViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super BookingOrderCreationResponse> loadingState) {
        LoadingState<? super BookingOrderCreationResponse> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            BookingOrderViewModelImpl.access$navigateToPayment(this.a, ((BookingOrderCreationResponse) ((LoadingState.Loaded) loadingState2).getData()).getDeepLink());
        } else if (loadingState2 instanceof LoadingState.Error) {
            LoadingState.Error error = (LoadingState.Error) loadingState2;
            if (error.getError() instanceof ErrorWithMessage) {
                TypedError error2 = error.getError();
                Objects.requireNonNull(error2, "null cannot be cast to non-null type com.avito.android.remote.error.ErrorWithMessage");
                this.a.c.postValue(new BookingOrderScreenState.Message(((ErrorWithMessage) error2).getMessage()));
            }
        } else if (loadingState2 instanceof LoadingState.Loading) {
            this.a.c.postValue(BookingOrderScreenState.Loading.INSTANCE);
        }
    }
}
