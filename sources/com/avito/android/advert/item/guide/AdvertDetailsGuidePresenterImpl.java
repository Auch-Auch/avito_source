package com.avito.android.advert.item.guide;

import android.content.res.Resources;
import android.net.Uri;
import android.view.ViewGroup;
import com.avito.android.advert.item.guide.AdvertDetailsGuidePresenter;
import com.avito.android.advert.item.guide.di.GuideSections;
import com.avito.android.advert.item.guide.section.GuideSectionItem;
import com.avito.android.advert.item.guide.section.GuideSectionItemPresenter;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.analytics.guide.FromGuideBlock;
import com.avito.android.advert_details.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.guide.GuideSection;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\b\u0007\u0012\b\b\u0001\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b!\u0010\"J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006#"}, d2 = {"Lcom/avito/android/advert/item/guide/AdvertDetailsGuidePresenterImpl;", "Lcom/avito/android/advert/item/guide/AdvertDetailsGuidePresenter;", "Lcom/avito/android/advert/item/guide/AdvertDetailsGuideView;", "view", "Lcom/avito/android/advert/item/guide/AdvertDetailsGuideItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/guide/AdvertDetailsGuideView;Lcom/avito/android/advert/item/guide/AdvertDetailsGuideItem;I)V", "Lcom/avito/android/advert/item/guide/AdvertDetailsGuidePresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/advert/item/guide/AdvertDetailsGuidePresenter$Router;)V", "detachRouter", "()V", "Landroid/net/Uri;", "url", "onGuideLinkClick", "(Landroid/net/Uri;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "sectionsAdapterPresenter", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/item/guide/AdvertDetailsGuidePresenter$Router;", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "c", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/advert/item/guide/section/GuideSectionItemPresenter;", "guideSectionItemPresenter", "<init>", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/advert/item/guide/section/GuideSectionItemPresenter;Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsGuidePresenterImpl implements AdvertDetailsGuidePresenter {
    public AdvertDetailsGuidePresenter.Router a;
    public final AdapterPresenter b;
    public final AdvertDetailsAnalyticsInteractor c;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AdvertDetailsGuidePresenterImpl a;
        public final /* synthetic */ AdvertDetailsGuideItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdvertDetailsGuidePresenterImpl advertDetailsGuidePresenterImpl, AdvertDetailsGuideItem advertDetailsGuideItem) {
            super(0);
            this.a = advertDetailsGuidePresenterImpl;
            this.b = advertDetailsGuideItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.c.sendClickGuide(this.b.getIid(), FromGuideBlock.LINK);
            this.a.onGuideLinkClick(this.b.getLink().getUrl());
            return Unit.INSTANCE;
        }
    }

    @Inject
    public AdvertDetailsGuidePresenterImpl(@GuideSections @NotNull AdapterPresenter adapterPresenter, @NotNull GuideSectionItemPresenter guideSectionItemPresenter, @NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "sectionsAdapterPresenter");
        Intrinsics.checkNotNullParameter(guideSectionItemPresenter, "guideSectionItemPresenter");
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "analyticsInteractor");
        this.b = adapterPresenter;
        this.c = advertDetailsAnalyticsInteractor;
        guideSectionItemPresenter.setOnGuideLinkClickListener(this);
    }

    @Override // com.avito.android.advert.item.guide.AdvertDetailsGuidePresenter
    public void attachRouter(@NotNull AdvertDetailsGuidePresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.a = router;
    }

    @Override // com.avito.android.advert.item.guide.AdvertDetailsGuidePresenter
    public void detachRouter() {
        this.a = null;
    }

    @Override // com.avito.android.advert.item.guide.OnGuideLinkClickListener
    public void onGuideLinkClick(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "url");
        AdvertDetailsGuidePresenter.Router router = this.a;
        if (router != null) {
            router.openGuideLink(uri);
        }
    }

    public void bindView(@NotNull AdvertDetailsGuideView advertDetailsGuideView, @NotNull AdvertDetailsGuideItem advertDetailsGuideItem, int i) {
        T t;
        int i2;
        int i3;
        boolean z;
        Intrinsics.checkNotNullParameter(advertDetailsGuideView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsGuideItem, "item");
        if (advertDetailsGuideItem.getShowTopDivider()) {
            advertDetailsGuideView.showTopDivider();
        } else {
            advertDetailsGuideView.hideTopDivider();
        }
        if (advertDetailsGuideItem.getTitle() == null) {
            advertDetailsGuideView.hideTitle();
        } else {
            advertDetailsGuideView.showTitle(advertDetailsGuideItem.getTitle());
        }
        if (advertDetailsGuideItem.getLink() == null) {
            advertDetailsGuideView.hideLink();
        } else {
            advertDetailsGuideView.showLink(advertDetailsGuideItem.getLink(), new a(this, advertDetailsGuideItem));
        }
        List<GuideSection> sections = advertDetailsGuideItem.getSections();
        boolean z2 = false;
        boolean z3 = sections.size() == 1;
        Iterator<T> it = sections.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            String description = t.getDescription();
            if (description == null || description.length() <= 0) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        if (t != null) {
            z2 = true;
        }
        if (z3) {
            i2 = -1;
        } else {
            i2 = advertDetailsGuideView.getContext().getResources().getDimensionPixelSize(R.dimen.guide_section_min_width);
        }
        Resources resources = advertDetailsGuideView.getContext().getResources();
        if (z2) {
            i3 = R.dimen.guide_section_max_height;
        } else {
            i3 = R.dimen.guide_section_min_height;
        }
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(i2, resources.getDimensionPixelSize(i3));
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(sections, 10));
        Iterator<T> it2 = sections.iterator();
        while (it2.hasNext()) {
            arrayList.add(new GuideSectionItem(0, null, advertDetailsGuideItem.getIid(), it2.next(), layoutParams, 3, null));
        }
        this.b.onDataSourceChanged(new ListDataSource(arrayList));
    }
}
