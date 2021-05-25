package a2.a.a.y2;

import com.avito.android.remote.model.social.SocialNotification;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<SocialNotification, Boolean> {
    public final /* synthetic */ Set a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Set set) {
        super(1);
        this.a = set;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(SocialNotification socialNotification) {
        SocialNotification socialNotification2 = socialNotification;
        Intrinsics.checkNotNullParameter(socialNotification2, "it");
        return Boolean.valueOf(this.a.contains(socialNotification2.getId()));
    }
}
