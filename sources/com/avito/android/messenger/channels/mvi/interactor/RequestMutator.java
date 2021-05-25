package com.avito.android.messenger.channels.mvi.interactor;

import androidx.annotation.VisibleForTesting;
import arrow.core.Option;
import arrow.core.OptionKt;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsLastMessageProvider;
import com.avito.android.messenger.conversation.mvi.data.MessageRepoReader;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.Observable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\n\u0010\u0013\u001a\u00060\u0007j\u0002`\u0010\u0012\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0006\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R \u0010\u000b\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\u00060\u0007j\u0002`\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/RequestMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsLastMessageProvider$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsLastMessageProvider$State;)Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsLastMessageProvider$State;", "", "", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelId;", "d", "Ljava/util/Set;", "channelIds", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepoReader;", "e", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepoReader;", "messageRepo", "Lcom/avito/android/messenger/channels/mvi/interactor/UserId;", "c", "Ljava/lang/String;", ChannelContext.Item.USER_ID, "<init>", "(Ljava/lang/String;Ljava/util/Set;Lcom/avito/android/messenger/conversation/mvi/data/MessageRepoReader;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@VisibleForTesting(otherwise = 3)
public final class RequestMutator extends Mutator<ChannelsLastMessageProvider.State> {
    public final String c;
    public final Set<String> d;
    public final MessageRepoReader e;

