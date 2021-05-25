package com.avito.android.publish.select.di;

import com.avito.android.di.PerFragment;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.select.SelectFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/publish/select/di/SelectComponent;", "", "Lcom/avito/android/publish/select/SelectFragment;", "fragment", "", "inject", "(Lcom/avito/android/publish/select/SelectFragment;)V", "Builder", "publish_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PublishComponent.class}, modules = {SelectModule.class})
@PerFragment
public interface SelectComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/select/di/SelectComponent$Builder;", "", "Lcom/avito/android/publish/di/PublishComponent;", "component", "publishComponent", "(Lcom/avito/android/publish/di/PublishComponent;)Lcom/avito/android/publish/select/di/SelectComponent$Builder;", "Lcom/avito/android/publish/select/di/SelectModule;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "selectModule", "(Lcom/avito/android/publish/select/di/SelectModule;)Lcom/avito/android/publish/select/di/SelectComponent$Builder;", "Lcom/avito/android/publish/select/di/SelectComponent;", "build", "()Lcom/avito/android/publish/select/di/SelectComponent;", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        SelectComponent build();

        @NotNull
        Builder publishComponent(@NotNull PublishComponent publishComponent);

        @NotNull
        Builder selectModule(@NotNull SelectModule selectModule);
    }

    void inject(@NotNull SelectFragment selectFragment);
}
