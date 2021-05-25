package com.avito.android.advert.item.questionnaire;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preferences;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/advert/item/questionnaire/QuestionnaireStorageImpl;", "Lcom/avito/android/advert/item/questionnaire/QuestionnaireStorage;", "", "questionnaireId", "questionId", "", "setLastOpenedQuestionId", "(II)V", "getLastOpenedQuestionId", "(I)I", "setQuestionnaireCompleted", "(I)V", "", "isQuestionnaireCompleted", "(I)Z", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "preferences", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class QuestionnaireStorageImpl implements QuestionnaireStorage {
    public final Preferences a;

    @Inject
    public QuestionnaireStorageImpl(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.a = preferences;
    }

    @Override // com.avito.android.advert.item.questionnaire.QuestionnaireStorage
    public int getLastOpenedQuestionId(int i) {
        Preferences preferences = this.a;
        return preferences.getInt(QuestionnaireStorageKt.KEY_QUESTIONNAIRE_PREFIX + i, -1);
    }

    @Override // com.avito.android.advert.item.questionnaire.QuestionnaireStorage
    public boolean isQuestionnaireCompleted(int i) {
        return getLastOpenedQuestionId(i) == -2;
    }

    @Override // com.avito.android.advert.item.questionnaire.QuestionnaireStorage
    public void setLastOpenedQuestionId(int i, int i2) {
        Preferences preferences = this.a;
        preferences.putInt(QuestionnaireStorageKt.KEY_QUESTIONNAIRE_PREFIX + i, i2);
    }

    @Override // com.avito.android.advert.item.questionnaire.QuestionnaireStorage
    public void setQuestionnaireCompleted(int i) {
        setLastOpenedQuestionId(i, -2);
    }
}
