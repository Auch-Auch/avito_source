package com.avito.android.di.component;

import androidx.core.app.NotificationCompat;
import com.avito.android.di.PerService;
import com.avito.android.di.module.ImageUploadServiceModule;
import com.avito.android.photo_picker.legacy.service.ImageUploadService;
import com.google.gson.Gson;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/di/component/ImageUploadServiceComponent;", "", "Lcom/avito/android/photo_picker/legacy/service/ImageUploadService;", NotificationCompat.CATEGORY_SERVICE, "", "inject", "(Lcom/avito/android/photo_picker/legacy/service/ImageUploadService;)V", "Builder", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
@PerService
@Component(dependencies = {ImageUploadServiceDependencies.class}, modules = {ImageUploadServiceModule.class})
public interface ImageUploadServiceComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/di/component/ImageUploadServiceComponent$Builder;", "", "Lcom/avito/android/di/component/ImageUploadServiceDependencies;", "dependencies", "(Lcom/avito/android/di/component/ImageUploadServiceDependencies;)Lcom/avito/android/di/component/ImageUploadServiceComponent$Builder;", "Lcom/avito/android/di/module/ImageUploadServiceModule;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "(Lcom/avito/android/di/module/ImageUploadServiceModule;)Lcom/avito/android/di/component/ImageUploadServiceComponent$Builder;", "Lcom/avito/android/di/component/ImageUploadServiceComponent;", "build", "()Lcom/avito/android/di/component/ImageUploadServiceComponent;", "Lcom/google/gson/Gson;", "gson", "withGson", "(Lcom/google/gson/Gson;)Lcom/avito/android/di/component/ImageUploadServiceComponent$Builder;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        ImageUploadServiceComponent build();

        @NotNull
        Builder dependencies(@NotNull ImageUploadServiceDependencies imageUploadServiceDependencies);

        @NotNull
        Builder module(@NotNull ImageUploadServiceModule imageUploadServiceModule);

        @BindsInstance
        @NotNull
        Builder withGson(@NotNull Gson gson);
    }

    void inject(@NotNull ImageUploadService imageUploadService);
}
