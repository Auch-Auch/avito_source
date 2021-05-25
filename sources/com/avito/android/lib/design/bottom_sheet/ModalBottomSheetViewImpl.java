package com.avito.android.lib.design.bottom_sheet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.transition.Fade;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.avito.android.lib.design.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.TransitionDsl;
import com.avito.android.util.Views;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@SuppressLint({"ClickableViewAccessibility"})
public final class ModalBottomSheetViewImpl implements ModalBottomSheetView {
    public final View a;
    public final FrameLayout b;
    public final LinearLayout c;
    public final ViewGroup d;
    public final TextView e;
    public final ImageView f;
    public final FrameLayout g;
    public final FrameLayout h;
    public final TextView i;
    public final View j;
    public View k;
    public final BottomSheetBehavior<LinearLayout> l;
    public FrameLayout m;
    public int n;
    @Nullable
    public Function2<? super View, ? super Integer, Unit> o;
    @Nullable
    public Function2<? super View, ? super Float, Unit> p;
    @Nullable
    public Function0<Unit> q;
    @Nullable
    public Function0<Unit> r;
    @Nullable
    public Function0<Unit> s;
    public final int t;
    public final int u;
    public View.OnLayoutChangeListener v;
    public boolean w;
    public final ViewGroup x;

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
            if (i == 0) {
                ModalBottomSheetViewImpl modalBottomSheetViewImpl = (ModalBottomSheetViewImpl) this.b;
                if (modalBottomSheetViewImpl.w) {
                    Function0<Unit> function0 = modalBottomSheetViewImpl.q;
                    if (function0 != null) {
                        function0.invoke();
                        return;
                    }
                    return;
                }
                modalBottomSheetViewImpl.dismiss();
            } else if (i == 1) {
                Function0<Unit> function02 = ((ModalBottomSheetViewImpl) this.b).r;
                if (function02 != null) {
                    function02.invoke();
                }
            } else {
                throw null;
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
        public final /* synthetic */ ModalBottomSheetViewImpl a;

        public c(ModalBottomSheetViewImpl modalBottomSheetViewImpl) {
            this.a = modalBottomSheetViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0<Unit> function0 = this.a.s;
            if (function0 != null) {
                function0.invoke();
            }
            ModalBottomSheetViewImpl modalBottomSheetViewImpl = this.a;
            modalBottomSheetViewImpl.x.postDelayed(new a2.a.a.k1.a.a.c(modalBottomSheetViewImpl), 250);
            if (this.a.l.getState() != 2) {
                this.a.dismiss();
            }
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ ModalBottomSheetViewImpl a;
        public final /* synthetic */ Function0 b;

        public d(ModalBottomSheetViewImpl modalBottomSheetViewImpl, Function0 function0) {
            this.a = modalBottomSheetViewImpl;
            this.b = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (((Boolean) this.b.invoke()).booleanValue() && this.a.l.getState() != 2) {
                Function0<Unit> function0 = this.a.s;
                if (function0 != null) {
                    function0.invoke();
                }
                this.a.dismiss();
            }
        }
    }

    public static final class e extends Lambda implements Function1<Transition, Unit> {
        public final /* synthetic */ ModalBottomSheetViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ModalBottomSheetViewImpl modalBottomSheetViewImpl) {
            super(1);
            this.a = modalBottomSheetViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Transition transition) {
            Intrinsics.checkNotNullParameter(transition, "it");
            this.a.l.setState(4);
            return Unit.INSTANCE;
        }
    }

