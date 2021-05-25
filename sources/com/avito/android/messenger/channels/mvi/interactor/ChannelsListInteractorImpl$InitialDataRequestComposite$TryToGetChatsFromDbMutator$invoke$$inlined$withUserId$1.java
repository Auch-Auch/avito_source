package com.avito.android.messenger.channels.mvi.interactor;

import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.messenger.analytics.OpenChatListEvent;
import com.avito.android.messenger.analytics.graphite_counter.ChatListLoadingResult;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.util.Singles;
import com.avito.android.util.UnauthorizedException;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxkotlin.SinglesKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.DraftEntity;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a*\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00018\u00008\u0000 \u0005*\u0014\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"R", "Larrow/core/Option;", "", "userIdOption", "Lio/reactivex/SingleSource;", "kotlin.jvm.PlatformType", "apply", "(Larrow/core/Option;)Lio/reactivex/SingleSource;", "com/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$withUserId$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelsListInteractorImpl$InitialDataRequestComposite$TryToGetChatsFromDbMutator$invoke$$inlined$withUserId$1<T, R> implements Function<Option<? extends String>, SingleSource<? extends R>> {
    public final /* synthetic */ ChannelsListInteractorImpl.InitialDataRequestComposite.TryToGetChatsFromDbMutator a;
    public final /* synthetic */ ChannelsListInteractor.State b;

    public static final class a<T, R> implements Function<Pair<? extends Notification<Pair<? extends List<? extends Pair<? extends Channel, ? extends DraftEntity>>, ? extends Long>>, ? extends Notification<Pair<? extends List<? extends Pair<? extends Channel, ? extends DraftEntity>>, ? extends Long>>>, ChannelsListInteractor.State> {
        public final /* synthetic */ String a;
        public final /* synthetic */ ChannelsListInteractorImpl$InitialDataRequestComposite$TryToGetChatsFromDbMutator$invoke$$inlined$withUserId$1 b;

        public a(String str, ChannelsListInteractorImpl$InitialDataRequestComposite$TryToGetChatsFromDbMutator$invoke$$inlined$withUserId$1 channelsListInteractorImpl$InitialDataRequestComposite$TryToGetChatsFromDbMutator$invoke$$inlined$withUserId$1) {
            this.a = str;
            this.b = channelsListInteractorImpl$InitialDataRequestComposite$TryToGetChatsFromDbMutator$invoke$$inlined$withUserId$1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.avito.android.analytics.timer.AnalyticsTimer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public ChannelsListInteractor.State apply(Pair<? extends Notification<Pair<? extends List<? extends Pair<? extends Channel, ? extends DraftEntity>>, ? extends Long>>, ? extends Notification<Pair<? extends List<? extends Pair<? extends Channel, ? extends DraftEntity>>, ? extends Long>>> pair) {
            Pair<? extends Notification<Pair<? extends List<? extends Pair<? extends Channel, ? extends DraftEntity>>, ? extends Long>>, ? extends Notification<Pair<? extends List<? extends Pair<? extends Channel, ? extends DraftEntity>>, ? extends Long>>> pair2 = pair;
            Intrinsics.checkNotNullParameter(pair2, "<name for destructuring parameter 0>");
            Notification notification = (Notification) pair2.component1();
            Notification notification2 = (Notification) pair2.component2();
            if (!notification.isOnError() || !notification2.isOnError()) {
                Pair pair3 = (Pair) notification.getValue();
                if (pair3 == null) {
                    pair3 = TuplesKt.to(null, null);
                }
                List<Pair<Channel, DraftEntity>> list = (List) pair3.component1();
                Long l = (Long) pair3.component2();
                Pair pair4 = (Pair) notification2.getValue();
                if (pair4 == null) {
                    pair4 = TuplesKt.to(null, null);
                }
                List<Pair<Channel, DraftEntity>> list2 = (List) pair4.component1();
                Long l2 = (Long) pair4.component2();
                if (list == null && list2 == null) {
                    return this.b.b;
                }
                ChannelsListInteractor.State state = this.b.b;
                String str = this.a;
                ChannelsListInteractor.State.Loading.Finished finished = ChannelsListInteractor.State.Loading.Finished.INSTANCE;
                if (list == null) {
                    list = state.getMainChannelsAndDrafts();
                }
                if (l == null) {
                    l = this.b.b.getMainListBottomTimestamp();
                }
                if (list2 == null) {
                    list2 = this.b.b.getPinnedChannelsAndDrafts();
                }
                if (l2 == null) {
                    l2 = this.b.b.getPinnedListBottomTimestamp();
                }
                ChannelsListInteractor.State copy$default = ChannelsListInteractor.State.copy$default(state, str, finished, null, null, list, l, false, list2, l2, null, false, 1612, null);
                ChannelsListInteractorImpl.this.D.trackChannelsLoad();
                ChannelsListInteractorImpl.this.A.trackEnd(ChatListLoadingResult.SUCCESS);
                ChannelsListInteractorImpl.this.E.track(new OpenChatListEvent(copy$default.getPinnedChannelsAndDrafts().size() + copy$default.getMainChannelsAndDrafts().size()));
                return copy$default;
            }
            Throwable error = notification.getError();
            if (error == null) {
                error = notification2.getError();
            }
            if (error == null) {
                error = new UnknownError();
            }
            ChannelsListInteractorImpl$InitialDataRequestComposite$TryToGetChatsFromDbMutator$invoke$$inlined$withUserId$1 channelsListInteractorImpl$InitialDataRequestComposite$TryToGetChatsFromDbMutator$invoke$$inlined$withUserId$1 = this.b;
            return ChannelsListInteractorImpl.InitialDataRequestComposite.TryToGetChatsFromDbMutator.access$handleError(channelsListInteractorImpl$InitialDataRequestComposite$TryToGetChatsFromDbMutator$invoke$$inlined$withUserId$1.a, error, channelsListInteractorImpl$InitialDataRequestComposite$TryToGetChatsFromDbMutator$invoke$$inlined$withUserId$1.b);
        }
    }

    public ChannelsListInteractorImpl$InitialDataRequestComposite$TryToGetChatsFromDbMutator$invoke$$inlined$withUserId$1(ChannelsListInteractorImpl.InitialDataRequestComposite.TryToGetChatsFromDbMutator tryToGetChatsFromDbMutator, ChannelsListInteractor.State state) {
        this.a = tryToGetChatsFromDbMutator;
        this.b = state;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Object apply(Option<? extends String> option) {
        return apply((Option<String>) option);
    }

    public final SingleSource<? extends R> apply(@NotNull Option<String> option) {
        Single single;
        Single single2;
        Intrinsics.checkNotNullParameter(option, "userIdOption");
        if (option instanceof None) {
            throw new UnauthorizedException();
        } else if (option instanceof Some) {
            String str = (String) ((Some) option).getT();
            ChannelsListInteractorImpl.InitialDataRequestComposite.TryToGetChatsFromDbMutator tryToGetChatsFromDbMutator = this.a;
            if (ChannelsListInteractorImpl.this.u.getMessengerPinSupportChat().invoke().booleanValue()) {
                Single access$getChatsFromDbForSpecificList = ChannelsListInteractorImpl.InitialDataRequestComposite.TryToGetChatsFromDbMutator.access$getChatsFromDbForSpecificList(tryToGetChatsFromDbMutator, str, ChannelsListInteractorImpl.this.H, "main");
                if (ChannelsListInteractorImpl.this.I != null) {
                    single2 = ChannelsListInteractorImpl.InitialDataRequestComposite.TryToGetChatsFromDbMutator.access$getChatsFromDbForSpecificList(tryToGetChatsFromDbMutator, str, ChannelsListInteractorImpl.this.I, "pinned");
                } else {
                    single2 = Singles.toSingle(Notification.createOnComplete());
                }
                single = SinglesKt.zipWith(access$getChatsFromDbForSpecificList, single2);
            } else {
                single = SinglesKt.zipWith(ChannelsListInteractorImpl.InitialDataRequestComposite.TryToGetChatsFromDbMutator.access$getChatsFromDbForSpecificList(tryToGetChatsFromDbMutator, str, ChannelsListInteractorImpl.this.J, "merged"), Singles.toSingle(Notification.createOnComplete()));
            }
            Single<R> map = single.map(new a(str, this));
            Intrinsics.checkNotNullExpressionValue(map, "getChatsFromDb(userId)\n …                        }");
            return map;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
