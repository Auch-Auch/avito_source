package a2.a.a.e2.r;

import androidx.lifecycle.Observer;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import com.avito.android.publish.view.ItemDetailsViewImpl;
public final class c<T> implements Observer<HtmlEditorViewModel.State> {
    public final /* synthetic */ ItemDetailsViewImpl a;

    public c(ItemDetailsViewImpl itemDetailsViewImpl) {
        this.a = itemDetailsViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(HtmlEditorViewModel.State state) {
        HtmlEditorViewModel.State state2 = state;
        if (state2 instanceof HtmlEditorViewModel.State.Enabled) {
            this.a.showHtmlEditorToolbar();
        } else if (state2 instanceof HtmlEditorViewModel.State.Disabled) {
            this.a.hideHtmlEditorToolbar();
        }
    }
}
