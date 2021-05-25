package a2.a.a.a1.c0;

import com.avito.android.home.default_search_location.DefaultSearchLocationPresenterImpl;
import com.avito.android.remote.model.Coordinates;
import io.reactivex.rxjava3.functions.Function;
import org.funktionale.option.Option;
import org.funktionale.option.OptionKt;
public final class h<T, R> implements Function<Coordinates, Option<? extends Boolean>> {
    public final /* synthetic */ DefaultSearchLocationPresenterImpl a;

    public h(DefaultSearchLocationPresenterImpl defaultSearchLocationPresenterImpl) {
        this.a = defaultSearchLocationPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Option<? extends Boolean> apply(Coordinates coordinates) {
        return OptionKt.toOption(Boolean.valueOf(this.a.e));
    }
}
