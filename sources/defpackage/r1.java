package defpackage;

import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.entities.LocationPickerState;
import io.reactivex.rxjava3.functions.Predicate;
import kotlin.Unit;
/* compiled from: java-style lambda group */
/* renamed from: r1  reason: default package */
public final class r1<T> implements Predicate<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public r1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Predicate
    public final boolean test(Unit unit) {
        int i = this.a;
        if (i == 0) {
            return !((LocationPickerState) this.b).getAddressStringFitsCoords();
        }
        if (i != 1) {
            if (i == 2) {
                return ((LocationPickerState) this.b).getAddressStringFitsCoords();
            }
            if (i == 3) {
                return !((LocationPickerBinderImpl.a) this.b).a.k.isPermissionGranted();
            }
            throw null;
        } else if (((LocationPickerState) this.b).getAddressValidationState().getValidationRules() != null) {
            return true;
        } else {
            return false;
        }
    }
}
