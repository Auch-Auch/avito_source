package com.avito.android.hints.di;

import com.avito.android.di.PerFragment;
import com.avito.android.hints.items.HintItemBlueprint;
import com.avito.android.hints.items.HintItemPresenter;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/hints/di/ListModule;", "", "Lcom/avito/android/hints/items/HintItemPresenter;", "hintItemPresenter", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "provideHintPresenter", "(Lcom/avito/android/hints/items/HintItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/hints/items/HintItemBlueprint;", "hintItemBlueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideHintBlueprint", "(Lcom/avito/android/hints/items/HintItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "hints_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class})
public interface ListModule {
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> provideHintBlueprint(@NotNull HintItemBlueprint hintItemBlueprint);

    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemPresenter<?, ?> provideHintPresenter(@NotNull HintItemPresenter hintItemPresenter);
}
