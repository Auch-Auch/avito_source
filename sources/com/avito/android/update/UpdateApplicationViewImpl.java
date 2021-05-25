package com.avito.android.update;

import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.ButtonsKt;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.button.ButtonImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0019\u0010\u0015\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/update/UpdateApplicationViewImpl;", "Lcom/avito/android/update/UpdateApplicationView;", "Lio/reactivex/Observable;", "", "updateButtonClicks", "()Lio/reactivex/Observable;", "showNoApplicationInstalledError", "()V", "Lru/avito/component/button/ButtonImpl;", "c", "Lru/avito/component/button/ButtonImpl;", "updateButton", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "content", AuthSource.BOOKING_ORDER, "updateApplicationImage", "d", "getView", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "update_release"}, k = 1, mv = {1, 4, 2})
public final class UpdateApplicationViewImpl implements UpdateApplicationView {
    public final View a;
    public final View b;
    public final ButtonImpl c;
    @NotNull
    public final View d;

    public UpdateApplicationViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.d = view;
        View findViewById = view.findViewById(R.id.content);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
        View findViewById2 = view.findViewById(R.id.image_update_application);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById2;
        View findViewById3 = view.findViewById(R.id.button_update_application);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        ButtonImpl buttonImpl = new ButtonImpl(findViewById3);
        this.c = buttonImpl;
        buttonImpl.setText(view.getContext().getText(R.string.update_application_button));
        Views.hideIfDoesNotFitIntoParent(findViewById2, findViewById);
    }

    @NotNull
    public final View getView() {
        return this.d;
    }

    @Override // com.avito.android.update.UpdateApplicationView
    public void showNoApplicationInstalledError() {
        Views.showSnackBar$default(this.d, R.string.no_application_installed_to_perform_this_action, 0, (Integer) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.update.UpdateApplicationView
    @NotNull
    public Observable<Unit> updateButtonClicks() {
        return InteropKt.toV2(ButtonsKt.clicks(this.c));
    }
}
