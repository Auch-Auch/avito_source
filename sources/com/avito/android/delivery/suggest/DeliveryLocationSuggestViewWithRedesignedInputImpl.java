package com.avito.android.delivery.suggest;

import a2.a.a.k0.d.h;
import a2.g.r.g;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.delivery.R;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.suggest_locations.SuggestLocationsToolbarImpl;
import com.avito.android.util.SchedulersFactory3;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.data_source.DataSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b0\u00101J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001e\u0010'\u001a\n $*\u0004\u0018\u00010#0#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u00062"}, d2 = {"Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestViewWithRedesignedInputImpl;", "Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestView;", "Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestViewModel;", "viewModel", "", "bindTo", "(Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestViewModel;)V", "Landroid/view/View;", "f", "Landroid/view/View;", "view", "d", "Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestViewModel;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", g.a, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lio/reactivex/rxjava3/core/Observable;", "e", "Lio/reactivex/rxjava3/core/Observable;", "getNavigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "navigationClicks", "Landroidx/lifecycle/LifecycleOwner;", "h", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/avito/android/util/SchedulersFactory3;", "i", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/avito/android/suggest_locations/SuggestLocationsToolbarImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/android/suggest_locations/SuggestLocationsToolbarImpl;", "toolbar", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory3;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryLocationSuggestViewWithRedesignedInputImpl implements DeliveryLocationSuggestView {
    public final SuggestLocationsToolbarImpl a;
    public final RecyclerView b;
    public ProgressOverlay c;
    public DeliveryLocationSuggestViewModel d;
    @NotNull
    public final Observable<Unit> e;
    public final View f;
    public final AdapterPresenter g;
    public final LifecycleOwner h;
    public final SchedulersFactory3 i;

    public static final class a<T> implements Observer<DataSource<Item>> {
        public final /* synthetic */ DeliveryLocationSuggestViewWithRedesignedInputImpl a;

        public a(DeliveryLocationSuggestViewWithRedesignedInputImpl deliveryLocationSuggestViewWithRedesignedInputImpl) {
            this.a = deliveryLocationSuggestViewWithRedesignedInputImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(DataSource<Item> dataSource) {
            DataSource<Item> dataSource2 = dataSource;
            if (dataSource2 != null) {
                this.a.g.onDataSourceChanged(dataSource2);
                RecyclerView recyclerView = this.a.b;
                Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
                DeliveryLocationSuggestViewWithRedesignedInputImpl deliveryLocationSuggestViewWithRedesignedInputImpl = this.a;
                deliveryLocationSuggestViewWithRedesignedInputImpl.a.queryEmits().last("").observeOn(deliveryLocationSuggestViewWithRedesignedInputImpl.i.mainThread()).subscribe(new DeliveryLocationSuggestViewWithRedesignedInputImpl$bindTo$1$$special$$inlined$let$lambda$1(dataSource2, this));
            }
        }
    }

    public static final class b<T> implements Observer<Boolean> {
        public final /* synthetic */ DeliveryLocationSuggestViewWithRedesignedInputImpl a;

        public b(DeliveryLocationSuggestViewWithRedesignedInputImpl deliveryLocationSuggestViewWithRedesignedInputImpl) {
            this.a = deliveryLocationSuggestViewWithRedesignedInputImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Boolean bool) {
            Boolean bool2 = bool;
            if (bool2 != null) {
                bool2.booleanValue();
                if (bool2.booleanValue()) {
                    LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.a.c, null, 1, null);
                } else {
                    SnackbarExtensionsKt.showSnackbar$default(this.a.f, (String) null, R.string.has_error_occurred, (String) null, 0, (Function0) null, 0, (SnackbarPosition) null, (SnackbarType) null, 253, (Object) null);
                }
            }
        }
    }

    public static final class c<T> implements Consumer<String> {
        public final /* synthetic */ DeliveryLocationSuggestViewModel a;

        public c(DeliveryLocationSuggestViewModel deliveryLocationSuggestViewModel) {
            this.a = deliveryLocationSuggestViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            DeliveryLocationSuggestViewModel deliveryLocationSuggestViewModel = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, "query");
            deliveryLocationSuggestViewModel.searchSuggestions(str2);
        }
    }

    public static final class d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ DeliveryLocationSuggestViewWithRedesignedInputImpl a;
        public final /* synthetic */ DeliveryLocationSuggestViewModel b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(DeliveryLocationSuggestViewWithRedesignedInputImpl deliveryLocationSuggestViewWithRedesignedInputImpl, DeliveryLocationSuggestViewModel deliveryLocationSuggestViewModel) {
            super(0);
            this.a = deliveryLocationSuggestViewWithRedesignedInputImpl;
            this.b = deliveryLocationSuggestViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            DeliveryLocationSuggestViewWithRedesignedInputImpl deliveryLocationSuggestViewWithRedesignedInputImpl = this.a;
            deliveryLocationSuggestViewWithRedesignedInputImpl.a.queryEmits().last("").observeOn(deliveryLocationSuggestViewWithRedesignedInputImpl.i.mainThread()).subscribe(new DeliveryLocationSuggestViewWithRedesignedInputImpl$bindTo$4$$special$$inlined$doOnLastQuery$1(this));
            return Unit.INSTANCE;
        }
    }

    public DeliveryLocationSuggestViewWithRedesignedInputImpl(@NotNull View view, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder, @NotNull LifecycleOwner lifecycleOwner, @NotNull Analytics analytics, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.f = view;
        this.g = adapterPresenter;
        this.h = lifecycleOwner;
        this.i = schedulersFactory3;
        View inflate = ((ViewStub) view.findViewById(R.id.stub_suggest_toolbar)).inflate();
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.avito.android.suggest_locations.SuggestLocationsToolbarImpl");
        SuggestLocationsToolbarImpl suggestLocationsToolbarImpl = (SuggestLocationsToolbarImpl) inflate;
        this.a = suggestLocationsToolbarImpl;
        int i2 = R.id.recycler_view;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(i2);
        this.b = recyclerView;
        View findViewById = view.findViewById(R.id.content_holder);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        this.c = new ProgressOverlay((ViewGroup) findViewById, i2, analytics, false, 0, 24, null);
        this.e = suggestLocationsToolbarImpl.backPressed();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), 1, false));
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setAdapter(new SimpleRecyclerAdapter(adapterPresenter, itemBinder));
        suggestLocationsToolbarImpl.showKeyboard();
        String string = view.getContext().getString(R.string.delivery_suggest_location_hint);
        Intrinsics.checkNotNullExpressionValue(string, "view.context.getString(R…ry_suggest_location_hint)");
        suggestLocationsToolbarImpl.setHint(string);
        suggestLocationsToolbarImpl.donePressed().observeOn(schedulersFactory3.mainThread()).subscribe(new h(this));
    }

    public static final /* synthetic */ DeliveryLocationSuggestViewModel access$getViewModel$p(DeliveryLocationSuggestViewWithRedesignedInputImpl deliveryLocationSuggestViewWithRedesignedInputImpl) {
        DeliveryLocationSuggestViewModel deliveryLocationSuggestViewModel = deliveryLocationSuggestViewWithRedesignedInputImpl.d;
        if (deliveryLocationSuggestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return deliveryLocationSuggestViewModel;
    }

    @Override // com.avito.android.delivery.suggest.DeliveryLocationSuggestView
    public void bindTo(@NotNull DeliveryLocationSuggestViewModel deliveryLocationSuggestViewModel) {
        Intrinsics.checkNotNullParameter(deliveryLocationSuggestViewModel, "viewModel");
        this.d = deliveryLocationSuggestViewModel;
        deliveryLocationSuggestViewModel.getDataChanges().observe(this.h, new a(this));
        deliveryLocationSuggestViewModel.getErrorChanges().observe(this.h, new b(this));
        this.a.queryEmits().skip(1).debounce(300, TimeUnit.MILLISECONDS).observeOn(this.i.mainThread()).subscribe(new c(deliveryLocationSuggestViewModel));
        this.c.setOnRefreshListener(new d(this, deliveryLocationSuggestViewModel));
    }

    @Override // com.avito.android.delivery.suggest.DeliveryLocationSuggestView
    @NotNull
    public Observable<Unit> getNavigationClicks() {
        return this.e;
    }
}
