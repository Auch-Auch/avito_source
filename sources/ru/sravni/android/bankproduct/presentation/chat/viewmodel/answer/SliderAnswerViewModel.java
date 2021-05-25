package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerInfoDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.IContentCardDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.card.SliderContentCardDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.card.SliderSnapPointDomain;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard;
import t6.n.e;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010.\u001a\u00020+¢\u0006\u0004\b5\u00106J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR(\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001c0\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u0016R\"\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u0016R\"\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010\u0016R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020'0\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\"\u00101\u001a\b\u0012\u0004\u0012\u00020 0\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b/\u0010\u0014\u001a\u0004\b0\u0010\u0016R\u0016\u00104\u001a\u00020 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103¨\u00067"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/SliderAnswerViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/ISliderAnswerViewModel;", "", "conversationID", "Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;", "contentCard", "", "init", "(Ljava/lang/String;Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;)V", "", VKApiConst.POSITION, "onSliderPositionChanged", "(F)V", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/INextContentCard;", "answerSender", "sendAnswer", "(Lru/sravni/android/bankproduct/presentation/chat/viewmodel/INextContentCard;)V", "Landroidx/lifecycle/MutableLiveData;", "f", "Landroidx/lifecycle/MutableLiveData;", "getSliderStartValue", "()Landroidx/lifecycle/MutableLiveData;", "sliderStartValue", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "j", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "", "c", "getSliderValues", "sliderValues", "", "e", "getStartPosition", "startPosition", g.a, "getSliderEndValue", "sliderEndValue", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/SliderAnswerItem;", "i", "Ljava/util/List;", "listSliderItem", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "k", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "d", "getProgressPointsCount", "progressPointsCount", "h", "I", "selectedPosition", "<init>", "(Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SliderAnswerViewModel extends ViewModel implements ISliderAnswerViewModel {
    @NotNull
    public final MutableLiveData<List<String>> c = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Integer> d = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Integer> e = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<String> f = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<String> g = new MutableLiveData<>();
    public int h;
    public List<SliderAnswerItem> i = CollectionsKt__CollectionsKt.emptyList();
    public final IErrorLogger j;
    public final IThrowableWrapper k;

    public SliderAnswerViewModel(@NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        this.j = iErrorLogger;
        this.k = iThrowableWrapper;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatAnswerInitialize
    public void init(@NotNull String str, @Nullable IContentCardDomain iContentCardDomain) {
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        if (!(iContentCardDomain instanceof SliderContentCardDomain)) {
            iContentCardDomain = null;
        }
        SliderContentCardDomain sliderContentCardDomain = (SliderContentCardDomain) iContentCardDomain;
        if (sliderContentCardDomain != null) {
            getStartPosition().setValue(0);
            List<SliderSnapPointDomain> pointDomains = sliderContentCardDomain.getPointDomains();
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(pointDomains, 10));
            for (T t : pointDomains) {
                arrayList.add(new SliderAnswerItem(sliderContentCardDomain.getOrderId(), str, sliderContentCardDomain.getFieldContentName(), t.getLabel(), t.getKey()));
            }
            this.i = arrayList;
            getProgressPointsCount().setValue(Integer.valueOf(this.i.size() - 1));
            getSliderStartValue().setValue(this.i.get(0).getLabel());
            getSliderEndValue().setValue(sliderContentCardDomain.getPointDomains().get(this.i.size() - 1).getLabel());
            MutableLiveData<List<String>> sliderValues = getSliderValues();
            List<SliderAnswerItem> list = this.i;
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().getLabel());
            }
            sliderValues.setValue(arrayList2);
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.adapter.ISliderPositionListener
    public void onSliderPositionChanged(float f2) {
        this.h = (int) f2;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISliderAnswerViewModel
    public void sendAnswer(@NotNull INextContentCard iNextContentCard) {
        Intrinsics.checkParameterIsNotNull(iNextContentCard, "answerSender");
        int size = this.i.size();
        int i2 = this.h;
        if (i2 >= 0 && size >= i2) {
            SliderAnswerItem sliderAnswerItem = this.i.get(i2);
            iNextContentCard.nextCard(new AnswerInfoDomain(sliderAnswerItem.getCardId(), sliderAnswerItem.getConversationId(), sliderAnswerItem.getLabel(), q.mapOf(TuplesKt.to(sliderAnswerItem.getFieldName(), sliderAnswerItem.getKey())), null, 16, null));
            return;
        }
        this.j.logError(MessagePriority.ERROR, this.k.wrap(new WrongSliderPointError(this.h, this.i)));
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISliderAnswerViewModel
    @NotNull
    public MutableLiveData<Integer> getProgressPointsCount() {
        return this.d;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISliderAnswerViewModel
    @NotNull
    public MutableLiveData<String> getSliderEndValue() {
        return this.g;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISliderAnswerViewModel
    @NotNull
    public MutableLiveData<String> getSliderStartValue() {
        return this.f;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISliderAnswerViewModel
    @NotNull
    public MutableLiveData<List<String>> getSliderValues() {
        return this.c;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISliderAnswerViewModel
    @NotNull
    public MutableLiveData<Integer> getStartPosition() {
        return this.e;
    }
}
