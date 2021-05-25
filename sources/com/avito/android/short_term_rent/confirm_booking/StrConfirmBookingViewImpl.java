package com.avito.android.short_term_rent.confirm_booking;

import a2.a.a.v2.a.e;
import a2.a.a.v2.a.f;
import a2.a.a.v2.a.h;
import a2.a.a.v2.a.i;
import a2.a.a.v2.a.j;
import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.short_term_rent.R;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingView;
import com.avito.android.short_term_rent.utils.ShadowScrollListener;
import com.avito.android.ui.TopPaddingListDecoration;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010$\u001a\u00020!\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b?\u0010@J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001e\u0010\u0014\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0018\u001a\n \u0011*\u0004\u0018\u00010\u00150\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010 \u001a\n \u0011*\u0004\u0018\u00010\u001d0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001e\u00100\u001a\n \u0011*\u0004\u0018\u00010-0-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006A"}, d2 = {"Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingViewImpl;", "Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingView;", "Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingViewModel;", "viewModel", "", "bindTo", "(Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingViewModel;)V", "", AuthSource.OPEN_CHANNEL_LIST, "Z", "isPostPaid", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "j", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "Landroid/widget/FrameLayout;", "contentHolder", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "h", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "dividerItemDecorator", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Landroid/view/View;", "i", "Landroid/view/View;", "view", "Landroidx/lifecycle/LifecycleOwner;", "k", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroid/graphics/drawable/Drawable;", "f", "Landroid/graphics/drawable/Drawable;", "dividerDrawable", "Landroidx/appcompat/widget/Toolbar;", "c", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "", g.a, "I", "dividerPadding", "Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingView$Listener;", "l", "Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "e", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingView$Listener;Z)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrConfirmBookingViewImpl implements StrConfirmBookingView {
    public final Context a;
    public final FrameLayout b;
    public final Toolbar c;
    public final RecyclerView d;
    public final ProgressOverlay e;
    public final Drawable f;
    public final int g;
    public RecyclerView.ItemDecoration h;
    public final View i;
    public final RecyclerView.Adapter<BaseViewHolder> j;
    public final LifecycleOwner k;
    public final StrConfirmBookingView.Listener l;
    public final boolean m;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ StrConfirmBookingViewModel a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(StrConfirmBookingViewModel strConfirmBookingViewModel) {
            super(0);
            this.a = strConfirmBookingViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getBookingCalculationReview();
            return Unit.INSTANCE;
        }
    }

    public StrConfirmBookingViewImpl(@NotNull Analytics analytics, @NotNull View view, @NotNull RecyclerView.Adapter<BaseViewHolder> adapter, @NotNull LifecycleOwner lifecycleOwner, @NotNull StrConfirmBookingView.Listener listener, boolean z) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.i = view;
        this.j = adapter;
        this.k = lifecycleOwner;
        this.l = listener;
        this.m = z;
        Context context = view.getContext();
        this.a = context;
        int i2 = R.id.content_holder;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(i2);
        this.b = frameLayout;
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        this.c = toolbar;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        this.d = recyclerView;
        View findViewById = view.findViewById(i2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.content_holder)");
        this.e = new ProgressOverlay((ViewGroup) findViewById, 0, analytics, false, 0, 26, null);
        this.f = context.getDrawable(R.drawable.str_recycler_view_divider);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.g = context.getResources().getDimensionPixelOffset(com.avito.android.ui_components.R.dimen.publish_card_padding_horizontal);
        if (z) {
            Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
            toolbar.setTitle(context.getString(R.string.confirm_booking_post_paid_toolbar_title));
        } else {
            Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
            toolbar.setTitle(context.getString(R.string.confirm_booking_toolbar_title));
        }
        toolbar.setNavigationOnClickListener(new j(this));
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new TopPaddingListDecoration(view.getResources().getDimensionPixelSize(R.dimen.confirm_booking_list_top_padding)));
        Intrinsics.checkNotNullExpressionValue(frameLayout, "contentHolder");
        recyclerView.addOnScrollListener(new ShadowScrollListener(frameLayout));
    }

    @Override // com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingView
    public void bindTo(@NotNull StrConfirmBookingViewModel strConfirmBookingViewModel) {
        Intrinsics.checkNotNullParameter(strConfirmBookingViewModel, "viewModel");
        strConfirmBookingViewModel.getShowContentChanges().observe(this.k, new i(this));
        strConfirmBookingViewModel.getDividersChanges().observe(this.k, new a2.a.a.v2.a.g(this));
        strConfirmBookingViewModel.getProgressChanges().observe(this.k, new h(this));
        strConfirmBookingViewModel.getErrorMessageChanges().observe(this.k, new f(this));
        strConfirmBookingViewModel.getErrorChanges().observe(this.k, new e(this));
        this.e.setOnRefreshListener(new a(strConfirmBookingViewModel));
    }
}
