package com.avito.android.publish.objects;

import android.os.Bundle;
import com.avito.android.item_legacy.details.ParametersSource;
import com.avito.android.remote.model.PretendResult;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/publish/objects/ObjectsEditInteractor;", "Lcom/avito/android/item_legacy/details/ParametersSource;", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/PretendResult;", "validateParameters", "()Lio/reactivex/Observable;", "", "deleteParameters", "()V", "Landroid/os/Bundle;", "saveState", "()Landroid/os/Bundle;", "", "getHasOtherObjects", "()Z", "hasOtherObjects", "isAdding", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface ObjectsEditInteractor extends ParametersSource {
    void deleteParameters();

    boolean getHasOtherObjects();

    boolean isAdding();

    @NotNull
    Bundle saveState();

    @NotNull
    Observable<PretendResult> validateParameters();
}
