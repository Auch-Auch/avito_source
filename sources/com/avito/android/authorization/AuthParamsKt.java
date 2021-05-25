package com.avito.android.authorization;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u0015\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u001d\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001d\u0010\n\u001a\u00020\u0000*\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006*\u00020\u0000¢\u0006\u0004\b\f\u0010\b\u001a\u001b\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u000e\u0010\u000b\u001a\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0006*\u00020\u0000¢\u0006\u0004\b\u000f\u0010\b\u001a\u001d\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\u0011\u0010\u000b\u001a\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0006*\u00020\u0000¢\u0006\u0004\b\u0012\u0010\b\u001a\u001b\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0014\u0010\u000b\u001a\u0013\u0010\u0016\u001a\u00020\u0015*\u00020\u0000H\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001b\u0010\u0018\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001d\u0010\u001c\u001a\u00020\u0000*\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0000*\u00020\u001eH\u0000¢\u0006\u0004\b\u001f\u0010 \"\u0016\u0010!\u001a\u00020\u00068\u0000@\u0000XT¢\u0006\u0006\n\u0004\b!\u0010\"\"\u001a\u0010$\u001a\u00020\u0000*\u00020\u001e8@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b#\u0010 \"\u001a\u0010\u0013\u001a\u00020\u0006*\u00020\u001e8@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010%\"\u0016\u0010&\u001a\u00020\u00068\u0000@\u0000XT¢\u0006\u0006\n\u0004\b&\u0010\"\"\u0016\u0010'\u001a\u00020\u00068\u0000@\u0000XT¢\u0006\u0006\n\u0004\b'\u0010\"\"\u0016\u0010(\u001a\u00020\u00068\u0000@\u0000XT¢\u0006\u0006\n\u0004\b(\u0010\"\"\u0016\u0010)\u001a\u00020\u00068\u0000@\u0000XT¢\u0006\u0006\n\u0004\b)\u0010\"\"\u0016\u0010*\u001a\u00020\u00068\u0000@\u0000XT¢\u0006\u0006\n\u0004\b*\u0010\"\"\u001a\u0010\t\u001a\u00020\u0006*\u00020\u001e8@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010%\"\u0016\u0010+\u001a\u00020\u00068\u0000@\u0000XT¢\u0006\u0006\n\u0004\b+\u0010\"¨\u0006,"}, d2 = {"Landroid/content/Intent;", "getIntent", "(Landroid/content/Intent;)Landroid/content/Intent;", "intent", "putIntent", "(Landroid/content/Intent;Landroid/content/Intent;)Landroid/content/Intent;", "", "getLogin", "(Landroid/content/Intent;)Ljava/lang/String;", "login", "putLogin", "(Landroid/content/Intent;Ljava/lang/String;)Landroid/content/Intent;", "getSocial", "social", "putSocial", "getSocialId", "socialId", "putSocialId", "getHash", "hash", "putHash", "", "isPhoneUsed", "(Landroid/content/Intent;)Z", "putPhoneUsed", "(Landroid/content/Intent;Z)Landroid/content/Intent;", "Landroid/os/Parcelable;", "data", "putSuccessAuthResultData", "(Landroid/content/Intent;Landroid/os/Parcelable;)Landroid/content/Intent;", "Landroid/app/Activity;", "getSuccessAuthResultData", "(Landroid/app/Activity;)Landroid/content/Intent;", "KEY_INTENT", "Ljava/lang/String;", "getTargetIntent", "targetIntent", "(Landroid/app/Activity;)Ljava/lang/String;", "KEY_SOCIAL", "KEY_LOGIN", "KEY_SUCCESS_AUTH_RESULT_DATA", "KEY_HASH", "KEY_SOCIAL_ID", "KEY_PHONE_USED", "authorization_release"}, k = 2, mv = {1, 4, 2})
public final class AuthParamsKt {
    @NotNull
    public static final String KEY_HASH = "hash";
    @NotNull
    public static final String KEY_INTENT = "intent";
    @NotNull
    public static final String KEY_LOGIN = "login";
    @NotNull
    public static final String KEY_PHONE_USED = "phoneUsed";
    @NotNull
    public static final String KEY_SOCIAL = "social";
    @NotNull
    public static final String KEY_SOCIAL_ID = "social_id";
    @NotNull
    public static final String KEY_SUCCESS_AUTH_RESULT_DATA = "successAuthData";

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
    public static final Intent getIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$getIntent");
        return (Intent) intent.getParcelableExtra("intent");
    }

    @Nullable
    public static final String getLogin(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$getLogin");
        return intent.getStringExtra("login");
    }

    @Nullable
    public static final String getSocial(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$getSocial");
        return intent.getStringExtra("social");
    }

    @Nullable
    public static final String getSocialId(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$getSocialId");
        return intent.getStringExtra(KEY_SOCIAL_ID);
    }

    @Nullable
    public static final Intent getSuccessAuthResultData(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$this$getSuccessAuthResultData");
        Parcelable parcelableExtra = activity.getIntent().getParcelableExtra(KEY_SUCCESS_AUTH_RESULT_DATA);
        if (parcelableExtra == null) {
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("SuccessAuthResultData", parcelableExtra);
        return intent;
    }

    @NotNull
    public static final Intent getTargetIntent(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$this$targetIntent");
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        Intent intent2 = getIntent(intent);
        if (intent2 != null) {
            return intent2;
        }
        throw new IllegalStateException("intent must be specified");
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
    public static final Intent putIntent(@NotNull Intent intent, @Nullable Intent intent2) {
        Intrinsics.checkNotNullParameter(intent, "$this$putIntent");
        Intent putExtra = intent.putExtra("intent", intent2);
        Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(KEY_INTENT, intent)");
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

    @NotNull
    public static final Intent putSocial(@NotNull Intent intent, @NotNull String str) {
        Intrinsics.checkNotNullParameter(intent, "$this$putSocial");
        Intrinsics.checkNotNullParameter(str, "social");
        Intent putExtra = intent.putExtra("social", str);
        Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(KEY_SOCIAL, social)");
        return putExtra;
    }

    @NotNull
    public static final Intent putSocialId(@NotNull Intent intent, @Nullable String str) {
        Intrinsics.checkNotNullParameter(intent, "$this$putSocialId");
        Intent putExtra = intent.putExtra(KEY_SOCIAL_ID, str);
        Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(KEY_SOCIAL_ID, socialId)");
        return putExtra;
    }

    @NotNull
    public static final Intent putSuccessAuthResultData(@NotNull Intent intent, @Nullable Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(intent, "$this$putSuccessAuthResultData");
        Intent putExtra = intent.putExtra(KEY_SUCCESS_AUTH_RESULT_DATA, parcelable);
        Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(KEY_SUCCESS_AUTH_RESULT_DATA, data)");
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
