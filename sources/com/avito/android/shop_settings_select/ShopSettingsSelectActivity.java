package com.avito.android.shop_settings_select;

import android.os.Bundle;
import com.avito.android.remote.model.shop_settings.ShopSettingsSelectData;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/shop_settings_select/ShopSettingsSelectActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "getContentLayoutId", "()I", "Lcom/avito/android/remote/model/shop_settings/ShopSettingsSelectData;", "data", "openSelect", "(Lcom/avito/android/remote/model/shop_settings/ShopSettingsSelectData;)V", "<init>", "()V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsSelectActivity extends BaseActivity implements ShopSettingsSelectRouter {
    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.fragment_container;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, ShopSettingsSelectFragment.Companion.newInstance((ShopSettingsSelectData) getIntent().getParcelableExtra("data"))).commit();
        }
    }

    @Override // com.avito.android.shop_settings_select.ShopSettingsSelectRouter
    public void openSelect(@NotNull ShopSettingsSelectData shopSettingsSelectData) {
        Intrinsics.checkNotNullParameter(shopSettingsSelectData, "data");
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, ShopSettingsSelectFragment.Companion.newInstance(shopSettingsSelectData)).addToBackStack(null).setTransition(4097).commit();
    }
}
