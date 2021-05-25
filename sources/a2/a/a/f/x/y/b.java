package a2.a.a.f.x.y;

import android.content.DialogInterface;
import android.view.View;
import com.avito.android.advert.item.questionnaire.QuestionnairePresenterImpl;
import com.avito.android.remote.model.Questionnaire;
public final class b implements DialogInterface.OnCancelListener {
    public final /* synthetic */ QuestionnairePresenterImpl a;
    public final /* synthetic */ View b;

    public b(QuestionnairePresenterImpl questionnairePresenterImpl, Questionnaire questionnaire, View view) {
        this.a = questionnairePresenterImpl;
        this.b = view;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.a.e = true;
    }
}
