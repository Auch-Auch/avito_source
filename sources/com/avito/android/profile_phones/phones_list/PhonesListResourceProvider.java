package com.avito.android.profile_phones.phones_list;

import android.content.res.Resources;
import com.avito.android.profile_phones.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000e\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u0019\u0010\u0011\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\u0010\u0010\nR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/PhonesListResourceProvider;", "", "", "number", "", "advertsNumber", "(I)Ljava/lang/String;", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStatusOnVerification", "()Ljava/lang/String;", "statusOnVerification", AuthSource.SEND_ABUSE, "getStatusNotVerified", "statusNotVerified", "c", "getPhoneNotUsed", "phoneNotUsed", "Landroid/content/res/Resources;", "d", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class PhonesListResourceProvider {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    public final Resources d;

    public PhonesListResourceProvider(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.d = resources;
        String string = resources.getString(R.string.phone_status_not_verified);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…hone_status_not_verified)");
        this.a = string;
        String string2 = resources.getString(R.string.phone_status_on_verification);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…e_status_on_verification)");
        this.b = string2;
        String string3 = resources.getString(R.string.phone_not_used);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.string.phone_not_used)");
        this.c = string3;
    }

    @NotNull
    public final String advertsNumber(int i) {
        String quantityString = this.d.getQuantityString(R.plurals.adverts_count, i, Integer.valueOf(i));
        Intrinsics.checkNotNullExpressionValue(quantityString, "resources.getQuantityStr…ts_count, number, number)");
        return quantityString;
    }

    @NotNull
    public final String getPhoneNotUsed() {
        return this.c;
    }

    @NotNull
    public final String getStatusNotVerified() {
        return this.a;
    }

    @NotNull
    public final String getStatusOnVerification() {
        return this.b;
    }
}
