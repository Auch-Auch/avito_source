package a7.a.b.a.o;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import ru.avito.messenger.internal.log.Logger;
public final class a<T> implements Consumer<Disposable> {
    public final /* synthetic */ b a;
    public final /* synthetic */ Object b;

    public a(b bVar, Object obj) {
        this.a = bVar;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Disposable disposable) {
        Logger logger = this.a.a.a.c;
        String str = this.a.a.a.f;
        StringBuilder L = a2.b.a.a.a.L("Started executing: ");
        L.append(this.a.b.getClass().getSimpleName());
        L.append('(');
        Logger.DefaultImpls.d$default(logger, str, a2.b.a.a.a.q(L, this.b, ')'), null, 4, null);
    }
}
