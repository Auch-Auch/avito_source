package a2.a.a.x1.q;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.avito.android.PublishIntentFactory;
import com.avito.android.lib.design.button.Button;
import com.avito.android.photo_picker.R;
import com.avito.android.util.Rotation;
import com.avito.android.util.Views;
import com.jakewharton.rxbinding3.view.RxView;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class d implements c {
    public final Button a;
    public final FrameLayout b;

    public static final class a<T, R> implements Function<Unit, Unit> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Unit apply(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return Unit.INSTANCE;
        }
    }

    public d(@NotNull ViewGroup viewGroup, @NotNull PublishIntentFactory.PhotoPickerMode photoPickerMode) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        Intrinsics.checkNotNullParameter(photoPickerMode, "mode");
        View findViewById = viewGroup.findViewById(R.id.main_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.main_button)");
        Button button = (Button) findViewById;
        this.a = button;
        View findViewById2 = viewGroup.findViewById(R.id.footer);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.footer)");
        FrameLayout frameLayout = (FrameLayout) findViewById2;
        this.b = frameLayout;
        if (photoPickerMode == PublishIntentFactory.PhotoPickerMode.MODE_LEGACY) {
            String string = viewGroup.getContext().getString(com.avito.android.ui_components.R.string.continue_string);
            Intrinsics.checkNotNullExpressionValue(string, "rootView.context.getStri…R.string.continue_string)");
            button.setText(string);
        } else {
            String string2 = viewGroup.getContext().getString(com.avito.android.ui_components.R.string.button_ready);
            Intrinsics.checkNotNullExpressionValue(string2, "rootView.context.getStri…ui_R.string.button_ready)");
            button.setText(string2);
        }
        Views.show(frameLayout);
    }

    @Override // a2.a.a.x1.q.c
    public void a(@NotNull Rotation rotation) {
        Intrinsics.checkNotNullParameter(rotation, "rotation");
    }

    @Override // a2.a.a.x1.q.c
    public void b(boolean z) {
        this.a.setLoading(z);
    }

    @Override // a2.a.a.x1.q.c
    @NotNull
    public Observable<Unit> getClickObservable() {
        Observable<R> map = RxView.clicks(this.a).map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "button.clicks().map { Unit }");
        return map;
    }

    @Override // a2.a.a.x1.q.c
    public void setEnabled(boolean z) {
        this.a.setEnabled(z);
    }

    @Override // a2.a.a.x1.q.c
    public void setVisibility(boolean z) {
        if (z) {
            Views.show(this.a);
        } else {
            Views.conceal(this.a);
        }
    }
}
