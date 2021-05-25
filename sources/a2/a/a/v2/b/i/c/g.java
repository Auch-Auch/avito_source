package a2.a.a.v2.b.i.c;

import com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationViewModel;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class g<T> implements Consumer<Throwable> {
    public final /* synthetic */ HotelsLocationViewModel a;

    public g(HotelsLocationViewModel hotelsLocationViewModel) {
        this.a = hotelsLocationViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        this.a.c();
        Logs.error(th);
    }
}
