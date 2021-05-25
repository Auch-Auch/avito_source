package com.avito.android.bottom_navigation.util;

import android.content.Intent;
import android.os.Bundle;
import com.avito.android.bottom_navigation.NavigationTabSetItem;
import com.avito.android.bottom_navigation.ui.fragment.ShouldRetainCalledFrom;
import com.avito.android.bottom_navigation.ui.fragment.ShouldRetainCurrentTab;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u0007¢\u0006\u0004\b\u0005\u0010\b\u001a\u001b\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroid/content/Intent;", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "data", "putTabFragmentData", "(Landroid/content/Intent;Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;)Landroid/content/Intent;", "getTabFragmentData", "(Landroid/content/Intent;)Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "replaceTargetTabIfRequired", "(Landroid/content/Intent;Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Landroid/content/Intent;", "", "calledFrom", "replaceCalledFromIfRequired", "(Landroid/content/Intent;Ljava/lang/String;)Landroid/content/Intent;", "bottom-navigation_release"}, k = 2, mv = {1, 4, 2})
public final class IntentsKt {
    @Nullable
    public static final TabFragmentFactory.Data getTabFragmentData(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$getTabFragmentData");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            return getTabFragmentData(extras);
        }
        return null;
    }

    @NotNull
    public static final Intent putTabFragmentData(@NotNull Intent intent, @NotNull TabFragmentFactory.Data data) {
        Intrinsics.checkNotNullParameter(intent, "$this$putTabFragmentData");
        Intrinsics.checkNotNullParameter(data, "data");
        Intent putExtra = intent.putExtra("tab_fragment_data", data);
        Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(EXTRA_TAB_FRAGMENT_DATA, data)");
        return putExtra;
    }

    @NotNull
    public static final Intent replaceCalledFromIfRequired(@NotNull Intent intent, @NotNull String str) {
        Intrinsics.checkNotNullParameter(intent, "$this$replaceCalledFromIfRequired");
        Intrinsics.checkNotNullParameter(str, "calledFrom");
        TabFragmentFactory.Data tabFragmentData = getTabFragmentData(intent);
        if (tabFragmentData instanceof ShouldRetainCalledFrom) {
            putTabFragmentData(intent, ((ShouldRetainCalledFrom) tabFragmentData).copyWithCalledFrom(str));
        }
        return intent;
    }

    @NotNull
    public static final Intent replaceTargetTabIfRequired(@NotNull Intent intent, @Nullable NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(intent, "$this$replaceTargetTabIfRequired");
        if (navigationTabSetItem == null) {
            return intent;
        }
        TabFragmentFactory.Data tabFragmentData = getTabFragmentData(intent);
        if (tabFragmentData instanceof ShouldRetainCurrentTab) {
            putTabFragmentData(intent, ((ShouldRetainCurrentTab) tabFragmentData).copyWithTabIfRequired(navigationTabSetItem));
        }
        return intent;
    }

    @Nullable
    public static final TabFragmentFactory.Data getTabFragmentData(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "$this$getTabFragmentData");
        return (TabFragmentFactory.Data) bundle.getParcelable("tab_fragment_data");
    }
}
