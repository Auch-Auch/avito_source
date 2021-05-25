package com.avito.android.brandspace.items.news;

import com.avito.android.brandspace.items.news.NewsItemView;
import com.avito.android.brandspace.items.textmeasurement.TextItemMeasurer;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8V@\u0016X\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/brandspace/items/news/NewsItemMeasurer;", "Lcom/avito/android/brandspace/items/textmeasurement/TextItemMeasurer;", "Lcom/avito/android/brandspace/items/news/NewsItem;", "", "prepare", "()V", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurableItem;", "item", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasuredLayout;", "measure", "(Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurableItem;)Lcom/avito/android/brandspace/items/textmeasurement/TextMeasuredLayout;", "", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getMeasurerHash", "()I", "measurerHash", "Ldagger/Lazy;", "Lcom/avito/android/brandspace/items/news/NewsItemView$Measurer;", AuthSource.BOOKING_ORDER, "Ldagger/Lazy;", "lazyMeasurer", "<init>", "(Ldagger/Lazy;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class NewsItemMeasurer implements TextItemMeasurer<NewsItem> {
    @NotNull
    public final Lazy a = c.lazy(new a(this));
    public final dagger.Lazy<NewsItemView.Measurer> b;

    public static final class a extends Lambda implements Function0<Integer> {
        public final /* synthetic */ NewsItemMeasurer a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(NewsItemMeasurer newsItemMeasurer) {
            super(0);
            this.a = newsItemMeasurer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Integer invoke() {
            return Integer.valueOf(NewsItemMeasurer.access$getMeasurer$p(this.a).hashCode());
        }
    }

    @Inject
    public NewsItemMeasurer(@NotNull dagger.Lazy<NewsItemView.Measurer> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "lazyMeasurer");
        this.b = lazy;
    }

    public static final NewsItemView.Measurer access$getMeasurer$p(NewsItemMeasurer newsItemMeasurer) {
        NewsItemView.Measurer measurer = newsItemMeasurer.b.get();
        Intrinsics.checkNotNullExpressionValue(measurer, "lazyMeasurer.get()");
        return measurer;
    }

    @Override // com.avito.android.brandspace.items.textmeasurement.TextItemMeasurer
    public int getMeasurerHash() {
        return ((Number) this.a.getValue()).intValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0046, code lost:
        if ((!(r6 == null || t6.y.m.isBlank(r6))) != false) goto L_0x004a;
     */
    @Override // com.avito.android.brandspace.items.textmeasurement.TextItemMeasurer
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.brandspace.items.textmeasurement.TextMeasuredLayout measure(@org.jetbrains.annotations.NotNull com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem r6) {
        /*
            r5 = this;
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.avito.android.brandspace.items.news.NewsItem r6 = (com.avito.android.brandspace.items.news.NewsItem) r6
            dagger.Lazy<com.avito.android.brandspace.items.news.NewsItemView$Measurer> r0 = r5.b
            java.lang.Object r0 = r0.get()
            java.lang.String r1 = "lazyMeasurer.get()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.avito.android.brandspace.items.news.NewsItemView$Measurer r0 = (com.avito.android.brandspace.items.news.NewsItemView.Measurer) r0
            java.lang.String r1 = r6.getTitle()
            java.lang.String r2 = r6.getDescription()
            com.avito.android.remote.model.Action r3 = r6.getAction()
            if (r3 == 0) goto L_0x0049
            java.lang.String r3 = r3.getTitle()
            if (r3 == 0) goto L_0x0049
            com.avito.android.remote.model.Action r6 = r6.getAction()
            com.avito.android.deep_linking.links.DeepLink r6 = r6.getDeepLink()
            android.net.Uri r6 = r6.getUri()
            java.lang.String r6 = r6.getPath()
            r4 = 1
            if (r6 == 0) goto L_0x0044
            boolean r6 = t6.y.m.isBlank(r6)
            if (r6 == 0) goto L_0x0042
            goto L_0x0044
        L_0x0042:
            r6 = 0
            goto L_0x0045
        L_0x0044:
            r6 = 1
        L_0x0045:
            r6 = r6 ^ r4
            if (r6 == 0) goto L_0x0049
            goto L_0x004a
        L_0x0049:
            r3 = 0
        L_0x004a:
            com.avito.android.brandspace.items.news.NewsItemView$Layout r6 = r0.measure(r1, r2, r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.brandspace.items.news.NewsItemMeasurer.measure(com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem):com.avito.android.brandspace.items.textmeasurement.TextMeasuredLayout");
    }

    @Override // com.avito.android.brandspace.items.textmeasurement.TextItemMeasurer
    public void prepare() {
        this.b.get();
    }
}
