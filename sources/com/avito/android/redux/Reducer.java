package com.avito.android.redux;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.redux.Action;
import com.avito.android.redux.State;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\n\b\u0001\u0010\u0004 \u0000*\u00020\u00032\u00020\u0005J\u001f\u0010\b\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/redux/Reducer;", "Lcom/avito/android/redux/State;", ExifInterface.LATITUDE_SOUTH, "Lcom/avito/android/redux/Action;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "state", "action", "reduce", "(Lcom/avito/android/redux/State;Lcom/avito/android/redux/Action;)Lcom/avito/android/redux/State;", "redux"}, k = 1, mv = {1, 4, 2})
public interface Reducer<S extends State, A extends Action> {
    @NotNull
    S reduce(@NotNull S s, @NotNull A a);
}
