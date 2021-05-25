package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.editional;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.SuggestInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\"\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005¨\u0006\u0013"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/editional/ISuggestAnswerParam;", "", "Landroidx/lifecycle/LiveData;", "", "getInputType", "()Landroidx/lifecycle/LiveData;", "inputType", "", "getHint", "hint", "", "getCanAnswer", "canAnswer", "", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/SuggestInfo;", "getSuggestList", "suggestList", "getSuggestText", "suggestText", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface ISuggestAnswerParam {
    @NotNull
    LiveData<Boolean> getCanAnswer();

    @NotNull
    LiveData<String> getHint();

    @NotNull
    LiveData<Integer> getInputType();

    @NotNull
    LiveData<List<SuggestInfo>> getSuggestList();

    @NotNull
    LiveData<String> getSuggestText();
}
