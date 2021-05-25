package com.avito.android.advert.item.similars;

import com.avito.android.advert.item.AdvertDetailsItemsPresenter;
import com.avito.android.advert.item.commercials.PositionedBannerContainer;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.remote.model.section.SectionExpandButton;
import com.avito.android.remote.model.section.SectionResponse;
import com.avito.android.remote.model.section.SectionTypeElement;
import com.avito.android.serp.adapter.PersistableSpannedItem;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.ui.adapter.AppendingListener;
import com.avito.android.util.Kundle;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J7\u0010\u000e\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00072\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0007H&¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H&¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u001eH&¢\u0006\u0004\b&\u0010 J\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H&¢\u0006\u0004\b'\u0010\"J\u000f\u0010(\u001a\u00020\u001eH&¢\u0006\u0004\b(\u0010 J\u000f\u0010*\u001a\u00020)H&¢\u0006\u0004\b*\u0010+J\u0019\u0010-\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010)H&¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010/0\u0007H&¢\u0006\u0004\b0\u0010\"J\u000f\u00101\u001a\u00020\u0004H&¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0004H&¢\u0006\u0004\b3\u00102J\u0017\u00105\u001a\u00020\u001e2\u0006\u00104\u001a\u00020/H&¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u00042\u0006\u00104\u001a\u00020/H&¢\u0006\u0004\b7\u00108¨\u00069"}, d2 = {"Lcom/avito/android/advert/item/similars/AdvertComplementaryPresenter;", "Lcom/avito/android/ui/adapter/AppendingListener;", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", "", "setAdvert", "(Lcom/avito/android/remote/model/AdvertDetails;)V", "", "Lcom/avito/android/remote/model/section/SectionTypeElement;", "items", "Lcom/avito/android/advert/item/commercials/PositionedBannerContainer;", "commercials", "Lcom/avito/android/remote/model/section/SectionExpandButton;", "sectionExpandButton", "setComplementaryItems", "(Ljava/util/List;Ljava/util/List;Lcom/avito/android/remote/model/section/SectionExpandButton;)V", "Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;", "advertDetailsItemsPresenter", "bindComplementaryBlock", "(Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;)V", "", "columns", "Lcom/avito/android/advert/item/similars/ComplementarySection;", "convertComplementarySections", "(I)Lcom/avito/android/advert/item/similars/ComplementarySection;", "Lcom/avito/android/serp/adapter/PersistableSpannedItem;", "allItems", "Lcom/avito/android/serp/adapter/SpannedItem;", "convertCommercialBanners", "(Ljava/util/List;)Ljava/util/List;", "", "isSimilarsLoaded", "()Z", "getSimilars", "()Ljava/util/List;", "Lcom/avito/android/remote/model/section/SectionResponse;", "getSectionsData", "()Lcom/avito/android/remote/model/section/SectionResponse;", "isCommercialsLoaded", "getCommercials", "isComplementaryValid", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "restoreState", "onRestoreState", "(Lcom/avito/android/util/Kundle;)V", "", "getAnalyticsParams", "clearItems", "()V", "expandSections", "id", "needTrackCommercialOpened", "(Ljava/lang/String;)Z", "onCommercialOpened", "(Ljava/lang/String;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertComplementaryPresenter extends AppendingListener {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void setComplementaryItems$default(AdvertComplementaryPresenter advertComplementaryPresenter, List list, List list2, SectionExpandButton sectionExpandButton, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    sectionExpandButton = null;
                }
                advertComplementaryPresenter.setComplementaryItems(list, list2, sectionExpandButton);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setComplementaryItems");
        }
    }

    void bindComplementaryBlock(@Nullable AdvertDetailsItemsPresenter advertDetailsItemsPresenter);

    void clearItems();

    @NotNull
    List<SpannedItem> convertCommercialBanners(@NotNull List<? extends PersistableSpannedItem> list);

    @NotNull
    ComplementarySection convertComplementarySections(int i);

    void expandSections();

    @NotNull
    List<String> getAnalyticsParams();

    @NotNull
    List<PositionedBannerContainer> getCommercials();

    @NotNull
    SectionResponse getSectionsData();

    @NotNull
    List<SectionTypeElement> getSimilars();

    boolean isCommercialsLoaded();

    boolean isComplementaryValid();

    boolean isSimilarsLoaded();

    boolean needTrackCommercialOpened(@NotNull String str);

    void onCommercialOpened(@NotNull String str);

    void onRestoreState(@Nullable Kundle kundle);

    @NotNull
    Kundle onSaveState();

    void setAdvert(@Nullable AdvertDetails advertDetails);

    void setComplementaryItems(@NotNull List<? extends SectionTypeElement> list, @NotNull List<PositionedBannerContainer> list2, @Nullable SectionExpandButton sectionExpandButton);
}
