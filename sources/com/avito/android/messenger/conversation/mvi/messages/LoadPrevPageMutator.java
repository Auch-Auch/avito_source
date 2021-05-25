package com.avito.android.messenger.conversation.mvi.messages;

import a2.a.a.o1.d.a0.i.h;
import androidx.annotation.VisibleForTesting;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.messenger.MessageListPaginationException;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractorImpl;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.util.Singles;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/LoadPrevPageMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;)Lio/reactivex/Single;", "", "d", "Ljava/lang/String;", "channelId", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractorImpl$Dependencies;", "e", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractorImpl$Dependencies;", "deps", "c", ChannelContext.Item.USER_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractorImpl$Dependencies;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@VisibleForTesting(otherwise = 3)
public final class LoadPrevPageMutator extends MutatorSingle<MessageListInteractor.State> {
    public final String c;
    public final String d;
    public final MessageListInteractorImpl.Dependencies e;

    public static final class a<T, R> implements Function<Long, SingleSource<? extends MessageListInteractor.State.FirstPageLoaded>> {
        public final /* synthetic */ LoadPrevPageMutator a;
        public final /* synthetic */ long b;
        public final /* synthetic */ MessageListInteractor.State c;
        public final /* synthetic */ Long d;

        public a(LoadPrevPageMutator loadPrevPageMutator, long j, MessageListInteractor.State state, Long l) {
            this.a = loadPrevPageMutator;
            this.b = j;
            this.c = state;
            this.d = l;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends MessageListInteractor.State.FirstPageLoaded> apply(Long l) {
            Long l2 = l;
            Intrinsics.checkNotNullParameter(l2, "messageCountBeforeFirstPage");
            if (l2.longValue() >= this.b) {
                return Singles.toSingle(new MessageListInteractor.State.FirstPageLoaded(((MessageListInteractor.State.FirstPageLoaded) this.c).getFirstPageMessagesAndMetaInfoObservable(), new MessageListInteractor.PaginationState.Success(this.a.e.getMessageRepo().getMessagesAndMetaInfoBefore(this.d.longValue() + 1, this.a.c, this.a.d, this.b), this.d, this.b, true)));
            }
            Single<R> map = this.a.e.getSyncPreviousPageOfMessages().invoke(this.a.c, this.a.d).map(new h(this));
            Intrinsics.checkNotNullExpressionValue(map, "deps.syncPreviousPageOfM…                        }");
            return map;
        }
    }

    public static final class b<T, R> implements Function<Throwable, MessageListInteractor.State> {
        public final /* synthetic */ LoadPrevPageMutator a;
        public final /* synthetic */ MessageListInteractor.State b;

        public b(LoadPrevPageMutator loadPrevPageMutator, MessageListInteractor.State state) {
            this.a = loadPrevPageMutator;
            this.b = state;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public MessageListInteractor.State apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            ErrorTracker.DefaultImpls.track$default(this.a.e.getErrorTracker(), new MessageListPaginationException("Failed to load previous page", th2), null, null, 6, null);
            Observable<List<Pair<LocalMessage, MessageMetaInfo>>> firstPageMessagesAndMetaInfoObservable = ((MessageListInteractor.State.FirstPageLoaded) this.b).getFirstPageMessagesAndMetaInfoObservable();
            MessageListInteractor.PaginationState paginationState = ((MessageListInteractor.State.FirstPageLoaded) this.b).getPaginationState();
            return new MessageListInteractor.State.FirstPageLoaded(firstPageMessagesAndMetaInfoObservable, new MessageListInteractor.PaginationState.Error(paginationState.getPreviousMessagesAndMetaInfoObservable(), paginationState.getPreviousMessagesEndTimestamp(), paginationState.getRequestedPrevMessagesCount()));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoadPrevPageMutator(@NotNull String str, @NotNull String str2, @NotNull MessageListInteractorImpl.Dependencies dependencies) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(dependencies, "deps");
        this.c = str;
        this.d = str2;
        this.e = dependencies;
    }

    @NotNull
    public Single<MessageListInteractor.State> invoke(@NotNull MessageListInteractor.State state) {
        MessageListInteractor.PaginationState paginationState;
        Intrinsics.checkNotNullParameter(state, "oldState");
        boolean z = state instanceof MessageListInteractor.State.FirstPageLoaded;
        Long l = null;
        MessageListInteractor.State.FirstPageLoaded firstPageLoaded = (MessageListInteractor.State.FirstPageLoaded) (!z ? null : state);
        if (!(firstPageLoaded == null || (paginationState = firstPageLoaded.getPaginationState()) == null)) {
            l = paginationState.getPreviousMessagesEndTimestamp();
        }
        if (z) {
            MessageListInteractor.State.FirstPageLoaded firstPageLoaded2 = (MessageListInteractor.State.FirstPageLoaded) state;
            if ((firstPageLoaded2.getPaginationState() instanceof MessageListInteractor.PaginationState.InProgress) && l != null) {
                Single<R> flatMap = this.e.getMessageRepo().getMessageCountBefore(l.longValue() + 1, this.c, this.d).flatMap(new a(this, firstPageLoaded2.getPaginationState().getRequestedPrevMessagesCount() + ((long) 100), state, l));
                Intrinsics.checkNotNullExpressionValue(flatMap, "deps.messageRepo.getMess…      }\n                }");
                Single<U> cast = flatMap.cast(MessageListInteractor.State.class);
                Intrinsics.checkExpressionValueIsNotNull(cast, "cast(R::class.java)");
                Single<U> onErrorReturn = cast.onErrorReturn(new b(this, state));
                Intrinsics.checkNotNullExpressionValue(onErrorReturn, "deps.messageRepo.getMess…      )\n                }");
                return onErrorReturn;
            }
        }
        return Singles.toSingle(state);
    }
}
