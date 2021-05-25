package com.avito.android.messenger.conversation.mvi.menu;

import a2.a.a.o1.d.a0.g.e;
import a2.g.r.g;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.avito.android.analytics.Analytics;
import com.avito.android.lib.design.bottom_sheet.BottomSheetMenuDialog;
import com.avito.android.messenger.R;
import com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer;
import com.avito.android.messenger.conversation.confirmation_dialog.ConfirmationDialogView;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BackingField;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.Views;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u00101\u001a\u00020.¢\u0006\u0004\b8\u00109J+\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR9\u0010\u0012\u001a\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00038V@VX\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001b\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060(8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00107\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u0010\"¨\u0006:"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuViewImpl;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView;", "Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;", "prevState", "curState", "", "doRender", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;)V", "destroyViews", "()V", "<set-?>", g.a, "Lkotlin/properties/ReadWriteProperty;", "getLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;)Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;", "setLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;)V", "lastRenderedState", "Lcom/avito/android/messenger/conversation/confirmation_dialog/ConfirmationDialogView;", "c", "Lcom/avito/android/messenger/conversation/confirmation_dialog/ConfirmationDialogView;", "confirmationDialog", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "Landroid/content/Context;", "context", "", "d", "I", "bottomSheetPeekHeight", "Landroid/app/Dialog;", "e", "Landroid/app/Dialog;", "dialog", "Lcom/avito/android/util/DialogRouter;", "i", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/jakewharton/rxrelay2/Relay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/Relay;", "getProfileClicks", "()Lcom/jakewharton/rxrelay2/Relay;", "profileClicks", "Lcom/avito/android/analytics/Analytics;", "j", "Lcom/avito/android/analytics/Analytics;", "analytics", "Landroid/view/View;", "h", "Landroid/view/View;", "rootView", "f", "menuDialog", "<init>", "(Landroid/view/View;Lcom/avito/android/util/DialogRouter;Lcom/avito/android/analytics/Analytics;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelMenuViewImpl implements ChannelMenuView {
    public static final /* synthetic */ KProperty[] k = {Reflection.mutableProperty2(new MutablePropertyReference2Impl(ChannelMenuViewImpl.class, "lastRenderedState", "getLastRenderedState(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;)Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;", 0))};
    @NotNull
    public final Relay<Unit> a;
    public final Context b;
    public final ConfirmationDialogView c;
    public int d = -1;
    public Dialog e;
    public Dialog f;
    @Nullable
    public final ReadWriteProperty g = new BackingField(null);
    public final View h;
    public final DialogRouter i;
    public final Analytics j;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ChannelMenuViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ChannelMenuViewImpl channelMenuViewImpl) {
            super(0);
            this.a = channelMenuViewImpl;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ChannelMenuViewImpl channelMenuViewImpl = this.a;
            channelMenuViewImpl.d = (channelMenuViewImpl.h.getMeasuredHeight() * 2) / 3;
            return Unit.INSTANCE;
        }
    }

    public ChannelMenuViewImpl(@NotNull View view, @NotNull DialogRouter dialogRouter, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.h = view;
        this.i = dialogRouter;
        this.j = analytics;
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
        Context context = view.getContext();
        this.b = context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.c = new ConfirmationDialogView(context);
        Views.runOnGlobalLayout(view, new a(this));
    }

    @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView
    public void destroyViews() {
        Dialog dialog = this.e;
        boolean z = false;
        if ((dialog != null && dialog.isShowing()) && dialog != null) {
            dialog.dismiss();
        }
        Dialog dialog2 = this.f;
        if (dialog2 != null && dialog2.isShowing()) {
            z = true;
        }
        if (z && dialog2 != null) {
            dialog2.dismiss();
        }
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer
    @Nullable
    public ChannelMenuView.State getLastRenderedState(@NotNull Renderer<ChannelMenuView.State> renderer) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        return (ChannelMenuView.State) this.g.getValue(renderer, k[0]);
    }

    public void render(@NotNull ChannelMenuView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        ChannelMenuView.DefaultImpls.render(this, state);
    }

    public void setLastRenderedState(@NotNull Renderer<ChannelMenuView.State> renderer, @Nullable ChannelMenuView.State state) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        this.g.setValue(renderer, k[0], state);
    }

    public void doRender(@NotNull Renderer<ChannelMenuView.State> renderer, @Nullable ChannelMenuView.State state, @NotNull ChannelMenuView.State state2) {
        BottomSheetMenuDialog bottomSheetMenuDialog;
        Intrinsics.checkNotNullParameter(renderer, "$this$doRender");
        Intrinsics.checkNotNullParameter(state2, "curState");
        boolean z = false;
        boolean z2 = true;
        if (Intrinsics.areEqual(state2, ChannelMenuView.State.Empty.INSTANCE)) {
            Dialog dialog = this.e;
            if ((dialog != null && dialog.isShowing()) && dialog != null) {
                dialog.dismiss();
            }
            Dialog dialog2 = this.f;
            if (dialog2 != null && dialog2.isShowing()) {
                z = true;
            }
            if (z && dialog2 != null) {
                dialog2.dismiss();
            }
        } else if (state2 instanceof ChannelMenuView.State.Hidden) {
            Dialog dialog3 = this.f;
            if (dialog3 != null && dialog3.isShowing()) {
                z = true;
            }
            if (z && dialog3 != null) {
                dialog3.dismiss();
            }
            this.f = null;
        } else if (state2 instanceof ChannelMenuView.State.Shown) {
            Dialog dialog4 = this.f;
            if (dialog4 == null || !dialog4.isShowing()) {
                z2 = false;
            }
            if (z2 && dialog4 != null) {
                dialog4.dismiss();
            }
            ChannelMenuView.State.Shown shown = (ChannelMenuView.State.Shown) state2;
            if (!shown.getMenu().getProfile().isEmpty() || !shown.getMenu().getActions().isEmpty()) {
                Context context = this.b;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                bottomSheetMenuDialog = new BottomSheetMenuDialog(context, new e(this, shown));
            } else {
                Context context2 = this.b;
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                ToastsKt.showToast$default(context2, R.string.messenger_profile_is_not_available, 0, 2, (Object) null);
                shown.getCloseListener().invoke();
                bottomSheetMenuDialog = null;
            }
            this.f = bottomSheetMenuDialog;
        }
        ChannelMenuView.DialogState dialogState = state2.getDialogState();
        if (dialogState instanceof ChannelMenuView.DialogState.Empty) {
            Dialog dialog5 = this.e;
            if (dialog5 != null) {
                dialog5.dismiss();
            }
            this.e = null;
        } else if (dialogState instanceof ChannelMenuView.DialogState.Show) {
            Dialog dialog6 = this.e;
            if (dialog6 != null) {
                dialog6.dismiss();
            }
            this.c.dismiss();
            ChannelMenuView.DialogState.Show show = (ChannelMenuView.DialogState.Show) dialogState;
            this.e = this.i.showCancelableNotifyingDialog(show.getTitle(), true, show.getMessage(), show.getNegativeButtonText(), show.getNegativeButtonListener(), show.getPositiveButtonText(), show.getPositiveButtonListener());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView
    @NotNull
    public Relay<Unit> getProfileClicks() {
        return this.a;
    }
}
