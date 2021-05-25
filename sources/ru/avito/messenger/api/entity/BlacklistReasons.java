package ru.avito.messenger.api.entity;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001:\u0001\u001bB\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\b¨\u0006\u001c"}, d2 = {"Lru/avito/messenger/api/entity/BlacklistReasons;", "", "", "component1", "()Ljava/lang/String;", "", "Lru/avito/messenger/api/entity/BlacklistReasons$Reason;", "component2", "()Ljava/util/List;", "title", "reasons", "copy", "(Ljava/lang/String;Ljava/util/List;)Lru/avito/messenger/api/entity/BlacklistReasons;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getReasons", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Reason", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class BlacklistReasons {
    @SerializedName("reasons")
    @NotNull
    private final List<Reason> reasons;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u001a"}, d2 = {"Lru/avito/messenger/api/entity/BlacklistReasons$Reason;", "", "", "component1", "()J", "", "component2", "()Ljava/lang/String;", "id", "text", "copy", "(JLjava/lang/String;)Lru/avito/messenger/api/entity/BlacklistReasons$Reason;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getId", "Ljava/lang/String;", "getText", "<init>", "(JLjava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Reason {
        @SerializedName("id")
        private final long id;
        @SerializedName("text")
        @NotNull
        private final String text;

        public Reason(long j, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            this.id = j;
            this.text = str;
        }

        public static /* synthetic */ Reason copy$default(Reason reason, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = reason.id;
            }
            if ((i & 2) != 0) {
                str = reason.text;
            }
            return reason.copy(j, str);
        }

        public final long component1() {
            return this.id;
        }

        @NotNull
        public final String component2() {
            return this.text;
        }

        @NotNull
        public final Reason copy(long j, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            return new Reason(j, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Reason)) {
                return false;
            }
            Reason reason = (Reason) obj;
            return this.id == reason.id && Intrinsics.areEqual(this.text, reason.text);
        }

        public final long getId() {
            return this.id;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            int a = c.a(this.id) * 31;
            String str = this.text;
            return a + (str != null ? str.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Reason(id=");
            L.append(this.id);
            L.append(", text=");
            return a.t(L, this.text, ")");
        }
    }

    public BlacklistReasons(@NotNull String str, @NotNull List<Reason> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "reasons");
        this.title = str;
        this.reasons = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.avito.messenger.api.entity.BlacklistReasons */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BlacklistReasons copy$default(BlacklistReasons blacklistReasons, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = blacklistReasons.title;
        }
        if ((i & 2) != 0) {
            list = blacklistReasons.reasons;
        }
        return blacklistReasons.copy(str, list);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final List<Reason> component2() {
        return this.reasons;
    }

    @NotNull
    public final BlacklistReasons copy(@NotNull String str, @NotNull List<Reason> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "reasons");
        return new BlacklistReasons(str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlacklistReasons)) {
            return false;
        }
        BlacklistReasons blacklistReasons = (BlacklistReasons) obj;
        return Intrinsics.areEqual(this.title, blacklistReasons.title) && Intrinsics.areEqual(this.reasons, blacklistReasons.reasons);
    }

    @NotNull
    public final List<Reason> getReasons() {
        return this.reasons;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<Reason> list = this.reasons;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("BlacklistReasons(title=");
        L.append(this.title);
        L.append(", reasons=");
        return a.w(L, this.reasons, ")");
    }
}
