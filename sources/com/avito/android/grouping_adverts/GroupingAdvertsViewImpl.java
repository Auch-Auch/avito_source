package com.avito.android.grouping_adverts;

import a2.g.r.g;
import android.content.Context;
import android.content.DialogInterface;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.advert.viewed.ViewedAdvertsView;
import com.avito.android.analytics.Analytics;
import com.avito.android.async_phone.AsyncPhoneView;
import com.avito.android.async_phone.AsyncPhoneViewImpl;
import com.avito.android.deprecated_design.R;
import com.avito.android.favorite.FavoriteAdvertsView;
import com.avito.android.lastclick.LastClick;
import com.avito.android.legacy_mvp.ErrorMessageView;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.adapter.AppendingHandler;
import com.avito.android.ui.adapter.GridLayoutAppendingAdapter;
import com.avito.android.util.Contexts;
import com.avito.android.util.DialogUtils;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.Toolbars;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.jakewharton.rxbinding4.view.RxMenuItem;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B7\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010N\u001a\u00020M\u0012\u0006\u0010P\u001a\u00020O\u0012\u0006\u0010R\u001a\u00020Q\u0012\u0006\u0010T\u001a\u00020S¢\u0006\u0004\bU\u0010VJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\rJ\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001a\u0010\u0012J3\u0010 \u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\n2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001cH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\nH\u0016¢\u0006\u0004\b#\u0010\rJ\u0017\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u001fH\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u000fH\u0016¢\u0006\u0004\b(\u0010\u0012J\u000f\u0010)\u001a\u00020\u0006H\u0016¢\u0006\u0004\b)\u0010\bJ\u0010\u0010*\u001a\u00020\u0006H\u0001¢\u0006\u0004\b*\u0010\bJ\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H\u0001¢\u0006\u0004\b+\u0010\u0016R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020-0,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010;R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006W"}, d2 = {"Lcom/avito/android/grouping_adverts/GroupingAdvertsViewImpl;", "Lcom/avito/android/grouping_adverts/GroupingAdvertsView;", "Lcom/avito/android/favorite/FavoriteAdvertsView;", "Lcom/avito/android/legacy_mvp/ErrorMessageView;", "Lcom/avito/android/advert/viewed/ViewedAdvertsView;", "Lcom/avito/android/async_phone/AsyncPhoneView;", "", "showProgress", "()V", "hideProgress", "", "error", "showLoadingError", "(Ljava/lang/String;)V", "notifyDataChanged", "", VKApiConst.POSITION, "notifyItemAtPositionChanged", "(I)V", "showError", "Lio/reactivex/rxjava3/core/Observable;", "getRetryButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "getUpButtonClicks", "filterButtonClicks", "spanCount", "updateSpanCount", "phoneNumber", "Lkotlin/Function0;", "okHandler", "cancelHandler", "", "showCallDialog", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Z", "message", "showToastMessage", "isWhite", "setWhiteBackground", "(Z)V", "itemIndex", "onItemChanged", "showFilters", "dismissPhoneLoadError", "showPhoneLoadError", "Lcom/avito/android/ui/adapter/GridLayoutAppendingAdapter;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "f", "Lcom/avito/android/ui/adapter/GridLayoutAppendingAdapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroid/view/View;", "h", "Landroid/view/View;", "view", "e", "toolbarShadow", "Landroidx/appcompat/app/AlertDialog;", g.a, "Landroidx/appcompat/app/AlertDialog;", "phoneCallDialog", "Landroidx/appcompat/widget/Toolbar;", "d", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroidx/recyclerview/widget/GridLayoutManager;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/android/ui/adapter/AppendingHandler;", "appendingHandler", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "<init>", "(Landroid/view/View;Lcom/avito/android/analytics/Analytics;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;Lcom/avito/android/ui/adapter/AppendingHandler;Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;)V", "grouping-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class GroupingAdvertsViewImpl implements GroupingAdvertsView, FavoriteAdvertsView, ErrorMessageView, ViewedAdvertsView, AsyncPhoneView {
    public GridLayoutManager a;
    public final RecyclerView b;
    public ProgressOverlay c;
    public final Toolbar d;
    public final View e;
    public final GridLayoutAppendingAdapter<BaseViewHolder> f;
    public AlertDialog g;
    public final View h;
    public final /* synthetic */ AsyncPhoneViewImpl i;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            this.a.invoke();
            LastClick.Updater.update();
        }
    }

    public static final class b implements DialogInterface.OnCancelListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            LastClick.Updater.update();
            this.a.invoke();
        }
    }

    public GroupingAdvertsViewImpl(@NotNull View view, @NotNull Analytics analytics, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder, @NotNull AppendingHandler appendingHandler, @NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(appendingHandler, "appendingHandler");
        Intrinsics.checkNotNullParameter(spanSizeLookup, "spanSizeLookup");
        this.i = new AsyncPhoneViewImpl(view);
        this.h = view;
        this.a = new GridLayoutManager(view.getContext(), 1, 1, false);
        int i2 = R.id.recycler;
        View findViewById = view.findViewById(i2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.recycler)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.b = recyclerView;
        View findViewById2 = view.findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(com.av…ated_design.R.id.toolbar)");
        Toolbar toolbar = (Toolbar) findViewById2;
        this.d = toolbar;
        View findViewById3 = view.findViewById(com.avito.android.ui_components.R.id.shadow);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(com.av…i_components.R.id.shadow)");
        this.e = findViewById3;
        this.f = new GridLayoutAppendingAdapter<>(new SimpleRecyclerAdapter(adapterPresenter, itemBinder), appendingHandler);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        int colorCompat = Contexts.getColorCompat(context, com.avito.android.lib.design.avito.R.color.expected_background);
        View findViewById4 = view.findViewById(R.id.container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.container)");
        this.c = new ProgressOverlay((ViewGroup) findViewById4, i2, analytics, false, colorCompat, 8, null);
        view.setBackgroundColor(colorCompat);
        this.a.setSpanSizeLookup(spanSizeLookup);
        recyclerView.setLayoutManager(this.a);
        recyclerView.setItemAnimator(null);
        Toolbars.setBackIcon$default(toolbar, 0, 1, null);
        Views.show(findViewById3);
    }

    @Override // com.avito.android.async_phone.AsyncPhoneView
    public void dismissPhoneLoadError() {
        this.i.dismissPhoneLoadError();
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsView
    @NotNull
    public Observable<Unit> filterButtonClicks() {
        MenuItem findItem = this.d.getMenu().findItem(R.id.menu_filters);
        if (findItem != null) {
            return RxMenuItem.clicks$default(findItem, null, 1, null);
        }
        throw new IllegalArgumentException("Toolbar was not inflated".toString());
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsView
    @NotNull
    public Observable<Unit> getRetryButtonClicks() {
        return InteropKt.toV3(this.c.refreshes());
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsView
    @NotNull
    public Observable<Unit> getUpButtonClicks() {
        return Toolbars.upClicks(this.d);
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsView
    public void hideProgress() {
        this.c.showContent();
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsView
    public void notifyDataChanged() {
        if (this.b.getAdapter() == null) {
            this.b.setAdapter(this.f);
            return;
        }
        RecyclerView.Adapter adapter = this.b.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsView, com.avito.android.advert.viewed.ViewedAdvertsView
    public void notifyItemAtPositionChanged(int i2) {
        RecyclerView.Adapter adapter = this.b.getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(i2);
        }
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsView
    public void onItemChanged(int i2) {
        RecyclerView.Adapter adapter = this.b.getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(i2);
        }
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsView
    public void setWhiteBackground(boolean z) {
        int i2;
        View view = this.h;
        if (z) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            i2 = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.white);
        } else {
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
            i2 = Contexts.getColorCompat(context2, com.avito.android.lib.design.avito.R.color.expected_background);
        }
        view.setBackgroundColor(i2);
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsView
    public boolean showCallDialog(@NotNull String str, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(str, "phoneNumber");
        Intrinsics.checkNotNullParameter(function0, "okHandler");
        Intrinsics.checkNotNullParameter(function02, "cancelHandler");
        if (DialogUtils.isShowing(this.g)) {
            return false;
        }
        AlertDialog create = new AlertDialog.Builder(this.h.getContext()).setTitle(R.string.phone).setMessage(str).setPositiveButton(com.avito.android.ui_components.R.string.call, new a(function0)).setOnCancelListener(new b(function02)).create();
        this.g = create;
        Intrinsics.checkNotNull(create);
        create.show();
        return true;
    }

    @Override // com.avito.android.legacy_mvp.ErrorMessageView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Views.showSnackBar$default(this.h, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsView
    public void showFilters() {
        this.d.inflateMenu(R.menu.rds_grouping);
        Toolbars.tintMenuByAttr(this.d, com.avito.android.lib.design.R.attr.blue);
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsView
    public void showLoadingError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.c.showLoadingProblem(str);
    }

    @Override // com.avito.android.async_phone.AsyncPhoneView
    @NotNull
    public Observable<Unit> showPhoneLoadError() {
        return this.i.showPhoneLoadError();
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsView
    public void showProgress() {
        this.c.showLoading();
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsView
    public void showToastMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Context context = this.h.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        ToastsKt.showToast$default(context, str, 0, 2, (Object) null);
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsView
    public void updateSpanCount(int i2) {
        this.a.setSpanCount(i2);
    }
}
