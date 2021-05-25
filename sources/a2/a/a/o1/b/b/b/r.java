package a2.a.a.o1.b.b.b;

import com.avito.android.messenger.channels.mvi.interactor.FoldersInteractorImpl;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class r<T> implements Consumer<Boolean> {
    public final /* synthetic */ FoldersInteractorImpl a;

    public r(FoldersInteractorImpl foldersInteractorImpl) {
        this.a = foldersInteractorImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.jakewharton.rxrelay2.Relay */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(Boolean bool) {
        if (!bool.booleanValue()) {
            this.a.c.accept(Unit.INSTANCE);
        }
    }
}
