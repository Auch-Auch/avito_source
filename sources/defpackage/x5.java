package defpackage;

import com.avito.android.blueprints.publish.html_editor.HtmlEditorItemState;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorItemViewExtensionsKt;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import com.avito.android.items.ItemWithHtmlSupport;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: x5  reason: default package */
public final class x5 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x5(int i, Object obj, Object obj2) {
        super(0);
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        int i = this.a;
        if (i == 0) {
            HtmlEditorItemViewExtensionsKt.access$unBindViewModel((HtmlEditorItemState) this.b, (ItemWithHtmlSupport) this.c);
            return Unit.INSTANCE;
        } else if (i == 1) {
            if (((HtmlEditorViewModel) this.b).clearHistoryTopIfNeeded()) {
                ((HtmlEditorItemState) this.c).getEditorState().setShouldMakeSnapshotOnNextOperation(false);
                ((HtmlEditorItemState) this.c).getEditorState().setLastOperation(null);
            }
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}
