package com.avito.android.messenger.conversation.mvi.send;

import a2.a.a.o1.d.a0.m.h;
import a2.g.r.g;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.avito.android.Features;
import com.avito.android.component.MessageInput;
import com.avito.android.lib.design.bottom_sheet.BottomSheetMenuDialog;
import com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.attach_menu.AttachMenu;
import com.avito.android.remote.model.messenger.attach_menu.AttachMenuItem;
import com.avito.android.util.GlobalAnimationsKt;
import com.avito.android.util.Views;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.functions.Predicate;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010H\u001a\u00020E¢\u0006\u0004\b^\u0010_J)\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001a\u001a\n \r*\u0004\u0018\u00010\u00170\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015R\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0013R\"\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010-\u001a\b\u0012\u0004\u0012\u00020*0 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b+\u0010\"\u001a\u0004\b,\u0010$R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\"\u00104\u001a\b\u0012\u0004\u0012\u00020*0 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b2\u0010\"\u001a\u0004\b3\u0010$R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\"\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00070\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b9\u0010\u0013\u001a\u0004\b:\u0010\u0015R\"\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00070 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b<\u0010\"\u001a\u0004\b=\u0010$R\u001d\u0010D\u001a\u00020?8B@\u0002X\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u001e\u0010J\u001a\n \r*\u0004\u0018\u000105058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u00107R\"\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00070 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bK\u0010\"\u001a\u0004\bL\u0010$R\"\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00070\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bN\u0010\u0013\u001a\u0004\bO\u0010\u0015R\u001e\u0010T\u001a\n \r*\u0004\u0018\u00010Q0Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u001e\u0010V\u001a\n \r*\u0004\u0018\u00010Q0Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010SR\u0016\u0010Y\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010\\¨\u0006`"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessageViewImpl;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessageView;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "prevState", "curState", "", "userChangedText", "", "render", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;Z)V", "clearText", "()V", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lcom/jakewharton/rxrelay2/Relay;", "p", "Lcom/jakewharton/rxrelay2/Relay;", "getAttachFileClicks", "()Lcom/jakewharton/rxrelay2/Relay;", "attachFileClicks", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", "r", "getAttachmentDialogDismissedStream", "attachmentDialogDismissedStream", "i", "attachImageClickRelay", "Lio/reactivex/Observable;", "n", "Lio/reactivex/Observable;", "getTouches", "()Lio/reactivex/Observable;", "touches", "Lcom/avito/android/component/MessageInput;", "d", "Lcom/avito/android/component/MessageInput;", "inputContainer", "", "k", "getMessageTextChangesByUser", "messageTextChangesByUser", "Landroid/app/Dialog;", "h", "Landroid/app/Dialog;", "attachMenuDialog", "j", "getSubmitButtonClicks", "submitButtonClicks", "Landroid/view/View;", "u", "Landroid/view/View;", "rootView", VKApiConst.Q, "getSendLocationClicks", "sendLocationClicks", AuthSource.OPEN_CHANNEL_LIST, "getAttachImageClicks", "attachImageClicks", "Landroid/animation/Animator;", g.a, "Lkotlin/Lazy;", "getOnboardingDotAnimator", "()Landroid/animation/Animator;", "onboardingDotAnimator", "Lcom/avito/android/Features;", VKApiConst.VERSION, "Lcom/avito/android/Features;", "features", "c", "layout", "l", "getAttachButtonClicks", "attachButtonClicks", "o", "getAttachItemClicks", "attachItemClicks", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "onboardingDynamicDot", "e", "onboardingStaticDot", "t", "Z", "ignoreTextChange", "", "s", "I", "bottomSheetPeekHeight", "<init>", "(Landroid/view/View;Lcom/avito/android/Features;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SendMessageViewImpl implements SendMessageView {
    public final Context a;
    public final Resources b;
    public final View c;
    public final MessageInput d;
    public final ImageView e;
    public final ImageView f;
    public final Lazy g = t6.c.lazy(new c(this));
    public Dialog h;
    public final Relay<Unit> i;
    @NotNull
    public final Observable<String> j;
    @NotNull
    public final Observable<String> k;
    @NotNull
    public final Observable<Unit> l;
    @NotNull
    public final Observable<Unit> m;
    @NotNull
    public final Observable<Unit> n;
    @NotNull
    public final Relay<Unit> o;
    @NotNull
    public final Relay<Unit> p;
    @NotNull
    public final Relay<Unit> q;
    @NotNull
    public final Relay<Unit> r;
    public int s;
    public boolean t;
    public final View u;
    public final Features v;

    public static final class a<T> implements Predicate<CharSequence> {
        public final /* synthetic */ SendMessageViewImpl a;

        public a(SendMessageViewImpl sendMessageViewImpl) {
            this.a = sendMessageViewImpl;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "it");
            if (!this.a.t) {
                return true;
            }
            this.a.t = false;
            return false;
        }
    }

    public static final class c extends Lambda implements Function0<Animator> {
        public final /* synthetic */ SendMessageViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SendMessageViewImpl sendMessageViewImpl) {
            super(0);
            this.a = sendMessageViewImpl;
        }

        @Override // kotlin.jvm.functions.Function0
        public Animator invoke() {
            SendMessageViewImpl sendMessageViewImpl = this.a;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(sendMessageViewImpl.f, "scaleX", 1.0f, 3.0f, 3.0f, 3.0f);
            ofFloat.setDuration(3000L);
            GlobalAnimationsKt.setSafeRepeatCount(ofFloat, -1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(sendMessageViewImpl.f, "scaleY", 1.0f, 3.0f, 3.0f, 3.0f);
            ofFloat2.setDuration(3000L);
            GlobalAnimationsKt.setSafeRepeatCount(ofFloat2, -1);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(sendMessageViewImpl.f, "alpha", 0.5f, 0.0f, 0.0f, 0.0f);
            ofFloat3.setDuration(3000L);
            GlobalAnimationsKt.setSafeRepeatCount(ofFloat3, -1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
            return animatorSet;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [a2.a.a.o1.d.a0.m.i] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SendMessageViewImpl(@org.jetbrains.annotations.NotNull android.view.View r3, @org.jetbrains.annotations.NotNull com.avito.android.Features r4) {
        /*
            r2 = this;
            java.lang.String r0 = "rootView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "features"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r2.<init>()
            r2.u = r3
            r2.v = r4
            android.content.Context r4 = r3.getContext()
            r2.a = r4
            android.content.res.Resources r4 = r3.getResources()
            r2.b = r4
            int r4 = com.avito.android.messenger.R.id.input_container
            android.view.View r4 = r3.findViewById(r4)
            r2.c = r4
            com.avito.android.component.MessageInput$Companion r0 = com.avito.android.component.MessageInput.Companion
            java.lang.String r1 = "layout"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            com.avito.android.component.MessageInput r4 = r0.create(r4)
            r2.d = r4
            int r0 = com.avito.android.ui_components.R.id.attachment_button_onboarding_static_dot
            android.view.View r0 = r3.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r2.e = r0
            int r0 = com.avito.android.ui_components.R.id.attachment_button_onboarding_dynamic_dot
            android.view.View r3 = r3.findViewById(r0)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r2.f = r3
            com.avito.android.messenger.conversation.mvi.send.SendMessageViewImpl$c r3 = new com.avito.android.messenger.conversation.mvi.send.SendMessageViewImpl$c
            r3.<init>(r2)
            kotlin.Lazy r3 = t6.c.lazy(r3)
            r2.g = r3
            java.lang.String r3 = "PublishRelay.create<T>().toSerialized()"
            com.jakewharton.rxrelay2.Relay r3 = a2.b.a.a.a.J1(r3)
            r2.i = r3
            io.reactivex.rxjava3.core.Observable r0 = r4.getSubmitButtonClicks()
            io.reactivex.Observable r0 = com.avito.android.util.rx3.InteropKt.toV2(r0)
            r2.j = r0
            io.reactivex.rxjava3.core.Observable r0 = r4.getAttachmentButtonClicks()
            io.reactivex.Observable r0 = com.avito.android.util.rx3.InteropKt.toV2(r0)
            r2.l = r0
            io.reactivex.rxjava3.core.Observable r0 = r4.getPhotoButtonClicks()
            io.reactivex.Observable r0 = com.avito.android.util.rx3.InteropKt.toV2(r0)
            io.reactivex.Observable r3 = r0.mergeWith(r3)
            java.lang.String r0 = "inputContainer.photoButt…th(attachImageClickRelay)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r2.m = r3
            io.reactivex.rxjava3.core.Observable r3 = r4.getTouches()
            io.reactivex.Observable r3 = com.avito.android.util.rx3.InteropKt.toV2(r3)
            r2.n = r3
            com.jakewharton.rxrelay2.PublishRelay r3 = com.jakewharton.rxrelay2.PublishRelay.create()
            java.lang.String r0 = "PublishRelay.create()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r2.o = r3
            com.jakewharton.rxrelay2.PublishRelay r3 = com.jakewharton.rxrelay2.PublishRelay.create()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r2.p = r3
            com.jakewharton.rxrelay2.PublishRelay r3 = com.jakewharton.rxrelay2.PublishRelay.create()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r2.q = r3
            com.jakewharton.rxrelay2.PublishRelay r3 = com.jakewharton.rxrelay2.PublishRelay.create()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r2.r = r3
            r3 = -1
            r2.s = r3
            io.reactivex.rxjava3.core.Observable r3 = r4.getTextChanges()
            io.reactivex.Observable r3 = com.avito.android.util.rx3.InteropKt.toV2(r3)
            r0 = 1
            io.reactivex.Observable r3 = r3.skip(r0)
            com.avito.android.messenger.conversation.mvi.send.SendMessageViewImpl$a r4 = new com.avito.android.messenger.conversation.mvi.send.SendMessageViewImpl$a
            r4.<init>(r2)
            io.reactivex.Observable r3 = r3.filter(r4)
            com.avito.android.messenger.conversation.mvi.send.SendMessageViewImpl$b r4 = com.avito.android.messenger.conversation.mvi.send.SendMessageViewImpl.b.a
            if (r4 == 0) goto L_0x00d4
            a2.a.a.o1.d.a0.m.i r0 = new a2.a.a.o1.d.a0.m.i
            r0.<init>(r4)
            r4 = r0
        L_0x00d4:
            io.reactivex.functions.Function r4 = (io.reactivex.functions.Function) r4
            io.reactivex.Observable r3 = r3.map(r4)
            java.lang.String r4 = "inputContainer.textChang…p(CharSequence::toString)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r2.k = r3
            android.view.View r3 = access$getRootView$p(r2)
            android.view.ViewTreeObserver r3 = r3.getViewTreeObserver()
            com.avito.android.messenger.conversation.mvi.send.SendMessageViewImpl$initializeBottomSheetPeekHeight$1 r4 = new com.avito.android.messenger.conversation.mvi.send.SendMessageViewImpl$initializeBottomSheetPeekHeight$1
            r4.<init>()
            r3.addOnGlobalLayoutListener(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.send.SendMessageViewImpl.<init>(android.view.View, com.avito.android.Features):void");
    }

    public static final Animator access$createOnboardingDotAnimator(SendMessageViewImpl sendMessageViewImpl) {
        Objects.requireNonNull(sendMessageViewImpl);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(sendMessageViewImpl.f, "scaleX", 1.0f, 3.0f, 3.0f, 3.0f);
        ofFloat.setDuration(3000L);
        GlobalAnimationsKt.setSafeRepeatCount(ofFloat, -1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(sendMessageViewImpl.f, "scaleY", 1.0f, 3.0f, 3.0f, 3.0f);
        ofFloat2.setDuration(3000L);
        GlobalAnimationsKt.setSafeRepeatCount(ofFloat2, -1);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(sendMessageViewImpl.f, "alpha", 0.5f, 0.0f, 0.0f, 0.0f);
        ofFloat3.setDuration(3000L);
        GlobalAnimationsKt.setSafeRepeatCount(ofFloat3, -1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        return animatorSet;
    }

    public static final boolean access$getFileSharingOnboardingIsShown$p(SendMessageViewImpl sendMessageViewImpl, Map map) {
        Objects.requireNonNull(sendMessageViewImpl);
        return ((OnboardingState) map.get(Onboarding.FileSharing)) != OnboardingState.HIDDEN;
    }

    public static final Animator access$getOnboardingDotAnimator$p(SendMessageViewImpl sendMessageViewImpl) {
        return (Animator) sendMessageViewImpl.g.getValue();
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessageView
    public void clearText() {
        this.d.clearText();
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessageView
    @NotNull
    public Observable<Unit> getAttachButtonClicks() {
        return this.l;
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessageView
    @NotNull
    public Observable<Unit> getAttachImageClicks() {
        return this.m;
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessageView
    @NotNull
    public Observable<String> getMessageTextChangesByUser() {
        return this.k;
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessageView
    @NotNull
    public Observable<String> getSubmitButtonClicks() {
        return this.j;
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessageView
    @NotNull
    public Observable<Unit> getTouches() {
        return this.n;
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessageView
    public void render(@Nullable SendMessagePresenter.State state, @NotNull SendMessagePresenter.State state2, boolean z) {
        Intrinsics.checkNotNullParameter(state2, "curState");
        boolean z2 = false;
        AttachMenuItem.File file = null;
        if (Intrinsics.areEqual(state2.getContextIsReady(), Boolean.TRUE) && state2.getDraftText() != null) {
            this.d.setPhotoEnabled(state2.getPhotoEnabled());
            this.d.setAttachmentButtonState(state2.getAttachButtonState());
            if (!z) {
                String draftText = state2.getDraftText();
                if (!(draftText == null || m.isBlank(draftText))) {
                    this.t = true;
                    this.d.setText(state2.getDraftText(), false);
                }
            }
            this.d.show();
            if (state2.getAttachMenuIsShown()) {
                Dialog dialog = this.h;
                if (dialog == null || !dialog.isShowing()) {
                    AttachMenu dynamicAttachMenu = state2.getDynamicAttachMenu();
                    Map<Onboarding, OnboardingState> onboardingStates = state2.getOnboardingStates();
                    Context context = this.a;
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    this.h = new BottomSheetMenuDialog(context, new h(this, dynamicAttachMenu, onboardingStates));
                }
            } else {
                Dialog dialog2 = this.h;
                if (dialog2 != null) {
                    dialog2.dismiss();
                }
                this.h = null;
            }
            if (this.v.getMessengerDynamicAttachMenu().invoke().booleanValue()) {
                AttachMenu dynamicAttachMenu2 = state2.getDynamicAttachMenu();
                if (dynamicAttachMenu2 != null) {
                    file = dynamicAttachMenu2.getFile();
                }
                if (file != null) {
                    if (state2.getOnboardingStates().get(Onboarding.FileSharing) != OnboardingState.HIDDEN) {
                        z2 = true;
                    }
                    if (z2) {
                        Views.show(this.e);
                        ImageView imageView = this.f;
                        Intrinsics.checkNotNullExpressionValue(imageView, "onboardingDynamicDot");
                        if (!imageView.isShown()) {
                            Views.show(this.f);
                        }
                        if (!access$getOnboardingDotAnimator$p(this).isStarted()) {
                            access$getOnboardingDotAnimator$p(this).start();
                            return;
                        }
                        return;
                    }
                }
            }
            if (access$getOnboardingDotAnimator$p(this).isStarted()) {
                access$getOnboardingDotAnimator$p(this).cancel();
            }
            Views.hide(this.e);
            Views.hide(this.f);
            return;
        }
        this.d.hide();
        Dialog dialog3 = this.h;
        if (dialog3 != null) {
            dialog3.dismiss();
        }
        this.h = null;
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessageView
    @NotNull
    public Relay<Unit> getAttachFileClicks() {
        return this.p;
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessageView
    @NotNull
    public Relay<Unit> getAttachItemClicks() {
        return this.o;
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessageView
    @NotNull
    public Relay<Unit> getAttachmentDialogDismissedStream() {
        return this.r;
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessageView
    @NotNull
    public Relay<Unit> getSendLocationClicks() {
        return this.q;
    }
}
