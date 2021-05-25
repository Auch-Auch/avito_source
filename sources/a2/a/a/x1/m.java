package a2.a.a.x1;

import com.avito.android.photo_picker.PhotoPickerViewModel;
import com.avito.android.util.Logs;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class m extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ PhotoPickerViewModel a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(PhotoPickerViewModel photoPickerViewModel) {
        super(1);
        this.a = photoPickerViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "error");
        Logs.error("Can't save photos to db", th2);
        this.a.f.setValue(PhotoPickerViewModel.RoutingAction.ToExit.INSTANCE);
        return Unit.INSTANCE;
    }
}
