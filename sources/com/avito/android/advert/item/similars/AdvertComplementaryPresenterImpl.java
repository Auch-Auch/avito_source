package com.avito.android.advert.item.similars;

import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.advert.item.AdvertDetailsItemsPresenter;
import com.avito.android.advert.item.commercials.AdvertCommercials;
import com.avito.android.advert.item.commercials.AdvertCommercialsConverter;
import com.avito.android.advert.item.commercials.AdvertSerpCommercialBanner;
import com.avito.android.advert.item.commercials.PositionedBannerContainer;
import com.avito.android.advert.tracker.AdvertDetailsTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.remote.model.CommercialBanner;
import com.avito.android.remote.model.LoadedNetworkBanner;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.section.SectionExpandButton;
import com.avito.android.remote.model.section.SectionResponse;
import com.avito.android.remote.model.section.SectionTypeElement;
import com.avito.android.remote.model.section.SectionTypeItem;
import com.avito.android.section.SectionItemConverter;
import com.avito.android.serp.adapter.PersistableSpannedItem;
import com.avito.android.serp.adapter.SerpCommercialBanner;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.util.Kundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010L\u001a\u00020I\u0012\u0006\u0010>\u001a\u00020;\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u0010Z\u001a\u00020W\u0012\u0006\u0010F\u001a\u00020C¢\u0006\u0004\b]\u0010^J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\rJ\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0011J\u0019\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b#\u0010$J#\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u000e2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u000eH\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u000bH\u0016¢\u0006\u0004\b*\u0010\rJ5\u0010/\u001a\u00020\u00022\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020\u000b2\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\u00022\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0002H\u0016¢\u0006\u0004\b7\u0010\u0004J\u000f\u00108\u001a\u00020\u0002H\u0016¢\u0006\u0004\b8\u0010\u0004J\u000f\u00109\u001a\u00020\u000bH\u0016¢\u0006\u0004\b9\u0010\rJ\u0017\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001010\u000eH\u0016¢\u0006\u0004\b:\u0010\u0011R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00020\u000f0M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010S\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00160M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010O¨\u0006_"}, d2 = {"Lcom/avito/android/advert/item/similars/AdvertComplementaryPresenterImpl;", "Lcom/avito/android/advert/item/similars/AdvertComplementaryPresenter;", "", "clearItems", "()V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "restoreState", "onRestoreState", "(Lcom/avito/android/util/Kundle;)V", "", "isSimilarsLoaded", "()Z", "", "Lcom/avito/android/remote/model/section/SectionTypeElement;", "getSimilars", "()Ljava/util/List;", "Lcom/avito/android/remote/model/section/SectionResponse;", "getSectionsData", "()Lcom/avito/android/remote/model/section/SectionResponse;", "isCommercialsLoaded", "Lcom/avito/android/advert/item/commercials/PositionedBannerContainer;", "getCommercials", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", "setAdvert", "(Lcom/avito/android/remote/model/AdvertDetails;)V", "Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;", "advertDetailsItemsPresenter", "bindComplementaryBlock", "(Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;)V", "", "columns", "Lcom/avito/android/advert/item/similars/ComplementarySection;", "convertComplementarySections", "(I)Lcom/avito/android/advert/item/similars/ComplementarySection;", "Lcom/avito/android/serp/adapter/PersistableSpannedItem;", "allItems", "Lcom/avito/android/serp/adapter/SpannedItem;", "convertCommercialBanners", "(Ljava/util/List;)Ljava/util/List;", "isComplementaryValid", "items", "commercials", "Lcom/avito/android/remote/model/section/SectionExpandButton;", "sectionExpandButton", "setComplementaryItems", "(Ljava/util/List;Ljava/util/List;Lcom/avito/android/remote/model/section/SectionExpandButton;)V", "", "id", "needTrackCommercialOpened", "(Ljava/lang/String;)Z", "onCommercialOpened", "(Ljava/lang/String;)V", "expandSections", "onAppend", "canAppend", "getAnalyticsParams", "Lcom/avito/android/section/SectionItemConverter;", g.a, "Lcom/avito/android/section/SectionItemConverter;", "recommendationSectionItemConverter", "Lcom/avito/android/advert/item/commercials/AdvertCommercialsConverter;", "h", "Lcom/avito/android/advert/item/commercials/AdvertCommercialsConverter;", "commercialsConverter", "Lcom/avito/android/Features;", "j", "Lcom/avito/android/Features;", "features", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/AdvertDetails;", "Lcom/avito/android/advert/item/similars/AdvertSimilarPresenterResourceProvider;", "f", "Lcom/avito/android/advert/item/similars/AdvertSimilarPresenterResourceProvider;", "resourceProvider", "", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "complementaryItems", "e", "Z", "complementaryExpanded", "d", "Lcom/avito/android/remote/model/section/SectionExpandButton;", "expandButton", "Lcom/avito/android/advert/tracker/AdvertDetailsTracker;", "i", "Lcom/avito/android/advert/tracker/AdvertDetailsTracker;", "tracker", "c", "commercialItems", "<init>", "(Lcom/avito/android/advert/item/similars/AdvertSimilarPresenterResourceProvider;Lcom/avito/android/section/SectionItemConverter;Lcom/avito/android/advert/item/commercials/AdvertCommercialsConverter;Lcom/avito/android/advert/tracker/AdvertDetailsTracker;Lcom/avito/android/Features;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertComplementaryPresenterImpl implements AdvertComplementaryPresenter {
    public AdvertDetails a;
    public final List<SectionTypeElement> b = new ArrayList();
    public final List<PositionedBannerContainer> c = new ArrayList();
    public SectionExpandButton d;
    public boolean e;
    public final AdvertSimilarPresenterResourceProvider f;
    public final SectionItemConverter g;
    public final AdvertCommercialsConverter h;
    public final AdvertDetailsTracker i;
    public final Features j;

    public static final class a extends Lambda implements Function1<SectionTypeElement, Boolean> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(SectionTypeElement sectionTypeElement) {
            SectionTypeElement sectionTypeElement2 = sectionTypeElement;
            Intrinsics.checkNotNullParameter(sectionTypeElement2, "it");
            return Boolean.valueOf(sectionTypeElement2 instanceof SectionTypeItem);
        }
    }

    public static final class b extends Lambda implements Function1<SectionTypeElement, SectionTypeItem> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SectionTypeItem invoke(SectionTypeElement sectionTypeElement) {
            SectionTypeElement sectionTypeElement2 = sectionTypeElement;
            Intrinsics.checkNotNullParameter(sectionTypeElement2, "it");
            return (SectionTypeItem) sectionTypeElement2;
        }
    }

    public static final class c extends Lambda implements Function1<SectionTypeItem, String> {
        public static final c a = new c();

        public c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public String invoke(SectionTypeItem sectionTypeItem) {
            SectionTypeItem sectionTypeItem2 = sectionTypeItem;
            Intrinsics.checkNotNullParameter(sectionTypeItem2, "it");
            return sectionTypeItem2.getContext();
        }
    }

    @Inject
    public AdvertComplementaryPresenterImpl(@NotNull AdvertSimilarPresenterResourceProvider advertSimilarPresenterResourceProvider, @NotNull SectionItemConverter sectionItemConverter, @NotNull AdvertCommercialsConverter advertCommercialsConverter, @NotNull AdvertDetailsTracker advertDetailsTracker, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(advertSimilarPresenterResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(sectionItemConverter, "recommendationSectionItemConverter");
        Intrinsics.checkNotNullParameter(advertCommercialsConverter, "commercialsConverter");
        Intrinsics.checkNotNullParameter(advertDetailsTracker, "tracker");
        Intrinsics.checkNotNullParameter(features, "features");
        this.f = advertSimilarPresenterResourceProvider;
        this.g = sectionItemConverter;
        this.h = advertCommercialsConverter;
        this.i = advertDetailsTracker;
        this.j = features;
    }

    @Override // com.avito.android.advert.item.similars.AdvertComplementaryPresenter
    public void bindComplementaryBlock(@Nullable AdvertDetailsItemsPresenter advertDetailsItemsPresenter) {
        AdvertDetails advertDetails = this.a;
        if (advertDetails != null) {
            ComplementarySection convertComplementarySections = convertComplementarySections(this.f.getSimilarColumns());
            this.i.trackComplementaryPrepare();
            if (this.j.getCommercialsOnAdvertisement().invoke().booleanValue()) {
                if (advertDetailsItemsPresenter != null) {
                    advertDetailsItemsPresenter.bindComplementarySection(advertDetails, convertComplementarySections);
                }
            } else if (advertDetailsItemsPresenter != null) {
                advertDetailsItemsPresenter.legacyBindComplementaryItems(advertDetails, convertComplementarySections.getSimilarItems());
            }
            this.i.trackComplementaryDraw();
        }
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public boolean canAppend() {
        return false;
    }

    @Override // com.avito.android.advert.item.similars.AdvertComplementaryPresenter
    public void clearItems() {
        this.b.clear();
        this.c.clear();
    }

    @Override // com.avito.android.advert.item.similars.AdvertComplementaryPresenter
    @NotNull
    public List<SpannedItem> convertCommercialBanners(@NotNull List<? extends PersistableSpannedItem> list) {
        Intrinsics.checkNotNullParameter(list, "allItems");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            if (t instanceof AdvertSerpCommercialBanner) {
                t = t.getCommercialSerpItem();
            }
            arrayList.add(t);
        }
        return arrayList;
    }

    @Override // com.avito.android.advert.item.similars.AdvertComplementaryPresenter
    @NotNull
    public ComplementarySection convertComplementarySections(int i2) {
        AdvertCommercials advertCommercials;
        AdvertDetails advertDetails = this.a;
        if (advertDetails == null) {
            return new ComplementarySection(null, null, null, 7, null);
        }
        List list = (List) SectionItemConverter.DefaultImpls.convert$default(this.g, this.b, i2, advertDetails.isShopAdvert(), !this.e ? this.d : null, false, 16, null).blockingGet();
        if (this.j.getCommercialsOnAdvertisement().invoke().booleanValue()) {
            advertCommercials = this.h.convert(this.c, SerpDisplayType.Grid);
        } else {
            advertCommercials = new AdvertCommercials(null, null, 3, null);
        }
        AdvertSerpCommercialBanner topCommercial = advertCommercials.getTopCommercial();
        Intrinsics.checkNotNullExpressionValue(list, "recommendations");
        return new ComplementarySection(topCommercial, list, advertCommercials.getBottomCommercial());
    }

    @Override // com.avito.android.advert.item.similars.AdvertComplementaryPresenter
    public void expandSections() {
        this.e = true;
    }

    @Override // com.avito.android.advert.item.similars.AdvertComplementaryPresenter
    @NotNull
    public List<String> getAnalyticsParams() {
        return SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(this.b), a.a), b.a), c.a));
    }

    @Override // com.avito.android.advert.item.similars.AdvertComplementaryPresenter
    @NotNull
    public List<PositionedBannerContainer> getCommercials() {
        return CollectionsKt___CollectionsKt.toList(this.c);
    }

    @Override // com.avito.android.advert.item.similars.AdvertComplementaryPresenter
    @NotNull
    public SectionResponse getSectionsData() {
        return new SectionResponse(getSimilars(), this.d);
    }

    @Override // com.avito.android.advert.item.similars.AdvertComplementaryPresenter
    @NotNull
    public List<SectionTypeElement> getSimilars() {
        return CollectionsKt___CollectionsKt.toList(this.b);
    }

    @Override // com.avito.android.advert.item.similars.AdvertComplementaryPresenter
    public boolean isCommercialsLoaded() {
        T t;
        if (this.c.size() > 0) {
            Iterator<T> it = this.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (!t.getBanner().isLoaded()) {
                    break;
                }
            }
            if (t == null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.avito.android.advert.item.similars.AdvertComplementaryPresenter
    public boolean isComplementaryValid() {
        return this.a != null && !this.b.isEmpty();
    }

    @Override // com.avito.android.advert.item.similars.AdvertComplementaryPresenter
    public boolean isSimilarsLoaded() {
        return this.b.size() > 0;
    }

    @Override // com.avito.android.advert.item.similars.AdvertComplementaryPresenter
    public boolean needTrackCommercialOpened(@NotNull String str) {
        String str2;
        SerpCommercialBanner banner;
        CommercialBanner commercialBanner;
        LoadedNetworkBanner loadedNetworkBanner;
        boolean z;
        LoadedNetworkBanner loadedNetworkBanner2;
        Intrinsics.checkNotNullParameter(str, "id");
        Iterator<T> it = this.c.iterator();
        while (true) {
            str2 = null;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            T t = next;
            CommercialBanner commercialBanner2 = t.getBanner().getCommercialBanner();
            if (!(commercialBanner2 == null || (loadedNetworkBanner2 = commercialBanner2.getLoadedNetworkBanner()) == null)) {
                str2 = loadedNetworkBanner2.getId();
            }
            if (!Intrinsics.areEqual(str2, str) || !t.getBanner().isLoaded()) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                str2 = next;
                break;
            }
        }
        PositionedBannerContainer positionedBannerContainer = (PositionedBannerContainer) str2;
        if (positionedBannerContainer == null || (banner = positionedBannerContainer.getBanner()) == null || (commercialBanner = banner.getCommercialBanner()) == null || (loadedNetworkBanner = commercialBanner.getLoadedNetworkBanner()) == null || loadedNetworkBanner.getWasOpened()) {
            return false;
        }
        return true;
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public void onAppend() {
    }

    @Override // com.avito.android.advert.item.similars.AdvertComplementaryPresenter
    public void onCommercialOpened(@NotNull String str) {
        String str2;
        SerpCommercialBanner banner;
        CommercialBanner commercialBanner;
        LoadedNetworkBanner loadedNetworkBanner;
        boolean z;
        LoadedNetworkBanner loadedNetworkBanner2;
        Intrinsics.checkNotNullParameter(str, "id");
        Iterator<T> it = this.c.iterator();
        while (true) {
            str2 = null;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            T t = next;
            CommercialBanner commercialBanner2 = t.getBanner().getCommercialBanner();
            if (!(commercialBanner2 == null || (loadedNetworkBanner2 = commercialBanner2.getLoadedNetworkBanner()) == null)) {
                str2 = loadedNetworkBanner2.getId();
            }
            if (!Intrinsics.areEqual(str2, str) || !t.getBanner().isLoaded()) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                str2 = next;
                break;
            }
        }
        PositionedBannerContainer positionedBannerContainer = (PositionedBannerContainer) str2;
        if (positionedBannerContainer != null && (banner = positionedBannerContainer.getBanner()) != null && (commercialBanner = banner.getCommercialBanner()) != null && (loadedNetworkBanner = commercialBanner.getLoadedNetworkBanner()) != null) {
            loadedNetworkBanner.setWasOpened(true);
        }
    }

    @Override // com.avito.android.advert.item.similars.AdvertComplementaryPresenter
    public void onRestoreState(@Nullable Kundle kundle) {
        Boolean bool;
        SectionExpandButton sectionExpandButton = null;
        List<? extends SectionTypeElement> parcelableList = kundle != null ? kundle.getParcelableList("KEY_COMPLEMENTARY_ITEMS") : null;
        List<PositionedBannerContainer> parcelableList2 = kundle != null ? kundle.getParcelableList("KEY_COMMERCIAL_ITEMS") : null;
        if (kundle != null) {
            sectionExpandButton = (SectionExpandButton) kundle.getParcelable("KEY_EXPAND_BUTTON");
        }
        this.e = (kundle == null || (bool = kundle.getBoolean("KEY_COMPLEMENTARY_EXPANDED")) == null) ? false : bool.booleanValue();
        if (parcelableList == null) {
            parcelableList = CollectionsKt__CollectionsKt.emptyList();
        }
        if (parcelableList2 == null) {
            parcelableList2 = CollectionsKt__CollectionsKt.emptyList();
        }
        setComplementaryItems(parcelableList, parcelableList2, sectionExpandButton);
    }

    @Override // com.avito.android.advert.item.similars.AdvertComplementaryPresenter
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        kundle.putParcelableList("KEY_COMPLEMENTARY_ITEMS", this.b);
        kundle.putParcelableList("KEY_COMMERCIAL_ITEMS", this.c);
        kundle.putParcelable("KEY_EXPAND_BUTTON", this.d);
        kundle.putBoolean("KEY_COMPLEMENTARY_EXPANDED", Boolean.valueOf(this.e));
        return kundle;
    }

    @Override // com.avito.android.advert.item.similars.AdvertComplementaryPresenter
    public void setAdvert(@Nullable AdvertDetails advertDetails) {
        this.a = advertDetails;
    }

    @Override // com.avito.android.advert.item.similars.AdvertComplementaryPresenter
    public void setComplementaryItems(@NotNull List<? extends SectionTypeElement> list, @NotNull List<PositionedBannerContainer> list2, @Nullable SectionExpandButton sectionExpandButton) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(list2, "commercials");
        this.c.clear();
        this.c.addAll(list2);
        if (!list.isEmpty()) {
            this.b.clear();
            this.b.addAll(list);
        }
        this.d = sectionExpandButton;
    }
}
