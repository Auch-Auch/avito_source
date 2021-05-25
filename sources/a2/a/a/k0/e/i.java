package a2.a.a.k0.e;

import com.avito.android.lib.design.tooltip.TooltipContent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class i extends Lambda implements Function1<TooltipContent, Unit> {
    public final /* synthetic */ String a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(String str) {
        super(1);
        this.a = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(TooltipContent tooltipContent) {
        TooltipContent tooltipContent2 = tooltipContent;
        Intrinsics.checkNotNullParameter(tooltipContent2, "$receiver");
        tooltipContent2.setBody(this.a);
        return Unit.INSTANCE;
    }
}
