package android.util;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public abstract class FloatProperty<T> extends Property<T, Float> {
    public FloatProperty(@Nullable String str) {
        super(Float.class, str);
    }

    @Override // android.util.Property
    @NonNull
    public abstract Float get(@NonNull T t);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    @SuppressLint({"NewApi"})
    public /* bridge */ /* synthetic */ void set(@NonNull Object obj, @NonNull Float f) {
        set((FloatProperty<T>) obj, f);
    }

    public abstract void setValue(@NonNull T t, float f);

    @SuppressLint({"NewApi"})
    public final void set(@NonNull T t, @NonNull Float f) {
        setValue(t, f.floatValue());
    }
}
