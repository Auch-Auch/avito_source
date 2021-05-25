package com.avito.android.delivery.suggest;

import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.location_picker.providers.AddressGeoCoder;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.location_picker.AddressSuggestionResult;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestInteractorImpl;", "Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestInteractor;", "", "query", "Lcom/avito/android/avito_map/AvitoMapBounds;", "visibleRegion", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/location_picker/AddressSuggestionResult;", "searchSuggestions", "(Ljava/lang/String;Lcom/avito/android/avito_map/AvitoMapBounds;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/location_picker/providers/AddressGeoCoder;", AuthSource.SEND_ABUSE, "Lcom/avito/android/location_picker/providers/AddressGeoCoder;", "addressGeoCoder", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/location_picker/providers/AddressGeoCoder;Lcom/avito/android/util/SchedulersFactory3;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryLocationSuggestInteractorImpl implements DeliveryLocationSuggestInteractor {
    public final AddressGeoCoder a;
    public final SchedulersFactory3 b;

    @Inject
    public DeliveryLocationSuggestInteractorImpl(@NotNull AddressGeoCoder addressGeoCoder, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(addressGeoCoder, "addressGeoCoder");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = addressGeoCoder;
        this.b = schedulersFactory3;
    }

    @Override // com.avito.android.delivery.suggest.DeliveryLocationSuggestInteractor
    @NotNull
    public Observable<AddressSuggestionResult> searchSuggestions(@NotNull String str, @NotNull AvitoMapBounds avitoMapBounds) {
        Intrinsics.checkNotNullParameter(str, "query");
        Intrinsics.checkNotNullParameter(avitoMapBounds, "visibleRegion");
        Observable<AddressSuggestionResult> observable = this.a.getSuggestions(str, avitoMapBounds).subscribeOn(this.b.io()).toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "addressGeoCoder.getSugge…          .toObservable()");
        return observable;
    }
}
