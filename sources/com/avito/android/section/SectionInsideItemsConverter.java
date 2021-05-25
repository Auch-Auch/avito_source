package com.avito.android.section;

import com.avito.android.remote.model.section.SectionElement;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/section/SectionInsideItemsConverter;", "", "", "Lcom/avito/android/remote/model/section/SectionElement;", MessengerShareContentUtility.ELEMENTS, "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "convert", "(Ljava/util/List;)Ljava/util/List;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SectionInsideItemsConverter {
    @NotNull
    List<PersistableSerpItem> convert(@NotNull List<? extends SectionElement> list);
}
