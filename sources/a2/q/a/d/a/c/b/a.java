package a2.q.a.d.a.c.b;

import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.presentation.screen.documents.submitting.SNSSubmittingDocumentsFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<Document, Unit> {
    public final /* synthetic */ SNSSubmittingDocumentsFragment.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(SNSSubmittingDocumentsFragment.a aVar) {
        super(1);
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Document document) {
        Document document2 = document;
        Intrinsics.checkNotNullParameter(document2, "document");
        this.a.a.getViewModel().onDocumentClicked(document2);
        return Unit.INSTANCE;
    }
}
