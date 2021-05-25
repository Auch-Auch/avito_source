package a7.c.a.a;

import androidx.lifecycle.Observer;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.SravniChatActivity;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.utils.keyboard.KeyboardError;
public final class a<T> implements Observer<Integer> {
    public final /* synthetic */ SravniChatActivity a;
    public final /* synthetic */ IErrorLogger b;
    public final /* synthetic */ IThrowableWrapper c;

    public a(SravniChatActivity sravniChatActivity, IErrorLogger iErrorLogger, IThrowableWrapper iThrowableWrapper) {
        this.a = sravniChatActivity;
        this.b = iErrorLogger;
        this.c = iThrowableWrapper;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Integer num) {
        Integer num2 = num;
        int i = R.id.hide_keyboard;
        if (num2 != null && num2.intValue() == i) {
            SravniChatActivity.access$hideKeyboard(this.a);
            return;
        }
        int i2 = R.id.show_keyboard;
        if (num2 != null && num2.intValue() == i2) {
            SravniChatActivity.access$showKeyboard(this.a);
        } else {
            this.b.logError(MessagePriority.WARN, this.c.wrap(new KeyboardError()));
        }
    }
}
