package com.avito.android.publish.sts_scanner.di;

import com.avito.android.di.PerFragment;
import com.avito.android.photo_picker.legacy.di.CameraItemPresenterModule;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.sts_scanner.StsScannerFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/publish/sts_scanner/di/StsScannerComponent;", "", "Lcom/avito/android/publish/sts_scanner/StsScannerFragment;", "fragment", "", "inject", "(Lcom/avito/android/publish/sts_scanner/StsScannerFragment;)V", "Builder", "publish_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PublishComponent.class}, modules = {StsScannerModule.class, CameraItemPresenterModule.class})
@PerFragment
public interface StsScannerComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/publish/sts_scanner/di/StsScannerComponent$Builder;", "", "Lcom/avito/android/publish/di/PublishComponent;", "component", "publishComponent", "(Lcom/avito/android/publish/di/PublishComponent;)Lcom/avito/android/publish/sts_scanner/di/StsScannerComponent$Builder;", "Lcom/avito/android/publish/sts_scanner/di/StsScannerModule;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "stsScannerModule", "(Lcom/avito/android/publish/sts_scanner/di/StsScannerModule;)Lcom/avito/android/publish/sts_scanner/di/StsScannerComponent$Builder;", "Lcom/avito/android/photo_picker/legacy/di/CameraItemPresenterModule;", "cameraPresenterModule", "(Lcom/avito/android/photo_picker/legacy/di/CameraItemPresenterModule;)Lcom/avito/android/publish/sts_scanner/di/StsScannerComponent$Builder;", "Lcom/avito/android/publish/sts_scanner/di/StsScannerComponent;", "build", "()Lcom/avito/android/publish/sts_scanner/di/StsScannerComponent;", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        StsScannerComponent build();

        @NotNull
        Builder cameraPresenterModule(@NotNull CameraItemPresenterModule cameraItemPresenterModule);

        @NotNull
        Builder publishComponent(@NotNull PublishComponent publishComponent);

        @NotNull
        Builder stsScannerModule(@NotNull StsScannerModule stsScannerModule);
    }

    void inject(@NotNull StsScannerFragment stsScannerFragment);
}
