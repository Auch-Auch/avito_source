package com.avito.android.safedeal.delivery_type;

import android.content.Intent;
import androidx.annotation.StringRes;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u0019\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/safedeal/delivery_type/DeliveryTypeFragmentDelegate;", "", "", "closeScreen", "()V", "Landroid/content/Intent;", "intent", "launchActivity", "(Landroid/content/Intent;)V", "showAuthScreen", "", "stringId", "launchToast", "(I)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryTypeFragmentDelegate {
    void closeScreen();

    void launchActivity(@Nullable Intent intent);

    void launchToast(@StringRes int i);

    void showAuthScreen();
}
