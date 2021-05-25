package com.avito.android.db;

import android.content.ContentValues;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J&\u0010\u0007\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\b\u0010\t\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/db/ContentValuePropertyDelegate;", "T", "Lkotlin/properties/ReadWriteProperty;", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", "getValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "value", "", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "Landroid/content/ContentValues;", AuthSource.SEND_ABUSE, "Landroid/content/ContentValues;", ResidentialComplexModuleKt.VALUES, "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "key", "<init>", "(Landroid/content/ContentValues;Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class ContentValuePropertyDelegate<T> implements ReadWriteProperty<Object, T> {
    public final ContentValues a;
    public final String b;

    public ContentValuePropertyDelegate(@NotNull ContentValues contentValues, @NotNull String str) {
        Intrinsics.checkNotNullParameter(contentValues, ResidentialComplexModuleKt.VALUES);
        Intrinsics.checkNotNullParameter(str, "key");
        this.a = contentValues;
        this.b = str;
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    @Nullable
    public T getValue(@NotNull Object obj, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(obj, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        T t = (T) this.a.get(this.b);
        if (!(t instanceof Object)) {
            return null;
        }
        return t;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(@NotNull Object obj, @NotNull KProperty<?> kProperty, @Nullable T t) {
        Intrinsics.checkNotNullParameter(obj, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        if (t == null) {
            this.a.putNull(this.b);
        } else if (t instanceof String) {
            this.a.put(this.b, (String) t);
        } else if (t instanceof Long) {
            this.a.put(this.b, (Long) t);
        } else if (t instanceof Integer) {
            this.a.put(this.b, (Integer) t);
        } else if (t instanceof Boolean) {
            this.a.put(this.b, (Boolean) t);
        } else if (t instanceof byte[]) {
            this.a.put(this.b, (byte[]) t);
        } else if (t instanceof Double) {
            this.a.put(this.b, (Double) t);
        } else if (t instanceof Float) {
            this.a.put(this.b, (Float) t);
        } else if (t instanceof Short) {
            this.a.put(this.b, (Short) t);
        } else if (t instanceof Byte) {
            this.a.put(this.b, (Byte) t);
        } else {
            throw new IllegalArgumentException("ContentValue doesn't support the value " + ((Object) t) + " (property " + kProperty.getName());
        }
    }
}
