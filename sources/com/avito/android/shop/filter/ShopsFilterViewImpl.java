package com.avito.android.shop.filter;

import a2.g.r.g;
import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.analytics.Analytics;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Category;
import com.avito.android.remote.model.Entity;
import com.avito.android.remote.model.Location;
import com.avito.android.shop.R;
import com.avito.android.ui.adapter.NameIdAdapter;
import com.avito.android.ui.adapter.ShopCategoryAdapter;
import com.avito.android.ui.view.BaseSelectView;
import com.avito.android.ui.view.FieldView;
import com.avito.android.ui.view.SelectView;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.Toolbars;
import com.avito.konveyor.data_source.DataSource;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u00103\u001a\u000202¢\u0006\u0004\b4\u00105J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\nJ\u001d\u0010\u0018\u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0010\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010\f\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010\u001cR\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00066"}, d2 = {"Lcom/avito/android/shop/filter/ShopsFilterViewImpl;", "Lcom/avito/android/shop/filter/ShopsFilterView;", "", "showRetryOverlay", "()V", "showLoading", "hideLoading", "", "error", "showError", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/Category;", "category", "setSelectedCategory", "(Lcom/avito/android/remote/model/Category;)V", "Lcom/avito/android/remote/model/Location;", "location", "setSelectedLocation", "(Lcom/avito/android/remote/model/Location;)V", "setDefaultLocation", "title", "setToolbar", "Lcom/avito/konveyor/data_source/DataSource;", "categories", "setCategories", "(Lcom/avito/konveyor/data_source/DataSource;)V", "Lcom/avito/android/ui/view/SelectView;", "c", "Lcom/avito/android/ui/view/SelectView;", "Lcom/avito/android/util/DeviceMetrics;", g.a, "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Landroidx/appcompat/widget/Toolbar;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroid/view/View;", "e", "Landroid/view/View;", "view", AuthSource.BOOKING_ORDER, "Lcom/avito/android/shop/filter/ShopsFilterViewPresenter;", "f", "Lcom/avito/android/shop/filter/ShopsFilterViewPresenter;", "presenter", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "d", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/android/shop/filter/ShopsFilterViewPresenter;Lcom/avito/android/util/DeviceMetrics;Lcom/avito/android/analytics/Analytics;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopsFilterViewImpl implements ShopsFilterView {
    public final Toolbar a;
    public final SelectView b;
    public final SelectView c;
    public final ProgressOverlay d;
    public final View e;
    public final ShopsFilterViewPresenter f;
    public final DeviceMetrics g;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements FieldView.OnFieldValueChangeListener<Entity<? extends Object>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.android.ui.view.FieldView, java.lang.Object] */
        @Override // com.avito.android.ui.view.FieldView.OnFieldValueChangeListener
        public final void onFieldValueChanged(FieldView fieldView, Entity<? extends Object> entity) {
            int i = this.a;
            if (i == 0) {
                ((ShopsFilterViewImpl) this.b).f.onCategorySelected((Category) entity);
            } else if (i == 1) {
                ((ShopsFilterViewImpl) this.b).f.onLocationSelected((Location) entity);
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ShopsFilterViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ShopsFilterViewImpl shopsFilterViewImpl) {
            super(0);
            this.a = shopsFilterViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.f.onRefresh();
            return Unit.INSTANCE;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ShopsFilterViewImpl a;

        public c(ShopsFilterViewImpl shopsFilterViewImpl) {
            this.a = shopsFilterViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.f.onBackClicked();
        }
    }

    public static final class d implements Toolbar.OnMenuItemClickListener {
        public final /* synthetic */ ShopsFilterViewImpl a;

        public d(ShopsFilterViewImpl shopsFilterViewImpl) {
            this.a = shopsFilterViewImpl;
        }

        @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            Intrinsics.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != R.id.action_show) {
                return false;
            }
            this.a.f.onShowClicked();
            return true;
        }
    }

    public ShopsFilterViewImpl(@NotNull View view, @NotNull ShopsFilterViewPresenter shopsFilterViewPresenter, @NotNull DeviceMetrics deviceMetrics, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(shopsFilterViewPresenter, "presenter");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.e = view;
        this.f = shopsFilterViewPresenter;
        this.g = deviceMetrics;
        View findViewById = view.findViewById(com.avito.android.deprecated_design.R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById;
        this.a = toolbar;
        View findViewById2 = view.findViewById(R.id.category);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.ui.view.SelectView");
        SelectView selectView = (SelectView) findViewById2;
        this.b = selectView;
        View findViewById3 = view.findViewById(R.id.location);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.ui.view.SelectView");
        SelectView selectView2 = (SelectView) findViewById3;
        this.c = selectView2;
        View findViewById4 = view.findViewById(R.id.container);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.ViewGroup");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById4, R.id.content, analytics, false, 0, 24, null);
        this.d = progressOverlay;
        progressOverlay.setOnRefreshListener(new b(this));
        selectView.setOnFieldValueChangedListener(new a(0, this));
        selectView2.setSelector(new BaseSelectView.SimpleSelector<Location>(this) { // from class: com.avito.android.shop.filter.ShopsFilterViewImpl.3
            public final /* synthetic */ ShopsFilterViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.ui.view.BaseSelectView.SimpleSelector, com.avito.android.ui.view.BaseSelectView.Selector
            public void show(@Nullable FieldView<Location> fieldView) {
                this.a.f.onLocationClicked(fieldView != null ? fieldView.getValue() : null);
            }
        });
        selectView2.setOnFieldValueChangedListener(new a(1, this));
        toolbar.setNavigationOnClickListener(new c(this));
    }

    @Override // com.avito.android.shop.filter.ShopsFilterView
    public void hideLoading() {
        this.d.showContent();
    }

    @Override // com.avito.android.shop.filter.ShopsFilterView
    public void setCategories(@NotNull DataSource<Category> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "categories");
        ShopsFilterViewImpl$setCategories$selector$1 shopsFilterViewImpl$setCategories$selector$1 = new BaseSelectView.DialogSelector(this, dataSource, this.e.getContext()) { // from class: com.avito.android.shop.filter.ShopsFilterViewImpl$setCategories$selector$1
            public final /* synthetic */ ShopsFilterViewImpl d;
            public final /* synthetic */ DataSource e;

            {
                this.d = r1;
                this.e = r2;
            }

            @Override // com.avito.android.ui.view.BaseSelectView.DialogSelector
            @NotNull
            public NameIdAdapter createAdapter(@Nullable DataSource<? extends Entity<?>> dataSource2) {
                Context context = this.d.e.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "view.context");
                return new ShopCategoryAdapter(context, this.e, this.d.g);
            }
        };
        shopsFilterViewImpl$setCategories$selector$1.setItems(dataSource);
        this.b.setSelector(shopsFilterViewImpl$setCategories$selector$1);
    }

    @Override // com.avito.android.shop.filter.ShopsFilterView
    public void setDefaultLocation(@NotNull Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        this.c.setEmptyValue(location);
    }

    @Override // com.avito.android.shop.filter.ShopsFilterView
    public void setSelectedCategory(@Nullable Category category) {
        this.b.setValue(category, false);
    }

    @Override // com.avito.android.shop.filter.ShopsFilterView
    public void setSelectedLocation(@Nullable Location location) {
        this.c.setValue(location, false);
    }

    @Override // com.avito.android.shop.filter.ShopsFilterView
    public void setToolbar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        Toolbars.setSpannedTitle(this.a, str);
        this.a.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_close_24_blue);
        this.a.inflateMenu(R.menu.filters);
        this.a.setOnMenuItemClickListener(new d(this));
    }

    @Override // com.avito.android.shop.filter.ShopsFilterView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Context context = this.e.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        ToastsKt.showToast$default(context, str, 0, 2, (Object) null);
    }

    @Override // com.avito.android.shop.filter.ShopsFilterView
    public void showLoading() {
        this.d.showLoading();
    }

    @Override // com.avito.android.shop.filter.ShopsFilterView
    public void showRetryOverlay() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.d, null, 1, null);
    }
}
