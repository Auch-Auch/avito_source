package org.kodein.di;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001eBC\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R(\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR(\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR$\u0010\u001b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lorg/kodein/di/SearchSpecs;", "", "", "toString", "()Ljava/lang/String;", "Lorg/kodein/di/TypeToken;", AuthSource.BOOKING_ORDER, "Lorg/kodein/di/TypeToken;", "getArgType", "()Lorg/kodein/di/TypeToken;", "setArgType", "(Lorg/kodein/di/TypeToken;)V", "argType", "c", "getType", "setType", "type", AuthSource.SEND_ABUSE, "getContextType", "setContextType", "contextType", "d", "Ljava/lang/Object;", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "tag", "<init>", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;)V", "NoDefinedTag", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public class SearchSpecs {
    @Nullable
    public TypeToken<?> a;
    @Nullable
    public TypeToken<?> b;
    @Nullable
    public TypeToken<?> c;
    @Nullable
    public Object d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lorg/kodein/di/SearchSpecs$NoDefinedTag;", "", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class NoDefinedTag {
        public static final NoDefinedTag INSTANCE = new NoDefinedTag();
    }

    public SearchSpecs() {
        this(null, null, null, null, 15, null);
    }

    public SearchSpecs(@Nullable TypeToken<?> typeToken, @Nullable TypeToken<?> typeToken2, @Nullable TypeToken<?> typeToken3, @Nullable Object obj) {
        this.a = typeToken;
        this.b = typeToken2;
        this.c = typeToken3;
        this.d = obj;
    }

    @Nullable
    public final TypeToken<?> getArgType() {
        return this.b;
    }

    @Nullable
    public final TypeToken<?> getContextType() {
        return this.a;
    }

    @Nullable
    public final Object getTag() {
        return this.d;
    }

    @Nullable
    public final TypeToken<?> getType() {
        return this.c;
    }

    public final void setArgType(@Nullable TypeToken<?> typeToken) {
        this.b = typeToken;
    }

    public final void setContextType(@Nullable TypeToken<?> typeToken) {
        this.a = typeToken;
    }

    public final void setTag(@Nullable Object obj) {
        this.d = obj;
    }

    public final void setType(@Nullable TypeToken<?> typeToken) {
        this.c = typeToken;
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList();
        String str = null;
        if (this.a != null) {
            StringBuilder L = a.L("contextType=");
            TypeToken<?> typeToken = this.a;
            L.append(typeToken != null ? typeToken.simpleDispString() : null);
            arrayList.add(L.toString());
        }
        if (this.b != null) {
            StringBuilder L2 = a.L("argType=");
            TypeToken<?> typeToken2 = this.b;
            L2.append(typeToken2 != null ? typeToken2.simpleDispString() : null);
            arrayList.add(L2.toString());
        }
        if (this.c != null) {
            StringBuilder L3 = a.L("type=");
            TypeToken<?> typeToken3 = this.c;
            if (typeToken3 != null) {
                str = typeToken3.simpleDispString();
            }
            L3.append(str);
            arrayList.add(L3.toString());
        }
        if (!Intrinsics.areEqual(this.d, NoDefinedTag.INSTANCE)) {
            StringBuilder L4 = a.L("tag=");
            L4.append(this.d);
            arrayList.add(L4.toString());
        }
        return a.s(a.I('['), CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null), ']');
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchSpecs(TypeToken typeToken, TypeToken typeToken2, TypeToken typeToken3, Object obj, int i, j jVar) {
        this((i & 1) != 0 ? null : typeToken, (i & 2) != 0 ? null : typeToken2, (i & 4) != 0 ? null : typeToken3, (i & 8) != 0 ? NoDefinedTag.INSTANCE : obj);
    }
}