    /* compiled from: java-style lambda group */
    public static final class a<T, R> implements Function<Throwable, Pair<? extends String, ? extends Option<? extends LocalMessage>>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public final Pair<? extends String, ? extends Option<? extends LocalMessage>> apply(Throwable th) {
            int i = this.a;
            if (i == 0) {
                Intrinsics.checkNotNullParameter(th, "it");
                return TuplesKt.to((String) this.b, OptionKt.none());
            } else if (i == 1) {
                Intrinsics.checkNotNullParameter(th, "it");
                return TuplesKt.to((String) this.b, OptionKt.none());
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T, R> implements Function<Option<? extends LocalMessage>, Pair<? extends String, ? extends Option<? extends LocalMessage>>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public b(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public final Pair<? extends String, ? extends Option<? extends LocalMessage>> apply(Option<? extends LocalMessage> option) {
            int i = this.a;
            if (i == 0) {
                Option<? extends LocalMessage> option2 = option;
                Intrinsics.checkNotNullParameter(option2, "messageOption");
                return TuplesKt.to((String) this.b, option2);
            } else if (i == 1) {
                Option<? extends LocalMessage> option3 = option;
                Intrinsics.checkNotNullParameter(option3, "messageOption");
                return TuplesKt.to((String) this.b, option3);
            } else {
                throw null;
            }
        }
    }

    public static final class c<T1, T2> implements BiPredicate<Option<? extends LocalMessage>, Option<? extends LocalMessage>> {
        public final /* synthetic */ RequestMutator a;

        public c(RequestMutator requestMutator) {
            this.a = requestMutator;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.functions.BiPredicate
        public boolean test(Option<? extends LocalMessage> option, Option<? extends LocalMessage> option2) {
            Option<? extends LocalMessage> option3 = option;
            Option<? extends LocalMessage> option4 = option2;
            Intrinsics.checkNotNullParameter(option3, "prev");
            Intrinsics.checkNotNullParameter(option4, "cur");
            if (!option4.isEmpty() || !option3.isEmpty()) {
                if (!option4.isDefined() || !option3.isDefined()) {
                    return false;
                }
                Object orNull = option4.orNull();
                Intrinsics.checkNotNull(orNull);
                LocalMessage localMessage = (LocalMessage) orNull;
                Object orNull2 = option3.orNull();
                Intrinsics.checkNotNull(orNull2);
                LocalMessage localMessage2 = (LocalMessage) orNull2;
                if (!(Intrinsics.areEqual(localMessage, localMessage2) && localMessage.created == localMessage2.created && Intrinsics.areEqual(localMessage.fromId, localMessage2.fromId) && localMessage.getDeliveryStatus() == localMessage2.getDeliveryStatus() && Intrinsics.areEqual(localMessage.body, localMessage2.body) && Intrinsics.areEqual(localMessage.preview, localMessage2.preview) && localMessage.isSupported == localMessage2.isSupported)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static final class d<T1, T2> implements BiPredicate<Option<? extends LocalMessage>, Option<? extends LocalMessage>> {
        public final /* synthetic */ RequestMutator a;

        public d(RequestMutator requestMutator, ChannelsLastMessageProvider.State state) {
            this.a = requestMutator;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.functions.BiPredicate
        public boolean test(Option<? extends LocalMessage> option, Option<? extends LocalMessage> option2) {
            Option<? extends LocalMessage> option3 = option;
            Option<? extends LocalMessage> option4 = option2;
            Intrinsics.checkNotNullParameter(option3, "prev");
            Intrinsics.checkNotNullParameter(option4, "cur");
            if (!option4.isEmpty() || !option3.isEmpty()) {
                if (!option4.isDefined() || !option3.isDefined()) {
                    return false;
                }
                Object orNull = option4.orNull();
                Intrinsics.checkNotNull(orNull);
                LocalMessage localMessage = (LocalMessage) orNull;
                Object orNull2 = option3.orNull();
                Intrinsics.checkNotNull(orNull2);
                LocalMessage localMessage2 = (LocalMessage) orNull2;
                if (!(Intrinsics.areEqual(localMessage, localMessage2) && localMessage.created == localMessage2.created && Intrinsics.areEqual(localMessage.fromId, localMessage2.fromId) && localMessage.getDeliveryStatus() == localMessage2.getDeliveryStatus() && Intrinsics.areEqual(localMessage.body, localMessage2.body) && Intrinsics.areEqual(localMessage.preview, localMessage2.preview) && localMessage.isSupported == localMessage2.isSupported)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static final class e<T, R> implements Function<Object[], Map<String, ? extends Option<? extends LocalMessage>>> {
        public static final e a = new e();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Map<String, ? extends Option<? extends LocalMessage>> apply(Object[] objArr) {
            Object[] objArr2 = objArr;
            Intrinsics.checkNotNullParameter(objArr2, "combinedResult");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : objArr2) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Pair<com.avito.android.messenger.channels.mvi.interactor.ChannelId /* = kotlin.String */, arrow.core.Option<com.avito.android.remote.model.messenger.message.LocalMessage>>");
                Pair pair = (Pair) obj;
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RequestMutator(@NotNull String str, @NotNull Set<String> set, @NotNull MessageRepoReader messageRepoReader) {
        super("RequestMutator(userId = " + str + ", channelIds = " + set + ')');
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(set, "channelIds");
        Intrinsics.checkNotNullParameter(messageRepoReader, "messageRepo");
        this.c = str;
        this.d = set;
        this.e = messageRepoReader;
    }

    public static final boolean access$hasNotChanged(RequestMutator requestMutator, Option option, Option option2) {
        Objects.requireNonNull(requestMutator);
        if (!option.isEmpty() || !option2.isEmpty()) {
            if (!option.isDefined() || !option2.isDefined()) {
                return false;
            }
            Object orNull = option.orNull();
            Intrinsics.checkNotNull(orNull);
            LocalMessage localMessage = (LocalMessage) orNull;
            Object orNull2 = option2.orNull();
            Intrinsics.checkNotNull(orNull2);
            LocalMessage localMessage2 = (LocalMessage) orNull2;
            if (!(Intrinsics.areEqual(localMessage, localMessage2) && localMessage.created == localMessage2.created && Intrinsics.areEqual(localMessage.fromId, localMessage2.fromId) && localMessage.getDeliveryStatus() == localMessage2.getDeliveryStatus() && Intrinsics.areEqual(localMessage.body, localMessage2.body) && Intrinsics.areEqual(localMessage.preview, localMessage2.preview) && localMessage.isSupported == localMessage2.isSupported)) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public ChannelsLastMessageProvider.State invoke(@NotNull ChannelsLastMessageProvider.State state) {
        LinkedHashMap linkedHashMap;
        Intrinsics.checkNotNullParameter(state, "oldState");
        if (!((!Intrinsics.areEqual(this.c, state.getUserId())) || (!Intrinsics.areEqual(this.d, state.getRequestObservables().keySet())))) {
            return state;
        }
        if (!Intrinsics.areEqual(this.c, state.getUserId())) {
            Set<String> set = this.d;
            linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(t6.n.e.collectionSizeOrDefault(set, 10)), 16));
            for (T t : set) {
                T t2 = t;
                linkedHashMap.put(t, this.e.getLastMessage(this.c, t2).distinctUntilChanged(new c(this)).map(new b(0, t2)).startWith((Observable<R>) ((R) TuplesKt.to(t2, OptionKt.none()))).onErrorReturn(new a(0, t2)));
            }
        } else {
            Set<String> set2 = this.d;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(t6.n.e.collectionSizeOrDefault(set2, 10)), 16));
            for (T t3 : set2) {
                T t4 = t3;
                Observable<Pair<String, Option<LocalMessage>>> observable = state.getRequestObservables().get(t4);
                if (observable == null) {
                    observable = this.e.getLastMessage(this.c, t4).distinctUntilChanged(new d(this, state)).map(new b(1, t4)).startWith((Observable<R>) ((R) TuplesKt.to(t4, OptionKt.none()))).onErrorReturn(new a(1, t4));
                }
                linkedHashMap2.put(t3, observable);
            }
            linkedHashMap = linkedHashMap2;
        }
        Observable combineLatest = Observable.combineLatest(linkedHashMap.values(), e.a);
        String str = this.c;
        Intrinsics.checkNotNullExpressionValue(combineLatest, "newChannelsLastMessageStream");
        return new ChannelsLastMessageProvider.State(str, linkedHashMap, combineLatest);
    }

    public static final boolean access$hasNotChanged(RequestMutator requestMutator, LocalMessage localMessage, LocalMessage localMessage2) {
        Objects.requireNonNull(requestMutator);
        return Intrinsics.areEqual(localMessage, localMessage2) && localMessage.created == localMessage2.created && Intrinsics.areEqual(localMessage.fromId, localMessage2.fromId) && localMessage.getDeliveryStatus() == localMessage2.getDeliveryStatus() && Intrinsics.areEqual(localMessage.body, localMessage2.body) && Intrinsics.areEqual(localMessage.preview, localMessage2.preview) && localMessage.isSupported == localMessage2.isSupported;
    }
}
