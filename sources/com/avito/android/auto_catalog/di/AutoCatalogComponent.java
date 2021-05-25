package com.avito.android.auto_catalog.di;

import android.content.res.Resources;
import com.avito.android.auto_catalog.AutoCatalogData;
import com.avito.android.auto_catalog.AutoCatalogFragment;
import com.avito.android.auto_catalog.di.AutoCatalogModule;
import com.avito.android.di.PerFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/auto_catalog/di/AutoCatalogComponent;", "", "Lcom/avito/android/auto_catalog/AutoCatalogFragment;", "fragment", "", "inject", "(Lcom/avito/android/auto_catalog/AutoCatalogFragment;)V", "Builder", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {AutoCatalogDependencies.class}, modules = {AutoCatalogModule.class, AutoCatalogTrackerModule.class})
@PerFragment
public interface AutoCatalogComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\u00002\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000e\u001a\u00020\u00002\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/auto_catalog/di/AutoCatalogComponent$Builder;", "", "Lcom/avito/android/auto_catalog/di/AutoCatalogDependencies;", "autoCatalogDependencies", "(Lcom/avito/android/auto_catalog/di/AutoCatalogDependencies;)Lcom/avito/android/auto_catalog/di/AutoCatalogComponent$Builder;", "Lcom/avito/android/auto_catalog/AutoCatalogData;", "data", "withAutoCatalogData", "(Lcom/avito/android/auto_catalog/AutoCatalogData;)Lcom/avito/android/auto_catalog/di/AutoCatalogComponent$Builder;", "", "searchContext", "withSearchContext", "(Ljava/lang/String;)Lcom/avito/android/auto_catalog/di/AutoCatalogComponent$Builder;", "from", "withFromScreen", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/auto_catalog/di/AutoCatalogComponent$Builder;", "Lcom/avito/android/auto_catalog/di/AutoCatalogComponent;", "build", "()Lcom/avito/android/auto_catalog/di/AutoCatalogComponent;", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        Builder autoCatalogDependencies(@NotNull AutoCatalogDependencies autoCatalogDependencies);

        @NotNull
        AutoCatalogComponent build();

        @BindsInstance
        @NotNull
        Builder withAutoCatalogData(@NotNull AutoCatalogData autoCatalogData);

        @BindsInstance
        @NotNull
        Builder withFromScreen(@AutoCatalogModule.FromScreen @Nullable String str);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder withSearchContext(@AutoCatalogModule.SearchContext @Nullable String str);
    }

    void inject(@NotNull AutoCatalogFragment autoCatalogFragment);
}
