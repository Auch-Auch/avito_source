package com.avito.android.bottom_navigation;

import a2.g.r.g;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.bottom_navigation.ui.AddAdvertDrawable;
import com.avito.android.bottom_navigation.ui.BottomNavigationLayout;
import com.avito.android.bottom_navigation.ui.IconAddAdvertDrawable;
import com.avito.android.bottom_navigation.ui.OnTabClickListener;
import com.avito.android.bottom_navigation.ui.PlusAddAdvertDrawable;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0019B7\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010>\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u00106\u001a\u00020\u0014\u0012\u0006\u0010D\u001a\u00020A¢\u0006\u0004\bL\u0010MJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\n8\u0002@\u0003X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\n8\u0002@\u0003X\u0004¢\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010&\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010!R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\n8\u0002@\u0003X\u0004¢\u0006\u0006\n\u0004\b3\u0010!R\u0016\u00106\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u0010\u001fR\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010!R\u0016\u0010>\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010\u001cR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\n8\u0002@\u0003X\u0004¢\u0006\u0006\n\u0004\bE\u0010!R\u0016\u0010I\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010HR\u0016\u0010K\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010!¨\u0006N"}, d2 = {"Lcom/avito/android/bottom_navigation/BottomNavigationViewImpl;", "Lcom/avito/android/bottom_navigation/BottomNavigationView;", "Lcom/avito/android/bottom_navigation/KeyboardListener;", "Lcom/avito/android/bottom_navigation/ui/OnTabClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setOnTabClickListener", "(Lcom/avito/android/bottom_navigation/ui/OnTabClickListener;)V", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "", "count", "setTabBadge", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;I)V", "selectTab", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)V", "Lcom/avito/android/bottom_navigation/AddButtonState;", "state", "setAddButtonState", "(Lcom/avito/android/bottom_navigation/AddButtonState;)V", "", "isVisible", "setVisible", "(Z)V", "onKeyboardVisibilityChanged", AuthSource.SEND_ABUSE, "Landroid/view/View;", "p", "Landroid/view/View;", "tabContainer", "c", "Z", "i", "I", "bigContentColor", g.a, "bigBackgroundColor", "d", "sizeIcon", "Lcom/avito/android/bottom_navigation/NavigationTabSet;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/bottom_navigation/NavigationTabSet;", "navigationTabSet", "Lcom/avito/android/bottom_navigation/BottomNavigationViewImpl$a;", "l", "Lcom/avito/android/bottom_navigation/BottomNavigationViewImpl$a;", "animationSettings", "Lcom/avito/android/bottom_navigation/ui/BottomNavigationLayout;", "n", "Lcom/avito/android/bottom_navigation/ui/BottomNavigationLayout;", "bottomNavigationLayout", "f", "smallBackgroundColor", VKApiConst.Q, "hideNavigationOnActiveAddTab", "Landroid/animation/ValueAnimator;", AuthSource.BOOKING_ORDER, "Landroid/animation/ValueAnimator;", "addAdvertAnimator", "e", "sizeLargeIcon", "o", "addAdvertButton", "k", "Lcom/avito/android/bottom_navigation/AddButtonState;", "Lcom/avito/android/bottom_navigation/BottomNavigationTestGroup;", "r", "Lcom/avito/android/bottom_navigation/BottomNavigationTestGroup;", "userAdvertsTabTestGroup", "h", "smallContentColor", "Lcom/avito/android/bottom_navigation/ui/AddAdvertDrawable;", "Lcom/avito/android/bottom_navigation/ui/AddAdvertDrawable;", "addAdvertBackground", "j", "navigationHeight", "<init>", "(Lcom/avito/android/bottom_navigation/NavigationTabSet;Lcom/avito/android/bottom_navigation/ui/BottomNavigationLayout;Landroid/view/View;Landroid/view/View;ZLcom/avito/android/bottom_navigation/BottomNavigationTestGroup;)V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
public final class BottomNavigationViewImpl implements BottomNavigationView, KeyboardListener {
    public final AddAdvertDrawable a;
    public ValueAnimator b;
    public boolean c = true;
    public final int d;
    public final int e;
    @ColorInt
    public final int f;
    @ColorInt
    public final int g;
    @ColorInt
    public final int h;
    @ColorInt
    public final int i;
    public final int j;
    public AddButtonState k;
    public final a l;
    public final NavigationTabSet m;
    public final BottomNavigationLayout n;
    public final View o;
    public final View p;
    public final boolean q;
    public final BottomNavigationTestGroup r;

