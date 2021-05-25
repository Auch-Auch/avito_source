package com.avito.android.analytics.features;

import android.content.Context;
import com.avito.android.enabler.AnalyticFeature;
import com.avito.android.enabler.AnalyticFeatures;
import com.avito.android.enabler.RemoteFeature;
import com.avito.android.enabler.RemoteFeatures;
import com.avito.android.enabler.TogglesStorage;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.toggle.Feature;
import com.avito.android.util.AvitoBuildInfo;
import com.jakewharton.rxrelay2.Relay;
import com.jakewharton.rxrelay2.ReplayRelay;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR(\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/avito/android/analytics/features/AvitoAnalyticFeatures;", "Lcom/avito/android/enabler/RemoteFeatures;", "Lcom/avito/android/enabler/AnalyticFeatures;", "Lcom/jakewharton/rxrelay2/Relay;", "Lcom/avito/android/enabler/RemoteFeature;", "", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/Relay;", "touchedFeaturesRelay", "Lcom/avito/android/enabler/TogglesStorage;", "c", "Lcom/avito/android/enabler/TogglesStorage;", "storage", "Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getTouchedFeatures", "()Lio/reactivex/Observable;", "touchedFeatures", "", "getHasCacheForCurrentVersion", "()Z", "hasCacheForCurrentVersion", "Landroid/content/Context;", "context", "Lcom/avito/android/util/AvitoBuildInfo;", "buildInfo", "<init>", "(Landroid/content/Context;Lcom/avito/android/util/AvitoBuildInfo;Lcom/avito/android/enabler/TogglesStorage;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public class AvitoAnalyticFeatures extends RemoteFeatures implements AnalyticFeatures {
    public final Relay<RemoteFeature<Object>> a;
    @NotNull
    public final Observable<RemoteFeature<Object>> b;
    public final TogglesStorage c;

    public static final class a extends Lambda implements Function1<Feature<? extends Object>, Feature<? extends Object>> {
        public final /* synthetic */ AvitoAnalyticFeatures a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AvitoAnalyticFeatures avitoAnalyticFeatures) {
            super(1);
            this.a = avitoAnalyticFeatures;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Feature<? extends Object> invoke(Feature<? extends Object> feature) {
            Feature<? extends Object> feature2 = feature;
            Intrinsics.checkNotNullParameter(feature2, "feature");
            return feature2 instanceof RemoteFeature ? new AnalyticFeature((RemoteFeature) feature2, new a2.a.a.i.f.a(this)) : feature2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AvitoAnalyticFeatures(@NotNull Context context, @NotNull AvitoBuildInfo avitoBuildInfo, @NotNull TogglesStorage togglesStorage) {
        super(context, avitoBuildInfo, togglesStorage);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(avitoBuildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(togglesStorage, "storage");
        this.c = togglesStorage;
        Relay<RemoteFeature<Object>> serialized = ReplayRelay.create().toSerialized();
        Intrinsics.checkNotNullExpressionValue(serialized, "ReplayRelay.create<Remot…re<Any>>().toSerialized()");
        this.a = serialized;
        this.b = serialized;
        decorate(new a(this));
    }

    @Override // com.avito.android.enabler.AnalyticFeatures
    public boolean getHasCacheForCurrentVersion() {
        return this.c.getHasCacheForCurrentVersion();
    }

    @Override // com.avito.android.enabler.AnalyticFeatures
    @NotNull
    public Observable<RemoteFeature<Object>> getTouchedFeatures() {
        return this.b;
    }
}
