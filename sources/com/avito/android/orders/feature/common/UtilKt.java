package com.avito.android.orders.feature.common;

import androidx.fragment.app.Fragment;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "", "navigateToAuth", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/ActivityIntentFactory;)V", "orders_release"}, k = 2, mv = {1, 4, 2})
public final class UtilKt {
    public static final void navigateToAuth(@NotNull Fragment fragment, @NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        fragment.startActivity(AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory, null, AuthSource.TEST_2, null, 5, null));
    }
}
