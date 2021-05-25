package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerInfoDomain;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatAnswerInitialize;
import ru.sravni.android.bankproduct.utils.masktext.IMaskTextErrorHandler;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\rR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\rR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\rR\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\rR\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\rR\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\rR\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\r¨\u0006\u001d"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/IPassportScanAnswerViewModel;", "Lru/sravni/android/bankproduct/utils/masktext/IMaskTextErrorHandler;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/IChatAnswerInitialize;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/DocumentFieldInfo;", "documentFieldInfo", "", "setNewValue", "(Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/DocumentFieldInfo;)V", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "getAnswerInfoDomain", "()Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "Landroidx/lifecycle/LiveData;", "getIssueDate", "()Landroidx/lifecycle/LiveData;", "issueDate", "", "getPassportScanSignal", "passportScanSignal", "getSeriesNumber", "seriesNumber", "isMaskFilledAuthorityCode", "isCompleteFields", "getBirthDate", "birthDate", "isMaskFilledIssueDate", "isMaskFilledBirthDate", "isMaskFilledSeriesNumber", "getAuthorityCode", "authorityCode", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IPassportScanAnswerViewModel extends IMaskTextErrorHandler, IChatAnswerInitialize {
    @NotNull
    AnswerInfoDomain getAnswerInfoDomain();

    @NotNull
    LiveData<DocumentFieldInfo> getAuthorityCode();

    @NotNull
    LiveData<DocumentFieldInfo> getBirthDate();

    @NotNull
    LiveData<DocumentFieldInfo> getIssueDate();

    @NotNull
    LiveData<Boolean> getPassportScanSignal();

    @NotNull
    LiveData<DocumentFieldInfo> getSeriesNumber();

    @NotNull
    LiveData<Boolean> isCompleteFields();

    @NotNull
    LiveData<Boolean> isMaskFilledAuthorityCode();

    @NotNull
    LiveData<Boolean> isMaskFilledBirthDate();

    @NotNull
    LiveData<Boolean> isMaskFilledIssueDate();

    @NotNull
    LiveData<Boolean> isMaskFilledSeriesNumber();

    void setNewValue(@NotNull DocumentFieldInfo documentFieldInfo);
}
