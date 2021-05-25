package com.avito.android.developments_catalog.di;

import android.app.Activity;
import com.avito.android.developments_catalog.DevelopmentsCatalogFragment;
import com.avito.android.developments_catalog.DevelopmentsCatalogFragmentManagerDelegate;
import com.avito.android.di.PerFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/developments_catalog/di/DevelopmentsCatalogComponent;", "", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogFragment;", "activity", "", "inject", "(Lcom/avito/android/developments_catalog/DevelopmentsCatalogFragment;)V", "Builder", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {DevelopmentsCatalogDependencies.class}, modules = {DevelopmentsCatalogModule.class, DevelopmentsCatalogTrackerModule.class})
@PerFragment
public interface DevelopmentsCatalogComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\u00002\b\b\u0001\u0010\r\u001a\u00020\tH'¢\u0006\u0004\b\u000e\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b\u0010\u0010\fJ\u0019\u0010\u0012\u001a\u00020\u00002\b\b\u0001\u0010\u0011\u001a\u00020\tH'¢\u0006\u0004\b\u0012\u0010\fJ\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/developments_catalog/di/DevelopmentsCatalogComponent$Builder;", "", "Lcom/avito/android/developments_catalog/di/DevelopmentsCatalogDependencies;", "developmentsCatalogDependencies", "(Lcom/avito/android/developments_catalog/di/DevelopmentsCatalogDependencies;)Lcom/avito/android/developments_catalog/di/DevelopmentsCatalogComponent$Builder;", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/developments_catalog/di/DevelopmentsCatalogComponent$Builder;", "", "itemId", "withDevelopmentsId", "(Ljava/lang/String;)Lcom/avito/android/developments_catalog/di/DevelopmentsCatalogComponent$Builder;", "title", "withDevelopmentsTitle", "searchContext", "withSearchContext", "fromPage", "withFromPage", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogFragmentManagerDelegate;", "fragmentDelegate", "withFragmentManagerDelegate", "(Lcom/avito/android/developments_catalog/DevelopmentsCatalogFragmentManagerDelegate;)Lcom/avito/android/developments_catalog/di/DevelopmentsCatalogComponent$Builder;", "Lcom/avito/android/developments_catalog/di/DevelopmentsCatalogComponent;", "build", "()Lcom/avito/android/developments_catalog/di/DevelopmentsCatalogComponent;", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        DevelopmentsCatalogComponent build();

        @NotNull
        Builder developmentsCatalogDependencies(@NotNull DevelopmentsCatalogDependencies developmentsCatalogDependencies);

        @BindsInstance
        @NotNull
        Builder withActivity(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder withDevelopmentsId(@DevelopmentId @NotNull String str);

        @BindsInstance
        @NotNull
        Builder withDevelopmentsTitle(@DevelopmentTitle @NotNull String str);

        @BindsInstance
        @NotNull
        Builder withFragmentManagerDelegate(@NotNull DevelopmentsCatalogFragmentManagerDelegate developmentsCatalogFragmentManagerDelegate);

        @BindsInstance
        @NotNull
        Builder withFromPage(@FromPage @NotNull String str);

        @BindsInstance
        @NotNull
        Builder withSearchContext(@Nullable String str);
    }

    void inject(@NotNull DevelopmentsCatalogFragment developmentsCatalogFragment);
}
