package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer;

import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010R!\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/WrongSliderPointError;", "", "", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/SliderAnswerItem;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getItems", "()Ljava/util/List;", "items", "", AuthSource.SEND_ABUSE, "I", "getPosition", "()I", VKApiConst.POSITION, "<init>", "(ILjava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class WrongSliderPointError extends Throwable {
    public final int a;
    @Nullable
    public final List<SliderAnswerItem> b;

    public WrongSliderPointError(int i, @Nullable List<SliderAnswerItem> list) {
        this.a = i;
        this.b = list;
    }

    @Nullable
    public final List<SliderAnswerItem> getItems() {
        return this.b;
    }

    public final int getPosition() {
        return this.a;
    }
}
