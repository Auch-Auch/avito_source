package com.avito.android.messenger.conversation.mvi.message_menu;

import a2.a.a.o1.d.a0.h.d;
import a2.g.r.g;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.avito.android.lib.design.bottom_sheet.BottomSheetMenuDialog;
import com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer;
import com.avito.android.messenger.conversation.confirmation_dialog.ConfirmationDialogView;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BackingField;
import com.avito.android.util.Views;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import kotlin.Metadata;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102J+\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001e\u0010\u0016\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R9\u0010\u001e\u001a\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00038V@VX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\"\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b%\u0010\rR\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-¨\u00063"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuViewImpl;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuView;", "Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "prevState", "curState", "", "doRender", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;)V", "Lcom/jakewharton/rxrelay2/Relay;", "c", "Lcom/jakewharton/rxrelay2/Relay;", "getActionConfirmedStream", "()Lcom/jakewharton/rxrelay2/Relay;", "actionConfirmedStream", "d", "getDismissStream", "dismissStream", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<set-?>", "e", "Lkotlin/properties/ReadWriteProperty;", "getLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "setLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;)V", "lastRenderedState", "Landroid/app/Dialog;", "h", "Landroid/app/Dialog;", "menuDialog", "", AuthSource.BOOKING_ORDER, "getActionClickStream", "actionClickStream", "Lcom/avito/android/messenger/conversation/confirmation_dialog/ConfirmationDialogView;", "f", "Lcom/avito/android/messenger/conversation/confirmation_dialog/ConfirmationDialogView;", "confirmationDialog", "", g.a, "I", "bottomSheetPeekHeight", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageMenuViewImpl implements MessageMenuView {
    public static final /* synthetic */ KProperty[] i = {Reflection.mutableProperty2(new MutablePropertyReference2Impl(MessageMenuViewImpl.class, "lastRenderedState", "getLastRenderedState(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", 0))};
    public final Context a;
    @NotNull
    public final Relay<String> b;
    @NotNull
    public final Relay<Unit> c;
    @NotNull
    public final Relay<Unit> d;
    @Nullable
    public final ReadWriteProperty e = new BackingField(null);
    public final ConfirmationDialogView f;
    public int g;
    public Dialog h;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                Relay<Unit> actionConfirmedStream = ((MessageMenuViewImpl) this.b).getActionConfirmedStream();
                Unit unit = Unit.INSTANCE;
                actionConfirmedStream.accept(unit);
                return unit;
            } else if (i == 1) {
                Relay<Unit> dismissStream = ((MessageMenuViewImpl) this.b).getDismissStream();
                Unit unit2 = Unit.INSTANCE;
                dismissStream.accept(unit2);
                return unit2;
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MessageMenuViewImpl a;
        public final /* synthetic */ View b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MessageMenuViewImpl messageMenuViewImpl, View view) {
            super(0);
            this.a = messageMenuViewImpl;
            this.b = view;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.g = (this.b.getMeasuredHeight() * 2) / 3;
            return Unit.INSTANCE;
        }
    }

    public MessageMenuViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        Context context = view.getContext();
        this.a = context;
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.b = create;
        PublishRelay create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.c = create2;
        PublishRelay create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        this.d = create3;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.f = new ConfirmationDialogView(context);
        this.g = -1;
        Views.runOnGlobalLayout(view, new b(this, view));
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer
    @Nullable
    public MessageMenuPresenter.State getLastRenderedState(@NotNull Renderer<MessageMenuPresenter.State> renderer) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        return (MessageMenuPresenter.State) this.e.getValue(renderer, i[0]);
    }

    public void render(@NotNull MessageMenuPresenter.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        MessageMenuView.DefaultImpls.render(this, state);
    }

    public void setLastRenderedState(@NotNull Renderer<MessageMenuPresenter.State> renderer, @Nullable MessageMenuPresenter.State state) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        this.e.setValue(renderer, i[0], state);
    }

    public void doRender(@NotNull Renderer<MessageMenuPresenter.State> renderer, @Nullable MessageMenuPresenter.State state, @NotNull MessageMenuPresenter.State state2) {
        Intrinsics.checkNotNullParameter(renderer, "$this$doRender");
        Intrinsics.checkNotNullParameter(state2, "curState");
        if (Intrinsics.areEqual(state2, MessageMenuPresenter.State.Empty.INSTANCE) || (state2 instanceof MessageMenuPresenter.State.Hidden)) {
            this.f.dismiss();
            Dialog dialog = this.h;
            if (dialog != null) {
                dialog.dismiss();
            }
        } else if (state2 instanceof MessageMenuPresenter.State.Shown.Menu) {
            Dialog dialog2 = this.h;
            if (dialog2 != null) {
                dialog2.dismiss();
            }
            this.f.dismiss();
            Context context = this.a;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this.h = new BottomSheetMenuDialog(context, new d(this, (MessageMenuPresenter.State.Shown.Menu) state2));
        } else if (state2 instanceof MessageMenuPresenter.State.Shown.Confirmation) {
            Dialog dialog3 = this.h;
            if (dialog3 != null) {
                dialog3.dismiss();
            }
            this.f.dismiss();
            this.f.show(((MessageMenuPresenter.State.Shown.Confirmation) state2).getConfirmation(), new a(0, this), new a(1, this));
        }
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuView
    @NotNull
    public Relay<String> getActionClickStream() {
        return this.b;
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuView
    @NotNull
    public Relay<Unit> getActionConfirmedStream() {
        return this.c;
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuView
    @NotNull
    public Relay<Unit> getDismissStream() {
        return this.d;
    }
}
