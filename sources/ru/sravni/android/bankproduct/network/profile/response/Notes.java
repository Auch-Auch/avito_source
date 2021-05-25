package ru.sravni.android.bankproduct.network.profile.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.repository.profile.entity.ProfileNoteRepo;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\t\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\b¨\u0006\u001a"}, d2 = {"Lru/sravni/android/bankproduct/network/profile/response/Notes;", "", "", "Lru/sravni/android/bankproduct/repository/profile/entity/ProfileNoteRepo;", "toNotesListRepo", "()Ljava/util/List;", "Lru/sravni/android/bankproduct/network/profile/response/Work;", "component1", "()Lru/sravni/android/bankproduct/network/profile/response/Work;", "work", "copy", "(Lru/sravni/android/bankproduct/network/profile/response/Work;)Lru/sravni/android/bankproduct/network/profile/response/Notes;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lru/sravni/android/bankproduct/network/profile/response/Work;", "getWork", "<init>", "(Lru/sravni/android/bankproduct/network/profile/response/Work;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class Notes {
    @SerializedName("work")
    @NotNull
    private final Work work;

    public Notes(@NotNull Work work2) {
        Intrinsics.checkParameterIsNotNull(work2, "work");
        this.work = work2;
    }

    public static /* synthetic */ Notes copy$default(Notes notes, Work work2, int i, Object obj) {
        if ((i & 1) != 0) {
            work2 = notes.work;
        }
        return notes.copy(work2);
    }

    @NotNull
    public final Work component1() {
        return this.work;
    }

    @NotNull
    public final Notes copy(@NotNull Work work2) {
        Intrinsics.checkParameterIsNotNull(work2, "work");
        return new Notes(work2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof Notes) && Intrinsics.areEqual(this.work, ((Notes) obj).work);
        }
        return true;
    }

    @NotNull
    public final Work getWork() {
        return this.work;
    }

    public int hashCode() {
        Work work2 = this.work;
        if (work2 != null) {
            return work2.hashCode();
        }
        return 0;
    }

    @NotNull
    public final List<ProfileNoteRepo> toNotesListRepo() {
        return d.listOf(this.work.toProfileNoteRepo());
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Notes(work=");
        L.append(this.work);
        L.append(")");
        return L.toString();
    }
}
