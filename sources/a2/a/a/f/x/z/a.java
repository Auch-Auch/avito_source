package a2.a.a.f.x.z;

import com.avito.android.advert.item.safe_show.SafeShowItemPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ SafeShowItemPresenterImpl.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(SafeShowItemPresenterImpl.a aVar) {
        super(0);
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.a.a.sendSafeShowDialogContactsButtonClicked(this.a.b.getAdvertId());
        return Unit.INSTANCE;
    }
}
