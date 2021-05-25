package ru.avito.component.bottom_sheet;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.jakewharton.rxrelay3.BehaviorRelay;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.bottom_sheet.BottomSheet;
import t6.v.e;
public final class BottomSheetImpl implements BottomSheet {
    public final Context a;
    public final Resources b;
    public final LayoutInflater c;
    public final View d;
    public final View e;
    public final CoordinatorLayout f;
    public final BottomSheetBehavior<FrameLayout> g;
    public final Runnable h = new c(this);
    public boolean i;
    public final int j;
    public a7.a.a.a.a k;
    public final View.OnLayoutChangeListener l;
    @Nullable
    public View m;
    @Nullable
    public View n;
    @NotNull
    public final BehaviorRelay<BottomSheet.Visibility> o;
    public boolean p;
    public boolean q;
    public boolean r;
    @NotNull
    public BottomSheet.NotchVisibility s;
    public boolean t;
    @NotNull
    public BottomSheet.PeekHeight u;
    public final FrameLayout v;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            BottomSheet.NotchVisibility.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ BottomSheetImpl a;

        public a(BottomSheetImpl bottomSheetImpl) {
            this.a = bottomSheetImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.g.setHideable(true);
            this.a.close();
        }
    }

    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ BottomSheetImpl a;

        public b(BottomSheetImpl bottomSheetImpl) {
            this.a = bottomSheetImpl;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            FrameLayout frameLayout = this.a.v;
            frameLayout.setPadding(frameLayout.getPaddingLeft(), this.a.v.getPaddingTop(), this.a.v.getPaddingRight(), i4 - i2);
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ BottomSheetImpl a;

        public c(BottomSheetImpl bottomSheetImpl) {
            this.a = bottomSheetImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a();
        }
    }

    public BottomSheetImpl(@NotNull FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "bottomSheetView");
        this.v = frameLayout;
        Context context = frameLayout.getContext();
        this.a = context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.b = context.getResources();
        this.c = LayoutInflater.from(context);
        View findViewById = frameLayout.findViewById(R.id.avito_bottom_sheet_notch);
        Intrinsics.checkNotNullExpressionValue(findViewById, "bottomSheetView.findView…avito_bottom_sheet_notch)");
        this.d = findViewById;
        View findViewById2 = frameLayout.findViewById(R.id.bottom_sheet_close_button);
        this.e = findViewById2;
        ViewParent parent = frameLayout.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
        this.f = (CoordinatorLayout) parent;
        BottomSheetBehavior<FrameLayout> from = BottomSheetBehavior.from(frameLayout);
        Intrinsics.checkNotNullExpressionValue(from, "BottomSheetBehavior.from(bottomSheetView)");
        this.g = from;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.j = Contexts.getColorCompat(context, com.avito.android.lib.design.avito.R.color.expected_overlay);
        this.l = new b(this);
        BehaviorRelay<BottomSheet.Visibility> createDefault = BehaviorRelay.createDefault(BottomSheet.Visibility.Collapsed.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(createDefault, "BehaviorRelay.createDefa…eet.Visibility.Collapsed)");
        this.o = createDefault;
        this.s = BottomSheet.NotchVisibility.AUTO;
        this.t = true;
        this.u = BottomSheet.PeekHeight.Auto.INSTANCE;
        from.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback(this) { // from class: ru.avito.component.bottom_sheet.BottomSheetImpl.1
            public final /* synthetic */ BottomSheetImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(@NotNull View view, float f2) {
                Intrinsics.checkNotNullParameter(view, "bottomSheet");
                a7.a.a.a.a aVar = this.a.k;
                if (aVar != null) {
                    if (!(!Float.isInfinite(f2) && !Float.isNaN(f2)) || f2 <= 0.5f) {
                        aVar.setAlpha(0.0f);
                        Views.hide(aVar);
                        return;
                    }
                    aVar.setAlpha(e.coerceAtMost((f2 - 0.5f) * ((float) 2), 1.0f));
                    Views.show(aVar);
                }
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(@NotNull View view, int i2) {
                BottomSheet.Visibility visibility;
                Intrinsics.checkNotNullParameter(view, "bottomSheet");
                a7.a.a.a.a aVar = this.a.k;
                if (i2 == 3) {
                    boolean z = view.getHeight() > this.a.g.getPeekHeight();
                    if (aVar != null && z) {
                        aVar.setAlpha(1.0f);
                        Views.show(aVar);
                    }
                    visibility = BottomSheet.Visibility.Expanded.INSTANCE;
                } else if (i2 == 4) {
                    if (aVar != null) {
                        Views.hide(aVar);
                    }
                    visibility = BottomSheet.Visibility.Collapsed.INSTANCE;
                } else if (i2 == 5) {
                    if (aVar != null) {
                        Views.hide(aVar);
                    }
                    visibility = BottomSheet.Visibility.Closed.INSTANCE;
                } else {
                    return;
                }
                this.a.o.accept(visibility);
            }
        });
        a();
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new a(this));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00cf, code lost:
        if ((!r5.p && r5.v.getHeight() > r5.g.getPeekHeight()) != false) goto L_0x00d1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
        // Method dump skipped, instructions count: 310
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.avito.component.bottom_sheet.BottomSheetImpl.a():void");
    }

    @Override // ru.avito.component.bottom_sheet.BottomSheet
    public void attachBottomView(@Nullable View view) {
        View view2;
        if (view == null && (view2 = this.n) != null) {
            view2.removeOnLayoutChangeListener(this.l);
        }
        if (!Intrinsics.areEqual(this.n, view)) {
            this.n = view;
            b();
        }
    }

    public final void b() {
        if (!this.i) {
            this.i = true;
            this.v.post(this.h);
        }
    }

    @Override // ru.avito.component.bottom_sheet.BottomSheet
    public void close() {
        if (this.t) {
            if (!this.g.isHideable()) {
                a();
            }
            this.g.setState(5);
            return;
        }
        throw new IllegalStateException("Bottom sheet is not hideable");
    }

    @Override // ru.avito.component.bottom_sheet.BottomSheet
    public void collapse() {
        if (this.p) {
            this.g.setState(3);
        } else {
            this.g.setState(4);
        }
    }

    @Override // ru.avito.component.bottom_sheet.BottomSheet
    public void expand() {
        this.g.setState(3);
    }

    @Override // ru.avito.component.bottom_sheet.BottomSheet
    @Nullable
    public View getBottomView() {
        return this.n;
    }

    @Override // ru.avito.component.bottom_sheet.BottomSheet
    @Nullable
    public View getContentView() {
        return this.m;
    }

    @Override // ru.avito.component.bottom_sheet.BottomSheet
    public boolean getDimBackgroundOnExpand() {
        return this.q;
    }

    @Override // ru.avito.component.bottom_sheet.BottomSheet
    public boolean getDimStatusBarOnExpand() {
        return this.r;
    }

    @Override // ru.avito.component.bottom_sheet.BottomSheet
    public boolean getLockExpanded() {
        return this.p;
    }

    @Override // ru.avito.component.bottom_sheet.BottomSheet
    @NotNull
    public BottomSheet.NotchVisibility getNotchVisibility() {
        return this.s;
    }

    @Override // ru.avito.component.bottom_sheet.BottomSheet
    @NotNull
    public BottomSheet.PeekHeight getPeekHeight() {
        return this.u;
    }

    @Override // ru.avito.component.bottom_sheet.BottomSheet
    @NotNull
    public View getView() {
        return this.v;
    }

    @Override // ru.avito.component.bottom_sheet.BottomSheet
    @NotNull
    public BottomSheet.Visibility getVisibility() {
        BottomSheet.Visibility value = this.o.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "visibilityObservable.value");
        return value;
    }

    @Override // ru.avito.component.bottom_sheet.BottomSheet
    public Observable getVisibilityObservable() {
        return this.o;
    }

    @Override // ru.avito.component.bottom_sheet.BottomSheet
    public boolean isHideable() {
        return this.t;
    }

    @Override // ru.avito.component.bottom_sheet.BottomSheet
    @NotNull
    public View setContentView(@NotNull View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        int i2;
        Intrinsics.checkNotNullParameter(view, "view");
        View view2 = this.m;
        if (view2 != null) {
            this.v.removeView(view2);
        }
        if (layoutParams != null && ((i2 = layoutParams.height) == -2 || i2 == -1)) {
            ViewGroup.LayoutParams layoutParams2 = this.v.getLayoutParams();
            layoutParams2.height = layoutParams.height;
            this.v.setLayoutParams(layoutParams2);
        }
        if (layoutParams != null) {
            this.v.addView(view, 0, layoutParams);
        } else {
            this.v.addView(view, 0);
        }
        this.m = view;
        return view;
    }

    @Override // ru.avito.component.bottom_sheet.BottomSheet
    public void setDimBackgroundOnExpand(boolean z) {
        if (this.q != z) {
            this.q = z;
            b();
        }
    }

    @Override // ru.avito.component.bottom_sheet.BottomSheet
    public void setDimStatusBarOnExpand(boolean z) {
        if (this.r != z) {
            this.r = z;
            b();
        }
    }

    @Override // ru.avito.component.bottom_sheet.BottomSheet
    public void setHideable(boolean z) {
        if (this.t != z) {
            this.t = z;
            b();
        }
    }

    @Override // ru.avito.component.bottom_sheet.BottomSheet
    public void setLockExpanded(boolean z) {
        if (this.p != z) {
            this.p = z;
            b();
        }
    }

    @Override // ru.avito.component.bottom_sheet.BottomSheet
    public void setNotchVisibility(@NotNull BottomSheet.NotchVisibility notchVisibility) {
        Intrinsics.checkNotNullParameter(notchVisibility, "value");
        if (this.s != notchVisibility) {
            this.s = notchVisibility;
            b();
        }
    }

    @Override // ru.avito.component.bottom_sheet.BottomSheet
    public void setPeekHeight(@NotNull BottomSheet.PeekHeight peekHeight) {
        Intrinsics.checkNotNullParameter(peekHeight, "value");
        if (!Intrinsics.areEqual(this.u, peekHeight)) {
            this.u = peekHeight;
            b();
        }
    }

    @Override // ru.avito.component.bottom_sheet.BottomSheet
    @NotNull
    public View setContentView(int i2) {
        View inflate = this.c.inflate(i2, (ViewGroup) this.v, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        setContentView(inflate, inflate.getLayoutParams());
        return inflate;
    }
}
