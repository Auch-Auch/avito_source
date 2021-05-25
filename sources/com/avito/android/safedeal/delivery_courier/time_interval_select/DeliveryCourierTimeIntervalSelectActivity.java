package com.avito.android.safedeal.delivery_courier.time_interval_select;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.avito.android.remote.model.delivery_courier.TimeInterval;
import com.avito.android.safedeal.R;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onBackPressed", "()V", "<init>", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierTimeIntervalSelectActivity extends AppCompatActivity {
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if (supportFragmentManager.getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_delivery_courier_time_interval_select);
        if (bundle == null) {
            String stringExtra = getIntent().getStringExtra("EXTRA_ORDER_ID");
            if (stringExtra != null) {
                String stringExtra2 = getIntent().getStringExtra("EXTRA_SOURCE");
                if (stringExtra2 != null) {
                    getSupportFragmentManager().beginTransaction().add(com.avito.android.ui_components.R.id.fragment_container, new DeliveryCourierTimeIntervalSelectFragment.Factory().createInstance(stringExtra, stringExtra2, (TimeInterval) getIntent().getParcelableExtra(DeliveryCourierTimeIntervalSelectActivityKt.EXTRA_SELECTED))).addToBackStack(null).commit();
                    return;
                }
                throw new IllegalStateException("source not set");
            }
            throw new IllegalStateException("orderID not set");
        }
    }
}
