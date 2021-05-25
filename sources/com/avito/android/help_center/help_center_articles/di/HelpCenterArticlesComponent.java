package com.avito.android.help_center.help_center_articles.di;

import com.avito.android.di.PerActivity;
import com.avito.android.help_center.help_center_articles.HelpCenterArticlesActivity;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/help_center/help_center_articles/di/HelpCenterArticlesComponent;", "", "Lcom/avito/android/help_center/help_center_articles/HelpCenterArticlesActivity;", "activity", "", "inject", "(Lcom/avito/android/help_center/help_center_articles/HelpCenterArticlesActivity;)V", "Builder", "help-center_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {HelpCenterArticlesDependencies.class}, modules = {HelpCenterArticlesModule.class})
@PerActivity
public interface HelpCenterArticlesComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0006\u001a\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\b\u001a\u00020\u00002\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005H'¢\u0006\u0004\b\b\u0010\u0007J\u001b\u0010\t\u001a\u00020\u00002\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005H'¢\u0006\u0004\b\t\u0010\u0007J\u001b\u0010\n\u001a\u00020\u00002\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005H'¢\u0006\u0004\b\n\u0010\u0007J\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/help_center/help_center_articles/di/HelpCenterArticlesComponent$Builder;", "", "Lcom/avito/android/help_center/help_center_articles/di/HelpCenterArticlesDependencies;", "dependencies", "(Lcom/avito/android/help_center/help_center_articles/di/HelpCenterArticlesDependencies;)Lcom/avito/android/help_center/help_center_articles/di/HelpCenterArticlesComponent$Builder;", "", "articleId", "(Ljava/lang/String;)Lcom/avito/android/help_center/help_center_articles/di/HelpCenterArticlesComponent$Builder;", "theme", "advertisementId", "contextId", "Lcom/avito/android/help_center/help_center_articles/di/HelpCenterArticlesComponent;", "build", "()Lcom/avito/android/help_center/help_center_articles/di/HelpCenterArticlesComponent;", "help-center_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder advertisementId(@AdvertisementId @Nullable String str);

        @BindsInstance
        @NotNull
        Builder articleId(@ArticleId @NotNull String str);

        @NotNull
        HelpCenterArticlesComponent build();

        @BindsInstance
        @NotNull
        Builder contextId(@ContextId @Nullable String str);

        @NotNull
        Builder dependencies(@NotNull HelpCenterArticlesDependencies helpCenterArticlesDependencies);

        @BindsInstance
        @NotNull
        Builder theme(@Theme @Nullable String str);
    }

    void inject(@NotNull HelpCenterArticlesActivity helpCenterArticlesActivity);
}
