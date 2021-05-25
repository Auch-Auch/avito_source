package com.avito.android.advert.cpo_program.di;

import com.avito.android.advert.cpo_program.AutotekaCpoProgramActivity;
import com.avito.android.di.PerActivity;
import com.avito.android.remote.model.CpoDescription;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/advert/cpo_program/di/AutotekaCpoProgramComponent;", "", "Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramActivity;", "activity", "", "inject", "(Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramActivity;)V", "Builder", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {AutotekaCpoProgramDependencies.class}, modules = {AutotekaCpoProgramModule.class})
@PerActivity
public interface AutotekaCpoProgramComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/advert/cpo_program/di/AutotekaCpoProgramComponent$Builder;", "", "Lcom/avito/android/advert/cpo_program/di/AutotekaCpoProgramDependencies;", "cpoProgramDependencies", "(Lcom/avito/android/advert/cpo_program/di/AutotekaCpoProgramDependencies;)Lcom/avito/android/advert/cpo_program/di/AutotekaCpoProgramComponent$Builder;", "Lcom/avito/android/remote/model/CpoDescription;", "description", "withDescription", "(Lcom/avito/android/remote/model/CpoDescription;)Lcom/avito/android/advert/cpo_program/di/AutotekaCpoProgramComponent$Builder;", "Lcom/avito/android/advert/cpo_program/di/AutotekaCpoProgramComponent;", "build", "()Lcom/avito/android/advert/cpo_program/di/AutotekaCpoProgramComponent;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        AutotekaCpoProgramComponent build();

        @NotNull
        Builder cpoProgramDependencies(@NotNull AutotekaCpoProgramDependencies autotekaCpoProgramDependencies);

        @BindsInstance
        @NotNull
        Builder withDescription(@NotNull CpoDescription cpoDescription);
    }

    void inject(@NotNull AutotekaCpoProgramActivity autotekaCpoProgramActivity);
}
