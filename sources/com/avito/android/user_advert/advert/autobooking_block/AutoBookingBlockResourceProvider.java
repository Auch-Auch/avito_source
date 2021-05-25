package com.avito.android.user_advert.advert.autobooking_block;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_advert.R;
import com.avito.android.user_advert.advert.switcher_block.SwitcherBlockResourceProvider;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/avito/android/user_advert/advert/autobooking_block/AutoBookingBlockResourceProvider;", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherBlockResourceProvider;", "", "d", "Ljava/lang/String;", "getTurningOffWarningMessage", "()Ljava/lang/String;", "turningOffWarningMessage", "e", "getTurningOffWarningCancelButtonTitle", "turningOffWarningCancelButtonTitle", AuthSource.SEND_ABUSE, "getSwitcherEnableErrorText", "switcherEnableErrorText", "f", "getTurningOffWarningConfirmButtonTitle", "turningOffWarningConfirmButtonTitle", "c", "getTurningOffWarningTitle", "turningOffWarningTitle", AuthSource.BOOKING_ORDER, "getSwitcherDisableErrorText", "switcherDisableErrorText", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class AutoBookingBlockResourceProvider implements SwitcherBlockResourceProvider {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    @NotNull
    public final String f;

    @Inject
    public AutoBookingBlockResourceProvider(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        String string = resources.getString(R.string.auto_booking_switcher_enable_error);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ng_switcher_enable_error)");
        this.a = string;
        String string2 = resources.getString(R.string.auto_booking_switcher_disable_error);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…g_switcher_disable_error)");
        this.b = string2;
        String string3 = resources.getString(R.string.auto_booking_warning_title);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st…to_booking_warning_title)");
        this.c = string3;
        String string4 = resources.getString(R.string.auto_booking_warning_message);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st…_booking_warning_message)");
        this.d = string4;
        String string5 = resources.getString(R.string.auto_booking_warning_cancel_button);
        Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(R.st…ng_warning_cancel_button)");
        this.e = string5;
        String string6 = resources.getString(R.string.auto_booking_warning_confirm_button);
        Intrinsics.checkNotNullExpressionValue(string6, "resources.getString(R.st…g_warning_confirm_button)");
        this.f = string6;
    }

    @Override // com.avito.android.user_advert.advert.switcher_block.SwitcherBlockResourceProvider
    @NotNull
    public String getSwitcherDisableErrorText() {
        return this.b;
    }

    @Override // com.avito.android.user_advert.advert.switcher_block.SwitcherBlockResourceProvider
    @NotNull
    public String getSwitcherEnableErrorText() {
        return this.a;
    }

    @NotNull
    public final String getTurningOffWarningCancelButtonTitle() {
        return this.e;
    }

    @NotNull
    public final String getTurningOffWarningConfirmButtonTitle() {
        return this.f;
    }

    @NotNull
    public final String getTurningOffWarningMessage() {
        return this.d;
    }

    @NotNull
    public final String getTurningOffWarningTitle() {
        return this.c;
    }
}
