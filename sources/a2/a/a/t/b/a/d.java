package a2.a.a.t.b.a;

import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import com.avito.android.items.ItemWithHtmlSupport;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ HtmlEditorViewModel b;
    public final /* synthetic */ ItemWithHtmlSupport c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Function1 function1, HtmlEditorViewModel htmlEditorViewModel, ItemWithHtmlSupport itemWithHtmlSupport) {
        super(1);
        this.a = function1;
        this.b = htmlEditorViewModel;
        this.c = itemWithHtmlSupport;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Boolean bool) {
        boolean booleanValue = bool.booleanValue();
        this.a.invoke(Boolean.valueOf(booleanValue));
        if (booleanValue) {
            this.b.setState(new HtmlEditorViewModel.State.Enabled(this.c.getStringId()));
        } else {
            this.b.setState(HtmlEditorViewModel.State.Disabled.INSTANCE);
        }
        return Unit.INSTANCE;
    }
}
