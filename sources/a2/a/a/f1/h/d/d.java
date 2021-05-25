package a2.a.a.f1.h.d;

import android.widget.TextView;
import com.avito.android.in_app_calls.ui.call.CallViewImpl;
import com.avito.android.util.Views;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Consumer<String> {
    public final /* synthetic */ CallViewImpl a;

    public d(CallViewImpl callViewImpl) {
        this.a = callViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(String str) {
        TextView textView = this.a.f;
        Intrinsics.checkNotNullExpressionValue(textView, "timerView");
        textView.setText(str);
        Views.show(this.a.f);
    }
}
