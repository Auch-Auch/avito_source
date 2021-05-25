package com.avito.android.payment.wallet;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.avito.android.design.widget.tab.TabLayoutAdapter;
import com.avito.android.payment.R;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.util.Contexts;
import com.avito.android.util.TabLayoutsKt;
import com.google.android.material.tabs.TabLayout;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/payment/wallet/OperationsHistoryActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "onSupportNavigateUp", "()Z", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class OperationsHistoryActivity extends BaseActivity {
    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.payment_operations_history_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.wallet_page_tabs);
        ViewPager viewPager = (ViewPager) findViewById(R.id.wallet_page_view_pager);
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        Drawable navigationIcon = toolbar.getNavigationIcon();
        if (navigationIcon != null) {
            navigationIcon.setColorFilter(Contexts.getColorByAttr(this, com.avito.android.lib.design.R.attr.black), PorterDuff.Mode.SRC_ATOP);
        }
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        TabsDataProvider tabsDataProvider = new TabsDataProvider();
        tabsDataProvider.updateItems(CollectionsKt__CollectionsKt.listOf((Object[]) new TabItem[]{new TabItem("Пополнения", "topup"), new TabItem("Оплата услуг", NotificationCompat.CATEGORY_SERVICE)}));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
        Intrinsics.checkNotNullExpressionValue(viewPager, "viewPager");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        viewPager.setAdapter(new WalletPageOperationsPagerAdapter(supportFragmentManager, tabsDataProvider));
        Intrinsics.checkNotNullExpressionValue(tabLayout, "walletTabs");
        TabLayoutsKt.setAdapter(tabLayout, new TabLayoutAdapter(tabsDataProvider, this, 0, 4, null));
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}
