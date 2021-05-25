package com.avito.android.lib.design.bottom_sheet;

import a2.g.r.g;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.transition.Fade;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.util.Contexts;
import com.avito.android.util.TransitionDsl;
import com.avito.android.util.Views;
import com.vk.sdk.api.VKApiConst;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b#\u0018\u00002\u00020\u0001B\u0010\u0012\u0006\u0010m\u001a\u00020^¢\u0006\u0005\b\u0010\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\fJ3\u0010\u0014\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0006J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001b\u0010\u0017J\u001d\u0010\u001b\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u001cH\u0016¢\u0006\u0004\b\u001b\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001f\u0010\u0017J\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\u0006J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0011H\u0016¢\u0006\u0004\b#\u0010\u0017J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0011H\u0016¢\u0006\u0004\b%\u0010\u0017J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0011H\u0016¢\u0006\u0004\b'\u0010\u0017J\u000f\u0010(\u001a\u00020\u0004H\u0016¢\u0006\u0004\b(\u0010\bJ\u0017\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0002H\u0016¢\u0006\u0004\b*\u0010\u0006J\u0017\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0011H\u0016¢\u0006\u0004\b,\u0010\u0017J\u0019\u0010.\u001a\u00020\u00042\b\b\u0001\u0010-\u001a\u00020\u0002H\u0016¢\u0006\u0004\b.\u0010\u0006J\u0017\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0011H\u0016¢\u0006\u0004\b4\u0010\u0017J\u0017\u00105\u001a\u00020\u00042\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b5\u00102J\u0015\u00108\u001a\u00020\u00042\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0004H\u0016¢\u0006\u0004\b:\u0010\bR6\u0010B\u001a\u0016\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010;8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001e\u0010G\u001a\n D*\u0004\u0018\u00010C0C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u001e\u0010N\u001a\n D*\u0004\u0018\u00010K0K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u001e\u0010Q\u001a\n D*\u0004\u0018\u00010\n0\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u001e\u0010S\u001a\n D*\u0004\u0018\u00010\n0\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010PR\u001e\u0010U\u001a\n D*\u0004\u0018\u00010/0/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010TR6\u0010Y\u001a\u0016\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u0004\u0018\u00010;8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bV\u0010=\u001a\u0004\bW\u0010?\"\u0004\bX\u0010AR\u001e\u0010]\u001a\n D*\u0004\u0018\u00010Z0Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u001e\u0010a\u001a\n D*\u0004\u0018\u00010^0^8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u001e\u0010c\u001a\n D*\u0004\u0018\u00010C0C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010FR*\u0010i\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001c8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010\u001dR\u0016\u0010k\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010IR\u0016\u0010m\u001a\u00020^8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bl\u0010`R\u001e\u0010o\u001a\n D*\u0004\u0018\u00010\n0\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bn\u0010PR\u0016\u0010r\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u001e\u0010t\u001a\n D*\u0004\u0018\u00010^0^8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bs\u0010`R*\u0010x\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001c8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bu\u0010e\u001a\u0004\bv\u0010g\"\u0004\bw\u0010\u001dR*\u0010|\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001c8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\by\u0010e\u001a\u0004\bz\u0010g\"\u0004\b{\u0010\u001dR\u001e\u0010~\u001a\n D*\u0004\u0018\u00010\n0\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b}\u0010P¨\u0006\u0001"}, d2 = {"Lcom/avito/android/lib/design/bottom_sheet/TabletBottomSheetView;", "Lcom/avito/android/lib/design/bottom_sheet/ModalBottomSheetView;", "", "newState", "", AuthSource.SEND_ABUSE, "(I)V", "show", "()V", "dismiss", "Landroid/widget/FrameLayout;", "getContentView", "()Landroid/widget/FrameLayout;", "getFooterView", "", "title", "actionTitle", "", "showCloseButton", "showHeaderThumb", "setHeaderParams", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZ)V", "showActionButton", "(Z)V", "iconId", "setCloseButtonIcon", "cancelOnTouchOutside", "setCancelOnTouchOutside", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "manuallyDismiss", "setManualDismissOnCancelClick", "peekHeight", "setPeekHeight", "hideable", "setHideable", "active", "setActionButtonActive", "skipCollapsed", "setSkipCollapsed", Tracker.Events.CREATIVE_EXPAND, "thumbHeight", "setThumbLayoutHeight", PanelStateKt.PANEL_EXPANDED, "setForceExpandedState", "color", "setScrimBackgroundColor", "Landroid/view/View;", "view", "setCustomHeader", "(Landroid/view/View;)V", "shouldFit", "setFitContentPeekHeight", "setScrimBackgroundView", "", "elevation", "setElevation", "(F)V", "forceShowHeaderThumb", "Lkotlin/Function2;", "l", "Lkotlin/jvm/functions/Function2;", "getOnStateChangedListener", "()Lkotlin/jvm/functions/Function2;", "setOnStateChangedListener", "(Lkotlin/jvm/functions/Function2;)V", "onStateChangedListener", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "j", "Landroid/widget/TextView;", "bottomSheetActionButton", "r", "I", "gray28Color", "Lcom/avito/android/lib/design/bottom_sheet/BoundedCardView;", "i", "Lcom/avito/android/lib/design/bottom_sheet/BoundedCardView;", "bottomSheetHolder", AuthSource.BOOKING_ORDER, "Landroid/widget/FrameLayout;", "backgroundView", "h", "bottomSheetFooter", "Landroid/view/View;", "touchOutsideView", AuthSource.OPEN_CHANNEL_LIST, "getOnSlideListener", "setOnSlideListener", "onSlideListener", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "bottomSheetCloseButton", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "bottomSheetHeader", "e", "bottomSheetTitle", "p", "Lkotlin/jvm/functions/Function0;", "getOnClickOutsideViewListener", "()Lkotlin/jvm/functions/Function0;", "setOnClickOutsideViewListener", "onClickOutsideViewListener", VKApiConst.Q, "blueColor", "t", "bottomSheetContainerView", "k", "customBottomSheetHeader", "s", "Z", "manuallyDismissOnCancelClick", "c", "bottomSheet", "n", "getOnCloseListener", "setOnCloseListener", "onCloseListener", "o", "getOnActionClickListener", "setOnActionClickListener", "onActionClickListener", g.a, "bottomSheetBody", "<init>", "(Landroid/view/ViewGroup;)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class TabletBottomSheetView implements ModalBottomSheetView {
    public final View a;
    public final FrameLayout b;
    public final ViewGroup c;
    public final ViewGroup d;
    public final TextView e;
    public final ImageView f;
    public final FrameLayout g;
    public final FrameLayout h;
    public final BoundedCardView i;
    public final TextView j;
    public FrameLayout k;
    @Nullable
    public Function2<? super View, ? super Integer, Unit> l;
    @Nullable
    public Function2<? super View, ? super Float, Unit> m;
    @Nullable
    public Function0<Unit> n;
    @Nullable
    public Function0<Unit> o;
    @Nullable
    public Function0<Unit> p;
    public final int q;
    public final int r;
    public boolean s;
    public final ViewGroup t;

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i != 0) {
                if (i == 1) {
                    Function0<Unit> onActionClickListener = ((TabletBottomSheetView) this.b).getOnActionClickListener();
                    if (onActionClickListener != null) {
                        onActionClickListener.invoke();
                        return;
                    }
                    return;
                }
                throw null;
            } else if (((TabletBottomSheetView) this.b).s) {
                Function0<Unit> onCloseListener = ((TabletBottomSheetView) this.b).getOnCloseListener();
                if (onCloseListener != null) {
                    onCloseListener.invoke();
                }
            } else {
                ((TabletBottomSheetView) this.b).dismiss();
            }
        }
    }

    public static final class b implements View.OnTouchListener {
        public static final b a = new b();

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ TabletBottomSheetView a;

        public c(TabletBottomSheetView tabletBottomSheetView) {
            this.a = tabletBottomSheetView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0<Unit> onClickOutsideViewListener = this.a.getOnClickOutsideViewListener();
            if (onClickOutsideViewListener != null) {
                onClickOutsideViewListener.invoke();
            }
            this.a.dismiss();
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ TabletBottomSheetView a;
        public final /* synthetic */ Function0 b;

        public d(TabletBottomSheetView tabletBottomSheetView, Function0 function0) {
            this.a = tabletBottomSheetView;
            this.b = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (((Boolean) this.b.invoke()).booleanValue()) {
                Function0<Unit> onClickOutsideViewListener = this.a.getOnClickOutsideViewListener();
                if (onClickOutsideViewListener != null) {
                    onClickOutsideViewListener.invoke();
                }
                this.a.dismiss();
            }
        }
    }

    public static final class e extends Lambda implements Function1<Transition, Unit> {
        public final /* synthetic */ TabletBottomSheetView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(TabletBottomSheetView tabletBottomSheetView) {
            super(1);
            this.a = tabletBottomSheetView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Transition transition) {
            Intrinsics.checkNotNullParameter(transition, "it");
            this.a.a(5);
            return Unit.INSTANCE;
        }
    }

    public TabletBottomSheetView(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "bottomSheetContainerView");
        this.t = viewGroup;
        this.a = viewGroup.findViewById(R.id.bottom_sheet_touch_outside);
        this.b = (FrameLayout) viewGroup.findViewById(R.id.bottom_sheet_background);
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.bottom_sheet);
        this.c = viewGroup2;
        this.d = (ViewGroup) viewGroup2.findViewById(R.id.bottom_sheet_header);
        this.e = (TextView) viewGroup2.findViewById(R.id.bottom_sheet_title);
        ImageView imageView = (ImageView) viewGroup2.findViewById(R.id.bottom_sheet_close_button);
        this.f = imageView;
        this.g = (FrameLayout) viewGroup2.findViewById(R.id.bottom_sheet_body);
        this.h = (FrameLayout) viewGroup.findViewById(R.id.footer_container);
        this.i = (BoundedCardView) viewGroup.findViewById(R.id.bottom_sheet_holder);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.bottom_sheet_action_button);
        this.j = textView;
        this.k = (FrameLayout) viewGroup2.findViewById(R.id.custom_bottom_sheet_header);
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "bottomSheetContainerView.context");
        this.q = Contexts.getColorByAttr(context, R.attr.blue);
        Context context2 = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "bottomSheetContainerView.context");
        this.r = Contexts.getColorByAttr(context2, R.attr.gray28);
        Views.hide(viewGroup);
        imageView.setOnClickListener(new a(0, this));
        ViewCompat.setAccessibilityDelegate(viewGroup2, new AccessibilityDelegateCompat(this) { // from class: com.avito.android.lib.design.bottom_sheet.TabletBottomSheetView.2
            public final /* synthetic */ TabletBottomSheetView d;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.d = r1;
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(@NotNull View view, @NotNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                Intrinsics.checkNotNullParameter(view, "host");
                Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, "info");
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.addAction(1048576);
                accessibilityNodeInfoCompat.setDismissable(true);
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public boolean performAccessibilityAction(@NotNull View view, int i2, @NotNull Bundle bundle) {
                Intrinsics.checkNotNullParameter(view, "host");
                Intrinsics.checkNotNullParameter(bundle, "args");
                if (i2 != 1048576) {
                    return super.performAccessibilityAction(view, i2, bundle);
                }
                this.d.dismiss();
                return true;
            }
        });
        viewGroup2.setOnTouchListener(b.a);
        textView.setOnClickListener(new a(1, this));
    }

    public final void a(int i2) {
        Function2<View, Integer, Unit> onStateChangedListener = getOnStateChangedListener();
        if (onStateChangedListener != null) {
            ViewGroup viewGroup = this.c;
            Intrinsics.checkNotNullExpressionValue(viewGroup, "bottomSheet");
            onStateChangedListener.invoke(viewGroup, Integer.valueOf(i2));
        }
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void dismiss() {
        a(5);
        ViewGroup viewGroup = this.t;
        TransitionDsl transitionDsl = new TransitionDsl(new Fade());
        transitionDsl.addTarget(this.t);
        TransitionManager.beginDelayedTransition(viewGroup, transitionDsl.buildTransition());
        Views.hide(this.t);
        Function0<Unit> onCloseListener = getOnCloseListener();
        if (onCloseListener != null) {
            onCloseListener.invoke();
        }
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void expand() {
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void forceShowHeaderThumb() {
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    @NotNull
    public FrameLayout getContentView() {
        FrameLayout frameLayout = this.g;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "bottomSheetBody");
        return frameLayout;
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    @NotNull
    public FrameLayout getFooterView() {
        FrameLayout frameLayout = this.h;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "bottomSheetFooter");
        return frameLayout;
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    @Nullable
    public Function0<Unit> getOnActionClickListener() {
        return this.o;
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    @Nullable
    public Function0<Unit> getOnClickOutsideViewListener() {
        return this.p;
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    @Nullable
    public Function0<Unit> getOnCloseListener() {
        return this.n;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function2<? super android.view.View, ? super java.lang.Float, kotlin.Unit>, kotlin.jvm.functions.Function2<android.view.View, java.lang.Float, kotlin.Unit> */
    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    @Nullable
    public Function2<View, Float, Unit> getOnSlideListener() {
        return this.m;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function2<? super android.view.View, ? super java.lang.Integer, kotlin.Unit>, kotlin.jvm.functions.Function2<android.view.View, java.lang.Integer, kotlin.Unit> */
    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    @Nullable
    public Function2<View, Integer, Unit> getOnStateChangedListener() {
        return this.l;
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setActionButtonActive(boolean z) {
        if (z) {
            TextView textView = this.j;
            Intrinsics.checkNotNullExpressionValue(textView, "bottomSheetActionButton");
            textView.setClickable(true);
            this.j.setTextColor(this.q);
            return;
        }
        TextView textView2 = this.j;
        Intrinsics.checkNotNullExpressionValue(textView2, "bottomSheetActionButton");
        textView2.setClickable(false);
        this.j.setTextColor(this.r);
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setCancelOnTouchOutside(boolean z) {
        if (z) {
            this.a.setOnClickListener(new c(this));
        } else {
            this.a.setOnClickListener(null);
        }
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setCloseButtonIcon(int i2) {
        this.f.setBackgroundResource(i2);
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setCustomHeader(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Views.setVisible(this.d, false);
        Views.setVisible(this.k, true);
        this.k.addView(view);
    }

    public final void setElevation(float f2) {
        BoundedCardView boundedCardView = this.i;
        Intrinsics.checkNotNullExpressionValue(boundedCardView, "bottomSheetHolder");
        boundedCardView.setElevation(0.0f);
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setFitContentPeekHeight(boolean z) {
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setForceExpandedState(boolean z) {
        if (z) {
            ViewGroup viewGroup = this.c;
            Intrinsics.checkNotNullExpressionValue(viewGroup, "bottomSheet");
            viewGroup.getLayoutParams().height = -1;
            return;
        }
        ViewGroup viewGroup2 = this.c;
        Intrinsics.checkNotNullExpressionValue(viewGroup2, "bottomSheet");
        viewGroup2.getLayoutParams().height = -2;
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setHeaderParams(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, boolean z, boolean z2) {
        boolean z3 = false;
        Views.setVisible(this.d, (charSequence == null && charSequence2 == null && !z) ? false : true);
        TextView textView = this.e;
        Intrinsics.checkNotNullExpressionValue(textView, "bottomSheetTitle");
        textView.setText(charSequence);
        TextView textView2 = this.j;
        Intrinsics.checkNotNullExpressionValue(textView2, "bottomSheetActionButton");
        textView2.setText(charSequence2);
        Views.setVisible(this.e, !(charSequence == null || m.isBlank(charSequence)));
        TextView textView3 = this.j;
        if (charSequence == null || m.isBlank(charSequence)) {
            z3 = true;
        }
        Views.setVisible(textView3, !z3);
        Views.setVisible(this.f, z);
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setHideable(boolean z) {
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setManualDismissOnCancelClick(boolean z) {
        this.s = z;
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setOnActionClickListener(@Nullable Function0<Unit> function0) {
        this.o = function0;
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setOnClickOutsideViewListener(@Nullable Function0<Unit> function0) {
        this.p = function0;
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setOnCloseListener(@Nullable Function0<Unit> function0) {
        this.n = function0;
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setOnSlideListener(@Nullable Function2<? super View, ? super Float, Unit> function2) {
        this.m = function2;
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setOnStateChangedListener(@Nullable Function2<? super View, ? super Integer, Unit> function2) {
        this.l = function2;
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setPeekHeight(int i2) {
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setScrimBackgroundColor(@ColorInt int i2) {
        this.a.setBackgroundColor(i2);
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setScrimBackgroundView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.b.addView(view);
        Views.show(this.b);
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setSkipCollapsed(boolean z) {
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setThumbLayoutHeight(int i2) {
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void show() {
        if (!ViewCompat.isLaidOut(this.t) || Views.isVisible(this.t)) {
            Views.show(this.t);
            a(4);
            return;
        }
        ViewGroup viewGroup = this.t;
        TransitionDsl transitionDsl = new TransitionDsl(new Fade());
        transitionDsl.addTarget(this.t);
        transitionDsl.onTransitionEnd(new e(this));
        TransitionManager.beginDelayedTransition(viewGroup, transitionDsl.buildTransition());
        Views.show(this.t);
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void showActionButton(boolean z) {
        Views.setVisible(this.j, z);
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setCancelOnTouchOutside(@NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "cancelOnTouchOutside");
        this.a.setOnClickListener(new d(this, function0));
    }
}
