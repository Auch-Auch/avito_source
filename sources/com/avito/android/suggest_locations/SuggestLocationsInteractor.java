package com.avito.android.suggest_locations;

import com.avito.android.remote.model.location_picker.AddressSuggestionResult;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/suggest_locations/SuggestLocationsInteractor;", "", "", "query", "locationId", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/suggest_locations/SuggestLocationsResult;", "getLocationSuggestions", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "getLegacyLocationSuggestions", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/location_picker/AddressSuggestionResult;", "getAddressSuggestions", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public interface SuggestLocationsInteractor {
    @NotNull
    Single<AddressSuggestionResult> getAddressSuggestions(@NotNull String str);

    @NotNull
    Single<SuggestLocationsResult> getLegacyLocationSuggestions(@NotNull String str);

    @NotNull
    Single<SuggestLocationsResult> getLocationSuggestions(@NotNull String str, @Nullable String str2);
}
