package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
public abstract class InputMergerFactory {

    public class a extends InputMergerFactory {
        @Override // androidx.work.InputMergerFactory
        @Nullable
        public InputMerger createInputMerger(@NonNull String str) {
            return null;
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static InputMergerFactory getDefaultInputMergerFactory() {
        return new a();
    }

    @Nullable
    public abstract InputMerger createInputMerger(@NonNull String str);

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final InputMerger createInputMergerWithDefaultFallback(@NonNull String str) {
        InputMerger createInputMerger = createInputMerger(str);
        return createInputMerger == null ? InputMerger.fromClassName(str) : createInputMerger;
    }
}
