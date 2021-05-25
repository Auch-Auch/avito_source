package com.avito.android.vas_discount.ui.items.description;

import android.view.View;
import android.widget.TextView;
import com.avito.android.component.timer.CountDownTimerWidget;
import com.avito.android.util.Views;
import com.avito.android.vas_discount.R;
import com.avito.android.vas_discount.ui.items.description.DescriptionItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/avito/android/vas_discount/ui/items/description/DescriptionItemViewImpl;", "Lcom/avito/android/vas_discount/ui/items/description/DescriptionItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "description", "setDescription", "", "finishDate", "showDiscountTimer", "(J)V", "hideDiscountTimer", "()V", "Lcom/avito/android/component/timer/CountDownTimerWidget;", "u", "Lcom/avito/android/component/timer/CountDownTimerWidget;", "timerView", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "titleView", "t", "descriptionView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "vas-discount_release"}, k = 1, mv = {1, 4, 2})
public final class DescriptionItemViewImpl extends BaseViewHolder implements DescriptionItemView {
    public final TextView s;
    public final TextView t;
    public final CountDownTimerWidget u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DescriptionItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title)");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.description);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.description)");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.timer_widget);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.timer_widget)");
        this.u = (CountDownTimerWidget) findViewById3;
    }

    @Override // com.avito.android.vas_discount.ui.items.description.DescriptionItemView
    public void hideDiscountTimer() {
        Views.hide(this.u);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        DescriptionItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.vas_discount.ui.items.description.DescriptionItemView
    public void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        this.t.setText(str);
    }

    @Override // com.avito.android.vas_discount.ui.items.description.DescriptionItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setText(str);
    }

    @Override // com.avito.android.vas_discount.ui.items.description.DescriptionItemView
    public void showDiscountTimer(long j) {
        Views.show(this.u);
        this.u.setFinishDate(j);
    }
}
