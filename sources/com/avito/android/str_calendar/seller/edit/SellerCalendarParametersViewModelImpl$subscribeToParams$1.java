package com.avito.android.str_calendar.seller.edit;

import com.avito.android.remote.model.StrSellerCalendarParameters;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/StrSellerCalendarParameters;", "kotlin.jvm.PlatformType", "it", "", "accept", "(Lcom/avito/android/util/LoadingState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class SellerCalendarParametersViewModelImpl$subscribeToParams$1<T> implements Consumer<LoadingState<? super StrSellerCalendarParameters>> {
    public final /* synthetic */ SellerCalendarParametersViewModelImpl a;

    public SellerCalendarParametersViewModelImpl$subscribeToParams$1(SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl) {
        this.a = sellerCalendarParametersViewModelImpl;
    }

    public final void accept(LoadingState<? super StrSellerCalendarParameters> loadingState) {
        if (loadingState instanceof LoadingState.Loaded) {
            SellerCalendarParametersViewModelImpl.access$onParametersLoaded(this.a, (StrSellerCalendarParameters) ((LoadingState.Loaded) loadingState).getData());
        } else if (loadingState instanceof LoadingState.Loading) {
            this.a.e();
        } else if (loadingState instanceof LoadingState.Error) {
            SellerCalendarParametersViewModelImpl.access$showFullScreenError(this.a, new Runnable(this) { // from class: com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewModelImpl$subscribeToParams$1.1
                public final /* synthetic */ SellerCalendarParametersViewModelImpl$subscribeToParams$1 a;

                {
                    this.a = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a.c();
                }
            });
        }
    }
}
