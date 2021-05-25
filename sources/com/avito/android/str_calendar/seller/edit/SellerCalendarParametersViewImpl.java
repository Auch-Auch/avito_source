package com.avito.android.str_calendar.seller.edit;

import a2.a.a.b3.c.b.f;
import a2.a.a.b3.c.b.i;
import a2.a.a.b3.c.b.j;
import a2.a.a.b3.c.b.k;
import a2.a.a.b3.c.b.l;
import a2.a.a.b3.c.b.m;
import a2.a.a.b3.c.b.n;
import a2.a.a.b3.c.b.o;
import a2.a.a.b3.c.b.p;
import a2.g.r.g;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.str_calendar.R;
import com.avito.android.str_calendar.seller.edit.view.SellerCalendarParametersDecoration;
import com.avito.android.str_calendar.seller.edit.view.SellerCalendarParametersGroupDecoration;
import com.avito.android.ui.PaddingListDecoration;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.jakewharton.rxbinding3.view.RxView;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010@\u001a\u00020?\u0012\u0006\u0010B\u001a\u00020A\u0012\u0006\u0010D\u001a\u00020C\u0012\u0006\u0010F\u001a\u00020E\u0012\u0006\u0010\f\u001a\u00020\t\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0004\bG\u0010HJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0013R\u0016\u0010$\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0013R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u0002018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u00103¨\u0006I"}, d2 = {"Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersViewImpl;", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersView;", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersViewModel;", "viewModel", "", "bindTo", "(Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersViewModel;)V", "clearSubscriptions", "()V", "", "n", "Z", "useGroupDecorations", "Lio/reactivex/Observable;", "o", "Lio/reactivex/Observable;", "keyboardVisibilityObservable", "Landroid/view/View;", "e", "Landroid/view/View;", "closeButton", "Landroid/view/ViewGroup;", "l", "Landroid/view/ViewGroup;", "view", "Landroidx/lifecycle/LifecycleOwner;", AuthSource.OPEN_CHANNEL_LIST, "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "j", "getCloseClicks", "()Lio/reactivex/Observable;", "closeClicks", "c", "applyButtonContainer", "d", "applyButton", "", "k", "J", "delayTimeMs", "Lio/reactivex/disposables/CompositeDisposable;", "i", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/progress_overlay/ProgressOverlay;", AuthSource.SEND_ABUSE, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "h", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "groupsDecoration", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "titleTextView", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", g.a, "itemsDecoration", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParamsResourceProvider;", "resourceProvider", "<init>", "(Landroid/view/ViewGroup;Landroidx/lifecycle/LifecycleOwner;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParamsResourceProvider;ZLio/reactivex/Observable;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerCalendarParametersViewImpl implements SellerCalendarParametersView {
    public final ProgressOverlay a;
    public final RecyclerView b;
    public final View c;
    public final View d;
    public final View e;
    public final TextView f;
    public RecyclerView.ItemDecoration g;
    public RecyclerView.ItemDecoration h;
    public final CompositeDisposable i;
    @NotNull
    public final Observable<Unit> j;
    public final long k;
    public final ViewGroup l;
    public final LifecycleOwner m;
    public final boolean n;
    public final Observable<Boolean> o;

    public SellerCalendarParametersViewImpl(@NotNull ViewGroup viewGroup, @NotNull LifecycleOwner lifecycleOwner, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder, @NotNull Analytics analytics, @NotNull SellerCalendarParamsResourceProvider sellerCalendarParamsResourceProvider, boolean z, @NotNull Observable<Boolean> observable) {
        Intrinsics.checkNotNullParameter(viewGroup, "view");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(sellerCalendarParamsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(observable, "keyboardVisibilityObservable");
        this.l = viewGroup;
        this.m = lifecycleOwner;
        this.n = z;
        this.o = observable;
        View findViewById = viewGroup.findViewById(R.id.content_holder);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.content_holder)");
        this.a = new ProgressOverlay((ViewGroup) findViewById, 0, analytics, false, 0, 26, null);
        View findViewById2 = viewGroup.findViewById(R.id.recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.recycler_view)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.b = recyclerView;
        View findViewById3 = viewGroup.findViewById(R.id.apply_button_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.apply_button_container)");
        this.c = findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.apply_button);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.apply_button)");
        this.d = findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.close_button);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.close_button)");
        this.e = findViewById5;
        TextView textView = (TextView) viewGroup.findViewById(R.id.title_text_view);
        this.f = textView;
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.seller_edit_calendar_recycler_view_horizontal_padding);
        int dimensionPixelSize2 = viewGroup.getResources().getDimensionPixelSize(R.dimen.seller_edit_calendar_recycler_view_vertical_padding);
        this.g = new SellerCalendarParametersDecoration(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.i = compositeDisposable;
        this.j = RxView.clicks(findViewById5);
        String toolbarTitle = sellerCalendarParamsResourceProvider.getToolbarTitle();
        if (textView != null) {
            textView.setText(toolbarTitle);
        }
        recyclerView.setAdapter(new SimpleRecyclerAdapter(adapterPresenter, itemBinder));
        recyclerView.setLayoutManager(new LinearLayoutManager(viewGroup.getContext(), 1, false));
        PaddingListDecoration paddingListDecoration = new PaddingListDecoration(0, viewGroup.getResources().getDimensionPixelSize(R.dimen.seller_edit_calendar_recycler_view_bottom_padding), 0, 0, 12, null);
        recyclerView.addItemDecoration(this.g);
        recyclerView.addItemDecoration(paddingListDecoration);
        Disposable subscribe = observable.skip(1).throttleFirst(this.k, TimeUnit.MILLISECONDS).subscribe(new o(this), p.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "keyboardVisibilityObserv…error(it) }\n            )");
        DisposableKt.addTo(subscribe, compositeDisposable);
        this.k = (long) viewGroup.getResources().getInteger(17694720);
    }

    public static final RecyclerView.ItemDecoration access$getRecyclerGroupsDecoration(SellerCalendarParametersViewImpl sellerCalendarParametersViewImpl, Set set) {
        return new SellerCalendarParametersGroupDecoration(sellerCalendarParametersViewImpl.l.getResources().getDimensionPixelSize(R.dimen.seller_edit_calendar_recycler_view_group_top_margin), set);
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersView
    public void bindTo(@NotNull SellerCalendarParametersViewModel sellerCalendarParametersViewModel) {
        Intrinsics.checkNotNullParameter(sellerCalendarParametersViewModel, "viewModel");
        sellerCalendarParametersViewModel.getUpdateViewChanges().observe(this.m, new n(this));
        if (this.n) {
            sellerCalendarParametersViewModel.getGroupsBoundsChanges().observe(this.m, new k(this));
        }
        sellerCalendarParametersViewModel.getShowContentChanges().observe(this.m, new m(this));
        sellerCalendarParametersViewModel.getProgressChanges().observe(this.m, new l(this));
        sellerCalendarParametersViewModel.getErrorChanges().observe(this.m, new i(this));
        sellerCalendarParametersViewModel.getErrorMessageChanges().observe(this.m, new j(this));
        LiveData<Boolean> enableApplyButtonChanges = sellerCalendarParametersViewModel.getEnableApplyButtonChanges();
        Consumer<Unit> applyClicksConsumer = sellerCalendarParametersViewModel.getApplyClicksConsumer();
        enableApplyButtonChanges.observe(this.m, new f(this));
        this.d.setOnClickListener(new a2.a.a.b3.c.b.g(applyClicksConsumer));
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersView
    public void clearSubscriptions() {
        this.i.clear();
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersView
    @NotNull
    public Observable<Unit> getCloseClicks() {
        return this.j;
    }
}
