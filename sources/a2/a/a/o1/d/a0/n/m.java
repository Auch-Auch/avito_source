package a2.a.a.o1.d.a0.n;

import com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class m<T, R> implements Function<GroupedObservable<String, LocalMessage>, ObservableSource<? extends Unit>> {
    public final /* synthetic */ MessageSyncAgentImpl a;
    public final /* synthetic */ String b;

    public m(MessageSyncAgentImpl messageSyncAgentImpl, String str) {
        this.a = messageSyncAgentImpl;
        this.b = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends Unit> apply(GroupedObservable<String, LocalMessage> groupedObservable) {
        GroupedObservable<String, LocalMessage> groupedObservable2 = groupedObservable;
        Intrinsics.checkNotNullParameter(groupedObservable2, "messagesByChannel");
        GroupedObservable<String, LocalMessage> groupedObservable3 = groupedObservable2;
        if (this.a.n) {
            Observable<LocalMessage> debounce = groupedObservable2.debounce(200, TimeUnit.MILLISECONDS);
            Intrinsics.checkNotNullExpressionValue(debounce, "debounce(MARK_AS_READ_DE…S, TimeUnit.MILLISECONDS)");
            groupedObservable3 = debounce;
        }
        return groupedObservable3.map(new l(this));
    }
}
