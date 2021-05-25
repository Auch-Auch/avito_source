package com.avito.android.messenger.conversation.mvi.messages;

import a2.a.a.o1.d.a0.i.g;
import androidx.annotation.VisibleForTesting;
import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.messenger.MessageListLoadingException;
import com.avito.android.messenger.analytics.graphite_counter.ChatLoadingResult;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractorImpl;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Logs;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/LoadFirstPageMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;)Lio/reactivex/Single;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractorImpl$Dependencies;", "f", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractorImpl$Dependencies;", "deps", "", "c", "Ljava/lang/String;", ChannelContext.Item.USER_ID, "d", "channelId", "e", "messageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractorImpl$Dependencies;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@VisibleForTesting(otherwise = 3)
public final class LoadFirstPageMutator extends MutatorSingle<MessageListInteractor.State> {
    public final String c;
    public final String d;
    public final String e;
    public final MessageListInteractorImpl.Dependencies f;

    public static final class a<T, R> implements Function<Option<? extends Long>, SingleSource<? extends MessageListInteractor.State>> {
        public final /* synthetic */ LoadFirstPageMutator a;

        public a(LoadFirstPageMutator loadFirstPageMutator) {
            this.a = loadFirstPageMutator;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends MessageListInteractor.State> apply(Option<? extends Long> option) {
            Single<R> single;
            Option<? extends Long> option2 = option;
            Intrinsics.checkNotNullParameter(option2, "timestampOption");
            if (option2 instanceof None) {
                Completable onErrorResumeNext = this.a.f.getSyncLatestMessages().invoke(this.a.c, this.a.d).onErrorResumeNext(new a2.a.a.o1.d.a0.i.d(this));
                Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "deps.syncLatestMessages(…                        }");
                single = onErrorResumeNext.toSingleDefault(Unit.INSTANCE).flatMap(new LoadFirstPageMutator$invoke$1$$special$$inlined$fold$lambda$2(this));
                Intrinsics.checkNotNullExpressionValue(single, "toSingleDefault(Unit).flatMap { singleFactory() }");
            } else if (option2 instanceof Some) {
                long longValue = ((Number) ((Some) option2).getT()).longValue();
                Completable onErrorResumeNext2 = this.a.f.getSyncLatestMessages().invoke(this.a.c, this.a.d).onErrorResumeNext(new a2.a.a.o1.d.a0.i.f(this));
                Intrinsics.checkNotNullExpressionValue(onErrorResumeNext2, "deps.syncLatestMessages(…                        }");
                Single<R> flatMap = onErrorResumeNext2.toSingleDefault(Unit.INSTANCE).flatMap(new LoadFirstPageMutator$invoke$1$$special$$inlined$fold$lambda$4(longValue, this));
                Intrinsics.checkNotNullExpressionValue(flatMap, "toSingleDefault(Unit).flatMap { singleFactory() }");
                single = flatMap.doOnSuccess(new g(this));
            } else {
                throw new NoWhenBranchMatchedException();
            }
            Objects.requireNonNull(single, "null cannot be cast to non-null type io.reactivex.Single<com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor.State>");
            return single;
        }
    }

    public static final class b<T> implements Consumer<Disposable> {
        public final /* synthetic */ LoadFirstPageMutator a;

        public b(LoadFirstPageMutator loadFirstPageMutator) {
            this.a = loadFirstPageMutator;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            this.a.f.getChatLoadingTimer().trackStart();
        }
    }

    public static final class c<T> implements Consumer<MessageListInteractor.State> {
        public final /* synthetic */ LoadFirstPageMutator a;

        public c(LoadFirstPageMutator loadFirstPageMutator) {
            this.a = loadFirstPageMutator;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(MessageListInteractor.State state) {
            this.a.f.getChatLoadingTimer().trackEnd(ChatLoadingResult.SUCCESS);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ LoadFirstPageMutator a;

        public d(LoadFirstPageMutator loadFirstPageMutator) {
            this.a = loadFirstPageMutator;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.f.getChatLoadingTimer().trackEnd(ChatLoadingResult.ERROR);
        }
    }

    public static final class e implements Action {
        public final /* synthetic */ LoadFirstPageMutator a;

        public e(LoadFirstPageMutator loadFirstPageMutator) {
            this.a = loadFirstPageMutator;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.a.f.getSubscribeToReconnects().invoke(this.a.c, this.a.d);
        }
    }

    public static final class f<T, R> implements Function<Throwable, MessageListInteractor.State> {
        public final /* synthetic */ LoadFirstPageMutator a;

        public f(LoadFirstPageMutator loadFirstPageMutator) {
            this.a = loadFirstPageMutator;
        }

        @Override // io.reactivex.functions.Function
        public MessageListInteractor.State apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            Logs.warning$default("MessageListInteractor", "FirstPageLoadError: " + th2, null, 4, null);
            ErrorTracker.DefaultImpls.track$default(this.a.f.getErrorTracker(), new MessageListLoadingException("Failed to load messages", th2), null, null, 6, null);
            return MessageListInteractor.State.FirstPageLoadError.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoadFirstPageMutator(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull MessageListInteractorImpl.Dependencies dependencies) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(dependencies, "deps");
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = dependencies;
    }

    @NotNull
    public Single<MessageListInteractor.State> invoke(@NotNull MessageListInteractor.State state) {
        Intrinsics.checkNotNullParameter(state, "oldState");
        MessageRepo messageRepo = this.f.getMessageRepo();
        String str = this.c;
        String str2 = this.d;
        String str3 = this.e;
        Single<R> onErrorReturn = messageRepo.getFirstPageTimestamp(str, str2, 101, str3, str3 != null).flatMap(new a(this)).doOnSubscribe(new b(this)).doAfterSuccess(new c(this)).doOnError(new d(this)).doAfterTerminate(new e(this)).onErrorReturn(new f(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "deps.messageRepo.getFirs…geLoadError\n            }");
        return onErrorReturn;
    }
}
