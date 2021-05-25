package com.avito.android.str_calendar.booking;

import android.os.Bundle;
import android.view.View;
import com.avito.android.str.StrCalendarActivityInteractionConstants;
import com.avito.android.str_calendar.R;
import com.avito.android.str_calendar.booking.CalendarFragment;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Contexts;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/str_calendar/booking/CalendarActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onBackPressed", "<init>", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class CalendarActivity extends BaseActivity {
    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        setResult(-1);
        super.onBackPressed();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_calendar);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().add(com.avito.android.ui_components.R.id.fragment_container, new CalendarFragment.Factory().createInstance(getIntent().getStringExtra("advert_id"), (Date) getIntent().getSerializableExtra(StrCalendarActivityInteractionConstants.EXTRA_CHECK_IN_DATE), (Date) getIntent().getSerializableExtra(StrCalendarActivityInteractionConstants.EXTRA_CHECK_OUT_DATE))).commit();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (getResources().getBoolean(R.bool.show_bottom_sheet)) {
            BottomSheetBehavior from = BottomSheetBehavior.from(findViewById(R.id.bottom_sheet));
            Intrinsics.checkNotNullExpressionValue(from, "BottomSheetBehavior.from(bottomSheet)");
            from.setHideable(true);
            from.setPeekHeight(Contexts.getRealDisplayHeight(this));
            from.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: com.avito.android.str_calendar.booking.CalendarActivity$setUpView$1
                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                public void onSlide(@NotNull View view, float f) {
                    Intrinsics.checkNotNullParameter(view, "bottomSheet");
                }

                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                public void onStateChanged(@NotNull View view, int i) {
                    Intrinsics.checkNotNullParameter(view, "bottomSheet");
                    if (i == 5) {
                        CalendarActivity.this.setResult(-1);
                        CalendarActivity.this.finish();
                    }
                }
            });
        }
    }
}
