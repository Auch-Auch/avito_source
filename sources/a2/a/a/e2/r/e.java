package a2.a.a.e2.r;

import androidx.lifecycle.Observer;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import com.avito.android.publish.view.ItemDetailsViewImpl;
public final class e<T> implements Observer<HtmlEditorViewModel.NavigationButtonsState> {
    public final /* synthetic */ ItemDetailsViewImpl a;

    public e(ItemDetailsViewImpl itemDetailsViewImpl) {
        this.a = itemDetailsViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(HtmlEditorViewModel.NavigationButtonsState navigationButtonsState) {
        HtmlEditorViewModel.NavigationButtonsState navigationButtonsState2 = navigationButtonsState;
        this.a.setEditorNavigationButtonsStates(navigationButtonsState2.getUndoEnabled(), navigationButtonsState2.getRedoEnabled());
    }
}
