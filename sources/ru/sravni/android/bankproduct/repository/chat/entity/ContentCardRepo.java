package ru.sravni.android.bankproduct.repository.chat.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B)\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J2\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R!\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0019\u0010\u0005¨\u0006\u001c"}, d2 = {"Lru/sravni/android/bankproduct/repository/chat/entity/ContentCardRepo;", "", "", "", "component1", "()Ljava/util/List;", "Lru/sravni/android/bankproduct/repository/chat/entity/ContentCardElementRepo;", "component2", "modifiers", "contentElements", "copy", "(Ljava/util/List;Ljava/util/List;)Lru/sravni/android/bankproduct/repository/chat/entity/ContentCardRepo;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getContentElements", AuthSource.SEND_ABUSE, "getModifiers", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ContentCardRepo {
    @NotNull
    public final List<String> a;
    @Nullable
    public final List<ContentCardElementRepo> b;

    public ContentCardRepo() {
        this(null, null, 3, null);
    }

    public ContentCardRepo(@NotNull List<String> list, @Nullable List<ContentCardElementRepo> list2) {
        Intrinsics.checkParameterIsNotNull(list, "modifiers");
        this.a = list;
        this.b = list2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.repository.chat.entity.ContentCardRepo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ContentCardRepo copy$default(ContentCardRepo contentCardRepo, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = contentCardRepo.a;
        }
        if ((i & 2) != 0) {
            list2 = contentCardRepo.b;
        }
        return contentCardRepo.copy(list, list2);
    }

    @NotNull
    public final List<String> component1() {
        return this.a;
    }

    @Nullable
    public final List<ContentCardElementRepo> component2() {
        return this.b;
    }

    @NotNull
    public final ContentCardRepo copy(@NotNull List<String> list, @Nullable List<ContentCardElementRepo> list2) {
        Intrinsics.checkParameterIsNotNull(list, "modifiers");
        return new ContentCardRepo(list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContentCardRepo)) {
            return false;
        }
        ContentCardRepo contentCardRepo = (ContentCardRepo) obj;
        return Intrinsics.areEqual(this.a, contentCardRepo.a) && Intrinsics.areEqual(this.b, contentCardRepo.b);
    }

    @Nullable
    public final List<ContentCardElementRepo> getContentElements() {
        return this.b;
    }

    @NotNull
    public final List<String> getModifiers() {
        return this.a;
    }

    public int hashCode() {
        List<String> list = this.a;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<ContentCardElementRepo> list2 = this.b;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ContentCardRepo(modifiers=");
        L.append(this.a);
        L.append(", contentElements=");
        return a.w(L, this.b, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ContentCardRepo(List list, List list2, int i, j jVar) {
        this((i & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : list2);
    }
}
