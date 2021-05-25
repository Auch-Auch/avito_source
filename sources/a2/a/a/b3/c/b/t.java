package a2.a.a.b3.c.b;

import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewModelImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Consumer;
import java.util.Map;
public final class t<T> implements Consumer<LoadingState<? super Map<String, ? extends String>>> {
    public final /* synthetic */ SellerCalendarParametersViewModelImpl a;

    public t(SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl) {
        this.a = sellerCalendarParametersViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super Map<String, ? extends String>> loadingState) {
        LoadingState<? super Map<String, ? extends String>> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            SellerCalendarParametersViewModelImpl.access$onValidateInfoLoaded(this.a, (Map) ((LoadingState.Loaded) loadingState2).getData());
        } else if (loadingState2 instanceof LoadingState.Error) {
            this.a.getErrorMessageChanges().setValue(this.a.F.getErrorOccurred());
        }
    }
}
