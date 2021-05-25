package com.avito.android.location_list;

import a2.g.r.g;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.deprecated_design.R;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.DialogUtils;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Snackbars;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.Toolbars;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010W\u001a\u00020\u000b\u0012\u0006\u0010Y\u001a\u00020X\u0012\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020[0Z\u0012\u0006\u0010^\u001a\u00020]¢\u0006\u0004\b_\u0010`J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\nJ\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\nJ\u000f\u0010\u0013\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\nJ\u001d\u0010\u0016\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\nJ\u000f\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0019\u0010\nJ\u000f\u0010\u001a\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\nJ\u000f\u0010\u001b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001b\u0010\nJ\u000f\u0010\u001c\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\nJ\u000f\u0010\u001d\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\nJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0003H\u0016¢\u0006\u0004\b!\u0010\nJ\u000f\u0010\"\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\"\u0010\nR\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R:\u0010+\u001a&\u0012\f\u0012\n (*\u0004\u0018\u00010\u00030\u0003 (*\u0012\u0012\f\u0012\n (*\u0004\u0018\u00010\u00030\u0003\u0018\u00010'0'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R:\u00101\u001a&\u0012\f\u0012\n (*\u0004\u0018\u00010\u00030\u0003 (*\u0012\u0012\f\u0012\n (*\u0004\u0018\u00010\u00030\u0003\u0018\u00010'0'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u0010*R\u001c\u00104\u001a\b\u0012\u0004\u0012\u0002020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u0005R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R:\u0010:\u001a&\u0012\f\u0012\n (*\u0004\u0018\u00010\u00030\u0003 (*\u0012\u0012\f\u0012\n (*\u0004\u0018\u00010\u00030\u0003\u0018\u00010'0'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010*R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR:\u0010D\u001a&\u0012\f\u0012\n (*\u0004\u0018\u00010\u00030\u0003 (*\u0012\u0012\f\u0012\n (*\u0004\u0018\u00010\u00030\u0003\u0018\u00010'0'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010*R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006a"}, d2 = {"Lcom/avito/android/location_list/LocationListViewImpl;", "Lcom/avito/android/location_list/LocationListView;", "Lio/reactivex/Observable;", "", "dismissCallback", "()Lio/reactivex/Observable;", "refreshCallback", "findLocationCallback", "navigationCallback", "showList", "()V", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "showEmptyView", "notifyChanged", "scrollToTop", "setHomeIconNormal", "setHomeIconDiscard", "showProgressDialog", "Lkotlin/Function0;", "action", "showLocationSettingsDisabledMessage", "(Lkotlin/jvm/functions/Function0;)V", "showLocationProblem", "showSearchKeyboard", "showUnavailable", PlatformActions.HIDE_KEYBOARD, "showContent", "showStartLoading", "", "isContentOverlayVisible", "()Z", "onRefresh", "dismissLocationProgress", "Landroidx/appcompat/app/AppCompatActivity;", "e", "Landroidx/appcompat/app/AppCompatActivity;", "activity", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", AuthSource.OPEN_CHANNEL_LIST, "Lcom/jakewharton/rxrelay2/PublishRelay;", "navigationRelay", "Landroid/app/ProgressDialog;", g.a, "Landroid/app/ProgressDialog;", "progressDialog", "l", "findLocationRelay", "", "getSearchQuery", "searchQuery", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "listView", "k", "refreshRelay", "Landroidx/appcompat/widget/Toolbar;", "c", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "h", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "j", "dismissRelay", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "f", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroid/widget/ImageButton;", "i", "Landroid/widget/ImageButton;", "clearButton", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "emptyView", "Landroid/widget/EditText;", "d", "Landroid/widget/EditText;", "searchView", "n", "Landroid/view/ViewGroup;", "view", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "viewHolderFactory", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/blueprint/ViewHolderBuilder;Lcom/avito/android/analytics/Analytics;)V", "location-list_release"}, k = 1, mv = {1, 4, 2})
public final class LocationListViewImpl implements LocationListView {
    public final RecyclerView a;
    public final View b;
    public final Toolbar c;
    public final EditText d;
    public final AppCompatActivity e;
    public final ProgressOverlay f;
    public ProgressDialog g;
    public final SimpleRecyclerAdapter h;
    public final ImageButton i;
    public PublishRelay<Unit> j = PublishRelay.create();
    public PublishRelay<Unit> k = PublishRelay.create();
    public PublishRelay<Unit> l = PublishRelay.create();
    public PublishRelay<Unit> m = PublishRelay.create();
    public final ViewGroup n;

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                ((LocationListViewImpl) this.b).m.accept(Unit.INSTANCE);
            } else if (i == 1) {
                ((LocationListViewImpl) this.b).d.setText("");
            } else {
                throw null;
            }
        }
    }

    public static final class b implements Toolbar.OnMenuItemClickListener {
        public final /* synthetic */ LocationListViewImpl a;

        public b(LocationListViewImpl locationListViewImpl) {
            this.a = locationListViewImpl;
        }

        @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            Intrinsics.checkNotNullExpressionValue(menuItem, "it");
            if (menuItem.getItemId() != R.id.menu_find_location) {
                return false;
            }
            this.a.l.accept(Unit.INSTANCE);
            return true;
        }
    }

    public static final class c<T> implements Consumer<CharSequence> {
        public final /* synthetic */ LocationListViewImpl a;

        public c(LocationListViewImpl locationListViewImpl) {
            this.a = locationListViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            ImageButton imageButton = this.a.i;
            Intrinsics.checkNotNullExpressionValue(charSequence2, "it");
            Views.setVisible(imageButton, !m.isBlank(charSequence2));
        }
    }

    public static final class e implements DialogInterface.OnCancelListener {
        public final /* synthetic */ LocationListViewImpl a;

        public e(LocationListViewImpl locationListViewImpl) {
            this.a = locationListViewImpl;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            this.a.j.accept(Unit.INSTANCE);
        }
    }

    public LocationListViewImpl(@NotNull ViewGroup viewGroup, @NotNull AdapterPresenter adapterPresenter, @NotNull ViewHolderBuilder<? extends BaseViewHolder> viewHolderBuilder, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(viewGroup, "view");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(viewHolderBuilder, "viewHolderFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.n = viewGroup;
        View findViewById = viewGroup.findViewById(16908298);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.a = recyclerView;
        View findViewById2 = viewGroup.findViewById(16908292);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById3;
        this.c = toolbar;
        Context context = viewGroup.getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        AppCompatActivity appCompatActivity = (AppCompatActivity) context;
        this.e = appCompatActivity;
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(adapterPresenter, viewHolderBuilder);
        this.h = simpleRecyclerAdapter;
        recyclerView.setLayoutManager(new LinearLayoutManager(appCompatActivity));
        simpleRecyclerAdapter.setHasStableIds(true);
        toolbar.inflateMenu(R.menu.region_list);
        toolbar.setOnMenuItemClickListener(new b(this));
        toolbar.setNavigationOnClickListener(new a(0, this));
        View inflate = LayoutInflater.from(appCompatActivity).inflate(com.avito.android.select.R.layout.select_dialog_search_view, (ViewGroup) toolbar, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "toolBarSearchView");
        View findViewById4 = inflate.findViewById(com.avito.android.select.R.id.select_dialog_search_view);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.EditText");
        EditText editText = (EditText) findViewById4;
        this.d = editText;
        View findViewById5 = inflate.findViewById(com.avito.android.select.R.id.select_dialog_search_view_clear);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.ImageButton");
        ImageButton imageButton = (ImageButton) findViewById5;
        this.i = imageButton;
        Views.hide(imageButton);
        editText.setHint(R.string.region_or_city);
        imageButton.setOnClickListener(new a(1, this));
        ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup, R.id.content, analytics, false, 0, 24, null);
        this.f = progressOverlay;
        progressOverlay.setOnRefreshListener(this);
    }

    @Override // com.avito.android.location_list.LocationListView
    @NotNull
    public Observable<Unit> dismissCallback() {
        PublishRelay<Unit> publishRelay = this.j;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "dismissRelay");
        return publishRelay;
    }

    @Override // com.avito.android.location_list.LocationListView
    public void dismissLocationProgress() {
        DialogUtils.dismissDialog(this.g);
    }

    @Override // com.avito.android.location_list.LocationListView
    @NotNull
    public Observable<Unit> findLocationCallback() {
        PublishRelay<Unit> publishRelay = this.l;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "findLocationRelay");
        return publishRelay;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [a2.a.a.m1.h] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.avito.android.location_list.LocationListView
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.Observable<java.lang.String> getSearchQuery() {
        /*
            r3 = this;
            android.widget.EditText r0 = r3.d
            io.reactivex.Observable r0 = com.avito.android.location_list.LocationListViewKt.access$textChangesOmitInitialEvent(r0)
            com.avito.android.location_list.LocationListViewImpl$c r1 = new com.avito.android.location_list.LocationListViewImpl$c
            r1.<init>(r3)
            io.reactivex.Observable r0 = r0.doOnNext(r1)
            com.avito.android.location_list.LocationListViewImpl$d r1 = com.avito.android.location_list.LocationListViewImpl.d.a
            if (r1 == 0) goto L_0x0019
            a2.a.a.m1.h r2 = new a2.a.a.m1.h
            r2.<init>(r1)
            r1 = r2
        L_0x0019:
            io.reactivex.functions.Function r1 = (io.reactivex.functions.Function) r1
            io.reactivex.Observable r0 = r0.map(r1)
            java.lang.String r1 = "searchView\n            .…(CharSequence?::toString)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.location_list.LocationListViewImpl.getSearchQuery():io.reactivex.Observable");
    }

    @Override // com.avito.android.location_list.LocationListView
    public void hideKeyboard() {
        Keyboards.hideKeyboard(this.e);
    }

    @Override // com.avito.android.location_list.LocationListView
    public boolean isContentOverlayVisible() {
        return this.f.isContentVisible();
    }

    @Override // com.avito.android.location_list.LocationListView
    @NotNull
    public Observable<Unit> navigationCallback() {
        PublishRelay<Unit> publishRelay = this.m;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "navigationRelay");
        return publishRelay;
    }

    @Override // com.avito.android.location_list.LocationListView
    public void notifyChanged() {
        if (this.a.getAdapter() == null) {
            this.a.setAdapter(this.h);
        }
        this.h.notifyDataSetChanged();
    }

    @Override // com.avito.android.progress_overlay.OnRefreshListener
    public void onRefresh() {
        this.k.accept(Unit.INSTANCE);
    }

    @Override // com.avito.android.location_list.LocationListView
    @NotNull
    public Observable<Unit> refreshCallback() {
        PublishRelay<Unit> publishRelay = this.k;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "refreshRelay");
        return publishRelay;
    }

    @Override // com.avito.android.location_list.LocationListView
    public void scrollToTop() {
        this.a.smoothScrollToPosition(0);
    }

    @Override // com.avito.android.location_list.LocationListView
    public void setHomeIconDiscard() {
        Toolbars.setCloseIcon(this.c);
    }

    @Override // com.avito.android.location_list.LocationListView
    public void setHomeIconNormal() {
        this.c.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24_blue);
    }

    @Override // com.avito.android.location_list.LocationListView
    public void showContent() {
        this.f.showContent();
    }

    @Override // com.avito.android.location_list.LocationListView
    public void showEmptyView() {
        Views.show(this.b);
        Views.hide(this.a);
    }

    @Override // com.avito.android.location_list.LocationListView
    public void showList() {
        Views.show(this.a);
        Views.hide(this.b);
    }

    @Override // com.avito.android.location_list.LocationListView
    public void showLocationProblem() {
        ToastsKt.showToast$default(this.e, com.avito.android.ui_components.R.string.no_found_location_search_message, 0, 2, (Object) null);
    }

    @Override // com.avito.android.location_list.LocationListView
    public void showLocationSettingsDisabledMessage(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        Snackbars.initButton(Views.showSnackBar$default(this.n, R.string.location_settings_disabled, 0, Integer.valueOf(R.string.enable_settings), 0, function0, (Function0) null, 0, 104, (Object) null));
    }

    @Override // com.avito.android.location_list.LocationListView
    public void showProgressDialog() {
        ProgressDialog progressDialog = this.g;
        if (progressDialog == null) {
            AppCompatActivity appCompatActivity = this.e;
            this.g = ProgressDialog.show(appCompatActivity, null, appCompatActivity.getString(R.string.detecting), true, true, new e(this));
        } else if (progressDialog != null) {
            progressDialog.show();
        }
    }

    @Override // com.avito.android.location_list.LocationListView
    public void showSearchKeyboard() {
        Keyboards.showKeyboard$default(this.d, 0, 1, null);
    }

    @Override // com.avito.android.location_list.LocationListView
    public void showStartLoading() {
        this.f.showLoading();
        Views.hide(this.n.findViewById(R.id.content));
    }

    @Override // com.avito.android.location_list.LocationListView
    public void showUnavailable() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.f, null, 1, null);
        Views.hide(this.n.findViewById(R.id.content));
    }

    @Override // com.avito.android.location_list.LocationListView
    @NotNull
    public ViewGroup getRootView() {
        return this.n;
    }
}
