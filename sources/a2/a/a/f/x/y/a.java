package a2.a.a.f.x.y;

import android.content.DialogInterface;
import android.view.View;
import com.avito.android.advert.item.questionnaire.QuestionnairePresenterImpl;
import com.avito.android.remote.model.Questionnaire;
public final class a implements DialogInterface.OnDismissListener {
    public final /* synthetic */ QuestionnairePresenterImpl a;
    public final /* synthetic */ View b;

    public a(QuestionnairePresenterImpl questionnairePresenterImpl, Questionnaire questionnaire, View view) {
        this.a = questionnairePresenterImpl;
        this.b = view;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        QuestionnairePresenterImpl.access$onDismissed(this.a);
    }
}