    public static final class a {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final float e;
        public final float f;
        public final int g;
        public final int h;
        public final int i;
        public final int j;
        public final int k;

        public a(int i2, int i3, int i4, int i5, float f2, float f3, int i6, int i7, int i8, int i9, @ColorInt int i10) {
            this.a = i2;
            this.b = i3;
            this.c = i4;
            this.d = i5;
            this.e = f2;
            this.f = f3;
            this.g = i6;
            this.h = i7;
            this.i = i8;
            this.j = i9;
            this.k = i10;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && Float.compare(this.e, aVar.e) == 0 && Float.compare(this.f, aVar.f) == 0 && this.g == aVar.g && this.h == aVar.h && this.i == aVar.i && this.j == aVar.j && this.k == aVar.k;
        }

        public int hashCode() {
            return ((((((((a2.b.a.a.a.i1(this.f, a2.b.a.a.a.i1(this.e, ((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31, 31), 31) + this.g) * 31) + this.h) * 31) + this.i) * 31) + this.j) * 31) + this.k;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("AnimationSettings(startSize=");
            L.append(this.a);
            L.append(", endSize=");
            L.append(this.b);
            L.append(", startRadiusSize=");
            L.append(this.c);
            L.append(", endRadiusSize=");
            L.append(this.d);
            L.append(", startRotation=");
            L.append(this.e);
            L.append(", endRotation=");
            L.append(this.f);
            L.append(", startNavigationTranslationY=");
            L.append(this.g);
            L.append(", endNavigationTranslationY=");
            L.append(this.h);
            L.append(", startLayoutBottomMargin=");
            L.append(this.i);
            L.append(", endLayoutBottomMargin=");
            L.append(this.j);
            L.append(", contentActiveStateColor=");
            return a2.b.a.a.a.j(L, this.k, ")");
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ BottomNavigationViewImpl a;
        public final /* synthetic */ boolean b;

        public b(BottomNavigationViewImpl bottomNavigationViewImpl, boolean z) {
            this.a = bottomNavigationViewImpl;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.a.c) {
                this.a.a(!this.b);
            }
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ BottomNavigationViewImpl a;
        public final /* synthetic */ float b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ float f;
        public final /* synthetic */ float g;
        public final /* synthetic */ int h;
        public final /* synthetic */ int i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ int l;
        public final /* synthetic */ int m;
        public final /* synthetic */ float n;
        public final /* synthetic */ int o;
        public final /* synthetic */ float p;
        public final /* synthetic */ int q;

        public c(BottomNavigationViewImpl bottomNavigationViewImpl, float f2, int i2, int i3, int i4, float f3, float f4, int i5, int i6, int i7, int i8, int i9, int i10, float f5, int i11, float f6, int i12) {
            this.a = bottomNavigationViewImpl;
            this.b = f2;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = f3;
            this.g = f4;
            this.h = i5;
            this.i = i6;
            this.j = i7;
            this.k = i8;
            this.l = i9;
            this.m = i10;
            this.n = f5;
            this.o = i11;
            this.p = f6;
            this.q = i12;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullExpressionValue(valueAnimator, "it");
            float animatedFraction = valueAnimator.getAnimatedFraction();
            BottomNavigationLayout bottomNavigationLayout = this.a.n;
            float f2 = this.b;
            bottomNavigationLayout.setTranslationY(((((float) this.c) - f2) * animatedFraction) + f2);
            ViewGroup.LayoutParams layoutParams = this.a.p.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i2 = this.d;
            if (i2 != 0 || this.e == 0 || animatedFraction >= 1.0f) {
                i2 = this.e;
            }
            marginLayoutParams.bottomMargin = i2;
            View view = this.a.o;
            float f3 = this.f;
            view.setRotation(((this.g - f3) * animatedFraction) + f3);
            int i3 = this.h;
            int i4 = i3 + ((int) (((float) (this.i - i3)) * animatedFraction));
            this.a.o.getLayoutParams().width = i4;
            this.a.o.getLayoutParams().height = i4;
            this.a.a.setBackgroundColor(BottomNavigationViewImpl.access$shiftColor(this.a, this.j, this.k, animatedFraction));
            this.a.a.setContentColor(BottomNavigationViewImpl.access$shiftColor(this.a, this.l, this.m, animatedFraction));
            AddAdvertDrawable addAdvertDrawable = this.a.a;
            float f4 = this.n;
            addAdvertDrawable.setContentSize(((((float) this.o) - f4) * animatedFraction) + f4);
            AddAdvertDrawable addAdvertDrawable2 = this.a.a;
            float f5 = this.p;
            addAdvertDrawable2.setRadiusSize(((((float) this.q) - f5) * animatedFraction) + f5);
            this.a.o.invalidate();
            this.a.o.requestLayout();
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ BottomNavigationViewImpl a;
        public final /* synthetic */ OnTabClickListener b;

        public d(BottomNavigationViewImpl bottomNavigationViewImpl, OnTabClickListener onTabClickListener) {
            this.a = bottomNavigationViewImpl;
            this.b = onTabClickListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            OnTabClickListener onTabClickListener = this.b;
            for (NavigationTabSetItem navigationTabSetItem : this.a.m) {
                if (navigationTabSetItem.getAddButtonState().isActive()) {
                    onTabClickListener.onTabClick(navigationTabSetItem);
                    return;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
    }

    public BottomNavigationViewImpl(@NotNull NavigationTabSet navigationTabSet, @NotNull BottomNavigationLayout bottomNavigationLayout, @NotNull View view, @NotNull View view2, boolean z, @NotNull BottomNavigationTestGroup bottomNavigationTestGroup) {
        a aVar;
        AddAdvertDrawable addAdvertDrawable;
        int i2;
        Intrinsics.checkNotNullParameter(navigationTabSet, "navigationTabSet");
        Intrinsics.checkNotNullParameter(bottomNavigationLayout, "bottomNavigationLayout");
        Intrinsics.checkNotNullParameter(view, "addAdvertButton");
        Intrinsics.checkNotNullParameter(view2, "tabContainer");
        Intrinsics.checkNotNullParameter(bottomNavigationTestGroup, "userAdvertsTabTestGroup");
        this.m = navigationTabSet;
        this.n = bottomNavigationLayout;
        this.o = view;
        this.p = view2;
        this.q = z;
        this.r = bottomNavigationTestGroup;
        Context context = view.getContext();
        Resources resources = view.getResources();
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "addAdvertButton.context");
        context2.getTheme();
        int i3 = R.dimen.bottom_nav_icon_size;
        this.d = resources.getDimensionPixelSize(i3);
        this.e = resources.getDimensionPixelSize(R.dimen.bottom_nav_large_icon_size);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int i4 = R.attr.gray28;
        int colorByAttr = Contexts.getColorByAttr(context, i4);
        this.f = colorByAttr;
        int i5 = R.attr.blue;
        this.g = Contexts.getColorByAttr(context, i5);
        this.h = Contexts.getColorByAttr(context, i4);
        int i6 = R.attr.constantWhite;
        this.i = Contexts.getColorByAttr(context, i6);
        int i7 = R.dimen.bottom_nav_height;
        this.j = resources.getDimensionPixelSize(i7);
        bottomNavigationLayout.setTabs(navigationTabSet, NavigationTab.SEARCH.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        if (bottomNavigationTestGroup.isTest()) {
            aVar = new a(resources.getDimensionPixelSize(i3), resources.getDimensionPixelSize(R.dimen.bottom_nav_icon_big_state_size), 0, resources.getDimensionPixelSize(R.dimen.bottom_nav_circle_radius_big), 0.0f, 0.0f, 0, 0, resources.getDimensionPixelSize(i7), resources.getDimensionPixelSize(i7), Contexts.getColorByAttr(context, i5));
        } else {
            aVar = new a(resources.getDimensionPixelSize(R.dimen.bottom_nav_add_advert_small_plus_length), resources.getDimensionPixelSize(R.dimen.bottom_nav_add_advert_big_plus_length), resources.getDimensionPixelSize(R.dimen.bottom_nav_circle_radius_small), resources.getDimensionPixelSize(R.dimen.bottom_nav_circle_radius_big), 0.0f, 45.0f, 0, resources.getDimensionPixelSize(i7), 0, resources.getDimensionPixelSize(i7), Contexts.getColorByAttr(context, i6));
        }
        this.l = aVar;
        if (bottomNavigationTestGroup.isTest()) {
            Context context3 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "addAdvertButton.context");
            int colorByAttr2 = Contexts.getColorByAttr(context, i6);
            if (bottomNavigationTestGroup == BottomNavigationTestGroup.FLOATING_ADD) {
                i2 = R.drawable.bg_bn_tab_user_adverts;
            } else {
                i2 = R.drawable.bg_bn_tab_user_adverts_with_plus;
            }
            addAdvertDrawable = new IconAddAdvertDrawable(context3, colorByAttr, colorByAttr2, i2, (float) aVar.a, (float) aVar.c);
        } else {
            addAdvertDrawable = new PlusAddAdvertDrawable(colorByAttr, Contexts.getColorByAttr(context, i6), resources.getDimension(R.dimen.bottom_nav_add_advert_plus_width), (float) aVar.a, (float) aVar.c);
        }
        this.a = addAdvertDrawable;
        view.setBackground(addAdvertDrawable);
    }

    public static final int access$shiftColor(BottomNavigationViewImpl bottomNavigationViewImpl, int i2, int i3, float f2) {
        Objects.requireNonNull(bottomNavigationViewImpl);
        return Color.rgb((int) ((((float) (Color.red(i3) - Color.red(i2))) * f2) + ((float) Color.red(i2))), (int) ((((float) (Color.green(i3) - Color.green(i2))) * f2) + ((float) Color.green(i2))), (int) ((((float) (Color.blue(i3) - Color.blue(i2))) * f2) + ((float) Color.blue(i2))));
    }

    public final void a(boolean z) {
        Views.setVisible(this.n, z);
        Views.setVisible(this.o, z);
        Views.changeMargin$default(this.p, 0, 0, 0, z ? this.j : 0, 7, null);
    }

    @Override // com.avito.android.bottom_navigation.KeyboardListener
    public void onKeyboardVisibilityChanged(boolean z) {
        if (!this.c) {
            return;
        }
        if (z) {
            a(!z);
        } else {
            this.n.postDelayed(new b(this, z), 100);
        }
    }

    @Override // com.avito.android.bottom_navigation.BottomNavigationView
    public void selectTab(@NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        this.n.selectTab(navigationTabSetItem);
    }

    @Override // com.avito.android.bottom_navigation.BottomNavigationView
    public void setAddButtonState(@NotNull AddButtonState addButtonState) {
        int i2;
        int i3;
        float f2;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(addButtonState, "state");
        if (addButtonState != this.k && this.c) {
            this.k = addButtonState;
            ValueAnimator valueAnimator = this.b;
            if (valueAnimator != null) {
                valueAnimator.pause();
            }
            float translationY = this.n.getTranslationY();
            if (!this.q || !addButtonState.isActive()) {
                i2 = this.l.g;
            } else {
                i2 = this.l.h;
            }
            ViewGroup.LayoutParams layoutParams = this.p.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            if (!this.q || !addButtonState.isActive()) {
                i3 = this.l.j;
            } else {
                i3 = this.l.i;
            }
            float rotation = this.o.getRotation();
            if (addButtonState.isActive()) {
                f2 = this.l.f;
            } else {
                f2 = this.l.e;
            }
            int i8 = this.o.getLayoutParams().width;
            int i9 = addButtonState.isBig() ? this.e : this.d;
            int backgroundColor = this.a.getBackgroundColor();
            int i10 = addButtonState.isBig() ? this.g : this.f;
            int contentColor = this.a.getContentColor();
            if (addButtonState.isBig()) {
                i4 = this.i;
            } else if (addButtonState.isActive()) {
                i4 = this.l.k;
            } else {
                i4 = this.h;
            }
            float contentSize = this.a.getContentSize();
            if (addButtonState.isBig()) {
                i5 = this.l.b;
            } else {
                i5 = this.l.a;
            }
            float radiusSize = this.a.getRadiusSize();
            if (addButtonState.isBig()) {
                i6 = this.l.d;
            } else {
                i6 = this.l.c;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "animator");
            ofFloat.setDuration(150L);
            ofFloat.addUpdateListener(new c(this, translationY, i2, i7, i3, rotation, f2, i8, i9, backgroundColor, i10, contentColor, i4, contentSize, i5, radiusSize, i6));
            this.b = ofFloat;
            ofFloat.start();
        }
    }

    @Override // com.avito.android.bottom_navigation.BottomNavigationView
    public void setOnTabClickListener(@NotNull OnTabClickListener onTabClickListener) {
        Intrinsics.checkNotNullParameter(onTabClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.n.setOnTabClickListener(onTabClickListener);
        this.o.setOnClickListener(new d(this, onTabClickListener));
    }

    @Override // com.avito.android.bottom_navigation.BottomNavigationView
    public void setTabBadge(@NotNull NavigationTabSetItem navigationTabSetItem, int i2) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        this.n.setTabBadge(navigationTabSetItem, i2);
    }

    @Override // com.avito.android.bottom_navigation.BottomNavigationView
    public void setVisible(boolean z) {
        this.c = z;
        a(z);
    }
}
