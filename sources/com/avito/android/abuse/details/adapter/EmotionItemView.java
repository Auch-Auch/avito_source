package com.avito.android.abuse.details.adapter;

import com.avito.android.component.emotion_selector.EmotionSelector;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/abuse/details/adapter/EmotionItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/component/emotion_selector/EmotionSelector;", "", "hint", "", "setHint", "(Ljava/lang/String;)V", PlatformActions.HIDE_KEYBOARD, "()V", "abuse_release"}, k = 1, mv = {1, 4, 2})
public interface EmotionItemView extends ItemView, EmotionSelector {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull EmotionItemView emotionItemView) {
            ItemView.DefaultImpls.onUnbind(emotionItemView);
        }
    }

    void hideKeyboard();

    void setHint(@NotNull String str);
}
