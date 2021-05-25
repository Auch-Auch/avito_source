package a2.a.a.e2.r;

import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import com.avito.android.html_editor.EditorNavigationEvent;
import com.avito.android.publish.details.PublishDetailsFragment;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<EditorNavigationEvent> {
    public final /* synthetic */ PublishDetailsFragment a;

    public b(PublishDetailsFragment publishDetailsFragment) {
        this.a = publishDetailsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(EditorNavigationEvent editorNavigationEvent) {
        EditorNavigationEvent editorNavigationEvent2 = editorNavigationEvent;
        HtmlEditorViewModel htmlEditorViewModel = this.a.getHtmlEditorViewModel();
        Intrinsics.checkNotNullExpressionValue(editorNavigationEvent2, "it");
        htmlEditorViewModel.onHistoryNavigationClicked(editorNavigationEvent2);
    }
}
