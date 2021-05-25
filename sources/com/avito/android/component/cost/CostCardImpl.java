package com.avito.android.component.cost;

import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.text.Text;
import ru.avito.component.text.TextImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/avito/android/component/cost/CostCardImpl;", "Lcom/avito/android/component/cost/CostCard;", "", "title", "", "setTitle", "(Ljava/lang/CharSequence;)V", "value", "setValue", "Lru/avito/component/text/Text;", AuthSource.BOOKING_ORDER, "Lru/avito/component/text/Text;", "valueView", AuthSource.SEND_ABUSE, "titleView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class CostCardImpl implements CostCard {
    public final Text a;
    public final Text b;

    public CostCardImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = new TextImpl(Views.findById(view, R.id.cost_card_title));
        this.b = new TextImpl(Views.findById(view, R.id.cost_card_value));
    }

    @Override // com.avito.android.component.cost.CostCard
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.a.setText(charSequence);
    }

    @Override // com.avito.android.component.cost.CostCard
    public void setValue(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "value");
        this.b.setText(charSequence);
    }
}
