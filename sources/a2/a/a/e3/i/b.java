package a2.a.a.e3.i;

import android.content.Context;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.tariff.tariff_package_info.TariffPackageInfoFragment;
import com.avito.android.util.text.AttributedTextFormatter;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Observer<AttributedText> {
    public final /* synthetic */ TariffPackageInfoFragment a;

    public b(TariffPackageInfoFragment tariffPackageInfoFragment) {
        this.a = tariffPackageInfoFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(AttributedText attributedText) {
        Toolbar toolbar = this.a.a();
        AttributedTextFormatter attributedTextFormatter = this.a.getAttributedTextFormatter();
        Context requireContext = this.a.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        toolbar.setTitle(attributedTextFormatter.format(requireContext, attributedText));
    }
}
