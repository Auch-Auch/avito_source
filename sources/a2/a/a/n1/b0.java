package a2.a.a.n1;

import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.entities.ActivityResult;
import io.reactivex.rxjava3.functions.Predicate;
public final class b0<T> implements Predicate<ActivityResult> {
    public final /* synthetic */ LocationPickerBinderImpl.a a;

    public b0(LocationPickerBinderImpl.a aVar) {
        this.a = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Predicate
    public boolean test(ActivityResult activityResult) {
        ActivityResult activityResult2 = activityResult;
        return activityResult2.getRequestCode() == this.a.a.i.getEnableLocationRequestCode() && activityResult2.isSuccess();
    }
}
