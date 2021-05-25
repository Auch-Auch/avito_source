package com.avito.android.shop.detailed;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.shop.detailed.ShopDetailedFragment;
import com.avito.android.shop.detailed.di.DaggerShopDetailedActivityComponent;
import com.avito.android.shop.detailed.di.ShopDetailedDependencies;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.Intents;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0012J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/avito/android/shop/detailed/ShopDetailedActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "", "getContentLayoutId", "()I", "closeSearch", "()V", AuthSource.SEND_ABUSE, "<init>", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopDetailedActivity extends BaseActivity {
    public final void a(Intent intent) {
        TreeClickStreamParent treeAnalyticsParent = Intents.getTreeAnalyticsParent(intent);
        String stringExtra = intent.getStringExtra("shop_id");
        Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(KEY_SHOP_ID)");
        String stringExtra2 = intent.getStringExtra("page_from");
        String stringExtra3 = intent.getStringExtra("shop_context");
        Parcelable parcelableExtra = intent.getParcelableExtra("search_params");
        Intrinsics.checkNotNullExpressionValue(parcelableExtra, "intent.getParcelableExtra(KEY_SEARCH_PARAMS)");
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShopDetailedFragment.Factory().newInstance(new ShopDetailedArguments(stringExtra, stringExtra2, stringExtra3, (SearchParams) parcelableExtra, treeAnalyticsParent))).commitAllowingStateLoss();
    }

    public final void closeSearch() {
        Intent upIntent = getUpIntent();
        if (upIntent != null) {
            upIntent.setFlags(603979776);
            Contexts.startActivitySafely(this, upIntent);
        }
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.fragment_container;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            Intent intent = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            a(intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        a(intent);
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        DaggerShopDetailedActivityComponent.builder().dependencies((ShopDetailedDependencies) ComponentDependenciesKt.getDependencies(ShopDetailedDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).build().inject(this);
        return true;
    }
}
