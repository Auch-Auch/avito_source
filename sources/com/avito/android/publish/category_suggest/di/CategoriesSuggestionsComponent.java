package com.avito.android.publish.category_suggest.di;

import com.avito.android.di.PerFragment;
import com.avito.android.publish.category_suggest.CategoriesSuggestionsFragment;
import com.avito.android.publish.di.PublishComponent;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/publish/category_suggest/di/CategoriesSuggestionsComponent;", "", "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsFragment;", "fragment", "", "inject", "(Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsFragment;)V", "Builder", "publish_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PublishComponent.class}, modules = {CategoriesSuggestionsModule.class})
@PerFragment
public interface CategoriesSuggestionsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/category_suggest/di/CategoriesSuggestionsComponent$Builder;", "", "Lcom/avito/android/publish/di/PublishComponent;", "component", "publishComponent", "(Lcom/avito/android/publish/di/PublishComponent;)Lcom/avito/android/publish/category_suggest/di/CategoriesSuggestionsComponent$Builder;", "Lcom/avito/android/publish/category_suggest/di/CategoriesSuggestionsModule;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "categoriesSuggestionsModule", "(Lcom/avito/android/publish/category_suggest/di/CategoriesSuggestionsModule;)Lcom/avito/android/publish/category_suggest/di/CategoriesSuggestionsComponent$Builder;", "Lcom/avito/android/publish/category_suggest/di/CategoriesSuggestionsComponent;", "build", "()Lcom/avito/android/publish/category_suggest/di/CategoriesSuggestionsComponent;", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        CategoriesSuggestionsComponent build();

        @NotNull
        Builder categoriesSuggestionsModule(@NotNull CategoriesSuggestionsModule categoriesSuggestionsModule);

        @NotNull
        Builder publishComponent(@NotNull PublishComponent publishComponent);
    }

    void inject(@NotNull CategoriesSuggestionsFragment categoriesSuggestionsFragment);
}
