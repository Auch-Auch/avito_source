package a2.a.a.x1;

import com.avito.android.photo_picker.PhotoPickerViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class l extends Lambda implements Function0<Unit> {
    public final /* synthetic */ PhotoPickerViewModel a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(PhotoPickerViewModel photoPickerViewModel) {
        super(0);
        this.a = photoPickerViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.f.setValue(PhotoPickerViewModel.RoutingAction.ToExitWithSuccess.INSTANCE);
        return Unit.INSTANCE;
    }
}
