package a2.a.a.o1.b.b.b;

import com.avito.android.messenger.channels.mvi.interactor.FoldersInteractorImpl;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class q<T> implements Consumer<Unit> {
    public final /* synthetic */ FoldersInteractorImpl a;

    public q(FoldersInteractorImpl foldersInteractorImpl) {
        this.a = foldersInteractorImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.jakewharton.rxrelay2.Relay */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        this.a.c.accept(Unit.INSTANCE);
    }
}
