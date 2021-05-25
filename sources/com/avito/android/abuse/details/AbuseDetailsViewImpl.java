package com.avito.android.abuse.details;

import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.abuse.R;
import com.avito.android.analytics.Analytics;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.ui.VerticalListItemDecoration;
import com.avito.android.util.AvitoSnackbar;
import com.avito.android.util.Keyboards;
import com.avito.android.util.MenuItemsKt;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jakewharton.rxbinding4.view.RxMenuItem;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.appbar.AppBar;
import ru.avito.component.appbar.AppBarImpl;
import ru.avito.component.appbar.AppBarsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010A\u001a\u00020>\u0012\u0006\u0010C\u001a\u00020B\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010G\u001a\u00020F¢\u0006\u0004\bH\u0010IJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ%\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ\u001d\u0010\u001e\u001a\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b \u0010\u0004R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001e\u00109\u001a\n 6*\u0004\u0018\u000105058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006J"}, d2 = {"Lcom/avito/android/abuse/details/AbuseDetailsViewImpl;", "Lcom/avito/android/abuse/details/AbuseDetailsView;", "", "showCloseNavigation", "()V", "showBackNavigation", "showSendButton", "hideSendButton", "Lio/reactivex/rxjava3/core/Observable;", "sendClicks", "()Lio/reactivex/rxjava3/core/Observable;", "navigationClicks", "", "message", "Lkotlin/Function0;", "callback", "showError", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "showSnackbar", "(Ljava/lang/String;)V", "showLoading", "showContent", "notifyItemsChanged", "", FirebaseAnalytics.Param.INDEX, "notifyItemRemoved", "(I)V", "scrollToPosition", "", "indexes", "setDividers", "(Ljava/lang/Iterable;)V", PlatformActions.HIDE_KEYBOARD, "Landroid/view/MenuItem;", g.a, "Landroid/view/MenuItem;", "sendMenuItem", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "f", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemDecoration", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "e", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "d", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lru/avito/component/appbar/AppBar;", "c", "Lru/avito/component/appbar/AppBar;", "appBar", "Landroid/view/View;", "h", "Landroid/view/View;", "rootView", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;Lcom/avito/android/analytics/Analytics;)V", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class AbuseDetailsViewImpl implements AbuseDetailsView {
    public final Context a;
    public final RecyclerView b;
    public final AppBar c;
    public ProgressOverlay d;
    public final SimpleRecyclerAdapter e;
    public RecyclerView.ItemDecoration f;
    public final MenuItem g;
    public final View h;

    public AbuseDetailsViewImpl(@NotNull View view, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.h = view;
        this.a = view.getContext();
        int i = R.id.recycler;
        View findViewById = view.findViewById(i);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.b = recyclerView;
        AppBarImpl appBarImpl = new AppBarImpl(view, null, false, 4, null);
        this.c = appBarImpl;
        View findViewById2 = view.findViewById(R.id.content_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
        this.d = new ProgressOverlay((ViewGroup) findViewById2, i, analytics, false, 0, 24, null);
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(adapterPresenter, itemBinder);
        this.e = simpleRecyclerAdapter;
        simpleRecyclerAdapter.setHasStableIds(true);
        recyclerView.setAdapter(simpleRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setItemAnimator(null);
        View findViewById3 = view.findViewById(com.avito.android.ui_components.R.id.shadow);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        Views.show(findViewById3);
        View findViewById4 = view.findViewById(com.avito.android.deprecated_design.R.id.toolbar);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        MenuItem add = ((Toolbar) findViewById4).getMenu().add(com.avito.android.ui_components.R.string.send);
        Intrinsics.checkNotNullExpressionValue(add, "toolbar.menu.add(ui_R.string.send)");
        this.g = add;
        add.setShowAsAction(2);
        appBarImpl.setTitle(R.string.abuse_details_title);
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsView
    public void hideKeyboard() {
        Keyboards.hideKeyboard$default(this.h, false, 1, null);
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsView
    public void hideSendButton() {
        MenuItemsKt.hide(this.g);
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsView
    @NotNull
    public Observable<Unit> navigationClicks() {
        return this.c.navigationCallbacks();
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsView
    public void notifyItemRemoved(int i) {
        this.e.notifyItemRemoved(i);
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsView
    public void notifyItemsChanged() {
        this.e.notifyDataSetChanged();
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsView
    public void scrollToPosition(int i) {
        this.b.smoothScrollToPosition(i);
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsView
    @NotNull
    public Observable<Unit> sendClicks() {
        return RxMenuItem.clicks$default(this.g, null, 1, null);
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsView
    public void setDividers(@NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "indexes");
        RecyclerView.ItemDecoration itemDecoration = this.f;
        if (itemDecoration != null) {
            this.b.removeItemDecoration(itemDecoration);
        }
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(com.avito.android.ui_components.R.dimen.component_horizontal_padding);
        Drawable drawable = this.a.getDrawable(com.avito.android.ui_components.R.drawable.black_12_divider);
        VerticalListItemDecoration.Builder padding = new VerticalListItemDecoration.Builder(null, 1, null).setPadding(dimensionPixelSize, dimensionPixelSize);
        for (Integer num : iterable) {
            padding.setDividerForItemAt(num.intValue(), drawable);
        }
        VerticalListItemDecoration build = padding.build();
        this.b.addItemDecoration(build);
        Unit unit = Unit.INSTANCE;
        this.f = build;
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsView
    public void showBackNavigation() {
        AppBarsKt.setBackIcon(this.c);
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsView
    public void showCloseNavigation() {
        AppBarsKt.setCloseIcon(this.c);
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsView
    public void showContent() {
        this.d.showContent();
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsView
    public void showError(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(function0, "callback");
        this.d.showLoadingProblem(str);
        this.d.setOnRefreshListener(function0);
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsView
    public void showLoading() {
        this.d.showLoading();
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsView
    public void showSendButton() {
        MenuItemsKt.show(this.g);
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsView
    public void showSnackbar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        AvitoSnackbar.make$default(AvitoSnackbar.INSTANCE, this.b, str, 0, null, 0, null, null, 0, 0, 0, 1016, null).show();
    }
}
