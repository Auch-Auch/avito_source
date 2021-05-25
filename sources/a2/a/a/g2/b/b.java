package a2.a.a.g2.b;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.rating.publish.RatingPublishPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function0<Unit> {
    public final /* synthetic */ RatingPublishPresenterImpl a;
    public final /* synthetic */ DeepLink b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(RatingPublishPresenterImpl ratingPublishPresenterImpl, DeepLink deepLink) {
        super(0);
        this.a = ratingPublishPresenterImpl;
        this.b = deepLink;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.a(this.b);
        return Unit.INSTANCE;
    }
}
