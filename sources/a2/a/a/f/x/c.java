package a2.a.a.f.x;

import com.avito.android.advert.item.AdvertDetailsFragment;
import com.avito.android.advert.item.AdvertDetailsView;
import com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoPresenter;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ AdvertDetailsFragment a;
    public final /* synthetic */ DfpCreditViewModel b;
    public final /* synthetic */ AdvertDetailsCreditInfoPresenter c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(AdvertDetailsFragment advertDetailsFragment, DfpCreditViewModel dfpCreditViewModel, AdvertDetailsCreditInfoPresenter advertDetailsCreditInfoPresenter) {
        super(1);
        this.a = advertDetailsFragment;
        this.b = dfpCreditViewModel;
        this.c = advertDetailsCreditInfoPresenter;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Boolean bool) {
        Boolean bool2 = bool;
        if (Intrinsics.areEqual(bool2, Boolean.FALSE) && Intrinsics.areEqual(this.b.isEditing().getValue(), Boolean.TRUE)) {
            this.c.clearFocus();
        }
        AdvertDetailsView advertDetailsView = this.a.c();
        Intrinsics.checkNotNullExpressionValue(bool2, "it");
        advertDetailsView.onKeyboardVisibilityChanged(bool2.booleanValue());
        return Unit.INSTANCE;
    }
}
