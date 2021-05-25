package com.avito.android.messenger.conversation.mvi.messages;

import a2.b.a.a.a;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
import t6.y.f;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\t\nJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;", "", ChannelContext.Item.USER_ID, "", "loadFirstPage", "(Ljava/lang/String;)V", "loadPrevPage", "PaginationState", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessageListInteractor extends MviEntity<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u001a\u001b\u001cB\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002H\b¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\b¢\u0006\u0004\b\u0006\u0010\u0007R4\u0010\u0010\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nj\u0002`\r0\t0\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0001\u0003\u001d\u0002\u0005¨\u0006\u001e"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$PaginationState;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$PaginationState$InProgress;", "toInProgress", "()Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$PaginationState$InProgress;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$PaginationState$Error;", "toError", "()Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$PaginationState$Error;", "Lio/reactivex/Observable;", "", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageAndMetaInfo;", "getPreviousMessagesAndMetaInfoObservable", "()Lio/reactivex/Observable;", "previousMessagesAndMetaInfoObservable", "", "getRequestedPrevMessagesCount", "()J", "requestedPrevMessagesCount", "getPreviousMessagesEndTimestamp", "()Ljava/lang/Long;", "previousMessagesEndTimestamp", "<init>", "()V", "Error", "InProgress", "Success", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$PaginationState$Success;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class PaginationState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B?\u0012$\u0010\u0012\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n0\u00060\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J.\u0010\u000b\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n0\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011JN\u0010\u0015\u001a\u00020\u00002&\b\u0002\u0010\u0012\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n0\u00060\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0014\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR:\u0010\u0012\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n0\u00060\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0011¨\u0006*"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$PaginationState$Error;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$PaginationState;", "", "toString", "()Ljava/lang/String;", "Lio/reactivex/Observable;", "", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageAndMetaInfo;", "component1", "()Lio/reactivex/Observable;", "", "component2", "()Ljava/lang/Long;", "component3", "()J", "previousMessagesAndMetaInfoObservable", "previousMessagesEndTimestamp", "requestedPrevMessagesCount", "copy", "(Lio/reactivex/Observable;Ljava/lang/Long;J)Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$PaginationState$Error;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lio/reactivex/Observable;", "getPreviousMessagesAndMetaInfoObservable", AuthSource.BOOKING_ORDER, "Ljava/lang/Long;", "getPreviousMessagesEndTimestamp", "c", "J", "getRequestedPrevMessagesCount", "<init>", "(Lio/reactivex/Observable;Ljava/lang/Long;J)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends PaginationState {
            @NotNull
            public final Observable<List<Pair<LocalMessage, MessageMetaInfo>>> a;
            @Nullable
            public final Long b;
            public final long c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull Observable<List<Pair<LocalMessage, MessageMetaInfo>>> observable, @Nullable Long l, long j) {
                super(null);
                Intrinsics.checkNotNullParameter(observable, "previousMessagesAndMetaInfoObservable");
                this.a = observable;
                this.b = l;
                this.c = j;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor$PaginationState$Error */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Error copy$default(Error error, Observable observable, Long l, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    observable = error.getPreviousMessagesAndMetaInfoObservable();
                }
                if ((i & 2) != 0) {
                    l = error.getPreviousMessagesEndTimestamp();
                }
                if ((i & 4) != 0) {
                    j = error.getRequestedPrevMessagesCount();
                }
                return error.copy(observable, l, j);
            }

            @NotNull
            public final Observable<List<Pair<LocalMessage, MessageMetaInfo>>> component1() {
                return getPreviousMessagesAndMetaInfoObservable();
            }

            @Nullable
            public final Long component2() {
                return getPreviousMessagesEndTimestamp();
            }

            public final long component3() {
                return getRequestedPrevMessagesCount();
            }

            @NotNull
            public final Error copy(@NotNull Observable<List<Pair<LocalMessage, MessageMetaInfo>>> observable, @Nullable Long l, long j) {
                Intrinsics.checkNotNullParameter(observable, "previousMessagesAndMetaInfoObservable");
                return new Error(observable, l, j);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Error)) {
                    return false;
                }
                Error error = (Error) obj;
                return Intrinsics.areEqual(getPreviousMessagesAndMetaInfoObservable(), error.getPreviousMessagesAndMetaInfoObservable()) && Intrinsics.areEqual(getPreviousMessagesEndTimestamp(), error.getPreviousMessagesEndTimestamp()) && getRequestedPrevMessagesCount() == error.getRequestedPrevMessagesCount();
            }

            @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor.PaginationState
            @NotNull
            public Observable<List<Pair<LocalMessage, MessageMetaInfo>>> getPreviousMessagesAndMetaInfoObservable() {
                return this.a;
            }

            @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor.PaginationState
            @Nullable
            public Long getPreviousMessagesEndTimestamp() {
                return this.b;
            }

            @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor.PaginationState
            public long getRequestedPrevMessagesCount() {
                return this.c;
            }

            public int hashCode() {
                Observable<List<Pair<LocalMessage, MessageMetaInfo>>> previousMessagesAndMetaInfoObservable = getPreviousMessagesAndMetaInfoObservable();
                int i = 0;
                int hashCode = (previousMessagesAndMetaInfoObservable != null ? previousMessagesAndMetaInfoObservable.hashCode() : 0) * 31;
                Long previousMessagesEndTimestamp = getPreviousMessagesEndTimestamp();
                if (previousMessagesEndTimestamp != null) {
                    i = previousMessagesEndTimestamp.hashCode();
                }
                return ((hashCode + i) * 31) + c.a(getRequestedPrevMessagesCount());
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("PaginationState.Error(\n                | previousMessagesAndMetaInfoObservable=");
                L.append(getPreviousMessagesAndMetaInfoObservable());
                L.append(",\n                | previousMessagesEndTimestamp=");
                L.append(getPreviousMessagesEndTimestamp());
                L.append(",\n                | requestedPrevMessagesCount=");
                L.append(getRequestedPrevMessagesCount());
                L.append("\n                |)");
                return f.trimMargin$default(L.toString(), null, 1, null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B?\u0012$\u0010\u0012\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n0\u00060\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J.\u0010\u000b\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n0\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011JN\u0010\u0015\u001a\u00020\u00002&\b\u0002\u0010\u0012\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n0\u00060\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0014\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR:\u0010\u0012\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n0\u00060\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0011¨\u0006*"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$PaginationState$InProgress;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$PaginationState;", "", "toString", "()Ljava/lang/String;", "Lio/reactivex/Observable;", "", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageAndMetaInfo;", "component1", "()Lio/reactivex/Observable;", "", "component2", "()Ljava/lang/Long;", "component3", "()J", "previousMessagesAndMetaInfoObservable", "previousMessagesEndTimestamp", "requestedPrevMessagesCount", "copy", "(Lio/reactivex/Observable;Ljava/lang/Long;J)Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$PaginationState$InProgress;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lio/reactivex/Observable;", "getPreviousMessagesAndMetaInfoObservable", AuthSource.BOOKING_ORDER, "Ljava/lang/Long;", "getPreviousMessagesEndTimestamp", "c", "J", "getRequestedPrevMessagesCount", "<init>", "(Lio/reactivex/Observable;Ljava/lang/Long;J)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class InProgress extends PaginationState {
            @NotNull
            public final Observable<List<Pair<LocalMessage, MessageMetaInfo>>> a;
            @Nullable
            public final Long b;
            public final long c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public InProgress(@NotNull Observable<List<Pair<LocalMessage, MessageMetaInfo>>> observable, @Nullable Long l, long j) {
                super(null);
                Intrinsics.checkNotNullParameter(observable, "previousMessagesAndMetaInfoObservable");
                this.a = observable;
                this.b = l;
                this.c = j;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor$PaginationState$InProgress */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ InProgress copy$default(InProgress inProgress, Observable observable, Long l, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    observable = inProgress.getPreviousMessagesAndMetaInfoObservable();
                }
                if ((i & 2) != 0) {
                    l = inProgress.getPreviousMessagesEndTimestamp();
                }
                if ((i & 4) != 0) {
                    j = inProgress.getRequestedPrevMessagesCount();
                }
                return inProgress.copy(observable, l, j);
            }

            @NotNull
            public final Observable<List<Pair<LocalMessage, MessageMetaInfo>>> component1() {
                return getPreviousMessagesAndMetaInfoObservable();
            }

            @Nullable
            public final Long component2() {
                return getPreviousMessagesEndTimestamp();
            }

            public final long component3() {
                return getRequestedPrevMessagesCount();
            }

            @NotNull
            public final InProgress copy(@NotNull Observable<List<Pair<LocalMessage, MessageMetaInfo>>> observable, @Nullable Long l, long j) {
                Intrinsics.checkNotNullParameter(observable, "previousMessagesAndMetaInfoObservable");
                return new InProgress(observable, l, j);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof InProgress)) {
                    return false;
                }
                InProgress inProgress = (InProgress) obj;
                return Intrinsics.areEqual(getPreviousMessagesAndMetaInfoObservable(), inProgress.getPreviousMessagesAndMetaInfoObservable()) && Intrinsics.areEqual(getPreviousMessagesEndTimestamp(), inProgress.getPreviousMessagesEndTimestamp()) && getRequestedPrevMessagesCount() == inProgress.getRequestedPrevMessagesCount();
            }

            @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor.PaginationState
            @NotNull
            public Observable<List<Pair<LocalMessage, MessageMetaInfo>>> getPreviousMessagesAndMetaInfoObservable() {
                return this.a;
            }

            @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor.PaginationState
            @Nullable
            public Long getPreviousMessagesEndTimestamp() {
                return this.b;
            }

            @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor.PaginationState
            public long getRequestedPrevMessagesCount() {
                return this.c;
            }

            public int hashCode() {
                Observable<List<Pair<LocalMessage, MessageMetaInfo>>> previousMessagesAndMetaInfoObservable = getPreviousMessagesAndMetaInfoObservable();
                int i = 0;
                int hashCode = (previousMessagesAndMetaInfoObservable != null ? previousMessagesAndMetaInfoObservable.hashCode() : 0) * 31;
                Long previousMessagesEndTimestamp = getPreviousMessagesEndTimestamp();
                if (previousMessagesEndTimestamp != null) {
                    i = previousMessagesEndTimestamp.hashCode();
                }
                return ((hashCode + i) * 31) + c.a(getRequestedPrevMessagesCount());
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("PaginationState.InProgress(\n                | previousMessagesAndMetaInfoObservable=");
                L.append(getPreviousMessagesAndMetaInfoObservable());
                L.append(",\n                | previousMessagesEndTimestamp=");
                L.append(getPreviousMessagesEndTimestamp());
                L.append(",\n                | requestedPrevMessagesCount=");
                L.append(getRequestedPrevMessagesCount());
                L.append("\n                |)");
                return f.trimMargin$default(L.toString(), null, 1, null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001BG\u0012$\u0010\u0015\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n0\u00060\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0017\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0012¢\u0006\u0004\b.\u0010/J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J.\u0010\u000b\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n0\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014JX\u0010\u0019\u001a\u00020\u00002&\b\u0002\u0010\u0015\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n0\u00060\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u0012HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b \u0010!R\u0019\u0010\u0018\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0014R:\u0010\u0015\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n0\u00060\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\fR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u000fR\u001c\u0010\u0017\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0011¨\u00060"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$PaginationState$Success;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$PaginationState;", "", "toString", "()Ljava/lang/String;", "Lio/reactivex/Observable;", "", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageAndMetaInfo;", "component1", "()Lio/reactivex/Observable;", "", "component2", "()Ljava/lang/Long;", "component3", "()J", "", "component4", "()Z", "previousMessagesAndMetaInfoObservable", "previousMessagesEndTimestamp", "requestedPrevMessagesCount", "hasMorePages", "copy", "(Lio/reactivex/Observable;Ljava/lang/Long;JZ)Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$PaginationState$Success;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "d", "Z", "getHasMorePages", AuthSource.SEND_ABUSE, "Lio/reactivex/Observable;", "getPreviousMessagesAndMetaInfoObservable", AuthSource.BOOKING_ORDER, "Ljava/lang/Long;", "getPreviousMessagesEndTimestamp", "c", "J", "getRequestedPrevMessagesCount", "<init>", "(Lio/reactivex/Observable;Ljava/lang/Long;JZ)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Success extends PaginationState {
            @NotNull
            public final Observable<List<Pair<LocalMessage, MessageMetaInfo>>> a;
            @Nullable
            public final Long b;
            public final long c;
            public final boolean d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Success(@NotNull Observable<List<Pair<LocalMessage, MessageMetaInfo>>> observable, @Nullable Long l, long j, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(observable, "previousMessagesAndMetaInfoObservable");
                this.a = observable;
                this.b = l;
                this.c = j;
                this.d = z;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor$PaginationState$Success */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Success copy$default(Success success, Observable observable, Long l, long j, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    observable = success.getPreviousMessagesAndMetaInfoObservable();
                }
                if ((i & 2) != 0) {
                    l = success.getPreviousMessagesEndTimestamp();
                }
                if ((i & 4) != 0) {
                    j = success.getRequestedPrevMessagesCount();
                }
                if ((i & 8) != 0) {
                    z = success.d;
                }
                return success.copy(observable, l, j, z);
            }

            @NotNull
            public final Observable<List<Pair<LocalMessage, MessageMetaInfo>>> component1() {
                return getPreviousMessagesAndMetaInfoObservable();
            }

            @Nullable
            public final Long component2() {
                return getPreviousMessagesEndTimestamp();
            }

            public final long component3() {
                return getRequestedPrevMessagesCount();
            }

            public final boolean component4() {
                return this.d;
            }

            @NotNull
            public final Success copy(@NotNull Observable<List<Pair<LocalMessage, MessageMetaInfo>>> observable, @Nullable Long l, long j, boolean z) {
                Intrinsics.checkNotNullParameter(observable, "previousMessagesAndMetaInfoObservable");
                return new Success(observable, l, j, z);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Success)) {
                    return false;
                }
                Success success = (Success) obj;
                return Intrinsics.areEqual(getPreviousMessagesAndMetaInfoObservable(), success.getPreviousMessagesAndMetaInfoObservable()) && Intrinsics.areEqual(getPreviousMessagesEndTimestamp(), success.getPreviousMessagesEndTimestamp()) && getRequestedPrevMessagesCount() == success.getRequestedPrevMessagesCount() && this.d == success.d;
            }

            public final boolean getHasMorePages() {
                return this.d;
            }

            @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor.PaginationState
            @NotNull
            public Observable<List<Pair<LocalMessage, MessageMetaInfo>>> getPreviousMessagesAndMetaInfoObservable() {
                return this.a;
            }

            @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor.PaginationState
            @Nullable
            public Long getPreviousMessagesEndTimestamp() {
                return this.b;
            }

            @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor.PaginationState
            public long getRequestedPrevMessagesCount() {
                return this.c;
            }

            public int hashCode() {
                Observable<List<Pair<LocalMessage, MessageMetaInfo>>> previousMessagesAndMetaInfoObservable = getPreviousMessagesAndMetaInfoObservable();
                int i = 0;
                int hashCode = (previousMessagesAndMetaInfoObservable != null ? previousMessagesAndMetaInfoObservable.hashCode() : 0) * 31;
                Long previousMessagesEndTimestamp = getPreviousMessagesEndTimestamp();
                if (previousMessagesEndTimestamp != null) {
                    i = previousMessagesEndTimestamp.hashCode();
                }
                int a3 = (((hashCode + i) * 31) + c.a(getRequestedPrevMessagesCount())) * 31;
                boolean z = this.d;
                if (z) {
                    z = true;
                }
                int i2 = z ? 1 : 0;
                int i3 = z ? 1 : 0;
                int i4 = z ? 1 : 0;
                return a3 + i2;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("PaginationState.Success(\n                | previousMessagesAndMetaInfoObservable=");
                L.append(getPreviousMessagesAndMetaInfoObservable());
                L.append(",\n                | previousMessagesEndTimestamp=");
                L.append(getPreviousMessagesEndTimestamp());
                L.append(",\n                | requestedPrevMessagesCount=");
                L.append(getRequestedPrevMessagesCount());
                L.append(".\n                | hasMorePages=");
                return f.trimMargin$default(a.B(L, this.d, "\n                |)"), null, 1, null);
            }
        }

        public PaginationState() {
        }

        @NotNull
        public abstract Observable<List<Pair<LocalMessage, MessageMetaInfo>>> getPreviousMessagesAndMetaInfoObservable();

        @Nullable
        public abstract Long getPreviousMessagesEndTimestamp();

        public abstract long getRequestedPrevMessagesCount();

        @NotNull
        public final Error toError() {
            return new Error(getPreviousMessagesAndMetaInfoObservable(), getPreviousMessagesEndTimestamp(), getRequestedPrevMessagesCount());
        }

        @NotNull
        public final InProgress toInProgress() {
            return new InProgress(getPreviousMessagesAndMetaInfoObservable(), getPreviousMessagesEndTimestamp(), getRequestedPrevMessagesCount());
        }

        public PaginationState(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;", "", "<init>", "()V", "Empty", "FirstPageLoadError", "FirstPageLoaded", "FirstPageLoadingInProgress", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State$Empty;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State$FirstPageLoadingInProgress;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State$FirstPageLoadError;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State$FirstPageLoaded;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State$Empty;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends State {
            @NotNull
            public static final Empty INSTANCE = new Empty();

            public Empty() {
                super(null);
            }

            @NotNull
            public String toString() {
                return "Empty";
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State$FirstPageLoadError;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class FirstPageLoadError extends State {
            @NotNull
            public static final FirstPageLoadError INSTANCE = new FirstPageLoadError();

            public FirstPageLoadError() {
                super(null);
            }

            @NotNull
            public String toString() {
                return "FirstPageLoadError";
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B5\u0012$\u0010\r\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004j\u0002`\u00070\u00030\u0002\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\"\u0010#J.\u0010\b\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004j\u0002`\u00070\u00030\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJB\u0010\u000f\u001a\u00020\u00002&\b\u0002\u0010\r\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004j\u0002`\u00070\u00030\u00022\b\b\u0002\u0010\u000e\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR7\u0010\r\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004j\u0002`\u00070\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\tR\u0019\u0010\u000e\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\f¨\u0006$"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State$FirstPageLoaded;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;", "Lio/reactivex/Observable;", "", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageAndMetaInfo;", "component1", "()Lio/reactivex/Observable;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$PaginationState;", "component2", "()Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$PaginationState;", "firstPageMessagesAndMetaInfoObservable", "paginationState", "copy", "(Lio/reactivex/Observable;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$PaginationState;)Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State$FirstPageLoaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lio/reactivex/Observable;", "getFirstPageMessagesAndMetaInfoObservable", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$PaginationState;", "getPaginationState", "<init>", "(Lio/reactivex/Observable;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$PaginationState;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class FirstPageLoaded extends State {
            @NotNull
            public final Observable<List<Pair<LocalMessage, MessageMetaInfo>>> a;
            @NotNull
            public final PaginationState b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public FirstPageLoaded(@NotNull Observable<List<Pair<LocalMessage, MessageMetaInfo>>> observable, @NotNull PaginationState paginationState) {
                super(null);
                Intrinsics.checkNotNullParameter(observable, "firstPageMessagesAndMetaInfoObservable");
                Intrinsics.checkNotNullParameter(paginationState, "paginationState");
                this.a = observable;
                this.b = paginationState;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor$State$FirstPageLoaded */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ FirstPageLoaded copy$default(FirstPageLoaded firstPageLoaded, Observable observable, PaginationState paginationState, int i, Object obj) {
                if ((i & 1) != 0) {
                    observable = firstPageLoaded.a;
                }
                if ((i & 2) != 0) {
                    paginationState = firstPageLoaded.b;
                }
                return firstPageLoaded.copy(observable, paginationState);
            }

            @NotNull
            public final Observable<List<Pair<LocalMessage, MessageMetaInfo>>> component1() {
                return this.a;
            }

            @NotNull
            public final PaginationState component2() {
                return this.b;
            }

            @NotNull
            public final FirstPageLoaded copy(@NotNull Observable<List<Pair<LocalMessage, MessageMetaInfo>>> observable, @NotNull PaginationState paginationState) {
                Intrinsics.checkNotNullParameter(observable, "firstPageMessagesAndMetaInfoObservable");
                Intrinsics.checkNotNullParameter(paginationState, "paginationState");
                return new FirstPageLoaded(observable, paginationState);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof FirstPageLoaded)) {
                    return false;
                }
                FirstPageLoaded firstPageLoaded = (FirstPageLoaded) obj;
                return Intrinsics.areEqual(this.a, firstPageLoaded.a) && Intrinsics.areEqual(this.b, firstPageLoaded.b);
            }

            @NotNull
            public final Observable<List<Pair<LocalMessage, MessageMetaInfo>>> getFirstPageMessagesAndMetaInfoObservable() {
                return this.a;
            }

            @NotNull
            public final PaginationState getPaginationState() {
                return this.b;
            }

            public int hashCode() {
                Observable<List<Pair<LocalMessage, MessageMetaInfo>>> observable = this.a;
                int i = 0;
                int hashCode = (observable != null ? observable.hashCode() : 0) * 31;
                PaginationState paginationState = this.b;
                if (paginationState != null) {
                    i = paginationState.hashCode();
                }
                return hashCode + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("FirstPageLoaded(firstPageMessagesAndMetaInfoObservable=");
                L.append(this.a);
                L.append(", paginationState=");
                L.append(this.b);
                L.append(")");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State$FirstPageLoadingInProgress;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class FirstPageLoadingInProgress extends State {
            @NotNull
            public static final FirstPageLoadingInProgress INSTANCE = new FirstPageLoadingInProgress();

            public FirstPageLoadingInProgress() {
                super(null);
            }

            @NotNull
            public String toString() {
                return "FirstPageLoadingInProgress";
            }
        }

        public State() {
        }

        public State(j jVar) {
        }
    }

    void loadFirstPage(@NotNull String str);

    void loadPrevPage(@NotNull String str);
}