    public ModalBottomSheetViewImpl(@NotNull ViewGroup viewGroup) {
        int i2;
        Intrinsics.checkNotNullParameter(viewGroup, "bottomSheetContainerView");
        this.x = viewGroup;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewGroup.findViewById(R.id.coordinator);
        this.a = viewGroup.findViewById(R.id.bottom_sheet_touch_outside);
        this.b = (FrameLayout) viewGroup.findViewById(R.id.bottom_sheet_background);
        LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.bottom_sheet);
        this.c = linearLayout;
        this.d = (ViewGroup) linearLayout.findViewById(R.id.bottom_sheet_header);
        this.e = (TextView) linearLayout.findViewById(R.id.bottom_sheet_title);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.bottom_sheet_close_button);
        this.f = imageView;
        this.g = (FrameLayout) linearLayout.findViewById(R.id.bottom_sheet_body);
        this.h = (FrameLayout) viewGroup.findViewById(R.id.footer_container);
        TextView textView = (TextView) linearLayout.findViewById(R.id.bottom_sheet_action_button);
        this.i = textView;
        this.j = linearLayout.findViewById(R.id.header_thumb);
        this.k = linearLayout.findViewById(R.id.thumb_layout);
        BottomSheetBehavior<LinearLayout> from = BottomSheetBehavior.from(linearLayout);
        Intrinsics.checkNotNullExpressionValue(from, "BottomSheetBehavior.from(bottomSheet)");
        this.l = from;
        this.m = (FrameLayout) linearLayout.findViewById(R.id.custom_bottom_sheet_header);
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "bottomSheetContainerView.context");
        this.t = Contexts.getColorByAttr(context, R.attr.blue);
        Context context2 = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "bottomSheetContainerView.context");
        this.u = Contexts.getColorByAttr(context2, R.attr.gray28);
        Context context3 = viewGroup.getContext();
        TypedValue typedValue = new TypedValue();
        Context context4 = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "bottomSheetContainerView.context");
        if (context4.getTheme().resolveAttribute(R.attr.bottomSheetDialog, typedValue, true)) {
            i2 = typedValue.resourceId;
        } else {
            i2 = R.style.Design_Widget_BottomSheetDialog;
        }
        TypedArray obtainStyledAttributes = context3.obtainStyledAttributes(i2, new int[]{R.attr.bottomSheet_titleMarginWithoutThumb});
        this.n = obtainStyledAttributes.getDimensionPixelSize(0, this.n);
        obtainStyledAttributes.recycle();
        from.setState(5);
        from.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback(this) { // from class: com.avito.android.lib.design.bottom_sheet.ModalBottomSheetViewImpl.1
            public final /* synthetic */ ModalBottomSheetViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(@NotNull View view, float f2) {
                Intrinsics.checkNotNullParameter(view, "bottomSheet");
                Function2<? super View, ? super Float, Unit> function2 = this.a.p;
                if (function2 != null) {
                    function2.invoke(view, Float.valueOf(f2));
                }
                if (f2 < ((float) 0)) {
                    FrameLayout frameLayout = this.a.h;
                    Intrinsics.checkNotNullExpressionValue(frameLayout, "bottomSheetFooter");
                    FrameLayout frameLayout2 = this.a.h;
                    Intrinsics.checkNotNullExpressionValue(frameLayout2, "bottomSheetFooter");
                    frameLayout.setTranslationY(((float) (-frameLayout2.getHeight())) * f2);
                    return;
                }
                FrameLayout frameLayout3 = this.a.h;
                Intrinsics.checkNotNullExpressionValue(frameLayout3, "bottomSheetFooter");
                frameLayout3.setTranslationY(0.0f);
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(@NotNull View view, int i3) {
                Intrinsics.checkNotNullParameter(view, "bottomSheet");
                Function2<? super View, ? super Integer, Unit> function2 = this.a.o;
                if (function2 != null) {
                    function2.invoke(view, Integer.valueOf(i3));
                }
                if (i3 == 1) {
                    ModalBottomSheetViewImpl modalBottomSheetViewImpl = this.a;
                    modalBottomSheetViewImpl.x.postDelayed(new a2.a.a.k1.a.a.c(modalBottomSheetViewImpl), 250);
                }
                if (i3 == 5) {
                    this.a.a();
                }
            }
        });
        imageView.setOnClickListener(new a(0, this));
        ViewCompat.setAccessibilityDelegate(linearLayout, new AccessibilityDelegateCompat(this) { // from class: com.avito.android.lib.design.bottom_sheet.ModalBottomSheetViewImpl.3
            public final /* synthetic */ ModalBottomSheetViewImpl d;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.d = r1;
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(@NotNull View view, @NotNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                Intrinsics.checkNotNullParameter(view, "host");
                Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, "info");
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                if (this.d.l.isHideable()) {
                    accessibilityNodeInfoCompat.addAction(1048576);
                    accessibilityNodeInfoCompat.setDismissable(true);
                    return;
                }
                accessibilityNodeInfoCompat.setDismissable(false);
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public boolean performAccessibilityAction(@NotNull View view, int i3, @NotNull Bundle bundle) {
                Intrinsics.checkNotNullParameter(view, "host");
                Intrinsics.checkNotNullParameter(bundle, "args");
                if (i3 != 1048576 || !this.d.l.isHideable()) {
                    return super.performAccessibilityAction(view, i3, bundle);
                }
                this.d.dismiss();
                return true;
            }
        });
        linearLayout.setOnTouchListener(b.a);
        textView.setOnClickListener(new a(1, this));
    }

    public final void a() {
        Function0<Unit> function0 = this.q;
        if (function0 != null) {
            function0.invoke();
        }
        ViewGroup viewGroup = this.x;
        TransitionDsl transitionDsl = new TransitionDsl(new Fade());
        transitionDsl.addTarget(this.x);
        TransitionManager.beginDelayedTransition(viewGroup, transitionDsl.buildTransition());
        Views.hide(this.x);
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void dismiss() {
        if (this.l.isHideable()) {
            this.l.setState(5);
        } else {
            a();
        }
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void expand() {
        this.l.setState(3);
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void forceShowHeaderThumb() {
        Views.show(this.j);
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
        return this.r;
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    @Nullable
    public Function0<Unit> getOnClickOutsideViewListener() {
        return this.s;
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    @Nullable
    public Function0<Unit> getOnCloseListener() {
        return this.q;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function2<? super android.view.View, ? super java.lang.Float, kotlin.Unit>, kotlin.jvm.functions.Function2<android.view.View, java.lang.Float, kotlin.Unit> */
    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    @Nullable
    public Function2<View, Float, Unit> getOnSlideListener() {
        return this.p;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function2<? super android.view.View, ? super java.lang.Integer, kotlin.Unit>, kotlin.jvm.functions.Function2<android.view.View, java.lang.Integer, kotlin.Unit> */
    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    @Nullable
    public Function2<View, Integer, Unit> getOnStateChangedListener() {
        return this.o;
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setActionButtonActive(boolean z) {
        if (z) {
            TextView textView = this.i;
            Intrinsics.checkNotNullExpressionValue(textView, "bottomSheetActionButton");
            textView.setClickable(true);
            this.i.setTextColor(this.t);
            return;
        }
        TextView textView2 = this.i;
        Intrinsics.checkNotNullExpressionValue(textView2, "bottomSheetActionButton");
        textView2.setClickable(false);
        this.i.setTextColor(this.u);
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
    public void setCloseButtonIcon(@DrawableRes int i2) {
        this.f.setBackgroundResource(i2);
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setCustomHeader(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Views.setVisible(this.d, false);
        Views.setVisible(this.m, true);
        this.m.addView(view);
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setFitContentPeekHeight(boolean z) {
        View.OnLayoutChangeListener onLayoutChangeListener = this.v;
        if (onLayoutChangeListener != null) {
            this.x.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
        if (z) {
            ViewGroup viewGroup = this.x;
            ModalBottomSheetViewImpl$setFitContentPeekHeight$listener$1 modalBottomSheetViewImpl$setFitContentPeekHeight$listener$1 = new View.OnLayoutChangeListener(viewGroup) { // from class: com.avito.android.lib.design.bottom_sheet.ModalBottomSheetViewImpl$setFitContentPeekHeight$listener$1
                public final /* synthetic */ View b;

                {
                    this.b = r2;
                }

                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(@Nullable View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    View view2 = this.b;
                    Context context = view2.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    view2.measure(View.MeasureSpec.makeMeasureSpec(view2.getWidth(), 0), View.MeasureSpec.makeMeasureSpec(Contexts.getDisplayHeight(context), Integer.MIN_VALUE));
                    ModalBottomSheetView.this.setPeekHeight(view2.getMeasuredHeight());
                    this.b.removeOnLayoutChangeListener(this);
                }
            };
            viewGroup.addOnLayoutChangeListener(modalBottomSheetViewImpl$setFitContentPeekHeight$listener$1);
            this.v = modalBottomSheetViewImpl$setFitContentPeekHeight$listener$1;
        }
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setForceExpandedState(boolean z) {
        if (z) {
            LinearLayout linearLayout = this.c;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "bottomSheet");
            linearLayout.getLayoutParams().height = -1;
            return;
        }
        LinearLayout linearLayout2 = this.c;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "bottomSheet");
        linearLayout2.getLayoutParams().height = -2;
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setHeaderParams(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, boolean z, boolean z2) {
        boolean z3 = false;
        Views.setVisible(this.d, (charSequence == null && charSequence2 == null && !z) ? false : true);
        TextView textView = this.e;
        Intrinsics.checkNotNullExpressionValue(textView, "bottomSheetTitle");
        textView.setText(charSequence);
        TextView textView2 = this.i;
        Intrinsics.checkNotNullExpressionValue(textView2, "bottomSheetActionButton");
        textView2.setText(charSequence2);
        Views.setVisible(this.e, !(charSequence == null || m.isBlank(charSequence)));
        TextView textView3 = this.i;
        if (charSequence == null || m.isBlank(charSequence)) {
            z3 = true;
        }
        Views.setVisible(textView3, !z3);
        Views.setVisible(this.f, z);
        Views.setVisible(this.j, z2);
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setHideable(boolean z) {
        this.l.setHideable(z);
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setManualDismissOnCancelClick(boolean z) {
        this.w = z;
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setOnActionClickListener(@Nullable Function0<Unit> function0) {
        this.r = function0;
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setOnClickOutsideViewListener(@Nullable Function0<Unit> function0) {
        this.s = function0;
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setOnCloseListener(@Nullable Function0<Unit> function0) {
        this.q = function0;
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setOnSlideListener(@Nullable Function2<? super View, ? super Float, Unit> function2) {
        this.p = function2;
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setOnStateChangedListener(@Nullable Function2<? super View, ? super Integer, Unit> function2) {
        this.o = function2;
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setPeekHeight(int i2) {
        this.l.setPeekHeight(i2);
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
        this.l.setSkipCollapsed(z);
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setThumbLayoutHeight(int i2) {
        View view = this.k;
        Intrinsics.checkNotNullExpressionValue(view, "thumbLayout");
        view.getLayoutParams().height = i2;
        this.k.requestLayout();
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void show() {
        if (!ViewCompat.isLaidOut(this.x) || Views.isVisible(this.x)) {
            Views.show(this.x);
            this.l.setState(4);
            return;
        }
        ViewGroup viewGroup = this.x;
        TransitionDsl transitionDsl = new TransitionDsl(new Fade());
        transitionDsl.addTarget(this.x);
        transitionDsl.onTransitionEnd(new e(this));
        TransitionManager.beginDelayedTransition(viewGroup, transitionDsl.buildTransition());
        Views.show(this.x);
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void showActionButton(boolean z) {
        Views.setVisible(this.i, z);
    }

    @Override // com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView
    public void setCancelOnTouchOutside(@NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "cancelOnTouchOutside");
        this.a.setOnClickListener(new d(this, function0));
    }
}
