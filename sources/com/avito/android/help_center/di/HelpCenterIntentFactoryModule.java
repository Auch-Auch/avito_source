package com.avito.android.help_center.di;

import com.avito.android.HelpCenterIntentFactory;
import com.avito.android.help_center.HelpCenterIntentFactoryImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/help_center/di/HelpCenterIntentFactoryModule;", "", "Lcom/avito/android/help_center/HelpCenterIntentFactoryImpl;", "factory", "Lcom/avito/android/HelpCenterIntentFactory;", "bindHelpCenterIntentFactory", "(Lcom/avito/android/help_center/HelpCenterIntentFactoryImpl;)Lcom/avito/android/HelpCenterIntentFactory;", "help-center_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface HelpCenterIntentFactoryModule {
    @Binds
    @NotNull
    HelpCenterIntentFactory bindHelpCenterIntentFactory(@NotNull HelpCenterIntentFactoryImpl helpCenterIntentFactoryImpl);
}
