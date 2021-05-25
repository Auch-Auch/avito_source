package a2.a.a.g.h;

import com.avito.android.advert_core.marketplace.MarketplacePresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
public final class a<T> implements Consumer<Integer> {
    public final /* synthetic */ MarketplacePresenterImpl a;

    public a(MarketplacePresenterImpl marketplacePresenterImpl) {
        this.a = marketplacePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Integer num) {
        Integer num2 = num;
        this.a.j.getQuantityConsumer().accept(Integer.valueOf((num2 != null ? num2.intValue() : 0) + 1));
    }
}
