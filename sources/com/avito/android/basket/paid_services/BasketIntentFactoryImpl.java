package com.avito.android.basket.paid_services;

import android.content.Context;
import android.content.Intent;
import com.avito.android.BasketIntentFactory;
import com.avito.android.basket_legacy.ui.BasketActivityKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Constants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016JE\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/basket/paid_services/BasketIntentFactoryImpl;", "Lcom/avito/android/BasketIntentFactory;", "", "itemId", "Landroid/content/Intent;", "upIntent", "", "showFees", "vasContext", "vasType", "from", "basketIntent", "(Ljava/lang/String;Landroid/content/Intent;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "paidServicesIntent", "(Lcom/avito/android/deep_linking/links/DeepLink;)Landroid/content/Intent;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class BasketIntentFactoryImpl implements BasketIntentFactory {
    public final Context a;

    @Inject
    public BasketIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.BasketIntentFactory
    @NotNull
    public Intent basketIntent(@NotNull String str, @NotNull Intent intent, boolean z, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(intent, "upIntent");
        Intent putExtra = BasketActivityKt.createBasketActivityIntent(this.a, str, z, str2, str3, str4).putExtra(Constants.UP_INTENT, intent);
        Intrinsics.checkNotNullExpressionValue(putExtra, "createBasketActivityInte…ants.UP_INTENT, upIntent)");
        return putExtra;
    }

    @Override // com.avito.android.BasketIntentFactory
    @NotNull
    public Intent paidServicesIntent(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        return PaidServicesActivityKt.createPaidServicesActivityIntent(this.a, deepLink);
    }
}
