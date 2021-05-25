package com.avito.android.component.bottom_sheet;

import a2.g.r.g;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ActionMenu;
import com.avito.android.util.Views;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.jakewharton.rxbinding4.view.RxView;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.appbar.AppBar;
import ru.avito.component.appbar.AppBarImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010+\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u001e\u0010 \u001a\u0004\u0018\u00010\u001b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR$\u0010%\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010\u00110\u00110!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010\u0013¨\u00061"}, d2 = {"Lcom/avito/android/component/bottom_sheet/BottomSheetViewImpl;", "Lcom/avito/android/component/bottom_sheet/BottomSheetView;", "Lio/reactivex/rxjava3/core/Observable;", "", "closeEvents", "()Lio/reactivex/rxjava3/core/Observable;", "", "panelStateChanges", "close", "()V", "openFullscreen", "show", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "setPeekHeight", "(I)V", "getPanelState", "()I", "Landroid/view/View;", "f", "Landroid/view/View;", "toolbarContainer", "Landroid/widget/TextView;", g.a, "Landroid/widget/TextView;", "collapsedStateToolbar", "e", "bottomSheetView", "Lru/avito/component/appbar/AppBar;", AuthSource.SEND_ABUSE, "Lru/avito/component/appbar/AppBar;", "getAppBar", "()Lru/avito/component/appbar/AppBar;", "appBar", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "bottomSheetBehavior", "Lcom/avito/android/component/bottom_sheet/BottomSheetAdapter;", "c", "Lcom/avito/android/component/bottom_sheet/BottomSheetAdapter;", "bottomSheetCallbacks", "d", "root", "scrollableView", "", "autoShow", "<init>", "(Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/widget/TextView;Landroid/view/View;Z)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class BottomSheetViewImpl implements BottomSheetView {
    @Nullable
    public final AppBar a;
    public final BottomSheetBehavior<View> b;
    public final BottomSheetAdapter c;
    public final View d;
    public final View e;
    public final View f;
    public final TextView g;

    public static final class a<T> implements Predicate<Integer> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(Integer num) {
            Integer num2 = num;
            return num2 != null && num2.intValue() == 5;
        }
    }

    public static final class b<T, R> implements Function<Integer, Unit> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Unit apply(Integer num) {
            return Unit.INSTANCE;
        }
    }

    public static final class c<T, R> implements Function<Unit, Boolean> {
        public final /* synthetic */ BottomSheetViewImpl a;

        public c(BottomSheetViewImpl bottomSheetViewImpl) {
            this.a = bottomSheetViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Boolean apply(Unit unit) {
            return Boolean.valueOf(this.a.b.getState() == 5);
        }
    }

    public static final class d<T, R> implements Function<Boolean, ObservableSource<? extends Unit>> {
        public final /* synthetic */ BottomSheetViewImpl a;

        public d(BottomSheetViewImpl bottomSheetViewImpl) {
            this.a = bottomSheetViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends Unit> apply(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "isHidden");
            if (bool2.booleanValue()) {
                return Observable.create(a2.a.a.a.c.a.a);
            }
            return Observable.create(new a2.a.a.a.c.b(this));
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ BottomSheetViewImpl a;

        public e(BottomSheetViewImpl bottomSheetViewImpl) {
            this.a = bottomSheetViewImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.a.b.getState() == 5) {
                this.a.b.setState(4);
            } else {
                this.a.c.onStateChanged(this.a.e, this.a.b.getState());
            }
        }
    }

    public BottomSheetViewImpl(@NotNull View view, @NotNull View view2, @Nullable View view3, @Nullable TextView textView, @Nullable View view4, boolean z) {
        Intrinsics.checkNotNullParameter(view, "root");
        Intrinsics.checkNotNullParameter(view2, "bottomSheetView");
        this.d = view;
        this.e = view2;
        this.f = view3;
        this.g = textView;
        if (view3 != null) {
            this.a = new AppBar(this, new AppBarImpl(view2, view4, false, 4, null)) { // from class: com.avito.android.component.bottom_sheet.BottomSheetViewImpl.1
                public final /* synthetic */ AppBarImpl a;
                public final /* synthetic */ BottomSheetViewImpl b;
                public final /* synthetic */ AppBarImpl c;

                {
                    this.b = r1;
                    this.c = r2;
                    this.a = r2;
                }

                @Override // ru.avito.component.appbar.AppBar
                public void hideActionsMenu() {
                    this.a.hideActionsMenu();
                }

                @Override // ru.avito.component.appbar.AppBar
                public boolean isVisible() {
                    return this.a.isVisible();
                }

                @Override // ru.avito.component.appbar.AppBar
                @NotNull
                public Observable<Integer> menuCallbacks() {
                    return this.a.menuCallbacks();
                }

                @Override // ru.avito.component.appbar.AppBar
                @NotNull
                public Observable<Unit> navigationCallbacks() {
                    return this.a.navigationCallbacks();
                }

                @Override // ru.avito.component.appbar.AppBar
                public void setActionMenuItemIcon(int i, @DrawableRes int i2, @AttrRes @Nullable Integer num) {
                    this.a.setActionMenuItemIcon(i, i2, num);
                }

                @Override // ru.avito.component.appbar.AppBar
                public void setIcon(@Nullable Picture picture) {
                    this.a.setIcon(picture);
                }

                @Override // ru.avito.component.appbar.AppBar
                public void setMenu(@MenuRes int i) {
                    this.a.setMenu(i);
                }

                @Override // ru.avito.component.appbar.AppBar
                public void setMenuTintColor(@ColorRes int i) {
                    this.a.setMenuTintColor(i);
                }

                @Override // ru.avito.component.appbar.AppBar
                public void setMenuTintColorAttr(@AttrRes int i) {
                    this.a.setMenuTintColorAttr(i);
                }

                @Override // ru.avito.component.appbar.AppBar
                public void setNavigationIcon(@DrawableRes int i, @AttrRes @Nullable Integer num) {
                    this.a.setNavigationIcon(i, num);
                }

                @Override // ru.avito.component.appbar.AppBar
                public void setShadowVisible(boolean z2) {
                    this.a.setShadowVisible(z2);
                }

                @Override // ru.avito.component.appbar.AppBar
                public void setTitle(@NotNull CharSequence charSequence) {
                    Intrinsics.checkNotNullParameter(charSequence, "title");
                    this.c.setTitle(charSequence);
                    TextView textView2 = this.b.g;
                    if (textView2 != null) {
                        textView2.setText(charSequence);
                    }
                }

                @Override // ru.avito.component.appbar.AppBar
                public void setVisible(boolean z2) {
                    this.a.setVisible(z2);
                }

                @Override // ru.avito.component.appbar.AppBar
                public void showActionsMenu(@NotNull List<ActionMenu> list) {
                    Intrinsics.checkNotNullParameter(list, "actions");
                    this.a.showActionsMenu(list);
                }

                @Override // ru.avito.component.appbar.AppBar
                public void showToolbar() {
                    this.a.showToolbar();
                }

                @Override // ru.avito.component.appbar.AppBar
                public void setTitle(int i) {
                    this.c.setTitle(i);
                    TextView textView2 = this.b.g;
                    if (textView2 != null) {
                        textView2.setText(i);
                    }
                }
            };
        } else {
            this.a = null;
        }
        BottomSheetBehavior<View> from = BottomSheetBehavior.from(view2);
        Intrinsics.checkNotNullExpressionValue(from, "BottomSheetBehavior.from(bottomSheetView)");
        this.b = from;
        BottomSheetAdapter callbacks = BottomSheetBehaviorsKt.callbacks(from);
        this.c = callbacks;
        callbacks.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback(this) { // from class: com.avito.android.component.bottom_sheet.BottomSheetViewImpl.2
            public final /* synthetic */ BottomSheetViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(@NotNull View view5, float f2) {
                Intrinsics.checkNotNullParameter(view5, "bottomSheet");
                BottomSheetViewImpl bottomSheetViewImpl = this.a;
                Float valueOf = Float.valueOf(f2);
                if (!(Float.compare(valueOf.floatValue(), Float.NaN) != 0)) {
                    valueOf = null;
                }
                BottomSheetViewImpl.access$animateToolbar(bottomSheetViewImpl, valueOf != null ? valueOf.floatValue() : 1.0f);
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(@NotNull View view5, int i) {
                Intrinsics.checkNotNullParameter(view5, "bottomSheet");
                if (this.a.b.getPeekHeight() >= this.a.e.getHeight() && i == 4) {
                    i = 3;
                }
                if (i == 3) {
                    BottomSheetViewImpl.access$animateToolbar(this.a, 1.0f);
                } else if (i == 4) {
                    BottomSheetViewImpl.access$animateToolbar(this.a, 0.0f);
                }
            }
        });
        from.setState(5);
        if (z) {
            show();
        }
    }

    public static final void access$animateToolbar(BottomSheetViewImpl bottomSheetViewImpl, float f2) {
        if (f2 <= 0.0f) {
            View view = bottomSheetViewImpl.f;
            if (view != null) {
                Views.hide(view);
            }
            TextView textView = bottomSheetViewImpl.g;
            if (textView != null) {
                Views.show(textView);
            }
            TextView textView2 = bottomSheetViewImpl.g;
            if (textView2 != null) {
                textView2.setAlpha(1.0f);
            }
        } else if (f2 >= 1.0f) {
            View view2 = bottomSheetViewImpl.f;
            if (view2 != null) {
                Views.show(view2);
            }
            View view3 = bottomSheetViewImpl.f;
            if (view3 != null) {
                view3.setAlpha(1.0f);
            }
            TextView textView3 = bottomSheetViewImpl.g;
            if (textView3 != null) {
                Views.hide(textView3);
            }
        } else {
            View view4 = bottomSheetViewImpl.f;
            if (view4 != null) {
                Views.show(view4);
            }
            View view5 = bottomSheetViewImpl.f;
            if (view5 != null) {
                view5.setAlpha(f2);
            }
            TextView textView4 = bottomSheetViewImpl.g;
            if (textView4 != null) {
                Views.show(textView4);
            }
            TextView textView5 = bottomSheetViewImpl.g;
            if (textView5 != null) {
                textView5.setAlpha(((float) 1) - f2);
            }
        }
    }

    @Override // com.avito.android.component.bottom_sheet.BottomSheetView
    public void close() {
        this.b.setState(5);
    }

    @Override // com.avito.android.component.bottom_sheet.BottomSheetView
    @NotNull
    public Observable<Unit> closeEvents() {
        Observable<Unit> observable;
        Observable<R> map = BottomSheetBehaviorsKt.panelStateChanges(this.c).filter(a.a).map(b.a);
        AppBar appBar = getAppBar();
        if (appBar == null || (observable = appBar.navigationCallbacks()) == null) {
            observable = Observable.never();
        }
        Observable<Unit> merge = Observable.merge(map, Observable.merge(observable, RxView.clicks(this.d)).map(new c(this)).flatMap(new d(this)));
        Intrinsics.checkNotNullExpressionValue(merge, "Observable.merge<Unit>(\n…              }\n        )");
        return merge;
    }

    @Override // com.avito.android.component.bottom_sheet.BottomSheetView
    @Nullable
    public AppBar getAppBar() {
        return this.a;
    }

    @Override // com.avito.android.component.bottom_sheet.BottomSheetView
    public int getPanelState() {
        return this.b.getState();
    }

    @Override // com.avito.android.component.bottom_sheet.BottomSheetView
    public void openFullscreen() {
        this.b.setState(3);
    }

    @Override // com.avito.android.component.bottom_sheet.BottomSheetView
    @NotNull
    public Observable<Integer> panelStateChanges() {
        return BottomSheetBehaviorsKt.panelStateChanges(this.c);
    }

    @Override // com.avito.android.component.bottom_sheet.BottomSheetView
    public void setPeekHeight(int i) {
        this.b.setPeekHeight(i);
    }

    @Override // com.avito.android.component.bottom_sheet.BottomSheetView
    public void show() {
        this.e.post(new e(this));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BottomSheetViewImpl(android.view.View r8, android.view.View r9, android.view.View r10, android.widget.TextView r11, android.view.View r12, boolean r13, int r14, t6.r.a.j r15) {
        /*
            r7 = this;
            r15 = r14 & 2
            if (r15 == 0) goto L_0x000f
            int r9 = com.avito.android.ui_components.R.id.content_container
            android.view.View r9 = r8.findViewById(r9)
            java.lang.String r15 = "null cannot be cast to non-null type android.view.View"
            java.util.Objects.requireNonNull(r9, r15)
        L_0x000f:
            r2 = r9
            r9 = r14 & 4
            if (r9 == 0) goto L_0x001a
            int r9 = com.avito.android.ui_components.R.id.toolbar_container
            android.view.View r10 = r2.findViewById(r9)
        L_0x001a:
            r3 = r10
            r9 = r14 & 8
            if (r9 == 0) goto L_0x0028
            int r9 = com.avito.android.ui_components.R.id.collapsed_state_toolbar
            android.view.View r9 = r2.findViewById(r9)
            r11 = r9
            android.widget.TextView r11 = (android.widget.TextView) r11
        L_0x0028:
            r4 = r11
            r9 = r14 & 16
            if (r9 == 0) goto L_0x002e
            r12 = 0
        L_0x002e:
            r5 = r12
            r9 = r14 & 32
            if (r9 == 0) goto L_0x0036
            r13 = 1
            r6 = 1
            goto L_0x0037
        L_0x0036:
            r6 = r13
        L_0x0037:
            r0 = r7
            r1 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.component.bottom_sheet.BottomSheetViewImpl.<init>(android.view.View, android.view.View, android.view.View, android.widget.TextView, android.view.View, boolean, int, t6.r.a.j):void");
    }
}
