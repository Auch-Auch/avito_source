package ru.sravni.android.bankproduct.utils.product;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005¨\u0006\u0007"}, d2 = {"Lru/sravni/android/bankproduct/utils/product/IProductUtil;", "", "", "Lru/sravni/android/bankproduct/utils/product/SravniProductItem;", "getListFinanceProduct", "()Ljava/util/List;", "getListInsuranceProduct", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IProductUtil {
    @NotNull
    List<SravniProductItem> getListFinanceProduct();

    @NotNull
    List<SravniProductItem> getListInsuranceProduct();
}
