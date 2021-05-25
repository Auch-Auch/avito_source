package a2.a.a.g.n;

import com.avito.android.advert_core.social.SocialPresenterImpl;
import com.avito.android.advert_core.social.SocialView;
import com.avito.android.social.SharingManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<SharingManager.ShareError, Unit> {
    public final /* synthetic */ SocialPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(SocialPresenterImpl socialPresenterImpl) {
        super(1);
        this.a = socialPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(SharingManager.ShareError shareError) {
        SocialView socialView;
        SharingManager.ShareError shareError2 = shareError;
        Intrinsics.checkNotNullParameter(shareError2, "error");
        if (shareError2 instanceof SharingManager.ShareError.NoConnection) {
            SocialView socialView2 = this.a.b;
            if (socialView2 != null) {
                socialView2.showConnectivityError();
            }
        } else if ((shareError2 instanceof SharingManager.ShareError.Unknown) && (socialView = this.a.b) != null) {
            socialView.showUnknownError();
        }
        return Unit.INSTANCE;
    }
}
