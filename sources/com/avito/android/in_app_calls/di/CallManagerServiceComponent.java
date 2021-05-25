package com.avito.android.in_app_calls.di;

import android.app.Service;
import androidx.core.app.NotificationCompat;
import com.avito.android.di.PerService;
import com.avito.android.in_app_calls.service.CallManagerService;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/in_app_calls/di/CallManagerServiceComponent;", "", "Lcom/avito/android/in_app_calls/service/CallManagerService;", NotificationCompat.CATEGORY_SERVICE, "", "inject", "(Lcom/avito/android/in_app_calls/service/CallManagerService;)V", "CallManagerServiceComponentFactory", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
@PerService
@Component(dependencies = {CallManagerServiceComponentDependencies.class}, modules = {CallManagerServiceModule.class})
public interface CallManagerServiceComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/in_app_calls/di/CallManagerServiceComponent$CallManagerServiceComponentFactory;", "", "Landroid/app/Service;", NotificationCompat.CATEGORY_SERVICE, "Lcom/avito/android/in_app_calls/di/CallManagerServiceComponentDependencies;", "dependencies", "Lcom/avito/android/in_app_calls/di/CallManagerServiceComponent;", "create", "(Landroid/app/Service;Lcom/avito/android/in_app_calls/di/CallManagerServiceComponentDependencies;)Lcom/avito/android/in_app_calls/di/CallManagerServiceComponent;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface CallManagerServiceComponentFactory {
        @NotNull
        CallManagerServiceComponent create(@BindsInstance @NotNull Service service, @NotNull CallManagerServiceComponentDependencies callManagerServiceComponentDependencies);
    }

    void inject(@NotNull CallManagerService callManagerService);
}
