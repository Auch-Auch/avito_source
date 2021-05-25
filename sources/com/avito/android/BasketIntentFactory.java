package com.avito.android;

import android.content.Intent;
import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JM\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/BasketIntentFactory;", "", "", "itemId", "Landroid/content/Intent;", "upIntent", "", "showFees", "vasContext", "vasType", "from", "basketIntent", "(Ljava/lang/String;Landroid/content/Intent;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "paidServicesIntent", "(Lcom/avito/android/deep_linking/links/DeepLink;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface BasketIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent basketIntent$default(BasketIntentFactory basketIntentFactory, String str, Intent intent, boolean z, String str2, String str3, String str4, int i, Object obj) {
            if (obj == null) {
                return basketIntentFactory.basketIntent(str, intent, (i & 4) != 0 ? true : z, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: basketIntent");
        }
    }

    @NotNull
    Intent basketIntent(@NotNull String str, @NotNull Intent intent, boolean z, @Nullable String str2, @Nullable String str3, @Nullable String str4);

    @NotNull
    Intent paidServicesIntent(@NotNull DeepLink deepLink);
}
