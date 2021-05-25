package com.avito.android.messenger.search;

import a2.a.a.o1.f.i;
import androidx.annotation.VisibleForTesting;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntityWithMutatorsRelay;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.search.ChannelsSearchInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.avito.android.util.UnauthorizedException;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.avito.messenger.api.entity.ChannelSearchItem;
import ru.avito.messenger.api.entity.ChatMessage;
import ru.avito.messenger.api.entity.event.ChatClearEvent;
import ru.avito.messenger.api.entity.event.ChatEvent;
import ru.avito.messenger.api.entity.event.ReadChatEvent;
import ru.avito.messenger.api.entity.event.ReadMessageEvent;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00041234B?\b\u0001\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010,\u001a\u00020\u0003¢\u0006\u0004\b-\u0010.B<\b\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0011\u0010\u0010\u001a\r\u0012\t\u0012\u00070\r¢\u0006\u0002\b/0\f\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b-\u00100J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\nR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R:\u0010\u001a\u001a&\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u0016 \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u0016\u0018\u00010\u00150\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u00158V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u00065"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchInteractorImpl;", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor;", "Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityWithMutatorsRelay;", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State;", "Lcom/avito/android/messenger/search/SearchQuery;", "query", "", "startSearch", "(Lcom/avito/android/messenger/search/SearchQuery;)V", "requestNextPage", "()V", "onCleared", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "p", "Lru/avito/messenger/MessengerClient;", "client", "Lcom/avito/android/account/AccountStateProvider;", "o", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lio/reactivex/Observable;", "", "kotlin.jvm.PlatformType", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/Observable;", "cancellationStream", "getReconnectsStream", "()Lio/reactivex/Observable;", "reconnectsStream", "Lcom/avito/android/analytics/Analytics;", "r", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lio/reactivex/disposables/CompositeDisposable;", "n", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/messenger/MessengerEntityConverter;", VKApiConst.Q, "Lcom/avito/android/messenger/MessengerEntityConverter;", "entityConverter", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "initialState", "<init>", "(Lcom/avito/android/account/AccountStateProvider;Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/MessengerEntityConverter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State;)V", "Lkotlin/jvm/JvmSuppressWildcards;", "(Lcom/avito/android/account/AccountStateProvider;Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/MessengerEntityConverter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory;)V", "c", "d", "e", "f", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsSearchInteractorImpl extends BaseMviEntityWithMutatorsRelay<ChannelsSearchInteractor.State> implements ChannelsSearchInteractor {
    public final Observable<Long> m;
    public final CompositeDisposable n;
    public final AccountStateProvider o;
    public final MessengerClient<AvitoMessengerApi> p;
    public final MessengerEntityConverter q;
    public final Analytics r;

    public static final class a<T> implements Consumer<String> {
        public final /* synthetic */ ChannelsSearchInteractorImpl a;

        public a(ChannelsSearchInteractorImpl channelsSearchInteractorImpl) {
            this.a = channelsSearchInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.jakewharton.rxrelay2.Relay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            Relay mutatorsRelay = this.a.getMutatorsRelay();
            Intrinsics.checkNotNullExpressionValue(str2, ChannelContext.Item.USER_ID);
            f fVar = new f(str2);
            mutatorsRelay.accept(new MutatorSingle(fVar.getName(), new ChannelsSearchInteractorImpl$1$$special$$inlined$toMutatorSingle$1(fVar)));
        }
    }

    public static final class b<T> implements Consumer<ChatEvent> {
        public final /* synthetic */ ChannelsSearchInteractorImpl a;

        public b(ChannelsSearchInteractorImpl channelsSearchInteractorImpl) {
            this.a = channelsSearchInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.jakewharton.rxrelay2.Relay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(ChatEvent chatEvent) {
            ChatEvent chatEvent2 = chatEvent;
            Relay mutatorsRelay = this.a.getMutatorsRelay();
            Intrinsics.checkNotNullExpressionValue(chatEvent2, "event");
            c cVar = new c(chatEvent2);
            mutatorsRelay.accept(new MutatorSingle(cVar.getName(), new ChannelsSearchInteractorImpl$2$$special$$inlined$toMutatorSingle$1(cVar)));
        }
    }

    public static final class c extends Mutator<ChannelsSearchInteractor.State> {
        public final ChatEvent c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(@NotNull ChatEvent chatEvent) {
            super(null, 1, null);
            Intrinsics.checkNotNullParameter(chatEvent, "event");
            this.c = chatEvent;
        }

        public static final ChannelsSearchInteractor.State.Loaded a(c cVar, ChannelsSearchInteractor.State.Loaded loaded, String str, long j) {
            String str2;
            String str3;
            Channel channel;
            ChannelsSearchInteractor.SearchResults results = loaded.getResults();
            List<ChannelsSearchInteractor.SearchResults.Result> items = loaded.getResults().getItems();
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(items, 10));
            for (T t : items) {
                if (Intrinsics.areEqual(t.getChannel().getChannelId(), cVar.c.getChannelId())) {
                    Channel channel2 = t.getChannel();
                    LocalMessage lastMessage = channel2.getLastMessage();
                    if (lastMessage != null) {
                        str3 = lastMessage.userId;
                        str2 = str;
                    } else {
                        str2 = str;
                        str3 = null;
                    }
                    if (Intrinsics.areEqual(str3, str2)) {
                        LocalMessage lastMessage2 = channel2.getLastMessage();
                        channel = Channel.copy$default(channel2, null, null, lastMessage2 != null ? LocalMessage.copy$default(lastMessage2, null, null, null, null, null, null, 0, true, false, null, null, false, null, 8063, null) : null, null, 0, 0, null, null, false, true, false, false, null, null, null, null, null, null, null, 523771, null);
                    } else {
                        LocalMessage lastMessage3 = channel2.getLastMessage();
                        channel = Channel.copy$default(channel2, null, null, lastMessage3 != null ? LocalMessage.copy$default(lastMessage3, null, null, null, null, null, null, 0, false, false, Long.valueOf(j), null, false, null, 7679, null) : null, null, 0, 0, null, null, false, false, false, false, null, null, null, null, null, null, null, 524283, null);
                    }
                    t = (T) ChannelsSearchInteractor.SearchResults.Result.copy$default(t, channel, null, 2, null);
                }
                arrayList.add(t);
            }
            return ChannelsSearchInteractor.State.Loaded.copy$default(loaded, null, null, ChannelsSearchInteractor.SearchResults.copy$default(results, arrayList, false, 2, null), null, 11, null);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.avito.android.messenger.channels.mvi.common.v2.Mutator
        public ChannelsSearchInteractor.State invoke(ChannelsSearchInteractor.State state) {
            T t;
            ChannelsSearchInteractor.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            if (state2 instanceof ChannelsSearchInteractor.State.Loaded) {
                Iterator<T> it = state2.getResults().getItems().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it.next();
                    if (Intrinsics.areEqual(t.getChannel().getChannelId(), this.c.getChannelId())) {
                        break;
                    }
                }
                if (!(t != null)) {
                    return (ChannelsSearchInteractor.State.Loaded) state2;
                }
                ChannelsSearchInteractor.State.Loaded loaded = (ChannelsSearchInteractor.State.Loaded) state2;
                ChatEvent chatEvent = this.c;
                if (chatEvent instanceof ChatClearEvent) {
                    ChannelsSearchInteractor.SearchResults results = loaded.getResults();
                    List<ChannelsSearchInteractor.SearchResults.Result> items = loaded.getResults().getItems();
                    ArrayList arrayList = new ArrayList();
                    for (T t2 : items) {
                        if (!Intrinsics.areEqual(t2.getChannel().getChannelId(), chatEvent.getChannelId())) {
                            arrayList.add(t2);
                        }
                    }
                    return ChannelsSearchInteractor.State.Loaded.copy$default(loaded, null, null, ChannelsSearchInteractor.SearchResults.copy$default(results, arrayList, false, 2, null), null, 11, null);
                } else if (chatEvent instanceof ReadMessageEvent) {
                    ReadMessageEvent readMessageEvent = (ReadMessageEvent) chatEvent;
                    return a(this, loaded, readMessageEvent.getFromId(), readMessageEvent.getTimeStamp());
                } else if (!(chatEvent instanceof ReadChatEvent)) {
                    return loaded;
                } else {
                    ReadChatEvent readChatEvent = (ReadChatEvent) chatEvent;
                    return a(this, loaded, readChatEvent.getFromId(), readChatEvent.timeStamp);
                }
            } else if ((state2 instanceof ChannelsSearchInteractor.State.Empty) || (state2 instanceof ChannelsSearchInteractor.State.Error)) {
                return state2;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public final class d extends MutatorSingle<ChannelsSearchInteractor.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public d() {
            super("LoadNextPageMutator");
        }

        /* Return type fixed from 'io.reactivex.Single' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle
        public Single<ChannelsSearchInteractor.State> invoke(ChannelsSearchInteractor.State state) {
            ChannelsSearchInteractor.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            if (!(state2 instanceof ChannelsSearchInteractor.State.Loaded) || !state2.getResults().getHasMore()) {
                return Singles.toSingle(state2);
            }
            Single<ChannelsSearchInteractor.State> subscribeOn = ChannelsSearchInteractorImpl.this.p.withMessengerApi().observeOn(ChannelsSearchInteractorImpl.this.getSchedulers().computation()).flatMap(new a2.a.a.o1.f.b(state2)).map(new a2.a.a.o1.f.c(this, state2)).onErrorReturn(new s2(0, state2)).takeUntil(ChannelsSearchInteractorImpl.this.m.firstOrError()).onErrorReturn(new s2(1, state2)).subscribeOn(ChannelsSearchInteractorImpl.this.getSchedulers().computation());
            Intrinsics.checkNotNullExpressionValue(subscribeOn, "client.withMessengerApi(…schedulers.computation())");
            return subscribeOn;
        }
    }

    public final class e extends MutatorSingle<ChannelsSearchInteractor.State> {
        @NotNull
        public final SearchQuery c;
        public final /* synthetic */ ChannelsSearchInteractorImpl d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(@NotNull ChannelsSearchInteractorImpl channelsSearchInteractorImpl, SearchQuery searchQuery) {
            super("StartSearchMutator(" + searchQuery + ')');
            Intrinsics.checkNotNullParameter(searchQuery, "query");
            this.d = channelsSearchInteractorImpl;
            this.c = searchQuery;
        }

        /* Return type fixed from 'io.reactivex.Single' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle
        public Single<ChannelsSearchInteractor.State> invoke(ChannelsSearchInteractor.State state) {
            ChannelsSearchInteractor.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            if (m.isBlank(state2.getCurrentUserId())) {
                return Singles.toSingle(new ChannelsSearchInteractor.State.Error("", this.c, new UnauthorizedException()));
            }
            Single<ChannelsSearchInteractor.State> subscribeOn = this.d.p.withMessengerApi().observeOn(this.d.getSchedulers().computation()).flatMap(new a2.a.a.o1.f.d(this)).map(new a2.a.a.o1.f.e(this, state2)).onErrorReturn(new a2.a.a.o1.f.f(this, state2)).takeUntil(this.d.m.filter(new a2.a.a.o1.f.g(this)).firstOrError()).onErrorReturn(new a2.a.a.o1.f.h(state2)).doOnSubscribe(new i(this)).subscribeOn(this.d.getSchedulers().computation());
            Intrinsics.checkNotNullExpressionValue(subscribeOn, "client.withMessengerApi(…schedulers.computation())");
            return subscribeOn;
        }
    }

    public static final class f extends Mutator<ChannelsSearchInteractor.State> {
        public final String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(@NotNull String str) {
            super(null, 1, null);
            Intrinsics.checkNotNullParameter(str, "newUserId");
            this.c = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.avito.android.messenger.channels.mvi.common.v2.Mutator
        public ChannelsSearchInteractor.State invoke(ChannelsSearchInteractor.State state) {
            ChannelsSearchInteractor.State.Error error;
            ChannelsSearchInteractor.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            if (Intrinsics.areEqual(state2.getCurrentUserId(), this.c)) {
                return state2;
            }
            if (state2 instanceof ChannelsSearchInteractor.State.Empty) {
                return ((ChannelsSearchInteractor.State.Empty) state2).copy(this.c);
            }
            if (state2 instanceof ChannelsSearchInteractor.State.Loaded) {
                if (!m.isBlank(this.c)) {
                    return ChannelsSearchInteractor.State.Loaded.copy$default((ChannelsSearchInteractor.State.Loaded) state2, this.c, null, null, null, 14, null);
                }
                error = new ChannelsSearchInteractor.State.Error("", state2.getQuery(), new UnauthorizedException());
            } else if (!(state2 instanceof ChannelsSearchInteractor.State.Error)) {
                throw new NoWhenBranchMatchedException();
            } else if (!m.isBlank(this.c)) {
                return ChannelsSearchInteractor.State.Error.copy$default((ChannelsSearchInteractor.State.Error) state2, this.c, null, null, 6, null);
            } else {
                error = new ChannelsSearchInteractor.State.Error("", state2.getQuery(), new UnauthorizedException());
            }
            return error;
        }
    }

    public static final class g<T, R> implements Function<e, Long> {
        public static final g a = new g();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Long apply(e eVar) {
            e eVar2 = eVar;
            Intrinsics.checkNotNullParameter(eVar2, "it");
            return Long.valueOf(eVar2.c.getId());
        }
    }

    public static final class h<T, R> implements Function<Boolean, Unit> {
        public static final h a = new h();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Unit apply(Boolean bool) {
            Intrinsics.checkNotNullParameter(bool, "it");
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @VisibleForTesting
    public ChannelsSearchInteractorImpl(@NotNull AccountStateProvider accountStateProvider, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull MessengerEntityConverter messengerEntityConverter, @NotNull Analytics analytics, @NotNull SchedulersFactory schedulersFactory, @NotNull ChannelsSearchInteractor.State state) {
        super("ChannelsSearchInteractor", state, schedulersFactory, null, 8, null);
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(messengerEntityConverter, "entityConverter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(state, "initialState");
        this.o = accountStateProvider;
        this.p = messengerClient;
        this.q = messengerEntityConverter;
        this.r = analytics;
        Observable ofType = getMutatorsRelay().ofType(e.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType, "ofType(R::class.java)");
        this.m = ofType.map(g.a);
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.n = compositeDisposable;
        Disposable subscribe = InteropKt.toV2(accountStateProvider.userId()).observeOn(schedulersFactory.computation()).distinctUntilChanged().subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "accountStateProvider.use…erId).toMutatorSingle() }");
        DisposableKt.addTo(subscribe, compositeDisposable);
        Disposable subscribe2 = messengerClient.observeChatEvents(ChatEvent.class).observeOn(schedulersFactory.computation()).subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "client.observeChatEvents…vent).toMutatorSingle() }");
        DisposableKt.addTo(subscribe2, compositeDisposable);
    }

    public static final ChannelsSearchInteractor.SearchResults.Result access$convert(ChannelsSearchInteractorImpl channelsSearchInteractorImpl, ChannelSearchItem channelSearchItem) {
        Objects.requireNonNull(channelsSearchInteractorImpl);
        MessengerEntityConverter messengerEntityConverter = channelsSearchInteractorImpl.q;
        ru.avito.messenger.api.entity.Channel channel = channelSearchItem.getChannel();
        ChatMessage message = channelSearchItem.getMessage();
        if (message == null) {
            message = channelSearchItem.getChannel().getLastMessage();
        }
        Channel convertChannel = messengerEntityConverter.convertChannel(ru.avito.messenger.api.entity.Channel.copy$default(channel, null, null, message, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 524283, null));
        ChatMessage message2 = channelSearchItem.getMessage();
        return new ChannelsSearchInteractor.SearchResults.Result(convertChannel, message2 != null ? message2.getId() : null);
    }

    @Override // com.avito.android.messenger.search.ChannelsSearchInteractor
    @NotNull
    public Observable<Unit> getReconnectsStream() {
        Observable<R> map = this.p.allReconnects().debounce(500, TimeUnit.MILLISECONDS, getSchedulers().computation()).map(h.a);
        Intrinsics.checkNotNullExpressionValue(map, "client.allReconnects()\n …            .map { Unit }");
        return map;
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntity, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.n.clear();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.search.ChannelsSearchInteractor
    public void requestNextPage() {
        getMutatorsRelay().accept(new d());
    }

    @Override // com.avito.android.messenger.search.ChannelsSearchInteractor
    public void startSearch(@NotNull SearchQuery searchQuery) {
        Intrinsics.checkNotNullParameter(searchQuery, "query");
        getMutatorsRelay().accept(new e(this, searchQuery));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Inject
    public ChannelsSearchInteractorImpl(@NotNull AccountStateProvider accountStateProvider, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull MessengerEntityConverter messengerEntityConverter, @NotNull Analytics analytics, @NotNull SchedulersFactory schedulersFactory) {
        this(accountStateProvider, messengerClient, messengerEntityConverter, analytics, schedulersFactory, new ChannelsSearchInteractor.State.Empty(null, 1, null));
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(messengerEntityConverter, "entityConverter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
    }
}
