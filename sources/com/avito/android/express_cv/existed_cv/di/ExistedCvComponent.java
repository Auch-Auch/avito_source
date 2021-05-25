package com.avito.android.express_cv.existed_cv.di;

import com.avito.android.di.PerFragment;
import com.avito.android.express_cv.existed_cv.ExistedCvFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/express_cv/existed_cv/di/ExistedCvComponent;", "", "Lcom/avito/android/express_cv/existed_cv/ExistedCvFragment;", "fragment", "", "inject", "(Lcom/avito/android/express_cv/existed_cv/ExistedCvFragment;)V", "Builder", "express-cv_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ExistedCvComponentDependencies.class}, modules = {ExistedCvModule.class})
@PerFragment
public interface ExistedCvComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/express_cv/existed_cv/di/ExistedCvComponent$Builder;", "", "Lcom/avito/android/express_cv/existed_cv/di/ExistedCvModule;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "existedCvModule", "(Lcom/avito/android/express_cv/existed_cv/di/ExistedCvModule;)Lcom/avito/android/express_cv/existed_cv/di/ExistedCvComponent$Builder;", "Lcom/avito/android/express_cv/existed_cv/di/ExistedCvComponentDependencies;", "dependencies", "(Lcom/avito/android/express_cv/existed_cv/di/ExistedCvComponentDependencies;)Lcom/avito/android/express_cv/existed_cv/di/ExistedCvComponent$Builder;", "Lcom/avito/android/express_cv/existed_cv/di/ExistedCvComponent;", "build", "()Lcom/avito/android/express_cv/existed_cv/di/ExistedCvComponent;", "express-cv_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        ExistedCvComponent build();

        @NotNull
        Builder dependencies(@NotNull ExistedCvComponentDependencies existedCvComponentDependencies);

        @NotNull
        Builder existedCvModule(@NotNull ExistedCvModule existedCvModule);
    }

    void inject(@NotNull ExistedCvFragment existedCvFragment);
}
