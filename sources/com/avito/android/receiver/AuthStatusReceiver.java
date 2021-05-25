package com.avito.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AuthResult;
import com.avito.android.remote.model.UserCredentials;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.ok.android.sdk.OkListener;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0002\u0010\u000fB\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/avito/android/receiver/AuthStatusReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Lcom/avito/android/receiver/AuthStatusReceiver$AuthStatusListener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/receiver/AuthStatusReceiver$AuthStatusListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lcom/avito/android/receiver/AuthStatusReceiver$AuthStatusListener;)V", "Companion", "AuthStatusListener", "application_release"}, k = 1, mv = {1, 4, 2})
public final class AuthStatusReceiver extends BroadcastReceiver {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final AuthStatusListener a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0011\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/receiver/AuthStatusReceiver$AuthStatusListener;", "", "Lcom/avito/android/remote/model/UserCredentials;", "credentials", "Lcom/avito/android/remote/model/AuthResult;", "authResult", "", "onLoginSuccess", "(Lcom/avito/android/remote/model/UserCredentials;Lcom/avito/android/remote/model/AuthResult;)V", "", OkListener.KEY_EXCEPTION, "onLoginFailure", "(Ljava/lang/Throwable;)V", "", "isUserAction", "onLogoutSuccess", "(Z)V", "onLogoutFailure", "application_release"}, k = 1, mv = {1, 4, 2})
    public interface AuthStatusListener {
        void onLoginFailure(@NotNull Throwable th);

        void onLoginSuccess(@NotNull UserCredentials userCredentials, @NotNull AuthResult authResult);

        void onLogoutFailure(@NotNull Throwable th);

        void onLogoutSuccess(boolean z);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/receiver/AuthStatusReceiver$Companion;", "", "Lcom/avito/android/remote/model/UserCredentials;", "credentials", "Lcom/avito/android/remote/model/AuthResult;", "authResult", "Landroid/content/Intent;", "createLoginSuccessIntent", "(Lcom/avito/android/remote/model/UserCredentials;Lcom/avito/android/remote/model/AuthResult;)Landroid/content/Intent;", "", OkListener.KEY_EXCEPTION, "createLoginFailureIntent", "(Ljava/lang/Throwable;)Landroid/content/Intent;", "", "isUserAction", "createLogoutSuccessIntent", "(Z)Landroid/content/Intent;", "createLogoutFailureIntent", "Landroid/content/IntentFilter;", "createIntentFilter", "()Landroid/content/IntentFilter;", "<init>", "()V", "application_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        @NotNull
        public final IntentFilter createIntentFilter() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(AuthStatusReceiverKt.access$getACTION_LOGIN_SUCCESS$p());
            intentFilter.addAction(AuthStatusReceiverKt.access$getACTION_LOGIN_FAILURE$p());
            intentFilter.addAction(AuthStatusReceiverKt.access$getACTION_LOGOUT_SUCCESS$p());
            intentFilter.addAction(AuthStatusReceiverKt.access$getACTION_LOGOUT_FAILURE$p());
            return intentFilter;
        }

        @JvmStatic
        @NotNull
        public final Intent createLoginFailureIntent(@NotNull Throwable th) {
            Intrinsics.checkNotNullParameter(th, OkListener.KEY_EXCEPTION);
            Intent putExtra = new Intent(AuthStatusReceiverKt.access$getACTION_LOGIN_FAILURE$p()).putExtra(AuthStatusReceiverKt.access$getKEY_EXCEPTION$p(), th);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(ACTION_LOGIN_FAIL…KEY_EXCEPTION, exception)");
            return putExtra;
        }

        @JvmStatic
        @NotNull
        public final Intent createLoginSuccessIntent(@NotNull UserCredentials userCredentials, @NotNull AuthResult authResult) {
            Intrinsics.checkNotNullParameter(userCredentials, "credentials");
            Intrinsics.checkNotNullParameter(authResult, "authResult");
            Intent putExtra = new Intent(AuthStatusReceiverKt.access$getACTION_LOGIN_SUCCESS$p()).putExtra(AuthStatusReceiverKt.access$getKEY_CREDENTIALS$p(), userCredentials).putExtra(AuthStatusReceiverKt.access$getKEY_AUTH_RESULT$p(), authResult);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(ACTION_LOGIN_SUCC…_AUTH_RESULT, authResult)");
            return putExtra;
        }

