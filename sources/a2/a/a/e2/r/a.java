package a2.a.a.e2.r;

import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import com.avito.android.html_formatter.FormatChange;
import com.avito.android.publish.details.PublishDetailsFragment;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Consumer<FormatChange> {
    public final /* synthetic */ PublishDetailsFragment a;

    public a(PublishDetailsFragment publishDetailsFragment) {
        this.a = publishDetailsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(FormatChange formatChange) {
        FormatChange formatChange2 = formatChange;
        HtmlEditorViewModel htmlEditorViewModel = this.a.getHtmlEditorViewModel();
        Intrinsics.checkNotNullExpressionValue(formatChange2, "it");
        htmlEditorViewModel.onFormatClicked(formatChange2);
    }
}
