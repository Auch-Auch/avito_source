package com.avito.android.delivery.map.point_info;

import a2.b.a.a.a;
import a2.g.r.g;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.delivery.R;
import com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoView;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.PaddingListDecoration;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jakewharton.rxbinding4.view.RxView;
import com.jakewharton.rxrelay3.PublishRelay;
import com.jakewharton.rxrelay3.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010P\u001a\u00020\u0007\u0012\u0006\u0010Y\u001a\u00020T\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010'\u001a\u00020\"¢\u0006\u0004\b\\\u0010]J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001dR\u0019\u0010'\u001a\u00020\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010\tR\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00100R\u001c\u00107\u001a\b\u0012\u0004\u0012\u00020.048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u00100R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010\u0013R\u0016\u0010L\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010\tR\u0019\u0010P\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010\t\u001a\u0004\bN\u0010OR\"\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00040\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bQ\u0010\u001b\u001a\u0004\bR\u0010\u001dR\u0019\u0010Y\u001a\u00020T8\u0006@\u0006¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bZ\u0010\t¨\u0006^"}, d2 = {"Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoViewImpl;", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoView;", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoView$State;", "state", "", "render", "(Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoView$State;)V", "Landroid/view/View;", "h", "Landroid/view/View;", "progressBar", "Lcom/avito/konveyor/ItemBinder;", "u", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Landroid/widget/TextView;", AuthSource.OPEN_CHANNEL_LIST, "Landroid/widget/TextView;", "overlayLabelView", "Lcom/jakewharton/rxrelay3/Relay;", "o", "Lcom/jakewharton/rxrelay3/Relay;", "bottomSheetHideRelay", "Lio/reactivex/rxjava3/core/Observable;", "p", "Lio/reactivex/rxjava3/core/Observable;", "getSubmitButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "submitButtonClicks", VKApiConst.Q, "getRetryButtonClicks", "retryButtonClicks", "Lcom/avito/android/util/text/AttributedTextFormatter;", VKApiConst.VERSION, "Lcom/avito/android/util/text/AttributedTextFormatter;", "getAttributedTextFormatter", "()Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "j", "submitButtonContainer", "Landroidx/recyclerview/widget/RecyclerView;", "i", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "infoContainer", "e", "errorContainer", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", g.a, "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "bottomSheetBehavior", "n", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoView$State;", "previousState", AuthSource.SEND_ABUSE, "container", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", AuthSource.BOOKING_ORDER, "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "findMeButton", "", "getBottomSheetPeekHeight", "()I", "bottomSheetPeekHeight", "Lcom/avito/android/lib/design/button/Button;", "k", "Lcom/avito/android/lib/design/button/Button;", "retryButton", "f", "errorTitle", "c", "toolbar", "s", "getRootView", "()Landroid/view/View;", "rootView", "r", "getBottomSheetHideObservable", "bottomSheetHideObservable", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "t", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "l", "overlayContainer", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryRdsPointInfoViewImpl implements DeliveryRdsPointInfoView {
    public final ViewGroup a;
    public final FloatingActionButton b;
    public final View c;
    public final ViewGroup d;
    public final ViewGroup e;
    public final TextView f;
    public final BottomSheetBehavior<ViewGroup> g;
    public View h;
    public RecyclerView i;
    public View j;
    public Button k;
    public View l;
    public TextView m;
    public DeliveryRdsPointInfoView.State n;
    public final Relay<Unit> o;
    @NotNull
    public final Observable<Unit> p;
    @NotNull
    public final Observable<Unit> q = RxView.clicks(this.k);
    @NotNull
    public final Observable<Unit> r;
    @NotNull
    public final View s;
    @NotNull
    public final AdapterPresenter t;
    @NotNull
    public final ItemBinder u;
    @NotNull
    public final AttributedTextFormatter v;

    public DeliveryRdsPointInfoViewImpl(@NotNull View view, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.s = view;
        this.t = adapterPresenter;
        this.u = itemBinder;
        this.v = attributedTextFormatter;
        View findViewById = view.findViewById(R.id.bottom_sheet_point_info);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.….bottom_sheet_point_info)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        this.a = viewGroup;
        View findViewById2 = view.findViewById(R.id.find_me_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.find_me_button)");
        this.b = (FloatingActionButton) findViewById2;
        View findViewById3 = view.findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.toolbar)");
        this.c = findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.info_container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "container.findViewById(R.id.info_container)");
        this.d = (ViewGroup) findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.error_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "container.findViewById(R.id.error_container)");
        ViewGroup viewGroup2 = (ViewGroup) findViewById5;
        this.e = viewGroup2;
        View findViewById6 = viewGroup2.findViewById(R.id.error_title);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "errorContainer.findViewById(R.id.error_title)");
        this.f = (TextView) findViewById6;
        BottomSheetBehavior<ViewGroup> from = BottomSheetBehavior.from(viewGroup);
        Intrinsics.checkNotNullExpressionValue(from, "BottomSheetBehavior.from(container)");
        this.g = from;
        View findViewById7 = viewGroup.findViewById(R.id.progress);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "container.findViewById(R.id.progress)");
        this.h = findViewById7;
        View findViewById8 = viewGroup.findViewById(R.id.recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "container.findViewById(R.id.recycler_view)");
        this.i = (RecyclerView) findViewById8;
        View findViewById9 = view.findViewById(R.id.submit_button_container);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById(R.….submit_button_container)");
        this.j = findViewById9;
        View findViewById10 = viewGroup2.findViewById(R.id.retry_button);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "errorContainer.findViewById(R.id.retry_button)");
        this.k = (Button) findViewById10;
        View findViewById11 = view.findViewById(R.id.overlay_container);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "rootView.findViewById(R.id.overlay_container)");
        this.l = findViewById11;
        View findViewById12 = findViewById11.findViewById(R.id.overlay_label);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "overlayContainer.findViewById(R.id.overlay_label)");
        this.m = (TextView) findViewById12;
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.o = create;
        View findViewById13 = view.findViewById(R.id.submit_button);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "rootView.findViewById<View>(R.id.submit_button)");
        this.p = RxView.clicks(findViewById13);
        this.r = create;
        RecyclerView recyclerView = this.i;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.setAdapter(new SimpleRecyclerAdapter(adapterPresenter, itemBinder));
        recyclerView.addItemDecoration(new PaddingListDecoration(recyclerView.getResources().getDimensionPixelSize(R.dimen.delivery_point_bottom_sheet_recyclerview_top_padding), recyclerView.getResources().getDimensionPixelSize(R.dimen.delivery_summary_recycler_view_bottom_padding), 0, 0, 12, null));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoViewImpl$initRecyclerView$1$1
            public final int a;

            {
                this.a = RecyclerView.this.getResources().getDimensionPixelOffset(R.dimen.delivery_point_bottom_sheet_recyclerview_children_vertical_padding);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect rect, @NotNull View view2, @NotNull RecyclerView recyclerView2, @NotNull RecyclerView.State state) {
                a.F0(rect, "outRect", view2, "view", recyclerView2, "parent", state, "state");
                int i2 = this.a;
                rect.set(0, i2, 0, i2);
            }
        });
        from.setHideable(true);
        from.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoViewImpl$initBottomSheet$1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(@NotNull View view2, float f2) {
                Intrinsics.checkNotNullParameter(view2, "bottomSheet");
                Float valueOf = Float.valueOf(f2);
                if (!(Float.compare(valueOf.floatValue(), Float.NaN) != 0)) {
                    valueOf = null;
                }
                float floatValue = valueOf != null ? valueOf.floatValue() : 0.0f;
                DeliveryRdsPointInfoViewImpl.access$moveSubmitButton(DeliveryRdsPointInfoViewImpl.this, floatValue);
                DeliveryRdsPointInfoViewImpl.access$moveOverlay(DeliveryRdsPointInfoViewImpl.this, floatValue);
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(@NotNull View view2, int i2) {
                Intrinsics.checkNotNullParameter(view2, "view");
                if (i2 == 5) {
                    DeliveryRdsPointInfoViewImpl.access$getFindMeButton$p(DeliveryRdsPointInfoViewImpl.this).show();
                    DeliveryRdsPointInfoViewImpl.access$getBottomSheetHideRelay$p(DeliveryRdsPointInfoViewImpl.this).accept(Unit.INSTANCE);
                    Views.hide(DeliveryRdsPointInfoViewImpl.access$getSubmitButtonContainer$p(DeliveryRdsPointInfoViewImpl.this));
                    DeliveryRdsPointInfoViewImpl.access$setPreviousState$p(DeliveryRdsPointInfoViewImpl.this, null);
                }
            }
        });
        from.setState(5);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        from.setPeekHeight(Contexts.getDisplayHeight(context) / 2);
    }

    public static final void access$moveOverlay(DeliveryRdsPointInfoViewImpl deliveryRdsPointInfoViewImpl, float f2) {
        if (deliveryRdsPointInfoViewImpl.l.getHeight() != 0) {
            float max = Math.max(-f2, 0.0f);
            deliveryRdsPointInfoViewImpl.l.setY(((float) deliveryRdsPointInfoViewImpl.c.getHeight()) * max);
            deliveryRdsPointInfoViewImpl.l.setAlpha(max);
        }
    }

    public static final void access$moveSubmitButton(DeliveryRdsPointInfoViewImpl deliveryRdsPointInfoViewImpl, float f2) {
        if (deliveryRdsPointInfoViewImpl.j.getHeight() != 0) {
            deliveryRdsPointInfoViewImpl.j.setY(((float) deliveryRdsPointInfoViewImpl.s.getHeight()) - ((((float) 1) + Math.min(f2, 0.0f)) * ((float) deliveryRdsPointInfoViewImpl.j.getHeight())));
        }
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        return this.t;
    }

    @NotNull
    public final AttributedTextFormatter getAttributedTextFormatter() {
        return this.v;
    }

    @Override // com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoView
    @NotNull
    public Observable<Unit> getBottomSheetHideObservable() {
        return this.r;
    }

    @Override // com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoView
    public int getBottomSheetPeekHeight() {
        return this.g.getPeekHeight();
    }

    @NotNull
    public final ItemBinder getItemBinder() {
        return this.u;
    }

    @Override // com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoView
    @NotNull
    public Observable<Unit> getRetryButtonClicks() {
        return this.q;
    }

    @NotNull
    public final View getRootView() {
        return this.s;
    }

    @Override // com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoView
    @NotNull
    public Observable<Unit> getSubmitButtonClicks() {
        return this.p;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00fe  */
    @Override // com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void render(@org.jetbrains.annotations.NotNull com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoView.State r10) {
        /*
        // Method dump skipped, instructions count: 347
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoViewImpl.render(com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoView$State):void");
    }
}
