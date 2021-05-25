package a2.a.a.f.x.t.i;

import com.avito.android.advert.item.dfpcreditinfo.calculator.SravniCalculatorView;
import com.avito.android.deep_linking.links.OnUrlClickListener;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a implements OnUrlClickListener {
    public final /* synthetic */ SravniCalculatorView a;

    public a(SravniCalculatorView sravniCalculatorView, String str, String str2) {
        this.a = sravniCalculatorView;
    }

    @Override // com.avito.android.deep_linking.links.OnUrlClickListener
    public final boolean onUrlClick(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        this.a.getListener().onCreditPrivacyLinkClick();
        return true;
    }
}
