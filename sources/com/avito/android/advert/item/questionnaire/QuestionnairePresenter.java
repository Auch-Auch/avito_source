package com.avito.android.advert.item.questionnaire;

import android.os.Bundle;
import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Questionnaire;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0002\u0016\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/advert/item/questionnaire/QuestionnairePresenter;", "", "Lcom/avito/android/remote/model/Questionnaire;", "questionnaire", "", "showIfNeeded", "(Lcom/avito/android/remote/model/Questionnaire;)V", "Landroid/view/View;", "view", "attachView", "(Landroid/view/View;)V", "detachView", "()V", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "Lcom/avito/android/advert/item/questionnaire/QuestionnairePresenter$Listener;", "getListener", "()Lcom/avito/android/advert/item/questionnaire/QuestionnairePresenter$Listener;", "setListener", "(Lcom/avito/android/advert/item/questionnaire/QuestionnairePresenter$Listener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "FromPage", "Listener", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface QuestionnairePresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert/item/questionnaire/QuestionnairePresenter$FromPage;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "ITEM", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public enum FromPage {
        ITEM("item");
        
        @NotNull
        public final String a;

        /* access modifiers changed from: public */
        FromPage(String str) {
            this.a = str;
        }

        @NotNull
        public final String getValue() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert/item/questionnaire/QuestionnairePresenter$Listener;", "", "Lcom/avito/android/remote/model/Questionnaire$Question;", "question", "", "onQuestionAppeared", "(Lcom/avito/android/remote/model/Questionnaire$Question;)V", "Lcom/avito/android/remote/model/Questionnaire$Answer;", "answer", "onQuestionAnswered", "(Lcom/avito/android/remote/model/Questionnaire$Question;Lcom/avito/android/remote/model/Questionnaire$Answer;)V", "onCompleted", "()V", "onClosed", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onClosed(@NotNull Questionnaire.Question question);

        void onCompleted();

        void onQuestionAnswered(@NotNull Questionnaire.Question question, @NotNull Questionnaire.Answer answer);

        void onQuestionAppeared(@NotNull Questionnaire.Question question);
    }

    void attachView(@NotNull View view);

    void detachView();

    @Nullable
    Listener getListener();

    @NotNull
    Bundle onSaveState();

    void setListener(@Nullable Listener listener);

    void showIfNeeded(@NotNull Questionnaire questionnaire);
}
