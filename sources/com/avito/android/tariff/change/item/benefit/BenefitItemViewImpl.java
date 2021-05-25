package com.avito.android.tariff.change.item.benefit;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.avito.android.tariff.R;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0014\u001a\n \r*\u0004\u0018\u00010\u00110\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/avito/android/tariff/change/item/benefit/BenefitItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/tariff/change/item/benefit/BenefitItemView;", "", "text", "", "setText", "(Ljava/lang/String;)V", "Lcom/avito/android/tariff/change/item/benefit/BenefitIcon;", "benefitIcon", "setIcon", "(Lcom/avito/android/tariff/change/item/benefit/BenefitIcon;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "s", "Landroid/widget/TextView;", "textBenefit", "Landroid/widget/ImageView;", "t", "Landroid/widget/ImageView;", "icon", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class BenefitItemViewImpl extends BaseViewHolder implements BenefitItemView {
    public final TextView s;
    public final ImageView t;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            BenefitIcon.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BenefitItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (TextView) view.findViewById(R.id.benefit_text);
        this.t = (ImageView) view.findViewById(R.id.icon);
    }

    @Override // com.avito.android.tariff.change.item.benefit.BenefitItemView
    public void setIcon(@NotNull BenefitIcon benefitIcon) {
        Intrinsics.checkNotNullParameter(benefitIcon, "benefitIcon");
        int ordinal = benefitIcon.ordinal();
        if (ordinal == 0) {
            Views.hide(this.t);
        } else if (ordinal == 1) {
            Views.show(this.t);
            this.t.setImageResource(com.avito.android.ui_components.R.drawable.ic_checkmark_16);
        } else if (ordinal == 2) {
            Views.show(this.t);
            this.t.setImageResource(com.avito.android.ui_components.R.drawable.ic_add_16);
        }
    }

    @Override // com.avito.android.tariff.change.item.benefit.BenefitItemView
    public void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextView textView = this.s;
        Intrinsics.checkNotNullExpressionValue(textView, "textBenefit");
        textView.setText(str);
    }
}
