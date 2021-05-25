package com.avito.android.brandspace.router;

import android.content.Intent;
import com.avito.android.BrandspaceIntentFactory;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.navigation.NavigationTabProvider;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J5\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/brandspace/router/BrandspaceIntentFactoryImpl;", "Lcom/avito/android/BrandspaceIntentFactory;", "", "id", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "brandspaceSource", "Lcom/avito/android/bottom_navigation/NavigationTab;", "tab", "Landroid/content/Intent;", "brandspaceIntent", "(Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/lang/String;Lcom/avito/android/bottom_navigation/NavigationTab;)Landroid/content/Intent;", "Lcom/avito/android/CoreActivityIntentFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/CoreActivityIntentFactory;", "coreActivityIntentFactory", "Lcom/avito/android/navigation/NavigationTabProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/navigation/NavigationTabProvider;", "tabProvider", "<init>", "(Lcom/avito/android/CoreActivityIntentFactory;Lcom/avito/android/navigation/NavigationTabProvider;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public class BrandspaceIntentFactoryImpl implements BrandspaceIntentFactory {
    public final CoreActivityIntentFactory a;
    public final NavigationTabProvider b;

    @Inject
    public BrandspaceIntentFactoryImpl(@NotNull CoreActivityIntentFactory coreActivityIntentFactory, @NotNull NavigationTabProvider navigationTabProvider) {
        Intrinsics.checkNotNullParameter(coreActivityIntentFactory, "coreActivityIntentFactory");
        Intrinsics.checkNotNullParameter(navigationTabProvider, "tabProvider");
        this.a = coreActivityIntentFactory;
        this.b = navigationTabProvider;
    }

    @Override // com.avito.android.BrandspaceIntentFactory
    @NotNull
    public Intent brandspaceIntent(@NotNull String str, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable String str2, @Nullable NavigationTab navigationTab) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (navigationTab == null) {
            navigationTab = this.b.currentTab();
        }
        if (navigationTab == null) {
            navigationTab = NavigationTab.SEARCH.INSTANCE;
        }
        return this.a.mainScreenWithTab(new BrandspaceFragmentData(new BrandspaceArguments(str, treeClickStreamParent, str2), navigationTab));
    }
}
