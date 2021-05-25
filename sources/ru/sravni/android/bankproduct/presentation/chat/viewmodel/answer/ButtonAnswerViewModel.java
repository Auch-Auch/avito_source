package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerInfoDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.ContentCardActionInfoDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.IContentCardDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.card.ButtonContentCardDomain;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR(\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/ButtonAnswerViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/IButtonAnswerViewModel;", "", "conversationID", "Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;", "contentCard", "", "init", "(Ljava/lang/String;Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;)V", "Landroidx/lifecycle/MutableLiveData;", "", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/ButtonAnswerInfo;", "c", "Landroidx/lifecycle/MutableLiveData;", "getButtonAnswerVariantList", "()Landroidx/lifecycle/MutableLiveData;", "buttonAnswerVariantList", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ButtonAnswerViewModel extends ViewModel implements IButtonAnswerViewModel {
    @NotNull
    public final MutableLiveData<List<ButtonAnswerInfo>> c = new MutableLiveData<>();

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatAnswerInitialize
    public void init(@NotNull String str, @Nullable IContentCardDomain iContentCardDomain) {
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        IContentCardDomain iContentCardDomain2 = iContentCardDomain;
        if (!(iContentCardDomain2 instanceof ButtonContentCardDomain)) {
            iContentCardDomain2 = null;
        }
        ButtonContentCardDomain buttonContentCardDomain = (ButtonContentCardDomain) iContentCardDomain2;
        if (buttonContentCardDomain != null) {
            MutableLiveData<List<ButtonAnswerInfo>> buttonAnswerVariantList = getButtonAnswerVariantList();
            List<ContentCardActionInfoDomain> actions = buttonContentCardDomain.getActions();
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(actions, 10));
            for (T t : actions) {
                arrayList.add(new ButtonAnswerInfo(new AnswerInfoDomain(buttonContentCardDomain.getOrderId(), str, t.getText(), null, t.getCode(), 8, null), t.getText()));
            }
            buttonAnswerVariantList.setValue(arrayList);
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IButtonAnswerViewModel
    @NotNull
    public MutableLiveData<List<ButtonAnswerInfo>> getButtonAnswerVariantList() {
        return this.c;
    }
}
