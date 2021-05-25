package com.avito.android.suggest_locations;

import com.avito.android.remote.model.location_picker.AddressSuggestion;
import com.avito.android.suggest_locations.adapter.SuggestLocationItem;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H&¢\u0006\u0004\b\n\u0010\u0007J\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H&¢\u0006\u0004\b\u0014\u0010\u0013J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H&¢\u0006\u0004\b\u0015\u0010\u0013J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011H&¢\u0006\u0004\b\u0016\u0010\u0013J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H&¢\u0006\u0004\b\u0017\u0010\u0013J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011H&¢\u0006\u0004\b\u0018\u0010\u0013J\u000f\u0010\u0019\u001a\u00020\u0005H&¢\u0006\u0004\b\u0019\u0010\u0010J\u000f\u0010\u001a\u001a\u00020\u0005H&¢\u0006\u0004\b\u001a\u0010\u0010J\u000f\u0010\u001b\u001a\u00020\u0005H&¢\u0006\u0004\b\u001b\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/avito/android/suggest_locations/SuggestLocationsView;", "", "", "Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem;", "locations", "", "updateLocations", "(Ljava/util/List;)V", "Lcom/avito/android/remote/model/location_picker/AddressSuggestion;", "addresses", "updateAddresses", "", "textQuery", "updateTextQuery", "(Ljava/lang/String;)V", "clearLocations", "()V", "Lio/reactivex/rxjava3/core/Observable;", "myLocationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "addressClicks", "errorSnackbarClicks", "searchQueryChanged", "backPressed", "donePressed", "showError", "showNetworkError", "showEmptySuggestsError", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public interface SuggestLocationsView {
    @NotNull
    Observable<AddressSuggestion> addressClicks();

    @NotNull
    Observable<Unit> backPressed();

    void clearLocations();

    @NotNull
    Observable<String> donePressed();

    @NotNull
    Observable<Unit> errorSnackbarClicks();

    @NotNull
    Observable<SuggestLocationItem> myLocationClicks();

    @NotNull
    Observable<String> searchQueryChanged();

    void showEmptySuggestsError();

    void showError();

    void showNetworkError();

    void updateAddresses(@NotNull List<AddressSuggestion> list);

    void updateLocations(@NotNull List<SuggestLocationItem> list);

    void updateTextQuery(@NotNull String str);
}
