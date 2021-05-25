package com.avito.android.cart_fab;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preferences;
import com.google.firebase.analytics.FirebaseAnalytics;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eR(\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028V@VX\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/cart_fab/CartFabPreferencesImpl;", "Lcom/avito/android/cart_fab/CartFabPreferences;", "", "value", "getQuantity", "()Ljava/lang/Integer;", "setQuantity", "(Ljava/lang/Integer;)V", FirebaseAnalytics.Param.QUANTITY, "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "prefs", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "cart-fab_release"}, k = 1, mv = {1, 4, 2})
public final class CartFabPreferencesImpl implements CartFabPreferences {
    public final Preferences a;

    @Inject
    public CartFabPreferencesImpl(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        this.a = preferences;
    }

    @Override // com.avito.android.cart_fab.CartFabPreferences
    @Nullable
    public Integer getQuantity() {
        if (this.a.contains("cartQuantity")) {
            return Integer.valueOf(this.a.getInt("cartQuantity", 0));
        }
        return null;
    }

    @Override // com.avito.android.cart_fab.CartFabPreferences
    public void setQuantity(@Nullable Integer num) {
        if (num != null) {
            this.a.putInt("cartQuantity", num.intValue());
        } else {
            this.a.remove("cartQuantity");
        }
    }
}
