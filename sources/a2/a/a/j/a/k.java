package a2.a.a.j.a;

import a2.b.a.a.a;
import com.avito.android.app.task.NoRetryException;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.entity.ChatMessage;
import ru.ok.android.sdk.OkListener;
public final class k<T, R> implements Function<Throwable, SingleSource<? extends ChatMessage>> {
    public final /* synthetic */ LocalMessage a;

    public k(LocalMessage localMessage) {
        this.a = localMessage;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends ChatMessage> apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, OkListener.KEY_EXCEPTION);
        StringBuilder Q = a.Q("File message upload failed ", "userId=");
        Q.append(this.a.userId);
        Q.append(" localId=");
        Q.append(this.a.localId);
        Q.append(" channelId=");
        Q.append(this.a.channelId);
        return Single.error(new NoRetryException(Q.toString(), th2));
    }
}
