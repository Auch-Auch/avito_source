package com.avito.android.messenger.conversation.mvi.messages;

import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a*\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00018\u00018\u0001 \u0005*\u0014\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00018\u00018\u0001\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"T", "R", "Larrow/core/Option;", "it", "Lio/reactivex/ObservableSource;", "kotlin.jvm.PlatformType", "apply", "(Larrow/core/Option;)Lio/reactivex/ObservableSource;", "com/avito/android/util/Observables$switchMapFold$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class MessageListPresenterImpl$subscribeToFileDownloadFails$$inlined$switchMapFold$1<T, R> implements Function<Option<? extends T>, ObservableSource<? extends R>> {
    public final /* synthetic */ MessageListPresenterImpl a;

    public MessageListPresenterImpl$subscribeToFileDownloadFails$$inlined$switchMapFold$1(MessageListPresenterImpl messageListPresenterImpl) {
        this.a = messageListPresenterImpl;
    }

    public final ObservableSource<? extends R> apply(@NotNull Option<? extends T> option) {
        Intrinsics.checkNotNullParameter(option, "it");
        if (option instanceof None) {
            Observable never = Observable.never();
            Intrinsics.checkNotNullExpressionValue(never, "Observable.never()");
            return never;
        } else if (option instanceof Some) {
            return InteropKt.toV2(MessageListPresenterImpl.access$getDeps$p(this.a).getFileDownloadManager().observeNewDownloadFails((String) ((Some) option).getT(), MessageListPresenterImpl.access$getDeps$p(this.a).getChannelId(), MessageListPresenterImpl.access$getDeps$p(this.a).getTimeSource().now()));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return apply((Option) ((Option) obj));
    }
}
