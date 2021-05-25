package com.avito.android.serp;

import android.app.Application;
import android.content.Intent;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.SerpIntentFactory;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.serp.SerpActivity;
import com.avito.android.util.UrlParams;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u001c\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006JE\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\t\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001d¨\u0006 "}, d2 = {"Lcom/avito/android/serp/SerpIntentFactoryImpl;", "Lcom/avito/android/SerpIntentFactory;", "", "subscriptionId", "Landroid/content/Intent;", "searchSubscriptionIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "context", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "fromPage", "", "showOver", UrlParams.SIMPLE_MAP, "itemsListIntent", "(Lcom/avito/android/remote/model/SearchParams;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/lang/String;ZZ)Landroid/content/Intent;", "Lcom/avito/android/serp/SerpArguments;", "serpArguments", "Lcom/avito/android/bottom_navigation/NavigationTab;", "tab", AuthSource.SEND_ABUSE, "(Lcom/avito/android/serp/SerpArguments;Lcom/avito/android/bottom_navigation/NavigationTab;Z)Landroid/content/Intent;", "Lcom/avito/android/CoreActivityIntentFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/CoreActivityIntentFactory;", "coreActivityIntentFactory", "Landroid/app/Application;", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;Lcom/avito/android/CoreActivityIntentFactory;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class SerpIntentFactoryImpl implements SerpIntentFactory {
    public final Application a;
    public final CoreActivityIntentFactory b;

    @Inject
    public SerpIntentFactoryImpl(@NotNull Application application, @NotNull CoreActivityIntentFactory coreActivityIntentFactory) {
        Intrinsics.checkNotNullParameter(application, "context");
        Intrinsics.checkNotNullParameter(coreActivityIntentFactory, "coreActivityIntentFactory");
        this.a = application;
        this.b = coreActivityIntentFactory;
    }

    public final Intent a(SerpArguments serpArguments, NavigationTab navigationTab, boolean z) {
        if (z) {
            return new SerpActivity.Factory().create(this.a, serpArguments);
        }
        return this.b.mainScreenWithTab(new SerpFragmentData(serpArguments, navigationTab));
    }

    @Override // com.avito.android.SerpIntentFactory
    @NotNull
    public Intent itemsListIntent(@NotNull SearchParams searchParams, @Nullable String str, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable String str2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        return a(new SerpArguments(null, searchParams, str, treeClickStreamParent, str2, false, 33, null), NavigationTab.SEARCH.INSTANCE, z);
    }

    @Override // com.avito.android.SerpIntentFactory
    @NotNull
    public Intent searchSubscriptionIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "subscriptionId");
        return a(new SerpArguments(str, null, null, null, null, false, 62, null), NavigationTab.FAVORITES.INSTANCE, false);
    }
}
