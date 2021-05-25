package a2.a.a.g.d.a;

import android.view.View;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionViewImpl;
import com.avito.android.lib.design.button.Button;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
public final class a implements View.OnClickListener {
    public final /* synthetic */ CarMarketPriceDescriptionViewImpl a;
    public final /* synthetic */ Button b;
    public final /* synthetic */ Function0 c;

    public a(CarMarketPriceDescriptionViewImpl carMarketPriceDescriptionViewImpl, Button button, Function0 function0) {
        this.a = carMarketPriceDescriptionViewImpl;
        this.b = button;
        this.c = function0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (!this.b.isActivated()) {
            this.b.setActivated(true);
            Button button = this.a.A;
            if (button != null) {
                button.setActivated(false);
            }
            this.a.A = this.b;
            Function0 function0 = this.c;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }
}
