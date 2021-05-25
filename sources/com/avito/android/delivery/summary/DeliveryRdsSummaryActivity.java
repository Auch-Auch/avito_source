package com.avito.android.delivery.summary;

import android.os.Bundle;
import com.avito.android.SummaryState;
import com.avito.android.delivery.R;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingActivityKt;
import com.avito.android.delivery.summary.DeliveryRdsSummaryFragment;
import com.avito.android.ui.activity.BaseActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/delivery/summary/DeliveryRdsSummaryActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "", "getContentLayoutId", "()I", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryRdsSummaryActivity extends BaseActivity {
    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.rds_activity_delivery_summary;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        DeliveryRdsSummaryFragment deliveryRdsSummaryFragment;
        super.onCreate(bundle);
        if (bundle == null) {
            String stringExtra = getIntent().getStringExtra(DeliveryRdsSummaryActivityKt.EXTRA_PAY_ORDER_ID);
            if (stringExtra != null) {
                deliveryRdsSummaryFragment = new DeliveryRdsSummaryFragment.Factory().createInstance(stringExtra);
            } else {
                SummaryState summaryState = (SummaryState) getIntent().getParcelableExtra(DeliveryRdsSummaryActivityKt.EXTRA_SUMMARY_STATE);
                if (summaryState != null) {
                    deliveryRdsSummaryFragment = new DeliveryRdsSummaryFragment.Factory().createInstance(getIntent().getStringExtra("search_context"), summaryState, getIntent().getBooleanExtra(DeliveryRdsStartOrderingActivityKt.EXTRA_CART_FLAG, false), getIntent().getBooleanExtra(DeliveryRdsStartOrderingActivityKt.EXTRA_MARKETPLACE_FLAG, false), getIntent().getStringExtra("source"));
                } else {
                    throw new IllegalStateException("Summary state must not be null!");
                }
            }
            getSupportFragmentManager().beginTransaction().add(com.avito.android.ui_components.R.id.fragment_container, deliveryRdsSummaryFragment).commit();
        }
    }
}
