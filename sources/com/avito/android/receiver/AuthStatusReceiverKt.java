package com.avito.android.receiver;

import kotlin.Metadata;
import ru.ok.android.sdk.OkListener;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"application_release"}, k = 2, mv = {1, 4, 2})
public final class AuthStatusReceiverKt {
    public static final /* synthetic */ String access$getACTION_LOGIN_FAILURE$p() {
        return "com.avito.android.ACTION_LOGIN_FAILURE";
    }

    public static final /* synthetic */ String access$getACTION_LOGIN_SUCCESS$p() {
        return "com.avito.android.ACTION_LOGIN_SUCCESS";
    }

    public static final /* synthetic */ String access$getACTION_LOGOUT_FAILURE$p() {
        return "com.avito.android.ACTION_LOGOUT_FAILURE";
    }

    public static final /* synthetic */ String access$getACTION_LOGOUT_SUCCESS$p() {
        return "com.avito.android.ACTION_LOGOUT_SUCCESS";
    }

    public static final /* synthetic */ String access$getKEY_AUTH_RESULT$p() {
        return "authResult";
    }

    public static final /* synthetic */ String access$getKEY_CREDENTIALS$p() {
        return "credentials";
    }

    public static final /* synthetic */ String access$getKEY_EXCEPTION$p() {
        return OkListener.KEY_EXCEPTION;
    }

    public static final /* synthetic */ String access$getKEY_IS_USER_ACTION$p() {
        return "is_user_action";
    }
}
