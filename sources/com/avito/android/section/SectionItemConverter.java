package com.avito.android.section;

import com.avito.android.remote.model.section.SectionExpandButton;
import com.avito.android.remote.model.section.SectionTypeElement;
import com.avito.android.remote.model.section.SectionTypeItem;
import com.avito.android.serp.adapter.PersistableSpannedItem;
import com.facebook.share.internal.MessengerShareContentUtility;
import io.reactivex.rxjava3.core.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JQ\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00020\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000e\u0010\u000fJ?\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/section/SectionItemConverter;", "", "", "Lcom/avito/android/remote/model/section/SectionTypeElement;", MessengerShareContentUtility.ELEMENTS, "", "columns", "", "isShop", "Lcom/avito/android/remote/model/section/SectionExpandButton;", "expandButton", "skipFilter", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/serp/adapter/PersistableSpannedItem;", "convert", "(Ljava/util/List;IZLcom/avito/android/remote/model/section/SectionExpandButton;Z)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/section/SectionTypeItem;", "element", "convertSectionTypeItem", "(Lcom/avito/android/remote/model/section/SectionTypeItem;IZZ)Lio/reactivex/rxjava3/core/Single;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SectionItemConverter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Single convert$default(SectionItemConverter sectionItemConverter, List list, int i, boolean z, SectionExpandButton sectionExpandButton, boolean z2, int i2, Object obj) {
            if (obj == null) {
                boolean z3 = (i2 & 4) != 0 ? false : z;
                if ((i2 & 8) != 0) {
                    sectionExpandButton = null;
                }
                return sectionItemConverter.convert(list, i, z3, sectionExpandButton, (i2 & 16) != 0 ? false : z2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: convert");
        }

        public static /* synthetic */ Single convertSectionTypeItem$default(SectionItemConverter sectionItemConverter, SectionTypeItem sectionTypeItem, int i, boolean z, boolean z2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    z = false;
                }
                if ((i2 & 8) != 0) {
                    z2 = false;
                }
                return sectionItemConverter.convertSectionTypeItem(sectionTypeItem, i, z, z2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: convertSectionTypeItem");
        }
    }

    @NotNull
    Single<List<PersistableSpannedItem>> convert(@NotNull List<? extends SectionTypeElement> list, int i, boolean z, @Nullable SectionExpandButton sectionExpandButton, boolean z2);

    @NotNull
    Single<List<PersistableSpannedItem>> convertSectionTypeItem(@NotNull SectionTypeItem sectionTypeItem, int i, boolean z, boolean z2);
}
