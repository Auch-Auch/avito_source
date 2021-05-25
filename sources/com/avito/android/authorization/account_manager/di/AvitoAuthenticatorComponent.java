package com.avito.android.authorization.account_manager.di;

import android.app.Service;
import androidx.core.app.NotificationCompat;
import com.avito.android.authorization.account_manager.AvitoAuthenticatorService;
import com.avito.android.di.PerService;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/authorization/account_manager/di/AvitoAuthenticatorComponent;", "", "Lcom/avito/android/authorization/account_manager/AvitoAuthenticatorService;", "activity", "", "inject", "(Lcom/avito/android/authorization/account_manager/AvitoAuthenticatorService;)V", "Builder", "authorization_release"}, k = 1, mv = {1, 4, 2})
@PerService
@Component(dependencies = {AvitoAuthenticatorDependencies.class}, modules = {AvitoAuthenticatorModule.class})
public interface AvitoAuthenticatorComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/authorization/account_manager/di/AvitoAuthenticatorComponent$Builder;", "", "Lcom/avito/android/authorization/account_manager/di/AvitoAuthenticatorDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/authorization/account_manager/di/AvitoAuthenticatorDependencies;)Lcom/avito/android/authorization/account_manager/di/AvitoAuthenticatorComponent$Builder;", "Landroid/app/Service;", NotificationCompat.CATEGORY_SERVICE, "with", "(Landroid/app/Service;)Lcom/avito/android/authorization/account_manager/di/AvitoAuthenticatorComponent$Builder;", "Lcom/avito/android/authorization/account_manager/di/AvitoAuthenticatorComponent;", "build", "()Lcom/avito/android/authorization/account_manager/di/AvitoAuthenticatorComponent;", "authorization_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        AvitoAuthenticatorComponent build();

        @NotNull
        Builder dependentOn(@NotNull AvitoAuthenticatorDependencies avitoAuthenticatorDependencies);

        @BindsInstance
        @NotNull
        Builder with(@NotNull Service service);
    }

    void inject(@NotNull AvitoAuthenticatorService avitoAuthenticatorService);
}
