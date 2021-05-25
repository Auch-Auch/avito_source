package com.avito.android.messenger.map.sharing;

import androidx.lifecycle.MutableLiveData;
import com.avito.android.messenger.channels.mvi.common.v2.Action;
import com.avito.android.messenger.map.sharing.SharingMapView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/map/sharing/EditAddressClickedAction;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Action;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/map/sharing/SharingMapView$State;)V", "Landroidx/lifecycle/MutableLiveData;", "", "c", "Landroidx/lifecycle/MutableLiveData;", "editAddressStream", "<init>", "(Landroidx/lifecycle/MutableLiveData;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class EditAddressClickedAction extends Action<SharingMapView.State> {
    public final MutableLiveData<String> c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditAddressClickedAction(@NotNull MutableLiveData<String> mutableLiveData) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(mutableLiveData, "editAddressStream");
        this.c = mutableLiveData;
    }

    public void invoke(@NotNull SharingMapView.State state) {
        Intrinsics.checkNotNullParameter(state, "curState");
        this.c.postValue(state.getBottomSheetTitle());
    }
}
