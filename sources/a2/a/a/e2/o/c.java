package a2.a.a.e2.o;

import androidx.lifecycle.Observer;
import com.avito.android.publish.category_suggest.CategoriesSuggestionsFragment;
import com.avito.android.publish.category_suggest.CategoriesSuggestionsViewModel;
import com.avito.android.publish.view.publish_button.PublishButton;
public final class c<T> implements Observer<CategoriesSuggestionsViewModel.MainActionState> {
    public final /* synthetic */ CategoriesSuggestionsFragment a;

    public c(CategoriesSuggestionsFragment categoriesSuggestionsFragment) {
        this.a = categoriesSuggestionsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(CategoriesSuggestionsViewModel.MainActionState mainActionState) {
        CategoriesSuggestionsViewModel.MainActionState mainActionState2 = mainActionState;
        PublishButton publishButton = this.a.j;
        if (publishButton != null) {
            publishButton.setVisible(mainActionState2 == CategoriesSuggestionsViewModel.MainActionState.VISIBLE);
        }
    }
}
