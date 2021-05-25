package com.avito.android.messenger.map.viewing.view;

import a2.b.a.a.a;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.clustering.AbstractClusterItem;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004JE\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00022\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\f8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\r\u0010\u001cR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004¨\u0006$"}, d2 = {"Lcom/avito/android/messenger/map/viewing/view/Pin;", "Lcom/avito/android/avito_map/clustering/AbstractClusterItem;", "", "toString", "()Ljava/lang/String;", "id", "Lcom/avito/android/avito_map/AvitoMapPoint;", VKApiConst.POSITION, "title", "", "", "description", "", "isSelected", "copy", "(Ljava/lang/String;Lcom/avito/android/avito_map/AvitoMapPoint;Ljava/lang/String;Ljava/util/List;Z)Lcom/avito/android/messenger/map/viewing/view/Pin;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "e", "Ljava/util/List;", "getDescription", "()Ljava/util/List;", "isNotSelected", "()Z", "f", "Z", "d", "Ljava/lang/String;", "getId", "<init>", "(Ljava/lang/String;Lcom/avito/android/avito_map/AvitoMapPoint;Ljava/lang/String;Ljava/util/List;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class Pin extends AbstractClusterItem {
    @NotNull
    public final String d;
    @NotNull
    public final List<CharSequence> e;
    public final boolean f;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Pin(String str, AvitoMapPoint avitoMapPoint, String str2, List list, boolean z, int i, j jVar) {
        this((i & 1) != 0 ? a.I2("UUID.randomUUID().toString()") : str, avitoMapPoint, str2, list, z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.messenger.map.viewing.view.Pin */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Pin copy$default(Pin pin, String str, AvitoMapPoint avitoMapPoint, String str2, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pin.d;
        }
        if ((i & 2) != 0) {
            avitoMapPoint = pin.getPosition();
        }
        if ((i & 4) != 0) {
            str2 = pin.getTitle();
        }
        if ((i & 8) != 0) {
            list = pin.e;
        }
        if ((i & 16) != 0) {
            z = pin.f;
        }
        return pin.copy(str, avitoMapPoint, str2, list, z);
    }

    @NotNull
    public final Pin copy(@NotNull String str, @NotNull AvitoMapPoint avitoMapPoint, @NotNull String str2, @NotNull List<? extends CharSequence> list, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(avitoMapPoint, VKApiConst.POSITION);
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(list, "description");
        return new Pin(str, avitoMapPoint, str2, list, z);
    }

    @Override // com.avito.android.avito_map.clustering.AbstractClusterItem
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pin) || !super.equals(obj)) {
            return false;
        }
        Pin pin = (Pin) obj;
        return !(Intrinsics.areEqual(this.d, pin.d) ^ true) && this.f == pin.f;
    }

    @NotNull
    public final List<CharSequence> getDescription() {
        return this.e;
    }

    @NotNull
    public final String getId() {
        return this.d;
    }

    @Override // com.avito.android.avito_map.clustering.AbstractClusterItem
    public int hashCode() {
        return a.a(this.f) + a.B0(this.d, super.hashCode() * 31, 31);
    }

    public final boolean isNotSelected() {
        return !isSelected();
    }

    public final boolean isSelected() {
        return this.f;
    }

    @Override // com.avito.android.avito_map.clustering.AbstractClusterItem
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Pin(\n\t id=");
        L.append(this.d);
        L.append(",\n\t position=");
        L.append(getPosition());
        L.append(",\n\t title=");
        L.append(getTitle());
        L.append(",\n\t snippet=");
        L.append(getSnippet());
        L.append(",\n\t isSelected=");
        return a.B(L, this.f, "\n)");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.util.List<? extends java.lang.CharSequence> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Pin(@org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull com.avito.android.avito_map.AvitoMapPoint r7, @org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull java.util.List<? extends java.lang.CharSequence> r9, boolean r10) {
        /*
            r5 = this;
            java.lang.String r0 = "id"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "position"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "description"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            boolean r0 = r9.isEmpty()
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x005d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r9.size()
            int r1 = r1 * 2
            int r1 = r1 + -1
            r0.<init>(r1)
            r1 = 0
            java.util.Iterator r2 = r9.iterator()
        L_0x002e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0053
            java.lang.Object r3 = r2.next()
            int r4 = r1 + 1
            if (r1 >= 0) goto L_0x003f
            kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow()
        L_0x003f:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.append(r3)
            int r3 = r9.size()
            int r3 = r3 + -1
            if (r1 >= r3) goto L_0x0051
            java.lang.String r1 = "\n"
            r0.append(r1)
        L_0x0051:
            r1 = r4
            goto L_0x002e
        L_0x0053:
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "sb.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            goto L_0x005f
        L_0x005d:
            java.lang.String r0 = ""
        L_0x005f:
            r5.<init>(r7, r8, r0)
            r5.d = r6
            r5.e = r9
            r5.f = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.map.viewing.view.Pin.<init>(java.lang.String, com.avito.android.avito_map.AvitoMapPoint, java.lang.String, java.util.List, boolean):void");
    }
}
