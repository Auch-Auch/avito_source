package a2.a.a.h3.a;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.MyAdvertLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.deep_linking.links.SendEmailLink;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import com.avito.android.user_advert.advert.MyAdvertRouter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class i0 implements OnDeepLinkClickListener {
    public final /* synthetic */ MyAdvertDetailsPresenterImpl a;

    public i0(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl) {
        this.a = myAdvertDetailsPresenterImpl;
    }

    @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
    public final void onDeepLinkClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        if (deepLink instanceof SendEmailLink) {
            SendEmailLink sendEmailLink = (SendEmailLink) deepLink;
            String toEmail = sendEmailLink.getToEmail();
            String subject = sendEmailLink.getSubject();
            StringBuilder sb = new StringBuilder();
            sb.append(this.a.G.getSupportEmailText());
            String info = sendEmailLink.getInfo();
            if (info == null) {
                info = "";
            }
            sb.append(info);
            SendEmailLink sendEmailLink2 = new SendEmailLink(toEmail, subject, sb.toString());
            MyAdvertRouter myAdvertRouter = this.a.a;
            if (myAdvertRouter != null) {
                myAdvertRouter.openDeepLink(sendEmailLink2);
            }
        } else if (deepLink instanceof MyAdvertLink.Edit) {
            MyAdvertRouter myAdvertRouter2 = this.a.a;
            if (myAdvertRouter2 != null) {
                MyAdvertLink.Edit edit = (MyAdvertLink.Edit) deepLink;
                MyAdvertRouter.DefaultImpls.openEdit$default(myAdvertRouter2, edit.getItemId(), edit.getPostAction(), null, 4, null);
            }
        } else {
            MyAdvertRouter myAdvertRouter3 = this.a.a;
            if (myAdvertRouter3 != null) {
                myAdvertRouter3.openDeepLink(deepLink);
            }
        }
    }
}
