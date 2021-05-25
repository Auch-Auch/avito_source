package com.avito.android.profile.sessions.adapter.action;

import com.avito.android.profile.sessions.adapter.session.SessionItem;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/profile/sessions/adapter/action/SessionsItemAction;", "", "<init>", "()V", "LoadingNextAction", "MoreButtonClickAction", "RetryOnErrorAction", "Lcom/avito/android/profile/sessions/adapter/action/SessionsItemAction$MoreButtonClickAction;", "Lcom/avito/android/profile/sessions/adapter/action/SessionsItemAction$LoadingNextAction;", "Lcom/avito/android/profile/sessions/adapter/action/SessionsItemAction$RetryOnErrorAction;", "profile_release"}, k = 1, mv = {1, 4, 2})
public abstract class SessionsItemAction {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/profile/sessions/adapter/action/SessionsItemAction$LoadingNextAction;", "Lcom/avito/android/profile/sessions/adapter/action/SessionsItemAction;", "", AuthSource.SEND_ABUSE, "J", "getFromTimestamp", "()J", "fromTimestamp", "<init>", "(J)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class LoadingNextAction extends SessionsItemAction {
        public final long a;

        public LoadingNextAction(long j) {
            super(null);
            this.a = j;
        }

        public final long getFromTimestamp() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/profile/sessions/adapter/action/SessionsItemAction$MoreButtonClickAction;", "Lcom/avito/android/profile/sessions/adapter/action/SessionsItemAction;", "Lcom/avito/android/profile/sessions/adapter/session/SessionItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/profile/sessions/adapter/session/SessionItem;", "getItem", "()Lcom/avito/android/profile/sessions/adapter/session/SessionItem;", "item", "<init>", "(Lcom/avito/android/profile/sessions/adapter/session/SessionItem;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class MoreButtonClickAction extends SessionsItemAction {
        @NotNull
        public final SessionItem a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MoreButtonClickAction(@NotNull SessionItem sessionItem) {
            super(null);
            Intrinsics.checkNotNullParameter(sessionItem, "item");
            this.a = sessionItem;
        }

        @NotNull
        public final SessionItem getItem() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/profile/sessions/adapter/action/SessionsItemAction$RetryOnErrorAction;", "Lcom/avito/android/profile/sessions/adapter/action/SessionsItemAction;", "", AuthSource.SEND_ABUSE, "J", "getFromTimestamp", "()J", "fromTimestamp", "<init>", "(J)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class RetryOnErrorAction extends SessionsItemAction {
        public final long a;

        public RetryOnErrorAction(long j) {
            super(null);
            this.a = j;
        }

        public final long getFromTimestamp() {
            return this.a;
        }
    }

    public SessionsItemAction() {
    }

    public SessionsItemAction(j jVar) {
    }
}
