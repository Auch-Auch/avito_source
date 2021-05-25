package a2.a.a.n2.w.b;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.lib.design.tooltip.Tooltip;
import com.avito.android.lib.design.tooltip.TooltipContent;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandlerImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function1<TooltipContent, Unit> {
    public final /* synthetic */ SerpOnboardingHandlerImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ SerpOnboardingHandlerImpl.OnboardingTarget c;
    public final /* synthetic */ Tooltip d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(SerpOnboardingHandlerImpl serpOnboardingHandlerImpl, String str, SerpOnboardingHandlerImpl.OnboardingTarget onboardingTarget, Tooltip tooltip) {
        super(1);
        this.a = serpOnboardingHandlerImpl;
        this.b = str;
        this.c = onboardingTarget;
        this.d = tooltip;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(TooltipContent tooltipContent) {
        TooltipContent tooltipContent2 = tooltipContent;
        Intrinsics.checkNotNullParameter(tooltipContent2, "$receiver");
        tooltipContent2.setBody(this.b);
        DeepLink deepLink = this.c.getDeepLink();
        if (deepLink != null) {
            tooltipContent2.setButtonText(this.a.j.getOnboardingButtonText());
            tooltipContent2.setButtonClickListener(new c(deepLink, this, tooltipContent2));
        }
        return Unit.INSTANCE;
    }
}
