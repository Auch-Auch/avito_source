package com.avito.android.redux;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.redux.Action;
import com.avito.android.redux.State;
import io.reactivex.rxjava3.disposables.Disposable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\n\b\u0001\u0010\u0004 \u0000*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/redux/SubscribableStore;", "Lcom/avito/android/redux/State;", ExifInterface.LATITUDE_SOUTH, "Lcom/avito/android/redux/Action;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/redux/Store;", "Lio/reactivex/rxjava3/disposables/Disposable;", "subscribe", "()Lio/reactivex/rxjava3/disposables/Disposable;", "redux"}, k = 1, mv = {1, 4, 2})
public interface SubscribableStore<S extends State, A extends Action> extends Store<S, A> {
    @NotNull
    Disposable subscribe();
}
