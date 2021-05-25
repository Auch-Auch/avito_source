package com.avito.android.short_term_rent.start_booking;

import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.avito.android.short_term_rent.R;
import com.avito.android.short_term_rent.start_booking.StrStartBookingFragment;
import com.avito.android.str.StrCalendarActivityInteractionConstants;
import com.avito.android.ui.activity.BaseActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/short_term_rent/start_booking/StrStartBookingActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "<init>", "()V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrStartBookingActivity extends BaseActivity {
    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_start_booking);
        if (bundle == null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            int i = com.avito.android.ui_components.R.id.fragment_container;
            StrStartBookingFragment.Factory factory = new StrStartBookingFragment.Factory();
            String stringExtra = getIntent().getStringExtra("advert_id");
            if (stringExtra != null) {
                String stringExtra2 = getIntent().getStringExtra("source");
                if (stringExtra2 != null) {
                    beginTransaction.add(i, factory.createInstance(stringExtra, stringExtra2, getIntent().getStringExtra(StrCalendarActivityInteractionConstants.EXTRA_CHECK_IN_DATE), getIntent().getStringExtra(StrCalendarActivityInteractionConstants.EXTRA_CHECK_OUT_DATE), getIntent().getBooleanExtra("show_calendar", false), getIntent().getStringExtra("workflow"))).commit();
                    return;
                }
                throw new IllegalStateException("source is null");
            }
            throw new IllegalStateException("advertId is null");
        }
    }
}
