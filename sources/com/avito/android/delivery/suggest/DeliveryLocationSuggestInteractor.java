package com.avito.android.delivery.suggest;

import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.remote.model.location_picker.AddressSuggestionResult;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestInteractor;", "", "", "query", "Lcom/avito/android/avito_map/AvitoMapBounds;", "visibleRegion", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/location_picker/AddressSuggestionResult;", "searchSuggestions", "(Ljava/lang/String;Lcom/avito/android/avito_map/AvitoMapBounds;)Lio/reactivex/rxjava3/core/Observable;", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryLocationSuggestInteractor {
    @NotNull
    Observable<AddressSuggestionResult> searchSuggestions(@NotNull String str, @NotNull AvitoMapBounds avitoMapBounds);
}
