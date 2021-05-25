package com.avito.android.str_calendar.seller.calendar;

import a2.a.a.b3.c.a.i;
import a2.a.a.b3.c.a.j;
import a2.a.a.b3.c.a.k;
import a2.a.a.b3.c.a.l;
import a2.a.a.b3.c.a.m;
import a2.a.a.b3.c.a.n;
import a2.a.a.b3.c.a.o;
import a2.g.r.g;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.str_calendar.R;
import com.avito.android.str_calendar.calendar.base.BaseCalendarView;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxbinding3.view.RxView;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u0010:\u001a\u000209\u0012\u0006\u00104\u001a\u000201¢\u0006\u0004\b;\u0010<J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0017R\"\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050#8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010\u0017R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010\u0017R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u0006="}, d2 = {"Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarViewImpl;", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarView;", "Lcom/avito/android/str_calendar/calendar/base/BaseCalendarView;", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarViewModel;", "viewModel", "", "bindTo", "(Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarViewModel;)V", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getCalendarItemDecoration", "(Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;)Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "titleTextView", "Lcom/avito/android/progress_overlay/ProgressOverlay;", AuthSource.SEND_ABUSE, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "clearButton", "f", "editParamsButtonContainer", "e", "editMainParamsButton", "Landroidx/lifecycle/LifecycleOwner;", "k", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "c", "closeButton", "Lio/reactivex/Observable;", "i", "Lio/reactivex/Observable;", "getCloseClicks", "()Lio/reactivex/Observable;", "closeClicks", g.a, "editParamsButton", "Landroid/view/ViewGroup;", "j", "Landroid/view/ViewGroup;", "view", "d", "editMainParamsButtonContainer", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarResourceProvider;", "l", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarResourceProvider;", "resourceProvider", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "<init>", "(Landroid/view/ViewGroup;Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/analytics/Analytics;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarResourceProvider;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerCalendarViewImpl extends BaseCalendarView implements SellerCalendarView {
    public final ProgressOverlay a;
    public final View b;
    public final View c;
    public final View d;
    public final View e;
    public final View f;
    public final View g;
    public final TextView h;
    @NotNull
    public final Observable<Unit> i;
    public final ViewGroup j;
    public final LifecycleOwner k;
    public final SellerCalendarResourceProvider l;

    public SellerCalendarViewImpl(@NotNull ViewGroup viewGroup, @NotNull LifecycleOwner lifecycleOwner, @NotNull Analytics analytics, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder, @NotNull SellerCalendarResourceProvider sellerCalendarResourceProvider) {
        Intrinsics.checkNotNullParameter(viewGroup, "view");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(sellerCalendarResourceProvider, "resourceProvider");
        this.j = viewGroup;
        this.k = lifecycleOwner;
        this.l = sellerCalendarResourceProvider;
        View findViewById = viewGroup.findViewById(R.id.content_holder);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.content_holder)");
        this.a = new ProgressOverlay((ViewGroup) findViewById, 0, analytics, false, 0, 26, null);
        View findViewById2 = viewGroup.findViewById(R.id.clear_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.clear_button)");
        this.b = findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.close_button);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.close_button)");
        this.c = findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.edit_main_params_button_container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.e…_params_button_container)");
        this.d = findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.edit_main_params_button);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.edit_main_params_button)");
        this.e = findViewById5;
        View findViewById6 = viewGroup.findViewById(R.id.edit_params_button_container);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.e…_params_button_container)");
        this.f = findViewById6;
        View findViewById7 = viewGroup.findViewById(R.id.edit_params_button);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.edit_params_button)");
        this.g = findViewById7;
        this.h = (TextView) viewGroup.findViewById(R.id.title_text_view);
        this.i = RxView.clicks(findViewById3);
        setCalendarUpRecyclerView(viewGroup, adapterPresenter, itemBinder);
    }

    public static final void access$setTitle(SellerCalendarViewImpl sellerCalendarViewImpl, String str) {
        TextView textView = sellerCalendarViewImpl.h;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.avito.android.str_calendar.seller.calendar.SellerCalendarView
    public void bindTo(@NotNull SellerCalendarViewModel sellerCalendarViewModel) {
        Intrinsics.checkNotNullParameter(sellerCalendarViewModel, "viewModel");
        sellerCalendarViewModel.getUpdateViewChanges().observe(this.k, new o(this));
        sellerCalendarViewModel.getShowContentChanges().observe(this.k, new m(this));
        sellerCalendarViewModel.getProgressChanges().observe(this.k, new k(this));
        sellerCalendarViewModel.getErrorChanges().observe(this.k, new i(this));
        sellerCalendarViewModel.getErrorMessageChanges().observe(this.k, new j(this));
        sellerCalendarViewModel.getShowClearButtonChanges().observe(this.k, new l(this));
        sellerCalendarViewModel.getToolbarTitleChanges().observe(this.k, new n(this));
        sellerCalendarViewModel.getShowEditParamsButton().observe(this.k, new a2.a.a.b3.c.a.g(this));
        Consumer<Unit> clearClicksConsumer = sellerCalendarViewModel.getClearClicksConsumer();
        Consumer<Unit> editClicksConsumer = sellerCalendarViewModel.getEditClicksConsumer();
        this.b.setOnClickListener(new j0(0, clearClicksConsumer));
        this.e.setOnClickListener(new j0(1, editClicksConsumer));
        this.g.setOnClickListener(new j0(2, editClicksConsumer));
    }

    @Override // com.avito.android.str_calendar.calendar.base.BaseCalendarView
    @NotNull
    public RecyclerView.ItemDecoration getCalendarItemDecoration(@NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        Intrinsics.checkNotNullParameter(spanSizeLookup, "spanSizeLookup");
        Context context = getRecyclerView().getContext();
        a aVar = new Function2<Integer, Integer, Integer>(spanSizeLookup) { // from class: com.avito.android.str_calendar.seller.calendar.SellerCalendarViewImpl.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function2
            public Integer invoke(Integer num, Integer num2) {
                return Integer.valueOf(((GridLayoutManager.SpanSizeLookup) this.receiver).getSpanIndex(num.intValue(), num2.intValue()));
            }
        };
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new SellerCalendarRecyclerViewDecoration(7, aVar, context.getResources().getDimensionPixelSize(R.dimen.calendar_recycler_view_horizontal_padding), context.getResources().getDimensionPixelSize(R.dimen.calendar_recycler_view_day_horizontal_padding), context.getResources().getDimensionPixelSize(R.dimen.calendar_recycler_view_day_vertical_margin));
    }

    @Override // com.avito.android.str_calendar.seller.calendar.SellerCalendarView
    @NotNull
    public Observable<Unit> getCloseClicks() {
        return this.i;
    }
}
