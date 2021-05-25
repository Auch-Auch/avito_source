package a2.a.a.j.b;

import androidx.work.ListenableWorker;
import com.avito.android.app.work.SendPendingMessagesWorker;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<Boolean, SingleSource<? extends ListenableWorker.Result>> {
    public final /* synthetic */ SendPendingMessagesWorker.b a;

    public c(SendPendingMessagesWorker.b bVar) {
        this.a = bVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends ListenableWorker.Result> apply(Boolean bool) {
        Boolean bool2 = bool;
        Intrinsics.checkNotNullParameter(bool2, "shouldRun");
        if (bool2.booleanValue()) {
            return this.a.a.getPendingMessageHandler().get().startMessageHandling(this.a.a.getSchedulers().io()).toSingle(b.a);
        }
        return Single.just(ListenableWorker.Result.success());
    }
}
