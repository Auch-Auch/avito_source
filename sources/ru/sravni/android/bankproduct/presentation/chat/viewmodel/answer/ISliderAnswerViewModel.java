package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatAnswerInitialize;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard;
import ru.sravni.android.bankproduct.utils.adapter.ISliderPositionListener;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000bR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000bR\"\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00140\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000b¨\u0006\u0017"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/ISliderAnswerViewModel;", "Lru/sravni/android/bankproduct/utils/adapter/ISliderPositionListener;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/IChatAnswerInitialize;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/INextContentCard;", "answerSender", "", "sendAnswer", "(Lru/sravni/android/bankproduct/presentation/chat/viewmodel/INextContentCard;)V", "Landroidx/lifecycle/LiveData;", "", "getSliderStartValue", "()Landroidx/lifecycle/LiveData;", "sliderStartValue", "", "getStartPosition", "startPosition", "getSliderEndValue", "sliderEndValue", "getProgressPointsCount", "progressPointsCount", "", "getSliderValues", "sliderValues", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface ISliderAnswerViewModel extends ISliderPositionListener, IChatAnswerInitialize {
    @NotNull
    LiveData<Integer> getProgressPointsCount();

    @NotNull
    LiveData<String> getSliderEndValue();

    @NotNull
    LiveData<String> getSliderStartValue();

    @NotNull
    LiveData<List<String>> getSliderValues();

    @NotNull
    LiveData<Integer> getStartPosition();

    void sendAnswer(@NotNull INextContentCard iNextContentCard);
}
