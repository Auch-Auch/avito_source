package defpackage;

import com.avito.android.public_profile.ui.PublicProfilePresenter;
import com.avito.android.public_profile.ui.PublicProfilePresenterImpl;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ProfileRatingAction;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: u5  reason: default package */
public final class u5 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u5(int i, Object obj, Object obj2, Object obj3, Object obj4) {
        super(0);
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
        this.e = obj4;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        int i = this.a;
        if (i == 0) {
            PublicProfilePresenterImpl.access$onRatingClicked((PublicProfilePresenterImpl) this.d, (ProfileRatingAction) this.b);
            return Unit.INSTANCE;
        } else if (i == 1) {
            PublicProfilePresenter.Router router = ((PublicProfilePresenterImpl) this.d).e;
            if (router != null) {
                router.showPhotoGallery((Image) this.b);
            }
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}
