package com.avito.android.str_calendar.calendar.view.konveyor.items.day.seller;

import a2.a.a.b3.b.a.a.a.a.b.a;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import com.avito.android.remote.model.Sort;
import com.avito.android.str_calendar.R;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.seller.SellerDayItemView;
import com.avito.android.str_calendar.seller.calendar.data.SellerDayItemState;
import com.avito.android.str_calendar.seller.calendar.data.Status;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010)\u001a\u00020\u0018\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b*\u0010+J5\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0017\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001e\u0010\u001b\u001a\n \u0014*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001d\u001a\n \u0014*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010%\u001a\n \u0014*\u0004\u0018\u00010\"0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001e\u0010&\u001a\n \u0014*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001aR\u001e\u0010(\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010\u0016¨\u0006,"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemViewImpl;", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "text", "Lcom/avito/android/str_calendar/seller/calendar/data/SellerDayItemState;", "state", "Lio/reactivex/functions/Consumer;", "Ljava/util/Date;", "clickConsumer", Sort.DATE, "", "bind", "(Ljava/lang/String;Lcom/avito/android/str_calendar/seller/calendar/data/SellerDayItemState;Lio/reactivex/functions/Consumer;Ljava/util/Date;)V", "", "dayColor", "priceColor", "t", "(ILjava/lang/Integer;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", VKApiConst.VERSION, "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "x", "Landroid/view/View;", "dotView", "u", "secondaryBackgroundView", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemBackgroundsProvider;", "y", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemBackgroundsProvider;", "backgroundsProvider", "Landroid/content/Context;", "s", "Landroid/content/Context;", "context", "primaryBackgroundView", "w", "priceTextView", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemBackgroundsProvider;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerDayItemViewImpl extends BaseViewHolder implements SellerDayItemView {
    public final Context s;
    public final View t;
    public final View u;
    public final TextView v;
    public final TextView w;
    public final View x;
    public final SellerDayItemBackgroundsProvider y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SellerDayItemViewImpl(@NotNull View view, @NotNull SellerDayItemBackgroundsProvider sellerDayItemBackgroundsProvider) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(sellerDayItemBackgroundsProvider, "backgroundsProvider");
        this.y = sellerDayItemBackgroundsProvider;
        this.s = view.getContext();
        this.t = view.findViewById(R.id.background_view);
        this.u = view.findViewById(R.id.secondary_background_view);
        this.v = (TextView) view.findViewById(R.id.text_view);
        this.w = (TextView) view.findViewById(R.id.price_text_view);
        this.x = view.findViewById(R.id.dot);
    }

    @Override // com.avito.android.str_calendar.calendar.view.konveyor.items.day.seller.SellerDayItemView
    public void bind(@NotNull String str, @NotNull SellerDayItemState sellerDayItemState, @NotNull Consumer<Date> consumer, @NotNull Date date) {
        int i;
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(sellerDayItemState, "state");
        Intrinsics.checkNotNullParameter(consumer, "clickConsumer");
        Intrinsics.checkNotNullParameter(date, Sort.DATE);
        String nightPrice = sellerDayItemState.getNightPrice();
        TextView textView = this.v;
        Intrinsics.checkNotNullExpressionValue(textView, "textView");
        boolean z = false;
        TextViews.bindText$default(textView, str, false, 2, null);
        TextView textView2 = this.w;
        Intrinsics.checkNotNullExpressionValue(textView2, "priceTextView");
        TextViews.bindText$default(textView2, nightPrice, false, 2, null);
        if (sellerDayItemState.getSelected()) {
            int i2 = com.avito.android.lib.design.R.attr.white;
            t(i2, Integer.valueOf(i2));
        } else if (sellerDayItemState.getPrimaryStatus() == Status.PAST) {
            t(com.avito.android.lib.design.R.attr.gray28, null);
        } else if (sellerDayItemState.getHasEditedParameters()) {
            int i3 = com.avito.android.lib.design.R.attr.black;
            t(i3, Integer.valueOf(i3));
        } else {
            t(com.avito.android.lib.design.R.attr.black, Integer.valueOf(com.avito.android.lib.design.R.attr.gray48));
        }
        Background background = this.y.getBackground(sellerDayItemState.getPrimaryStatus(), sellerDayItemState.getSecondaryStatus(), sellerDayItemState.getPrimaryPosition(), sellerDayItemState.getSecondaryPosition());
        if (background.getPrimaryBackgroundRes() != null) {
            View view = this.t;
            Intrinsics.checkNotNullExpressionValue(view, "primaryBackgroundView");
            Views.setBackgroundCompat(view, background.getPrimaryBackgroundRes().intValue());
        } else {
            View view2 = this.t;
            Intrinsics.checkNotNullExpressionValue(view2, "primaryBackgroundView");
            Views.setBackgroundCompat(view2, (Drawable) null);
        }
        if (background.getSecondaryBackgroundRes() != null) {
            View view3 = this.u;
            Intrinsics.checkNotNullExpressionValue(view3, "secondaryBackgroundView");
            Views.setBackgroundCompat(view3, background.getSecondaryBackgroundRes().intValue());
        } else {
            View view4 = this.u;
            Intrinsics.checkNotNullExpressionValue(view4, "secondaryBackgroundView");
            Views.setBackgroundCompat(view4, (Drawable) null);
        }
        boolean z2 = sellerDayItemState.getHasEditedParameters() && sellerDayItemState.getPrimaryStatus() != Status.PAST;
        if (sellerDayItemState.getSelected() || sellerDayItemState.getPrimaryStatus() == Status.SELECTED) {
            z = true;
        }
        if (z2) {
            Views.show(this.x);
            View view5 = this.x;
            Intrinsics.checkNotNullExpressionValue(view5, "dotView");
            if (z) {
                i = R.drawable.str_calendar_seller_day_dot_selected_background;
            } else {
                i = R.drawable.str_calendar_seller_day_dot_background;
            }
            Views.setBackgroundCompat(view5, i);
        } else {
            Views.hide(this.x);
        }
        if (sellerDayItemState.getPrimaryStatus() == Status.PAST) {
            this.u.setOnClickListener(null);
        } else {
            this.u.setOnClickListener(new a(consumer, date));
        }
        View view6 = this.t;
        Intrinsics.checkNotNullExpressionValue(view6, "primaryBackgroundView");
        view6.setTag(sellerDayItemState.getPrimaryPosition());
        View view7 = this.u;
        Intrinsics.checkNotNullExpressionValue(view7, "secondaryBackgroundView");
        view7.setTag(sellerDayItemState.getSecondaryPosition());
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        SellerDayItemView.DefaultImpls.onUnbind(this);
    }

    public final void t(@AttrRes int i, @AttrRes Integer num) {
        TextView textView = this.v;
        Context context = this.s;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setTextColor(Contexts.getColorByAttr(context, i));
        if (num != null) {
            int intValue = num.intValue();
            TextView textView2 = this.w;
            Context context2 = this.s;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            textView2.setTextColor(Contexts.getColorByAttr(context2, intValue));
        }
    }
}
