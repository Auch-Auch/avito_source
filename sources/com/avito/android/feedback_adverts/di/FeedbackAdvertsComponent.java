package com.avito.android.feedback_adverts.di;

import arrow.core.Option;
import com.avito.android.di.PerActivity;
import com.avito.android.feedback_adverts.FeedbackAdvertsActivity;
import com.avito.android.feedback_adverts.FeedbackAdvertsPresenterState;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/feedback_adverts/di/FeedbackAdvertsComponent;", "", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsActivity;", "activity", "", "inject", "(Lcom/avito/android/feedback_adverts/FeedbackAdvertsActivity;)V", "Builder", "feedback-adverts_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {FeedbackAdvertsDependencies.class}, modules = {FeedbackAdvertsModule.class})
@PerActivity
public interface FeedbackAdvertsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H'¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H'¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\f\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\nH'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/feedback_adverts/di/FeedbackAdvertsComponent$Builder;", "", "Larrow/core/Option;", "", "id", "itemId", "(Larrow/core/Option;)Lcom/avito/android/feedback_adverts/di/FeedbackAdvertsComponent$Builder;", "selectedItemId", "(Ljava/lang/String;)Lcom/avito/android/feedback_adverts/di/FeedbackAdvertsComponent$Builder;", "title", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsPresenterState;", "state", "presenterState", "(Lcom/avito/android/feedback_adverts/FeedbackAdvertsPresenterState;)Lcom/avito/android/feedback_adverts/di/FeedbackAdvertsComponent$Builder;", "Lcom/avito/android/feedback_adverts/di/FeedbackAdvertsDependencies;", "dependencies", "feedbackAdvertsDependencies", "(Lcom/avito/android/feedback_adverts/di/FeedbackAdvertsDependencies;)Lcom/avito/android/feedback_adverts/di/FeedbackAdvertsComponent$Builder;", "Lcom/avito/android/feedback_adverts/di/FeedbackAdvertsComponent;", "build", "()Lcom/avito/android/feedback_adverts/di/FeedbackAdvertsComponent;", "feedback-adverts_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        FeedbackAdvertsComponent build();

        @NotNull
        Builder feedbackAdvertsDependencies(@NotNull FeedbackAdvertsDependencies feedbackAdvertsDependencies);

        @BindsInstance
        @NotNull
        Builder itemId(@NotNull Option<String> option);

        @BindsInstance
        @NotNull
        Builder presenterState(@Nullable FeedbackAdvertsPresenterState feedbackAdvertsPresenterState);

        @BindsInstance
        @NotNull
        Builder selectedItemId(@Nullable String str);

        @BindsInstance
        @NotNull
        Builder title(@Nullable String str);
    }

    void inject(@NotNull FeedbackAdvertsActivity feedbackAdvertsActivity);
}
