package com.avito.android.express_cv.di;

import android.app.Activity;
import com.avito.android.di.PerActivity;
import com.avito.android.express_cv.ExpressCvActivity;
import com.avito.android.express_cv.existed_cv.di.ExistedCvComponentDependencies;
import com.avito.android.express_cv.new_cv.di.NewCvComponentDependencies;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/avito/android/express_cv/di/ExpressCvComponent;", "Lcom/avito/android/express_cv/new_cv/di/NewCvComponentDependencies;", "Lcom/avito/android/express_cv/existed_cv/di/ExistedCvComponentDependencies;", "Lcom/avito/android/express_cv/ExpressCvActivity;", "activity", "", "inject", "(Lcom/avito/android/express_cv/ExpressCvActivity;)V", "Builder", "express-cv_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ExpressCvDependencies.class}, modules = {ExpressCvModule.class})
@PerActivity
public interface ExpressCvComponent extends NewCvComponentDependencies, ExistedCvComponentDependencies {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/express_cv/di/ExpressCvComponent$Builder;", "", "Lcom/avito/android/express_cv/di/ExpressCvDependencies;", "dependencies", "(Lcom/avito/android/express_cv/di/ExpressCvDependencies;)Lcom/avito/android/express_cv/di/ExpressCvComponent$Builder;", "Lcom/avito/android/express_cv/di/ExpressCvModule;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "expressCvModule", "(Lcom/avito/android/express_cv/di/ExpressCvModule;)Lcom/avito/android/express_cv/di/ExpressCvComponent$Builder;", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/express_cv/di/ExpressCvComponent$Builder;", "Lcom/avito/android/express_cv/di/ExpressCvComponent;", "build", "()Lcom/avito/android/express_cv/di/ExpressCvComponent;", "express-cv_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        ExpressCvComponent build();

        @NotNull
        Builder dependencies(@NotNull ExpressCvDependencies expressCvDependencies);

        @NotNull
        Builder expressCvModule(@NotNull ExpressCvModule expressCvModule);

        @BindsInstance
        @NotNull
        Builder withActivity(@NotNull Activity activity);
    }

    void inject(@NotNull ExpressCvActivity expressCvActivity);
}
