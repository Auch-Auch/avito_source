package a2.a.a.t.b.a;

import android.text.Selection;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorItemState;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import com.avito.android.html_editor.HistorySnapshot;
import com.avito.android.html_formatter.FormatOperation;
import com.avito.android.items.ItemWithHtmlSupport;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ HtmlEditorItemView a;
    public final /* synthetic */ HtmlEditorItemState b;
    public final /* synthetic */ ItemWithHtmlSupport c;
    public final /* synthetic */ HtmlEditorViewModel d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(HtmlEditorItemView htmlEditorItemView, HtmlEditorItemState htmlEditorItemState, ItemWithHtmlSupport itemWithHtmlSupport, HtmlEditorViewModel htmlEditorViewModel) {
        super(0);
        this.a = htmlEditorItemView;
        this.b = htmlEditorItemState;
        this.c = itemWithHtmlSupport;
        this.d = htmlEditorViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.b.getEditorState().setShouldMakeSnapshotOnNextOperation(true);
        if (this.b.getEditorState().getLastOperation() instanceof FormatOperation) {
            String value = this.c.getValue();
            if (value != null) {
                CharSequence text = this.a.getText();
                HtmlEditorViewModel.DefaultImpls.onNewSnapshot$default(this.d, new HistorySnapshot(value, Selection.getSelectionStart(text), Selection.getSelectionEnd(text)), false, 2, null);
            }
            this.b.getEditorState().setLastOperation(null);
        }
        return Unit.INSTANCE;
    }
}
