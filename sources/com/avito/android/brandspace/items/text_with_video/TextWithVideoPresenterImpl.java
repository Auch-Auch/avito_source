package com.avito.android.brandspace.items.text_with_video;

import android.view.View;
import com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.presenter.BrandspacePresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/brandspace/items/text_with_video/TextWithVideoPresenterImpl;", "Lcom/avito/android/brandspace/items/text_with_video/TextWithVideoPresenter;", "Lcom/avito/android/brandspace/items/text_with_video/TextWithVideoItemView;", "view", "Lcom/avito/android/brandspace/items/text_with_video/TextWithVideoItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/brandspace/items/text_with_video/TextWithVideoItemView;Lcom/avito/android/brandspace/items/text_with_video/TextWithVideoItem;I)V", "Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", "brandspacePresenter", "<init>", "(Lcom/avito/android/brandspace/presenter/BrandspacePresenter;Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class TextWithVideoPresenterImpl implements TextWithVideoPresenter {
    public final BrandspacePresenter a;
    public final BrandspaceAnalyticsInteractor b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Action a;
        public final /* synthetic */ TextWithVideoPresenterImpl b;
        public final /* synthetic */ TextWithVideoItem c;

        public a(Action action, TextWithVideoPresenterImpl textWithVideoPresenterImpl, TextWithVideoItem textWithVideoItem) {
            this.a = action;
            this.b = textWithVideoPresenterImpl;
            this.c = textWithVideoItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            BrandspaceAnalyticsInteractor.DefaultImpls.trackBlockClick$default(this.b.b, this.c, this.a.getDeepLink(), false, 4, null);
            this.b.a.openDeeplink(this.a.getDeepLink());
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ TextWithVideoPresenterImpl a;
        public final /* synthetic */ TextWithVideoItem b;

        public b(TextWithVideoPresenterImpl textWithVideoPresenterImpl, TextWithVideoItem textWithVideoItem) {
            this.a = textWithVideoPresenterImpl;
            this.b = textWithVideoItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            BrandspaceAnalyticsInteractor.DefaultImpls.trackBlockClick$default(this.a.b, this.b, null, false, 4, null);
            this.a.a.openVideoUrl(this.b.getVideoUrl(), BlockType.BS_TEXT_WITH_VIDEO.getValue());
        }
    }

    @Inject
    public TextWithVideoPresenterImpl(@NotNull BrandspacePresenter brandspacePresenter, @NotNull BrandspaceAnalyticsInteractor brandspaceAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(brandspacePresenter, "brandspacePresenter");
        Intrinsics.checkNotNullParameter(brandspaceAnalyticsInteractor, "analyticsInteractor");
        this.a = brandspacePresenter;
        this.b = brandspaceAnalyticsInteractor;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindView(@org.jetbrains.annotations.NotNull com.avito.android.brandspace.items.text_with_video.TextWithVideoItemView r11, @org.jetbrains.annotations.NotNull com.avito.android.brandspace.items.text_with_video.TextWithVideoItem r12, int r13) {
        /*
            r10 = this;
            java.lang.String r13 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r13)
            java.lang.String r13 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r13)
            com.avito.android.remote.model.Image r1 = r12.getImage()
            com.avito.android.brandspace.remote.model.BrandspaceTextWithVideoImagePlacement r13 = r12.getImagePlacement()
            com.avito.android.brandspace.remote.model.BrandspaceTextWithVideoImagePlacement r0 = com.avito.android.brandspace.remote.model.BrandspaceTextWithVideoImagePlacement.RIGHT
            r2 = 0
            r3 = 1
            if (r13 != r0) goto L_0x001a
            r13 = 1
            goto L_0x001b
        L_0x001a:
            r13 = 0
        L_0x001b:
            java.lang.String r4 = r12.getTitle()
            java.lang.String r5 = r12.getDescription()
            java.lang.String r6 = r12.getAdditionalDescription()
            com.avito.android.remote.model.Action r0 = r12.getAction()
            r7 = 0
            if (r0 == 0) goto L_0x004e
            java.lang.String r0 = r0.getTitle()
            if (r0 == 0) goto L_0x004e
            com.avito.android.remote.model.Action r8 = r12.getAction()
            com.avito.android.deep_linking.links.DeepLink r8 = r8.getDeepLink()
            java.lang.String r8 = r8.getPath()
            if (r8 == 0) goto L_0x0048
            boolean r8 = t6.y.m.isBlank(r8)
            if (r8 == 0) goto L_0x0049
        L_0x0048:
            r2 = 1
        L_0x0049:
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x004e
            r8 = r0
            goto L_0x004f
        L_0x004e:
            r8 = r7
        L_0x004f:
            com.avito.android.remote.model.Action r0 = r12.getAction()
            if (r0 == 0) goto L_0x0068
            com.avito.android.deep_linking.links.DeepLink r2 = r0.getDeepLink()
            boolean r2 = r2 instanceof com.avito.android.deep_linking.links.NoMatchLink
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r0 = r7
        L_0x0060:
            if (r0 == 0) goto L_0x0068
            com.avito.android.brandspace.items.text_with_video.TextWithVideoPresenterImpl$a r2 = new com.avito.android.brandspace.items.text_with_video.TextWithVideoPresenterImpl$a
            r2.<init>(r0, r10, r12)
            r7 = r2
        L_0x0068:
            com.avito.android.brandspace.items.text_with_video.TextWithVideoPresenterImpl$b r9 = new com.avito.android.brandspace.items.text_with_video.TextWithVideoPresenterImpl$b
            r9.<init>(r10, r12)
            r0 = r11
            r2 = r13
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r8
            r8 = r9
            r0.bind(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.brandspace.items.text_with_video.TextWithVideoPresenterImpl.bindView(com.avito.android.brandspace.items.text_with_video.TextWithVideoItemView, com.avito.android.brandspace.items.text_with_video.TextWithVideoItem, int):void");
    }
}
