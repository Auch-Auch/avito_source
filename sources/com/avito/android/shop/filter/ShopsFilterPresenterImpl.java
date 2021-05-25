package com.avito.android.shop.filter;

import a2.a.a.s2.c.c;
import a2.a.a.s2.c.d;
import a2.g.r.g;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.SparseArray;
import com.avito.android.FilterAnalyticsData;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.filter.FilterOpenedEvent;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.ScreenIdField;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CaseText;
import com.avito.android.remote.model.Category;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.shop.filter.ShopsSearchParameters;
import com.avito.android.shop.filter.ShopsFilterPresenter;
import com.avito.android.shop.filter.di.ShopsFilterModule;
import com.avito.android.ui_components.R;
import com.avito.android.util.Constants;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.Throwables;
import com.avito.android.util.rx3.Disposables;
import com.avito.konveyor.data_source.ListDataSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BG\b\u0007\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010G\u001a\u00020F\u0012\u0006\u0010I\u001a\u00020H\u0012\b\b\u0001\u0010=\u001a\u00020:\u0012\n\b\u0001\u0010@\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\bJ\u0010KJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\bJ\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\bJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\bJ\u0019\u0010\u001c\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u001c\u0010\u0019J\u000f\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010<R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006L"}, d2 = {"Lcom/avito/android/shop/filter/ShopsFilterPresenterImpl;", "Lcom/avito/android/shop/filter/ShopsFilterPresenter;", "Lcom/avito/android/shop/filter/ShopsFilterView;", "view", "", "attachView", "(Lcom/avito/android/shop/filter/ShopsFilterView;)V", "detachView", "()V", "Lcom/avito/android/shop/filter/ShopsFilterPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/shop/filter/ShopsFilterPresenter$Router;)V", "detachRouter", "Landroid/os/Bundle;", "onSaveInstanceState", "()Landroid/os/Bundle;", "onRefresh", "Lcom/avito/android/remote/model/Category;", "category", "onCategorySelected", "(Lcom/avito/android/remote/model/Category;)V", "Lcom/avito/android/remote/model/Location;", "location", "onLocationClicked", "(Lcom/avito/android/remote/model/Location;)V", "onBackClicked", "onShowClicked", "onLocationSelected", AuthSource.SEND_ABUSE, "e", "Lcom/avito/android/shop/filter/ShopsFilterPresenter$Router;", "Lcom/avito/android/util/SchedulersFactory3;", "i", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "d", "Lcom/avito/android/shop/filter/ShopsFilterView;", "Landroid/content/res/Resources;", "j", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/remote/model/CaseText;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/CaseText;", "locationNames", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "f", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscription", "Lcom/avito/android/shop/filter/ShopsFilterData;", "c", "Lcom/avito/android/shop/filter/ShopsFilterData;", "shopsFilterData", "Lcom/avito/android/shop/filter/ShopsFilterInteractor;", "h", "Lcom/avito/android/shop/filter/ShopsFilterInteractor;", "interactor", "Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "k", "Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "initialSearchParams", "l", "Landroid/os/Bundle;", "savedState", "searchParameters", "", g.a, "Ljava/lang/String;", "locationId", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "treeStateIdGenerator", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/shop/filter/ShopsFilterInteractor;Lcom/avito/android/util/SchedulersFactory3;Landroid/content/res/Resources;Lcom/avito/android/analytics/provider/TreeStateIdGenerator;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;Landroid/os/Bundle;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopsFilterPresenterImpl implements ShopsFilterPresenter {
    public final ShopsSearchParameters a;
    public CaseText b;
    public ShopsFilterData c;
    public ShopsFilterView d;
    public ShopsFilterPresenter.Router e;
    public CompositeDisposable f;
    public String g;
    public final ShopsFilterInteractor h;
    public final SchedulersFactory3 i;
    public final Resources j;
    public final ShopsSearchParameters k;
    public final Bundle l;

    @Inject
    public ShopsFilterPresenterImpl(@NotNull ShopsFilterInteractor shopsFilterInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Resources resources, @NotNull TreeStateIdGenerator treeStateIdGenerator, @NotNull Analytics analytics, @ShopsFilterModule.ShopsSearchParams @NotNull ShopsSearchParameters shopsSearchParameters, @ShopsFilterModule.PresenterState @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(shopsFilterInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(treeStateIdGenerator, "treeStateIdGenerator");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(shopsSearchParameters, "initialSearchParams");
        this.h = shopsFilterInteractor;
        this.i = schedulersFactory3;
        this.j = resources;
        this.k = shopsSearchParameters;
        this.l = bundle;
        ShopsSearchParameters copy$default = (bundle == null || (copy$default = (ShopsSearchParameters) bundle.getParcelable("search_parameters")) == null) ? ShopsSearchParameters.copy$default(shopsSearchParameters, null, null, null, 7, null) : copy$default;
        this.a = copy$default;
        ShopsFilterData shopsFilterData = null;
        this.b = bundle != null ? (CaseText) bundle.getParcelable(Constants.LOCATION_NAMES) : null;
        this.c = bundle != null ? (ShopsFilterData) bundle.getParcelable("shops_filter_data") : shopsFilterData;
        this.f = new CompositeDisposable();
        this.g = shopsSearchParameters.getLocationId();
        if (bundle == null) {
            long nextStateId = treeStateIdGenerator.nextStateId();
            analytics.track(new FilterOpenedEvent(nextStateId, new TreeClickStreamParent(nextStateId, ScreenIdField.FILTERS.name(), null, null), this.g, copy$default.getCategoryId(), null, null, FilterAnalyticsData.Source.SHOP_LIST.getValue(), null, 176, null));
        }
    }

    public static final void access$onFailedToLoadFilterData(ShopsFilterPresenterImpl shopsFilterPresenterImpl, Throwable th) {
        ShopsFilterView shopsFilterView;
        ShopsFilterView shopsFilterView2 = shopsFilterPresenterImpl.d;
        if (shopsFilterView2 != null) {
            shopsFilterView2.showRetryOverlay();
        }
        if (!Throwables.isNetworkProblem(th) && (shopsFilterView = shopsFilterPresenterImpl.d) != null) {
            shopsFilterView.showError(new ErrorFormatterImpl(shopsFilterPresenterImpl.j).format(th));
        }
    }

    public static final void access$onFilterDataLoaded(ShopsFilterPresenterImpl shopsFilterPresenterImpl, ShopsFilterData shopsFilterData) {
        shopsFilterPresenterImpl.c = shopsFilterData;
        shopsFilterPresenterImpl.a();
        ShopsFilterView shopsFilterView = shopsFilterPresenterImpl.d;
        if (shopsFilterView != null) {
            shopsFilterView.hideLoading();
        }
    }

    public final void a() {
        T t;
        ShopsFilterData shopsFilterData;
        List<Category> categories;
        ShopsFilterView shopsFilterView = this.d;
        if (shopsFilterView != null) {
            ShopsFilterData shopsFilterData2 = this.c;
            Location location = null;
            if (shopsFilterData2 != null) {
                shopsFilterView.setDefaultLocation(shopsFilterData2.getDefaultLocation());
                shopsFilterView.setCategories(new ListDataSource(shopsFilterData2.getCategories()));
                String categoryId = this.a.getCategoryId();
                if (categoryId != null && (shopsFilterData = this.c) != null && (categories = shopsFilterData.getCategories()) != null) {
                    Iterator<T> it = categories.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        t = it.next();
                        if (Intrinsics.areEqual(t.getId(), categoryId)) {
                            break;
                        }
                    }
                }
                t = null;
                shopsFilterView.setSelectedCategory(t);
            }
            if (shopsFilterData2 != null) {
                location = shopsFilterData2.getLocation();
            }
            shopsFilterView.setSelectedLocation(location);
        }
    }

    @Override // com.avito.android.shop.filter.ShopsFilterPresenter
    public void attachRouter(@NotNull ShopsFilterPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.e = router;
    }

    @Override // com.avito.android.shop.filter.ShopsFilterPresenter
    public void attachView(@NotNull ShopsFilterView shopsFilterView) {
        Intrinsics.checkNotNullParameter(shopsFilterView, "view");
        this.d = shopsFilterView;
        String string = this.j.getString(R.string.clarify);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(ui_R.string.clarify)");
        shopsFilterView.setToolbar(string);
        if (this.c == null) {
            onRefresh();
        } else {
            a();
        }
    }

    @Override // com.avito.android.shop.filter.ShopsFilterPresenter
    public void detachRouter() {
        this.e = null;
    }

    @Override // com.avito.android.shop.filter.ShopsFilterPresenter
    public void detachView() {
        this.f.clear();
        this.d = null;
    }

    @Override // com.avito.android.shop.filter.ShopsFilterViewPresenter
    public void onBackClicked() {
        ShopsFilterPresenter.Router router = this.e;
        if (router != null) {
            router.onBackClicked();
        }
    }

    @Override // com.avito.android.shop.filter.ShopsFilterViewPresenter
    public void onCategorySelected(@Nullable Category category) {
        this.a.setCategoryId(category != null ? category.getId() : null);
    }

    @Override // com.avito.android.shop.filter.ShopsFilterViewPresenter
    public void onLocationClicked(@Nullable Location location) {
        ShopsFilterPresenter.Router router = this.e;
        if (router != null) {
            router.showLocationScreen(location);
        }
    }

    @Override // com.avito.android.shop.filter.ShopsFilterViewPresenter
    public void onLocationSelected(@Nullable Location location) {
        String str;
        Location defaultLocation;
        CaseText names;
        Location defaultLocation2;
        ShopsSearchParameters shopsSearchParameters = this.a;
        CaseText caseText = null;
        if (location == null || (str = location.getId()) == null) {
            ShopsFilterData shopsFilterData = this.c;
            str = (shopsFilterData == null || (defaultLocation2 = shopsFilterData.getDefaultLocation()) == null) ? null : defaultLocation2.getId();
        }
        shopsSearchParameters.setLocationId(str);
        if (location == null || (names = location.getNames()) == null) {
            ShopsFilterData shopsFilterData2 = this.c;
            if (!(shopsFilterData2 == null || (defaultLocation = shopsFilterData2.getDefaultLocation()) == null)) {
                caseText = defaultLocation.getNames();
            }
        } else {
            caseText = names;
        }
        this.b = caseText;
        ShopsFilterView shopsFilterView = this.d;
        if (shopsFilterView != null) {
            shopsFilterView.setSelectedLocation(location);
        }
    }

    @Override // com.avito.android.shop.filter.ShopsFilterViewPresenter
    public void onRefresh() {
        if (this.c == null) {
            ShopsFilterView shopsFilterView = this.d;
            if (shopsFilterView != null) {
                shopsFilterView.showLoading();
            }
            CompositeDisposable compositeDisposable = this.f;
            Disposable subscribe = this.h.loadShopsFilterData(this.g).observeOn(this.i.mainThread()).subscribe(new c(this), new d(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor\n            .…rData(it) }\n            )");
            Disposables.plusAssign(compositeDisposable, subscribe);
        }
    }

    @Override // com.avito.android.shop.filter.ShopsFilterPresenter
    @NotNull
    public Bundle onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("search_parameters", this.a);
        bundle.putParcelable(Constants.LOCATION_NAMES, this.b);
        bundle.putParcelable("shops_filter_data", this.c);
        return bundle;
    }

    @Override // com.avito.android.shop.filter.ShopsFilterViewPresenter
    public void onShowClicked() {
        SparseArray<String> sparseArray;
        ShopsFilterPresenter.Router router = this.e;
        if (router != null) {
            ShopsSearchParameters copy$default = ShopsSearchParameters.copy$default(this.a, null, null, null, 7, null);
            CaseText caseText = this.b;
            if (caseText == null || (sparseArray = caseText.getNames()) == null) {
                sparseArray = new SparseArray<>();
            }
            router.showResults(copy$default, new CaseText(sparseArray));
        }
    }
}
