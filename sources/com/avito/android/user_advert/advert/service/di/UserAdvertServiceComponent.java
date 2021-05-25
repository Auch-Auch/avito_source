package com.avito.android.user_advert.advert.service.di;

import androidx.core.app.NotificationCompat;
import com.avito.android.notification_manager_provider.NotificationManagerModule;
import com.avito.android.user_advert.advert.service.UserAdvertService;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Component(dependencies = {UserAdvertServiceDependencies.class}, modules = {UserAdvertServiceModule.class, NotificationManagerModule.class})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/user_advert/advert/service/di/UserAdvertServiceComponent;", "", "Lcom/avito/android/user_advert/advert/service/UserAdvertService;", NotificationCompat.CATEGORY_SERVICE, "", "inject", "(Lcom/avito/android/user_advert/advert/service/UserAdvertService;)V", "Builder", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public interface UserAdvertServiceComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/user_advert/advert/service/di/UserAdvertServiceComponent$Builder;", "", "Lcom/avito/android/user_advert/advert/service/di/UserAdvertServiceDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/user_advert/advert/service/di/UserAdvertServiceDependencies;)Lcom/avito/android/user_advert/advert/service/di/UserAdvertServiceComponent$Builder;", "Lcom/avito/android/user_advert/advert/service/di/UserAdvertServiceComponent;", "build", "()Lcom/avito/android/user_advert/advert/service/di/UserAdvertServiceComponent;", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        UserAdvertServiceComponent build();

        @NotNull
        Builder dependentOn(@NotNull UserAdvertServiceDependencies userAdvertServiceDependencies);
    }

    void inject(@NotNull UserAdvertService userAdvertService);
}
