package com.avito.android.advert.item.guide.section;

import android.net.Uri;
import android.view.View;
import com.avito.android.advert.item.guide.OnGuideLinkClickListener;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.analytics.guide.FromGuideBlock;
import com.avito.android.lib.design.R;
import com.avito.android.lib.util.DarkThemeManagerKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Color;
import com.avito.android.remote.model.guide.GuideSection;
import com.avito.android.util.Contexts;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/advert/item/guide/section/GuideSectionItemPresenterImpl;", "Lcom/avito/android/advert/item/guide/section/GuideSectionItemPresenter;", "Lcom/avito/android/advert/item/guide/OnGuideLinkClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setOnGuideLinkClickListener", "(Lcom/avito/android/advert/item/guide/OnGuideLinkClickListener;)V", "Lcom/avito/android/advert/item/guide/section/GuideSectionItemView;", "view", "Lcom/avito/android/advert/item/guide/section/GuideSectionItem;", "item", "", VKApiConst.POSITION, "bindView", "(Lcom/avito/android/advert/item/guide/section/GuideSectionItemView;Lcom/avito/android/advert/item/guide/section/GuideSectionItem;I)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/item/guide/OnGuideLinkClickListener;", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "analyticsInteractor", "<init>", "(Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class GuideSectionItemPresenterImpl implements GuideSectionItemPresenter {
    public OnGuideLinkClickListener a;
    public final AdvertDetailsAnalyticsInteractor b;

    public static final class a extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ GuideSectionItemPresenterImpl a;
        public final /* synthetic */ GuideSectionItem b;
        public final /* synthetic */ GuideSection c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(GuideSectionItemPresenterImpl guideSectionItemPresenterImpl, GuideSectionItem guideSectionItem, GuideSection guideSection) {
            super(1);
            this.a = guideSectionItemPresenterImpl;
            this.b = guideSectionItem;
            this.c = guideSection;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(View view) {
            Uri url;
            Intrinsics.checkNotNullParameter(view, "it");
            this.a.b.sendClickGuide(this.b.getIid(), FromGuideBlock.SECTION);
            OnGuideLinkClickListener onGuideLinkClickListener = this.a.a;
            if (!(onGuideLinkClickListener == null || (url = this.c.getUrl()) == null)) {
                onGuideLinkClickListener.onGuideLinkClick(url);
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public GuideSectionItemPresenterImpl(@NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "analyticsInteractor");
        this.b = advertDetailsAnalyticsInteractor;
    }

    @Override // com.avito.android.advert.item.guide.section.GuideSectionItemPresenter
    public void setOnGuideLinkClickListener(@Nullable OnGuideLinkClickListener onGuideLinkClickListener) {
        this.a = onGuideLinkClickListener;
    }

    public void bindView(@NotNull GuideSectionItemView guideSectionItemView, @NotNull GuideSectionItem guideSectionItem, int i) {
        Color color;
        Intrinsics.checkNotNullParameter(guideSectionItemView, "view");
        Intrinsics.checkNotNullParameter(guideSectionItem, "item");
        GuideSection guideSection = guideSectionItem.getGuideSection();
        guideSectionItemView.setLayoutParams(guideSectionItem.getLayoutParams());
        guideSectionItemView.setTitle(guideSection.getTitle());
        guideSectionItemView.setDescription(guideSection.getDescription());
        if (DarkThemeManagerKt.isDarkTheme(guideSectionItemView.getContext())) {
            color = guideSection.getBackgroundColorDark();
        } else {
            color = guideSection.getBackgroundColorLight();
        }
        guideSectionItemView.setBackgroundColor(color != null ? color.getValue() : Contexts.getColorByAttr(guideSectionItemView.getContext(), R.attr.blue100));
        guideSectionItemView.setOnClickListener(new a(this, guideSectionItem, guideSection));
    }
}