        @JvmStatic
        @NotNull
        public final Intent createLogoutFailureIntent(@NotNull Throwable th) {
            Intrinsics.checkNotNullParameter(th, OkListener.KEY_EXCEPTION);
            Intent putExtra = new Intent(AuthStatusReceiverKt.access$getACTION_LOGOUT_FAILURE$p()).putExtra(AuthStatusReceiverKt.access$getKEY_EXCEPTION$p(), th);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(ACTION_LOGOUT_FAI…KEY_EXCEPTION, exception)");
            return putExtra;
        }

        @JvmStatic
        @NotNull
        public final Intent createLogoutSuccessIntent(boolean z) {
            Intent putExtra = new Intent(AuthStatusReceiverKt.access$getACTION_LOGOUT_SUCCESS$p()).putExtra(AuthStatusReceiverKt.access$getKEY_IS_USER_ACTION$p(), z);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(ACTION_LOGOUT_SUC…SER_ACTION, isUserAction)");
            return putExtra;
        }

        public Companion(j jVar) {
        }
    }

    public AuthStatusReceiver(@NotNull AuthStatusListener authStatusListener) {
        Intrinsics.checkNotNullParameter(authStatusListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = authStatusListener;
    }

    @JvmStatic
    @NotNull
    public static final IntentFilter createIntentFilter() {
        return Companion.createIntentFilter();
    }

    @JvmStatic
    @NotNull
    public static final Intent createLoginFailureIntent(@NotNull Throwable th) {
        return Companion.createLoginFailureIntent(th);
    }

    @JvmStatic
    @NotNull
    public static final Intent createLoginSuccessIntent(@NotNull UserCredentials userCredentials, @NotNull AuthResult authResult) {
        return Companion.createLoginSuccessIntent(userCredentials, authResult);
    }

    @JvmStatic
    @NotNull
    public static final Intent createLogoutFailureIntent(@NotNull Throwable th) {
        return Companion.createLogoutFailureIntent(th);
    }

    @JvmStatic
    @NotNull
    public static final Intent createLogoutSuccessIntent(boolean z) {
        return Companion.createLogoutSuccessIntent(z);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (action != null) {
            Intrinsics.checkNotNullExpressionValue(action, "intent.action ?: return");
            if (Intrinsics.areEqual(action, AuthStatusReceiverKt.access$getACTION_LOGIN_SUCCESS$p())) {
                UserCredentials userCredentials = (UserCredentials) intent.getParcelableExtra(AuthStatusReceiverKt.access$getKEY_CREDENTIALS$p());
                AuthResult authResult = (AuthResult) intent.getParcelableExtra(AuthStatusReceiverKt.access$getKEY_AUTH_RESULT$p());
                AuthStatusListener authStatusListener = this.a;
                Intrinsics.checkNotNullExpressionValue(userCredentials, "credentials");
                Intrinsics.checkNotNullExpressionValue(authResult, "result");
                authStatusListener.onLoginSuccess(userCredentials, authResult);
            } else if (Intrinsics.areEqual(action, AuthStatusReceiverKt.access$getACTION_LOGIN_FAILURE$p())) {
                Serializable serializableExtra = intent.getSerializableExtra(AuthStatusReceiverKt.access$getKEY_EXCEPTION$p());
                Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type kotlin.Throwable");
                this.a.onLoginFailure((Throwable) serializableExtra);
            } else if (Intrinsics.areEqual(action, AuthStatusReceiverKt.access$getACTION_LOGOUT_SUCCESS$p())) {
                this.a.onLogoutSuccess(intent.getBooleanExtra(AuthStatusReceiverKt.access$getKEY_IS_USER_ACTION$p(), false));
            } else if (Intrinsics.areEqual(action, AuthStatusReceiverKt.access$getACTION_LOGOUT_FAILURE$p())) {
                Serializable serializableExtra2 = intent.getSerializableExtra(AuthStatusReceiverKt.access$getKEY_EXCEPTION$p());
                Objects.requireNonNull(serializableExtra2, "null cannot be cast to non-null type kotlin.Throwable");
                this.a.onLogoutFailure((Throwable) serializableExtra2);
            }
        }
    }
}
