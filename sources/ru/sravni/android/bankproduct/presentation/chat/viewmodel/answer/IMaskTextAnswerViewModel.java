package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerInfoDomain;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatAnswerInitialize;
import ru.sravni.android.bankproduct.utils.masktext.IMaskTextErrorHandler;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0014"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/IMaskTextAnswerViewModel;", "Lru/sravni/android/bankproduct/utils/masktext/IMaskTextErrorHandler;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/IChatAnswerInitialize;", "", "text", "", "maskFilled", "", "setTextChange", "(Ljava/lang/String;Z)V", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "getAnswerInfoDomain", "()Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "Landroidx/lifecycle/LiveData;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/InitMaskElementInfo;", "getInitMaskElement", "()Landroidx/lifecycle/LiveData;", "initMaskElement", "getCanAnswer", "canAnswer", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IMaskTextAnswerViewModel extends IMaskTextErrorHandler, IChatAnswerInitialize {
    @NotNull
    AnswerInfoDomain getAnswerInfoDomain();

    @NotNull
    LiveData<Boolean> getCanAnswer();

    @NotNull
    LiveData<InitMaskElementInfo> getInitMaskElement();

    void setTextChange(@NotNull String str, boolean z);
}
