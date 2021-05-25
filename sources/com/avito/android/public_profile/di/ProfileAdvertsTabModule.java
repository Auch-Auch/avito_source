package com.avito.android.public_profile.di;

import com.avito.android.design.widget.tab.TabBlueprint;
import com.avito.android.di.PerFragment;
import com.avito.android.public_profile.ProfileAdvertsTabBlueprint;
import com.avito.android.ui.adapter.tab.BaseTabItem;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/public_profile/di/ProfileAdvertsTabModule;", "", "Lcom/avito/android/public_profile/ProfileAdvertsTabBlueprint;", "blueprint", "Lcom/avito/android/design/widget/tab/TabBlueprint;", "Lcom/avito/android/ui/adapter/tab/BaseTabItem;", "bindTabBlueprint", "(Lcom/avito/android/public_profile/ProfileAdvertsTabBlueprint;)Lcom/avito/android/design/widget/tab/TabBlueprint;", "public-profile_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface ProfileAdvertsTabModule {
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    TabBlueprint<? extends BaseTabItem> bindTabBlueprint(@NotNull ProfileAdvertsTabBlueprint profileAdvertsTabBlueprint);
}
