package a7.a.a.c;

import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
import ru.avito.component.floating_add_advert.FloatingAddAdvertImpl;
public final class a<T> implements Consumer<Unit> {
    public final /* synthetic */ c a;

    public a(c cVar) {
        this.a = cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        FloatingAddAdvertImpl.access$resubscribeToView(this.a.a);
    }
}
