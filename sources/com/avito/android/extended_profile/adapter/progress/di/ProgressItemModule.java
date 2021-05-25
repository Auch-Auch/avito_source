package com.avito.android.extended_profile.adapter.progress.di;

import com.avito.android.di.PerFragment;
import com.avito.android.extended_profile.adapter.progress.ProgressItemBlueprint;
import com.avito.android.extended_profile.adapter.progress.ProgressItemPresenter;
import com.avito.android.extended_profile.adapter.progress.ProgressItemPresenterImpl;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/extended_profile/adapter/progress/di/ProgressItemModule;", "", "Lcom/avito/android/extended_profile/adapter/progress/ProgressItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindBlueprint", "(Lcom/avito/android/extended_profile/adapter/progress/ProgressItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/extended_profile/adapter/progress/ProgressItemPresenterImpl;", "presenter", "Lcom/avito/android/extended_profile/adapter/progress/ProgressItemPresenter;", "bindPresenter", "(Lcom/avito/android/extended_profile/adapter/progress/ProgressItemPresenterImpl;)Lcom/avito/android/extended_profile/adapter/progress/ProgressItemPresenter;", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface ProgressItemModule {
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> bindBlueprint(@NotNull ProgressItemBlueprint progressItemBlueprint);

    @PerFragment
    @Binds
    @NotNull
    ProgressItemPresenter bindPresenter(@NotNull ProgressItemPresenterImpl progressItemPresenterImpl);
}
