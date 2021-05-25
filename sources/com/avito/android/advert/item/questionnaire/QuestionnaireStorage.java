package com.avito.android.advert.item.questionnaire;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert/item/questionnaire/QuestionnaireStorage;", "", "", "questionnaireId", "questionId", "", "setLastOpenedQuestionId", "(II)V", "getLastOpenedQuestionId", "(I)I", "setQuestionnaireCompleted", "(I)V", "", "isQuestionnaireCompleted", "(I)Z", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface QuestionnaireStorage {
    int getLastOpenedQuestionId(int i);

    boolean isQuestionnaireCompleted(int i);

    void setLastOpenedQuestionId(int i, int i2);

    void setQuestionnaireCompleted(int i);
}
