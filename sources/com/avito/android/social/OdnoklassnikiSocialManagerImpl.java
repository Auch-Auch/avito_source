package com.avito.android.social;

import a2.b.a.a.a;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.social.OdnoklassnikiSocialManager;
import com.avito.android.social.SharingManager;
import com.avito.android.social.SignInManager;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import ru.ok.android.sdk.Odnoklassniki;
import ru.ok.android.sdk.OkListener;
import ru.ok.android.sdk.R;
import ru.ok.android.sdk.util.OkAuthType;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J?\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J5\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u000e2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001d¨\u0006)"}, d2 = {"Lcom/avito/android/social/OdnoklassnikiSocialManagerImpl;", "Lcom/avito/android/social/OdnoklassnikiSocialManager;", "", "request", "result", "Landroid/content/Intent;", "data", "Lkotlin/Function1;", "Lcom/avito/android/social/SignInManager$Result;", "", "callback", "", "handleActivityResult", "(IILandroid/content/Intent;Lkotlin/jvm/functions/Function1;)Z", "", "getToken", "()Ljava/lang/String;", "Landroid/app/Activity;", "activity", "login", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function1;)V", "logout", "()V", "link", "Lcom/avito/android/social/SharingManager$ShareError;", "errorListener", "share", "(Landroid/app/Activity;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "c", "Ljava/lang/String;", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "Lru/ok/android/sdk/Odnoklassniki;", AuthSource.SEND_ABUSE, "Lru/ok/android/sdk/Odnoklassniki;", "odnoklassniki", AuthSource.BOOKING_ORDER, "errorName", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "social_release"}, k = 1, mv = {1, 4, 2})
public final class OdnoklassnikiSocialManagerImpl implements OdnoklassnikiSocialManager {
    public final Odnoklassniki a;
    public final String b;
    public String c;

