package com.avito.android;

import io.reactivex.Completable;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0004\u0018\u0001`\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/MessengerWorkFactory;", "", "Lkotlin/Pair;", "", "Ljava/util/UUID;", "Lcom/avito/android/WorkTagAndId;", "enqueueUpdateUnreadMessagesCountWork", "()Lkotlin/Pair;", "", "delayInSeconds", "", "replace", "Lio/reactivex/Completable;", "enqueueSendPendingMessagesWork", "(JZ)Lio/reactivex/Completable;", "cancelSendPendingMessagesWork", "()Lio/reactivex/Completable;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface MessengerWorkFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Completable enqueueSendPendingMessagesWork$default(MessengerWorkFactory messengerWorkFactory, long j, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    j = 0;
                }
                if ((i & 2) != 0) {
                    z = false;
                }
                return messengerWorkFactory.enqueueSendPendingMessagesWork(j, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enqueueSendPendingMessagesWork");
        }
    }

    @NotNull
    Completable cancelSendPendingMessagesWork();

    @NotNull
    Completable enqueueSendPendingMessagesWork(long j, boolean z);

    @Nullable
    Pair<String, UUID> enqueueUpdateUnreadMessagesCountWork();
}
