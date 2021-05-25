package com.avito.android.abuse.details.adapter;

import android.view.View;
import com.avito.android.abuse.R;
import com.avito.android.component.emotion_selector.EmotionSelector;
import com.avito.android.component.emotion_selector.EmotionSelectorImpl;
import com.avito.android.component.subheader.SubheaderImpl;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.Keyboards;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b*\u0010+J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\f\u0010\nJJ\u0010\u0014\u001a\u00020\u00062\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\r2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015JJ\u0010\u001b\u001a\u00020\u000628\u0010\u001a\u001a4\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rH\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u001d\u0010\nR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010\u0018\u001a\u00020\u000e8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/avito/android/abuse/details/adapter/EmotionItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/abuse/details/adapter/EmotionItemView;", "Lcom/avito/android/component/emotion_selector/EmotionSelector;", "", "hint", "", "setHint", "(Ljava/lang/String;)V", PlatformActions.HIDE_KEYBOARD, "()V", "clearListener", "hide", "Lkotlin/Function2;", "", "", "changeNumber", "Lkotlin/Function0;", "startTracking", "stopTracking", "setListener", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Lkotlin/ParameterName;", "name", "selectedNumber", "fromUser", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSelectedNumberChangedListener", "(Lkotlin/jvm/functions/Function2;)V", "show", "Landroid/view/View;", "t", "Landroid/view/View;", "rootView", "getSelectedNumber", "()I", "setSelectedNumber", "(I)V", "Lcom/avito/android/component/subheader/SubheaderImpl;", "s", "Lcom/avito/android/component/subheader/SubheaderImpl;", "hintView", "<init>", "(Landroid/view/View;)V", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class EmotionItemViewImpl extends BaseViewHolder implements EmotionItemView, EmotionSelector {
    public final SubheaderImpl s;
    public final View t;
    public final /* synthetic */ EmotionSelectorImpl u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmotionItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        View findViewById = view.findViewById(R.id.emotion);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.u = new EmotionSelectorImpl(findViewById);
        this.t = view;
        View findViewById2 = view.findViewById(R.id.hint);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.s = new SubheaderImpl(findViewById2);
    }

    @Override // com.avito.android.component.emotion_selector.EmotionSelector
    public void clearListener() {
        this.u.clearListener();
    }

    @Override // com.avito.android.component.emotion_selector.EmotionSelector
    public int getSelectedNumber() {
        return this.u.getSelectedNumber();
    }

    @Override // com.avito.android.component.emotion_selector.EmotionSelector
    public void hide() {
        this.u.hide();
    }

    @Override // com.avito.android.abuse.details.adapter.EmotionItemView
    public void hideKeyboard() {
        Keyboards.hideKeyboard$default(this.t, false, 1, null);
    }

    @Override // com.avito.android.abuse.details.adapter.EmotionItemView
    public void setHint(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "hint");
        this.s.setText(str);
    }

    @Override // com.avito.android.component.emotion_selector.EmotionSelector
    public void setListener(@NotNull Function2<? super Integer, ? super Boolean, Unit> function2, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function2, "changeNumber");
        Intrinsics.checkNotNullParameter(function0, "startTracking");
        Intrinsics.checkNotNullParameter(function02, "stopTracking");
        this.u.setListener(function2, function0, function02);
    }

    @Override // com.avito.android.component.emotion_selector.EmotionSelector
    public void setSelectedNumber(int i) {
        this.u.setSelectedNumber(i);
    }

    @Override // com.avito.android.component.emotion_selector.EmotionSelector
    public void setSelectedNumberChangedListener(@Nullable Function2<? super Integer, ? super Boolean, Unit> function2) {
        this.u.setSelectedNumberChangedListener(function2);
    }

    @Override // com.avito.android.component.emotion_selector.EmotionSelector
    public void show() {
        this.u.show();
    }
}
