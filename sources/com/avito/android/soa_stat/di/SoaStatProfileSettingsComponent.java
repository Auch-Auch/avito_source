package com.avito.android.soa_stat.di;

import com.avito.android.di.PerActivity;
import com.avito.android.soa_stat.profile_settings.SoaStatProfileSettingsActivity;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/soa_stat/di/SoaStatProfileSettingsComponent;", "", "Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsActivity;", "activity", "", "inject", "(Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsActivity;)V", "Builder", "soa-stat_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {SoaStatProfileSettingsDependencies.class}, modules = {SoaStatProfileSettingsModule.class})
@PerActivity
public interface SoaStatProfileSettingsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/soa_stat/di/SoaStatProfileSettingsComponent$Builder;", "", "Lcom/avito/android/soa_stat/di/SoaStatProfileSettingsDependencies;", "dependencies", "soaStatDependencies", "(Lcom/avito/android/soa_stat/di/SoaStatProfileSettingsDependencies;)Lcom/avito/android/soa_stat/di/SoaStatProfileSettingsComponent$Builder;", "Lcom/avito/android/soa_stat/di/SoaStatProfileSettingsComponent;", "build", "()Lcom/avito/android/soa_stat/di/SoaStatProfileSettingsComponent;", "Lcom/avito/android/util/text/AttributedTextFormatter;", "formatter", "withFormatter", "(Lcom/avito/android/util/text/AttributedTextFormatter;)Lcom/avito/android/soa_stat/di/SoaStatProfileSettingsComponent$Builder;", "soa-stat_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        SoaStatProfileSettingsComponent build();

        @NotNull
        Builder soaStatDependencies(@NotNull SoaStatProfileSettingsDependencies soaStatProfileSettingsDependencies);

        @BindsInstance
        @NotNull
        Builder withFormatter(@NotNull AttributedTextFormatter attributedTextFormatter);
    }

    void inject(@NotNull SoaStatProfileSettingsActivity soaStatProfileSettingsActivity);
}
