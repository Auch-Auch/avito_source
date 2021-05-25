package com.avito.android.bundles.ui.recycler.item.benefit;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.avito.android.bundles.R;
import com.avito.android.bundles.ui.recycler.item.benefit.BenefitItemView;
import com.avito.android.lib.design.notification_badge.NotificationBadgeFuncionsKt;
import com.avito.android.remote.model.BenefitColoredIcon;
import com.avito.android.remote.model.BenefitIconName;
import com.avito.android.remote.model.BundleBadge;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.android.util.color.ContextsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010 \u001a\u00020\u0018¢\u0006\u0004\b!\u0010\"J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/avito/android/bundles/ui/recycler/item/benefit/BenefitItemViewImpl;", "Lcom/avito/android/bundles/ui/recycler/item/benefit/BenefitItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/remote/model/BenefitColoredIcon;", "benefitColoredIcon", "", "setIcon", "(Lcom/avito/android/remote/model/BenefitColoredIcon;)V", "", "text", "Lcom/avito/android/remote/model/BundleBadge;", "badge", "setText", "(Ljava/lang/String;Lcom/avito/android/remote/model/BundleBadge;)V", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "removeOnClickListener", "()V", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "u", "Landroid/view/View;", "iconArrow", "Landroid/widget/ImageView;", "s", "Landroid/widget/ImageView;", "iconView", "view", "<init>", "(Landroid/view/View;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class BenefitItemViewImpl extends BaseViewHolder implements BenefitItemView {
    public final ImageView s;
    public final TextView t;
    public final View u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BenefitItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.icon);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
        this.s = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.text);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.icon_arrow);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.u = findViewById3;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        BenefitItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.bundles.ui.recycler.item.benefit.BenefitItemView
    public void removeOnClickListener() {
        this.itemView.setOnClickListener(null);
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        view.setClickable(false);
        View view2 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "itemView");
        view2.setFocusable(false);
        Views.conceal(this.u);
    }

    @Override // com.avito.android.bundles.ui.recycler.item.benefit.BenefitItemView
    public void setIcon(@Nullable BenefitColoredIcon benefitColoredIcon) {
        BenefitIconName icon = benefitColoredIcon != null ? benefitColoredIcon.getIcon() : null;
        if (benefitColoredIcon == null || icon == null) {
            Views.hide(this.s);
            return;
        }
        Views.show(this.s);
        this.s.setImageResource(icon.getIconResId());
        ImageView imageView = this.s;
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        imageView.setColorFilter(ContextsKt.getColorFrom(context, benefitColoredIcon.getColor()));
    }

    @Override // com.avito.android.bundles.ui.recycler.item.benefit.BenefitItemView
    public void setOnClickListener(@NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        view.setClickable(true);
        View view2 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "itemView");
        view2.setFocusable(true);
        this.itemView.setOnClickListener(onClickListener);
        Views.show(this.u);
    }

    @Override // com.avito.android.bundles.ui.recycler.item.benefit.BenefitItemView
    public void setText(@NotNull String str, @Nullable BundleBadge bundleBadge) {
        Intrinsics.checkNotNullParameter(str, "text");
        if (bundleBadge != null) {
            NotificationBadgeFuncionsKt.withNotificationBadge(this.t, str, bundleBadge.getTitle(), com.avito.android.lib.design.avito.R.style.Avito_NotificationBadge_TextLarge);
        } else {
            TextViews.bindText$default(this.t, str, false, 2, null);
        }
    }
}
