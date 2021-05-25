package a2.a.a.n;

import android.net.Uri;
import com.avito.android.autodeal_details.AutoDealDetailsActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function1<Uri, Unit> {
    public final /* synthetic */ AutoDealDetailsActivity a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(AutoDealDetailsActivity autoDealDetailsActivity) {
        super(1);
        this.a = autoDealDetailsActivity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Uri uri) {
        Uri uri2 = uri;
        Intrinsics.checkNotNullParameter(uri2, "it");
        AutoDealDetailsActivity.access$openImplicitIntent(this.a, uri2);
        return Unit.INSTANCE;
    }
}
