package com.avito.android.publish.drafts;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.category_parameters.AttributeNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b3\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001f\u001a\u00020\n\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\u0012\b\u0002\u0010!\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010\u0012\u0012\b\u0002\u0010\"\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010\u0012\b\b\u0002\u0010#\u001a\u00020\u0014\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0018¢\u0006\u0004\bI\u0010JJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0011\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0001\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\u0012\b\u0002\u0010!\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u00102\u0012\b\u0002\u0010\"\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u00102\b\b\u0002\u0010#\u001a\u00020\u00142\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010%\u001a\u00020\u0018HÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b(\u0010\u0004J\u0010\u0010)\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b)\u0010\tJ\u001a\u0010+\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b+\u0010,R\u001b\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u0004R\u0019\u0010#\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u0016R\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b4\u0010\u0004R\u0019\u0010\u001f\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u0010\fR\u0019\u0010%\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010\u001aR\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010.\u001a\u0004\b<\u0010\u0004R#\u0010\"\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u00108\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010\u0012R#\u0010!\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u00108\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010>\u001a\u0004\bA\u0010\u0012R\u0019\u0010\u001d\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010.\u001a\u0004\bC\u0010\u0004R\u0019\u0010\u001e\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010\tR\u001b\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010.\u001a\u0004\bH\u0010\u0004¨\u0006K"}, d2 = {"Lcom/avito/android/publish/drafts/LocalDraft;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()I", "", "component5", "()Z", "component6", "", "Lcom/avito/android/remote/model/category_parameters/AttributeNode;", "Lcom/avito/android/remote/model/category_parameters/AttributesTree;", "component7", "()Ljava/util/List;", "component8", "Lcom/avito/android/remote/model/Navigation;", "component9", "()Lcom/avito/android/remote/model/Navigation;", "component10", "Lcom/avito/android/publish/drafts/LocalPublishState;", "component11", "()Lcom/avito/android/publish/drafts/LocalPublishState;", "sessionId", "draftId", "state", "version", "hasLocalChanges", "serverDraftId", "slots", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "navigation", "activeFieldId", "localPublishState", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/avito/android/remote/model/Navigation;Ljava/lang/String;Lcom/avito/android/publish/drafts/LocalPublishState;)Lcom/avito/android/publish/drafts/LocalDraft;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "j", "Ljava/lang/String;", "getActiveFieldId", "i", "Lcom/avito/android/remote/model/Navigation;", "getNavigation", AuthSource.BOOKING_ORDER, "getDraftId", "e", "Z", "getHasLocalChanges", "k", "Lcom/avito/android/publish/drafts/LocalPublishState;", "getLocalPublishState", AuthSource.SEND_ABUSE, "getSessionId", "h", "Ljava/util/List;", "getParameters", g.a, "getSlots", "c", "getState", "d", "I", "getVersion", "f", "getServerDraftId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/avito/android/remote/model/Navigation;Ljava/lang/String;Lcom/avito/android/publish/drafts/LocalPublishState;)V", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public final class LocalDraft {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    public final int d;
    public final boolean e;
    @Nullable
    public final String f;
    @NotNull
    public final List<AttributeNode> g;
    @NotNull
    public final List<AttributeNode> h;
    @NotNull
    public final Navigation i;
    @Nullable
    public final String j;
    @NotNull
    public final LocalPublishState k;

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.AttributeNode> */
    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.AttributeNode> */
    /* JADX WARN: Multi-variable type inference failed */
    public LocalDraft(@NotNull String str, @NotNull String str2, @NotNull String str3, int i2, boolean z, @Nullable String str4, @NotNull List<? extends AttributeNode> list, @NotNull List<? extends AttributeNode> list2, @NotNull Navigation navigation, @Nullable String str5, @NotNull LocalPublishState localPublishState) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(str2, "draftId");
        Intrinsics.checkNotNullParameter(str3, "state");
        Intrinsics.checkNotNullParameter(list, "slots");
        Intrinsics.checkNotNullParameter(list2, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Intrinsics.checkNotNullParameter(localPublishState, "localPublishState");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i2;
        this.e = z;
        this.f = str4;
        this.g = list;
        this.h = list2;
        this.i = navigation;
        this.j = str5;
        this.k = localPublishState;
    }

    public static /* synthetic */ LocalDraft copy$default(LocalDraft localDraft, String str, String str2, String str3, int i2, boolean z, String str4, List list, List list2, Navigation navigation, String str5, LocalPublishState localPublishState, int i3, Object obj) {
        return localDraft.copy((i3 & 1) != 0 ? localDraft.a : str, (i3 & 2) != 0 ? localDraft.b : str2, (i3 & 4) != 0 ? localDraft.c : str3, (i3 & 8) != 0 ? localDraft.d : i2, (i3 & 16) != 0 ? localDraft.e : z, (i3 & 32) != 0 ? localDraft.f : str4, (i3 & 64) != 0 ? localDraft.g : list, (i3 & 128) != 0 ? localDraft.h : list2, (i3 & 256) != 0 ? localDraft.i : navigation, (i3 & 512) != 0 ? localDraft.j : str5, (i3 & 1024) != 0 ? localDraft.k : localPublishState);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final String component10() {
        return this.j;
    }

    @NotNull
    public final LocalPublishState component11() {
        return this.k;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    public final int component4() {
        return this.d;
    }

    public final boolean component5() {
        return this.e;
    }

    @Nullable
    public final String component6() {
        return this.f;
    }

    @NotNull
    public final List<AttributeNode> component7() {
        return this.g;
    }

    @NotNull
    public final List<AttributeNode> component8() {
        return this.h;
    }

    @NotNull
    public final Navigation component9() {
        return this.i;
    }

    @NotNull
    public final LocalDraft copy(@NotNull String str, @NotNull String str2, @NotNull String str3, int i2, boolean z, @Nullable String str4, @NotNull List<? extends AttributeNode> list, @NotNull List<? extends AttributeNode> list2, @NotNull Navigation navigation, @Nullable String str5, @NotNull LocalPublishState localPublishState) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(str2, "draftId");
        Intrinsics.checkNotNullParameter(str3, "state");
        Intrinsics.checkNotNullParameter(list, "slots");
        Intrinsics.checkNotNullParameter(list2, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Intrinsics.checkNotNullParameter(localPublishState, "localPublishState");
        return new LocalDraft(str, str2, str3, i2, z, str4, list, list2, navigation, str5, localPublishState);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalDraft)) {
            return false;
        }
        LocalDraft localDraft = (LocalDraft) obj;
        return Intrinsics.areEqual(this.a, localDraft.a) && Intrinsics.areEqual(this.b, localDraft.b) && Intrinsics.areEqual(this.c, localDraft.c) && this.d == localDraft.d && this.e == localDraft.e && Intrinsics.areEqual(this.f, localDraft.f) && Intrinsics.areEqual(this.g, localDraft.g) && Intrinsics.areEqual(this.h, localDraft.h) && Intrinsics.areEqual(this.i, localDraft.i) && Intrinsics.areEqual(this.j, localDraft.j) && Intrinsics.areEqual(this.k, localDraft.k);
    }

    @Nullable
    public final String getActiveFieldId() {
        return this.j;
    }

    @NotNull
    public final String getDraftId() {
        return this.b;
    }

    public final boolean getHasLocalChanges() {
        return this.e;
    }

    @NotNull
    public final LocalPublishState getLocalPublishState() {
        return this.k;
    }

    @NotNull
    public final Navigation getNavigation() {
        return this.i;
    }

    @NotNull
    public final List<AttributeNode> getParameters() {
        return this.h;
    }

    @Nullable
    public final String getServerDraftId() {
        return this.f;
    }

    @NotNull
    public final String getSessionId() {
        return this.a;
    }

    @NotNull
    public final List<AttributeNode> getSlots() {
        return this.g;
    }

    @NotNull
    public final String getState() {
        return this.c;
    }

    public final int getVersion() {
        return this.d;
    }

    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.d) * 31;
        boolean z = this.e;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode3 + i3) * 31;
        String str4 = this.f;
        int hashCode4 = (i6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<AttributeNode> list = this.g;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        List<AttributeNode> list2 = this.h;
        int hashCode6 = (hashCode5 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Navigation navigation = this.i;
        int hashCode7 = (hashCode6 + (navigation != null ? navigation.hashCode() : 0)) * 31;
        String str5 = this.j;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        LocalPublishState localPublishState = this.k;
        if (localPublishState != null) {
            i2 = localPublishState.hashCode();
        }
        return hashCode8 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("LocalDraft(sessionId=");
        L.append(this.a);
        L.append(", draftId=");
        L.append(this.b);
        L.append(", state=");
        L.append(this.c);
        L.append(", version=");
        L.append(this.d);
        L.append(", hasLocalChanges=");
        L.append(this.e);
        L.append(", serverDraftId=");
        L.append(this.f);
        L.append(", slots=");
        L.append(this.g);
        L.append(", parameters=");
        L.append(this.h);
        L.append(", navigation=");
        L.append(this.i);
        L.append(", activeFieldId=");
        L.append(this.j);
        L.append(", localPublishState=");
        L.append(this.k);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocalDraft(String str, String str2, String str3, int i2, boolean z, String str4, List list, List list2, Navigation navigation, String str5, LocalPublishState localPublishState, int i3, j jVar) {
        this(str, str2, str3, i2, (i3 & 16) != 0 ? false : z, (i3 & 32) != 0 ? null : str4, (i3 & 64) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 128) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i3 & 256) != 0 ? new Navigation(null, null, null, null, null, null, null, 127, null) : navigation, (i3 & 512) != 0 ? null : str5, (i3 & 1024) != 0 ? new LocalPublishState(null, null, 3, null) : localPublishState);
    }
}
