package com.avito.android.shop.info;

import a2.g.r.g;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.StringRes;
import com.avito.android.analytics.Analytics;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.list_item.ListItem;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.shop.R;
import com.avito.android.util.ActionMenu;
import com.avito.android.util.Views;
import com.facebook.share.internal.MessengerShareContentUtility;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.appbar.AppBar;
import ru.avito.component.appbar.AppBarImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010_\u001a\u00020C\u0012\u0006\u0010\\\u001a\u00020Y\u0012\u0006\u0010a\u001a\u00020`¢\u0006\u0004\bb\u0010cJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0007J\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0007J\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0007J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0007J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0007J\u001d\u0010\u0016\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0018\u0010\tJ\u0010\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u001cH\u0001¢\u0006\u0004\b \u0010\u001fJ.\u0010$\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001d2\b\b\u0001\u0010\"\u001a\u00020\u001d2\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\u001dH\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010(\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010&H\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010+\u001a\u00020\u00052\b\b\u0001\u0010*\u001a\u00020\u001dH\u0001¢\u0006\u0004\b+\u0010,J\u001a\u0010.\u001a\u00020\u00052\b\b\u0001\u0010-\u001a\u00020\u001dH\u0001¢\u0006\u0004\b.\u0010,J\u001a\u00100\u001a\u00020\u00052\b\b\u0001\u0010/\u001a\u00020\u001dH\u0001¢\u0006\u0004\b0\u0010,J&\u00103\u001a\u00020\u00052\b\b\u0001\u00101\u001a\u00020\u001d2\n\b\u0003\u00102\u001a\u0004\u0018\u00010\u001dH\u0001¢\u0006\u0004\b3\u00104J\u0018\u00106\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u0019H\u0001¢\u0006\u0004\b6\u00107J\u0018\u00109\u001a\u00020\u00052\u0006\u0010\f\u001a\u000208H\u0001¢\u0006\u0004\b9\u0010:J\u001a\u00109\u001a\u00020\u00052\b\b\u0001\u0010;\u001a\u00020\u001dH\u0001¢\u0006\u0004\b9\u0010,J\u0018\u0010<\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u0019H\u0001¢\u0006\u0004\b<\u00107J\u001e\u0010@\u001a\u00020\u00052\f\u0010?\u001a\b\u0012\u0004\u0012\u00020>0=H\u0001¢\u0006\u0004\b@\u0010AJ\u0010\u0010B\u001a\u00020\u0005H\u0001¢\u0006\u0004\bB\u0010\tR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010ER\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010MR\u0016\u0010X\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010MR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010M¨\u0006d"}, d2 = {"Lcom/avito/android/shop/info/ShopInfoViewImpl;", "Lcom/avito/android/shop/info/ShopInfoView;", "Lru/avito/component/appbar/AppBar;", "", "error", "", "showError", "(Ljava/lang/String;)V", "showLoading", "()V", "hideLoading", "showRetryOverlay", "title", "showTitle", MessengerShareContentUtility.SUBTITLE, "showSubtitle", "description", "showDescription", "showShopNotFoundError", "setAwards", "Lkotlin/Function0;", "onClick", "setAwardsOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "hideActionsMenu", "", "isVisible", "()Z", "Lio/reactivex/rxjava3/core/Observable;", "", "menuCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "navigationCallbacks", "itemPosition", "icon", "tintColorAttr", "setActionMenuItemIcon", "(IILjava/lang/Integer;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setIcon", "(Lcom/avito/android/image_loader/Picture;)V", "menuId", "setMenu", "(I)V", "menuTintColor", "setMenuTintColor", "menuTintColorAttr", "setMenuTintColorAttr", "drawableRes", "tintColorAttrId", "setNavigationIcon", "(ILjava/lang/Integer;)V", "visible", "setShadowVisible", "(Z)V", "", "setTitle", "(Ljava/lang/CharSequence;)V", "stringRes", "setVisible", "", "Lcom/avito/android/util/ActionMenu;", "actions", "showActionsMenu", "(Ljava/util/List;)V", "showToolbar", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "awardsContainer", "Lcom/avito/android/lib/design/list_item/ListItem;", "f", "Lcom/avito/android/lib/design/list_item/ListItem;", "awardsView", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "titleView", g.a, "container", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "h", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", AuthSource.BOOKING_ORDER, "subtitleView", "d", "notFoundView", "Lcom/avito/android/shop/info/ShopInfoViewPresenter;", "i", "Lcom/avito/android/shop/info/ShopInfoViewPresenter;", "presenter", "c", "descriptionView", "view", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/android/shop/info/ShopInfoViewPresenter;Lcom/avito/android/analytics/Analytics;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopInfoViewImpl implements ShopInfoView, AppBar {
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final ViewGroup e;
    public final ListItem f;
    public final ViewGroup g;
    public final ProgressOverlay h;
    public final ShopInfoViewPresenter i;
    public final /* synthetic */ AppBarImpl j;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ShopInfoViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ShopInfoViewImpl shopInfoViewImpl) {
            super(0);
            this.a = shopInfoViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.i.onRefresh();
            return Unit.INSTANCE;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public ShopInfoViewImpl(@NotNull ViewGroup viewGroup, @NotNull ShopInfoViewPresenter shopInfoViewPresenter, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(viewGroup, "view");
        Intrinsics.checkNotNullParameter(shopInfoViewPresenter, "presenter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.j = new AppBarImpl(viewGroup, null, false, 4, null);
        this.i = shopInfoViewPresenter;
        View findViewById = viewGroup.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.a = (TextView) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.subtitle);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.description);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.shop_not_found);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.d = (TextView) findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.awards_container);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.ViewGroup");
        this.e = (ViewGroup) findViewById5;
        View findViewById6 = viewGroup.findViewById(R.id.awards_button);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type com.avito.android.lib.design.list_item.ListItem");
        this.f = (ListItem) findViewById6;
        View findViewById7 = viewGroup.findViewById(R.id.container);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) findViewById7;
        this.g = viewGroup2;
        ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup2, R.id.scroll_view, analytics, false, 0, 24, null);
        this.h = progressOverlay;
        progressOverlay.setOnRefreshListener(new a(this));
        AppBar.DefaultImpls.setNavigationIcon$default(this, com.avito.android.ui_components.R.drawable.ic_close_24_blue, null, 2, null);
        setTitle(R.string.shop_info);
        View findViewById8 = viewGroup.findViewById(com.avito.android.ui_components.R.id.shadow);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.view.View");
        Views.show(findViewById8);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void hideActionsMenu() {
        this.j.hideActionsMenu();
    }

    @Override // com.avito.android.shop.info.ShopInfoView
    public void hideLoading() {
        this.h.showContent();
    }

    @Override // ru.avito.component.appbar.AppBar
    public boolean isVisible() {
        return this.j.isVisible();
    }

    @Override // ru.avito.component.appbar.AppBar
    @NotNull
    public Observable<Integer> menuCallbacks() {
        return this.j.menuCallbacks();
    }

    @Override // ru.avito.component.appbar.AppBar
    @NotNull
    public Observable<Unit> navigationCallbacks() {
        return this.j.navigationCallbacks();
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setActionMenuItemIcon(int i2, @DrawableRes int i3, @AttrRes @Nullable Integer num) {
        this.j.setActionMenuItemIcon(i2, i3, num);
    }

    @Override // com.avito.android.shop.info.ShopInfoView
    public void setAwards(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.f.setTitle(str);
        Views.show(this.e);
    }

    @Override // com.avito.android.shop.info.ShopInfoView
    public void setAwardsOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onClick");
        this.f.setOnClickListener(new b(function0));
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setIcon(@Nullable Picture picture) {
        this.j.setIcon(picture);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenu(@MenuRes int i2) {
        this.j.setMenu(i2);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenuTintColor(@ColorRes int i2) {
        this.j.setMenuTintColor(i2);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenuTintColorAttr(@AttrRes int i2) {
        this.j.setMenuTintColorAttr(i2);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setNavigationIcon(@DrawableRes int i2, @AttrRes @Nullable Integer num) {
        this.j.setNavigationIcon(i2, num);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setShadowVisible(boolean z) {
        this.j.setShadowVisible(z);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setTitle(@StringRes int i2) {
        this.j.setTitle(i2);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.j.setTitle(charSequence);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setVisible(boolean z) {
        this.j.setVisible(z);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void showActionsMenu(@NotNull List<ActionMenu> list) {
        Intrinsics.checkNotNullParameter(list, "actions");
        this.j.showActionsMenu(list);
    }

    @Override // com.avito.android.shop.info.ShopInfoView
    public void showDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        this.c.setText(str);
    }

    @Override // com.avito.android.shop.info.ShopInfoView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Views.showSnackBar$default(this.g, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.shop.info.ShopInfoView
    public void showLoading() {
        this.h.showLoading();
    }

    @Override // com.avito.android.shop.info.ShopInfoView
    public void showRetryOverlay() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.h, null, 1, null);
    }

    @Override // com.avito.android.shop.info.ShopInfoView
    public void showShopNotFoundError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Views.hide(this.g);
        Views.show(this.d);
        this.d.setText(str);
    }

    @Override // com.avito.android.shop.info.ShopInfoView
    public void showSubtitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, MessengerShareContentUtility.SUBTITLE);
        this.b.setText(str);
    }

    @Override // com.avito.android.shop.info.ShopInfoView
    public void showTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.a.setText(str);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void showToolbar() {
        this.j.showToolbar();
    }
}
