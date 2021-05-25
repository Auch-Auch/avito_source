package com.avito.android.fees.di;

import android.app.Activity;
import com.avito.android.di.PerActivity;
import com.avito.android.fees.FeesActivity;
import com.avito.android.fees.refactor.di.PackageFeesDependencies;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/fees/di/FeesActivityComponent;", "Lcom/avito/android/fees/refactor/di/PackageFeesDependencies;", "Lcom/avito/android/fees/FeesActivity;", "feesActivity", "", "inject", "(Lcom/avito/android/fees/FeesActivity;)V", "Builder", "fees_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {FeesActivityDependencies.class}, modules = {FeesActivityModule.class})
@PerActivity
public interface FeesActivityComponent extends PackageFeesDependencies {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/fees/di/FeesActivityComponent$Builder;", "", "Lcom/avito/android/fees/di/FeesActivityModule;", "feesActivityModule", "(Lcom/avito/android/fees/di/FeesActivityModule;)Lcom/avito/android/fees/di/FeesActivityComponent$Builder;", "Lcom/avito/android/fees/di/FeesActivityDependencies;", "dependencies", "(Lcom/avito/android/fees/di/FeesActivityDependencies;)Lcom/avito/android/fees/di/FeesActivityComponent$Builder;", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/fees/di/FeesActivityComponent$Builder;", "Lcom/avito/android/fees/di/FeesActivityComponent;", "build", "()Lcom/avito/android/fees/di/FeesActivityComponent;", "fees_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        FeesActivityComponent build();

        @NotNull
        Builder dependencies(@NotNull FeesActivityDependencies feesActivityDependencies);

        @NotNull
        Builder feesActivityModule(@NotNull FeesActivityModule feesActivityModule);

        @BindsInstance
        @NotNull
        Builder withActivity(@NotNull Activity activity);
    }

    void inject(@NotNull FeesActivity feesActivity);
}
