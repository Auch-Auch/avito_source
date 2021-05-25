package defpackage;

import android.widget.TextView;
import com.avito.android.messenger.conversation.mvi.message_menu.MenuElement;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: g5  reason: default package */
public final class g5 extends Lambda implements Function1<TextView, Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g5(int i, Object obj) {
        super(1);
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(TextView textView) {
        int i = this.a;
        if (i == 0) {
            TextView textView2 = textView;
            Intrinsics.checkNotNullParameter(textView2, "$receiver");
            textView2.setText(((MenuElement.Hint) ((MenuElement) this.b)).getText());
            return Unit.INSTANCE;
        } else if (i == 1) {
            TextView textView3 = textView;
            Intrinsics.checkNotNullParameter(textView3, "$receiver");
            textView3.setText(((MenuElement.Header) ((MenuElement) this.b)).getText());
            return Unit.INSTANCE;
        } else if (i == 2) {
            TextView textView4 = textView;
            Intrinsics.checkNotNullParameter(textView4, "$receiver");
            textView4.setText(((MenuElement.Text) ((MenuElement) this.b)).getText());
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}
