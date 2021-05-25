package com.avito.android.brandspace.di;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.brandspace.view.BrandspaceFragment;
import com.avito.android.brandspace.view.FragmentDelegate;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.ScreenAnalyticsDependencies;
import com.avito.android.fps.di.FpsModule;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/brandspace/di/BrandspaceFragmentComponent;", "", "Lcom/avito/android/brandspace/view/BrandspaceFragment;", "fragment", "", "inject", "(Lcom/avito/android/brandspace/view/BrandspaceFragment;)V", "Builder", "brandspace_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {BrandspaceFragmentDependencies.class, ScreenAnalyticsDependencies.class}, modules = {BrandspaceFragmentModule.class, FpsModule.class})
@PerFragment
public interface BrandspaceFragmentComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00002\b\b\u0001\u0010\u0013\u001a\u00020\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0017\u001a\u00020\u00002\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0012H'¢\u0006\u0004\b\u0017\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cH'¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\"\u001a\u00020\u00002\n\b\u0001\u0010!\u001a\u0004\u0018\u00010 H'¢\u0006\u0004\b\"\u0010#J\u001b\u0010&\u001a\u00020\u00002\n\b\u0001\u0010%\u001a\u0004\u0018\u00010$H'¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H&¢\u0006\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/avito/android/brandspace/di/BrandspaceFragmentComponent$Builder;", "", "Lcom/avito/android/brandspace/di/BrandspaceFragmentDependencies;", "brandspaceDependencies", "withBrandspaceDependencies", "(Lcom/avito/android/brandspace/di/BrandspaceFragmentDependencies;)Lcom/avito/android/brandspace/di/BrandspaceFragmentComponent$Builder;", "Lcom/avito/android/di/module/ScreenAnalyticsDependencies;", "dependencies", "withScreenAnalyticsDependencies", "(Lcom/avito/android/di/module/ScreenAnalyticsDependencies;)Lcom/avito/android/brandspace/di/BrandspaceFragmentComponent$Builder;", "Landroid/content/Context;", "context", "withViewContext", "(Landroid/content/Context;)Lcom/avito/android/brandspace/di/BrandspaceFragmentComponent$Builder;", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "withScreen", "(Lcom/avito/android/analytics/screens/Screen;)Lcom/avito/android/brandspace/di/BrandspaceFragmentComponent$Builder;", "", "brandspaceId", "withBrandspaceId", "(Ljava/lang/String;)Lcom/avito/android/brandspace/di/BrandspaceFragmentComponent$Builder;", "brandspaceSource", "withBrandspaceSource", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/brandspace/di/BrandspaceFragmentComponent$Builder;", "Lcom/avito/android/brandspace/view/FragmentDelegate;", "fragmentDelegate", "withFragmentDelegate", "(Lcom/avito/android/brandspace/view/FragmentDelegate;)Lcom/avito/android/brandspace/di/BrandspaceFragmentComponent$Builder;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "withInitialTreeParent", "(Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)Lcom/avito/android/brandspace/di/BrandspaceFragmentComponent$Builder;", "Landroid/os/Bundle;", "visibilityTrackerState", "withItemVisibilityTrackerState", "(Landroid/os/Bundle;)Lcom/avito/android/brandspace/di/BrandspaceFragmentComponent$Builder;", "Lcom/avito/android/brandspace/di/BrandspaceFragmentComponent;", "build", "()Lcom/avito/android/brandspace/di/BrandspaceFragmentComponent;", "brandspace_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        BrandspaceFragmentComponent build();

        @NotNull
        Builder withBrandspaceDependencies(@NotNull BrandspaceFragmentDependencies brandspaceFragmentDependencies);

        @BindsInstance
        @NotNull
        Builder withBrandspaceId(@BrandspaceId @NotNull String str);

        @BindsInstance
        @NotNull
        Builder withBrandspaceSource(@BrandspaceSourceAnnotation @Nullable String str);

        @BindsInstance
        @NotNull
        Builder withFragmentDelegate(@NotNull FragmentDelegate fragmentDelegate);

        @BindsInstance
        @NotNull
        Builder withInitialTreeParent(@BrandspaceInitialTreeParent @Nullable TreeClickStreamParent treeClickStreamParent);

        @BindsInstance
        @NotNull
        Builder withItemVisibilityTrackerState(@BrandspaceItemVisibilityTrackerState @Nullable Bundle bundle);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder withScreen(@NotNull Screen screen);

        @NotNull
        Builder withScreenAnalyticsDependencies(@NotNull ScreenAnalyticsDependencies screenAnalyticsDependencies);

        @BindsInstance
        @NotNull
        Builder withViewContext(@ViewContext @NotNull Context context);
    }

    void inject(@NotNull BrandspaceFragment brandspaceFragment);
}
