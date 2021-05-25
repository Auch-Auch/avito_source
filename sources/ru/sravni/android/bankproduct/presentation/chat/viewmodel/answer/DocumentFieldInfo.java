package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJB\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\fR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001c\u001a\u0004\b$\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b\u000f\u0010\b¨\u0006)"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/DocumentFieldInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "component4", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/DocumentFieldInfoEnum;", "component5", "()Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/DocumentFieldInfoEnum;", "data", "mask", "isComplete", "key", "type", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/DocumentFieldInfoEnum;)Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/DocumentFieldInfo;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/lang/String;", "getKey", AuthSource.BOOKING_ORDER, "getMask", "e", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/DocumentFieldInfoEnum;", "getType", AuthSource.SEND_ABUSE, "getData", "c", "Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/DocumentFieldInfoEnum;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class DocumentFieldInfo {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    public final boolean c;
    @NotNull
    public final String d;
    @NotNull
    public final DocumentFieldInfoEnum e;

    public DocumentFieldInfo(@NotNull String str, @NotNull String str2, boolean z, @NotNull String str3, @NotNull DocumentFieldInfoEnum documentFieldInfoEnum) {
        Intrinsics.checkParameterIsNotNull(str, "data");
        Intrinsics.checkParameterIsNotNull(str2, "mask");
        Intrinsics.checkParameterIsNotNull(str3, "key");
        Intrinsics.checkParameterIsNotNull(documentFieldInfoEnum, "type");
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = str3;
        this.e = documentFieldInfoEnum;
    }

    public static /* synthetic */ DocumentFieldInfo copy$default(DocumentFieldInfo documentFieldInfo, String str, String str2, boolean z, String str3, DocumentFieldInfoEnum documentFieldInfoEnum, int i, Object obj) {
        if ((i & 1) != 0) {
            str = documentFieldInfo.a;
        }
        if ((i & 2) != 0) {
            str2 = documentFieldInfo.b;
        }
        if ((i & 4) != 0) {
            z = documentFieldInfo.c;
        }
        if ((i & 8) != 0) {
            str3 = documentFieldInfo.d;
        }
        if ((i & 16) != 0) {
            documentFieldInfoEnum = documentFieldInfo.e;
        }
        return documentFieldInfo.copy(str, str2, z, str3, documentFieldInfoEnum);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    public final boolean component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    @NotNull
    public final DocumentFieldInfoEnum component5() {
        return this.e;
    }

    @NotNull
    public final DocumentFieldInfo copy(@NotNull String str, @NotNull String str2, boolean z, @NotNull String str3, @NotNull DocumentFieldInfoEnum documentFieldInfoEnum) {
        Intrinsics.checkParameterIsNotNull(str, "data");
        Intrinsics.checkParameterIsNotNull(str2, "mask");
        Intrinsics.checkParameterIsNotNull(str3, "key");
        Intrinsics.checkParameterIsNotNull(documentFieldInfoEnum, "type");
        return new DocumentFieldInfo(str, str2, z, str3, documentFieldInfoEnum);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DocumentFieldInfo)) {
            return false;
        }
        DocumentFieldInfo documentFieldInfo = (DocumentFieldInfo) obj;
        return Intrinsics.areEqual(this.a, documentFieldInfo.a) && Intrinsics.areEqual(this.b, documentFieldInfo.b) && this.c == documentFieldInfo.c && Intrinsics.areEqual(this.d, documentFieldInfo.d) && Intrinsics.areEqual(this.e, documentFieldInfo.e);
    }

    @NotNull
    public final String getData() {
        return this.a;
    }

    @NotNull
    public final String getKey() {
        return this.d;
    }

    @NotNull
    public final String getMask() {
        return this.b;
    }

    @NotNull
    public final DocumentFieldInfoEnum getType() {
        return this.e;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.c;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode2 + i2) * 31;
        String str3 = this.d;
        int hashCode3 = (i5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        DocumentFieldInfoEnum documentFieldInfoEnum = this.e;
        if (documentFieldInfoEnum != null) {
            i = documentFieldInfoEnum.hashCode();
        }
        return hashCode3 + i;
    }

    public final boolean isComplete() {
        return this.c;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("DocumentFieldInfo(data=");
        L.append(this.a);
        L.append(", mask=");
        L.append(this.b);
        L.append(", isComplete=");
        L.append(this.c);
        L.append(", key=");
        L.append(this.d);
        L.append(", type=");
        L.append(this.e);
        L.append(")");
        return L.toString();
    }
}
