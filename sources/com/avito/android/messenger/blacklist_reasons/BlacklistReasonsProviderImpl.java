package com.avito.android.messenger.blacklist_reasons;

import com.avito.android.messenger.blacklist_reasons.BlacklistReasonsProvider;
import com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntityWithMutatorsRelay;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.util.ThrowablesKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.avito.messenger.api.entity.BlacklistReasons;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\u0013\u0014B$\b\u0007\u0012\u0011\u0010\u000e\u001a\r\u0012\t\u0012\u00070\n¢\u0006\u0002\b\u000b0\t\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR!\u0010\u000e\u001a\r\u0012\t\u0012\u00070\n¢\u0006\u0002\b\u000b0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProviderImpl;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider;", "Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityWithMutatorsRelay;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider$State;", "", "suppressError", "", "loadBlacklistReasons", "(Z)V", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", AuthSource.OPEN_CHANNEL_LIST, "Lru/avito/messenger/MessengerClient;", "client", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lru/avito/messenger/MessengerClient;Lcom/avito/android/util/SchedulersFactory;)V", "LoadBlacklistReasonsMutator", "StartLoadingMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class BlacklistReasonsProviderImpl extends BaseMviEntityWithMutatorsRelay<BlacklistReasonsProvider.State> implements BlacklistReasonsProvider {
    public final MessengerClient<AvitoMessengerApi> m;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProviderImpl$LoadBlacklistReasonsMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider$State;)Lio/reactivex/Single;", "", "c", "Z", "suppressError", "<init>", "(Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProviderImpl;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class LoadBlacklistReasonsMutator extends MutatorSingle<BlacklistReasonsProvider.State> {
        public final boolean c;

        public static final class a<T, R> implements Function<AvitoMessengerApi, SingleSource<? extends BlacklistReasons>> {
            public static final a a = new a();

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public SingleSource<? extends BlacklistReasons> apply(AvitoMessengerApi avitoMessengerApi) {
                AvitoMessengerApi avitoMessengerApi2 = avitoMessengerApi;
                Intrinsics.checkNotNullParameter(avitoMessengerApi2, "api");
                return avitoMessengerApi2.getBlacklistReasons();
            }
        }

        public static final class b<T, R> implements Function<BlacklistReasons, BlacklistReasonsProvider.State> {
            public static final b a = new b();

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public BlacklistReasonsProvider.State apply(BlacklistReasons blacklistReasons) {
                BlacklistReasons blacklistReasons2 = blacklistReasons;
                Intrinsics.checkNotNullParameter(blacklistReasons2, "reasons");
                return new BlacklistReasonsProvider.State.Loaded(blacklistReasons2);
            }
        }

        public static final class c<T, R> implements Function<Throwable, BlacklistReasonsProvider.State> {
            public final /* synthetic */ LoadBlacklistReasonsMutator a;

            public c(LoadBlacklistReasonsMutator loadBlacklistReasonsMutator) {
                this.a = loadBlacklistReasonsMutator;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public BlacklistReasonsProvider.State apply(Throwable th) {
                Throwable th2 = th;
                Intrinsics.checkNotNullParameter(th2, "error");
                if (this.a.c) {
                    return new BlacklistReasonsProvider.State.Empty(null, 1, null);
                }
                return new BlacklistReasonsProvider.State.Empty(ThrowablesKt.toAvitoException(th2));
            }
        }

        public LoadBlacklistReasonsMutator(boolean z) {
            super(null, 1, null);
            this.c = z;
        }

        @NotNull
        public Single<BlacklistReasonsProvider.State> invoke(@NotNull BlacklistReasonsProvider.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if ((state instanceof BlacklistReasonsProvider.State.Empty) || (state instanceof BlacklistReasonsProvider.State.Loaded)) {
                return Singles.toSingle(state);
            }
            if (Intrinsics.areEqual(state, BlacklistReasonsProvider.State.Loading.INSTANCE)) {
                Single<BlacklistReasonsProvider.State> onErrorReturn = BlacklistReasonsProviderImpl.this.m.withMessengerApi().observeOn(BlacklistReasonsProviderImpl.this.getSchedulers().computation()).flatMap(a.a).map(b.a).onErrorReturn(new c(this));
                Intrinsics.checkNotNullExpressionValue(onErrorReturn, "client.withMessengerApi(…                        }");
                return onErrorReturn;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProviderImpl$StartLoadingMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider$State;)Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider$State;", "", "c", "Z", "suppressError", "<init>", "(Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProviderImpl;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class StartLoadingMutator extends Mutator<BlacklistReasonsProvider.State> {
        public final boolean c;

        public StartLoadingMutator(boolean z) {
            super(null, 1, null);
            this.c = z;
        }

        @NotNull
        public BlacklistReasonsProvider.State invoke(@NotNull BlacklistReasonsProvider.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state instanceof BlacklistReasonsProvider.State.Empty) {
                BlacklistReasonsProviderImpl.this.getMutatorsRelay().accept(new LoadBlacklistReasonsMutator(this.c));
                return BlacklistReasonsProvider.State.Loading.INSTANCE;
            } else if (Intrinsics.areEqual(state, BlacklistReasonsProvider.State.Loading.INSTANCE) || (state instanceof BlacklistReasonsProvider.State.Loaded)) {
                return state;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public BlacklistReasonsProviderImpl(@NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull SchedulersFactory schedulersFactory) {
        super("BlacklistReasonsProvider", new BlacklistReasonsProvider.State.Empty(null, 1, null), schedulersFactory, null, 8, null);
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.m = messengerClient;
    }

    @Override // com.avito.android.messenger.blacklist_reasons.BlacklistReasonsProvider
    public void loadBlacklistReasons(boolean z) {
        Relay mutatorsRelay = getMutatorsRelay();
        StartLoadingMutator startLoadingMutator = new StartLoadingMutator(z);
        mutatorsRelay.accept(new MutatorSingle(startLoadingMutator.getName(), new BlacklistReasonsProviderImpl$loadBlacklistReasons$$inlined$plusAssign$1(startLoadingMutator)));
    }
}
