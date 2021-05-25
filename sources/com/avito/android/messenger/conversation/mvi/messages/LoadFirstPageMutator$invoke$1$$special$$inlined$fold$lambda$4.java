package com.avito.android.messenger.conversation.mvi.messages;

import com.avito.android.messenger.conversation.mvi.messages.LoadFirstPageMutator;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.util.Singles;
import io.reactivex.Observable;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00018\u00008\u0000 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00030\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "", "it", "Lio/reactivex/SingleSource;", "kotlin.jvm.PlatformType", "apply", "(Lkotlin/Unit;)Lio/reactivex/SingleSource;", "com/avito/android/messenger/conversation/mvi/messages/LoadFirstPageMutator$invoke$1$$special$$inlined$flatMapSingle$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class LoadFirstPageMutator$invoke$1$$special$$inlined$fold$lambda$4<T, R> implements Function<Unit, SingleSource<? extends T>> {
    public final /* synthetic */ long a;
    public final /* synthetic */ LoadFirstPageMutator.a b;

    public LoadFirstPageMutator$invoke$1$$special$$inlined$fold$lambda$4(long j, LoadFirstPageMutator.a aVar) {
        this.a = j;
        this.b = aVar;
    }

    public final SingleSource<? extends T> apply(@NotNull Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        Observable<List<Pair<LocalMessage, MessageMetaInfo>>> messagesAndMetaInfoAfter = this.b.a.f.getMessageRepo().getMessagesAndMetaInfoAfter(this.a - 1, this.b.a.c, this.b.a.d);
        Observable never = Observable.never();
        Intrinsics.checkNotNullExpressionValue(never, "Observable.never()");
        return Singles.toSingle(new MessageListInteractor.State.FirstPageLoaded(messagesAndMetaInfoAfter, new MessageListInteractor.PaginationState.Success(never, Long.valueOf(this.a), 0, true)));
    }
}
