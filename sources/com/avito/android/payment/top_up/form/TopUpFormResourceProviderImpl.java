package com.avito.android.payment.top_up.form;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.avito.android.payment.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/payment/top_up/form/TopUpFormResourceProviderImpl;", "Lcom/avito/android/payment/top_up/form/TopUpFormResourceProvider;", "Landroid/graphics/drawable/Drawable;", "getInputItemDivider", "()Landroid/graphics/drawable/Drawable;", "inputItemDivider", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class TopUpFormResourceProviderImpl implements TopUpFormResourceProvider {
    public final Context a;

    public TopUpFormResourceProviderImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.payment.top_up.form.TopUpFormResourceProvider
    @NotNull
    public Drawable getInputItemDivider() {
        Drawable drawable = this.a.getDrawable(R.drawable.top_up_form_input_item_divider);
        Intrinsics.checkNotNull(drawable);
        return drawable;
    }
}
