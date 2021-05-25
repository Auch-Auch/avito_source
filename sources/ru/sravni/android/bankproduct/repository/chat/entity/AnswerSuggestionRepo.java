package ru.sravni.android.bankproduct.repository.chat.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerSuggestionDomain;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b&\u0010'J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u001e\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJH\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\b\b\u0002\u0010\u0012\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR'\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\u0012\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\u0007¨\u0006("}, d2 = {"Lru/sravni/android/bankproduct/repository/chat/entity/AnswerSuggestionRepo;", "", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerSuggestionDomain;", "toAnswerSuggestionDomain", "()Lru/sravni/android/bankproduct/domain/chat/entity/AnswerSuggestionDomain;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/util/Map;", "", "component4", "()Z", "suggestion", "extraSuggestion", "optionalFields", "isComplete", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Z)Lru/sravni/android/bankproduct/repository/chat/entity/AnswerSuggestionRepo;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/util/Map;", "getOptionalFields", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getSuggestion", "d", "Z", AuthSource.BOOKING_ORDER, "getExtraSuggestion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Z)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class AnswerSuggestionRepo {
    @NotNull
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final Map<String, String> c;
    public final boolean d;

    public AnswerSuggestionRepo(@NotNull String str, @Nullable String str2, @Nullable Map<String, String> map, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "suggestion");
        this.a = str;
        this.b = str2;
        this.c = map;
        this.d = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.repository.chat.entity.AnswerSuggestionRepo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnswerSuggestionRepo copy$default(AnswerSuggestionRepo answerSuggestionRepo, String str, String str2, Map map, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = answerSuggestionRepo.a;
        }
        if ((i & 2) != 0) {
            str2 = answerSuggestionRepo.b;
        }
        if ((i & 4) != 0) {
            map = answerSuggestionRepo.c;
        }
        if ((i & 8) != 0) {
            z = answerSuggestionRepo.d;
        }
        return answerSuggestionRepo.copy(str, str2, map, z);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final Map<String, String> component3() {
        return this.c;
    }

    public final boolean component4() {
        return this.d;
    }

    @NotNull
    public final AnswerSuggestionRepo copy(@NotNull String str, @Nullable String str2, @Nullable Map<String, String> map, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "suggestion");
        return new AnswerSuggestionRepo(str, str2, map, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnswerSuggestionRepo)) {
            return false;
        }
        AnswerSuggestionRepo answerSuggestionRepo = (AnswerSuggestionRepo) obj;
        return Intrinsics.areEqual(this.a, answerSuggestionRepo.a) && Intrinsics.areEqual(this.b, answerSuggestionRepo.b) && Intrinsics.areEqual(this.c, answerSuggestionRepo.c) && this.d == answerSuggestionRepo.d;
    }

    @Nullable
    public final String getExtraSuggestion() {
        return this.b;
    }

    @Nullable
    public final Map<String, String> getOptionalFields() {
        return this.c;
    }

    @NotNull
    public final String getSuggestion() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Map<String, String> map = this.c;
        if (map != null) {
            i = map.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.d;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    public final boolean isComplete() {
        return this.d;
    }

    @NotNull
    public final AnswerSuggestionDomain toAnswerSuggestionDomain() {
        return new AnswerSuggestionDomain(this.a, this.b, this.c, this.d);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("AnswerSuggestionRepo(suggestion=");
        L.append(this.a);
        L.append(", extraSuggestion=");
        L.append(this.b);
        L.append(", optionalFields=");
        L.append(this.c);
        L.append(", isComplete=");
        return a.B(L, this.d, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AnswerSuggestionRepo(String str, String str2, Map map, boolean z, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : map, z);
    }
}
