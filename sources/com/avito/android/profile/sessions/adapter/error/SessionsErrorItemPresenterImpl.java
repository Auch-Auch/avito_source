package com.avito.android.profile.sessions.adapter.error;

import com.avito.android.profile.sessions.adapter.action.SessionsItemAction;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/profile/sessions/adapter/error/SessionsErrorItemPresenterImpl;", "Lcom/avito/android/profile/sessions/adapter/error/SessionsErrorItemPresenter;", "Lcom/avito/android/profile/sessions/adapter/error/SessionsErrorItemView;", "view", "Lcom/avito/android/profile/sessions/adapter/error/SessionsErrorItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/profile/sessions/adapter/error/SessionsErrorItemView;Lcom/avito/android/profile/sessions/adapter/error/SessionsErrorItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/profile/sessions/adapter/action/SessionsItemAction;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "clicksConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SessionsErrorItemPresenterImpl implements SessionsErrorItemPresenter {
    public final Consumer<SessionsItemAction> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SessionsErrorItemPresenterImpl a;
        public final /* synthetic */ SessionsErrorItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SessionsErrorItemPresenterImpl sessionsErrorItemPresenterImpl, SessionsErrorItem sessionsErrorItem) {
            super(0);
            this.a = sessionsErrorItemPresenterImpl;
            this.b = sessionsErrorItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(new SessionsItemAction.RetryOnErrorAction(this.b.getFromTimestamp()));
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SessionsErrorItemView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SessionsErrorItemView sessionsErrorItemView) {
            super(0);
            this.a = sessionsErrorItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.setRefreshListener(null);
            this.a.setUnbindListener(null);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public SessionsErrorItemPresenterImpl(@NotNull Consumer<SessionsItemAction> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "clicksConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull SessionsErrorItemView sessionsErrorItemView, @NotNull SessionsErrorItem sessionsErrorItem, int i) {
        Intrinsics.checkNotNullParameter(sessionsErrorItemView, "view");
        Intrinsics.checkNotNullParameter(sessionsErrorItem, "item");
        sessionsErrorItemView.setMessage(sessionsErrorItem.getMessage());
        sessionsErrorItemView.setRefreshListener(new a(this, sessionsErrorItem));
        sessionsErrorItemView.setUnbindListener(new b(sessionsErrorItemView));
    }
}
