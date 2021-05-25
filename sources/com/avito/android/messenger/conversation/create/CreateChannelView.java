package com.avito.android.messenger.conversation.create;

import a2.g.r.g;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.ChannelProgressOverlay;
import com.avito.android.messenger.conversation.create.CreateChannelPresenter;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001e\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001f\u001a\n \u000e*\u0004\u0018\u00010\u001c0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006/"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelView;", "", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State;", "state", "", "render", "(Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State;)V", "destroy", "()V", "Landroid/view/View;", "h", "Landroid/view/View;", "rootView", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "Landroid/view/ViewGroup;", "contentHolder", "Lio/reactivex/Observable;", "f", "Lio/reactivex/Observable;", "getRetryClicks", "()Lio/reactivex/Observable;", "retryClicks", "Ljava/lang/Runnable;", "e", "Ljava/lang/Runnable;", "showLoadingRunnable", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lcom/avito/android/messenger/conversation/ChannelProgressOverlay;", "d", "Lcom/avito/android/messenger/conversation/ChannelProgressOverlay;", "progressOverlay", "Lcom/avito/android/messenger/conversation/create/CreateChannelRouter;", g.a, "Lcom/avito/android/messenger/conversation/create/CreateChannelRouter;", "router", "c", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State;", "renderedState", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/messenger/conversation/create/CreateChannelRouter;Landroid/view/View;Lcom/avito/android/analytics/Analytics;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class CreateChannelView {
    public final Context a;
    public final ViewGroup b;
    public CreateChannelPresenter.State c;
    public final ChannelProgressOverlay d;
    public final Runnable e = new b(this);
    @NotNull
    public final Observable<Unit> f;
    public final CreateChannelRouter g;
    public final View h;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ CreateChannelView a;

        public a(CreateChannelView createChannelView) {
            this.a = createChannelView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.a.d.showLoading();
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ CreateChannelView a;

        public b(CreateChannelView createChannelView) {
            this.a = createChannelView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.d.showLoading();
        }
    }

    public CreateChannelView(@NotNull CreateChannelRouter createChannelRouter, @NotNull View view, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(createChannelRouter, "router");
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.g = createChannelRouter;
        this.h = view;
        this.a = view.getContext();
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.messenger_create_channel_screen);
        this.b = viewGroup;
        Intrinsics.checkNotNullExpressionValue(viewGroup, "contentHolder");
        ChannelProgressOverlay channelProgressOverlay = new ChannelProgressOverlay(viewGroup, analytics);
        this.d = channelProgressOverlay;
        Observable<Unit> doAfterNext = channelProgressOverlay.refreshes().debounce(200, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).doAfterNext(new a(this));
        Intrinsics.checkNotNullExpressionValue(doAfterNext, "progressOverlay.refreshe…ssOverlay.showLoading() }");
        this.f = doAfterNext;
    }

    public final void destroy() {
        this.h.removeCallbacks(this.e);
    }

    @NotNull
    public final Observable<Unit> getRetryClicks() {
        return this.f;
    }

    public final void render(@NotNull CreateChannelPresenter.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (!Intrinsics.areEqual(state, this.c)) {
            if ((state instanceof CreateChannelPresenter.State.Empty) || (state instanceof CreateChannelPresenter.State.Waiting.CreateChannel)) {
                this.h.postDelayed(this.e, 600);
            } else if ((state instanceof CreateChannelPresenter.State.Waiting.Auth) || (state instanceof CreateChannelPresenter.State.Waiting.PhoneVerification)) {
                this.h.removeCallbacks(this.e);
                this.d.showContent();
            } else if (state instanceof CreateChannelPresenter.State.Created) {
                this.h.removeCallbacks(this.e);
                this.g.loadChannel(((CreateChannelPresenter.State.Created) state).getChannelId());
            } else if (state instanceof CreateChannelPresenter.State.Error) {
                this.h.removeCallbacks(this.e);
                if (Intrinsics.areEqual(state, CreateChannelPresenter.State.Error.AuthRequired.INSTANCE)) {
                    this.g.close(41);
                } else if (Intrinsics.areEqual(state, CreateChannelPresenter.State.Error.PhoneVerificationRequired.INSTANCE)) {
                    this.g.close(60);
                } else if (Intrinsics.areEqual(state, CreateChannelPresenter.State.Error.Forbidden.INSTANCE)) {
                    this.g.close(43);
                } else if (Intrinsics.areEqual(state, CreateChannelPresenter.State.Error.Network.INSTANCE)) {
                    ChannelProgressOverlay channelProgressOverlay = this.d;
                    String string = this.a.getString(com.avito.android.ui_components.R.string.connection_problem);
                    Intrinsics.checkNotNullExpressionValue(string, "context.getString(ui_R.string.connection_problem)");
                    channelProgressOverlay.showLoadingProblem(string);
                } else if (Intrinsics.areEqual(state, CreateChannelPresenter.State.Error.Unknown.INSTANCE)) {
                    ChannelProgressOverlay channelProgressOverlay2 = this.d;
                    String string2 = this.a.getString(com.avito.android.ui_components.R.string.something_went_wrong);
                    Intrinsics.checkNotNullExpressionValue(string2, "context.getString(ui_R.s…ing.something_went_wrong)");
                    channelProgressOverlay2.showLoadingProblem(string2);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
            this.c = state;
        }
    }
}
