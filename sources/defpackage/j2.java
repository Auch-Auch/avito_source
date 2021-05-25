package defpackage;

import arrow.core.Option;
import com.avito.android.messenger.analytics.ShowFoundMessageEvent;
import com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl;
import com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$syncLatestMessages$2$$special$$inlined$fold$lambda$1$1;
import com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$syncLatestMessages$2$$special$$inlined$fold$lambda$3$1;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.util.rx.arrow.OptionKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.MessengerHistory;
import ru.avito.messenger.api.entity.ChatMessage;
/* compiled from: java-style lambda group */
/* renamed from: j2  reason: default package */
public final class j2<T, R> implements Function<List<? extends ChatMessage>, ObservableSource<? extends List<? extends ChatMessage>>> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public j2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public final ObservableSource<? extends List<? extends ChatMessage>> apply(List<? extends ChatMessage> list) {
        T t;
        int i = this.a;
        String str = "";
        if (i == 0) {
            T t2 = null;
            List<? extends ChatMessage> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "newMessages");
            MessageSyncAgentImpl.g gVar = (MessageSyncAgentImpl.g) this.b;
            if (gVar.c != null) {
                MessageSyncAgentImpl messageSyncAgentImpl = gVar.a;
                MessengerHistory messengerHistory = messageSyncAgentImpl.g;
                MessageSyncAgentImpl.g gVar2 = (MessageSyncAgentImpl.g) this.b;
                String str2 = gVar2.d;
                String str3 = gVar2.b;
                String str4 = gVar2.c;
                String str5 = gVar2.e;
                String str6 = str5 != null ? str5 : str;
                Iterator<T> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    T next = it.next();
                    if (Intrinsics.areEqual(next.getId(), str4)) {
                        t2 = next;
                        break;
                    }
                }
                if (t2 != null) {
                    messageSyncAgentImpl.l.track(new ShowFoundMessageEvent(str3, str4, str6, true, 1));
                    Observable just = Observable.just(list2);
                    Intrinsics.checkNotNullExpressionValue(just, "Observable.just(newMessages)");
                    return just;
                }
                AtomicInteger atomicInteger = new AtomicInteger(1);
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                Observable<Option<LocalMessage>> take = messageSyncAgentImpl.e.getMessageWithRemoteId(str2, str4).subscribeOn(messageSyncAgentImpl.a()).take(1);
                Intrinsics.checkNotNullExpressionValue(take, "repo.getMessageWithRemot…\n                .take(1)");
                Observable<R> startWith = OptionKt.filterEmpty(take).flatMap(new MessageSyncAgentImpl$syncLatestMessages$2$$special$$inlined$fold$lambda$1$1(messageSyncAgentImpl, messengerHistory, str2, str3, list2, atomicInteger, atomicBoolean, str4, str6)).startWith((Observable<R>) list2);
                Intrinsics.checkNotNullExpressionValue(startWith, "repo.getMessageWithRemot…  .startWith(newMessages)");
                return startWith;
            }
            Observable just2 = Observable.just(list2);
            Intrinsics.checkNotNullExpressionValue(just2, "Observable.just(newMessages)");
            return just2;
        } else if (i == 1) {
            List<? extends ChatMessage> list3 = list;
            Intrinsics.checkNotNullParameter(list3, "newMessages");
            MessageSyncAgentImpl.g gVar3 = (MessageSyncAgentImpl.g) this.b;
            if (gVar3.c != null) {
                MessageSyncAgentImpl messageSyncAgentImpl2 = gVar3.a;
                MessengerHistory messengerHistory2 = messageSyncAgentImpl2.g;
                MessageSyncAgentImpl.g gVar4 = (MessageSyncAgentImpl.g) this.b;
                String str7 = gVar4.d;
                String str8 = gVar4.b;
                String str9 = gVar4.c;
                String str10 = gVar4.e;
                if (str10 != null) {
                    str = str10;
                }
                Iterator<T> it2 = list3.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        t = null;
                        break;
                    }
                    T next2 = it2.next();
                    if (Intrinsics.areEqual(next2.getId(), str9)) {
                        t = next2;
                        break;
                    }
                }
                if (t != null) {
                    messageSyncAgentImpl2.l.track(new ShowFoundMessageEvent(str8, str9, str, true, 1));
                    Observable just3 = Observable.just(list3);
                    Intrinsics.checkNotNullExpressionValue(just3, "Observable.just(newMessages)");
                    return just3;
                }
                AtomicInteger atomicInteger2 = new AtomicInteger(1);
                AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
                Observable<Option<LocalMessage>> take2 = messageSyncAgentImpl2.e.getMessageWithRemoteId(str7, str9).subscribeOn(messageSyncAgentImpl2.a()).take(1);
                Intrinsics.checkNotNullExpressionValue(take2, "repo.getMessageWithRemot…\n                .take(1)");
                Observable<R> startWith2 = OptionKt.filterEmpty(take2).flatMap(new MessageSyncAgentImpl$syncLatestMessages$2$$special$$inlined$fold$lambda$3$1(messageSyncAgentImpl2, messengerHistory2, str7, str8, list3, atomicInteger2, atomicBoolean2, str9, str)).startWith((Observable<R>) list3);
                Intrinsics.checkNotNullExpressionValue(startWith2, "repo.getMessageWithRemot…  .startWith(newMessages)");
                return startWith2;
            }
            Observable just4 = Observable.just(list3);
            Intrinsics.checkNotNullExpressionValue(just4, "Observable.just(newMessages)");
            return just4;
        } else {
            throw null;
        }
    }
}
