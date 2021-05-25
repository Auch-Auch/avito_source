package com.avito.android.short_term_rent.start_booking;

import a2.a.a.v2.c.b;
import a2.a.a.v2.c.c;
import a2.a.a.v2.c.d;
import a2.g.r.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search_filter.GroupsBackgroundDecoration;
import com.avito.android.short_term_rent.R;
import com.avito.android.short_term_rent.start_booking.StrStartBookingView;
import com.avito.android.short_term_rent.utils.ShadowScrollListener;
import com.avito.android.ui.PaddingListDecoration;
import com.avito.android.util.Contexts;
import com.avito.android.util.RecyclerViewsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B5\u0012\u0006\u00104\u001a\u000201\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b5\u00106J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00070\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001e\u0010\u000f\u001a\n \b*\u0004\u0018\u00010\f0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010 \u001a\n \b*\u0004\u0018\u00010\u001d0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010$\u001a\n \b*\u0004\u0018\u00010!0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001e\u0010,\u001a\n \b*\u0004\u0018\u00010)0)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/avito/android/short_term_rent/start_booking/StrStartBookingViewImpl;", "Lcom/avito/android/short_term_rent/start_booking/StrStartBookingView;", "Lcom/avito/android/short_term_rent/start_booking/StrStartBookingViewModel;", "viewModel", "", "bindTo", "(Lcom/avito/android/short_term_rent/start_booking/StrStartBookingViewModel;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "e", "Landroid/widget/TextView;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Landroidx/appcompat/widget/Toolbar;", "c", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/avito/android/search_filter/GroupsBackgroundDecoration;", "f", "Lcom/avito/android/search_filter/GroupsBackgroundDecoration;", "groupsBackgroundDecoration", "", "k", "Z", "isPostPaid", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "h", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/lifecycle/LifecycleOwner;", "i", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroid/widget/FrameLayout;", AuthSource.BOOKING_ORDER, "Landroid/widget/FrameLayout;", "contentHolder", "Lcom/avito/android/short_term_rent/start_booking/StrStartBookingView$Listener;", "j", "Lcom/avito/android/short_term_rent/start_booking/StrStartBookingView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View;", g.a, "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/short_term_rent/start_booking/StrStartBookingView$Listener;Z)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrStartBookingViewImpl implements StrStartBookingView {
    public final Context a;
    public final FrameLayout b;
    public final Toolbar c;
    public final RecyclerView d;
    public final TextView e;
    public GroupsBackgroundDecoration f;
    public final View g;
    public final RecyclerView.Adapter<BaseViewHolder> h;
    public final LifecycleOwner i;
    public final StrStartBookingView.Listener j;
    public final boolean k;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ StrStartBookingViewModel a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(StrStartBookingViewModel strStartBookingViewModel) {
            super(0);
            this.a = strStartBookingViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.onNextButtonClicked();
            return Unit.INSTANCE;
        }
    }

    public StrStartBookingViewImpl(@NotNull View view, @NotNull RecyclerView.Adapter<BaseViewHolder> adapter, @NotNull LifecycleOwner lifecycleOwner, @NotNull StrStartBookingView.Listener listener, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.g = view;
        this.h = adapter;
        this.i = lifecycleOwner;
        this.j = listener;
        this.k = z;
        Context context = view.getContext();
        this.a = context;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content_holder);
        this.b = frameLayout;
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        this.c = toolbar;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        this.d = recyclerView;
        TextView textView = (TextView) view.findViewById(R.id.button);
        this.e = textView;
        if (z) {
            Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
            toolbar.setTitle(context.getString(R.string.start_booking_post_paid_toolbar_title));
            Intrinsics.checkNotNullExpressionValue(textView, PhonePageSourceKt.PHONE_SOURCE_BUTTON);
            textView.setText(context.getString(R.string.start_booking_post_paid_next_button_text));
        } else {
            Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
            toolbar.setTitle(context.getString(R.string.start_booking_toolbar_title));
            Intrinsics.checkNotNullExpressionValue(textView, PhonePageSourceKt.PHONE_SOURCE_BUTTON);
            textView.setText(context.getString(R.string.start_booking_next_button_text));
        }
        toolbar.setNavigationOnClickListener(new d(this));
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new PaddingListDecoration(0, view.getResources().getDimensionPixelSize(R.dimen.start_booking_fragment_list_bottom_padding), 0, 0, 12, null));
        Intrinsics.checkNotNullExpressionValue(frameLayout, "contentHolder");
        recyclerView.addOnScrollListener(new ShadowScrollListener(frameLayout));
    }

    public static final void access$setGroupsBounds(StrStartBookingViewImpl strStartBookingViewImpl, List list) {
        if (strStartBookingViewImpl.f == null) {
            View view = strStartBookingViewImpl.g;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            view.setBackgroundColor(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray4));
            Resources resources = strStartBookingViewImpl.g.getResources();
            int i2 = com.avito.android.ui_components.R.drawable.bg_publish_card;
            Context context2 = strStartBookingViewImpl.g.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
            Drawable drawable = resources.getDrawable(i2, context2.getTheme());
            if (drawable != null) {
                int dimensionPixelSize = strStartBookingViewImpl.g.getResources().getDimensionPixelSize(R.dimen.start_booking_groups_vertical_padding);
                int dimensionPixelSize2 = strStartBookingViewImpl.g.getResources().getDimensionPixelSize(com.avito.android.ui_components.R.dimen.component_horizontal_padding);
                Resources resources2 = strStartBookingViewImpl.g.getResources();
                int i3 = R.drawable.str_group_divider;
                Context context3 = strStartBookingViewImpl.g.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "view.context");
                Drawable drawable2 = resources2.getDrawable(i3, context3.getTheme());
                if (drawable2 != null) {
                    GroupsBackgroundDecoration groupsBackgroundDecoration = new GroupsBackgroundDecoration(drawable, drawable2, dimensionPixelSize, dimensionPixelSize2, null, 16, null);
                    strStartBookingViewImpl.f = groupsBackgroundDecoration;
                    strStartBookingViewImpl.d.addItemDecoration(groupsBackgroundDecoration);
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        GroupsBackgroundDecoration groupsBackgroundDecoration2 = strStartBookingViewImpl.f;
        if (groupsBackgroundDecoration2 != null) {
            groupsBackgroundDecoration2.setRanges(list);
        }
        RecyclerView recyclerView = strStartBookingViewImpl.d;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        RecyclerViewsKt.invalidateItemDecorationsSafely(recyclerView);
    }

    @Override // com.avito.android.short_term_rent.start_booking.StrStartBookingView
    public void bindTo(@NotNull StrStartBookingViewModel strStartBookingViewModel) {
        Intrinsics.checkNotNullParameter(strStartBookingViewModel, "viewModel");
        strStartBookingViewModel.getGroupsChanges().observe(this.i, new b(this));
        strStartBookingViewModel.getErrorMessageChanges().observe(this.i, new c(this));
        this.e.setOnClickListener(new a2.a.a.v2.c.a(new a(strStartBookingViewModel)));
    }
}
