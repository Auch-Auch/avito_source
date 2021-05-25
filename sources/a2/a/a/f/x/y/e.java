package a2.a.a.f.x.y;

import android.view.View;
import com.avito.android.advert.item.questionnaire.QuestionnaireView;
import com.avito.android.remote.model.Questionnaire;
import kotlin.jvm.functions.Function1;
public final class e implements View.OnClickListener {
    public final /* synthetic */ Questionnaire.Answer a;
    public final /* synthetic */ Function1 b;

    public e(Questionnaire.Answer answer, QuestionnaireView questionnaireView, Function1 function1) {
        this.a = answer;
        this.b = function1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.b.invoke(this.a);
    }
}
