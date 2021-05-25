package ru.sravni.android.bankproduct.repository.dictionary;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.dictionary.entity.ProductDictionaryInfoDomain;
import t6.n.e;
import t6.n.s;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lru/sravni/android/bankproduct/repository/dictionary/ProductNameDictionary;", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "", "key", "Lru/sravni/android/bankproduct/domain/dictionary/entity/ProductDictionaryInfoDomain;", "get", "(Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/dictionary/entity/ProductDictionaryInfoDomain;", "", "getItems", "()Ljava/util/List;", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProductNameDictionary implements IProductNameDictionary {
    @Override // ru.sravni.android.bankproduct.domain.dictionary.ISravniDictionary
    @NotNull
    public List<ProductDictionaryInfoDomain> getItems() {
        List<Pair> list = s.toList(ProductNameDictionaryKt.access$getDictionary$p());
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (Pair pair : list) {
            arrayList.add((ProductDictionaryInfoDomain) pair.getSecond());
        }
        return arrayList;
    }

    @NotNull
    public ProductDictionaryInfoDomain get(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        ProductDictionaryInfoDomain productDictionaryInfoDomain = (ProductDictionaryInfoDomain) ProductNameDictionaryKt.access$getDictionary$p().get(str);
        return productDictionaryInfoDomain != null ? productDictionaryInfoDomain : ProductNameDictionaryKt.access$getUnknownProduct$p();
    }
}
