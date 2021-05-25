package ru.sravni.android.bankproduct.repository.chat.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001BU\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b-\u0010.J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000b\u0010\bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ^\u0010\u0015\u001a\u00020\u00002\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0017\u0010\bJ\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\bR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u000eR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010\bR!\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0005R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010\bR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u001f\u001a\u0004\b,\u0010\b¨\u0006/"}, d2 = {"Lru/sravni/android/bankproduct/repository/chat/entity/ContentElementParameterRepo;", "", "", "Lru/sravni/android/bankproduct/repository/chat/entity/SliderSnapPointRepo;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "", "component6", "()Ljava/lang/Boolean;", "snapPoints", "keyboard", "hint", "suggestMode", "savedSearchID", "showSuggestImmediately", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lru/sravni/android/bankproduct/repository/chat/entity/ContentElementParameterRepo;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getHint", "f", "Ljava/lang/Boolean;", "getShowSuggestImmediately", "d", "getSuggestMode", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getSnapPoints", AuthSource.BOOKING_ORDER, "getKeyboard", "e", "getSavedSearchID", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ContentElementParameterRepo {
    @Nullable
    public final List<SliderSnapPointRepo> a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final Boolean f;

    public ContentElementParameterRepo() {
        this(null, null, null, null, null, null, 63, null);
    }

    public ContentElementParameterRepo(@Nullable List<SliderSnapPointRepo> list, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool) {
        this.a = list;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = bool;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: ru.sravni.android.bankproduct.repository.chat.entity.ContentElementParameterRepo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ContentElementParameterRepo copy$default(ContentElementParameterRepo contentElementParameterRepo, List list, String str, String str2, String str3, String str4, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            list = contentElementParameterRepo.a;
        }
        if ((i & 2) != 0) {
            str = contentElementParameterRepo.b;
        }
        if ((i & 4) != 0) {
            str2 = contentElementParameterRepo.c;
        }
        if ((i & 8) != 0) {
            str3 = contentElementParameterRepo.d;
        }
        if ((i & 16) != 0) {
            str4 = contentElementParameterRepo.e;
        }
        if ((i & 32) != 0) {
            bool = contentElementParameterRepo.f;
        }
        return contentElementParameterRepo.copy(list, str, str2, str3, str4, bool);
    }

    @Nullable
    public final List<SliderSnapPointRepo> component1() {
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
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final String component5() {
        return this.e;
    }

    @Nullable
    public final Boolean component6() {
        return this.f;
    }

    @NotNull
    public final ContentElementParameterRepo copy(@Nullable List<SliderSnapPointRepo> list, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool) {
        return new ContentElementParameterRepo(list, str, str2, str3, str4, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContentElementParameterRepo)) {
            return false;
        }
        ContentElementParameterRepo contentElementParameterRepo = (ContentElementParameterRepo) obj;
        return Intrinsics.areEqual(this.a, contentElementParameterRepo.a) && Intrinsics.areEqual(this.b, contentElementParameterRepo.b) && Intrinsics.areEqual(this.c, contentElementParameterRepo.c) && Intrinsics.areEqual(this.d, contentElementParameterRepo.d) && Intrinsics.areEqual(this.e, contentElementParameterRepo.e) && Intrinsics.areEqual(this.f, contentElementParameterRepo.f);
    }

    @Nullable
    public final String getHint() {
        return this.c;
    }

    @Nullable
    public final String getKeyboard() {
        return this.b;
    }

    @Nullable
    public final String getSavedSearchID() {
        return this.e;
    }

    @Nullable
    public final Boolean getShowSuggestImmediately() {
        return this.f;
    }

    @Nullable
    public final List<SliderSnapPointRepo> getSnapPoints() {
        return this.a;
    }

    @Nullable
    public final String getSuggestMode() {
        return this.d;
    }

    public int hashCode() {
        List<SliderSnapPointRepo> list = this.a;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.e;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Boolean bool = this.f;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode5 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ContentElementParameterRepo(snapPoints=");
        L.append(this.a);
        L.append(", keyboard=");
        L.append(this.b);
        L.append(", hint=");
        L.append(this.c);
        L.append(", suggestMode=");
        L.append(this.d);
        L.append(", savedSearchID=");
        L.append(this.e);
        L.append(", showSuggestImmediately=");
        return a.o(L, this.f, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ContentElementParameterRepo(List list, String str, String str2, String str3, String str4, Boolean bool, int i, j jVar) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : bool);
    }
}
