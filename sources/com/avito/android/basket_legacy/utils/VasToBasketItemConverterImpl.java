package com.avito.android.basket_legacy.utils;

import a2.b.a.a.a;
import com.avito.android.basket_legacy.item.BasketItem;
import com.avito.android.basket_legacy.item.header.HeaderItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/basket_legacy/utils/VasToBasketItemConverterImpl;", "Lcom/avito/android/basket_legacy/utils/VasToBasketItemConverter;", "", "Lcom/avito/android/basket_legacy/utils/VasService;", "vasList", "Lcom/avito/conveyor_item/Item;", "convert", "(Ljava/util/List;)Ljava/util/List;", "Lcom/avito/android/basket_legacy/utils/StringProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/basket_legacy/utils/StringProvider;", "stringProvider", "<init>", "(Lcom/avito/android/basket_legacy/utils/StringProvider;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class VasToBasketItemConverterImpl implements VasToBasketItemConverter {
    public final StringProvider a;

    @Inject
    public VasToBasketItemConverterImpl(@NotNull StringProvider stringProvider) {
        Intrinsics.checkNotNullParameter(stringProvider, "stringProvider");
        this.a = stringProvider;
    }

    @Override // com.avito.android.basket_legacy.utils.VasToBasketItemConverter
    @NotNull
    public List<Item> convert(@NotNull List<VasService> list) {
        Intrinsics.checkNotNullParameter(list, "vasList");
        HeaderItem headerItem = new HeaderItem("vas title", this.a.getVasTitle(), null, list.size(), 4, null);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (next.getPriceValue() <= 0) {
                z = false;
            }
            if (z) {
                arrayList2.add(next);
            }
        }
        Iterator it2 = arrayList2.iterator();
        int i = 0;
        while (it2.hasNext()) {
            Object next2 = it2.next();
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            VasService vasService = (VasService) next2;
            String H = a.H(new Object[]{Integer.valueOf(i)}, 1, "vas %s", "java.lang.String.format(this, *args)");
            String title = vasService.getTitle();
            AttributedText attributedText = new AttributedText("", CollectionsKt__CollectionsKt.emptyList());
            AttributedText price = vasService.getPrice();
            if (price == null) {
                price = new AttributedText("", CollectionsKt__CollectionsKt.emptyList());
            }
            arrayList.add(new BasketItem(H, title, attributedText, price, vasService.getOldPrice(), vasService.getIcon(), true, "vas title", vasService.getSlug(), vasService.getPriceValue()));
            i = i2;
        }
        if (!arrayList.isEmpty()) {
            arrayList.add(0, headerItem);
        }
        return arrayList;
    }
}
