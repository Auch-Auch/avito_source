package android.util;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public abstract class IntProperty<T> extends Property<T, Integer> {
    public IntProperty(@Nullable String str) {
        super(Integer.class, str);
    }

    @Override // android.util.Property
    @NonNull
    /* renamed from: get */
    public abstract Integer mo240get(@NonNull T t);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    @SuppressLint({"NewApi"})
    public /* bridge */ /* synthetic */ void set(@NonNull Object obj, @NonNull Integer num) {
        set((IntProperty<T>) obj, num);
    }

    public abstract void setValue(@NonNull T t, int i);

    @SuppressLint({"NewApi"})
    public final void set(@NonNull T t, @NonNull Integer num) {
        setValue(t, num.intValue());
    }
}
