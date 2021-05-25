package com.avito.android.suggest_locations;

import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.location_picker.AddressSuggestion;
import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/avito/android/suggest_locations/SuggestLocationsPresenter;", "", "Lcom/avito/android/suggest_locations/SuggestLocationsView;", "view", "", "attachView", "(Lcom/avito/android/suggest_locations/SuggestLocationsView;)V", "Lcom/avito/android/suggest_locations/SuggestLocationsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/suggest_locations/SuggestLocationsPresenter$Router;)V", "detachRouter", "()V", "detachView", "", "query", "loadSuggests", "(Ljava/lang/String;)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onBackPressed", "Router", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public interface SuggestLocationsPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/suggest_locations/SuggestLocationsPresenter$Router;", "", "", "finishScreen", "()V", "Lcom/avito/android/remote/model/Location;", "location", "leaveScreenWithLocation", "(Lcom/avito/android/remote/model/Location;)V", "Lcom/avito/android/remote/model/location_picker/AddressSuggestion;", "addressSuggestion", "openLocationPicker", "(Lcom/avito/android/remote/model/location_picker/AddressSuggestion;)V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void finishScreen();

        void leaveScreenWithLocation(@NotNull Location location);

        void openLocationPicker(@NotNull AddressSuggestion addressSuggestion);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull SuggestLocationsView suggestLocationsView);

    void detachRouter();

    void detachView();

    void loadSuggests(@NotNull String str);

    void onBackPressed();

    @NotNull
    Kundle onSaveState();
}
