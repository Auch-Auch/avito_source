package com.avito.android.serp.adapter;

import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpElement;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/serp/adapter/SerpElementItemConverter;", "", "", "Lcom/avito/android/remote/model/SerpElement;", MessengerShareContentUtility.ELEMENTS, "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "convert", "(Ljava/util/List;Lcom/avito/android/remote/model/SerpDisplayType;)Ljava/util/List;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SerpElementItemConverter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ List convert$default(SerpElementItemConverter serpElementItemConverter, List list, SerpDisplayType serpDisplayType, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    serpDisplayType = SerpDisplayType.Grid;
                }
                return serpElementItemConverter.convert(list, serpDisplayType);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: convert");
        }
    }

    @NotNull
    List<ViewTypeSerpItem> convert(@NotNull List<? extends SerpElement> list, @NotNull SerpDisplayType serpDisplayType);
}
