package a2.a.a.k1.a.j;

import com.avito.android.lib.design.snackbar.SnackbarView;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<WeakReference<SnackbarView>, Boolean> {
    public final /* synthetic */ SnackbarView a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(SnackbarView snackbarView) {
        super(1);
        this.a = snackbarView;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(WeakReference<SnackbarView> weakReference) {
        WeakReference<SnackbarView> weakReference2 = weakReference;
        Intrinsics.checkNotNullParameter(weakReference2, "it");
        return Boolean.valueOf(Intrinsics.areEqual(weakReference2.get(), this.a));
    }
}
