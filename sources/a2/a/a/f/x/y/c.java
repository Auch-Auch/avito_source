package a2.a.a.f.x.y;

import android.view.View;
import com.avito.android.advert.item.questionnaire.QuestionnairePresenter;
import com.avito.android.advert.item.questionnaire.QuestionnairePresenterImpl;
import com.avito.android.remote.model.Questionnaire;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function0<Unit> {
    public final /* synthetic */ QuestionnairePresenterImpl a;
    public final /* synthetic */ Questionnaire b;
    public final /* synthetic */ View c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(QuestionnairePresenterImpl questionnairePresenterImpl, Questionnaire questionnaire, View view) {
        super(0);
        this.a = questionnairePresenterImpl;
        this.b = questionnaire;
        this.c = view;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        QuestionnairePresenter.Listener listener;
        QuestionnairePresenterImpl.access$completeQuestionnaire(this.a, this.b);
        Questionnaire.Question question = this.a.d;
        if (!(question == null || (listener = this.a.getListener()) == null)) {
            listener.onClosed(question);
        }
        return Unit.INSTANCE;
    }
}
