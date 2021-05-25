package com.avito.android.serp.adapter.map_banner;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/serp/adapter/map_banner/MapBannerItemPresenterImpl;", "Lcom/avito/android/serp/adapter/map_banner/MapBannerItemPresenter;", "Lcom/avito/android/serp/adapter/map_banner/MapBannerItemView;", "view", "Lcom/avito/android/serp/adapter/map_banner/MapBannerItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/serp/adapter/map_banner/MapBannerItemView;Lcom/avito/android/serp/adapter/map_banner/MapBannerItem;I)V", "Ldagger/Lazy;", "Lcom/avito/android/serp/adapter/map_banner/MapBannerItemListener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ldagger/Lazy;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class MapBannerItemPresenterImpl implements MapBannerItemPresenter {
    public final Lazy<MapBannerItemListener> a;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Throwable> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                Logs.error(th);
            } else if (i == 1) {
                Logs.error(th);
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        public b(int i, Object obj, Object obj2) {
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                MapBannerItemPresenterImpl.access$followDeeplink((MapBannerItemPresenterImpl) this.b, ((MapBannerItem) this.c).getDeepLink());
            } else if (i == 1) {
                MapBannerItemPresenterImpl.access$followDeeplink((MapBannerItemPresenterImpl) this.b, ((MapBannerItem) this.c).getDeepLink());
            } else {
                throw null;
            }
        }
    }

    @Inject
    public MapBannerItemPresenterImpl(@NotNull Lazy<MapBannerItemListener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = lazy;
    }

    public static final void access$followDeeplink(MapBannerItemPresenterImpl mapBannerItemPresenterImpl, DeepLink deepLink) {
        Objects.requireNonNull(mapBannerItemPresenterImpl);
        if (deepLink != null) {
            mapBannerItemPresenterImpl.a.get().onSearchOnMapClicked(deepLink);
        }
    }

    public void bindView(@NotNull MapBannerItemView mapBannerItemView, @NotNull MapBannerItem mapBannerItem, int i) {
        Intrinsics.checkNotNullParameter(mapBannerItemView, "view");
        Intrinsics.checkNotNullParameter(mapBannerItem, "item");
        mapBannerItemView.setImage(mapBannerItem.getDarkMapScreenUri(), mapBannerItem.getLightMapScreenUri());
        mapBannerItemView.setButtonText(mapBannerItem.getButtonText());
        mapBannerItemView.getButtonClicks().subscribe(new b(0, this, mapBannerItem), a.b);
        mapBannerItemView.getMapImageClicks().subscribe(new b(1, this, mapBannerItem), a.c);
    }
}
