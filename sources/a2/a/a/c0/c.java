package a2.a.a.c0;

import com.avito.android.category.CategoryPresenter;
import com.avito.android.category.CategoryPresenterImpl;
import com.avito.android.category.Element;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function0<Unit> {
    public final /* synthetic */ CategoryPresenterImpl a;
    public final /* synthetic */ Element.Shops b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(CategoryPresenterImpl categoryPresenterImpl, Element.Shops shops) {
        super(0);
        this.a = categoryPresenterImpl;
        this.b = shops;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        CategoryPresenterImpl.access$sendCategoryClick(this.a, this.b.getName(), null);
        CategoryPresenterImpl.access$sendShopClick(this.a);
        CategoryPresenter.Router router = this.a.b;
        if (router != null) {
            router.followDeepLink(this.b.getDeepLink(), this.a.l.getParent());
        }
        return Unit.INSTANCE;
    }
}
