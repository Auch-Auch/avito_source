package a2.a.a.t.b.a;

import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import com.avito.android.html_editor.HistorySnapshot;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class e extends Lambda implements Function1<HistorySnapshot, Unit> {
    public final /* synthetic */ HtmlEditorViewModel a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(HtmlEditorViewModel htmlEditorViewModel) {
        super(1);
        this.a = htmlEditorViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(HistorySnapshot historySnapshot) {
        HistorySnapshot historySnapshot2 = historySnapshot;
        Intrinsics.checkNotNullParameter(historySnapshot2, "snapshot");
        HtmlEditorViewModel.DefaultImpls.onNewSnapshot$default(this.a, historySnapshot2, false, 2, null);
        return Unit.INSTANCE;
    }
}
