package a2.a.a.j.a;

import com.avito.android.app.task.PendingMessageHandlerImpl;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class w<T, R> implements Function<Boolean, CompletableSource> {
    public final /* synthetic */ LocalMessage a;
    public final /* synthetic */ a0 b;

    public w(LocalMessage localMessage, a0 a0Var) {
        this.a = localMessage;
        this.b = a0Var;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public CompletableSource apply(Boolean bool) {
        Boolean bool2 = bool;
        Intrinsics.checkNotNullParameter(bool2, "isConnected");
        if (bool2.booleanValue()) {
            PendingMessageHandlerImpl.b bVar = this.b.a;
            return PendingMessageHandlerImpl.access$trySendingMessage(bVar.a, this.a, bVar.b);
        }
        PendingMessageHandlerImpl.b bVar2 = this.b.a;
        return PendingMessageHandlerImpl.access$markAsFailedWhenExpired(bVar2.a, this.a, bVar2.b);
    }
}
