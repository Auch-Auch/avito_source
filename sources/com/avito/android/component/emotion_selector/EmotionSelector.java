package com.avito.android.component.emotion_selector;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001JI\u0010\u000b\u001a\u00020\t28\u0010\n\u001a4\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002H&¢\u0006\u0004\b\u000b\u0010\fJI\u0010\u0011\u001a\u00020\t2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u00022\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\tH&¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\tH&¢\u0006\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0006\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/avito/android/component/emotion_selector/EmotionSelector;", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "selectedNumber", "", "fromUser", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSelectedNumberChangedListener", "(Lkotlin/jvm/functions/Function2;)V", "changeNumber", "Lkotlin/Function0;", "startTracking", "stopTracking", "setListener", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "clearListener", "()V", "show", "hide", "getSelectedNumber", "()I", "setSelectedNumber", "(I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface EmotionSelector {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {

        /* compiled from: kotlin-style lambda group */
        public static final class a extends Lambda implements Function0<Unit> {
            public static final a b = new a(0);
            public static final a c = new a(1);
            public final /* synthetic */ int a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(int i) {
                super(0);
                this.a = i;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                int i = this.a;
                if (i == 0) {
                    return Unit.INSTANCE;
                }
                if (i == 1) {
                    return Unit.INSTANCE;
                }
                throw null;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.component.emotion_selector.EmotionSelector */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void setListener$default(EmotionSelector emotionSelector, Function2 function2, Function0 function0, Function0 function02, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    function0 = a.b;
                }
                if ((i & 4) != 0) {
                    function02 = a.c;
                }
                emotionSelector.setListener(function2, function0, function02);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setListener");
        }
    }

    void clearListener();

    int getSelectedNumber();

    void hide();

    void setListener(@NotNull Function2<? super Integer, ? super Boolean, Unit> function2, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02);

    void setSelectedNumber(int i);

    void setSelectedNumberChangedListener(@Nullable Function2<? super Integer, ? super Boolean, Unit> function2);

    void show();
}
