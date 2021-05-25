package com.avito.android.redux;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.redux.Action;
import com.avito.android.redux.State;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005J1\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/redux/Middleware;", "Lcom/avito/android/redux/State;", ExifInterface.LATITUDE_SOUTH, "Lcom/avito/android/redux/Action;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "Lio/reactivex/rxjava3/core/Observable;", "actions", "state", "create", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/core/Observable;", "redux"}, k = 1, mv = {1, 4, 2})
public interface Middleware<S extends State, A extends Action> {
    @NotNull
    Observable<A> create(@NotNull Observable<A> observable, @NotNull Observable<S> observable2);
}
