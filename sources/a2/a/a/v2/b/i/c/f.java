package a2.a.a.v2.b.i.c;

import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.hotels.HotelsSuggestResult;
import com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationViewModel;
import com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationViewModelKt;
import io.reactivex.rxjava3.functions.Consumer;
public final class f<T> implements Consumer<TypedResult<HotelsSuggestResult>> {
    public final /* synthetic */ HotelsLocationViewModel a;

    public f(HotelsLocationViewModel hotelsLocationViewModel) {
        this.a = hotelsLocationViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(TypedResult<HotelsSuggestResult> typedResult) {
        TypedResult<HotelsSuggestResult> typedResult2 = typedResult;
        if (typedResult2 instanceof TypedResult.OfResult) {
            this.a.getSuggestListChanges().setValue(HotelsLocationViewModelKt.access$toDialogItems(((HotelsSuggestResult) ((TypedResult.OfResult) typedResult2).getResult()).getLocation()));
        } else if (typedResult2 instanceof TypedResult.OfError) {
            this.a.c();
        }
    }
}
