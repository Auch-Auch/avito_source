package com.avito.android.brandspace.items.news;

import android.view.View;
import com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor;
import com.avito.android.brandspace.presenter.BrandspacePresenter;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/brandspace/items/news/NewsItemPresenterImpl;", "Lcom/avito/android/brandspace/items/news/NewsItemPresenter;", "Lcom/avito/android/brandspace/items/news/NewsItemView;", "view", "Lcom/avito/android/brandspace/items/news/NewsItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/brandspace/items/news/NewsItemView;Lcom/avito/android/brandspace/items/news/NewsItem;I)V", "Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", "brandspacePresenter", "<init>", "(Lcom/avito/android/brandspace/presenter/BrandspacePresenter;Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class NewsItemPresenterImpl implements NewsItemPresenter {
    public final BrandspacePresenter a;
    public final BrandspaceAnalyticsInteractor b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ DeepLink a;
        public final /* synthetic */ NewsItemPresenterImpl b;
        public final /* synthetic */ NewsItem c;

        public a(DeepLink deepLink, NewsItemPresenterImpl newsItemPresenterImpl, NewsItem newsItem) {
            this.a = deepLink;
            this.b = newsItemPresenterImpl;
            this.c = newsItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            BrandspaceAnalyticsInteractor.DefaultImpls.trackBlockClick$default(this.b.b, this.c, this.a, false, 4, null);
            this.b.a.openDeeplink(this.a);
        }
    }

    @Inject
    public NewsItemPresenterImpl(@NotNull BrandspacePresenter brandspacePresenter, @NotNull BrandspaceAnalyticsInteractor brandspaceAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(brandspacePresenter, "brandspacePresenter");
        Intrinsics.checkNotNullParameter(brandspaceAnalyticsInteractor, "analyticsInteractor");
        this.a = brandspacePresenter;
        this.b = brandspaceAnalyticsInteractor;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003d, code lost:
        if ((!(r5 == null || t6.y.m.isBlank(r5))) != false) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindView(@org.jetbrains.annotations.NotNull com.avito.android.brandspace.items.news.NewsItemView r9, @org.jetbrains.annotations.NotNull com.avito.android.brandspace.items.news.NewsItem r10, int r11) {
        /*
            r8 = this;
            java.lang.String r11 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r11)
            java.lang.String r11 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r11)
            com.avito.android.remote.model.Image r1 = r10.getImage()
            java.lang.String r2 = r10.getTitle()
            java.lang.String r3 = r10.getDescription()
            com.avito.android.remote.model.Action r11 = r10.getAction()
            r0 = 1
            r4 = 0
            if (r11 == 0) goto L_0x0040
            java.lang.String r11 = r11.getTitle()
            if (r11 == 0) goto L_0x0040
            com.avito.android.remote.model.Action r5 = r10.getAction()
            com.avito.android.deep_linking.links.DeepLink r5 = r5.getDeepLink()
            java.lang.String r5 = r5.getPath()
            if (r5 == 0) goto L_0x003b
            boolean r5 = t6.y.m.isBlank(r5)
            if (r5 == 0) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            r5 = 0
            goto L_0x003c
        L_0x003b:
            r5 = 1
        L_0x003c:
            r5 = r5 ^ r0
            if (r5 == 0) goto L_0x0040
            goto L_0x0041
        L_0x0040:
            r11 = r4
        L_0x0041:
            int r5 = r10.getPrecalculatedTextHeight()
            com.avito.android.remote.model.Action r6 = r10.getAction()
            if (r6 == 0) goto L_0x0061
            com.avito.android.deep_linking.links.DeepLink r6 = r6.getDeepLink()
            if (r6 == 0) goto L_0x0061
            boolean r7 = r6 instanceof com.avito.android.deep_linking.links.NoMatchLink
            r0 = r0 ^ r7
            if (r0 == 0) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            r6 = r4
        L_0x0058:
            if (r6 == 0) goto L_0x0061
            com.avito.android.brandspace.items.news.NewsItemPresenterImpl$a r0 = new com.avito.android.brandspace.items.news.NewsItemPresenterImpl$a
            r0.<init>(r6, r8, r10)
            r6 = r0
            goto L_0x0062
        L_0x0061:
            r6 = r4
        L_0x0062:
            r0 = r9
            r4 = r11
            r0.bind(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.brandspace.items.news.NewsItemPresenterImpl.bindView(com.avito.android.brandspace.items.news.NewsItemView, com.avito.android.brandspace.items.news.NewsItem, int):void");
    }
}
