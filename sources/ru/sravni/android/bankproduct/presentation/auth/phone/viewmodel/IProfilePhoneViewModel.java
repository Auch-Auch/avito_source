package ru.sravni.android.bankproduct.presentation.auth.phone.viewmodel;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.utils.masktext.IMaskTextErrorHandler;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0007H&¢\u0006\u0004\b\u000e\u0010\u000bR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0016"}, d2 = {"Lru/sravni/android/bankproduct/presentation/auth/phone/viewmodel/IProfilePhoneViewModel;", "Lru/sravni/android/bankproduct/utils/masktext/IMaskTextErrorHandler;", "", "extractedPhone", "formattedPhone", "", "maskFilled", "", "phoneChange", "(Ljava/lang/String;Ljava/lang/String;Z)V", "sendPhone", "()V", "fragmentStartAction", "clearPhoneField", "initPhone", "Landroidx/lifecycle/LiveData;", "Lru/sravni/android/bankproduct/presentation/auth/phone/viewmodel/StateEnum;", "getPhoneState", "()Landroidx/lifecycle/LiveData;", "phoneState", "getPhoneText", "phoneText", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IProfilePhoneViewModel extends IMaskTextErrorHandler {
    void clearPhoneField();

    void fragmentStartAction();

    @NotNull
    LiveData<StateEnum> getPhoneState();

    @NotNull
    LiveData<String> getPhoneText();

    void initPhone();

    void phoneChange(@NotNull String str, @NotNull String str2, boolean z);

    void sendPhone();
}
