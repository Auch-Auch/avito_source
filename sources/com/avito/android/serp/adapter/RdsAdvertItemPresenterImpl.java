package com.avito.android.serp.adapter;

import com.avito.android.analytics.Analytics;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ImageKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.y;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B7\u0012\u000e\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u001f\u0010 J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/serp/adapter/RdsAdvertItemPresenterImpl;", "Lcom/avito/android/serp/adapter/RdsAdvertItemPresenter;", "Lcom/avito/android/serp/adapter/RdsAdvertItemView;", "view", "Lcom/avito/android/serp/adapter/AdvertItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/serp/adapter/RdsAdvertItemView;Lcom/avito/android/serp/adapter/AdvertItem;I)V", "Lcom/avito/android/image_loader/Picture;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/serp/adapter/AdvertItem;)Lcom/avito/android/image_loader/Picture;", "", "", "c", "Ljava/util/Set;", "excludeFields", "", "d", "Z", "cancelImageLoadingOnDetach", "Ldagger/Lazy;", "Lcom/avito/android/serp/adapter/AdvertItemListener;", "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Ldagger/Lazy;Lcom/avito/android/analytics/Analytics;Ljava/util/Set;Z)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public class RdsAdvertItemPresenterImpl implements RdsAdvertItemPresenter {
    public final Lazy<? extends AdvertItemListener> a;
    public final Analytics b;
    public final Set<String> c;
    public final boolean d;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Object e;
        public final /* synthetic */ Object f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, int i2, Object obj, Object obj2, Object obj3, Object obj4) {
            super(0);
            this.a = i;
            this.b = i2;
            this.c = obj;
            this.d = obj2;
            this.e = obj3;
            this.f = obj4;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                AdvertItem advertItem = (AdvertItem) this.e;
                ((AdvertItemListener) ((RdsAdvertItemPresenterImpl) this.d).a.get()).onAdvertClicked(advertItem, this.b, RdsAdvertItemPresenterImpl.access$createImage((RdsAdvertItemPresenterImpl) this.d, (RdsAdvertItemView) this.f, advertItem));
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((AdvertItemListener) ((RdsAdvertItemPresenterImpl) this.d).a.get()).onFavoriteButtonClicked((AdvertItem) this.e);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public RdsAdvertItemPresenterImpl(@NotNull Lazy<? extends AdvertItemListener> lazy, @NotNull Analytics analytics, @NotNull Set<String> set, boolean z) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(set, "excludeFields");
        this.a = lazy;
        this.b = analytics;
        this.c = set;
        this.d = z;
    }

    public static final Image access$createImage(RdsAdvertItemPresenterImpl rdsAdvertItemPresenterImpl, RdsAdvertItemView rdsAdvertItemView, AdvertItem advertItem) {
        return ImageKt.toSingleImage(rdsAdvertItemView.getPictureUri(rdsAdvertItemPresenterImpl.a(advertItem)));
    }

    public final Picture a(AdvertItem advertItem) {
        Picture pictureOf$default;
        ForegroundImage infoImage = advertItem.getInfoImage();
        return (infoImage == null || (pictureOf$default = AvitoPictureKt.pictureOf$default(false, 0.0f, 0.0f, infoImage, 6, null)) == null) ? AvitoPictureKt.pictureOf$default(advertItem.getImage(), false, 0.0f, 0.0f, null, 28, null) : pictureOf$default;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RdsAdvertItemPresenterImpl(Lazy lazy, Analytics analytics, Set set, boolean z, int i, j jVar) {
        this(lazy, analytics, (i & 4) != 0 ? y.emptySet() : set, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0107  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindView(@org.jetbrains.annotations.NotNull com.avito.android.serp.adapter.RdsAdvertItemView r10, @org.jetbrains.annotations.NotNull com.avito.android.serp.adapter.AdvertItem r11, int r12) {
        /*
        // Method dump skipped, instructions count: 303
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.serp.adapter.RdsAdvertItemPresenterImpl.bindView(com.avito.android.serp.adapter.RdsAdvertItemView, com.avito.android.serp.adapter.AdvertItem, int):void");
    }
}
