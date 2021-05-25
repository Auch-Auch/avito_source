package defpackage;

import a2.a.a.e3.e.f.b;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.FeeMethodAction;
import com.avito.android.remote.model.FeeMethodBottomSheet;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: l5  reason: default package */
public final class l5 extends Lambda implements Function1<Unit, Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l5(int i, Object obj, Object obj2) {
        super(1);
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Unit unit) {
        int i = this.a;
        DeepLink deepLink = null;
        if (i == 0) {
            Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 0>");
            SingleLiveEvent singleLiveEvent = ((b) this.c).a.i;
            Unit unit2 = Unit.INSTANCE;
            singleLiveEvent.postValue(unit2);
            SingleLiveEvent singleLiveEvent2 = ((b) this.c).a.f;
            FeeMethodAction primaryAction = ((FeeMethodBottomSheet) this.b).getPrimaryAction();
            if (primaryAction != null) {
                deepLink = primaryAction.getDeeplink();
            }
            singleLiveEvent2.postValue(deepLink);
            return unit2;
        } else if (i == 1) {
            Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 0>");
            SingleLiveEvent singleLiveEvent3 = ((b) this.c).a.i;
            Unit unit3 = Unit.INSTANCE;
            singleLiveEvent3.postValue(unit3);
            SingleLiveEvent singleLiveEvent4 = ((b) this.c).a.f;
            FeeMethodAction secondaryAction = ((FeeMethodBottomSheet) this.b).getSecondaryAction();
            if (secondaryAction != null) {
                deepLink = secondaryAction.getDeeplink();
            }
            singleLiveEvent4.postValue(deepLink);
            return unit3;
        } else {
            throw null;
        }
    }
}
