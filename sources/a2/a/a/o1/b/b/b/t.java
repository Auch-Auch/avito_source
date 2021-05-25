package a2.a.a.o1.b.b.b;

import com.avito.android.messenger.channels.mvi.interactor.FoldersInteractorImpl;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class t<T, R> implements Function<Unit, SingleSource<? extends Map<String, ? extends Integer>>> {
    public final /* synthetic */ FoldersInteractorImpl a;
    public final /* synthetic */ Map b;

    public t(FoldersInteractorImpl foldersInteractorImpl, Map map) {
        this.a = foldersInteractorImpl;
        this.b = map;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends Map<String, ? extends Integer>> apply(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        return this.a.f.getFoldersUnreadCounterByTags(this.b).onErrorReturn(s.a);
    }
}
