package com.avito.android.serp.adapter.rich_snippets.job;

import androidx.annotation.VisibleForTesting;
import com.avito.android.remote.model.Color;
import com.avito.android.remote.model.GeoReference;
import com.avito.android.util.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a!\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"\u001c\u0010\u0006\u001a\u00020\u00058\u0006@\u0007XT¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "Lcom/avito/android/remote/model/GeoReference;", "Lcom/avito/android/remote/model/Color;", "getMetroLines", "(Ljava/util/List;)Ljava/util/List;", "", "KEY_ADVERT_XL_GALLERY_STATE", "Ljava/lang/String;", "getKEY_ADVERT_XL_GALLERY_STATE$annotations", "()V", "serp-core_release"}, k = 2, mv = {1, 4, 2})
public final class AdvertXlRichJobItemPresenterKt {
    @NotNull
    public static final String KEY_ADVERT_XL_GALLERY_STATE = "advert_xl_gallery_state";

    @VisibleForTesting
    public static /* synthetic */ void getKEY_ADVERT_XL_GALLERY_STATE$annotations() {
    }

    @Nullable
    public static final List<Color> getMetroLines(@NotNull List<GeoReference> list) {
        List<String> colors;
        Intrinsics.checkNotNullParameter(list, "$this$getMetroLines");
        GeoReference geoReference = (GeoReference) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
        if (geoReference == null || (colors = geoReference.getColors()) == null) {
            return null;
        }
        ArrayList<Number> arrayList = new ArrayList();
        Iterator<T> it = colors.iterator();
        while (it.hasNext()) {
            Integer parseColorOrNull = StringUtils.parseColorOrNull(it.next());
            if (parseColorOrNull != null) {
                arrayList.add(parseColorOrNull);
            }
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        for (Number number : arrayList) {
            arrayList2.add(new Color(number.intValue()));
        }
        return arrayList2;
    }
}
