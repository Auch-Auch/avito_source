package a2.a.a.j.a;

import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.app.task.PendingMessageHandlerImpl;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
public final class a0<T, R> implements Function<Option<? extends LocalMessage>, CompletableSource> {
    public final /* synthetic */ PendingMessageHandlerImpl.b a;

    public a0(PendingMessageHandlerImpl.b bVar) {
        this.a = bVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public CompletableSource apply(Option<? extends LocalMessage> option) {
        Option<? extends LocalMessage> option2 = option;
        Intrinsics.checkNotNullParameter(option2, "messageOption");
        if (option2 instanceof None) {
            return Completable.fromAction(x.a);
        }
        if (option2 instanceof Some) {
            LocalMessage localMessage = (LocalMessage) ((Some) option2).getT();
            return this.a.a.b.state().map(y.a).distinctUntilChanged().switchMapCompletable(new w(localMessage, this)).doOnError(new z(localMessage));
        }
        throw new NoWhenBranchMatchedException();
    }
}
