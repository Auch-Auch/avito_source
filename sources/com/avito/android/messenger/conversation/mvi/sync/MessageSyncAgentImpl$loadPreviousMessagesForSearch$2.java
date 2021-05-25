package com.avito.android.messenger.conversation.mvi.sync;

import arrow.core.Option;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.analytics.ShowFoundMessageEvent;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerHistory;
import ru.avito.messenger.api.entity.ChatMessage;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003 \u0005* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "it", "Lio/reactivex/ObservableSource;", "", "Lru/avito/messenger/api/entity/ChatMessage;", "kotlin.jvm.PlatformType", "apply", "(Lkotlin/Unit;)Lio/reactivex/ObservableSource;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class MessageSyncAgentImpl$loadPreviousMessagesForSearch$2<T, R> implements Function<Unit, ObservableSource<? extends List<? extends ChatMessage>>> {
    public final /* synthetic */ MessageSyncAgentImpl a;
    public final /* synthetic */ MessengerHistory b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ List e;
    public final /* synthetic */ AtomicInteger f;
    public final /* synthetic */ AtomicBoolean g;
    public final /* synthetic */ String h;
    public final /* synthetic */ String i;

    public MessageSyncAgentImpl$loadPreviousMessagesForSearch$2(MessageSyncAgentImpl messageSyncAgentImpl, MessengerHistory messengerHistory, String str, String str2, List list, AtomicInteger atomicInteger, AtomicBoolean atomicBoolean, String str3, String str4) {
        this.a = messageSyncAgentImpl;
        this.b = messengerHistory;
        this.c = str;
        this.d = str2;
        this.e = list;
        this.f = atomicInteger;
        this.g = atomicBoolean;
        this.h = str3;
        this.i = str4;
    }

    public final ObservableSource<? extends List<ChatMessage>> apply(@NotNull Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        return this.a.e.getOldestMessageTimestampInChannel(this.c, this.d).subscribeOn(this.a.a()).observeOn(this.a.j.computation()).flatMapObservable(new Function<Option<? extends Long>, ObservableSource<? extends List<? extends ChatMessage>>>(this) { // from class: com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$loadPreviousMessagesForSearch$2.1
            public final /* synthetic */ MessageSyncAgentImpl$loadPreviousMessagesForSearch$2 a;

            {
                this.a = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public /* bridge */ /* synthetic */ ObservableSource<? extends List<? extends ChatMessage>> apply(Option<? extends Long> option) {
                return apply((Option<Long>) option);
            }

            public final ObservableSource<? extends List<ChatMessage>> apply(@NotNull Option<Long> option) {
                T t;
                Intrinsics.checkNotNullParameter(option, "oldestLocalMessageTimestamp");
                Long orNull = option.orNull();
                if (orNull == null) {
                    Iterator<T> it = this.a.e.iterator();
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
                    orNull = t2 != null ? Long.valueOf(t2.getCreated()) : null;
                }
                if (orNull == null) {
                    return Observable.empty();
                }
                MessageSyncAgentImpl$loadPreviousMessagesForSearch$2 messageSyncAgentImpl$loadPreviousMessagesForSearch$2 = this.a;
                return MessageSyncAgentImpl.c(messageSyncAgentImpl$loadPreviousMessagesForSearch$2.a, messageSyncAgentImpl$loadPreviousMessagesForSearch$2.b, messageSyncAgentImpl$loadPreviousMessagesForSearch$2.d, orNull.longValue() + 1, null, Integer.valueOf(5 - this.a.f.get()), new Function1<List<? extends ChatMessage>, Boolean>(this) { // from class: com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl.loadPreviousMessagesForSearch.2.1.1
                    public final /* synthetic */ AnonymousClass1 a;

                    {
                        this.a = r1;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(List<? extends ChatMessage> list) {
                        return Boolean.valueOf(invoke((List<ChatMessage>) list));
                    }

                    public final boolean invoke(@NotNull List<ChatMessage> list) {
                        T t3;
                        Intrinsics.checkNotNullParameter(list, "messages");
                        this.a.a.f.incrementAndGet();
                        AtomicBoolean atomicBoolean = this.a.a.g;
                        Iterator<T> it2 = list.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                t3 = null;
                                break;
                            }
                            t3 = it2.next();
                            if (Intrinsics.areEqual(t3.getId(), this.a.a.h)) {
                                break;
                            }
                        }
                        atomicBoolean.set(t3 != null);
                        return this.a.a.g.get();
                    }
                }, 4);
            }
        }).doOnComplete(new Action(this) { // from class: com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$loadPreviousMessagesForSearch$2.2
            public final /* synthetic */ MessageSyncAgentImpl$loadPreviousMessagesForSearch$2 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Action
            public final void run() {
                Analytics analytics = this.a.a.l;
                MessageSyncAgentImpl$loadPreviousMessagesForSearch$2 messageSyncAgentImpl$loadPreviousMessagesForSearch$2 = this.a;
                analytics.track(new ShowFoundMessageEvent(messageSyncAgentImpl$loadPreviousMessagesForSearch$2.d, messageSyncAgentImpl$loadPreviousMessagesForSearch$2.h, messageSyncAgentImpl$loadPreviousMessagesForSearch$2.i, messageSyncAgentImpl$loadPreviousMessagesForSearch$2.g.get(), this.a.f.get()));
            }
        });
    }
}
