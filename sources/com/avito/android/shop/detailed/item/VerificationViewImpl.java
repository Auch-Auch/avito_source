package com.avito.android.shop.detailed.item;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.shop.R;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/avito/android/shop/detailed/item/VerificationViewImpl;", "Lcom/avito/android/shop/detailed/item/VerificationView;", "", "title", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setInternalVerification", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "setExternalVerification", "showVerification", "()V", "Landroid/view/ViewGroup;", AuthSource.SEND_ABUSE, "Landroid/view/ViewGroup;", "verificationContainer", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "internalVerificationView", "c", "externalVerificationView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationViewImpl implements VerificationView {
    public final ViewGroup a;
    public final TextView b;
    public final TextView c;

    public VerificationViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.verification_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        this.a = (ViewGroup) findViewById;
        View findViewById2 = view.findViewById(R.id.verification_internal);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.verification_external);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById3;
    }

    @Override // com.avito.android.shop.detailed.item.VerificationView
    public void setExternalVerification(@Nullable String str, @Nullable Function0<Unit> function0) {
        TextViews.bindText$default(this.c, str, false, 2, null);
        TextViews.setClickListener(this.c, function0);
    }

    @Override // com.avito.android.shop.detailed.item.VerificationView
    public void setInternalVerification(@Nullable String str, @Nullable Function0<Unit> function0) {
        TextViews.bindText$default(this.b, str, false, 2, null);
        TextViews.setClickListener(this.b, function0);
    }

    @Override // com.avito.android.shop.detailed.item.VerificationView
    public void showVerification() {
        Views.show(this.a);
    }
}
