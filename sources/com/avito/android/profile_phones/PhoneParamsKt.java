package com.avito.android.profile_phones;

import android.app.Activity;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u001d\u0010\t\u001a\u00020\u0000*\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\t\u0010\u0006\"\u001a\u0010\u0004\u001a\u00020\u0001*\u00020\n8@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Landroid/content/Intent;", "", "getPhone", "(Landroid/content/Intent;)Ljava/lang/String;", "phone", "putPhone", "(Landroid/content/Intent;Ljava/lang/String;)Landroid/content/Intent;", "getMessage", "message", "putMessage", "Landroid/app/Activity;", "(Landroid/app/Activity;)Ljava/lang/String;", "profile-phones_release"}, k = 2, mv = {1, 4, 2})
public final class PhoneParamsKt {
    @Nullable
    public static final String getMessage(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$getMessage");
        return intent.getStringExtra("message");
    }

    @Nullable
    public static final String getPhone(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$getPhone");
        return intent.getStringExtra("phone");
    }

    @NotNull
    public static final Intent putMessage(@NotNull Intent intent, @Nullable String str) {
        Intrinsics.checkNotNullParameter(intent, "$this$putMessage");
        Intent putExtra = intent.putExtra("message", str);
        Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(KEY_MESSAGE, message)");
        return putExtra;
    }

    @NotNull
    public static final Intent putPhone(@NotNull Intent intent, @Nullable String str) {
        Intrinsics.checkNotNullParameter(intent, "$this$putPhone");
        Intent putExtra = intent.putExtra("phone", str);
        Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(KEY_PHONE, phone)");
        return putExtra;
    }

    @NotNull
    public static final String getPhone(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$this$phone");
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        String phone = getPhone(intent);
        if (phone != null) {
            return phone;
        }
        throw new IllegalStateException("phone must be specified");
    }
}
