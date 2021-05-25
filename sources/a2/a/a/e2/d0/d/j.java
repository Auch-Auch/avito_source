package a2.a.a.e2.d0.d;

import com.avito.android.publish.slots.ConsumeValueChangeResult;
import com.avito.android.publish.slots.anonymous_number.AnonymousNumberSlotWrapper;
import com.avito.android.remote.model.category_parameters.slot.SlotType;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
public final class j<T> implements Consumer<Pair<? extends String, ? extends String>> {
    public final /* synthetic */ AnonymousNumberSlotWrapper a;

    public j(AnonymousNumberSlotWrapper anonymousNumberSlotWrapper) {
        this.a = anonymousNumberSlotWrapper;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r7v8, resolved type: com.jakewharton.rxrelay2.PublishRelay */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Pair<? extends String, ? extends String> pair) {
        String str = (String) pair.component2();
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (Character.isDigit(charAt)) {
                    sb.append(charAt);
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
            if (sb2 != null && sb2.length() == 11) {
                AnonymousNumberSlotWrapper.a(this.a, null, 1);
                return;
            }
        }
        if (this.a.d) {
            this.a.d = false;
            this.a.h.accept(new ConsumeValueChangeResult.NeedViewUpdate(SlotType.ANONYMOUS_NUMBER));
        }
    }
}
