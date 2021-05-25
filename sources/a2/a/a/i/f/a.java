package a2.a.a.i.f;

import com.avito.android.analytics.features.AvitoAnalyticFeatures;
import com.avito.android.enabler.RemoteFeature;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<RemoteFeature<Object>, Unit> {
    public final /* synthetic */ AvitoAnalyticFeatures.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(AvitoAnalyticFeatures.a aVar) {
        super(1);
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(RemoteFeature<Object> remoteFeature) {
        RemoteFeature<Object> remoteFeature2 = remoteFeature;
        Intrinsics.checkNotNullParameter(remoteFeature2, "it");
        this.a.a.a.accept(remoteFeature2);
        return Unit.INSTANCE;
    }
}
