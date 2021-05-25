package a2.a.a.a1;

import com.avito.android.home.HomePresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import org.funktionale.option.Option;
public final class j<T> implements Consumer<Option<? extends Throwable>> {
    public final /* synthetic */ HomePresenterImpl.g a;

    public j(HomePresenterImpl.g gVar) {
        this.a = gVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Option<? extends Throwable> option) {
        HomePresenterImpl.access$loadLocationError(this.a.a, (Throwable) option.orNull());
    }
}
