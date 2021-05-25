package com.avito.android.profile.sessions.adapter.session;

import com.avito.android.profile.sessions.adapter.action.SessionsItemAction;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/profile/sessions/adapter/session/SessionItemPresenterImpl;", "Lcom/avito/android/profile/sessions/adapter/session/SessionItemPresenter;", "Lcom/avito/android/profile/sessions/adapter/session/SessionItemView;", "view", "Lcom/avito/android/profile/sessions/adapter/session/SessionItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/profile/sessions/adapter/session/SessionItemView;Lcom/avito/android/profile/sessions/adapter/session/SessionItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/profile/sessions/adapter/action/SessionsItemAction;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "clicksConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SessionItemPresenterImpl implements SessionItemPresenter {
    public final Consumer<SessionsItemAction> a;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ SessionItemView a;
        public final /* synthetic */ SessionItemPresenterImpl b;
        public final /* synthetic */ SessionItem c;
        public final /* synthetic */ SessionItemView d;

        public a(SessionItemView sessionItemView, SessionItemPresenterImpl sessionItemPresenterImpl, SessionItem sessionItem, SessionItemView sessionItemView2) {
            this.a = sessionItemView;
            this.b = sessionItemPresenterImpl;
            this.c = sessionItem;
            this.d = sessionItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: io.reactivex.rxjava3.functions.Consumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.b.a.accept(new SessionsItemAction.MoreButtonClickAction(this.c));
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Disposable a;
        public final /* synthetic */ SessionItemView b;
        public final /* synthetic */ SessionItemView c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Disposable disposable, SessionItemView sessionItemView, SessionItemPresenterImpl sessionItemPresenterImpl, SessionItem sessionItem, SessionItemView sessionItemView2) {
            super(0);
            this.a = disposable;
            this.b = sessionItemView;
            this.c = sessionItemView2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Disposable disposable = this.a;
            if (disposable != null) {
                disposable.dispose();
            }
            this.b.setUnbindListener(null);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public SessionItemPresenterImpl(@NotNull Consumer<SessionsItemAction> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "clicksConsumer");
        this.a = consumer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0036, code lost:
        if ((r10 == null || r10.isEmpty()) == false) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindView(@org.jetbrains.annotations.NotNull com.avito.android.profile.sessions.adapter.session.SessionItemView r8, @org.jetbrains.annotations.NotNull com.avito.android.profile.sessions.adapter.session.SessionItem r9, int r10) {
        /*
            r7 = this;
            java.lang.String r10 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r10)
            java.lang.String r10 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r10)
            java.lang.String r10 = r9.getTitle()
            r8.setTitle(r10)
            java.lang.String r10 = r9.getSubtitle()
            r8.setDescription(r10)
            java.lang.Boolean r10 = r9.isCurrent()
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r0)
            r0 = 1
            r1 = 0
            if (r10 != 0) goto L_0x0039
            java.util.List r10 = r9.getActions()
            if (r10 == 0) goto L_0x0035
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r10 = 0
            goto L_0x0036
        L_0x0035:
            r10 = 1
        L_0x0036:
            if (r10 != 0) goto L_0x0039
            goto L_0x003a
        L_0x0039:
            r0 = 0
        L_0x003a:
            r8.setMoreButtonVisibility(r0)
            io.reactivex.rxjava3.core.Observable r10 = r8.getMoreButtonClicks()
            com.avito.android.profile.sessions.adapter.session.SessionItemPresenterImpl$a r0 = new com.avito.android.profile.sessions.adapter.session.SessionItemPresenterImpl$a
            r0.<init>(r8, r7, r9, r8)
            io.reactivex.rxjava3.disposables.Disposable r2 = r10.subscribe(r0)
            com.avito.android.profile.sessions.adapter.session.SessionItemPresenterImpl$b r10 = new com.avito.android.profile.sessions.adapter.session.SessionItemPresenterImpl$b
            r1 = r10
            r3 = r8
            r4 = r7
            r5 = r9
            r6 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            r8.setUnbindListener(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.profile.sessions.adapter.session.SessionItemPresenterImpl.bindView(com.avito.android.profile.sessions.adapter.session.SessionItemView, com.avito.android.profile.sessions.adapter.session.SessionItem, int):void");
    }
}
