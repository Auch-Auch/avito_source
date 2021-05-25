package com.avito.android.toggle;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.feature.OptionSet;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b \u0010!J\u0010\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR*\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u00008V@WX\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0011\u0010\u0005\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00028\u00008V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005R\u0016\u0010\u001c\u001a\u00020\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\bR\u0016\u0010\u001e\u001a\u00020\u001d8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/avito/android/toggle/PrefsFeature;", "T", "Lcom/avito/android/toggle/MutableFeature;", "Lcom/avito/android/toggle/Feature;", "invoke", "()Ljava/lang/Object;", "", "getApiToggleId", "()Ljava/lang/String;", "apiToggleId", "Landroid/content/SharedPreferences;", AuthSource.BOOKING_ORDER, "Landroid/content/SharedPreferences;", "preferences", "getDescription", "description", "value", "getValue", "setValue", "(Ljava/lang/Object;)V", "getValue$annotations", "()V", AuthSource.SEND_ABUSE, "Lcom/avito/android/toggle/Feature;", "delegate", "getOriginalValue", "originalValue", "getKey", "key", "", "isRemote", "()Z", "<init>", "(Lcom/avito/android/toggle/Feature;Landroid/content/SharedPreferences;)V", "features_release"}, k = 1, mv = {1, 4, 2})
public class PrefsFeature<T> implements MutableFeature<T>, Feature<T> {
    public final Feature<T> a;
    public final SharedPreferences b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.android.toggle.Feature<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public PrefsFeature(@NotNull Feature<? extends T> feature, @NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(feature, "delegate");
        Intrinsics.checkNotNullParameter(sharedPreferences, "preferences");
        this.a = feature;
        this.b = sharedPreferences;
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    @Override // com.avito.android.toggle.Feature
    @Nullable
    public String getApiToggleId() {
        return this.a.getApiToggleId();
    }

    @Override // com.avito.android.toggle.Feature
    @NotNull
    public String getDescription() {
        return this.a.getDescription();
    }

    @Override // com.avito.android.toggle.Feature
    @NotNull
    public String getKey() {
        return this.a.getKey();
    }

    @Override // com.avito.android.toggle.Feature
    public T getOriginalValue() {
        return this.a.getValue();
    }

    @Override // com.avito.android.toggle.MutableFeature, com.avito.android.toggle.Feature
    public T getValue() {
        if (getOriginalValue() instanceof OptionSet) {
            SharedPreferences sharedPreferences = this.b;
            String key = getKey();
            T originalValue = getOriginalValue();
            Objects.requireNonNull(originalValue, "null cannot be cast to non-null type com.avito.android.util.feature.OptionSet");
            return (T) PrefsFeatureKt.access$getOptionSet(sharedPreferences, key, originalValue);
        }
        T t = (T) this.b.getAll().get(getKey());
        return t != null ? t : getOriginalValue();
    }

    @Override // com.avito.android.toggle.Feature
    public T invoke() {
        return getValue();
    }

    @Override // com.avito.android.toggle.Feature
    public boolean isRemote() {
        return this.a.isRemote();
    }

    @Override // com.avito.android.toggle.MutableFeature
    @SuppressLint({"CommitPrefEdits"})
    public void setValue(T t) {
        SharedPreferences.Editor edit = this.b.edit();
        if (t instanceof Integer) {
            edit.putInt(getKey(), t.intValue());
        } else if (t instanceof Long) {
            edit.putLong(getKey(), t.longValue());
        } else if (t instanceof Float) {
            edit.putFloat(getKey(), t.floatValue());
        } else if (t instanceof String) {
            edit.putString(getKey(), t);
        } else if (t instanceof Boolean) {
            edit.putBoolean(getKey(), t.booleanValue());
        } else if (t instanceof OptionSet) {
            PrefsFeatureKt.access$putOptionSet(edit, getKey(), t);
        }
        edit.commit();
    }
}
