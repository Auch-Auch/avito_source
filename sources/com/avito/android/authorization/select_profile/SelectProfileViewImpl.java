package com.avito.android.authorization.select_profile;

import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.R;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.PaddingListDecoration;
import com.avito.android.ui.VerticalListItemDecoration;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.jakewharton.rxbinding4.view.RxView;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.appbar.AppBar;
import ru.avito.component.appbar.AppBarImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u00105\u001a\u00020\u0016\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010;\u001a\u00020:¢\u0006\u0004\b<\u0010=J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\tJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\tJ\u001d\u0010\u0014\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001e\u0010\"\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010\u0018R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u0006>"}, d2 = {"Lcom/avito/android/authorization/select_profile/SelectProfileViewImpl;", "Lcom/avito/android/authorization/select_profile/SelectProfileView;", "Lio/reactivex/rxjava3/core/Observable;", "", "navigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "errorRetryClicks", "networkErrorRetryClicks", "showContent", "()V", "showError", "", "message", "showNetworkError", "(Ljava/lang/String;)V", "showProgress", "notifyItemsChanged", "", "", "indexes", "setDividers", "(Ljava/lang/Iterable;)V", "Landroid/view/View;", "d", "Landroid/view/View;", "retryButton", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lru/avito/component/appbar/AppBar;", "e", "Lru/avito/component/appbar/AppBar;", "appBar", "c", "errorContainer", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "f", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "h", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemDecoration", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", g.a, "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "view", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;Lcom/avito/android/analytics/Analytics;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class SelectProfileViewImpl implements SelectProfileView {
    public final Context a;
    public final RecyclerView b;
    public final View c;
    public final View d;
    public final AppBar e;
    public ProgressOverlay f;
    public final SimpleRecyclerAdapter g;
    public RecyclerView.ItemDecoration h;

    public SelectProfileViewImpl(@NotNull View view, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Context context = view.getContext();
        this.a = context;
        int i = R.id.recycler;
        View findViewById = view.findViewById(i);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.b = recyclerView;
        View findViewById2 = view.findViewById(R.id.error_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.c = findViewById2;
        View findViewById3 = view.findViewById(R.id.button_retry);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.d = findViewById3;
        AppBarImpl appBarImpl = new AppBarImpl(view, recyclerView, false, 4, null);
        this.e = appBarImpl;
        View findViewById4 = view.findViewById(R.id.content_container);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.ViewGroup");
        this.f = new ProgressOverlay((ViewGroup) findViewById4, i, analytics, false, 0, 24, null);
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(adapterPresenter, itemBinder);
        this.g = simpleRecyclerAdapter;
        simpleRecyclerAdapter.setHasStableIds(true);
        recyclerView.setAdapter(simpleRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setItemAnimator(null);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        recyclerView.addItemDecoration(new PaddingListDecoration(context.getResources().getDimensionPixelSize(com.avito.android.ui_components.R.dimen.list_top_padding)));
        appBarImpl.setTitle(R.string.registration_title);
    }

    @Override // com.avito.android.authorization.select_profile.SelectProfileView
    @NotNull
    public Observable<Unit> errorRetryClicks() {
        return RxView.clicks(this.d);
    }

    @Override // com.avito.android.authorization.select_profile.SelectProfileView
    @NotNull
    public Observable<Unit> navigationClicks() {
        return this.e.navigationCallbacks();
    }

    @Override // com.avito.android.authorization.select_profile.SelectProfileView
    @NotNull
    public Observable<Unit> networkErrorRetryClicks() {
        return InteropKt.toV3(this.f.refreshes());
    }

    @Override // com.avito.android.authorization.select_profile.SelectProfileView
    public void notifyItemsChanged() {
        this.g.notifyDataSetChanged();
    }

    @Override // com.avito.android.authorization.select_profile.SelectProfileView
    public void setDividers(@NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "indexes");
        RecyclerView.ItemDecoration itemDecoration = this.h;
        if (itemDecoration != null) {
            this.b.removeItemDecoration(itemDecoration);
        }
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(com.avito.android.ui_components.R.dimen.content_horizontal_padding);
        Drawable drawable = this.a.getDrawable(com.avito.android.ui_components.R.drawable.black_12_divider);
        VerticalListItemDecoration.Builder drawForLastItem = new VerticalListItemDecoration.Builder(null, 1, null).setPadding(dimensionPixelSize, dimensionPixelSize).drawForLastItem(false);
        for (Integer num : iterable) {
            drawForLastItem.setDividerForItemAt(num.intValue(), drawable);
        }
        VerticalListItemDecoration build = drawForLastItem.build();
        this.b.addItemDecoration(build);
        Unit unit = Unit.INSTANCE;
        this.h = build;
    }

    @Override // com.avito.android.authorization.select_profile.SelectProfileView
    public void showContent() {
        this.f.showContent();
        Views.hide(this.c);
    }

    @Override // com.avito.android.authorization.select_profile.SelectProfileView
    public void showError() {
        this.f.showContent();
        Views.show(this.c);
    }

    @Override // com.avito.android.authorization.select_profile.SelectProfileView
    public void showNetworkError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.f.showLoadingProblem(str);
    }

    @Override // com.avito.android.authorization.select_profile.SelectProfileView
    public void showProgress() {
        this.f.showLoading();
    }
}
