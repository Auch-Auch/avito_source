package ru.sravni.android.bankproduct.utils.keyboard;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lru/sravni/android/bankproduct/utils/keyboard/KeyboardViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardViewModel;", "", "showKeyboard", "()V", PlatformActions.HIDE_KEYBOARD, "", "type", "", "convertTextTypeToInputType", "(Ljava/lang/String;)I", "", "isTextTypePhone", "(Ljava/lang/String;)Z", "Landroidx/lifecycle/MutableLiveData;", "c", "Landroidx/lifecycle/MutableLiveData;", "getKeyboardState", "()Landroidx/lifecycle/MutableLiveData;", "keyboardState", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "e", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "d", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "<init>", "(Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class KeyboardViewModel extends ViewModel implements IKeyboardViewModel {
    @NotNull
    public final MutableLiveData<Integer> c = new MutableLiveData<>();
    public final IErrorLogger d;
    public final IThrowableWrapper e;

    public KeyboardViewModel(@NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        this.d = iErrorLogger;
        this.e = iThrowableWrapper;
    }

    @Override // ru.sravni.android.bankproduct.utils.keyboard.IKeyboardTypeConverter
    public int convertTextTypeToInputType(@Nullable String str) {
        if (str == null) {
            return 1;
        }
        switch (str.hashCode()) {
            case -1034364087:
                if (str.equals("number")) {
                    return 2;
                }
                break;
            case 96619420:
                if (str.equals("email")) {
                    return 32;
                }
                break;
            case 106642798:
                if (str.equals("phone")) {
                    return 3;
                }
                break;
            case 1312628429:
                if (str.equals("standart")) {
                    return 1;
                }
                break;
        }
        this.d.logError(MessagePriority.WARN, this.e.wrap(new UnknownKeyboardTypeError(str)));
        return 1;
    }

    @Override // ru.sravni.android.bankproduct.utils.keyboard.IKeyboardHider
    public void hideKeyboard() {
        getKeyboardState().setValue(Integer.valueOf(R.id.hide_keyboard));
    }

    @Override // ru.sravni.android.bankproduct.utils.keyboard.IKeyboardTypeConverter
    public boolean isTextTypePhone(@Nullable String str) {
        return Intrinsics.areEqual(str, "phone");
    }

    @Override // ru.sravni.android.bankproduct.utils.keyboard.IKeyboardShower
    public void showKeyboard() {
        getKeyboardState().setValue(Integer.valueOf(R.id.show_keyboard));
    }

    @Override // ru.sravni.android.bankproduct.utils.keyboard.IKeyboardSignalSender
    @NotNull
    public MutableLiveData<Integer> getKeyboardState() {
        return this.c;
    }
}
