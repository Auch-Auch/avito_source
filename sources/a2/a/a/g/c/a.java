package a2.a.a.g.c;

import android.widget.TextView;
import com.avito.android.advert_core.call_methods.AdvertCallMethodsDialogFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<TextView, Unit> {
    public final /* synthetic */ AdvertCallMethodsDialogFragment.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(AdvertCallMethodsDialogFragment.a aVar) {
        super(1);
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(TextView textView) {
        TextView textView2 = textView;
        Intrinsics.checkNotNullParameter(textView2, "$receiver");
        textView2.setText(this.a.b);
        return Unit.INSTANCE;
    }
}
