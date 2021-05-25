package com.avito.android.abuse.details.adapter;

import com.avito.android.abuse.details.adapter.AbuseField;
import com.avito.android.component.emotion_selector.EmotionSelector;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u000e\b\u0001\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/abuse/details/adapter/EmotionItemPresenterImpl;", "Lcom/avito/android/abuse/details/adapter/EmotionItemPresenter;", "Lcom/avito/android/abuse/details/adapter/EmotionItemView;", "view", "Lcom/avito/android/abuse/details/adapter/AbuseField$Emotion;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/abuse/details/adapter/EmotionItemView;Lcom/avito/android/abuse/details/adapter/AbuseField$Emotion;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/abuse/details/adapter/AbuseField;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "focusConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class EmotionItemPresenterImpl implements EmotionItemPresenter {
    public final Consumer<AbuseField> a;

    public static final class a extends Lambda implements Function2<Integer, Boolean, Unit> {
        public final /* synthetic */ EmotionItemView a;
        public final /* synthetic */ AbuseField.Emotion b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(EmotionItemPresenterImpl emotionItemPresenterImpl, EmotionItemView emotionItemView, AbuseField.Emotion emotion) {
            super(2);
            this.a = emotionItemView;
            this.b = emotion;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Integer num, Boolean bool) {
            int intValue = num.intValue();
            bool.booleanValue();
            AbuseField.Emotion emotion = this.b;
            Integer valueOf = Integer.valueOf(intValue);
            if (!(valueOf.intValue() > -1)) {
                valueOf = null;
            }
            emotion.setValue(valueOf);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ EmotionItemPresenterImpl a;
        public final /* synthetic */ EmotionItemView b;
        public final /* synthetic */ AbuseField.Emotion c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(EmotionItemPresenterImpl emotionItemPresenterImpl, EmotionItemView emotionItemView, AbuseField.Emotion emotion) {
            super(0);
            this.a = emotionItemPresenterImpl;
            this.b = emotionItemView;
            this.c = emotion;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.c);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public EmotionItemPresenterImpl(@Named("focused") @NotNull Consumer<AbuseField> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "focusConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull EmotionItemView emotionItemView, @NotNull AbuseField.Emotion emotion, int i) {
        Intrinsics.checkNotNullParameter(emotionItemView, "view");
        Intrinsics.checkNotNullParameter(emotion, "item");
        EmotionSelector.DefaultImpls.setListener$default(emotionItemView, new a(this, emotionItemView, emotion), new b(this, emotionItemView, emotion), null, 4, null);
        emotionItemView.setHint(emotion.getHint());
        Integer value = emotion.getValue();
        emotionItemView.setSelectedNumber(value != null ? value.intValue() : -1);
    }
}
