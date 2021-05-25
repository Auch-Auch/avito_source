package com.avito.android.profile;

import a2.g.r.g;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.image_loader.Picture;
import com.avito.android.profile.UserProfileView;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.ui_components.R;
import com.avito.android.util.ActionMenu;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxkotlin.DisposableKt;
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
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\u0006\u0010U\u001a\u00020@\u0012\u0006\u0010W\u001a\u00020V\u0012\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020Y0X\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u0010\\\u001a\u00020[\u0012\b\b\u0002\u0010]\u001a\u00020\u0011¢\u0006\u0004\b^\u0010_J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0010\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014H\u0001¢\u0006\u0004\b\u0018\u0010\u0017J.\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00152\b\b\u0001\u0010\u001a\u001a\u00020\u00152\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010#\u001a\u00020\u00032\b\b\u0001\u0010\"\u001a\u00020\u0015H\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010&\u001a\u00020\u00032\b\b\u0001\u0010%\u001a\u00020\u0015H\u0001¢\u0006\u0004\b&\u0010$J\u001a\u0010(\u001a\u00020\u00032\b\b\u0001\u0010'\u001a\u00020\u0015H\u0001¢\u0006\u0004\b(\u0010$J&\u0010+\u001a\u00020\u00032\b\b\u0001\u0010)\u001a\u00020\u00152\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0004\b+\u0010,J\u0018\u0010.\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0011H\u0001¢\u0006\u0004\b.\u0010/J\u0018\u00102\u001a\u00020\u00032\u0006\u00101\u001a\u000200H\u0001¢\u0006\u0004\b2\u00103J\u001a\u00102\u001a\u00020\u00032\b\b\u0001\u00104\u001a\u00020\u0015H\u0001¢\u0006\u0004\b2\u0010$J\u0018\u00105\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0011H\u0001¢\u0006\u0004\b5\u0010/J\u001e\u00109\u001a\u00020\u00032\f\u00108\u001a\b\u0012\u0004\u0012\u00020706H\u0001¢\u0006\u0004\b9\u0010:J\u0010\u0010;\u001a\u00020\u0003H\u0001¢\u0006\u0004\b;\u0010\u0005R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010B¨\u0006`"}, d2 = {"Lcom/avito/android/profile/UserProfileViewImpl;", "Lcom/avito/android/profile/UserProfileView;", "Lru/avito/component/appbar/AppBar;", "", "showProgress", "()V", "showLogoutProgress", "showError", "", "message", "showSnackbar", "(Ljava/lang/String;)V", "showContent", "onDataChanged", "destroy", PlatformActions.HIDE_KEYBOARD, "hideActionsMenu", "", "isVisible", "()Z", "Lio/reactivex/rxjava3/core/Observable;", "", "menuCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "navigationCallbacks", "itemPosition", "icon", "tintColorAttr", "setActionMenuItemIcon", "(IILjava/lang/Integer;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setIcon", "(Lcom/avito/android/image_loader/Picture;)V", "menuId", "setMenu", "(I)V", "menuTintColor", "setMenuTintColor", "menuTintColorAttr", "setMenuTintColorAttr", "drawableRes", "tintColorAttrId", "setNavigationIcon", "(ILjava/lang/Integer;)V", "visible", "setShadowVisible", "(Z)V", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "stringRes", "setVisible", "", "Lcom/avito/android/util/ActionMenu;", "actions", "showActionsMenu", "(Ljava/util/List;)V", "showToolbar", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "d", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Landroid/view/View;", "c", "Landroid/view/View;", "logoutProgress", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/android/progress_overlay/ProgressOverlay;", AuthSource.SEND_ABUSE, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/profile/UserProfileView$Presenter;", g.a, "Lcom/avito/android/profile/UserProfileView$Presenter;", "presenter", "Lio/reactivex/disposables/CompositeDisposable;", "e", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "f", "view", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "viewHolderFactory", "Lcom/avito/android/analytics/Analytics;", "analytics", "isConcealableToolbarShadow", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/blueprint/ViewHolderBuilder;Lcom/avito/android/profile/UserProfileView$Presenter;Lcom/avito/android/analytics/Analytics;Z)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class UserProfileViewImpl implements UserProfileView, AppBar {
    public ProgressOverlay a;
    public final RecyclerView b;
    public final View c;
    public final SimpleRecyclerAdapter d;
    public final CompositeDisposable e;
    public final View f;
    public final UserProfileView.Presenter g;
    public final /* synthetic */ AppBarImpl h;

    public static final class a<T> implements Consumer<Integer> {
        public final /* synthetic */ UserProfileViewImpl a;

        public a(UserProfileViewImpl userProfileViewImpl) {
            this.a = userProfileViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Integer num) {
            Integer num2 = num;
            UserProfileView.Presenter presenter = this.a.g;
            Intrinsics.checkNotNullExpressionValue(num2, "it");
            presenter.onActionClicked(num2.intValue());
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ UserProfileViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(UserProfileViewImpl userProfileViewImpl) {
            super(0);
            this.a = userProfileViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.g.onRetryClicked();
            return Unit.INSTANCE;
        }
    }

    public UserProfileViewImpl(@NotNull View view, @NotNull AdapterPresenter adapterPresenter, @NotNull ViewHolderBuilder<? extends BaseViewHolder> viewHolderBuilder, @NotNull UserProfileView.Presenter presenter, @NotNull Analytics analytics, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(viewHolderBuilder, "viewHolderFactory");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        int i = R.id.recycler;
        View findViewById = view.findViewById(i);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.h = new AppBarImpl(view, findViewById, z);
        this.f = view;
        this.g = presenter;
        View findViewById2 = view.findViewById(R.id.recycler_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
        this.a = new ProgressOverlay((ViewGroup) findViewById2, i, analytics, false, 0, 24, null);
        View findViewById3 = view.findViewById(i);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById3;
        this.b = recyclerView;
        View findViewById4 = view.findViewById(R.id.logout_progress);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.c = findViewById4;
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(adapterPresenter, viewHolderBuilder);
        this.d = simpleRecyclerAdapter;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.e = compositeDisposable;
        if (!z) {
            View findViewById5 = view.findViewById(R.id.shadow);
            Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
            Views.show(findViewById5);
        }
        Disposable subscribe = InteropKt.toV2(menuCallbacks()).subscribe(new a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "menuCallbacks().toV2()\n …ed(it)\n            }, {})");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        this.a.setOnRefreshListener(new c(this));
        recyclerView.setAdapter(simpleRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    @Override // com.avito.android.profile.UserProfileView
    public void destroy() {
        this.e.clear();
    }

    @Override // ru.avito.component.appbar.AppBar
    public void hideActionsMenu() {
        this.h.hideActionsMenu();
    }

    @Override // com.avito.android.profile.UserProfileView
    public void hideKeyboard() {
        Keyboards.hideKeyboard$default(this.f, false, 1, null);
    }

    @Override // ru.avito.component.appbar.AppBar
    public boolean isVisible() {
        return this.h.isVisible();
    }

    @Override // ru.avito.component.appbar.AppBar
    @NotNull
    public Observable<Integer> menuCallbacks() {
        return this.h.menuCallbacks();
    }

    @Override // ru.avito.component.appbar.AppBar
    @NotNull
    public Observable<Unit> navigationCallbacks() {
        return this.h.navigationCallbacks();
    }

    @Override // com.avito.android.profile.UserProfileView
    public void onDataChanged() {
        this.d.notifyDataSetChanged();
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setActionMenuItemIcon(int i, @DrawableRes int i2, @AttrRes @Nullable Integer num) {
        this.h.setActionMenuItemIcon(i, i2, num);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setIcon(@Nullable Picture picture) {
        this.h.setIcon(picture);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenu(@MenuRes int i) {
        this.h.setMenu(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenuTintColor(@ColorRes int i) {
        this.h.setMenuTintColor(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenuTintColorAttr(@AttrRes int i) {
        this.h.setMenuTintColorAttr(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setNavigationIcon(@DrawableRes int i, @AttrRes @Nullable Integer num) {
        this.h.setNavigationIcon(i, num);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setShadowVisible(boolean z) {
        this.h.setShadowVisible(z);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setTitle(@StringRes int i) {
        this.h.setTitle(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.h.setTitle(charSequence);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setVisible(boolean z) {
        this.h.setVisible(z);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void showActionsMenu(@NotNull List<ActionMenu> list) {
        Intrinsics.checkNotNullParameter(list, "actions");
        this.h.showActionsMenu(list);
    }

    @Override // com.avito.android.profile.UserProfileView
    public void showContent() {
        this.a.showContent();
        Views.hide(this.c);
    }

    @Override // com.avito.android.profile.UserProfileView
    public void showError() {
        showToolbar();
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.a, null, 1, null);
        Views.hide(this.c);
    }

    @Override // com.avito.android.profile.UserProfileView
    public void showLogoutProgress() {
        showContent();
        showToolbar();
        Views.show(this.c);
    }

    @Override // com.avito.android.profile.UserProfileView
    public void showProgress() {
        showToolbar();
        this.a.showLoading();
        Views.hide(this.c);
    }

    @Override // com.avito.android.profile.UserProfileView
    public void showSnackbar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.showSnackBar$default(this.f, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void showToolbar() {
        this.h.showToolbar();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserProfileViewImpl(View view, AdapterPresenter adapterPresenter, ViewHolderBuilder viewHolderBuilder, UserProfileView.Presenter presenter, Analytics analytics, boolean z, int i, j jVar) {
        this(view, adapterPresenter, viewHolderBuilder, presenter, analytics, (i & 32) != 0 ? a2.b.a.a.a.u1(view, "view.context").getBoolean(R.bool.profile_concealable_toolbar_shadow) : z);
    }
}
