package a2.a.a.s2.b;

import com.avito.android.remote.model.SerpAdvert;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.SerpElementResult;
import com.avito.android.shop.detailed.ShopDetailedInteractorImpl;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t6.n.e;
public final class d<T, R> implements Function<SerpElementResult, SerpElementResult> {
    public final /* synthetic */ ShopDetailedInteractorImpl a;

    public d(ShopDetailedInteractorImpl shopDetailedInteractorImpl) {
        this.a = shopDetailedInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SerpElementResult apply(SerpElementResult serpElementResult) {
        SerpElementResult serpElementResult2 = serpElementResult;
        List<SerpElement> elements = serpElementResult2.getElements();
        ArrayList arrayList = new ArrayList();
        for (T t : elements) {
            if (t instanceof SerpAdvert) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(ShopDetailedInteractorImpl.access$mapSubclassToSerpAdvert(this.a, (SerpAdvert) it.next()));
        }
        return serpElementResult2.cloneWithNewElements(arrayList2);
    }
}
