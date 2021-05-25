package ru.sravni.android.bankproduct.utils.masktext;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.redmadrobot.inputmask.MaskedTextChangedListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandler;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.utils.di.UtilProviderKt;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lru/sravni/android/bankproduct/utils/masktext/MaskedTextChangedListenerWithCatch;", "Lcom/redmadrobot/inputmask/MaskedTextChangedListener;", "Landroid/text/Editable;", "edit", "", "afterTextChanged", "(Landroid/text/Editable;)V", "Landroid/widget/EditText;", AuthSource.OPEN_CHANNEL_LIST, "Landroid/widget/EditText;", AnalyticFieldsName.field, "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandler;", "n", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandler;", "errorHandler", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "o", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "", "format", "", "autocomplete", "Landroid/text/TextWatcher;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;", "valueListener", "<init>", "(Ljava/lang/String;ZLandroid/widget/EditText;Landroid/text/TextWatcher;Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandler;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class MaskedTextChangedListenerWithCatch extends MaskedTextChangedListener {
    public final EditText m;
    public final IErrorHandler n;
    public final IThrowableWrapper o;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MaskedTextChangedListenerWithCatch(String str, boolean z, EditText editText, TextWatcher textWatcher, MaskedTextChangedListener.ValueListener valueListener, IErrorHandler iErrorHandler, IThrowableWrapper iThrowableWrapper, int i, j jVar) {
        this(str, z, editText, textWatcher, valueListener, iErrorHandler, (i & 64) != 0 ? UtilProviderKt.throwableWrapperFactoryMethod("util") : iThrowableWrapper);
    }

    @Override // com.redmadrobot.inputmask.MaskedTextChangedListener, android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable editable) {
        try {
            super.afterTextChanged(editable);
        } catch (Exception unused) {
            IErrorHandler iErrorHandler = this.n;
            if (iErrorHandler != null) {
                iErrorHandler.handleError(this.o.wrap(new MaskedTextWrongFormatException(getPrimaryFormat(), String.valueOf(editable))));
            }
            this.m.removeTextChangedListener(this);
            this.m.addTextChangedListener(this);
            TextWatcher listener = getListener();
            if (listener != null) {
                listener.afterTextChanged(editable);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MaskedTextChangedListenerWithCatch(@NotNull String str, boolean z, @NotNull EditText editText, @Nullable TextWatcher textWatcher, @Nullable MaskedTextChangedListener.ValueListener valueListener, @Nullable IErrorHandler iErrorHandler, @NotNull IThrowableWrapper iThrowableWrapper) {
        super(str, z, editText, textWatcher, valueListener);
        Intrinsics.checkParameterIsNotNull(str, "format");
        Intrinsics.checkParameterIsNotNull(editText, AnalyticFieldsName.field);
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        this.m = editText;
        this.n = iErrorHandler;
        this.o = iThrowableWrapper;
    }
}
