package com.avito.android.search.map.action;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchSubscription;
import com.avito.android.remote.model.SubscriptionResult;
import com.avito.android.util.LoadingState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/SubscriptionAction;", "Lcom/avito/android/search/map/action/MapAction;", "<init>", "()V", "LoadSubscriptionAction", "LoadUnsubscriptionAction", "ShowSubscriptionAction", "Lcom/avito/android/search/map/action/SubscriptionAction$ShowSubscriptionAction;", "Lcom/avito/android/search/map/action/SubscriptionAction$LoadSubscriptionAction;", "Lcom/avito/android/search/map/action/SubscriptionAction$LoadUnsubscriptionAction;", "map_release"}, k = 1, mv = {1, 4, 2})
public abstract class SubscriptionAction implements MapAction {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/search/map/action/SubscriptionAction$LoadSubscriptionAction;", "Lcom/avito/android/search/map/action/SubscriptionAction;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/SearchSubscription;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/LoadingState;", "getState", "()Lcom/avito/android/util/LoadingState;", "state", "<init>", "(Lcom/avito/android/util/LoadingState;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class LoadSubscriptionAction extends SubscriptionAction {
        @NotNull
        public final LoadingState<SearchSubscription> a;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.android.util.LoadingState<? super com.avito.android.remote.model.SearchSubscription> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoadSubscriptionAction(@NotNull LoadingState<? super SearchSubscription> loadingState) {
            super(null);
            Intrinsics.checkNotNullParameter(loadingState, "state");
            this.a = loadingState;
        }

        @NotNull
        public final LoadingState<SearchSubscription> getState() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/search/map/action/SubscriptionAction$LoadUnsubscriptionAction;", "Lcom/avito/android/search/map/action/SubscriptionAction;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/SubscriptionResult;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/LoadingState;", "getState", "()Lcom/avito/android/util/LoadingState;", "state", "<init>", "(Lcom/avito/android/util/LoadingState;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class LoadUnsubscriptionAction extends SubscriptionAction {
        @NotNull
        public final LoadingState<SubscriptionResult> a;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.android.util.LoadingState<? super com.avito.android.remote.model.SubscriptionResult> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoadUnsubscriptionAction(@NotNull LoadingState<? super SubscriptionResult> loadingState) {
            super(null);
            Intrinsics.checkNotNullParameter(loadingState, "state");
            this.a = loadingState;
        }

        @NotNull
        public final LoadingState<SubscriptionResult> getState() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/SubscriptionAction$ShowSubscriptionAction;", "Lcom/avito/android/search/map/action/SubscriptionAction;", "", AuthSource.SEND_ABUSE, "Z", "getSubscribe", "()Z", "subscribe", "<init>", "(Z)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class ShowSubscriptionAction extends SubscriptionAction {
        public final boolean a;

        public ShowSubscriptionAction(boolean z) {
            super(null);
            this.a = z;
        }

        public final boolean getSubscribe() {
            return this.a;
        }
    }

    public SubscriptionAction() {
    }

    public SubscriptionAction(j jVar) {
    }
}
