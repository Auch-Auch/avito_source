package a2.a.a.c0;

import com.avito.android.category.CategoryPresenterImpl;
import com.avito.android.category.Element;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ CategoryPresenterImpl a;
    public final /* synthetic */ Element.Category b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(CategoryPresenterImpl categoryPresenterImpl, Element.Category category, int i) {
        super(0);
        this.a = categoryPresenterImpl;
        this.b = category;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        if (!this.b.getChildren().isEmpty()) {
            if (this.b.isChildrenVisible()) {
                CategoryPresenterImpl.access$removeChildren(this.a, this.b);
            } else {
                CategoryPresenterImpl.access$addChildren(this.a, this.b);
            }
            Element.Category category = this.b;
            category.setChildrenVisible(!category.isChildrenVisible());
        } else {
            CategoryPresenterImpl.access$sendCategoryClick(this.a, this.b.getName(), this.b.getId());
            CategoryPresenterImpl categoryPresenterImpl = this.a;
            categoryPresenterImpl.a(CategoryPresenterImpl.access$getSavedLocationIfNull(categoryPresenterImpl), this.b.getId());
        }
        return Unit.INSTANCE;
    }
}
