package com.avito.android.publish.premoderation.di;

import com.avito.android.di.PerFragment;
import com.avito.android.publish.di.PublishDependencies;
import com.avito.android.publish.premoderation.WrongCategoryFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/publish/premoderation/di/WrongCategoryComponent;", "", "Lcom/avito/android/publish/premoderation/WrongCategoryFragment;", "fragment", "", "inject", "(Lcom/avito/android/publish/premoderation/WrongCategoryFragment;)V", "Builder", "publish_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PublishDependencies.class}, modules = {WrongCategoryModule.class})
@PerFragment
public interface WrongCategoryComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/publish/premoderation/di/WrongCategoryComponent$Builder;", "", "Lcom/avito/android/publish/di/PublishDependencies;", "publishDependencies", "(Lcom/avito/android/publish/di/PublishDependencies;)Lcom/avito/android/publish/premoderation/di/WrongCategoryComponent$Builder;", "Lcom/avito/android/publish/premoderation/di/WrongCategoryModule;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "wrongCategoryModule", "(Lcom/avito/android/publish/premoderation/di/WrongCategoryModule;)Lcom/avito/android/publish/premoderation/di/WrongCategoryComponent$Builder;", "Lcom/avito/android/publish/premoderation/di/WrongCategoryComponent;", "build", "()Lcom/avito/android/publish/premoderation/di/WrongCategoryComponent;", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        WrongCategoryComponent build();

        @NotNull
        Builder publishDependencies(@NotNull PublishDependencies publishDependencies);

        @NotNull
        Builder wrongCategoryModule(@NotNull WrongCategoryModule wrongCategoryModule);
    }

    void inject(@NotNull WrongCategoryFragment wrongCategoryFragment);
}
