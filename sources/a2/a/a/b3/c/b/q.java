package a2.a.a.b3.c.b;

import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.StrSellerCalendarParametersUpdateResponse;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewModelImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Consumer;
public final class q<T> implements Consumer<LoadingState<? super StrSellerCalendarParametersUpdateResponse>> {
    public final /* synthetic */ SellerCalendarParametersViewModelImpl a;

    public q(SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl) {
        this.a = sellerCalendarParametersViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super StrSellerCalendarParametersUpdateResponse> loadingState) {
        LoadingState<? super StrSellerCalendarParametersUpdateResponse> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            this.a.e();
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            this.a.getCloseScreenChanges().setValue(Boolean.TRUE);
        } else if (loadingState2 instanceof LoadingState.Error) {
            TypedError error = ((LoadingState.Error) loadingState2).getError();
            this.a.showContent();
            if (error instanceof ErrorResult.IncorrectData) {
                this.a.C.setErrorsMap(((ErrorResult.IncorrectData) error).getMessages());
            } else {
                this.a.getErrorMessageChanges().postValue(this.a.F.getErrorOccurred());
            }
        }
    }
}
