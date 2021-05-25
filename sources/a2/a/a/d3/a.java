package a2.a.a.d3;

import com.avito.android.remote.model.location_picker.AddressSuggestion;
import com.avito.android.remote.model.location_picker.AddressSuggestionResult;
import com.avito.android.suggest_locations.SuggestLocationsPresenterImpl;
import com.avito.android.suggest_locations.SuggestLocationsView;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
public final class a<T> implements Consumer<AddressSuggestionResult> {
    public final /* synthetic */ SuggestLocationsPresenterImpl a;

    public a(SuggestLocationsPresenterImpl suggestLocationsPresenterImpl) {
        this.a = suggestLocationsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(AddressSuggestionResult addressSuggestionResult) {
        SuggestLocationsView suggestLocationsView;
        SuggestLocationsView suggestLocationsView2;
        AddressSuggestionResult addressSuggestionResult2 = addressSuggestionResult;
        if (addressSuggestionResult2 instanceof AddressSuggestionResult.Ok) {
            List<AddressSuggestion> addressSuggestions = ((AddressSuggestionResult.Ok) addressSuggestionResult2).getAddressSuggestions();
            this.a.h = addressSuggestions;
            SuggestLocationsView suggestLocationsView3 = this.a.a;
            if (suggestLocationsView3 != null) {
                suggestLocationsView3.updateAddresses(addressSuggestions);
            }
            if (addressSuggestions.isEmpty() && (suggestLocationsView2 = this.a.a) != null) {
                suggestLocationsView2.showEmptySuggestsError();
            }
        } else if (addressSuggestionResult2 instanceof AddressSuggestionResult.NetworkError) {
            SuggestLocationsView suggestLocationsView4 = this.a.a;
            if (suggestLocationsView4 != null) {
                suggestLocationsView4.showNetworkError();
            }
        } else if ((addressSuggestionResult2 instanceof AddressSuggestionResult.Error) && (suggestLocationsView = this.a.a) != null) {
            suggestLocationsView.showError();
        }
    }
}
