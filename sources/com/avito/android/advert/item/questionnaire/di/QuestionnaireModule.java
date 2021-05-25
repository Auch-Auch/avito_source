package com.avito.android.advert.item.questionnaire.di;

import com.avito.android.advert.item.questionnaire.QuestionnairePresenter;
import com.avito.android.advert.item.questionnaire.QuestionnairePresenterImpl;
import com.avito.android.advert.item.questionnaire.QuestionnaireStorage;
import com.avito.android.advert.item.questionnaire.QuestionnaireStorageImpl;
import com.avito.android.di.PerFragment;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert/item/questionnaire/di/QuestionnaireModule;", "", "Lcom/avito/android/advert/item/questionnaire/QuestionnairePresenterImpl;", "presenter", "Lcom/avito/android/advert/item/questionnaire/QuestionnairePresenter;", "bindQuestionnairePresenter", "(Lcom/avito/android/advert/item/questionnaire/QuestionnairePresenterImpl;)Lcom/avito/android/advert/item/questionnaire/QuestionnairePresenter;", "Lcom/avito/android/advert/item/questionnaire/QuestionnaireStorageImpl;", "Lcom/avito/android/advert/item/questionnaire/QuestionnaireStorage;", "bindQuestionnaireStorage", "(Lcom/avito/android/advert/item/questionnaire/QuestionnaireStorageImpl;)Lcom/avito/android/advert/item/questionnaire/QuestionnaireStorage;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface QuestionnaireModule {
    @PerFragment
    @Binds
    @NotNull
    QuestionnairePresenter bindQuestionnairePresenter(@NotNull QuestionnairePresenterImpl questionnairePresenterImpl);

    @PerFragment
    @Binds
    @NotNull
    QuestionnaireStorage bindQuestionnaireStorage(@NotNull QuestionnaireStorageImpl questionnaireStorageImpl);
}
