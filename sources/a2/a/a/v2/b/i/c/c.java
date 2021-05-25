package a2.a.a.v2.b.i.c;

import android.os.Parcelable;
import android.view.View;
import com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationDialog;
import com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationDialogItem;
import com.avito.android.util.Keyboards;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
public final class c<T> implements Consumer<HotelsLocationDialogItem> {
    public final /* synthetic */ HotelsLocationDialog a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ View c;
    public final /* synthetic */ Function1 d;
    public final /* synthetic */ Function0 e;
    public final /* synthetic */ Parcelable f;

    public c(HotelsLocationDialog hotelsLocationDialog, Function0 function0, View view, Function1 function1, Function0 function02, Parcelable parcelable) {
        this.a = hotelsLocationDialog;
        this.b = function0;
        this.c = view;
        this.d = function1;
        this.e = function02;
        this.f = parcelable;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(HotelsLocationDialogItem hotelsLocationDialogItem) {
        this.d.invoke(hotelsLocationDialogItem.getLocation());
        View view = this.c;
        if (view != null) {
            Keyboards.hideKeyboard$default(view, false, 1, null);
        }
        this.a.performDismiss();
    }
}
