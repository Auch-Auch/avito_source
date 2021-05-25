package ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.presentation.auth.phone.viewmodel.StateEnum;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H&¢\u0006\u0004\b\u000e\u0010\nR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0012R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0012R\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0012¨\u0006!"}, d2 = {"Lru/sravni/android/bankproduct/presentation/auth/sms/viewmodel/IProfileSmsViewModel;", "", "", "smsCode", "", "maxLength", "", "smsCodeChange", "(Ljava/lang/String;I)V", "repeatSendPhone", "()V", "time", "setTime", "(Ljava/lang/String;)V", "clearSmsField", "Landroidx/lifecycle/LiveData;", "Lru/sravni/android/bankproduct/presentation/auth/phone/viewmodel/StateEnum;", "getEditSmsStatus", "()Landroidx/lifecycle/LiveData;", "editSmsStatus", "getPhoneNumber", "phoneNumber", "getTimerValue", "timerValue", "getSmsCodeText", "smsCodeText", "getSmsInsertedText", "smsInsertedText", "getTimerState", "timerState", "", "getRepeatSmsCode", "repeatSmsCode", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IProfileSmsViewModel {
    void clearSmsField();

    @NotNull
    LiveData<StateEnum> getEditSmsStatus();

    @NotNull
    LiveData<String> getPhoneNumber();

    @NotNull
    LiveData<Boolean> getRepeatSmsCode();

    @NotNull
    LiveData<String> getSmsCodeText();

    @NotNull
    LiveData<String> getSmsInsertedText();

    @NotNull
    LiveData<Integer> getTimerState();

    @NotNull
    LiveData<String> getTimerValue();

    void repeatSendPhone();

    void setTime(@Nullable String str);

    void smsCodeChange(@NotNull String str, int i);
}
