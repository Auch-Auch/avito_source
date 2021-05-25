package com.avito.android.code_confirmation;

import android.app.Activity;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u001b\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\t\u0010\u0006\u001a\u0013\u0010\u000b\u001a\u00020\n*\u00020\u0000H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\r\u0010\u000e\"\u001a\u0010\u0004\u001a\u00020\u0001*\u00020\u000f8@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0010\"\u0016\u0010\u0011\u001a\u00020\u00018\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\u0016\u0010\u0013\u001a\u00020\u00018\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012\"\u001a\u0010\b\u001a\u00020\u0001*\u00020\u000f8@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0010\"\u0016\u0010\u0014\u001a\u00020\u00018\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012¨\u0006\u0015"}, d2 = {"Landroid/content/Intent;", "", "getLogin", "(Landroid/content/Intent;)Ljava/lang/String;", "login", "putLogin", "(Landroid/content/Intent;Ljava/lang/String;)Landroid/content/Intent;", "getHash", "hash", "putHash", "", "isPhoneUsed", "(Landroid/content/Intent;)Z", "putPhoneUsed", "(Landroid/content/Intent;Z)Landroid/content/Intent;", "Landroid/app/Activity;", "(Landroid/app/Activity;)Ljava/lang/String;", "KEY_PHONE_USED", "Ljava/lang/String;", "KEY_LOGIN", "KEY_HASH", "code-confirmation_release"}, k = 2, mv = {1, 4, 2})
public final class CodeConfirmationParamsKt {
    @NotNull
    public static final String KEY_HASH = "hash";
    @NotNull
    public static final String KEY_LOGIN = "login";
    @NotNull
    public static final String KEY_PHONE_USED = "phoneUsed";

    @NotNull
    public static final String getHash(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$this$hash");
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        String hash = getHash(intent);
        if (hash != null) {
            return hash;
        }
        throw new IllegalStateException("hash must be specified");
    }

    @Nullable
    public static final String getLogin(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$getLogin");
        return intent.getStringExtra("login");
    }

    public static final boolean isPhoneUsed(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$isPhoneUsed");
        return intent.getBooleanExtra("phoneUsed", false);
    }

    @NotNull
    public static final Intent putHash(@NotNull Intent intent, @NotNull String str) {
        Intrinsics.checkNotNullParameter(intent, "$this$putHash");
        Intrinsics.checkNotNullParameter(str, "hash");
        Intent putExtra = intent.putExtra("hash", str);
        Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(KEY_HASH, hash)");
        return putExtra;
    }

    @NotNull
    public static final Intent putLogin(@NotNull Intent intent, @Nullable String str) {
        Intrinsics.checkNotNullParameter(intent, "$this$putLogin");
        Intent putExtra = intent.putExtra("login", str);
        Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(KEY_LOGIN, login)");
        return putExtra;
    }

    @NotNull
    public static final Intent putPhoneUsed(@NotNull Intent intent, boolean z) {
        Intrinsics.checkNotNullParameter(intent, "$this$putPhoneUsed");
        Intent putExtra = intent.putExtra("phoneUsed", z);
        Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(KEY_PHONE_USED, isPhoneUsed)");
        return putExtra;
    }

    @Nullable
    public static final String getHash(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$getHash");
        return intent.getStringExtra("hash");
    }

    @NotNull
    public static final String getLogin(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$this$login");
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        String login = getLogin(intent);
        if (login != null) {
            return login;
        }
        throw new IllegalStateException("login must be specified");
    }
}
