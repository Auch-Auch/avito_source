package a2.a.a.a1.c0;

import com.avito.android.home.default_search_location.DefaultSearchLocationPresenterImpl;
import com.avito.android.remote.model.Coordinates;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class f<T> implements Consumer<Coordinates> {
    public final /* synthetic */ DefaultSearchLocationPresenterImpl a;

    public f(DefaultSearchLocationPresenterImpl defaultSearchLocationPresenterImpl) {
        this.a = defaultSearchLocationPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Coordinates coordinates) {
        Coordinates coordinates2 = coordinates;
        DefaultSearchLocationPresenterImpl defaultSearchLocationPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(coordinates2, "it");
        defaultSearchLocationPresenterImpl.g = DefaultSearchLocationPresenterImpl.access$createLocationWithCoordinates(defaultSearchLocationPresenterImpl, coordinates2);
    }
}
