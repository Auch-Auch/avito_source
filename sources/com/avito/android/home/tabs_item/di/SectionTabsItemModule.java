package com.avito.android.home.tabs_item.di;

import com.avito.android.di.PerFragment;
import com.avito.android.home.tabs_item.SectionTabsItemBlueprint;
import com.avito.android.home.tabs_item.SectionTabsItemPresenter;
import com.avito.android.home.tabs_item.SectionTabsItemPresenterImpl;
import com.avito.android.home.tabs_item.skeleton.SkeletonPresenter;
import com.avito.android.home.tabs_item.skeleton.SkeletonPresenterImpl;
import com.avito.android.util.preferences.Preferences;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/home/tabs_item/di/SectionTabsItemModule;", "", "Lcom/avito/android/home/tabs_item/SectionTabsItemPresenter;", "sectionTabsItemPresenter", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "Lcom/avito/android/home/tabs_item/SectionTabsItemBlueprint;", "provideSectionTabsItemBlueprint", "(Lcom/avito/android/home/tabs_item/SectionTabsItemPresenter;Lcom/avito/android/util/preferences/Preferences;)Lcom/avito/android/home/tabs_item/SectionTabsItemBlueprint;", "provideSectionTabsItemPresenter", "()Lcom/avito/android/home/tabs_item/SectionTabsItemPresenter;", "Lcom/avito/android/home/tabs_item/skeleton/SkeletonPresenter;", "provideSkeletonSectionTabsItemPresenter", "()Lcom/avito/android/home/tabs_item/skeleton/SkeletonPresenter;", "<init>", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class SectionTabsItemModule {
    @Provides
    @PerFragment
    @NotNull
    public final SectionTabsItemBlueprint provideSectionTabsItemBlueprint(@NotNull SectionTabsItemPresenter sectionTabsItemPresenter, @NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(sectionTabsItemPresenter, "sectionTabsItemPresenter");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        return new SectionTabsItemBlueprint(sectionTabsItemPresenter, preferences);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SectionTabsItemPresenter provideSectionTabsItemPresenter() {
        return new SectionTabsItemPresenterImpl();
    }

    @Provides
    @PerFragment
    @NotNull
    public final SkeletonPresenter provideSkeletonSectionTabsItemPresenter() {
        return new SkeletonPresenterImpl();
    }
}
