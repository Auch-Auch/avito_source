package com.avito.android.toggle;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.toggle.Feature;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B3\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00028\u0000\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u001aR\u001e\u0010\b\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u0013\u001a\u00028\u00008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\u00020\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/avito/android/toggle/ImmutableFeature;", "T", "Lcom/avito/android/toggle/Feature;", "", "d", "Ljava/lang/String;", "getApiToggleId", "()Ljava/lang/String;", "apiToggleId", AuthSource.SEND_ABUSE, "getDescription", "description", "c", "getKey", "key", AuthSource.BOOKING_ORDER, "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "value", "", "e", "Z", "isRemote", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Z)V", "features_release"}, k = 1, mv = {1, 4, 2})
public final class ImmutableFeature<T> implements Feature<T> {
    @NotNull
    public final String a;
    public final T b;
    @NotNull
    public final String c;
    @Nullable
    public final String d;
    public final boolean e;

    public ImmutableFeature(@NotNull String str, T t, @NotNull String str2, @Nullable String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "description");
        Intrinsics.checkNotNullParameter(str2, "key");
        this.a = str;
        this.b = t;
        this.c = str2;
        this.d = str3;
        this.e = z;
    }

    @Override // com.avito.android.toggle.Feature
    @Nullable
    public String getApiToggleId() {
        return this.d;
    }

    @Override // com.avito.android.toggle.Feature
    @NotNull
    public String getDescription() {
        return this.a;
    }

    @Override // com.avito.android.toggle.Feature
    @NotNull
    public String getKey() {
        return this.c;
    }

    @Override // com.avito.android.toggle.Feature
    public T getOriginalValue() {
        return (T) Feature.DefaultImpls.getOriginalValue(this);
    }

    @Override // com.avito.android.toggle.Feature
    public T getValue() {
        return this.b;
    }

    @Override // com.avito.android.toggle.Feature
    public T invoke() {
        return (T) Feature.DefaultImpls.invoke(this);
    }

    @Override // com.avito.android.toggle.Feature
    public boolean isRemote() {
        return this.e;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImmutableFeature(String str, Object obj, String str2, String str3, boolean z, int i, j jVar) {
        this(str, obj, str2, (i & 8) != 0 ? null : str3, z);
    }
}
