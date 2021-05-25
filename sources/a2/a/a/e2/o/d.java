package a2.a.a.e2.o;

import com.avito.android.publish.category_suggest.CategoriesSuggestionsFragment;
import com.avito.android.publish.wizard.WizardItem;
import io.reactivex.functions.Consumer;
public final class d<T> implements Consumer<WizardItem> {
    public final /* synthetic */ CategoriesSuggestionsFragment a;

    public d(CategoriesSuggestionsFragment categoriesSuggestionsFragment) {
        this.a = categoriesSuggestionsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(WizardItem wizardItem) {
        CategoriesSuggestionsFragment.access$getViewModel$p(this.a).onCategoryListItemClicked(wizardItem.getNavigation());
    }
}
