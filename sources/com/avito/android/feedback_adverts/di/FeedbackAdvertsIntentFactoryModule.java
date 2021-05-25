package com.avito.android.feedback_adverts.di;

import com.avito.android.FeedbackAdvertsIntentFactory;
import com.avito.android.feedback_adverts.FeedbackAdvertsIntentFactoryImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/feedback_adverts/di/FeedbackAdvertsIntentFactoryModule;", "", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsIntentFactoryImpl;", "factory", "Lcom/avito/android/FeedbackAdvertsIntentFactory;", "bindFeedbackAdvertsIntentFactory", "(Lcom/avito/android/feedback_adverts/FeedbackAdvertsIntentFactoryImpl;)Lcom/avito/android/FeedbackAdvertsIntentFactory;", "feedback-adverts_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface FeedbackAdvertsIntentFactoryModule {
    @Binds
    @NotNull
    FeedbackAdvertsIntentFactory bindFeedbackAdvertsIntentFactory(@NotNull FeedbackAdvertsIntentFactoryImpl feedbackAdvertsIntentFactoryImpl);
}
