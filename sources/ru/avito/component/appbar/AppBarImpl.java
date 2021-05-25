package ru.avito.component.appbar;

import a2.g.r.g;
import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.design.widget.lifecycle_view.LifecycleView;
import com.avito.android.design.widget.lifecycle_view.StateListener;
import com.avito.android.design.widget.search_view.ToolbarSearchViewKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.ActionMenu;
import com.avito.android.util.Contexts;
import com.avito.android.util.Kundle;
import com.avito.android.util.MenuItemsKt;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.Toolbars;
import com.avito.android.util.Views;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.appbar.floating_toolbar.FloatingToolbarRecyclerViewOnScrollListener;
import ru.avito.component.appbar.floating_toolbar.FloatingToolbarScrollViewOnTouchListener;
import ru.avito.component.appbar.floating_toolbar.ToolbarScrollManager;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010X\u001a\u00020C\u0012\b\u0010Y\u001a\u0004\u0018\u00010C\u0012\b\b\u0002\u0010Z\u001a\u00020)¢\u0006\u0004\b[\u0010\\J\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\fJ\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0012J#\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\t2\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013H\u0016¢\u0006\u0004\b\u001b\u0010\u0015J\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b\u001e\u0010\fJ\u0019\u0010#\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010'\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020)H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b/\u0010,J\u000f\u00100\u001a\u00020!H\u0016¢\u0006\u0004\b0\u00101J)\u00105\u001a\u00020\u00062\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\t2\b\u00104\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0006H\u0002¢\u0006\u0004\b7\u0010\u0012R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u00103\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010\r\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u001c\u0010W\u001a\b\u0012\u0004\u0012\u00020\t0U8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u0010V¨\u0006]"}, d2 = {"Lru/avito/component/appbar/AppBarImpl;", "Lru/avito/component/appbar/AppBar;", "Lcom/avito/android/design/widget/lifecycle_view/StateListener;", "", "Lcom/avito/android/util/ActionMenu;", "actions", "", "showActionsMenu", "(Ljava/util/List;)V", "", "menuId", "setMenu", "(I)V", "menuTintColor", "setMenuTintColor", "menuTintColorAttr", "setMenuTintColorAttr", "hideActionsMenu", "()V", "Lio/reactivex/rxjava3/core/Observable;", "menuCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "showToolbar", "drawableRes", "tintColorAttrId", "setNavigationIcon", "(ILjava/lang/Integer;)V", "navigationCallbacks", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "stringRes", "Lcom/avito/android/util/Kundle;", "state", "onRestoreState", "(Lcom/avito/android/util/Kundle;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setIcon", "(Lcom/avito/android/image_loader/Picture;)V", "", "visible", "setVisible", "(Z)V", "isVisible", "()Z", "setShadowVisible", "onSaveState", "()Lcom/avito/android/util/Kundle;", "itemPosition", "icon", "tintColorAttr", "setActionMenuItemIcon", "(IILjava/lang/Integer;)V", AuthSource.SEND_ABUSE, "Landroidx/appcompat/widget/Toolbar;", "c", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/facebook/drawee/view/SimpleDraweeView;", g.a, "Lcom/facebook/drawee/view/SimpleDraweeView;", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "toolbarContainer", "Landroid/view/View;", "d", "Landroid/view/View;", "toolbarShadow", "Lcom/avito/android/design/widget/lifecycle_view/LifecycleView;", "f", "Lcom/avito/android/design/widget/lifecycle_view/LifecycleView;", "lifecycle", "Lru/avito/component/appbar/floating_toolbar/ToolbarScrollManager;", "h", "Lru/avito/component/appbar/floating_toolbar/ToolbarScrollManager;", "scrollManager", "i", "I", "Landroid/content/Context;", AuthSource.BOOKING_ORDER, "Landroid/content/Context;", "context", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "menuRelay", "rootView", "scrollableView", "isConcealableShadow", "<init>", "(Landroid/view/View;Landroid/view/View;Z)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AppBarImpl implements AppBar, StateListener {
    public final PublishRelay<Integer> a;
    public final Context b;
    public final Toolbar c;
    public final View d;
    public final ViewGroup e;
    public final LifecycleView f;
    public final SimpleDraweeView g;
    public ToolbarScrollManager h;
    @ColorInt
    public int i;

    public static final class a implements Toolbar.OnMenuItemClickListener {
        public final /* synthetic */ AppBarImpl a;

        public a(AppBarImpl appBarImpl) {
            this.a = appBarImpl;
        }

        @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.a.a.accept(Integer.valueOf(menuItem != null ? menuItem.getItemId() : 0));
            return true;
        }
    }

    public AppBarImpl(@NotNull View view, @Nullable View view2, boolean z) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        PublishRelay<Integer> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        this.b = context;
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById;
        this.c = toolbar;
        View findViewById2 = view.findViewById(R.id.shadow);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.d = findViewById2;
        View findViewById3 = view.findViewById(R.id.toolbar_container);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) findViewById3;
        this.e = viewGroup;
        View findViewById4 = view.findViewById(R.id.lifecycle);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.avito.android.design.widget.lifecycle_view.LifecycleView");
        LifecycleView lifecycleView = (LifecycleView) findViewById4;
        this.f = lifecycleView;
        View findViewById5 = view.findViewById(R.id.icon);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.g = (SimpleDraweeView) findViewById5;
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "rootView.context");
        this.i = Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.blue);
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.setDuration(250);
        layoutTransition.setStartDelay(2, 0);
        Unit unit = Unit.INSTANCE;
        viewGroup.setLayoutTransition(layoutTransition);
        lifecycleView.setStateListener(this);
        if (view2 instanceof RecyclerView) {
            FloatingToolbarRecyclerViewOnScrollListener floatingToolbarRecyclerViewOnScrollListener = new FloatingToolbarRecyclerViewOnScrollListener(viewGroup, toolbar, findViewById2, z);
            ((RecyclerView) view2).addOnScrollListener(floatingToolbarRecyclerViewOnScrollListener);
            this.h = floatingToolbarRecyclerViewOnScrollListener;
        } else if (view2 instanceof ScrollView) {
            FloatingToolbarScrollViewOnTouchListener floatingToolbarScrollViewOnTouchListener = new FloatingToolbarScrollViewOnTouchListener((ScrollView) view2, viewGroup, toolbar, findViewById2, z);
            view2.setOnTouchListener(floatingToolbarScrollViewOnTouchListener);
            this.h = floatingToolbarScrollViewOnTouchListener;
        }
        toolbar.setOnMenuItemClickListener(new a(this));
    }

    public final void a() {
        Menu menu = this.c.getMenu();
        Intrinsics.checkNotNullExpressionValue(menu, "toolbar.menu");
        Context context = this.c.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "toolbar.context");
        ToolbarSearchViewKt.tintIcons(menu, context, this.i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void hideActionsMenu() {
        this.c.getMenu().clear();
    }

    @Override // ru.avito.component.appbar.AppBar
    public boolean isVisible() {
        return this.e.getVisibility() == 0;
    }

    @Override // ru.avito.component.appbar.AppBar
    @NotNull
    public Observable<Integer> menuCallbacks() {
        return this.a;
    }

    @Override // ru.avito.component.appbar.AppBar
    @NotNull
    public Observable<Unit> navigationCallbacks() {
        return Toolbars.upClicks(this.c);
    }

    @Override // com.avito.android.design.widget.lifecycle_view.StateListener
    public void onRestoreState(@Nullable Kundle kundle) {
        if (this.e.getTranslationY() == 0.0f) {
            if (Intrinsics.areEqual(kundle != null ? kundle.getBoolean("scrolled") : null, Boolean.TRUE)) {
                Views.show(this.d);
            }
        }
    }

    @Override // com.avito.android.design.widget.lifecycle_view.StateListener
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        ToolbarScrollManager toolbarScrollManager = this.h;
        return kundle.putBoolean("scrolled", Boolean.valueOf(toolbarScrollManager != null ? toolbarScrollManager.isScrolled() : false));
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setActionMenuItemIcon(int i2, int i3, @Nullable Integer num) {
        MenuItem item = this.c.getMenu().getItem(i2);
        item.setIcon(i3);
        if (num != null) {
            MenuItemsKt.tintIconByAttr(item, this.b, num.intValue());
        }
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setIcon(@Nullable Picture picture) {
        if (picture != null) {
            SimpleDraweeViewsKt.loadPicture$default(this.g, picture, null, null, 6, null);
            Views.show(this.g);
            this.c.setTitleMarginStart(this.c.getResources().getDimensionPixelSize(R.dimen.app_bar_title_with_icon_start_margin));
            this.c.requestLayout();
            return;
        }
        Views.hide(this.g);
        this.c.setTitleMarginStart(this.c.getResources().getDimensionPixelSize(R.dimen.app_bar_title_without_icon_start_margin));
        this.c.requestLayout();
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenu(int i2) {
        this.c.getMenu().clear();
        this.c.inflateMenu(i2);
        a();
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenuTintColor(@ColorRes int i2) {
        this.i = Contexts.getColorCompat(this.b, i2);
        a();
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenuTintColorAttr(@AttrRes int i2) {
        this.i = Contexts.getColorByAttr(this.b, i2);
        a();
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setNavigationIcon(int i2, @AttrRes @Nullable Integer num) {
        this.c.setNavigationIcon(i2);
        if (num != null) {
            num.intValue();
            Drawable navigationIcon = this.c.getNavigationIcon();
            if (navigationIcon != null) {
                navigationIcon.setTint(Contexts.getColorByAttr(this.b, num.intValue()));
            }
        }
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setShadowVisible(boolean z) {
        Views.setVisible(this.d, z);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.c.setTitle(charSequence);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setVisible(boolean z) {
        Views.setVisible(this.e, z);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void showActionsMenu(@NotNull List<ActionMenu> list) {
        Intrinsics.checkNotNullParameter(list, "actions");
        this.c.getMenu().clear();
        int i2 = 0;
        for (T t : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Toolbars.addActionMenu(this.c, i2, t);
            i2 = i3;
        }
    }

    @Override // ru.avito.component.appbar.AppBar
    public void showToolbar() {
        ToolbarScrollManager toolbarScrollManager = this.h;
        if (toolbarScrollManager != null) {
            toolbarScrollManager.showToolbar();
        }
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setTitle(int i2) {
        this.c.setTitle(i2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AppBarImpl(View view, View view2, boolean z, int i2, j jVar) {
        this(view, view2, (i2 & 4) != 0 ? true : z);
    }
}
