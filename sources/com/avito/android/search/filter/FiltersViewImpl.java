package com.avito.android.search.filter;

import a2.a.a.k2.a.b0;
import a2.g.r.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.search_filter.GroupsBackgroundDecoration;
import com.avito.android.ui.VerticalListItemDecoration;
import com.avito.android.ui_components.R;
import com.avito.android.util.ButtonsKt;
import com.avito.android.util.Contexts;
import com.avito.android.util.Keyboards;
import com.avito.android.util.RecyclerViewsKt;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.appbar.AppBar;
import ru.avito.component.appbar.AppBarImpl;
import ru.avito.component.appbar.AppBarsKt;
import ru.avito.component.floating_button.PrimaryFloatingButton;
import ru.avito.component.floating_button.PrimaryFloatingButtonImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010(\u001a\u00020\u0005\u0012\f\u0010?\u001a\b\u0012\u0004\u0012\u00020<0;\u0012\u0006\u0010L\u001a\u00020K¢\u0006\u0004\bM\u0010NJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u0017\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\fJ\u0017\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020<0;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006O"}, d2 = {"Lcom/avito/android/search/filter/FiltersViewImpl;", "Lcom/avito/android/search/filter/FiltersView;", "", "showProgress", "()V", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "hideProgress", "", "message", "showMessage", "(Ljava/lang/String;)V", "", "Lkotlin/ranges/IntRange;", "ranges", "setGroupsBounds", "(Ljava/util/List;)V", "showLoadingFailure", PlatformActions.HIDE_KEYBOARD, "Lio/reactivex/rxjava3/core/Observable;", "refreshClicks", "()Lio/reactivex/rxjava3/core/Observable;", "upClicks", "showClicks", "dispose", "showLiveSearchProgress", "hideLiveSearchProgress", "title", "setButtonTitle", "", "isEnabled", "setShowButtonEnabled", "(Z)V", "onDataChanged", "Landroid/graphics/drawable/Drawable;", AuthSource.SEND_ABUSE, "()Landroid/graphics/drawable/Drawable;", "i", "Landroid/view/View;", "view", "d", "progressLayout", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lru/avito/component/floating_button/PrimaryFloatingButton;", "e", "Lru/avito/component/floating_button/PrimaryFloatingButton;", "showAdvertsButton", "Lcom/avito/android/search/filter/KeyboardVisibilityDetector;", "f", "Lcom/avito/android/search/filter/KeyboardVisibilityDetector;", "keyboardDetector", "Lru/avito/component/appbar/AppBar;", AuthSource.BOOKING_ORDER, "Lru/avito/component/appbar/AppBar;", "appBar", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "j", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroid/os/Handler;", g.a, "Landroid/os/Handler;", "handler", "Lcom/avito/android/search_filter/GroupsBackgroundDecoration;", "h", "Lcom/avito/android/search_filter/GroupsBackgroundDecoration;", "groupsBackgroundDecoration", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView$Adapter;Lcom/avito/android/analytics/Analytics;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class FiltersViewImpl implements FiltersView {
    public final RecyclerView a;
    public final AppBar b;
    public final ProgressOverlay c;
    public final View d;
    public final PrimaryFloatingButton e;
    public final KeyboardVisibilityDetector f;
    public final Handler g = new Handler(Looper.getMainLooper());
    public GroupsBackgroundDecoration h;
    public final View i;
    public final RecyclerView.Adapter<BaseViewHolder> j;

    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ FiltersViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(FiltersViewImpl filtersViewImpl) {
            super(1);
            this.a = filtersViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            if (bool.booleanValue()) {
                ButtonsKt.hide(this.a.e);
            } else {
                this.a.g.post(new b0(this));
            }
            return Unit.INSTANCE;
        }
    }

    public FiltersViewImpl(@NotNull View view, @NotNull RecyclerView.Adapter<BaseViewHolder> adapter, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.i = view;
        this.j = adapter;
        int i2 = R.id.recycler_view;
        View findViewById = view.findViewById(i2);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.a = recyclerView;
        AppBarImpl appBarImpl = new AppBarImpl(view, recyclerView, false, 4, null);
        this.b = appBarImpl;
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        this.c = new ProgressOverlay((ViewGroup) view, i2, analytics, false, 0, 24, null);
        View findViewById2 = view.findViewById(R.id.progress);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.d = findViewById2;
        View findViewById3 = view.findViewById(R.id.btn_show_adverts);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.e = new PrimaryFloatingButtonImpl(findViewById3);
        AppBarsKt.setCloseIcon(appBarImpl);
        appBarImpl.setTitle(R.string.clarify);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        List<Number> emptyList = CollectionsKt__CollectionsKt.emptyList();
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(R.dimen.component_horizontal_padding);
        VerticalListItemDecoration.Builder padding = new VerticalListItemDecoration.Builder(a()).drawForLastItem(false).setPadding(dimensionPixelSize, dimensionPixelSize);
        for (Number number : emptyList) {
            padding.disableDividerForItemAt(number.intValue());
        }
        recyclerView.addItemDecoration(padding.build());
        this.a.setItemAnimator(null);
        View rootView = this.i.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
        this.f = new KeyboardVisibilityDetector(rootView, new a(this));
    }

    public final Drawable a() {
        int i2 = R.drawable.filters_view_divider;
        Resources resources = this.i.getResources();
        Context context = this.i.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Drawable drawable = resources.getDrawable(i2, context.getTheme());
        if (drawable != null) {
            return drawable;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.avito.android.search.filter.FiltersView
    public void dispose() {
        this.g.removeCallbacksAndMessages(null);
        this.f.dispose();
    }

    @Override // com.avito.android.search.filter.FiltersView
    @NotNull
    public View getRootView() {
        return this.i;
    }

    @Override // com.avito.android.search.filter.FiltersView
    public void hideKeyboard() {
        Keyboards.hideKeyboard$default(this.i, false, 1, null);
    }

    @Override // com.avito.android.search.filter.FiltersView
    public void hideLiveSearchProgress() {
        this.e.setProgressBarVisible(false);
    }

    @Override // com.avito.android.search.filter.FiltersView
    public void hideProgress() {
        this.c.showContent();
        Views.hide(this.d);
    }

    @Override // com.avito.android.search.filter.FiltersView
    public void onDataChanged() {
        if (this.a.getAdapter() == null) {
            this.a.setAdapter(this.j);
        }
    }

    @Override // com.avito.android.search.filter.FiltersView
    @NotNull
    public Observable<Unit> refreshClicks() {
        return InteropKt.toV3(this.c.refreshes());
    }

    @Override // com.avito.android.search.filter.FiltersView
    public void setButtonTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.e.setText(str);
    }

    @Override // com.avito.android.search.filter.FiltersView
    public void setGroupsBounds(@NotNull List<IntRange> list) {
        Intrinsics.checkNotNullParameter(list, "ranges");
        if (this.h == null) {
            View view = this.i;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            view.setBackgroundColor(Contexts.getColorCompat(context, com.avito.android.lib.design.avito.R.color.expected_filters_background));
            Drawable drawable = this.i.getContext().getDrawable(R.drawable.bg_publish_card);
            if (drawable != null) {
                GroupsBackgroundDecoration groupsBackgroundDecoration = new GroupsBackgroundDecoration(drawable, a(), this.i.getResources().getDimensionPixelSize(R.dimen.filters_decoration_vertical_padding), this.i.getResources().getDimensionPixelSize(R.dimen.component_horizontal_padding), null, 16, null);
                this.h = groupsBackgroundDecoration;
                RecyclerViewsKt.clearItemDecorations(this.a);
                this.a.addItemDecoration(groupsBackgroundDecoration);
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        GroupsBackgroundDecoration groupsBackgroundDecoration2 = this.h;
        if (groupsBackgroundDecoration2 != null) {
            groupsBackgroundDecoration2.setRanges(list);
        }
        RecyclerViewsKt.invalidateItemDecorationsSafely(this.a);
    }

    @Override // com.avito.android.search.filter.FiltersView
    public void setShowButtonEnabled(boolean z) {
        this.e.setEnabled(z);
    }

    @Override // com.avito.android.search.filter.FiltersView
    @NotNull
    public Observable<Unit> showClicks() {
        return ButtonsKt.clicks(this.e);
    }

    @Override // com.avito.android.search.filter.FiltersView
    public void showLiveSearchProgress() {
        this.e.setProgressBarVisible(true);
    }

    @Override // com.avito.android.search.filter.FiltersView
    public void showLoadingFailure() {
        this.b.showToolbar();
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.c, null, 1, null);
    }

    @Override // com.avito.android.search.filter.FiltersView
    public void showMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.showSnackBar$default(this.i, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.search.filter.FiltersView
    public void showProgress() {
        this.c.showContent();
        this.b.showToolbar();
        Views.show(this.d);
    }

    @Override // com.avito.android.search.filter.FiltersView
    @NotNull
    public Observable<Unit> upClicks() {
        return this.b.navigationCallbacks();
    }
}
