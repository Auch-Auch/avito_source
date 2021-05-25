package com.avito.android.advert.item.price_discount;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.advert_core.discount.AdvertDiscountDetailsDialog;
import com.avito.android.advert_details.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u001d\u0010\u000f\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u000bJ\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u000bJ\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u000bR\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010#¨\u0006."}, d2 = {"Lcom/avito/android/advert/item/price_discount/PriceWithDiscountViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/price_discount/PriceWithDiscountView;", "", "price", "", "showPrice", "(Ljava/lang/String;)V", "priceWithoutDiscount", "showPriceWithoutDiscount", "hidePriceWithoutDiscount", "()V", "applyClosedAdvert", "Lkotlin/Function0;", "onClick", "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "removeOnClickListener", "showRightIcon", "hideRightIcon", "Lcom/avito/android/advert_core/discount/AdvertDiscountDetailsDialog;", "dialog", "showDialog", "(Lcom/avito/android/advert_core/discount/AdvertDiscountDetailsDialog;)V", "onUnbind", "Landroid/view/ViewGroup;", "s", "Landroid/view/ViewGroup;", "priceViewContainer", "Landroid/content/res/ColorStateList;", VKApiConst.VERSION, "Landroid/content/res/ColorStateList;", "colorGray48", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "priceViewWithoutDiscount", "w", "Lcom/avito/android/advert_core/discount/AdvertDiscountDetailsDialog;", "shownDialog", "t", "priceView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class PriceWithDiscountViewImpl extends BaseViewHolder implements PriceWithDiscountView {
    public final ViewGroup s;
    public final TextView t;
    public final TextView u;
    public final ColorStateList v;
    public AdvertDiscountDetailsDialog w;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PriceWithDiscountViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.item_price_with_discount);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.item_price_with_discount)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        this.s = viewGroup;
        View findViewById2 = viewGroup.findViewById(R.id.price);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "priceViewContainer.findViewById(R.id.price)");
        this.t = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.price_without_discount);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "priceViewContainer.findV…d.price_without_discount)");
        this.u = (TextView) findViewById3;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.v = Contexts.getColorStateListByAttr(context, com.avito.android.lib.design.R.attr.gray48);
    }

    @Override // com.avito.android.advert.item.price_discount.PriceWithDiscountView
    public void applyClosedAdvert() {
        this.t.setTextColor(this.v);
    }

    @Override // com.avito.android.advert.item.price_discount.PriceWithDiscountView
    public void hidePriceWithoutDiscount() {
        Views.hide(this.u);
    }

    @Override // com.avito.android.advert.item.price_discount.PriceWithDiscountView
    public void hideRightIcon() {
        this.t.setCompoundDrawables(null, null, null, null);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        super.onUnbind();
        AdvertDiscountDetailsDialog advertDiscountDetailsDialog = this.w;
        if (advertDiscountDetailsDialog != null) {
            advertDiscountDetailsDialog.dismiss();
        }
        this.w = null;
    }

    @Override // com.avito.android.advert.item.price_discount.PriceWithDiscountView
    public void removeOnClickListener() {
        ViewGroup viewGroup = this.s;
        viewGroup.setOnClickListener(null);
        viewGroup.setClickable(false);
        viewGroup.setFocusable(false);
    }

    @Override // com.avito.android.advert.item.price_discount.PriceWithDiscountView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onClick");
        ViewGroup viewGroup = this.s;
        viewGroup.setOnClickListener(new a(function0));
        viewGroup.setClickable(true);
        viewGroup.setFocusable(true);
    }

    @Override // com.avito.android.advert.item.price_discount.PriceWithDiscountView
    public void showDialog(@NotNull AdvertDiscountDetailsDialog advertDiscountDetailsDialog) {
        Intrinsics.checkNotNullParameter(advertDiscountDetailsDialog, "dialog");
        AdvertDiscountDetailsDialog advertDiscountDetailsDialog2 = this.w;
        if (advertDiscountDetailsDialog2 != null) {
            advertDiscountDetailsDialog2.dismiss();
        }
        this.w = advertDiscountDetailsDialog;
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        advertDiscountDetailsDialog.show(context);
    }

    @Override // com.avito.android.advert.item.price_discount.PriceWithDiscountView
    public void showPrice(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "price");
        TextViews.bindText$default(this.t, str, false, 2, null);
    }

    @Override // com.avito.android.advert.item.price_discount.PriceWithDiscountView
    public void showPriceWithoutDiscount(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "priceWithoutDiscount");
        TextViews.bindText$default(this.u, str, false, 2, null);
    }

    @Override // com.avito.android.advert.item.price_discount.PriceWithDiscountView
    public void showRightIcon() {
        TextViews.setCompoundDrawables$default(this.t, 0, 0, com.avito.android.advert_core.R.drawable.ic_info, 0, 11, (Object) null);
    }
}
