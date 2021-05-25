package com.avito.android.messenger.conversation.create;

import arrow.core.Option;
import arrow.core.OptionKt;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.messenger.channels.mvi.data.ChannelRepoReader;
import com.avito.android.messenger.channels.mvi.data.DraftRepoWriter;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import com.avito.android.messenger.conversation.ChannelActivityArguments;
import com.avito.android.messenger.conversation.create.CreateChannelInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.User;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.entity.messenger.TerminationEvent;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelInteractorImpl;", "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor;", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "createParams", "Lio/reactivex/Single;", "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result;", "getOrCreateChannel", "(Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;)Lio/reactivex/Single;", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/messenger/channels/mvi/data/DraftRepoWriter;", "e", "Lcom/avito/android/messenger/channels/mvi/data/DraftRepoWriter;", "draftRepoWriter", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;", "d", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;", "channelSyncAgent", "Lcom/avito/android/account/AccountStateProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/messenger/channels/mvi/data/ChannelRepoReader;", "c", "Lcom/avito/android/messenger/channels/mvi/data/ChannelRepoReader;", "channelRepoReader", "<init>", "(Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/channels/mvi/data/ChannelRepoReader;Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;Lcom/avito/android/messenger/channels/mvi/data/DraftRepoWriter;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class CreateChannelInteractorImpl implements CreateChannelInteractor {
    public final AccountStateProvider a;
    public final SchedulersFactory b;
    public final ChannelRepoReader c;
    public final ChannelSyncAgent d;
    public final DraftRepoWriter e;

    public static final class a<T, R> implements Function<String, SingleSource<? extends CreateChannelInteractor.Result>> {
        public final /* synthetic */ CreateChannelInteractorImpl a;
        public final /* synthetic */ ChannelActivityArguments.Create b;

        public a(CreateChannelInteractorImpl createChannelInteractorImpl, ChannelActivityArguments.Create create) {
            this.a = createChannelInteractorImpl;
            this.b = create;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends CreateChannelInteractor.Result> apply(String str) {
            Single<R> single;
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, ChannelContext.Item.USER_ID);
            CreateChannelInteractorImpl createChannelInteractorImpl = this.a;
            ChannelActivityArguments.Create create = this.b;
            if (create instanceof ChannelActivityArguments.Create.ByItem) {
                ChannelActivityArguments.Create.ByItem byItem = (ChannelActivityArguments.Create.ByItem) create;
                Single<R> map = createChannelInteractorImpl.d.createChat(str2, byItem.getItemId(), byItem.getSource()).observeOn(createChannelInteractorImpl.b.computation()).map(CreateChannelInteractorImpl$createChannel$1.INSTANCE);
                Intrinsics.checkNotNullExpressionValue(map, "channelSyncAgent.createC…(channelId)\n            }");
                single = map.map(new CreateChannelInteractorImpl$getOrCreateChannelFromDb$1(createChannelInteractorImpl, str2, create));
                Intrinsics.checkNotNullExpressionValue(single, "createChannel(createPara…lt)\n                    }");
            } else if (create instanceof ChannelActivityArguments.Create.WithAvito) {
                single = createChannelInteractorImpl.d.createAvitoChat(str2, ((ChannelActivityArguments.Create.WithAvito) create).getSource()).observeOn(createChannelInteractorImpl.b.computation()).map(CreateChannelInteractorImpl$createAvitoChannel$1.INSTANCE);
                Intrinsics.checkNotNullExpressionValue(single, "channelSyncAgent.createA…(channelId)\n            }");
            } else {
                throw new NoWhenBranchMatchedException();
            }
            Single<R> onErrorReturn = single.onErrorReturn(new CreateChannelInteractorKt$sam$i$io_reactivex_functions_Function$0(new CreateChannelInteractorImpl$getOrCreateChannelFromDb$2(createChannelInteractorImpl)));
            Intrinsics.checkNotNullExpressionValue(onErrorReturn, "when (createParams) {\n  …eturn(::mapErrorToResult)");
            return onErrorReturn;
        }
    }

    public static final class b<T, R> implements Function<Throwable, CreateChannelInteractor.Result> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public CreateChannelInteractor.Result apply(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "it");
            return CreateChannelInteractor.Result.Error.Auth.INSTANCE;
        }
    }

    @Inject
    public CreateChannelInteractorImpl(@NotNull AccountStateProvider accountStateProvider, @NotNull SchedulersFactory schedulersFactory, @NotNull ChannelRepoReader channelRepoReader, @NotNull ChannelSyncAgent channelSyncAgent, @NotNull DraftRepoWriter draftRepoWriter) {
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(channelRepoReader, "channelRepoReader");
        Intrinsics.checkNotNullParameter(channelSyncAgent, "channelSyncAgent");
        Intrinsics.checkNotNullParameter(draftRepoWriter, "draftRepoWriter");
        this.a = accountStateProvider;
        this.b = schedulersFactory;
        this.c = channelRepoReader;
        this.d = channelSyncAgent;
        this.e = draftRepoWriter;
    }

    public static final Single access$createAvitoChannel(CreateChannelInteractorImpl createChannelInteractorImpl, String str, String str2) {
        Objects.requireNonNull(createChannelInteractorImpl);
        Single<R> map = createChannelInteractorImpl.d.createAvitoChat(str, str2).observeOn(createChannelInteractorImpl.b.computation()).map(CreateChannelInteractorImpl$createAvitoChannel$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "channelSyncAgent.createA…(channelId)\n            }");
        return map;
    }

    public static final Single access$createChannel(CreateChannelInteractorImpl createChannelInteractorImpl, String str, String str2, String str3) {
        Objects.requireNonNull(createChannelInteractorImpl);
        Single<R> map = createChannelInteractorImpl.d.createChat(str3, str, str2).observeOn(createChannelInteractorImpl.b.computation()).map(CreateChannelInteractorImpl$createChannel$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "channelSyncAgent.createC…(channelId)\n            }");
        return map;
    }

    public static final Single access$getOrCreateChannelFromDb(CreateChannelInteractorImpl createChannelInteractorImpl, String str, ChannelActivityArguments.Create create) {
        Single<R> single;
        Objects.requireNonNull(createChannelInteractorImpl);
        if (create instanceof ChannelActivityArguments.Create.ByItem) {
            ChannelActivityArguments.Create.ByItem byItem = (ChannelActivityArguments.Create.ByItem) create;
            Single<R> map = createChannelInteractorImpl.d.createChat(str, byItem.getItemId(), byItem.getSource()).observeOn(createChannelInteractorImpl.b.computation()).map(CreateChannelInteractorImpl$createChannel$1.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(map, "channelSyncAgent.createC…(channelId)\n            }");
            single = map.map(new CreateChannelInteractorImpl$getOrCreateChannelFromDb$1(createChannelInteractorImpl, str, create));
            Intrinsics.checkNotNullExpressionValue(single, "createChannel(createPara…lt)\n                    }");
        } else if (create instanceof ChannelActivityArguments.Create.WithAvito) {
            single = createChannelInteractorImpl.d.createAvitoChat(str, ((ChannelActivityArguments.Create.WithAvito) create).getSource()).observeOn(createChannelInteractorImpl.b.computation()).map(CreateChannelInteractorImpl$createAvitoChannel$1.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(single, "channelSyncAgent.createA…(channelId)\n            }");
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Single onErrorReturn = single.onErrorReturn(new CreateChannelInteractorKt$sam$i$io_reactivex_functions_Function$0(new CreateChannelInteractorImpl$getOrCreateChannelFromDb$2(createChannelInteractorImpl)));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "when (createParams) {\n  …eturn(::mapErrorToResult)");
        return onErrorReturn;
    }

    public static final CreateChannelInteractor.Result.Error access$mapErrorToResult(CreateChannelInteractorImpl createChannelInteractorImpl, Throwable th) {
        Objects.requireNonNull(createChannelInteractorImpl);
        TerminationEvent fromThrowable = TerminationEvent.Companion.fromThrowable(th);
        if (fromThrowable instanceof TerminationEvent.NetworkError) {
            return CreateChannelInteractor.Result.Error.Network.INSTANCE;
        }
        if (fromThrowable instanceof TerminationEvent.UnauthorizedError) {
            return CreateChannelInteractor.Result.Error.Auth.INSTANCE;
        }
        if (fromThrowable instanceof TerminationEvent.ForbiddenError) {
            return CreateChannelInteractor.Result.Error.Forbidden.INSTANCE;
        }
        Integer code = fromThrowable.getCode();
        if (code != null && code.intValue() == -32060) {
            return CreateChannelInteractor.Result.Error.PhoneVerification.INSTANCE;
        }
        return new CreateChannelInteractor.Result.Error.Unknown(th);
    }

    public static final CreateChannelInteractor.Result access$replaceDraftIfNeeded(CreateChannelInteractorImpl createChannelInteractorImpl, String str, String str2, CreateChannelInteractor.Result result) {
        T t;
        Objects.requireNonNull(createChannelInteractorImpl);
        if (str2 != null && (result instanceof CreateChannelInteractor.Result.Success)) {
            CreateChannelInteractor.Result.Success success = (CreateChannelInteractor.Result.Success) result;
            Option<Channel> blockingFirst = createChannelInteractorImpl.c.getChannel(str, success.getChannelId()).blockingFirst();
            Intrinsics.checkNotNullExpressionValue(blockingFirst, "channel");
            Channel channel = (Channel) OptionKt.getOrElse(blockingFirst, CreateChannelInteractorImpl$replaceDraftIfNeeded$users$1.INSTANCE);
            String str3 = null;
            List<User> users = channel != null ? channel.getUsers() : null;
            DraftRepoWriter draftRepoWriter = createChannelInteractorImpl.e;
            String channelId = success.getChannelId();
            if (users != null) {
                Iterator<T> it = users.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it.next();
                    if (!Intrinsics.areEqual(t.getId(), str)) {
                        break;
                    }
                }
                T t2 = t;
                if (t2 != null) {
                    str3 = t2.getId();
                }
            }
            if (str3 == null) {
                str3 = "";
            }
            draftRepoWriter.putDraft(str, channelId, str3, str2).blockingAwait();
        }
        return result;
    }

    @Override // com.avito.android.messenger.conversation.create.CreateChannelInteractor
    @NotNull
    public Single<CreateChannelInteractor.Result> getOrCreateChannel(@NotNull ChannelActivityArguments.Create create) {
        Intrinsics.checkNotNullParameter(create, "createParams");
        Single<CreateChannelInteractor.Result> onErrorReturn = InteropKt.toV2(this.a.currentUserId()).observeOn(this.b.computation()).flatMapSingle(new a(this, create)).onErrorReturn(b.a);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "accountStateProvider.cur…actor.Result.Error.Auth }");
        return onErrorReturn;
    }
}
