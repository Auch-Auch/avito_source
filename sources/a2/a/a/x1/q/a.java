package a2.a.a.x1.q;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.photo_picker.R;
import com.avito.android.util.Rotation;
import com.avito.android.util.Views;
import com.jakewharton.rxbinding3.view.RxView;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a implements c {
    public final View a;
    public final TextView b;
    public final View c;

    /* renamed from: a2.a.a.x1.q.a$a  reason: collision with other inner class name */
    public static final class C0010a<T, R> implements Function<Unit, Unit> {
        public static final C0010a a = new C0010a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Unit apply(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return Unit.INSTANCE;
        }
    }

    public a(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        View findViewById = viewGroup.findViewById(R.id.continue_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.continue_button);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.continue_progress);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.continue_progress)");
        this.c = findViewById3;
        Views.show(findViewById);
    }

    @Override // a2.a.a.x1.q.c
    public void a(@NotNull Rotation rotation) {
        Point point;
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        int width = this.a.getWidth();
        int height = this.a.getHeight();
        if (rotation instanceof Rotation.Rotation_90) {
            int i = width / 2;
            point = new Point(i, i);
        } else if (rotation instanceof Rotation.Rotation_270) {
            int i2 = height / 2;
            point = new Point(width - i2, i2);
        } else {
            point = new Point(0, 0);
        }
        this.a.setPivotX((float) point.x);
        this.a.setPivotY((float) point.y);
        this.a.setRotation((float) rotation.getDegree());
    }

    @Override // a2.a.a.x1.q.c
    public void b(boolean z) {
        TextView textView = this.b;
        if (z) {
            Views.conceal(textView);
        } else {
            Views.show(textView);
        }
        Views.setVisible(this.c, z);
    }

    @Override // a2.a.a.x1.q.c
    @NotNull
    public Observable<Unit> getClickObservable() {
        Observable<R> map = RxView.clicks(this.b).map(C0010a.a);
        Intrinsics.checkNotNullExpressionValue(map, "button.clicks().map { Unit }");
        return map;
    }

    @Override // a2.a.a.x1.q.c
    public void setEnabled(boolean z) {
        this.b.setEnabled(z);
    }

    @Override // a2.a.a.x1.q.c
    public void setVisibility(boolean z) {
        if (z) {
            Views.show(this.b);
        } else {
            Views.conceal(this.b);
        }
    }
}
