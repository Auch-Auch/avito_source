package com.avito.android.autodeal_details.di;

import androidx.fragment.app.FragmentActivity;
import com.avito.android.autodeal_details.AutoDealDetailsActivity;
import com.avito.android.di.PerActivity;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/autodeal_details/di/AutoDealDetailsComponent;", "", "Lcom/avito/android/autodeal_details/AutoDealDetailsActivity;", "activity", "", "inject", "(Lcom/avito/android/autodeal_details/AutoDealDetailsActivity;)V", "Builder", "autodeal-details_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {AutoDealDetailsDependencies.class}, modules = {AutoDealDetailsModule.class})
@PerActivity
public interface AutoDealDetailsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/autodeal_details/di/AutoDealDetailsComponent$Builder;", "", "Lcom/avito/android/autodeal_details/di/AutoDealDetailsDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/autodeal_details/di/AutoDealDetailsDependencies;)Lcom/avito/android/autodeal_details/di/AutoDealDetailsComponent$Builder;", "Landroidx/fragment/app/FragmentActivity;", "activity", "withFragmentActivity", "(Landroidx/fragment/app/FragmentActivity;)Lcom/avito/android/autodeal_details/di/AutoDealDetailsComponent$Builder;", "", "url", "withUrl", "(Ljava/lang/String;)Lcom/avito/android/autodeal_details/di/AutoDealDetailsComponent$Builder;", "Lcom/avito/android/autodeal_details/di/AutoDealDetailsComponent;", "build", "()Lcom/avito/android/autodeal_details/di/AutoDealDetailsComponent;", "autodeal-details_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        AutoDealDetailsComponent build();

        @NotNull
        Builder dependentOn(@NotNull AutoDealDetailsDependencies autoDealDetailsDependencies);

        @BindsInstance
        @NotNull
        Builder withFragmentActivity(@NotNull FragmentActivity fragmentActivity);

        @BindsInstance
        @NotNull
        Builder withUrl(@NotNull String str);
    }

    void inject(@NotNull AutoDealDetailsActivity autoDealDetailsActivity);
}
