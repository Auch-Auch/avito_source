package com.avito.android.select.new_metro;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.Features;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Metro;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.select.R;
import com.avito.android.select.SelectActivityKt;
import com.avito.android.select.SelectResult;
import com.avito.android.select.new_metro.RoutingAction;
import com.avito.android.select.new_metro.adapter.filter.MetroFilterItemPresenter;
import com.avito.android.select.new_metro.adapter.lineItem.MetroLineItemPresenter;
import com.avito.android.select.new_metro.adapter.metro_station.MetroStationItem;
import com.avito.android.select.new_metro.adapter.metro_station.MetroStationItemPresenter;
import com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItemPresenter;
import com.avito.android.select.new_metro.adapter.switcher.MetroListOutputTypePresenter;
import com.avito.android.select.new_metro.di.DaggerSelectMetroFragmentComponent;
import com.avito.android.select.new_metro.di.SelectMetroFragmentComponent;
import com.avito.android.select.new_metro.view.SelectMetroView;
import com.avito.android.select.new_metro.view.SelectMetroViewImpl;
import com.avito.android.select.new_metro.view_model.SelectMetroRouter;
import com.avito.android.select.new_metro.view_model.SelectMetroViewModel;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Logs;
import com.avito.android.util.rx3.InteropKt;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.data_source.DataSource;
import io.reactivex.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.y.l;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0001B\b¢\u0006\u0005\b\u0001\u0010\rJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ-\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\rJ\u000f\u0010\u001b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001b\u0010\rJ\u001d\u0010\u001f\u001a\u00020\t2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J%\u0010$\u001a\u00020\t2\u0006\u0010\"\u001a\u00020!2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020#0\u001cH\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\tH\u0016¢\u0006\u0004\b&\u0010\rR\"\u0010(\u001a\u00020'8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00106\u001a\u0002058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010=\u001a\u00020<8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010D\u001a\u00020C8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\"\u0010N\u001a\u00020M8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\"\u0010]\u001a\u00020V8\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u0018\u0010a\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\"\u0010c\u001a\u00020b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\"\u0010j\u001a\u00020i8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\"\u0010q\u001a\u00020p8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\"\u0010x\u001a\u00020w8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u001a\u0010\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/select/new_metro/SelectMetroFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/select/new_metro/view_model/SelectMetroRouter;", "Lcom/avito/android/select/new_metro/SelectMetroListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "()V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "cancel", "", "Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItem;", "selected", "confirm", "(Ljava/util/List;)V", "", "requestId", "Lcom/avito/android/remote/model/Metro;", "onMetroSelected", "(Ljava/lang/String;Ljava/util/List;)V", "onSelectMetroCancel", "Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItemPresenter;", "metroStationsPresenter", "Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItemPresenter;", "getMetroStationsPresenter", "()Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItemPresenter;", "setMetroStationsPresenter", "(Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItemPresenter;)V", "Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypePresenter;", "metroTypePresenter", "Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypePresenter;", "getMetroTypePresenter", "()Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypePresenter;", "setMetroTypePresenter", "(Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypePresenter;)V", "Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItemPresenter;", "metroFiltersPresenter", "Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItemPresenter;", "getMetroFiltersPresenter", "()Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItemPresenter;", "setMetroFiltersPresenter", "(Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItemPresenter;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/avito/android/select/new_metro/view_model/SelectMetroViewModel;", "selectMetroViewModel", "Lcom/avito/android/select/new_metro/view_model/SelectMetroViewModel;", "getSelectMetroViewModel", "()Lcom/avito/android/select/new_metro/view_model/SelectMetroViewModel;", "setSelectMetroViewModel", "(Lcom/avito/android/select/new_metro/view_model/SelectMetroViewModel;)V", AuthSource.OPEN_CHANNEL_LIST, "Z", "showAcceptBtn", "Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemPresenter;", "metroLineItemPresenter", "Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemPresenter;", "getMetroLineItemPresenter", "()Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemPresenter;", "setMetroLineItemPresenter", "(Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemPresenter;)V", "l", "Ljava/lang/String;", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "n", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "getNavigationState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "setNavigationState", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;)V", "navigationState", "Lcom/avito/android/select/new_metro/view/SelectMetroView;", "k", "Lcom/avito/android/select/new_metro/view/SelectMetroView;", "metroView", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "recyclerPresenter", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "getRecyclerPresenter", "()Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "setRecyclerPresenter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItemPresenter;", "selectedStationsItemPresenter", "Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItemPresenter;", "getSelectedStationsItemPresenter", "()Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItemPresenter;", "setSelectedStationsItemPresenter", "(Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItemPresenter;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lio/reactivex/rxjava3/disposables/Disposable;", "j", "Lio/reactivex/rxjava3/disposables/Disposable;", "keyboardVisibilitySubscription", "<init>", "Companion", "select_release"}, k = 1, mv = {1, 4, 2})
public final class SelectMetroFragment extends TabBaseFragment implements SelectMetroRouter, SelectMetroListener {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public Features features;
    @Inject
    public ItemBinder itemBinder;
    public Disposable j;
    public SelectMetroView k;
    public String l = "";
    public boolean m;
    @Inject
    public MetroFilterItemPresenter metroFiltersPresenter;
    @Inject
    public MetroLineItemPresenter metroLineItemPresenter;
    @Inject
    public MetroStationItemPresenter metroStationsPresenter;
    @Inject
    public MetroListOutputTypePresenter metroTypePresenter;
    @NotNull
    public NavigationState n = new NavigationState(false);
    @Inject
    public SimpleRecyclerAdapter recyclerAdapter;
    @Inject
    public DataAwareAdapterPresenter recyclerPresenter;
    @Inject
    public SelectMetroViewModel selectMetroViewModel;
    @Inject
    public MetroSelectedStationsItemPresenter selectedStationsItemPresenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/select/new_metro/SelectMetroFragment$Companion;", "", "Landroidx/fragment/app/Fragment;", "targetFragment", "Lcom/avito/android/select/new_metro/SelectMetroParams;", "params", "Lcom/avito/android/select/new_metro/SelectMetroFragment;", "newInstance", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/select/new_metro/SelectMetroParams;)Lcom/avito/android/select/new_metro/SelectMetroFragment;", "", "SELECTED_METRO_STATIONS", "Ljava/lang/String;", "SELECT_METRO_PARAMS", "<init>", "()V", "select_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        @NotNull
        public final SelectMetroFragment newInstance(@Nullable Fragment fragment, @NotNull SelectMetroParams selectMetroParams) {
            Intrinsics.checkNotNullParameter(selectMetroParams, "params");
            SelectMetroFragment selectMetroFragment = new SelectMetroFragment();
            selectMetroFragment.setTargetFragment(fragment, 0);
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("SelectMetroArguments", selectMetroParams);
            Unit unit = Unit.INSTANCE;
            selectMetroFragment.setArguments(bundle);
            return selectMetroFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<T> implements Consumer<Boolean> {
        public final /* synthetic */ SelectMetroFragment a;

        public a(SelectMetroFragment selectMetroFragment) {
            this.a = selectMetroFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            SelectMetroView selectMetroView = this.a.k;
            if (selectMetroView != null) {
                Intrinsics.checkNotNullExpressionValue(bool2, "it");
                selectMetroView.onKeyboardShowed(bool2.booleanValue());
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class c<T> implements Observer<DataSource<Item>> {
        public final /* synthetic */ SelectMetroFragment a;

        public c(SelectMetroFragment selectMetroFragment) {
            this.a = selectMetroFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(DataSource<Item> dataSource) {
            SelectMetroView selectMetroView;
            DataSource<Item> dataSource2 = dataSource;
            if (dataSource2 != null && (selectMetroView = this.a.k) != null) {
                selectMetroView.onItemsChanged(dataSource2);
            }
        }
    }

    public static final class d<T> implements Observer<List<? extends Integer>> {
        public final /* synthetic */ SelectMetroFragment a;

        public d(SelectMetroFragment selectMetroFragment) {
            this.a = selectMetroFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.select.new_metro.view.SelectMetroView */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public void onChanged(List<? extends Integer> list) {
            SelectMetroView selectMetroView;
            List<? extends Integer> list2 = list;
            if (list2 != null && (selectMetroView = this.a.k) != 0) {
                selectMetroView.onSelectedStationsChanged(list2);
            }
        }
    }

    public static final class e<T> implements Observer<Unit> {
        public final /* synthetic */ SelectMetroFragment a;

        public e(SelectMetroFragment selectMetroFragment) {
            this.a = selectMetroFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Unit unit) {
            SelectMetroView selectMetroView = this.a.k;
            if (selectMetroView != null) {
                selectMetroView.onDropText();
            }
        }
    }

    public static final class f<T> implements Observer<RoutingAction> {
        public final /* synthetic */ SelectMetroFragment a;

        public f(SelectMetroFragment selectMetroFragment) {
            this.a = selectMetroFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(RoutingAction routingAction) {
            RoutingAction routingAction2 = routingAction;
            if (routingAction2 instanceof RoutingAction.CancelAction) {
                this.a.cancel();
            } else if (routingAction2 instanceof RoutingAction.ConfirmAction) {
                this.a.confirm(((RoutingAction.ConfirmAction) routingAction2).getSelected());
            }
        }
    }

    @JvmStatic
    @NotNull
    public static final SelectMetroFragment newInstance(@Nullable Fragment fragment, @NotNull SelectMetroParams selectMetroParams) {
        return Companion.newInstance(fragment, selectMetroParams);
    }

    @Override // com.avito.android.select.new_metro.view_model.SelectMetroRouter
    public void cancel() {
        View view = getView();
        if (view != null) {
            Keyboards.hideKeyboard$default(view, false, 1, null);
        }
        onSelectMetroCancel();
    }

    @Override // com.avito.android.select.new_metro.view_model.SelectMetroRouter
    public void confirm(@NotNull List<MetroStationItem> list) {
        Intrinsics.checkNotNullParameter(list, "selected");
        View view = getView();
        if (view != null) {
            Keyboards.hideKeyboard$default(view, false, 1, null);
        }
        String str = this.l;
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            arrayList.add(new Metro(String.valueOf(t.getStationId()), t.getStationName(), null));
        }
        onMetroSelected(str, arrayList);
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final MetroFilterItemPresenter getMetroFiltersPresenter() {
        MetroFilterItemPresenter metroFilterItemPresenter = this.metroFiltersPresenter;
        if (metroFilterItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("metroFiltersPresenter");
        }
        return metroFilterItemPresenter;
    }

    @NotNull
    public final MetroLineItemPresenter getMetroLineItemPresenter() {
        MetroLineItemPresenter metroLineItemPresenter2 = this.metroLineItemPresenter;
        if (metroLineItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("metroLineItemPresenter");
        }
        return metroLineItemPresenter2;
    }

    @NotNull
    public final MetroStationItemPresenter getMetroStationsPresenter() {
        MetroStationItemPresenter metroStationItemPresenter = this.metroStationsPresenter;
        if (metroStationItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("metroStationsPresenter");
        }
        return metroStationItemPresenter;
    }

    @NotNull
    public final MetroListOutputTypePresenter getMetroTypePresenter() {
        MetroListOutputTypePresenter metroListOutputTypePresenter = this.metroTypePresenter;
        if (metroListOutputTypePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("metroTypePresenter");
        }
        return metroListOutputTypePresenter;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    @NotNull
    public NavigationState getNavigationState() {
        return this.n;
    }

    @NotNull
    public final SimpleRecyclerAdapter getRecyclerAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        return simpleRecyclerAdapter;
    }

    @NotNull
    public final DataAwareAdapterPresenter getRecyclerPresenter() {
        DataAwareAdapterPresenter dataAwareAdapterPresenter = this.recyclerPresenter;
        if (dataAwareAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerPresenter");
        }
        return dataAwareAdapterPresenter;
    }

    @NotNull
    public final SelectMetroViewModel getSelectMetroViewModel() {
        SelectMetroViewModel selectMetroViewModel2 = this.selectMetroViewModel;
        if (selectMetroViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectMetroViewModel");
        }
        return selectMetroViewModel2;
    }

    @NotNull
    public final MetroSelectedStationsItemPresenter getSelectedStationsItemPresenter() {
        MetroSelectedStationsItemPresenter metroSelectedStationsItemPresenter = this.selectedStationsItemPresenter;
        if (metroSelectedStationsItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedStationsItemPresenter");
        }
        return metroSelectedStationsItemPresenter;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Observable<Boolean> keyboardVisibilityChanges;
        io.reactivex.rxjava3.core.Observable v3;
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        this.j = (activity == null || (keyboardVisibilityChanges = Keyboards.keyboardVisibilityChanges(activity, false)) == null || (v3 = InteropKt.toV3(keyboardVisibilityChanges)) == null) ? null : v3.subscribe(new a(this), b.a);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.select_metro_fragment, viewGroup, false);
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Disposable disposable = this.j;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.k = null;
        SelectMetroViewModel selectMetroViewModel2 = this.selectMetroViewModel;
        if (selectMetroViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectMetroViewModel");
        }
        selectMetroViewModel2.getItems().removeObservers(getViewLifecycleOwner());
        SelectMetroViewModel selectMetroViewModel3 = this.selectMetroViewModel;
        if (selectMetroViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectMetroViewModel");
        }
        selectMetroViewModel3.getSelectedItems().removeObservers(getViewLifecycleOwner());
        SelectMetroViewModel selectMetroViewModel4 = this.selectMetroViewModel;
        if (selectMetroViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectMetroViewModel");
        }
        selectMetroViewModel4.getDropText().removeObservers(getViewLifecycleOwner());
        SelectMetroViewModel selectMetroViewModel5 = this.selectMetroViewModel;
        if (selectMetroViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectMetroViewModel");
        }
        selectMetroViewModel5.getRoutingActions().removeObservers(getViewLifecycleOwner());
    }

    @Override // com.avito.android.select.new_metro.SelectMetroListener
    public void onMetroSelected(@NotNull String str, @NotNull List<Metro> list) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        Intrinsics.checkNotNullParameter(list, "selected");
        Intent putExtra = new Intent().putExtra(SelectActivityKt.EXTRA_SELECT_RESULT, new SelectResult(str, list, null, 4, null));
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent().putExtra(EXTRA_…equestId, selectedItems))");
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (!features2.getSelectMetroWithoutActivity().invoke().booleanValue() || (getActivity() instanceof SelectMetroActivity)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setResult(-1, putExtra);
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        setResult(-1, putExtra);
        finish();
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        SelectMetroViewModel selectMetroViewModel2 = this.selectMetroViewModel;
        if (selectMetroViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectMetroViewModel");
        }
        List<Integer> value = selectMetroViewModel2.getSelectedItems().getValue();
        if (value != null) {
            Intrinsics.checkNotNullExpressionValue(value, "it");
            bundle.putIntArray("SelectedMetroStations", CollectionsKt___CollectionsKt.toIntArray(value));
        }
    }

    @Override // com.avito.android.select.new_metro.SelectMetroListener
    public void onSelectMetroCancel() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (!features2.getSelectMetroWithoutActivity().invoke().booleanValue() || (getActivity() instanceof SelectMetroActivity)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setResult(0);
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        TabBaseFragment.setResult$default(this, 0, null, 2, null);
        finish();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        DataAwareAdapterPresenter dataAwareAdapterPresenter = this.recyclerPresenter;
        if (dataAwareAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerPresenter");
        }
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        SelectMetroViewModel selectMetroViewModel2 = this.selectMetroViewModel;
        if (selectMetroViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectMetroViewModel");
        }
        MetroLineItemPresenter metroLineItemPresenter2 = this.metroLineItemPresenter;
        if (metroLineItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("metroLineItemPresenter");
        }
        boolean z = this.m;
        MetroStationItemPresenter metroStationItemPresenter = this.metroStationsPresenter;
        if (metroStationItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("metroStationsPresenter");
        }
        MetroFilterItemPresenter metroFilterItemPresenter = this.metroFiltersPresenter;
        if (metroFilterItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("metroFiltersPresenter");
        }
        MetroListOutputTypePresenter metroListOutputTypePresenter = this.metroTypePresenter;
        if (metroListOutputTypePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("metroTypePresenter");
        }
        SelectMetroViewModel selectMetroViewModel3 = this.selectMetroViewModel;
        if (selectMetroViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectMetroViewModel");
        }
        List<Integer> value = selectMetroViewModel3.getSelectedItems().getValue();
        int size = value != null ? value.size() : 0;
        MetroSelectedStationsItemPresenter metroSelectedStationsItemPresenter = this.selectedStationsItemPresenter;
        if (metroSelectedStationsItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedStationsItemPresenter");
        }
        this.k = new SelectMetroViewImpl(dataAwareAdapterPresenter, simpleRecyclerAdapter, selectMetroViewModel2, z, metroStationItemPresenter, metroSelectedStationsItemPresenter, metroFilterItemPresenter, metroListOutputTypePresenter, size, metroLineItemPresenter2, view);
        SelectMetroViewModel selectMetroViewModel4 = this.selectMetroViewModel;
        if (selectMetroViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectMetroViewModel");
        }
        selectMetroViewModel4.getItems().observe(getViewLifecycleOwner(), new c(this));
        SelectMetroViewModel selectMetroViewModel5 = this.selectMetroViewModel;
        if (selectMetroViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectMetroViewModel");
        }
        selectMetroViewModel5.getSelectedItems().observe(getViewLifecycleOwner(), new d(this));
        SelectMetroViewModel selectMetroViewModel6 = this.selectMetroViewModel;
        if (selectMetroViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectMetroViewModel");
        }
        selectMetroViewModel6.getDropText().observe(getViewLifecycleOwner(), new e(this));
        SelectMetroViewModel selectMetroViewModel7 = this.selectMetroViewModel;
        if (selectMetroViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectMetroViewModel");
        }
        selectMetroViewModel7.getRoutingActions().observe(getViewLifecycleOwner(), new f(this));
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setMetroFiltersPresenter(@NotNull MetroFilterItemPresenter metroFilterItemPresenter) {
        Intrinsics.checkNotNullParameter(metroFilterItemPresenter, "<set-?>");
        this.metroFiltersPresenter = metroFilterItemPresenter;
    }

    public final void setMetroLineItemPresenter(@NotNull MetroLineItemPresenter metroLineItemPresenter2) {
        Intrinsics.checkNotNullParameter(metroLineItemPresenter2, "<set-?>");
        this.metroLineItemPresenter = metroLineItemPresenter2;
    }

    public final void setMetroStationsPresenter(@NotNull MetroStationItemPresenter metroStationItemPresenter) {
        Intrinsics.checkNotNullParameter(metroStationItemPresenter, "<set-?>");
        this.metroStationsPresenter = metroStationItemPresenter;
    }

    public final void setMetroTypePresenter(@NotNull MetroListOutputTypePresenter metroListOutputTypePresenter) {
        Intrinsics.checkNotNullParameter(metroListOutputTypePresenter, "<set-?>");
        this.metroTypePresenter = metroListOutputTypePresenter;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    public void setNavigationState(@NotNull NavigationState navigationState) {
        Intrinsics.checkNotNullParameter(navigationState, "<set-?>");
        this.n = navigationState;
    }

    public final void setRecyclerAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.recyclerAdapter = simpleRecyclerAdapter;
    }

    public final void setRecyclerPresenter(@NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "<set-?>");
        this.recyclerPresenter = dataAwareAdapterPresenter;
    }

    public final void setSelectMetroViewModel(@NotNull SelectMetroViewModel selectMetroViewModel2) {
        Intrinsics.checkNotNullParameter(selectMetroViewModel2, "<set-?>");
        this.selectMetroViewModel = selectMetroViewModel2;
    }

    public final void setSelectedStationsItemPresenter(@NotNull MetroSelectedStationsItemPresenter metroSelectedStationsItemPresenter) {
        Intrinsics.checkNotNullParameter(metroSelectedStationsItemPresenter, "<set-?>");
        this.selectedStationsItemPresenter = metroSelectedStationsItemPresenter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        int[] intArray;
        Bundle arguments = getArguments();
        ArrayList arrayList = null;
        SelectMetroParams selectMetroParams = arguments != null ? (SelectMetroParams) arguments.getParcelable("SelectMetroArguments") : null;
        if (selectMetroParams != null) {
            if (!(bundle == null || (intArray = bundle.getIntArray("SelectedMetroStations")) == null)) {
                arrayList = ArraysKt___ArraysJvmKt.asList(intArray);
            }
            if (arrayList == null) {
                List<ParcelableEntity<String>> selectedValues = selectMetroParams.getSelectedValues();
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it = selectedValues.iterator();
                while (it.hasNext()) {
                    Integer intOrNull = l.toIntOrNull((String) it.next().getId());
                    if (intOrNull != null) {
                        arrayList2.add(intOrNull);
                    }
                }
                arrayList = arrayList2;
            }
            SelectMetroFragmentComponent.Builder builder = DaggerSelectMetroFragmentComponent.builder();
            Intrinsics.checkNotNullExpressionValue(builder, "DaggerSelectMetroFragmentComponent.builder()");
            builder.bindFragment(this).bindParams(selectMetroParams).bindSelectedStations(arrayList).setDependencies((CoreComponentDependencies) FragmentsKt.appComponent(this)).build().inject(this);
            if (bundle == null) {
                this.m = !arrayList.isEmpty();
            }
            this.l = selectMetroParams.getRequestId();
            return true;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
