package com.avito.android.phone_confirmation;

import android.content.Context;
import android.content.Intent;
import com.avito.android.PhoneConfirmationIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Constants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/phone_confirmation/PhoneConfirmationIntentFactoryImpl;", "Lcom/avito/android/PhoneConfirmationIntentFactory;", "", "phoneNumber", "manager", "", "isCompany", "confirmOnConsultationForm", "Landroid/content/Intent;", "phoneVerificationIntent", "(Ljava/lang/String;Ljava/lang/String;ZZ)Landroid/content/Intent;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "phone-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneConfirmationIntentFactoryImpl implements PhoneConfirmationIntentFactory {
    public final Context a;

    @Inject
    public PhoneConfirmationIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.PhoneConfirmationIntentFactory
    @NotNull
    public Intent phoneVerificationIntent(@NotNull String str, @Nullable String str2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "phoneNumber");
        Intent putExtra = new Intent(this.a, PhoneConfirmationActivity.class).setFlags(603979776).putExtra("phone", str).putExtra("manager", str2).putExtra(Constants.IS_COMPANY, z).putExtra(Constants.CONSULTATION_FORM, z2);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…onfirmOnConsultationForm)");
        return putExtra;
    }
}
