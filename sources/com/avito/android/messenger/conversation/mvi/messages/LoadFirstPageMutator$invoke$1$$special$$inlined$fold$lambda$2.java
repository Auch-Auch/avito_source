package com.avito.android.messenger.conversation.mvi.messages;

import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.messenger.conversation.mvi.messages.LoadFirstPageMutator;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.util.Singles;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00018\u00008\u0000 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00030\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "", "it", "Lio/reactivex/SingleSource;", "kotlin.jvm.PlatformType", "apply", "(Lkotlin/Unit;)Lio/reactivex/SingleSource;", "com/avito/android/messenger/conversation/mvi/messages/LoadFirstPageMutator$invoke$1$$special$$inlined$flatMapSingle$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class LoadFirstPageMutator$invoke$1$$special$$inlined$fold$lambda$2<T, R> implements Function<Unit, SingleSource<? extends T>> {
    public final /* synthetic */ LoadFirstPageMutator.a a;

    public static final class a<T, R> implements Function<Option<? extends Long>, SingleSource<? extends MessageListInteractor.State.FirstPageLoaded>> {
        public final /* synthetic */ LoadFirstPageMutator$invoke$1$$special$$inlined$fold$lambda$2 a;

        public a(LoadFirstPageMutator$invoke$1$$special$$inlined$fold$lambda$2 loadFirstPageMutator$invoke$1$$special$$inlined$fold$lambda$2) {
            this.a = loadFirstPageMutator$invoke$1$$special$$inlined$fold$lambda$2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends MessageListInteractor.State.FirstPageLoaded> apply(Option<? extends Long> option) {
            MessageListInteractor.State.FirstPageLoaded firstPageLoaded;
            Option<? extends Long> option2 = option;
            Intrinsics.checkNotNullParameter(option2, "timestampOption2");
            if (option2 instanceof None) {
                Observable<List<Pair<LocalMessage, MessageMetaInfo>>> allMessagesAndMetaInfo = this.a.a.a.f.getMessageRepo().getAllMessagesAndMetaInfo(this.a.a.a.c, this.a.a.a.d);
                Observable never = Observable.never();
                Intrinsics.checkNotNullExpressionValue(never, "Observable.never()");
                firstPageLoaded = new MessageListInteractor.State.FirstPageLoaded(allMessagesAndMetaInfo, new MessageListInteractor.PaginationState.Success(never, null, 0, false));
            } else if (option2 instanceof Some) {
                long longValue = ((Number) ((Some) option2).getT()).longValue();
                Observable<List<Pair<LocalMessage, MessageMetaInfo>>> messagesAndMetaInfoAfter = this.a.a.a.f.getMessageRepo().getMessagesAndMetaInfoAfter(longValue - 1, this.a.a.a.c, this.a.a.a.d);
                Observable never2 = Observable.never();
                Intrinsics.checkNotNullExpressionValue(never2, "Observable.never()");
                firstPageLoaded = new MessageListInteractor.State.FirstPageLoaded(messagesAndMetaInfoAfter, new MessageListInteractor.PaginationState.Success(never2, Long.valueOf(longValue), 0, true));
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return Singles.toSingle(firstPageLoaded);
        }
    }

    public LoadFirstPageMutator$invoke$1$$special$$inlined$fold$lambda$2(LoadFirstPageMutator.a aVar) {
        this.a = aVar;
    }

    public final SingleSource<? extends T> apply(@NotNull Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        Single<R> flatMap = this.a.a.f.getMessageRepo().getFirstPageTimestamp(this.a.a.c, this.a.a.d, 101, this.a.a.e, false).flatMap(new a(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "deps.messageRepo.getFirs…                        }");
        return flatMap;
    }
}
