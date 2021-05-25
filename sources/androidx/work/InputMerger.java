package androidx.work;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.List;
public abstract class InputMerger {
    public static final String a = Logger.tagWithPrefix("InputMerger");

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static InputMerger fromClassName(String str) {
        try {
            return (InputMerger) Class.forName(str).newInstance();
        } catch (Exception e) {
            Logger.get().error(a, a.c3("Trouble instantiating + ", str), e);
            return null;
        }
    }

    @NonNull
    public abstract Data merge(@NonNull List<Data> list);
}
