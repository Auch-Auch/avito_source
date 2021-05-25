package com.avito.android.messenger;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.UnreadMessagesCounter;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/UnreadMessagesCounterRelay;", "Lcom/avito/android/messenger/UnreadMessagesCounterConsumer;", "Lcom/avito/android/messenger/UnreadMessagesCounterObservable;", "Impl", "core_release"}, k = 1, mv = {1, 4, 2})
public interface UnreadMessagesCounterRelay extends UnreadMessagesCounterConsumer, UnreadMessagesCounterObservable {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tRD\u0010\u000f\u001a0\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00020\u0002 \u000b*\u0017\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\n¢\u0006\u0002\b\f0\n¢\u0006\u0002\b\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/UnreadMessagesCounterRelay$Impl;", "Lcom/avito/android/messenger/UnreadMessagesCounterRelay;", "Lcom/avito/android/remote/model/messenger/UnreadMessagesCounter;", "counter", "", "accept", "(Lcom/avito/android/remote/model/messenger/UnreadMessagesCounter;)V", "Lio/reactivex/rxjava3/core/Observable;", "observe", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/PublishRelay;", "relay", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements UnreadMessagesCounterRelay {
        public final PublishRelay<UnreadMessagesCounter> a = PublishRelay.create();

        @Override // com.avito.android.messenger.UnreadMessagesCounterConsumer
        public void accept(@NotNull UnreadMessagesCounter unreadMessagesCounter) {
            Intrinsics.checkNotNullParameter(unreadMessagesCounter, "counter");
            this.a.accept(unreadMessagesCounter);
        }

        @Override // com.avito.android.messenger.UnreadMessagesCounterObservable
        @NotNull
        public Observable<UnreadMessagesCounter> observe() {
            PublishRelay<UnreadMessagesCounter> publishRelay = this.a;
            Intrinsics.checkNotNullExpressionValue(publishRelay, "relay");
            return publishRelay;
        }
    }
}