    @Inject
    public OdnoklassnikiSocialManagerImpl(@NotNull Context context) {
        Odnoklassniki odnoklassniki;
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.authorization_canceled);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(ru.ok.…g.authorization_canceled)");
        this.b = string;
        if (Odnoklassniki.hasInstance()) {
            odnoklassniki = Odnoklassniki.getInstance();
            Intrinsics.checkNotNullExpressionValue(odnoklassniki, "Odnoklassniki.getInstance()");
        } else {
            odnoklassniki = Odnoklassniki.createInstance(context.getApplicationContext(), context.getString(R.string.okAppId), context.getString(R.string.okAppKey));
            Intrinsics.checkNotNullExpressionValue(odnoklassniki, "Odnoklassniki.createInst…g.okAppKey)\n            )");
        }
        this.a = odnoklassniki;
        odnoklassniki.checkValidTokens(new OkListener() { // from class: com.avito.android.social.OdnoklassnikiSocialManagerImpl$tryReadTokenFromCache$1
            @Override // ru.ok.android.sdk.OkListener
            public void onError(@Nullable String str) {
            }

            @Override // ru.ok.android.sdk.OkListener
            public void onSuccess(@NotNull JSONObject jSONObject) {
                Intrinsics.checkNotNullParameter(jSONObject, "json");
                OdnoklassnikiSocialManagerImpl odnoklassnikiSocialManagerImpl = OdnoklassnikiSocialManagerImpl.this;
                odnoklassnikiSocialManagerImpl.c = OdnoklassnikiSocialManagerImpl.access$parseToken(odnoklassnikiSocialManagerImpl, jSONObject);
            }
        });
    }

    public static final String access$parseToken(OdnoklassnikiSocialManagerImpl odnoklassnikiSocialManagerImpl, JSONObject jSONObject) {
        Objects.requireNonNull(odnoklassnikiSocialManagerImpl);
        return jSONObject.optString("access_token", null);
    }

    @Override // com.avito.android.social.SignInManager
    @Nullable
    public String getEmail() {
        return OdnoklassnikiSocialManager.DefaultImpls.getEmail(this);
    }

    @Override // com.avito.android.social.SignInManager
    @Nullable
    public String getToken() {
        return this.c;
    }

    @Override // com.avito.android.social.OdnoklassnikiSocialManager, com.avito.android.social.IsSocialNetwork
    @NotNull
    public SocialType getType() {
        return OdnoklassnikiSocialManager.DefaultImpls.getType(this);
    }

    @Override // com.avito.android.social.SignInManager
    public boolean handleActivityResult(int i, int i2, @Nullable Intent intent, @Nullable Function1<? super SignInManager.Result, Unit> function1) {
        OdnoklassnikiSocialManagerImpl$createOkListener$1 odnoklassnikiSocialManagerImpl$createOkListener$1 = new OkListener(function1) { // from class: com.avito.android.social.OdnoklassnikiSocialManagerImpl$createOkListener$1
            public final /* synthetic */ Function1 b;

            {
                this.b = r2;
            }

            @Override // ru.ok.android.sdk.OkListener
            public void onError(@Nullable String str) {
                if (Intrinsics.areEqual(str, OdnoklassnikiSocialManagerImpl.this.b)) {
                    Function1 function12 = this.b;
                    if (function12 != null) {
                        Unit unit = (Unit) function12.invoke(SignInManager.Result.Cancel.INSTANCE);
                        return;
                    }
                    return;
                }
                Function1 function13 = this.b;
                if (function13 != null) {
                    Unit unit2 = (Unit) function13.invoke(SignInManager.Result.Error.INSTANCE);
                }
            }

            @Override // ru.ok.android.sdk.OkListener
            public void onSuccess(@NotNull JSONObject jSONObject) {
                Intrinsics.checkNotNullParameter(jSONObject, "json");
                OdnoklassnikiSocialManagerImpl odnoklassnikiSocialManagerImpl = OdnoklassnikiSocialManagerImpl.this;
                odnoklassnikiSocialManagerImpl.c = OdnoklassnikiSocialManagerImpl.access$parseToken(odnoklassnikiSocialManagerImpl, jSONObject);
                Function1 function12 = this.b;
                if (function12 != null) {
                    Unit unit = (Unit) function12.invoke(SignInManager.Result.Success.INSTANCE);
                }
            }
        };
        if (this.a.isActivityRequestOAuth(i)) {
            return this.a.onAuthActivityResult(i, i2, intent, odnoklassnikiSocialManagerImpl$createOkListener$1);
        }
        return this.a.onActivityResultResult(i, i2, intent, odnoklassnikiSocialManagerImpl$createOkListener$1);
    }

    @Override // com.avito.android.social.SignInManager
    public boolean hasToken() {
        return OdnoklassnikiSocialManager.DefaultImpls.hasToken(this);
    }

    @Override // com.avito.android.social.SignInManager
    public void login(@NotNull Activity activity, @Nullable Function1<? super SignInManager.Result, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        logout();
        this.a.checkValidTokens(new OkListener(this, function1, activity) { // from class: com.avito.android.social.OdnoklassnikiSocialManagerImpl$login$1
            public final /* synthetic */ OdnoklassnikiSocialManagerImpl a;
            public final /* synthetic */ Function1 b;
            public final /* synthetic */ Activity c;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // ru.ok.android.sdk.OkListener
            public void onError(@Nullable String str) {
                this.a.a.requestAuthorization(this.c, "okauth://auth", OkAuthType.ANY, "GET_EMAIL");
            }

            @Override // ru.ok.android.sdk.OkListener
            public void onSuccess(@NotNull JSONObject jSONObject) {
                Intrinsics.checkNotNullParameter(jSONObject, "json");
                OdnoklassnikiSocialManagerImpl odnoklassnikiSocialManagerImpl = this.a;
                odnoklassnikiSocialManagerImpl.c = OdnoklassnikiSocialManagerImpl.access$parseToken(odnoklassnikiSocialManagerImpl, jSONObject);
                Function1 function12 = this.b;
                if (function12 != null) {
                    Unit unit = (Unit) function12.invoke(SignInManager.Result.Success.INSTANCE);
                }
            }
        });
    }

    @Override // com.avito.android.social.SignInManager
    public void logout() {
        this.c = null;
        this.a.clearTokens();
    }

    @Override // com.avito.android.social.SharingManager
    public void share(@NotNull Activity activity, @NotNull String str, @Nullable Function1<? super SharingManager.ShareError, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "link");
        this.a.performPosting(activity, a.e3("{\"media\":[{\"type\":\"link\",\"url\":\"", str, "\"}]}"), true, null);
    }

    @Override // com.avito.android.social.SharingManager
    public boolean shouldRestoreShare(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return OdnoklassnikiSocialManager.DefaultImpls.shouldRestoreShare(this, activity);
    }
}
