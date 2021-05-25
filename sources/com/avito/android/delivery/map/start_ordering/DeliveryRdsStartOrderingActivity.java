package com.avito.android.delivery.map.start_ordering;

import android.os.Bundle;
import com.avito.android.delivery.R;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment;
import com.avito.android.remote.model.ParametrizedEvent;
import com.avito.android.ui.activity.BaseActivity;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "", "getContentLayoutId", "()I", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryRdsStartOrderingActivity extends BaseActivity {
    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.rds_activity_delivery_points_map;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            String stringExtra = getIntent().getStringExtra("advert_id");
            String stringExtra2 = getIntent().getStringExtra("source");
            boolean booleanExtra = getIntent().getBooleanExtra(DeliveryRdsStartOrderingActivityKt.EXTRA_MARKETPLACE_FLAG, false);
            boolean booleanExtra2 = getIntent().getBooleanExtra(DeliveryRdsStartOrderingActivityKt.EXTRA_CART_FLAG, false);
            double doubleExtra = getIntent().getDoubleExtra(DeliveryRdsStartOrderingActivityKt.EXTRA_PIN_LAT, 180.01d);
            double doubleExtra2 = getIntent().getDoubleExtra(DeliveryRdsStartOrderingActivityKt.EXTRA_PIN_LNG, 180.01d);
            String stringExtra3 = getIntent().getStringExtra(DeliveryRdsStartOrderingActivityKt.EXTRA_PIN_FIAS_GUID);
            ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra(DeliveryRdsStartOrderingActivityKt.EXTRA_PIN_SERVICE_IDS);
            getSupportFragmentManager().beginTransaction().add(com.avito.android.ui_components.R.id.fragment_container, new DeliveryRdsStartOrderingFragment.Factory().createInstance(stringExtra, stringExtra2, getIntent().getStringExtra("search_context"), booleanExtra, booleanExtra2, getIntent().getStringExtra(DeliveryRdsStartOrderingActivityKt.EXTRA_FIRST_CART_ITEM_ID), getIntent().getStringExtra(DeliveryRdsStartOrderingActivityKt.EXTRA_CART_ITEMS), doubleExtra, doubleExtra2, stringExtra3, stringArrayListExtra, getIntent().getBooleanExtra(DeliveryRdsStartOrderingActivityKt.EXTRA_FROM_SUMMARY, false), (ParametrizedEvent) getIntent().getParcelableExtra(DeliveryRdsStartOrderingActivityKt.EXTRA_CONTACT_EVENT))).addToBackStack(null).commit();
        }
    }
}
