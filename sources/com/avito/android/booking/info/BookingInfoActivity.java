package com.avito.android.booking.info;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.avito.android.ui.activity.BaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/booking/info/BookingInfoActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "<init>", "()V", "Companion", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class BookingInfoActivity extends BaseActivity {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String EXTRA_FROM_BLOCK = "fromBlock";
    @NotNull
    public static final String EXTRA_ITEM_ID = "advertId";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00048\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00048\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/booking/info/BookingInfoActivity$Companion;", "", "Landroid/content/Context;", "context", "", "itemId", BookingInfoActivity.EXTRA_FROM_BLOCK, "Landroid/content/Intent;", "createBookingInfoIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "EXTRA_FROM_BLOCK", "Ljava/lang/String;", "EXTRA_ITEM_ID", "<init>", "()V", "booking_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Intent createBookingInfoIntent(@NotNull Context context, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "itemId");
            Intrinsics.checkNotNullParameter(str2, BookingInfoActivity.EXTRA_FROM_BLOCK);
            Intent intent = new Intent(context, BookingInfoActivity.class);
            intent.putExtra(BookingInfoActivity.EXTRA_ITEM_ID, str);
            intent.putExtra(BookingInfoActivity.EXTRA_FROM_BLOCK, str2);
            return intent;
        }

        public Companion(j jVar) {
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(EXTRA_ITEM_ID);
        Intrinsics.checkNotNull(stringExtra);
        String stringExtra2 = getIntent().getStringExtra(EXTRA_FROM_BLOCK);
        Intrinsics.checkNotNull(stringExtra2);
        getSupportFragmentManager().beginTransaction().replace(16908290, BookingInfoFragment.Companion.createInstance(stringExtra, stringExtra2)).commit();
    }
}
