package a2.a.a.b.j;

import com.avito.android.authorization.select_social.SelectSocialPresenterImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<Throwable, String> {
    public final /* synthetic */ SelectSocialPresenterImpl.h a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(SelectSocialPresenterImpl.h hVar) {
        super(1);
        this.a = hVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public String invoke(Throwable th) {
        return this.a.a.k.getSocialAuthenticationError();
    }
}
