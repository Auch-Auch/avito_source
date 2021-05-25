package com.avito.android.redux;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.redux.Action;
import com.avito.android.redux.State;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\n\b\u0001\u0010\u0004 \u0000*\u00020\u00032\u00020\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0001H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00028\u0000H&¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/redux/Store;", "Lcom/avito/android/redux/State;", ExifInterface.LATITUDE_SOUTH, "Lcom/avito/android/redux/Action;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "action", "", "dispatch", "(Lcom/avito/android/redux/Action;)V", "getState", "()Lcom/avito/android/redux/State;", "Lio/reactivex/rxjava3/core/Observable;", "stateChanges", "()Lio/reactivex/rxjava3/core/Observable;", "redux"}, k = 1, mv = {1, 4, 2})
public interface Store<S extends State, A extends Action> {
    void dispatch(@NotNull A a);

    @NotNull
    S getState();

    @NotNull
    Observable<S> stateChanges();
}
