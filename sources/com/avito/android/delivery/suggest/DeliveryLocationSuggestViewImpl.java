package com.avito.android.delivery.suggest;

import a2.a.a.k0.d.e;
import a2.a.a.k0.d.f;
import a2.g.r.g;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.delivery.R;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.data_source.DataSource;
import com.jakewharton.rxbinding3.appcompat.RxToolbar;
import com.jakewharton.rxbinding3.widget.RxTextView;
import io.reactivex.functions.Consumer;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001f\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u0006:"}, d2 = {"Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestViewImpl;", "Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestView;", "Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestViewModel;", "viewModel", "", "bindTo", "(Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestViewModel;)V", g.a, "Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestViewModel;", "Landroidx/appcompat/widget/Toolbar;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Ljava/lang/Runnable;", "f", "Ljava/lang/Runnable;", "searchAction", "Landroid/view/View;", "i", "Landroid/view/View;", "view", "Lio/reactivex/rxjava3/core/Observable;", "h", "Lio/reactivex/rxjava3/core/Observable;", "getNavigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "navigationClicks", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/lifecycle/LifecycleOwner;", "k", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroid/widget/ImageButton;", "c", "Landroid/widget/ImageButton;", "clearButton", "Landroid/widget/EditText;", AuthSource.BOOKING_ORDER, "Landroid/widget/EditText;", "searchView", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "e", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "j", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/analytics/Analytics;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryLocationSuggestViewImpl implements DeliveryLocationSuggestView {
    public final Toolbar a;
    public EditText b;
    public final ImageButton c;
    public final RecyclerView d;
    public ProgressOverlay e;
    public Runnable f;
    public DeliveryLocationSuggestViewModel g;
    @NotNull
    public final Observable<Unit> h;
    public final View i;
    public final AdapterPresenter j;
    public final LifecycleOwner k;

    public static final class a<T> implements Observer<DataSource<Item>> {
        public final /* synthetic */ DeliveryLocationSuggestViewImpl a;

        public a(DeliveryLocationSuggestViewImpl deliveryLocationSuggestViewImpl) {
            this.a = deliveryLocationSuggestViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(DataSource<Item> dataSource) {
            DataSource<Item> dataSource2 = dataSource;
            if (dataSource2 != null) {
                this.a.j.onDataSourceChanged(dataSource2);
                RecyclerView recyclerView = this.a.d;
                Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
                RecyclerView recyclerView2 = this.a.d;
                boolean z = true;
                if (dataSource2.isEmpty()) {
                    Editable text = this.a.b.getText();
                    Intrinsics.checkNotNullExpressionValue(text, "searchView.text");
                    if (text.length() == 0) {
                        z = false;
                    }
                }
                Views.setVisible(recyclerView2, z);
            }
        }
    }

    public static final class b<T> implements Observer<Boolean> {
        public final /* synthetic */ DeliveryLocationSuggestViewImpl a;

        public b(DeliveryLocationSuggestViewImpl deliveryLocationSuggestViewImpl) {
            this.a = deliveryLocationSuggestViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Boolean bool) {
            Boolean bool2 = bool;
            if (bool2 != null) {
                bool2.booleanValue();
                if (bool2.booleanValue()) {
                    LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.a.e, null, 1, null);
                } else {
                    Views.showSnackBar$default(this.a.i, R.string.has_error_occurred, 0, (Integer) null, 0, (Function0) null, (Function0) null, 0, 124, (Object) null);
                }
            }
        }
    }

    public static final class c<T> implements Consumer<CharSequence> {
        public final /* synthetic */ DeliveryLocationSuggestViewImpl a;
        public final /* synthetic */ DeliveryLocationSuggestViewModel b;

        public c(DeliveryLocationSuggestViewImpl deliveryLocationSuggestViewImpl, DeliveryLocationSuggestViewModel deliveryLocationSuggestViewModel) {
            this.a = deliveryLocationSuggestViewImpl;
            this.b = deliveryLocationSuggestViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            DeliveryLocationSuggestViewImpl.access$search(this.a, charSequence2.toString(), this.b);
            ImageButton imageButton = this.a.c;
            Intrinsics.checkNotNullExpressionValue(charSequence2, "query");
            Views.setVisible(imageButton, !m.isBlank(charSequence2));
        }
    }

    public static final class d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ DeliveryLocationSuggestViewImpl a;
        public final /* synthetic */ DeliveryLocationSuggestViewModel b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(DeliveryLocationSuggestViewImpl deliveryLocationSuggestViewImpl, DeliveryLocationSuggestViewModel deliveryLocationSuggestViewModel) {
            super(0);
            this.a = deliveryLocationSuggestViewImpl;
            this.b = deliveryLocationSuggestViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            DeliveryLocationSuggestViewImpl deliveryLocationSuggestViewImpl = this.a;
            DeliveryLocationSuggestViewImpl.access$search(deliveryLocationSuggestViewImpl, deliveryLocationSuggestViewImpl.b.getText().toString(), this.b);
            return Unit.INSTANCE;
        }
    }

    public DeliveryLocationSuggestViewImpl(@NotNull View view, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder, @NotNull LifecycleOwner lifecycleOwner, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.i = view;
        this.j = adapterPresenter;
        this.k = lifecycleOwner;
        View inflate = ((ViewStub) view.findViewById(R.id.stub_toolbar)).inflate();
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) inflate;
        this.a = toolbar;
        int i2 = R.id.recycler_view;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(i2);
        this.d = recyclerView;
        View findViewById = view.findViewById(R.id.content_holder);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        this.e = new ProgressOverlay((ViewGroup) findViewById, i2, analytics, false, 0, 24, null);
        this.h = InteropKt.toV3(RxToolbar.navigationClicks(toolbar));
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), 1, false));
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setAdapter(new SimpleRecyclerAdapter(adapterPresenter, itemBinder));
        View inflate2 = LayoutInflater.from(view.getContext()).inflate(R.layout.delivery_suggest_search_view, (ViewGroup) toolbar, true);
        Intrinsics.checkNotNullExpressionValue(inflate2, "toolbarSearchView");
        View findViewById2 = inflate2.findViewById(R.id.search_view);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.EditText");
        EditText editText = (EditText) findViewById2;
        this.b = editText;
        Keyboards.showKeyboard$default(editText, 0, 1, null);
        this.b.setHint(view.getContext().getString(R.string.delivery_suggest_location_hint));
        this.b.setOnEditorActionListener(new e(this));
        View findViewById3 = inflate2.findViewById(R.id.select_dialog_search_view_clear);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageButton");
        ImageButton imageButton = (ImageButton) findViewById3;
        this.c = imageButton;
        imageButton.setOnClickListener(new a2.a.a.k0.d.d(this));
        Views.hide(imageButton);
    }

    public static final /* synthetic */ DeliveryLocationSuggestViewModel access$getViewModel$p(DeliveryLocationSuggestViewImpl deliveryLocationSuggestViewImpl) {
        DeliveryLocationSuggestViewModel deliveryLocationSuggestViewModel = deliveryLocationSuggestViewImpl.g;
        if (deliveryLocationSuggestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return deliveryLocationSuggestViewModel;
    }

    public static final void access$search(DeliveryLocationSuggestViewImpl deliveryLocationSuggestViewImpl, String str, DeliveryLocationSuggestViewModel deliveryLocationSuggestViewModel) {
        deliveryLocationSuggestViewImpl.b.removeCallbacks(deliveryLocationSuggestViewImpl.f);
        f fVar = new f(deliveryLocationSuggestViewModel, str);
        deliveryLocationSuggestViewImpl.f = fVar;
        deliveryLocationSuggestViewImpl.b.postDelayed(fVar, 500);
    }

    @Override // com.avito.android.delivery.suggest.DeliveryLocationSuggestView
    public void bindTo(@NotNull DeliveryLocationSuggestViewModel deliveryLocationSuggestViewModel) {
        Intrinsics.checkNotNullParameter(deliveryLocationSuggestViewModel, "viewModel");
        this.g = deliveryLocationSuggestViewModel;
        deliveryLocationSuggestViewModel.getDataChanges().observe(this.k, new a(this));
        deliveryLocationSuggestViewModel.getErrorChanges().observe(this.k, new b(this));
        RxTextView.textChanges(this.b).skip(1).doOnNext(new c(this, deliveryLocationSuggestViewModel)).subscribe();
        this.e.setOnRefreshListener(new d(this, deliveryLocationSuggestViewModel));
    }

    @Override // com.avito.android.delivery.suggest.DeliveryLocationSuggestView
    @NotNull
    public Observable<Unit> getNavigationClicks() {
        return this.h;
    }
}
