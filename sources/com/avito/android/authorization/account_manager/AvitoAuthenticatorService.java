package com.avito.android.authorization.account_manager;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.avito.android.authorization.account_manager.di.AvitoAuthenticatorDependencies;
import com.avito.android.authorization.account_manager.di.DaggerAvitoAuthenticatorComponent;
import com.avito.android.di.ComponentDependenciesKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/avito/android/authorization/account_manager/AvitoAuthenticatorService;", "Landroid/app/Service;", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "", "onCreate", "()V", "Lcom/avito/android/authorization/account_manager/AvitoAccountAuthenticator;", "authenticator", "Lcom/avito/android/authorization/account_manager/AvitoAccountAuthenticator;", "getAuthenticator", "()Lcom/avito/android/authorization/account_manager/AvitoAccountAuthenticator;", "setAuthenticator", "(Lcom/avito/android/authorization/account_manager/AvitoAccountAuthenticator;)V", "<init>", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoAuthenticatorService extends Service {
    @Inject
    public AvitoAccountAuthenticator authenticator;

    @NotNull
    public final AvitoAccountAuthenticator getAuthenticator() {
        AvitoAccountAuthenticator avitoAccountAuthenticator = this.authenticator;
        if (avitoAccountAuthenticator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authenticator");
        }
        return avitoAccountAuthenticator;
    }

    @Override // android.app.Service
    @NotNull
    public IBinder onBind(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        AvitoAccountAuthenticator avitoAccountAuthenticator = this.authenticator;
        if (avitoAccountAuthenticator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authenticator");
        }
        IBinder iBinder = avitoAccountAuthenticator.getIBinder();
        Intrinsics.checkNotNullExpressionValue(iBinder, "authenticator.iBinder");
        return iBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        DaggerAvitoAuthenticatorComponent.builder().dependentOn((AvitoAuthenticatorDependencies) ComponentDependenciesKt.getDependencies(AvitoAuthenticatorDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Service) this))).with(this).build().inject(this);
    }

    public final void setAuthenticator(@NotNull AvitoAccountAuthenticator avitoAccountAuthenticator) {
        Intrinsics.checkNotNullParameter(avitoAccountAuthenticator, "<set-?>");
        this.authenticator = avitoAccountAuthenticator;
    }
}
