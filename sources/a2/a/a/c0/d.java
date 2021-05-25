package a2.a.a.c0;

import com.avito.android.category.CategoryPresenterImpl;
import com.avito.android.category.Element;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function0<Unit> {
    public final /* synthetic */ CategoryPresenterImpl a;
    public final /* synthetic */ Element.Subcategory b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(CategoryPresenterImpl categoryPresenterImpl, Element.Subcategory subcategory, Element.Category category) {
        super(0);
        this.a = categoryPresenterImpl;
        this.b = subcategory;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        CategoryPresenterImpl.access$sendCategoryClick(this.a, this.b.getName(), this.b.getId());
        CategoryPresenterImpl categoryPresenterImpl = this.a;
        categoryPresenterImpl.a(CategoryPresenterImpl.access$getSavedLocationIfNull(categoryPresenterImpl), this.b.getId());
        return Unit.INSTANCE;
    }
}
