package a2.a.a.k0.d;

import com.avito.android.delivery.suggest.DeliveryLocationSuggestViewModel;
public final class f implements Runnable {
    public final /* synthetic */ DeliveryLocationSuggestViewModel a;
    public final /* synthetic */ String b;

    public f(DeliveryLocationSuggestViewModel deliveryLocationSuggestViewModel, String str) {
        this.a = deliveryLocationSuggestViewModel;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.searchSuggestions(this.b);
    }
}
