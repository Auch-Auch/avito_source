package a2.a.a.a1.c0;

import com.avito.android.home.default_search_location.DefaultSearchLocationPresenterImpl;
import com.avito.android.location.SavedLocationInteractor;
import io.reactivex.rxjava3.functions.Consumer;
import org.funktionale.option.Option;
public final class i<T> implements Consumer<Option<? extends Boolean>> {
    public final /* synthetic */ DefaultSearchLocationPresenterImpl a;

    public i(DefaultSearchLocationPresenterImpl defaultSearchLocationPresenterImpl) {
        this.a = defaultSearchLocationPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Option<? extends Boolean> option) {
        if (!(this.a.f)) {
            SavedLocationInteractor.DefaultImpls.saveLocation$default(this.a.m, this.a.g, null, false, 6, null);
            this.a.f = true;
            this.a.o.setIsChangeCoordinates();
        }
    }
}
