package com.avito.android.serp.adapter.rich_snippets;

import android.content.res.Resources;
import com.avito.android.ab_tests.SellerInfoInRichSnippet;
import com.avito.android.ab_tests.configs.SellerInfoInRichSnippetTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.SellerInfoParams;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u000e\b\u0001\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tR\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/avito/android/serp/adapter/rich_snippets/SellerInfoParamsFactoryImpl;", "Lcom/avito/android/serp/adapter/rich_snippets/SellerInfoParamsFactory;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams;", "createVasParams", "()Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams;", "createRegularParams", "createSmallParams", "Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams$SellerInfoBlockPosition;", AuthSource.SEND_ABUSE, "()Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams$SellerInfoBlockPosition;", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/configs/SellerInfoInRichSnippetTestGroup;", "c", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "getAbTestGroup", "()Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "abTestGroup", "", "I", "richVasItemOffset", AuthSource.BOOKING_ORDER, "richRegularItemOffset", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SellerInfoParamsFactoryImpl implements SellerInfoParamsFactory {
    public final int a;
    public final int b;
    @NotNull
    public final SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup> c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SellerInfoInRichSnippetTestGroup.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[3] = 1;
            iArr[4] = 2;
        }
    }

    @Inject
    public SellerInfoParamsFactoryImpl(@NotNull Resources resources, @SellerInfoInRichSnippet @NotNull SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup> singleManuallyExposedAbTestGroup) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(singleManuallyExposedAbTestGroup, "abTestGroup");
        this.c = singleManuallyExposedAbTestGroup;
        this.a = resources.getDimensionPixelOffset(R.dimen.rich_snippet_seller_info_vas_padding);
        this.b = resources.getDimensionPixelOffset(R.dimen.rich_snippet_seller_info_regular_padding);
    }

    public final SellerInfoParams.SellerInfoBlockPosition a() {
        int ordinal = this.c.getTestGroup().ordinal();
        if (ordinal == 3) {
            return SellerInfoParams.SellerInfoBlockPosition.BEFORE_ACTIONS;
        }
        if (ordinal != 4) {
            return SellerInfoParams.SellerInfoBlockPosition.NONE;
        }
        return SellerInfoParams.SellerInfoBlockPosition.AFTER_ACTIONS;
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.SellerInfoParamsFactory
    @NotNull
    public SellerInfoParams createRegularParams() {
        return new SellerInfoParams(this.b, false, 2, a());
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.SellerInfoParamsFactory
    @NotNull
    public SellerInfoParams createSmallParams() {
        return new SellerInfoParams(this.b, false, 1, a());
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.SellerInfoParamsFactory
    @NotNull
    public SellerInfoParams createVasParams() {
        return new SellerInfoParams(this.a, true, 2, a());
    }

    @NotNull
    public final SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup> getAbTestGroup() {
        return this.c;
    }
}
