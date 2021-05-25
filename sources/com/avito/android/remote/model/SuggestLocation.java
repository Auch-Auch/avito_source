package com.avito.android.remote.model;

import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u001a\u001bB9\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/SuggestLocation;", "", "Lcom/avito/android/remote/model/SuggestLocation$Parent;", "parent", "Lcom/avito/android/remote/model/SuggestLocation$Parent;", "getParent", "()Lcom/avito/android/remote/model/SuggestLocation$Parent;", "", "suggestType", "Ljava/lang/String;", "getSuggestType", "()Ljava/lang/String;", "id", "getId", "Lcom/avito/android/remote/model/SuggestLocation$From;", "from", "Lcom/avito/android/remote/model/SuggestLocation$From;", "getFrom", "()Lcom/avito/android/remote/model/SuggestLocation$From;", "Lcom/avito/android/remote/model/CaseText;", "names", "Lcom/avito/android/remote/model/CaseText;", "getNames", "()Lcom/avito/android/remote/model/CaseText;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/CaseText;Lcom/avito/android/remote/model/SuggestLocation$From;Lcom/avito/android/remote/model/SuggestLocation$Parent;Ljava/lang/String;)V", HttpHeaders.FROM, "Parent", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestLocation {
    @Nullable
    private final From from;
    @Nullable
    private final String id;
    @Nullable
    private final CaseText names;
    @Nullable
    private final Parent parent;
    @Nullable
    private final String suggestType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/model/SuggestLocation$From;", "", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", MessageMetaInfo.COLUMN_PATH, "getPath", "internalId", "getInternalId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class From {
        @Nullable
        private final String internalId;
        @Nullable
        private final String name;
        @Nullable
        private final String path;

        public From() {
            this(null, null, null, 7, null);
        }

        public From(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            this.internalId = str;
            this.name = str2;
            this.path = str3;
        }

        @Nullable
        public final String getInternalId() {
            return this.internalId;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getPath() {
            return this.path;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ From(String str, String str2, String str3, int i, j jVar) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/SuggestLocation$Parent;", "", "Lcom/avito/android/remote/model/CaseText;", "names", "Lcom/avito/android/remote/model/CaseText;", "getNames", "()Lcom/avito/android/remote/model/CaseText;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/CaseText;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Parent {
        @Nullable
        private final String id;
        @Nullable
        private final CaseText names;

        public Parent() {
            this(null, null, 3, null);
        }

        public Parent(@Nullable String str, @Nullable CaseText caseText) {
            this.id = str;
            this.names = caseText;
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final CaseText getNames() {
            return this.names;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Parent(String str, CaseText caseText, int i, j jVar) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : caseText);
        }
    }

    public SuggestLocation(@Nullable String str, @Nullable CaseText caseText, @Nullable From from2, @Nullable Parent parent2, @Nullable String str2) {
        this.id = str;
        this.names = caseText;
        this.from = from2;
        this.parent = parent2;
        this.suggestType = str2;
    }

    @Nullable
    public final From getFrom() {
        return this.from;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final CaseText getNames() {
        return this.names;
    }

    @Nullable
    public final Parent getParent() {
        return this.parent;
    }

    @Nullable
    public final String getSuggestType() {
        return this.suggestType;
    }
}
