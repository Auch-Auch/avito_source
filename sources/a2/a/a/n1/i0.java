package a2.a.a.n1;

import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.location_picker.entities.SendLocationResponse;
import com.avito.android.location_picker.job.SendLocationToJobAssistant;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
public final class i0<T, R> implements Function<Unit, ObservableSource<? extends SendLocationResponse>> {
    public final /* synthetic */ LocationPickerBinderImpl.a a;
    public final /* synthetic */ LocationPickerState b;

    public i0(LocationPickerBinderImpl.a aVar, LocationPickerState locationPickerState) {
        this.a = aVar;
        this.b = locationPickerState;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends SendLocationResponse> apply(Unit unit) {
        SendLocationToJobAssistant sendLocationToJobAssistant = this.a.a.v;
        if (sendLocationToJobAssistant instanceof SendLocationToJobAssistant.ShouldSend) {
            return this.a.a.u.sendLocation(((SendLocationToJobAssistant.ShouldSend) this.a.a.v).getChannelId(), this.b.getLatLng().getLatitude(), this.b.getLatLng().getLongitude(), this.b.getAddressString()).subscribeOn(this.a.a.j.io()).toObservable();
        }
        if (sendLocationToJobAssistant instanceof SendLocationToJobAssistant.Default) {
            Logs.error(new IllegalStateException("currentState.sendLocationToJobAssistant must not be true in case of sendLocationToJobAssistant is Default"));
            return Observable.just(new SendLocationResponse.Error(null, 1, null));
        }
        throw new NoWhenBranchMatchedException();
    }
}
