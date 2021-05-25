package ru.sravni.android.bankproduct.network.profile.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.repository.profile.entity.ProfileRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b#\u0010$J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ.\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\rR\u001c\u0010\u000e\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\u0007R\u001c\u0010\u000f\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010\n¨\u0006%"}, d2 = {"Lru/sravni/android/bankproduct/network/profile/response/AccountResponse;", "", "Lru/sravni/android/bankproduct/repository/profile/entity/ProfileRepo;", "toProfileRepo", "()Lru/sravni/android/bankproduct/repository/profile/entity/ProfileRepo;", "Lru/sravni/android/bankproduct/network/profile/response/Common;", "component1", "()Lru/sravni/android/bankproduct/network/profile/response/Common;", "Lru/sravni/android/bankproduct/network/profile/response/Documents;", "component2", "()Lru/sravni/android/bankproduct/network/profile/response/Documents;", "Lru/sravni/android/bankproduct/network/profile/response/Notes;", "component3", "()Lru/sravni/android/bankproduct/network/profile/response/Notes;", "common", "documents", "notes", "copy", "(Lru/sravni/android/bankproduct/network/profile/response/Common;Lru/sravni/android/bankproduct/network/profile/response/Documents;Lru/sravni/android/bankproduct/network/profile/response/Notes;)Lru/sravni/android/bankproduct/network/profile/response/AccountResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lru/sravni/android/bankproduct/network/profile/response/Notes;", "getNotes", "Lru/sravni/android/bankproduct/network/profile/response/Common;", "getCommon", "Lru/sravni/android/bankproduct/network/profile/response/Documents;", "getDocuments", "<init>", "(Lru/sravni/android/bankproduct/network/profile/response/Common;Lru/sravni/android/bankproduct/network/profile/response/Documents;Lru/sravni/android/bankproduct/network/profile/response/Notes;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class AccountResponse {
    @SerializedName("common")
    @NotNull
    private final Common common;
    @SerializedName("documents")
    @NotNull
    private final Documents documents;
    @SerializedName("notes")
    @NotNull
    private final Notes notes;

    public AccountResponse(@NotNull Common common2, @NotNull Documents documents2, @NotNull Notes notes2) {
        Intrinsics.checkParameterIsNotNull(common2, "common");
        Intrinsics.checkParameterIsNotNull(documents2, "documents");
        Intrinsics.checkParameterIsNotNull(notes2, "notes");
        this.common = common2;
        this.documents = documents2;
        this.notes = notes2;
    }

    public static /* synthetic */ AccountResponse copy$default(AccountResponse accountResponse, Common common2, Documents documents2, Notes notes2, int i, Object obj) {
        if ((i & 1) != 0) {
            common2 = accountResponse.common;
        }
        if ((i & 2) != 0) {
            documents2 = accountResponse.documents;
        }
        if ((i & 4) != 0) {
            notes2 = accountResponse.notes;
        }
        return accountResponse.copy(common2, documents2, notes2);
    }

    @NotNull
    public final Common component1() {
        return this.common;
    }

    @NotNull
    public final Documents component2() {
        return this.documents;
    }

    @NotNull
    public final Notes component3() {
        return this.notes;
    }

    @NotNull
    public final AccountResponse copy(@NotNull Common common2, @NotNull Documents documents2, @NotNull Notes notes2) {
        Intrinsics.checkParameterIsNotNull(common2, "common");
        Intrinsics.checkParameterIsNotNull(documents2, "documents");
        Intrinsics.checkParameterIsNotNull(notes2, "notes");
        return new AccountResponse(common2, documents2, notes2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountResponse)) {
            return false;
        }
        AccountResponse accountResponse = (AccountResponse) obj;
        return Intrinsics.areEqual(this.common, accountResponse.common) && Intrinsics.areEqual(this.documents, accountResponse.documents) && Intrinsics.areEqual(this.notes, accountResponse.notes);
    }

    @NotNull
    public final Common getCommon() {
        return this.common;
    }

    @NotNull
    public final Documents getDocuments() {
        return this.documents;
    }

    @NotNull
    public final Notes getNotes() {
        return this.notes;
    }

    public int hashCode() {
        Common common2 = this.common;
        int i = 0;
        int hashCode = (common2 != null ? common2.hashCode() : 0) * 31;
        Documents documents2 = this.documents;
        int hashCode2 = (hashCode + (documents2 != null ? documents2.hashCode() : 0)) * 31;
        Notes notes2 = this.notes;
        if (notes2 != null) {
            i = notes2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public final ProfileRepo toProfileRepo() {
        return new ProfileRepo(this.common.toProfileCommonRepo(), this.documents.toDocListRepo(), this.notes.toNotesListRepo());
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("AccountResponse(common=");
        L.append(this.common);
        L.append(", documents=");
        L.append(this.documents);
        L.append(", notes=");
        L.append(this.notes);
        L.append(")");
        return L.toString();
    }
}
