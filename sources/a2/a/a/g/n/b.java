package a2.a.a.g.n;

import com.avito.android.advert_core.social.SocialPresenterImpl;
import com.avito.android.advert_core.social.SocialShareListener;
import com.avito.android.social.SharingManager;
import com.avito.android.social.SignInSocialManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function0<Unit> {
    public final /* synthetic */ SharingManager a;
    public final /* synthetic */ SocialPresenterImpl b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(SharingManager sharingManager, SocialPresenterImpl socialPresenterImpl, boolean z) {
        super(0);
        this.a = sharingManager;
        this.b = socialPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        SharingManager sharingManager = this.a;
        if (sharingManager instanceof SignInSocialManager) {
            SocialPresenterImpl.access$shareWithLogin(this.b, (SignInSocialManager) sharingManager);
        } else {
            SocialShareListener socialShareListener = this.b.d;
            if (socialShareListener != null) {
                socialShareListener.onSocialShare(this.a, false);
            }
            this.b.b(this.a);
        }
        return Unit.INSTANCE;
    }
}
