package com.avito.android.advert_core.feature_teasers.common;

import com.avito.android.advert_core.feature_teasers.common.dialog.AdvertDetailsFeatureTeaserDialogInfo;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/advert_core/feature_teasers/common/CommonFeatureTeaserPresenter;", "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserPresenter;", "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserView;", "view", "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem;", "item", "", "bindView", "(Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserView;Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem;)V", "onAction", "", AuthSource.SEND_ABUSE, "()Z", "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserResourceProvider;", "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserResourceProvider;", "resourceProvider", "<init>", "(Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserResourceProvider;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public class CommonFeatureTeaserPresenter implements FeatureTeaserPresenter {
    public final FeatureTeaserResourceProvider a;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2, Object obj3) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
            this.d = obj3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((CommonFeatureTeaserPresenter) this.b).onAction((FeatureTeaserView) this.d, (AdvertDetailsFeatureTeaserItem) this.c);
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((CommonFeatureTeaserPresenter) this.b).onAction((FeatureTeaserView) this.d, (AdvertDetailsFeatureTeaserItem) this.c);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    @Inject
    public CommonFeatureTeaserPresenter(@NotNull FeatureTeaserResourceProvider featureTeaserResourceProvider) {
        Intrinsics.checkNotNullParameter(featureTeaserResourceProvider, "resourceProvider");
        this.a = featureTeaserResourceProvider;
    }

    public final boolean a() {
        return !this.a.isTablet() && !this.a.isLandscape();
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.FeatureTeaserPresenter
    public void bindView(@NotNull FeatureTeaserView featureTeaserView, @NotNull AdvertDetailsFeatureTeaserItem advertDetailsFeatureTeaserItem) {
        List<AdvertDetailsFeatureTeaserOption> list;
        Intrinsics.checkNotNullParameter(featureTeaserView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsFeatureTeaserItem, "item");
        AdvertDetailsFeatureTeaserOption title = advertDetailsFeatureTeaserItem.getTitle();
        String str = null;
        String name = title != null ? title.getName() : null;
        AdvertDetailsFeatureTeaserOption title2 = advertDetailsFeatureTeaserItem.getTitle();
        featureTeaserView.setTitle(name, title2 != null ? title2.getIcon() : null);
        featureTeaserView.setSubtitle(advertDetailsFeatureTeaserItem.getSubtitle());
        if (!(advertDetailsFeatureTeaserItem.getDialogInfo() instanceof AdvertDetailsFeatureTeaserDialogInfo.CheckedByAvito) || !a()) {
            list = advertDetailsFeatureTeaserItem.getFeatures();
        } else {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        featureTeaserView.setFeatures(list);
        if (!(advertDetailsFeatureTeaserItem.getDialogInfo() instanceof AdvertDetailsFeatureTeaserDialogInfo.CheckedByAvito) || a()) {
            str = advertDetailsFeatureTeaserItem.getAdditionalInfoLink();
        }
        featureTeaserView.setLinkText(str);
        featureTeaserView.setLinkTextClickListener(new a(0, this, advertDetailsFeatureTeaserItem, featureTeaserView));
        featureTeaserView.setButtonText(advertDetailsFeatureTeaserItem.getButtonText());
        featureTeaserView.setButtonClickListener(new a(1, this, advertDetailsFeatureTeaserItem, featureTeaserView));
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.FeatureTeaserPresenter
    public void onAction(@NotNull FeatureTeaserView featureTeaserView, @NotNull AdvertDetailsFeatureTeaserItem advertDetailsFeatureTeaserItem) {
        Intrinsics.checkNotNullParameter(featureTeaserView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsFeatureTeaserItem, "item");
        AdvertDetailsFeatureTeaserDialogInfo dialogInfo = advertDetailsFeatureTeaserItem.getDialogInfo();
        if (dialogInfo != null) {
            featureTeaserView.showDialog(dialogInfo);
        }
    }
}
