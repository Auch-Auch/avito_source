package a2.a.a.o1.d.a0.n;

import com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerHistory;
import ru.avito.messenger.api.entity.ChatMessage;
public final class w<T, R> implements Function<Long, ObservableSource<? extends List<? extends ChatMessage>>> {
    public final /* synthetic */ long a;
    public final /* synthetic */ MessageSyncAgentImpl.g b;

    public w(long j, MessageSyncAgentImpl.g gVar) {
        this.a = j;
        this.b = gVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends List<? extends ChatMessage>> apply(Long l) {
        Long l2 = l;
        Intrinsics.checkNotNullParameter(l2, "historyOverlapTime");
        long longValue = (this.a - l2.longValue()) - 1;
        MessageSyncAgentImpl messageSyncAgentImpl = this.b.a;
        MessengerHistory messengerHistory = messageSyncAgentImpl.g;
        String str = this.b.b;
        Observable<R> flatMapObservable = MessengerHistory.DefaultImpls.history$default(messengerHistory, str, null, Long.valueOf(longValue), 100, 2, null).flatMapObservable(new Function<List<? extends ChatMessage>, ObservableSource<? extends List<? extends ChatMessage>>>(messengerHistory, longValue, str) { // from class: com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$syncLatestMessages$2$$special$$inlined$fold$lambda$2$1
            public final /* synthetic */ MessengerHistory b;
            public final /* synthetic */ long c;
            public final /* synthetic */ String d;

            {
                this.b = r2;
                this.c = r3;
                this.d = r5;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public /* bridge */ /* synthetic */ ObservableSource<? extends List<? extends ChatMessage>> apply(List<? extends ChatMessage> list) {
                return apply((List<ChatMessage>) list);
            }

            public final ObservableSource<? extends List<ChatMessage>> apply(@NotNull List<ChatMessage> list) {
                T t;
                Intrinsics.checkNotNullParameter(list, "messages");
                if (list.size() < 100) {
                    return Observable.just(list);
                }
                Iterator<T> it = list.iterator();
                Long l3 = null;
                if (!it.hasNext()) {
                    t = null;
                } else {
                    t = it.next();
                    if (it.hasNext()) {
                        long created = t.getCreated();
                        do {
                            T next = it.next();
                            long created2 = next.getCreated();
                            if (created > created2) {
                                t = next;
                                created = created2;
                            }
                        } while (it.hasNext());
                    }
                }
                T t2 = t;
                if (t2 != null) {
                    l3 = Long.valueOf(t2.getCreated());
                }
                if (l3 == null || l3.longValue() <= this.c) {
                    return Observable.just(list);
                }
                return MessageSyncAgentImpl.c(MessageSyncAgentImpl.this, this.b, this.d, 1 + l3.longValue(), Long.valueOf(this.c), null, null, 24).concatWith(Observable.just(list));
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMapObservable, "history(channelId, after…          }\n            }");
        return flatMapObservable;
    }
}
