package ru.sravni.android.bankproduct.utils.product;

import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.dictionary.entity.ProductDictionaryInfoDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\b¨\u0006\u0010"}, d2 = {"Lru/sravni/android/bankproduct/utils/product/ProductUtil;", "Lru/sravni/android/bankproduct/utils/product/IProductUtil;", "", "Lru/sravni/android/bankproduct/utils/product/SravniProductItem;", "getListFinanceProduct", "()Ljava/util/List;", "getListInsuranceProduct", AuthSource.SEND_ABUSE, "Ljava/util/List;", "listFinanceItemsProduct", AuthSource.BOOKING_ORDER, "listInsuranceItemsProduct", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "productDictionary", "<init>", "(Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProductUtil implements IProductUtil {
    public final List<SravniProductItem> a;
    public final List<SravniProductItem> b;

    public ProductUtil(@NotNull IProductNameDictionary iProductNameDictionary) {
        Intrinsics.checkParameterIsNotNull(iProductNameDictionary, "productDictionary");
        String title = ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getCREDIT_CHAT_NAME())).getTitle();
        String chatName = ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getCREDIT_CHAT_NAME())).getChatName();
        int i = R.color.bright_sky_blue_sravni;
        int i2 = R.color.sky_blue_sravni;
        this.a = CollectionsKt__CollectionsKt.listOf((Object[]) new SravniProductItem[]{new SravniProductItem(false, null, title, chatName, i, i2, R.drawable.ic_credit_sravni_sravni, null, null, null, null, null, ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getCREDIT_CHAT_NAME())).getAnalyticProductName(), 3970, null), new SravniProductItem(true, "http://sravni.ru/ipoteka/?utm_source=android&utm_medium=mobile_app&utm_campaign=mortcred", ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getMORTRAGE_CHAT_NAME())).getTitle(), ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getMORTRAGE_CHAT_NAME())).getChatName(), i, i2, R.drawable.ic_mortage_sravni, null, null, null, null, null, ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getMORTRAGE_CHAT_NAME())).getAnalyticProductName(), 3968, null), new SravniProductItem(true, "http://sravni.ru/vklady/?utm_source=android&utm_medium=mobile_app&utm_campaign=deposit", ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getDEPOSIT_CHAT_NAME())).getTitle(), ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getDEPOSIT_CHAT_NAME())).getChatName(), i, i2, R.drawable.ic_deposit_sravni, null, null, null, null, null, ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getDEPOSIT_CHAT_NAME())).getAnalyticProductName(), 3968, null), new SravniProductItem(true, "http://sravni.ru/debetovye-karty/?utm_source=android&utm_medium=mobile_app&utm_campaign=debcard", ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getDEBIT_CARDS_CHAT_NAME())).getTitle(), ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getDEBIT_CARDS_CHAT_NAME())).getChatName(), i, i2, R.drawable.ic_card_sravni, null, null, null, null, null, ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getDEBIT_CARDS_CHAT_NAME())).getAnalyticProductName(), 3968, null)});
        String title2 = ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getOSAGO_CHAT_NAME())).getTitle();
        String chatName2 = ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getOSAGO_CHAT_NAME())).getChatName();
        int i3 = R.color.shamrock_green_sravni;
        int i4 = R.color.light_green_sravni;
        this.b = CollectionsKt__CollectionsKt.listOf((Object[]) new SravniProductItem[]{new SravniProductItem(false, null, title2, chatName2, i3, i4, R.drawable.ic_osago_sravni, null, null, null, null, null, ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getOSAGO_CHAT_NAME())).getAnalyticProductName(), 3970, null), new SravniProductItem(true, "http://sravni.ru/kasko/?utm_source=android&utm_medium=mobile_app&utm_campaign=casco", ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getKASKO_CHAT_NAME())).getTitle(), ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getKASKO_CHAT_NAME())).getChatName(), i3, i4, R.drawable.ic_kasko_sravni, null, null, null, null, null, ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getKASKO_CHAT_NAME())).getAnalyticProductName(), 3968, null), new SravniProductItem(true, "http://sravni.ru/vzr/?utm_source=android&utm_medium=mobile_app&utm_campaign=vzr", ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getTRAVEL_INSURANCE_CHAT_NAME())).getTitle(), ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getTRAVEL_INSURANCE_CHAT_NAME())).getChatName(), i3, i4, R.drawable.ic_travel_sravni, null, null, null, null, null, ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getTRAVEL_INSURANCE_CHAT_NAME())).getAnalyticProductName(), 3968, null), new SravniProductItem(true, "http://sravni.ru/strahovanie-nedvizhimosti/?utm_source=android&utm_medium=mobile_app&utm_campaign=ifl ", ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getPROPERTY_INSURANSE_CHAT_NAME())).getTitle(), ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getPROPERTY_INSURANSE_CHAT_NAME())).getChatName(), i3, i4, R.drawable.ic_house_sravni, null, null, null, null, null, ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getPROPERTY_INSURANSE_CHAT_NAME())).getAnalyticProductName(), 3968, null), new SravniProductItem(true, "http://sravni.ru/strahovanie-ipoteki/?utm_source=android&utm_medium=mobile_app&utm_campaign=insmortcred", ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getMORTRAGE_INSURANSE_CHAT_NAME())).getTitle(), ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getMORTRAGE_INSURANSE_CHAT_NAME())).getChatName(), i3, i4, R.drawable.ic_house_mortage_sravni, null, null, null, null, null, ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getMORTRAGE_INSURANSE_CHAT_NAME())).getAnalyticProductName(), 3968, null)});
    }

    @Override // ru.sravni.android.bankproduct.utils.product.IProductUtil
    @NotNull
    public List<SravniProductItem> getListFinanceProduct() {
        return this.a;
    }

    @Override // ru.sravni.android.bankproduct.utils.product.IProductUtil
    @NotNull
    public List<SravniProductItem> getListInsuranceProduct() {
        return this.b;
    }
}
