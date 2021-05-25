package com.transitionseverywhere.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.util.Property;
import androidx.annotation.NonNull;
@TargetApi(14)
public abstract class IntProperty<T> extends Property<T, Integer> {

    public class a extends android.util.IntProperty<T> {
        public a(String str) {
            super(null);
        }

        @Override // android.util.IntProperty, android.util.Property
        @NonNull
        /* renamed from: get */
        public Integer mo240get(@NonNull T t) {
            return IntProperty.this.mo239get((IntProperty) t);
        }

        @Override // android.util.IntProperty
        public void setValue(@NonNull T t, int i) {
            IntProperty.this.setValue(t, i);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.util.IntProperty, android.util.Property
        @NonNull
        /* renamed from: get  reason: collision with other method in class */
        public Integer mo240get(@NonNull Object obj) {
            return IntProperty.this.mo239get((IntProperty) obj);
        }
    }

    public IntProperty() {
        super(Integer.class, null);
    }

    @NonNull
    @SuppressLint({"NewApi"})
    public Property<T, Integer> optimize() {
        return new a(null);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(@NonNull Object obj, @NonNull Integer num) {
        set((IntProperty<T>) obj, num);
    }

    public abstract void setValue(@NonNull T t, int i);

    @Override // android.util.Property
    @NonNull
    /* renamed from: get */
    public Integer mo239get(T t) {
        return 0;
    }

    public final void set(@NonNull T t, @NonNull Integer num) {
        setValue(t, num.intValue());
    }
}
