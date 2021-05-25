package com.avito.android.publish.objects.di;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.avito.android.di.PerFragment;
import com.avito.android.publish.details.di.PublishDetailsViewModule;
import com.avito.android.publish.di.PublishDependencies;
import com.avito.android.publish.objects.FillObjectsFragment;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.category_parameters.ObjectsParameter;
import com.avito.android.validation.ParametersListModule;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Named;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u00072\u00020\u0001:\u0002\b\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/publish/objects/di/ObjectsEditComponent;", "", "Lcom/avito/android/publish/objects/FillObjectsFragment;", "fragment", "", "inject", "(Lcom/avito/android/publish/objects/FillObjectsFragment;)V", "Companion", "Builder", "publish_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PublishDependencies.class}, modules = {ObjectsEditModule.class, PublishDetailsViewModule.class})
@PerFragment
public interface ObjectsEditComponent {
    @NotNull
    public static final Companion Companion = Companion.a;
    @NotNull
    public static final String NAVIGATION = "navigation";
    @NotNull
    public static final String OBJECT_INDEX = "object_index";
    @NotNull
    public static final String PARAMETER = "parameter";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00002\b\b\u0001\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\u00002\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0011H'¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00002\b\b\u0001\u0010\u0015\u001a\u00020\u0011H'¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H&¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/avito/android/publish/objects/di/ObjectsEditComponent$Builder;", "", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/publish/objects/di/ObjectsEditComponent$Builder;", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/publish/objects/di/ObjectsEditComponent$Builder;", "Lcom/avito/android/remote/model/Navigation;", "navigation", "withNavigation", "(Lcom/avito/android/remote/model/Navigation;)Lcom/avito/android/publish/objects/di/ObjectsEditComponent$Builder;", "Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;", "parameter", "withParameter", "(Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;)Lcom/avito/android/publish/objects/di/ObjectsEditComponent$Builder;", "", "objectIndex", "withObjectsIndex", "(Ljava/lang/Integer;)Lcom/avito/android/publish/objects/di/ObjectsEditComponent$Builder;", "minValuesForSearch", "withMinValuesForSearch", "(I)Lcom/avito/android/publish/objects/di/ObjectsEditComponent$Builder;", "Landroid/os/Bundle;", "interactorState", "withInteractorState", "(Landroid/os/Bundle;)Lcom/avito/android/publish/objects/di/ObjectsEditComponent$Builder;", "Lcom/avito/android/publish/di/PublishDependencies;", "publishDependencies", "(Lcom/avito/android/publish/di/PublishDependencies;)Lcom/avito/android/publish/objects/di/ObjectsEditComponent$Builder;", "Lcom/avito/android/validation/ParametersListModule;", "parametersListModule", "(Lcom/avito/android/validation/ParametersListModule;)Lcom/avito/android/publish/objects/di/ObjectsEditComponent$Builder;", "Lcom/avito/android/publish/objects/di/ObjectsEditComponent;", "build", "()Lcom/avito/android/publish/objects/di/ObjectsEditComponent;", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        ObjectsEditComponent build();

        @NotNull
        Builder parametersListModule(@NotNull ParametersListModule parametersListModule);

        @NotNull
        Builder publishDependencies(@NotNull PublishDependencies publishDependencies);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder withActivity(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder withInteractorState(@Nullable Bundle bundle);

        @BindsInstance
        @NotNull
        Builder withMinValuesForSearch(@Named("min_values_for_search") int i);

        @BindsInstance
        @NotNull
        Builder withNavigation(@Named("navigation") @NotNull Navigation navigation);

        @BindsInstance
        @NotNull
        Builder withObjectsIndex(@Named("object_index") @Nullable Integer num);

        @BindsInstance
        @NotNull
        Builder withParameter(@Named("parameter") @NotNull ObjectsParameter objectsParameter);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/avito/android/publish/objects/di/ObjectsEditComponent$Companion;", "", "", "NAVIGATION", "Ljava/lang/String;", "PARAMETER", "OBJECT_INDEX", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        @NotNull
        public static final String NAVIGATION = "navigation";
        @NotNull
        public static final String OBJECT_INDEX = "object_index";
        @NotNull
        public static final String PARAMETER = "parameter";
        public static final /* synthetic */ Companion a = new Companion();
    }

    void inject(@NotNull FillObjectsFragment fillObjectsFragment);
}
