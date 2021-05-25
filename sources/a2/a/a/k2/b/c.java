package a2.a.a.k2.b;

import com.avito.android.permissions.R;
import com.avito.android.search.map.SearchMapViewImpl;
import com.avito.android.util.AvitoSnackbar;
import com.avito.android.util.Snackbars;
import com.google.android.material.snackbar.Snackbar;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function0<Snackbar> {
    public final /* synthetic */ SearchMapViewImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(SearchMapViewImpl searchMapViewImpl) {
        super(0);
        this.a = searchMapViewImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Snackbar invoke() {
        Snackbar action = AvitoSnackbar.make$default(AvitoSnackbar.INSTANCE, this.a.A, R.string.location_permission_required, 0, null, 0, null, null, 0, 0, 504, null).setAction(R.string.permission_settings, this.a.o);
        Intrinsics.checkNotNullExpressionValue(action, "AvitoSnackbar.make(view,…issionSnackBarObservable)");
        Snackbar initButton = Snackbars.initButton(action);
        initButton.addCallback(this.a.o);
        Snackbars.getTextView(initButton).setMaxLines(3);
        return initButton;
    }
}
