package com.avito.android.publish.slots.market_price.item;

import android.content.res.ColorStateList;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.items.MarketPriceItem;
import com.avito.android.lib.design.list_item.ListItem;
import com.avito.android.publish.R;
import com.avito.android.publish.slots.market_price.item.MarketPriceView;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u001f\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00052\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001d\u0010\u0014R\u001e\u0010\"\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001e0#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001e\u0010(\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010!R\u001e\u0010,\u001a\n \u001f*\u0004\u0018\u00010)0)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001e\u00100\u001a\n \u001f*\u0004\u0018\u00010-0-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00102\u001a\n \u001f*\u0004\u0018\u00010-0-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010/¨\u00067"}, d2 = {"Lcom/avito/android/publish/slots/market_price/item/MarketPriceViewImpl;", "Lcom/avito/android/publish/slots/market_price/item/MarketPriceView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "formattedPrice", "", "setMarketPrice", "(Ljava/lang/CharSequence;)V", "text", "setMessage", "", "", "color", "setDealTypeTitle", "(Ljava/lang/String;I)V", "setDealTypeSubtitle", "(Ljava/lang/String;)V", "", "isVisible", "setMessageVisibility", "(Z)V", "Lcom/avito/android/items/MarketPriceItem$DealTypeImageName;", "imageName", "setDealTypeImage", "(Lcom/avito/android/items/MarketPriceItem$DealTypeImageName;)V", "", "emptyDealTypeData", "setEmptyDealTypeBlock", "(Ljava/util/List;)V", "setDealTypeVisibility", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "t", "Landroid/widget/TextView;", "message", "", "x", "Ljava/util/List;", "reusedShieldViews", "s", "marketPrice", "Lcom/avito/android/lib/design/list_item/ListItem;", "u", "Lcom/avito/android/lib/design/list_item/ListItem;", "dealType", "Landroid/view/ViewGroup;", VKApiConst.VERSION, "Landroid/view/ViewGroup;", "dealTypeBlock", "w", "emptyDealType", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class MarketPriceViewImpl extends BaseViewHolder implements MarketPriceView {
    public final TextView s;
    public final TextView t;
    public final ListItem u;
    public final ViewGroup v;
    public final ViewGroup w;
    public final List<TextView> x = new ArrayList();

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            MarketPriceItem.DealTypeImageName.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
            iArr[3] = 4;
            iArr[4] = 5;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarketPriceViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (TextView) view.findViewById(R.id.market_price);
        this.t = (TextView) view.findViewById(R.id.message);
        this.u = (ListItem) view.findViewById(R.id.deal_type);
        this.v = (ViewGroup) view.findViewById(R.id.deal_type_block);
        this.w = (ViewGroup) view.findViewById(R.id.empty_deal_type);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        MarketPriceView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.publish.slots.market_price.item.MarketPriceView
    public void setDealTypeImage(@Nullable MarketPriceItem.DealTypeImageName dealTypeImageName) {
        if (dealTypeImageName == null) {
            ListItem.setImageResource$default(this.u, 0, 0, 3, null);
            return;
        }
        int ordinal = dealTypeImageName.ordinal();
        if (ordinal == 0) {
            ListItem.setImageResource$default(this.u, 0, R.drawable.ic_imv_perfect, 1, null);
        } else if (ordinal == 1) {
            ListItem.setImageResource$default(this.u, 0, R.drawable.ic_imv_verygood, 1, null);
        } else if (ordinal == 2) {
            ListItem.setImageResource$default(this.u, 0, R.drawable.ic_imv_good, 1, null);
        } else if (ordinal == 3) {
            ListItem.setImageResource$default(this.u, 0, R.drawable.ic_imv_bad, 1, null);
        } else if (ordinal == 4) {
            ListItem.setImageResource$default(this.u, 0, R.drawable.ic_imv_verybad, 1, null);
        }
    }

    @Override // com.avito.android.publish.slots.market_price.item.MarketPriceView
    public void setDealTypeSubtitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.u.setSubtitle(str);
    }

    @Override // com.avito.android.publish.slots.market_price.item.MarketPriceView
    public void setDealTypeTitle(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.u.setTitle(str);
        ListItem listItem = this.u;
        ColorStateList valueOf = ColorStateList.valueOf(i);
        Intrinsics.checkNotNullExpressionValue(valueOf, "ColorStateList.valueOf(color)");
        listItem.setTitleColor(valueOf);
    }

    @Override // com.avito.android.publish.slots.market_price.item.MarketPriceView
    public void setDealTypeVisibility(boolean z) {
        Views.setVisible(this.v, z);
    }

    @Override // com.avito.android.publish.slots.market_price.item.MarketPriceView
    public void setEmptyDealTypeBlock(@Nullable List<String> list) {
        this.w.removeAllViews();
        int i = 0;
        if (list == null || list.isEmpty()) {
            Views.setVisible(this.w, false);
            return;
        }
        if (list.size() > this.x.size()) {
            ViewGroup viewGroup = this.w;
            Intrinsics.checkNotNullExpressionValue(viewGroup, "emptyDealType");
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            int size = list.size() - this.x.size();
            for (int i2 = 0; i2 < size; i2++) {
                View inflate = from.inflate(R.layout.publish_slot_market_price_gray_shield, this.w, false);
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
                this.x.add((TextView) inflate);
            }
        }
        for (T t2 : list) {
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            TextView textView = this.x.get(i);
            textView.setText(t2);
            this.w.addView(textView);
            i = i3;
        }
        Views.setVisible(this.w, true);
    }

    @Override // com.avito.android.publish.slots.market_price.item.MarketPriceView
    public void setMarketPrice(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "formattedPrice");
        TextView textView = this.s;
        Intrinsics.checkNotNullExpressionValue(textView, "marketPrice");
        textView.setText(charSequence);
    }

    @Override // com.avito.android.publish.slots.market_price.item.MarketPriceView
    public void setMessage(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        TextView textView = this.t;
        Intrinsics.checkNotNullExpressionValue(textView, "message");
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView2 = this.t;
        Intrinsics.checkNotNullExpressionValue(textView2, "message");
        textView2.setText(charSequence);
    }

    @Override // com.avito.android.publish.slots.market_price.item.MarketPriceView
    public void setMessageVisibility(boolean z) {
        Views.setVisible(this.t, z);
    }
}
