package defpackage;

import com.avito.android.blueprints.publish.VehicleRegNumberInputItemPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: p4  reason: default package */
public final class p4 extends Lambda implements Function1<String, Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p4(int i, Object obj, Object obj2) {
        super(1);
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(String str) {
        int i = this.a;
        if (i == 0) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            VehicleRegNumberInputItemPresenterImpl vehicleRegNumberInputItemPresenterImpl = (VehicleRegNumberInputItemPresenterImpl) this.b;
            VehicleRegNumberInputItemPresenterImpl.access$setLastEnteredNumber$p(vehicleRegNumberInputItemPresenterImpl, VehicleRegNumberInputItemPresenterImpl.access$withoutSpaces(vehicleRegNumberInputItemPresenterImpl, str2));
            if (VehicleRegNumberInputItemPresenterImpl.access$getFullMatchedMask$p((VehicleRegNumberInputItemPresenterImpl) this.b) != null) {
                ((Function1) this.c).invoke(VehicleRegNumberInputItemPresenterImpl.access$getLastEnteredNumber$p((VehicleRegNumberInputItemPresenterImpl) this.b) + VehicleRegNumberInputItemPresenterImpl.access$getLastEnteredRegion$p((VehicleRegNumberInputItemPresenterImpl) this.b));
            } else {
                ((Function1) this.c).invoke(VehicleRegNumberInputItemPresenterImpl.access$getLastEnteredNumber$p((VehicleRegNumberInputItemPresenterImpl) this.b));
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            String str3 = str;
            Intrinsics.checkNotNullParameter(str3, "it");
            VehicleRegNumberInputItemPresenterImpl vehicleRegNumberInputItemPresenterImpl2 = (VehicleRegNumberInputItemPresenterImpl) this.b;
            VehicleRegNumberInputItemPresenterImpl.access$setLastEnteredRegion$p(vehicleRegNumberInputItemPresenterImpl2, VehicleRegNumberInputItemPresenterImpl.access$withoutSpaces(vehicleRegNumberInputItemPresenterImpl2, str3));
            if (VehicleRegNumberInputItemPresenterImpl.access$getFullMatchedMask$p((VehicleRegNumberInputItemPresenterImpl) this.b) != null) {
                ((Function1) this.c).invoke(VehicleRegNumberInputItemPresenterImpl.access$getLastEnteredNumber$p((VehicleRegNumberInputItemPresenterImpl) this.b) + VehicleRegNumberInputItemPresenterImpl.access$getLastEnteredRegion$p((VehicleRegNumberInputItemPresenterImpl) this.b));
            }
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}
