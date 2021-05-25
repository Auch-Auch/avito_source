package com.avito.android.brandspace.items.mainbanner;

import android.view.View;
import com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor;
import com.avito.android.brandspace.presenter.BrandspacePresenter;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/brandspace/items/mainbanner/MainBannerItemPresenterImpl;", "Lcom/avito/android/brandspace/items/mainbanner/MainBannerItemPresenter;", "Lcom/avito/android/brandspace/items/mainbanner/MainBannerItemView;", "view", "Lcom/avito/android/brandspace/items/mainbanner/MainBannerItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/brandspace/items/mainbanner/MainBannerItemView;Lcom/avito/android/brandspace/items/mainbanner/MainBannerItem;I)V", "Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", "presenter", "<init>", "(Lcom/avito/android/brandspace/presenter/BrandspacePresenter;Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class MainBannerItemPresenterImpl implements MainBannerItemPresenter {
    public final BrandspacePresenter a;
    public final BrandspaceAnalyticsInteractor b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ MainBannerItemPresenterImpl a;
        public final /* synthetic */ MainBannerItem b;

        public a(MainBannerItemPresenterImpl mainBannerItemPresenterImpl, MainBannerItem mainBannerItem) {
            this.a = mainBannerItemPresenterImpl;
            this.b = mainBannerItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            BrandspaceAnalyticsInteractor brandspaceAnalyticsInteractor = this.a.b;
            MainBannerItem mainBannerItem = this.b;
            BrandspaceAnalyticsInteractor.DefaultImpls.trackBlockClick$default(brandspaceAnalyticsInteractor, mainBannerItem, mainBannerItem.getAction().getDeepLink(), false, 4, null);
            this.a.a.openDeeplink(this.b.getAction().getDeepLink());
        }
    }

    @Inject
    public MainBannerItemPresenterImpl(@NotNull BrandspacePresenter brandspacePresenter, @NotNull BrandspaceAnalyticsInteractor brandspaceAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(brandspacePresenter, "presenter");
        Intrinsics.checkNotNullParameter(brandspaceAnalyticsInteractor, "analyticsInteractor");
        this.a = brandspacePresenter;
        this.b = brandspaceAnalyticsInteractor;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindView(@org.jetbrains.annotations.NotNull com.avito.android.brandspace.items.mainbanner.MainBannerItemView r7, @org.jetbrains.annotations.NotNull com.avito.android.brandspace.items.mainbanner.MainBannerItem r8, int r9) {
        /*
            r6 = this;
            java.lang.String r9 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r9)
            java.lang.String r9 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r9)
            com.avito.android.remote.model.Image r1 = r8.getImage()
            java.lang.String r2 = r8.getTitle()
            java.lang.String r3 = r8.getDescription()
            com.avito.android.remote.model.Action r9 = r8.getAction()
            r0 = 0
            if (r9 == 0) goto L_0x0041
            java.lang.String r9 = r9.getTitle()
            if (r9 == 0) goto L_0x0041
            com.avito.android.remote.model.Action r4 = r8.getAction()
            com.avito.android.deep_linking.links.DeepLink r4 = r4.getDeepLink()
            java.lang.String r4 = r4.getPath()
            r5 = 1
            if (r4 == 0) goto L_0x003b
            boolean r4 = t6.y.m.isBlank(r4)
            if (r4 == 0) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            r4 = 0
            goto L_0x003c
        L_0x003b:
            r4 = 1
        L_0x003c:
            r4 = r4 ^ r5
            if (r4 == 0) goto L_0x0041
            r4 = r9
            goto L_0x0042
        L_0x0041:
            r4 = r0
        L_0x0042:
            com.avito.android.remote.model.Action r9 = r8.getAction()
            if (r9 == 0) goto L_0x004f
            com.avito.android.brandspace.items.mainbanner.MainBannerItemPresenterImpl$a r9 = new com.avito.android.brandspace.items.mainbanner.MainBannerItemPresenterImpl$a
            r9.<init>(r6, r8)
            r5 = r9
            goto L_0x0050
        L_0x004f:
            r5 = r0
        L_0x0050:
            r0 = r7
            r0.bind(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.brandspace.items.mainbanner.MainBannerItemPresenterImpl.bindView(com.avito.android.brandspace.items.mainbanner.MainBannerItemView, com.avito.android.brandspace.items.mainbanner.MainBannerItem, int):void");
    }
}
