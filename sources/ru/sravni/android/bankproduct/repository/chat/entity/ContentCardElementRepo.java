package ru.sravni.android.bankproduct.repository.chat.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJZ\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00072\b\b\u0002\u0010\u0014\u001a\u00020\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u000fR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0004R!\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\tR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010$\u001a\u0004\b,\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\f¨\u00062"}, d2 = {"Lru/sravni/android/bankproduct/repository/chat/entity/ContentCardElementRepo;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Ljava/util/List;", "Lru/sravni/android/bankproduct/repository/chat/entity/ContentElementParameterRepo;", "component5", "()Lru/sravni/android/bankproduct/repository/chat/entity/ContentElementParameterRepo;", "Lru/sravni/android/bankproduct/repository/chat/entity/ContentElementValidateRepo;", "component6", "()Lru/sravni/android/bankproduct/repository/chat/entity/ContentElementValidateRepo;", "name", "text", "type", MessengerShareContentUtility.ELEMENTS, "params", "validate", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lru/sravni/android/bankproduct/repository/chat/entity/ContentElementParameterRepo;Lru/sravni/android/bankproduct/repository/chat/entity/ContentElementValidateRepo;)Lru/sravni/android/bankproduct/repository/chat/entity/ContentCardElementRepo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "f", "Lru/sravni/android/bankproduct/repository/chat/entity/ContentElementValidateRepo;", "getValidate", "c", "Ljava/lang/String;", "getType", "d", "Ljava/util/List;", "getElements", AuthSource.SEND_ABUSE, "getName", AuthSource.BOOKING_ORDER, "getText", "e", "Lru/sravni/android/bankproduct/repository/chat/entity/ContentElementParameterRepo;", "getParams", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lru/sravni/android/bankproduct/repository/chat/entity/ContentElementParameterRepo;Lru/sravni/android/bankproduct/repository/chat/entity/ContentElementValidateRepo;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ContentCardElementRepo {
    @NotNull
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final List<ContentCardElementRepo> d;
    @NotNull
    public final ContentElementParameterRepo e;
    @Nullable
    public final ContentElementValidateRepo f;

    public ContentCardElementRepo(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable List<ContentCardElementRepo> list, @NotNull ContentElementParameterRepo contentElementParameterRepo, @Nullable ContentElementValidateRepo contentElementValidateRepo) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(contentElementParameterRepo, "params");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = list;
        this.e = contentElementParameterRepo;
        this.f = contentElementValidateRepo;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: ru.sravni.android.bankproduct.repository.chat.entity.ContentCardElementRepo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ContentCardElementRepo copy$default(ContentCardElementRepo contentCardElementRepo, String str, String str2, String str3, List list, ContentElementParameterRepo contentElementParameterRepo, ContentElementValidateRepo contentElementValidateRepo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = contentCardElementRepo.a;
        }
        if ((i & 2) != 0) {
            str2 = contentCardElementRepo.b;
        }
        if ((i & 4) != 0) {
            str3 = contentCardElementRepo.c;
        }
        if ((i & 8) != 0) {
            list = contentCardElementRepo.d;
        }
        if ((i & 16) != 0) {
            contentElementParameterRepo = contentCardElementRepo.e;
        }
        if ((i & 32) != 0) {
            contentElementValidateRepo = contentCardElementRepo.f;
        }
        return contentCardElementRepo.copy(str, str2, str3, list, contentElementParameterRepo, contentElementValidateRepo);
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
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final List<ContentCardElementRepo> component4() {
        return this.d;
    }

    @NotNull
    public final ContentElementParameterRepo component5() {
        return this.e;
    }

    @Nullable
    public final ContentElementValidateRepo component6() {
        return this.f;
    }

    @NotNull
    public final ContentCardElementRepo copy(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable List<ContentCardElementRepo> list, @NotNull ContentElementParameterRepo contentElementParameterRepo, @Nullable ContentElementValidateRepo contentElementValidateRepo) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(contentElementParameterRepo, "params");
        return new ContentCardElementRepo(str, str2, str3, list, contentElementParameterRepo, contentElementValidateRepo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContentCardElementRepo)) {
            return false;
        }
        ContentCardElementRepo contentCardElementRepo = (ContentCardElementRepo) obj;
        return Intrinsics.areEqual(this.a, contentCardElementRepo.a) && Intrinsics.areEqual(this.b, contentCardElementRepo.b) && Intrinsics.areEqual(this.c, contentCardElementRepo.c) && Intrinsics.areEqual(this.d, contentCardElementRepo.d) && Intrinsics.areEqual(this.e, contentCardElementRepo.e) && Intrinsics.areEqual(this.f, contentCardElementRepo.f);
    }

    @Nullable
    public final List<ContentCardElementRepo> getElements() {
        return this.d;
    }

    @NotNull
    public final String getName() {
        return this.a;
    }

    @NotNull
    public final ContentElementParameterRepo getParams() {
        return this.e;
    }

    @Nullable
    public final String getText() {
        return this.b;
    }

    @Nullable
    public final String getType() {
        return this.c;
    }

    @Nullable
    public final ContentElementValidateRepo getValidate() {
        return this.f;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<ContentCardElementRepo> list = this.d;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        ContentElementParameterRepo contentElementParameterRepo = this.e;
        int hashCode5 = (hashCode4 + (contentElementParameterRepo != null ? contentElementParameterRepo.hashCode() : 0)) * 31;
        ContentElementValidateRepo contentElementValidateRepo = this.f;
        if (contentElementValidateRepo != null) {
            i = contentElementValidateRepo.hashCode();
        }
        return hashCode5 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ContentCardElementRepo(name=");
        L.append(this.a);
        L.append(", text=");
        L.append(this.b);
        L.append(", type=");
        L.append(this.c);
        L.append(", elements=");
        L.append(this.d);
        L.append(", params=");
        L.append(this.e);
        L.append(", validate=");
        L.append(this.f);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ContentCardElementRepo(String str, String str2, String str3, List list, ContentElementParameterRepo contentElementParameterRepo, ContentElementValidateRepo contentElementValidateRepo, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : list, (i & 16) != 0 ? new ContentElementParameterRepo(null, null, null, null, null, null, 63, null) : contentElementParameterRepo, (i & 32) == 0 ? contentElementValidateRepo : null);
    }
}
