package com.avito.android.phone_confirmation;

import a2.b.a.a.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.Status;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/phone_confirmation/PhoneConfirmationSmsReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "restrictedContext", "Landroid/content/Intent;", "incomingIntent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Lio/reactivex/functions/Consumer;", "", AuthSource.SEND_ABUSE, "Lio/reactivex/functions/Consumer;", "inputText", "<init>", "(Lio/reactivex/functions/Consumer;)V", "phone-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneConfirmationSmsReceiver extends BroadcastReceiver {
    public final Consumer<String> a;

    public PhoneConfirmationSmsReceiver(@NotNull Consumer<String> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "inputText");
        this.a = consumer;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        Object obj;
        if (Intrinsics.areEqual(SmsRetriever.SMS_RETRIEVED_ACTION, intent != null ? intent.getAction() : null)) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                extras = new Bundle(0);
            }
            Object obj2 = extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS");
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type com.google.android.gms.common.api.Status");
            Status status = (Status) obj2;
            int statusCode = status.getStatusCode();
            if (statusCode == 0) {
                Object obj3 = extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);
                Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.String");
                String str = (String) obj3;
                Iterator it = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Character.isDigit(StringsKt___StringsKt.first((String) obj))) {
                        break;
                    }
                }
                String str2 = (String) obj;
                if (str2 != null) {
                    this.a.accept(str2);
                } else {
                    Logs.error$default("PhoneConfirmationSmsReceiver", a.c3("Unable to get verification code from ", str), null, 4, null);
                }
            } else if (statusCode != 15) {
                Logs.error$default("PhoneConfirmationSmsReceiver", "Unknown status " + status + " while waiting verification code", null, 4, null);
            } else {
                Logs.warning$default("PhoneConfirmationSmsReceiver", "Timed out waiting while waiting verification code", null, 4, null);
            }
        }
    }
}
