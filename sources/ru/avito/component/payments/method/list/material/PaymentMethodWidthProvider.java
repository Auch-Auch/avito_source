package ru.avito.component.payments.method.list.material;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lru/avito/component/payments/method/list/material/PaymentMethodWidthProvider;", "", "", "provideMethodWidth", "()I", "Landroid/app/Activity;", AuthSource.SEND_ABUSE, "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentMethodWidthProvider {
    public final Activity a;

    public PaymentMethodWidthProvider(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a = activity;
    }

    public final int provideMethodWidth() {
        View findViewById = this.a.findViewById(R.id.content_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "activity.findViewById<Li…i_R.id.content_container)");
        int width = ((LinearLayout) findViewById).getWidth();
        int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.payment_method_list_button_bar_padding);
        int dimensionPixelSize2 = this.a.getResources().getDimensionPixelSize(R.dimen.payment_method_list_space_between_blocks_size);
        return (int) ((((float) 4) * (((float) ((width - (dimensionPixelSize * 2)) - (dimensionPixelSize2 * 6))) / 7.0f)) + ((float) (dimensionPixelSize2 * 3)));
    }
}
