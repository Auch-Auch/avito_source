package com.avito.android.select.new_metro.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.input.Input;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.select.R;
import com.avito.android.select.new_metro.MetroLineStickyHeaderImpl;
import com.avito.android.select.new_metro.adapter.filter.MetroFilterItem;
import com.avito.android.select.new_metro.adapter.filter.MetroFilterItemPresenter;
import com.avito.android.select.new_metro.adapter.lineItem.MetroLineItem;
import com.avito.android.select.new_metro.adapter.lineItem.MetroLineItemPresenter;
import com.avito.android.select.new_metro.adapter.lineItem.MetroLineItemViewImpl;
import com.avito.android.select.new_metro.adapter.metro_station.MetroStationItem;
import com.avito.android.select.new_metro.adapter.metro_station.MetroStationItemPresenter;
import com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItem;
import com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItemPresenter;
import com.avito.android.select.new_metro.adapter.switcher.MetroListOutputTypeItem;
import com.avito.android.select.new_metro.adapter.switcher.MetroListOutputTypePresenter;
import com.avito.android.select.new_metro.view_model.SelectMetroViewModel;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.avito.android.util.ActionMenu;
import com.avito.android.util.Logs;
import com.avito.android.util.SimpleTextWatcher;
import com.avito.android.util.ViewUtils;
import com.avito.android.util.Views;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.appbar.AppBar;
import ru.avito.component.appbar.AppBarImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001Bc\b\u0007\u0012\u0006\u0010V\u001a\u00020S\u0012\u0006\u0010Z\u001a\u00020W\u0012\u0006\u0010b\u001a\u00020_\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010d\u001a\u00020c\u0012\u0006\u0010f\u001a\u00020e\u0012\u0006\u0010h\u001a\u00020g\u0012\u0006\u0010j\u001a\u00020i\u0012\b\b\u0002\u0010k\u001a\u00020\r\u0012\u0006\u0010m\u001a\u00020l\u0012\u0006\u0010n\u001a\u00020E¢\u0006\u0004\bo\u0010pJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0017\u0010\u0006R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010\u0019R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010\u0019R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010a¨\u0006q"}, d2 = {"Lcom/avito/android/select/new_metro/view/SelectMetroViewImpl;", "Lcom/avito/android/select/new_metro/view/SelectMetroView;", "", "showed", "", "onKeyboardShowed", "(Z)V", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/conveyor_item/Item;", "items", "onItemsChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "", "", "selectedStationsId", "onSelectedStationsChanged", "(Ljava/util/List;)V", "onDropText", "()V", "selectedCount", AuthSource.BOOKING_ORDER, "(I)V", "show", AuthSource.SEND_ABUSE, "u", "Z", "shouldShowSaveBtnWithEmptySelection", "Landroid/content/res/Resources;", "Landroid/content/res/Resources;", "resources", "Landroid/widget/FrameLayout;", "h", "Landroid/widget/FrameLayout;", "selectButtonContainer", "Landroid/view/inputmethod/InputMethodManager;", "l", "Landroid/view/inputmethod/InputMethodManager;", "inputManager", "n", "I", "bottomBtnContainerHeight", "Lcom/avito/android/lib/design/button/Button;", a2.g.r.g.a, "Lcom/avito/android/lib/design/button/Button;", "selectButton", "p", "keyboardVisible", "Lcom/avito/android/lib/design/input/Input;", "i", "Lcom/avito/android/lib/design/input/Input;", "searchByName", "Landroidx/recyclerview/widget/LinearLayoutManager;", "d", "Landroidx/recyclerview/widget/LinearLayoutManager;", "stationsListLayoutManager", "Lcom/avito/android/util/ActionMenu;", "o", "Lcom/avito/android/util/ActionMenu;", "clearActionMenu", VKApiConst.Q, "needScroll", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "Lru/avito/component/appbar/AppBar;", "e", "Lru/avito/component/appbar/AppBar;", "appBar", "Landroid/view/View;", "j", "Landroid/view/View;", TariffPackageInfoConverterKt.HEADER_STRING_ID, "k", "Lcom/avito/konveyor/data_source/DataSource;", "currentDataSource", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "r", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "recyclerPresenter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "s", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/android/select/new_metro/MetroLineStickyHeaderImpl;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/select/new_metro/MetroLineStickyHeaderImpl;", "stickyHeader", "Lcom/avito/android/select/new_metro/view_model/SelectMetroViewModel;", "t", "Lcom/avito/android/select/new_metro/view_model/SelectMetroViewModel;", "selectMetroViewModel", "Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItemPresenter;", "stationsPresenter", "Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItemPresenter;", "selectedStationsPresenter", "Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItemPresenter;", "filtersPresenter", "Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypePresenter;", "outputTypePresenter", "initialSelected", "Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemPresenter;", "metroLineItemPresenter", "view", "<init>", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;Lcom/avito/android/select/new_metro/view_model/SelectMetroViewModel;ZLcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItemPresenter;Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItemPresenter;Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItemPresenter;Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypePresenter;ILcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemPresenter;Landroid/view/View;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class SelectMetroViewImpl implements SelectMetroView {
    public final Context a;
    public final Resources b;
    public final CompositeDisposable c;
    public final LinearLayoutManager d;
    public final AppBar e;
    public final RecyclerView f;
    public final Button g;
    public final FrameLayout h;
    public final Input i;
    public final View j;
    public DataSource<Item> k;
    public InputMethodManager l;
    public MetroLineStickyHeaderImpl m;
    public int n;
    public final ActionMenu o;
    public boolean p;
    public boolean q;
    public final DataAwareAdapterPresenter r;
    public final SimpleRecyclerAdapter s;
    public final SelectMetroViewModel t;
    public final boolean u;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Throwable> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public static final a d = new a(2);
        public static final a e = new a(3);
        public static final a f = new a(4);
        public static final a g = new a(5);
        public static final a h = new a(6);
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Throwable th) {
            switch (this.a) {
                case 0:
                    Logs.error(th);
                    return;
                case 1:
                    Logs.error(th);
                    return;
                case 2:
                    Logs.error(th);
                    return;
                case 3:
                    Logs.error(th);
                    return;
                case 4:
                    Logs.error(th);
                    return;
                case 5:
                    Logs.error(th);
                    return;
                case 6:
                    Logs.error(th);
                    return;
                default:
                    throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<MetroFilterItem> {
        public final /* synthetic */ SelectMetroViewImpl a;

        public b(SelectMetroViewImpl selectMetroViewImpl) {
            this.a = selectMetroViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(MetroFilterItem metroFilterItem) {
            MetroFilterItem metroFilterItem2 = metroFilterItem;
            SelectMetroViewModel selectMetroViewModel = this.a.t;
            Intrinsics.checkNotNullExpressionValue(metroFilterItem2, "it");
            selectMetroViewModel.onFilterStateChanged(metroFilterItem2);
        }
    }

    public static final class c<T> implements Consumer<MetroListOutputTypeItem> {
        public final /* synthetic */ SelectMetroViewImpl a;

        public c(SelectMetroViewImpl selectMetroViewImpl) {
            this.a = selectMetroViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(MetroListOutputTypeItem metroListOutputTypeItem) {
            MetroListOutputTypeItem metroListOutputTypeItem2 = metroListOutputTypeItem;
            SelectMetroViewModel selectMetroViewModel = this.a.t;
            Intrinsics.checkNotNullExpressionValue(metroListOutputTypeItem2, "it");
            selectMetroViewModel.onNewOutputTypeSelected(metroListOutputTypeItem2);
        }
    }

    public static final class d<T> implements Consumer<MetroLineItem> {
        public final /* synthetic */ SelectMetroViewImpl a;

        public d(SelectMetroViewImpl selectMetroViewImpl) {
            this.a = selectMetroViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(MetroLineItem metroLineItem) {
            MetroLineItem metroLineItem2 = metroLineItem;
            SelectMetroViewModel selectMetroViewModel = this.a.t;
            Intrinsics.checkNotNullExpressionValue(metroLineItem2, "it");
            selectMetroViewModel.onLineStateChanged(metroLineItem2);
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ SelectMetroViewImpl a;

        public e(SelectMetroViewImpl selectMetroViewImpl) {
            this.a = selectMetroViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.t.onConfirmClicked();
        }
    }

    public static final class f<T> implements Consumer<Integer> {
        public final /* synthetic */ SelectMetroViewImpl a;

        public f(SelectMetroViewImpl selectMetroViewImpl) {
            this.a = selectMetroViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Integer num) {
            this.a.t.onClearSelected();
        }
    }

    public static final class g<T> implements Consumer<Unit> {
        public final /* synthetic */ SelectMetroViewImpl a;

        public g(SelectMetroViewImpl selectMetroViewImpl) {
            this.a = selectMetroViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.t.onCancelClicked();
        }
    }

    public static final class h<T> implements Consumer<MetroStationItem> {
        public final /* synthetic */ SelectMetroViewImpl a;

        public h(SelectMetroViewImpl selectMetroViewImpl) {
            this.a = selectMetroViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(MetroStationItem metroStationItem) {
            MetroStationItem metroStationItem2 = metroStationItem;
            SelectMetroViewModel selectMetroViewModel = this.a.t;
            Intrinsics.checkNotNullExpressionValue(metroStationItem2, "it");
            selectMetroViewModel.onStationStateChanged(metroStationItem2);
        }
    }

    public static final class i<T> implements Consumer<MetroSelectedStationsItem> {
        public final /* synthetic */ SelectMetroViewImpl a;

        public i(SelectMetroViewImpl selectMetroViewImpl) {
            this.a = selectMetroViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(MetroSelectedStationsItem metroSelectedStationsItem) {
            this.a.t.onSelectedStationsItemChange();
        }
    }

    public static final class j implements Runnable {
        public final /* synthetic */ SelectMetroViewImpl a;
        public final /* synthetic */ boolean b;

        public j(SelectMetroViewImpl selectMetroViewImpl, boolean z) {
            this.a = selectMetroViewImpl;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Views.setVisible(this.a.h, !this.b);
        }
    }

    @Inject
    public SelectMetroViewImpl(@NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter, @NotNull SimpleRecyclerAdapter simpleRecyclerAdapter, @NotNull SelectMetroViewModel selectMetroViewModel, boolean z, @NotNull MetroStationItemPresenter metroStationItemPresenter, @NotNull MetroSelectedStationsItemPresenter metroSelectedStationsItemPresenter, @NotNull MetroFilterItemPresenter metroFilterItemPresenter, @NotNull MetroListOutputTypePresenter metroListOutputTypePresenter, int i2, @NotNull MetroLineItemPresenter metroLineItemPresenter, @NotNull View view) {
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "recyclerPresenter");
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "recyclerAdapter");
        Intrinsics.checkNotNullParameter(selectMetroViewModel, "selectMetroViewModel");
        Intrinsics.checkNotNullParameter(metroStationItemPresenter, "stationsPresenter");
        Intrinsics.checkNotNullParameter(metroSelectedStationsItemPresenter, "selectedStationsPresenter");
        Intrinsics.checkNotNullParameter(metroFilterItemPresenter, "filtersPresenter");
        Intrinsics.checkNotNullParameter(metroListOutputTypePresenter, "outputTypePresenter");
        Intrinsics.checkNotNullParameter(metroLineItemPresenter, "metroLineItemPresenter");
        Intrinsics.checkNotNullParameter(view, "view");
        this.r = dataAwareAdapterPresenter;
        this.s = simpleRecyclerAdapter;
        this.t = selectMetroViewModel;
        this.u = z;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.a = context;
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        this.b = resources;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.c = compositeDisposable;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        this.d = linearLayoutManager;
        AppBarImpl appBarImpl = new AppBarImpl(view, null, false, 4, null);
        this.e = appBarImpl;
        View findViewById = view.findViewById(R.id.select_metro_recycler_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.f = recyclerView;
        View findViewById2 = view.findViewById(R.id.select_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.select_btn)");
        Button button = (Button) findViewById2;
        this.g = button;
        View findViewById3 = view.findViewById(R.id.select_btn_container);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.h = (FrameLayout) findViewById3;
        View findViewById4 = view.findViewById(R.id.select_metro_input);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        Input input = (Input) findViewById4;
        this.i = input;
        View findViewById5 = view.findViewById(R.id.metro_line_item_root);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.j = findViewById5;
        ListDataSource listDataSource = new ListDataSource(CollectionsKt__CollectionsKt.emptyList());
        this.k = listDataSource;
        this.m = new MetroLineStickyHeaderImpl(listDataSource, recyclerView, new MetroLineItemViewImpl(findViewById5), metroLineItemPresenter);
        String string = context.getString(R.string.select_metro_clear);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.select_metro_clear)");
        this.o = new ActionMenu(string, 1, null, null, null, 28, null);
        input.addTextChangedListener(new SimpleTextWatcher(this) { // from class: com.avito.android.select.new_metro.view.SelectMetroViewImpl$$special$$inlined$with$lambda$1
            public final /* synthetic */ SelectMetroViewImpl a;

            {
                this.a = r1;
            }

            @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
            public void afterTextChanged(@NotNull Editable editable) {
                Intrinsics.checkNotNullParameter(editable, "s");
                this.a.t.onSearchTextChanged(editable.toString());
                if (editable.length() > 0) {
                    this.a.q = true;
                }
            }
        });
        input.setHint(R.string.select_metro_station_name_input_hint);
        input.setFocusByClearButton(false);
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        Objects.requireNonNull(itemAnimator, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        this.n = resources.getDimensionPixelSize(R.dimen.select_metro_btn_container_height);
        appBarImpl.setTitle(R.string.select_metro_fragment_title);
        AppBar.DefaultImpls.setNavigationIcon$default(appBarImpl, com.avito.android.ui_components.R.drawable.ic_close_24_blue, null, 2, null);
        Disposable subscribe = appBarImpl.menuCallbacks().subscribe(new f(this), a.e);
        Intrinsics.checkNotNullExpressionValue(subscribe, "appBar.menuCallbacks().s…Logs.error(it)\n        })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        Disposable subscribe2 = appBarImpl.navigationCallbacks().subscribe(new g(this), a.f);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "appBar.navigationCallbac…Logs.error(it)\n        })");
        DisposableKt.plusAssign(compositeDisposable, subscribe2);
        Disposable subscribe3 = metroStationItemPresenter.getValueChangedStream().subscribe(new h(this), a.g);
        Intrinsics.checkNotNullExpressionValue(subscribe3, "stationsPresenter\n      ….error(it)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe3);
        Disposable subscribe4 = metroSelectedStationsItemPresenter.getValueChanges().subscribe(new i(this), a.h);
        Intrinsics.checkNotNullExpressionValue(subscribe4, "selectedStationsPresente….error(it)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe4);
        Disposable subscribe5 = metroFilterItemPresenter.getValueChangesStream().subscribe(new b(this), a.b);
        Intrinsics.checkNotNullExpressionValue(subscribe5, "filtersPresenter\n       ….error(it)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe5);
        Disposable subscribe6 = metroListOutputTypePresenter.getValueChangedStream().subscribe(new c(this), a.c);
        Intrinsics.checkNotNullExpressionValue(subscribe6, "outputTypePresenter\n    ….error(it)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe6);
        Disposable subscribe7 = metroLineItemPresenter.getExpandedChangeObservable().subscribe(new d(this), a.d);
        Intrinsics.checkNotNullExpressionValue(subscribe7, "metroLineItemPresenter\n ….error(it)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe7);
        simpleRecyclerAdapter.setHasStableIds(true);
        recyclerView.setAdapter(simpleRecyclerAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        button.setOnClickListener(new e(this));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(this) { // from class: com.avito.android.select.new_metro.view.SelectMetroViewImpl.18
            public final /* synthetic */ SelectMetroViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView2, int i3) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                super.onScrollStateChanged(recyclerView2, i3);
                if (this.a.p && i3 == 1) {
                    SelectMetroViewImpl.access$hideKeyBoard(this.a);
                }
            }
        });
        Object systemService = context.getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        this.l = (InputMethodManager) systemService;
        b(i2);
    }

    public static final void access$hideKeyBoard(SelectMetroViewImpl selectMetroViewImpl) {
        selectMetroViewImpl.f.post(new a2.a.a.m2.m.b.a(selectMetroViewImpl));
    }

    public static final void access$hideKeyboard(SelectMetroViewImpl selectMetroViewImpl, View view, boolean z) {
        InputMethodManager inputMethodManager = selectMetroViewImpl.l;
        View rootView = view.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        inputMethodManager.hideSoftInputFromWindow(rootView.getWindowToken(), 0);
        if (z && !ViewUtils.INSTANCE.pickFocus(view)) {
            view.getRootView().clearFocus();
        }
    }

    public final void a(boolean z) {
        this.h.animate().translationY(z ? 0.0f : (float) this.n).setDuration(150).start();
        int findLastVisibleItemPosition = this.d.findLastVisibleItemPosition();
        boolean z2 = true;
        int count = this.k.getCount() - 1;
        if (!(findLastVisibleItemPosition == count || findLastVisibleItemPosition + 1 == count)) {
            z2 = false;
        }
        if (z2 && z && this.q) {
            this.f.scrollToPosition(0);
            this.q = false;
        }
    }

    public final void b(int i2) {
        if (i2 == 0) {
            a(false);
            this.e.showActionsMenu(CollectionsKt__CollectionsKt.emptyList());
            if (this.u) {
                Button button = this.g;
                button.setText(R.string.f10selet_metro_accept);
                Views.show(button);
                a(true);
                return;
            }
            return;
        }
        Button button2 = this.g;
        String quantityString = button2.getResources().getQuantityString(R.plurals.select_n_stations, i2, Integer.valueOf(i2));
        Intrinsics.checkNotNullExpressionValue(quantityString, "resources.getQuantityStr…edCount\n                )");
        button2.setText(quantityString);
        Views.show(button2);
        a(true);
        this.e.showActionsMenu(t6.n.d.listOf(this.o));
    }

    @Override // com.avito.android.select.new_metro.view.SelectMetroView
    public void onDropText() {
        this.i.setText((Editable) null);
        this.f.post(new a2.a.a.m2.m.b.a(this));
    }

    @Override // com.avito.android.select.new_metro.view.SelectMetroView
    public void onItemsChanged(@NotNull DataSource<Item> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "items");
        this.k = dataSource;
        this.r.onDataSourceChanged(dataSource);
        this.m.setDataSource(dataSource);
    }

    @Override // com.avito.android.select.new_metro.view.SelectMetroView
    public void onKeyboardShowed(boolean z) {
        this.p = z;
        this.h.post(new j(this, z));
        if (!z) {
            Views.show(this.g);
            this.f.getRootView().clearFocus();
            return;
        }
        Views.hide(this.g);
    }

    @Override // com.avito.android.select.new_metro.view.SelectMetroView
    public void onSelectedStationsChanged(@NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "selectedStationsId");
        b(list.size());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelectMetroViewImpl(DataAwareAdapterPresenter dataAwareAdapterPresenter, SimpleRecyclerAdapter simpleRecyclerAdapter, SelectMetroViewModel selectMetroViewModel, boolean z, MetroStationItemPresenter metroStationItemPresenter, MetroSelectedStationsItemPresenter metroSelectedStationsItemPresenter, MetroFilterItemPresenter metroFilterItemPresenter, MetroListOutputTypePresenter metroListOutputTypePresenter, int i2, MetroLineItemPresenter metroLineItemPresenter, View view, int i3, t6.r.a.j jVar) {
        this(dataAwareAdapterPresenter, simpleRecyclerAdapter, selectMetroViewModel, z, metroStationItemPresenter, metroSelectedStationsItemPresenter, metroFilterItemPresenter, metroListOutputTypePresenter, (i3 & 256) != 0 ? 0 : i2, metroLineItemPresenter, view);
    }
}
