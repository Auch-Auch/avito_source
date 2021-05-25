package com.avito.android.publish.di;

import android.app.Activity;
import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.di.PerActivity;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.publish.PublishActivity;
import com.avito.android.publish.category_suggest.di.CategoriesSuggestionsDependencies;
import com.avito.android.publish.details.di.PublishDetailsDependencies;
import com.avito.android.publish.drafts.di.PublishDraftsAnalyticsModule;
import com.avito.android.publish.infomodel_request.di.InfomodelRequestDependencies;
import com.avito.android.publish.input_vin.di.InputVinDependencies;
import com.avito.android.publish.sts_scanner.di.StsScannerDependencies;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001\u000bJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/publish/di/PublishComponent;", "Lcom/avito/android/publish/sts_scanner/di/StsScannerDependencies;", "Lcom/avito/android/publish/input_vin/di/InputVinDependencies;", "Lcom/avito/android/publish/details/di/PublishDetailsDependencies;", "Lcom/avito/android/publish/category_suggest/di/CategoriesSuggestionsDependencies;", "Lcom/avito/android/publish/infomodel_request/di/InfomodelRequestDependencies;", "Lcom/avito/android/publish/PublishActivity;", "activity", "", "inject", "(Lcom/avito/android/publish/PublishActivity;)V", "Builder", "publish_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PublishDependencies.class, LocationDependencies.class}, modules = {PublishModule.class, PublishDraftsAnalyticsModule.class})
@PerActivity
public interface PublishComponent extends StsScannerDependencies, InputVinDependencies, PublishDetailsDependencies, CategoriesSuggestionsDependencies, InfomodelRequestDependencies {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0014H'¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/publish/di/PublishComponent$Builder;", "", "Lcom/avito/android/publish/di/PublishDependencies;", "publishDependencies", "(Lcom/avito/android/publish/di/PublishDependencies;)Lcom/avito/android/publish/di/PublishComponent$Builder;", "Lcom/avito/android/location/di/LocationDependencies;", "locationDependencies", "(Lcom/avito/android/location/di/LocationDependencies;)Lcom/avito/android/publish/di/PublishComponent$Builder;", "Lcom/avito/android/publish/di/PublishModule;", "publishModule", "(Lcom/avito/android/publish/di/PublishModule;)Lcom/avito/android/publish/di/PublishComponent$Builder;", "Lcom/avito/android/publish/di/PublishParametersModule;", "publishParametersModule", "(Lcom/avito/android/publish/di/PublishParametersModule;)Lcom/avito/android/publish/di/PublishComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/publish/di/PublishComponent$Builder;", "Landroid/app/Activity;", "activity", "(Landroid/app/Activity;)Lcom/avito/android/publish/di/PublishComponent$Builder;", "Landroidx/fragment/app/FragmentActivity;", "fragmentActivity", "(Landroidx/fragment/app/FragmentActivity;)Lcom/avito/android/publish/di/PublishComponent$Builder;", "Lcom/avito/android/publish/di/PublishComponent;", "build", "()Lcom/avito/android/publish/di/PublishComponent;", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder activity(@NotNull Activity activity);

        @NotNull
        PublishComponent build();

        @BindsInstance
        @NotNull
        Builder fragmentActivity(@NotNull FragmentActivity fragmentActivity);

        @NotNull
        Builder locationDependencies(@NotNull LocationDependencies locationDependencies);

        @NotNull
        Builder publishDependencies(@NotNull PublishDependencies publishDependencies);

        @NotNull
        Builder publishModule(@NotNull PublishModule publishModule);

        @NotNull
        Builder publishParametersModule(@NotNull PublishParametersModule publishParametersModule);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);
    }

    void inject(@NotNull PublishActivity publishActivity);
}
