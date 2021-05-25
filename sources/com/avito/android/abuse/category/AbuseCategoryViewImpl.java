package com.avito.android.abuse.category;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.deprecated_design.R;
import com.avito.android.image_loader.Picture;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ActionMenu;
import com.avito.android.util.Toolbars;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.appbar.AppBar;
import ru.avito.component.appbar.AppBarImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u0010U\u001a\u00020T¢\u0006\u0004\bV\u0010WJ\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\bJ\u0010\u0010\u0012\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0012\u0010\bJ\u0010\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003H\u0001¢\u0006\u0004\b\u0017\u0010\u0006J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0001¢\u0006\u0004\b\u0018\u0010\u0006J.\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00162\b\b\u0001\u0010\u001a\u001a\u00020\u00162\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u0016H\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010#\u001a\u00020\u00042\b\b\u0001\u0010\"\u001a\u00020\u0016H\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010&\u001a\u00020\u00042\b\b\u0001\u0010%\u001a\u00020\u0016H\u0001¢\u0006\u0004\b&\u0010$J\u001a\u0010(\u001a\u00020\u00042\b\b\u0001\u0010'\u001a\u00020\u0016H\u0001¢\u0006\u0004\b(\u0010$J&\u0010+\u001a\u00020\u00042\b\b\u0001\u0010)\u001a\u00020\u00162\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\u0016H\u0001¢\u0006\u0004\b+\u0010,J\u0018\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0013H\u0001¢\u0006\u0004\b.\u0010/J\u0018\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u000200H\u0001¢\u0006\u0004\b2\u00103J\u001a\u00102\u001a\u00020\u00042\b\b\u0001\u00104\u001a\u00020\u0016H\u0001¢\u0006\u0004\b2\u0010$J\u0018\u00105\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0013H\u0001¢\u0006\u0004\b5\u0010/J\u001e\u00109\u001a\u00020\u00042\f\u00108\u001a\b\u0012\u0004\u0012\u00020706H\u0001¢\u0006\u0004\b9\u0010:J\u0010\u0010;\u001a\u00020\u0004H\u0001¢\u0006\u0004\b;\u0010\bR\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010R¨\u0006X"}, d2 = {"Lcom/avito/android/abuse/category/AbuseCategoryViewImpl;", "Lcom/avito/android/abuse/category/AbuseCategoryView;", "Lru/avito/component/appbar/AppBar;", "Lio/reactivex/rxjava3/core/Observable;", "", "backClicks", "()Lio/reactivex/rxjava3/core/Observable;", "showBackIcon", "()V", "showCloseIcon", "retryClicks", "showLoading", "showContent", "", "error", "showError", "(Ljava/lang/String;)V", "notifyDataChanged", "hideActionsMenu", "", "isVisible", "()Z", "", "menuCallbacks", "navigationCallbacks", "itemPosition", "icon", "tintColorAttr", "setActionMenuItemIcon", "(IILjava/lang/Integer;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setIcon", "(Lcom/avito/android/image_loader/Picture;)V", "menuId", "setMenu", "(I)V", "menuTintColor", "setMenuTintColor", "menuTintColorAttr", "setMenuTintColorAttr", "drawableRes", "tintColorAttrId", "setNavigationIcon", "(ILjava/lang/Integer;)V", "visible", "setShadowVisible", "(Z)V", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "stringRes", "setVisible", "", "Lcom/avito/android/util/ActionMenu;", "actions", "showActionsMenu", "(Ljava/util/List;)V", "showToolbar", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "toolbarShadow", "Landroidx/appcompat/widget/Toolbar;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "rootView", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "f", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "d", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;Lcom/avito/android/analytics/Analytics;)V", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class AbuseCategoryViewImpl implements AbuseCategoryView, AppBar {
    public final Toolbar a;
    public final View b;
    public final RecyclerView c;
    public ProgressOverlay d;
    public final ViewGroup e;
    public final SimpleRecyclerAdapter f;
    public final /* synthetic */ AppBarImpl g;

    public static final class a<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ AbuseCategoryViewImpl a;

        /* renamed from: com.avito.android.abuse.category.AbuseCategoryViewImpl$a$a  reason: collision with other inner class name */
        public static final class View$OnClickListenerC0127a implements View.OnClickListener {
            public final /* synthetic */ ObservableEmitter a;

            public View$OnClickListenerC0127a(ObservableEmitter observableEmitter) {
                this.a = observableEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.onNext(Unit.INSTANCE);
            }
        }

        public a(AbuseCategoryViewImpl abuseCategoryViewImpl) {
            this.a = abuseCategoryViewImpl;
        }

        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Unit> observableEmitter) {
            this.a.a.setNavigationOnClickListener(new View$OnClickListenerC0127a(observableEmitter));
        }
    }

    public AbuseCategoryViewImpl(@NotNull ViewGroup viewGroup, @NotNull SimpleRecyclerAdapter simpleRecyclerAdapter, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.g = new AppBarImpl(viewGroup, null, false, 4, null);
        this.e = viewGroup;
        this.f = simpleRecyclerAdapter;
        View findViewById = viewGroup.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById;
        this.a = toolbar;
        View findViewById2 = viewGroup.findViewById(com.avito.android.ui_components.R.id.shadow);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById2;
        int i = com.avito.android.abuse.R.id.recycler;
        View findViewById3 = viewGroup.findViewById(i);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById3;
        this.c = recyclerView;
        View findViewById4 = viewGroup.findViewById(com.avito.android.abuse.R.id.content_container);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.ViewGroup");
        this.d = new ProgressOverlay((ViewGroup) findViewById4, i, analytics, false, 0, 24, null);
        toolbar.setTitle(com.avito.android.abuse.R.string.abuse_details_title);
        Views.show(findViewById2);
        simpleRecyclerAdapter.setHasStableIds(true);
        recyclerView.setAdapter(simpleRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(viewGroup.getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(300);
        }
    }

    @Override // com.avito.android.abuse.category.AbuseCategoryView
    @NotNull
    public Observable<Unit> backClicks() {
        Observable<Unit> create = Observable.create(new a(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…ext(Unit)\n        }\n    }");
        return create;
    }

    @Override // ru.avito.component.appbar.AppBar
    public void hideActionsMenu() {
        this.g.hideActionsMenu();
    }

    @Override // ru.avito.component.appbar.AppBar
    public boolean isVisible() {
        return this.g.isVisible();
    }

    @Override // ru.avito.component.appbar.AppBar
    @NotNull
    public Observable<Integer> menuCallbacks() {
        return this.g.menuCallbacks();
    }

    @Override // ru.avito.component.appbar.AppBar
    @NotNull
    public Observable<Unit> navigationCallbacks() {
        return this.g.navigationCallbacks();
    }

    @Override // com.avito.android.abuse.category.AbuseCategoryView
    public void notifyDataChanged() {
        this.f.notifyDataSetChanged();
    }

    @Override // com.avito.android.abuse.category.AbuseCategoryView
    @NotNull
    public Observable<Unit> retryClicks() {
        return InteropKt.toV3(this.d.refreshes());
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setActionMenuItemIcon(int i, @DrawableRes int i2, @AttrRes @Nullable Integer num) {
        this.g.setActionMenuItemIcon(i, i2, num);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setIcon(@Nullable Picture picture) {
        this.g.setIcon(picture);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenu(@MenuRes int i) {
        this.g.setMenu(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenuTintColor(@ColorRes int i) {
        this.g.setMenuTintColor(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenuTintColorAttr(@AttrRes int i) {
        this.g.setMenuTintColorAttr(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setNavigationIcon(@DrawableRes int i, @AttrRes @Nullable Integer num) {
        this.g.setNavigationIcon(i, num);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setShadowVisible(boolean z) {
        this.g.setShadowVisible(z);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setTitle(@StringRes int i) {
        this.g.setTitle(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.g.setTitle(charSequence);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setVisible(boolean z) {
        this.g.setVisible(z);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void showActionsMenu(@NotNull List<ActionMenu> list) {
        Intrinsics.checkNotNullParameter(list, "actions");
        this.g.showActionsMenu(list);
    }

    @Override // com.avito.android.abuse.category.AbuseCategoryView
    public void showBackIcon() {
        Toolbars.setBackIcon$default(this.a, 0, 1, null);
    }

    @Override // com.avito.android.abuse.category.AbuseCategoryView
    public void showCloseIcon() {
        Toolbars.setCloseIcon(this.a);
    }

    @Override // com.avito.android.abuse.category.AbuseCategoryView
    public void showContent() {
        this.d.showContent();
    }

    @Override // com.avito.android.abuse.category.AbuseCategoryView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.d.showLoadingProblem(str);
    }

    @Override // com.avito.android.abuse.category.AbuseCategoryView
    public void showLoading() {
        this.d.showLoading();
    }

    @Override // ru.avito.component.appbar.AppBar
    public void showToolbar() {
        this.g.showToolbar();
    }
}
