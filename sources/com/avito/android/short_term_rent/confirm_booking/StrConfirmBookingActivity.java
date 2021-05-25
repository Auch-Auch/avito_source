package com.avito.android.short_term_rent.confirm_booking;

import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.avito.android.short_term_rent.R;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingFragment;
import com.avito.android.str.StrCalendarActivityInteractionConstants;
import com.avito.android.ui.activity.BaseActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "<init>", "()V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrConfirmBookingActivity extends BaseActivity {
    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_confirm_booking);
        if (bundle == null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            int i = com.avito.android.ui_components.R.id.fragment_container;
            StrConfirmBookingFragment.Factory factory = new StrConfirmBookingFragment.Factory();
            String stringExtra = getIntent().getStringExtra("advert_id");
            if (stringExtra != null) {
                String stringExtra2 = getIntent().getStringExtra("check_int_date");
                if (stringExtra2 != null) {
                    String stringExtra3 = getIntent().getStringExtra(StrCalendarActivityInteractionConstants.EXTRA_CHECK_OUT_DATE);
                    if (stringExtra3 != null) {
                        beginTransaction.add(i, factory.createInstance(stringExtra, stringExtra2, stringExtra3, getIntent().getIntExtra("guests_count", -1), getIntent().getStringExtra("workflow"))).commit();
                        return;
                    }
                    throw new IllegalStateException("checkOutDate is null");
                }
                throw new IllegalStateException("checkInDate is null");
            }
            throw new IllegalStateException("advertId is null");
        }
    }
}
