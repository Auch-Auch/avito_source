package com.avito.android.publish.slots;

import com.avito.android.publish.PublishViewModel;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.slot.Slot;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J)\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/avito/android/publish/slots/SlotsFactory;", "", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "params", "", "Lcom/avito/android/publish/slots/SlotWrapper;", "Lcom/avito/android/remote/model/category_parameters/slot/Slot;", "createSlotSet", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Ljava/util/Set;", "Lcom/avito/android/publish/PublishViewModel;", "getPublishViewModel", "()Lcom/avito/android/publish/PublishViewModel;", "setPublishViewModel", "(Lcom/avito/android/publish/PublishViewModel;)V", "publishViewModel", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface SlotsFactory {
    @NotNull
    Set<SlotWrapper<? extends Slot<?>>> createSlotSet(@NotNull ParametersTree parametersTree);

    @NotNull
    PublishViewModel getPublishViewModel();

    void setPublishViewModel(@NotNull PublishViewModel publishViewModel);
}
