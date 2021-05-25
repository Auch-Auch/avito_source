package com.avito.android.str_calendar.seller;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.str_calendar.R;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarFragment;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersFragment;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Contexts;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.Relay;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b&\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0012\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\tR\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR(\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140\u00198\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/avito/android/str_calendar/seller/SellerCalendarActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/str_calendar/seller/SellerCalendarRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onBackPressed", "", BookingInfoActivity.EXTRA_ITEM_ID, "showSellerCalendar", "(Ljava/lang/String;)V", "Ljava/util/Date;", "startDate", "endDate", "showEditParametersScreen", "(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V", "", "updateCalendar", "leaveEditParametersScreen", "(Z)V", "finish", "Lcom/jakewharton/rxrelay2/Relay;", "k", "Lcom/jakewharton/rxrelay2/Relay;", "updateSellerCalendarRelay", "l", "getUpdateSellerCalendarObservable", "()Lcom/jakewharton/rxrelay2/Relay;", "setUpdateSellerCalendarObservable", "(Lcom/jakewharton/rxrelay2/Relay;)V", "updateSellerCalendarObservable", AuthSource.OPEN_CHANNEL_LIST, "Z", "updateMyAdvertDetailScreen", "<init>", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerCalendarActivity extends BaseActivity implements SellerCalendarRouter {
    public final Relay<Boolean> k;
    @NotNull
    public Relay<Boolean> l;
    public boolean m;

    public SellerCalendarActivity() {
        BehaviorRelay create = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorRelay.create()");
        this.k = create;
        this.l = create;
    }

    @Override // android.app.Activity
    public void finish() {
        setResult(this.m ? -1 : 0);
        super.finish();
    }

    @Override // com.avito.android.str_calendar.seller.SellerCalendarRouter
    public void leaveEditParametersScreen(boolean z) {
        onBackPressed();
        if (z) {
            this.m = true;
            this.k.accept(Boolean.TRUE);
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if (supportFragmentManager.getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Window window;
        super.onCreate(bundle);
        setContentView(R.layout.activity_seller_calendar);
        if (bundle == null) {
            String stringExtra = getIntent().getStringExtra("advert_id");
            Intrinsics.checkNotNullExpressionValue(stringExtra, BookingInfoActivity.EXTRA_ITEM_ID);
            showSellerCalendar(stringExtra);
        }
        if (Build.VERSION.SDK_INT > 21 && (window = getWindow()) != null) {
            window.setStatusBarColor(Contexts.getColorByAttr(this, com.avito.android.lib.design.R.attr.blackAlpha24));
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
            from.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: com.avito.android.str_calendar.seller.SellerCalendarActivity$setUpView$1
                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                public void onSlide(@NotNull View view, float f) {
                    Intrinsics.checkNotNullParameter(view, "bottomSheet");
                }

                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                public void onStateChanged(@NotNull View view, int i) {
                    Intrinsics.checkNotNullParameter(view, "bottomSheet");
                    if (i == 5) {
                        SellerCalendarActivity.this.finish();
                    }
                }
            });
        }
    }

    public void setUpdateSellerCalendarObservable(@NotNull Relay<Boolean> relay) {
        Intrinsics.checkNotNullParameter(relay, "<set-?>");
        this.l = relay;
    }

    @Override // com.avito.android.str_calendar.seller.SellerCalendarRouter
    public void showEditParametersScreen(@NotNull String str, @Nullable Date date, @Nullable Date date2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(com.avito.android.ui_components.R.id.fragment_container, new SellerCalendarParametersFragment.Factory().createInstance(str, date, date2)).addToBackStack(null).commit();
    }

    @Override // com.avito.android.str_calendar.seller.SellerCalendarRouter
    public void showSellerCalendar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        getSupportFragmentManager().beginTransaction().add(com.avito.android.ui_components.R.id.fragment_container, new SellerCalendarFragment.Factory().createInstance(str)).addToBackStack(null).commit();
    }

    @Override // com.avito.android.str_calendar.seller.SellerCalendarRouter
    @NotNull
    public Relay<Boolean> getUpdateSellerCalendarObservable() {
        return this.l;
    }
}
