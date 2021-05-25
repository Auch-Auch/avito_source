package com.avito.android.publish.publish_advert_request.di;

import android.content.res.Resources;
import com.avito.android.di.PerFragment;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.objects.di.ImageUploadModule;
import com.avito.android.publish.publish_advert_request.PublishAdvertRequestFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/publish/publish_advert_request/di/PublishAdvertRequestComponent;", "", "Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestFragment;", "fragment", "", "inject", "(Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestFragment;)V", "Builder", "publish_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PublishComponent.class}, modules = {PublishAdvertRequestModule.class, ImageUploadModule.class})
@PerFragment
public interface PublishAdvertRequestComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/publish/publish_advert_request/di/PublishAdvertRequestComponent$Builder;", "", "Lcom/avito/android/publish/di/PublishComponent;", "component", "publishComponent", "(Lcom/avito/android/publish/di/PublishComponent;)Lcom/avito/android/publish/publish_advert_request/di/PublishAdvertRequestComponent$Builder;", "Lcom/avito/android/publish/publish_advert_request/di/PublishAdvertRequestModule;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "publishAdvertRequestModule", "(Lcom/avito/android/publish/publish_advert_request/di/PublishAdvertRequestModule;)Lcom/avito/android/publish/publish_advert_request/di/PublishAdvertRequestComponent$Builder;", "Lcom/avito/android/publish/objects/di/ImageUploadModule;", "imageUploadModule", "(Lcom/avito/android/publish/objects/di/ImageUploadModule;)Lcom/avito/android/publish/publish_advert_request/di/PublishAdvertRequestComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/publish/publish_advert_request/di/PublishAdvertRequestComponent$Builder;", "Lcom/avito/android/publish/publish_advert_request/di/PublishAdvertRequestComponent;", "build", "()Lcom/avito/android/publish/publish_advert_request/di/PublishAdvertRequestComponent;", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        PublishAdvertRequestComponent build();

        @NotNull
        Builder imageUploadModule(@NotNull ImageUploadModule imageUploadModule);

        @NotNull
        Builder publishAdvertRequestModule(@NotNull PublishAdvertRequestModule publishAdvertRequestModule);

        @NotNull
        Builder publishComponent(@NotNull PublishComponent publishComponent);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);
    }

    void inject(@NotNull PublishAdvertRequestFragment publishAdvertRequestFragment);
}
