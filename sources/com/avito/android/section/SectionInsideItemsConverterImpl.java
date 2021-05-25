package com.avito.android.section;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpAdvert;
import com.avito.android.remote.model.section.SectionElement;
import com.avito.android.remote.model.section.VipAdvert;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.android.serp.adapter.SerpAdvertConverter;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/section/SectionInsideItemsConverterImpl;", "Lcom/avito/android/section/SectionInsideItemsConverter;", "", "Lcom/avito/android/remote/model/section/SectionElement;", MessengerShareContentUtility.ELEMENTS, "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "convert", "(Ljava/util/List;)Ljava/util/List;", "Lcom/avito/android/serp/adapter/SerpAdvertConverter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/SerpAdvertConverter;", "serpAdvertConverter", "<init>", "(Lcom/avito/android/serp/adapter/SerpAdvertConverter;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SectionInsideItemsConverterImpl implements SectionInsideItemsConverter {
    public final SerpAdvertConverter a;

    @Inject
    public SectionInsideItemsConverterImpl(@NotNull SerpAdvertConverter serpAdvertConverter) {
        Intrinsics.checkNotNullParameter(serpAdvertConverter, "serpAdvertConverter");
        this.a = serpAdvertConverter;
    }

    @Override // com.avito.android.section.SectionInsideItemsConverter
    @NotNull
    public List<PersistableSerpItem> convert(@NotNull List<? extends SectionElement> list) {
        ArrayList i0 = a.i0(list, MessengerShareContentUtility.ELEMENTS);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            if (t2 instanceof SerpAdvert) {
                i0.add(SerpAdvertConverter.DefaultImpls.convert$default(this.a, t2, false, null, 6, null));
            } else if (t2 instanceof VipAdvert) {
                i0.add(SerpAdvertConverter.DefaultImpls.convert$default(this.a, t2.getItem(), true, null, 4, null));
            }
            arrayList.add(Unit.INSTANCE);
            i = i2;
        }
        return i0;
    }
}
