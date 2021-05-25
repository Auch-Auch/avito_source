package a2.a.a.h3.a;

import com.avito.android.analytics.R;
import com.avito.android.lib.design.tooltip.TooltipContent;
import com.avito.android.user_advert.advert.MyAdvertDetailsViewImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
public final class d1 extends Lambda implements Function1<TooltipContent, Unit> {
    public final /* synthetic */ MyAdvertDetailsViewImpl a;
    public final /* synthetic */ Ref.ObjectRef b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d1(MyAdvertDetailsViewImpl myAdvertDetailsViewImpl, Ref.ObjectRef objectRef) {
        super(1);
        this.a = myAdvertDetailsViewImpl;
        this.b = objectRef;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(TooltipContent tooltipContent) {
        TooltipContent tooltipContent2 = tooltipContent;
        Intrinsics.checkNotNullParameter(tooltipContent2, "$receiver");
        tooltipContent2.setTitle(R.string.new_statistics_title);
        tooltipContent2.setBody(R.string.new_statistics_body);
        tooltipContent2.setButtonText(R.string.new_statistics_tooltip_btn_text);
        tooltipContent2.setButtonClickListener(new c1(this));
        return Unit.INSTANCE;
    }
}
