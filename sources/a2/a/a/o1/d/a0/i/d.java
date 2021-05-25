package a2.a.a.o1.d.a0.i;

import com.avito.android.messenger.conversation.mvi.messages.LoadFirstPageMutator;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class d<T, R> implements Function<Throwable, CompletableSource> {
    public final /* synthetic */ LoadFirstPageMutator.a a;

    public d(LoadFirstPageMutator.a aVar) {
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public CompletableSource apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "error");
        if (LoadFirstPageMutator.access$getMessageId$p(this.a.a) == null) {
            return Completable.fromCallable(new c(this));
        }
        return Completable.error(th2);
    }
}
