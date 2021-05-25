package ru.avito.component.text_input.password;

import io.reactivex.rxjava3.core.Observable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.text_input.EditTextSingleLine;
@Deprecated(message = "Используй com.avito.android.lib.design.input.Input", replaceWith = @ReplaceWith(expression = "Input", imports = {"com.avito.android.lib.design.input.Input"}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/avito/component/text_input/password/EditTextPassword;", "Lru/avito/component/text_input/EditTextSingleLine;", "", "isSecure", "()Z", "setSecure", "(Z)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface EditTextPassword extends EditTextSingleLine {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static Observable<Integer> actionCallbacks(@NotNull EditTextPassword editTextPassword) {
            return EditTextSingleLine.DefaultImpls.actionCallbacks(editTextPassword);
        }

        @NotNull
        public static Observable<Unit> doneCallbacks(@NotNull EditTextPassword editTextPassword) {
            return EditTextSingleLine.DefaultImpls.doneCallbacks(editTextPassword);
        }
    }

    boolean isSecure();

    void setSecure(boolean z);
}
