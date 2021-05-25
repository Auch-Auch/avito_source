package a2.a.a.t.b.a;

import com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorItemViewExtensionsKt;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import com.avito.android.html_editor.HtmlInteractorImpl;
import com.avito.android.items.ItemWithHtmlSupport;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function0<Unit> {
    public final /* synthetic */ HtmlEditorItemView a;
    public final /* synthetic */ CompositeDisposable b;
    public final /* synthetic */ HtmlEditorViewModel c;
    public final /* synthetic */ ItemWithHtmlSupport d;
    public final /* synthetic */ HtmlInteractorImpl e;
    public final /* synthetic */ Function2 f;
    public final /* synthetic */ Consumer g;
    public final /* synthetic */ Function0 h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(HtmlEditorItemView htmlEditorItemView, CompositeDisposable compositeDisposable, HtmlEditorViewModel htmlEditorViewModel, ItemWithHtmlSupport itemWithHtmlSupport, HtmlInteractorImpl htmlInteractorImpl, Function2 function2, Consumer consumer, Function0 function0) {
        super(0);
        this.a = htmlEditorItemView;
        this.b = compositeDisposable;
        this.c = htmlEditorViewModel;
        this.d = itemWithHtmlSupport;
        this.e = htmlInteractorImpl;
        this.f = function2;
        this.g = consumer;
        this.h = function0;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        HtmlEditorItemViewExtensionsKt.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        return Unit.INSTANCE;
    }
}
