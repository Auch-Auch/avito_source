package com.sumsub.sns.core.data.model.remote;

import a2.b.a.a.a;
import com.avito.android.remote.model.AvatarStatus;
import com.google.gson.annotations.SerializedName;
import com.sumsub.sns.core.data.model.DocumentType;
import com.sumsub.sns.core.data.model.FlowActionType;
import com.sumsub.sns.core.data.model.VideoRequiredType;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001:\u0002/0B?\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u000e¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JV\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u001c\u0010\u0015\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u0014\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b$\u0010\u0004R\u001c\u0010\u0016\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b&\u0010\rR\u001c\u0010\u0011\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b'\u0010\u0004R\u001c\u0010\u0012\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b(\u0010\u0004R\u001c\u0010\u0013\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b*\u0010\bR\u001c\u0010\u0017\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b,\u0010\u0010¨\u00061"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/RemoteAction;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/sumsub/sns/core/data/model/FlowActionType;", "component3", "()Lcom/sumsub/sns/core/data/model/FlowActionType;", "component4", "component5", "Lcom/sumsub/sns/core/data/model/remote/RemoteAction$RequiredIdDocs;", "component6", "()Lcom/sumsub/sns/core/data/model/remote/RemoteAction$RequiredIdDocs;", "Lcom/sumsub/sns/core/data/model/remote/RemoteAction$Review;", "component7", "()Lcom/sumsub/sns/core/data/model/remote/RemoteAction$Review;", "id", "applicantId", "type", "createdAt", "externalActionId", "requiredIdDocs", AvatarStatus.REVIEW, "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/FlowActionType;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/remote/RemoteAction$RequiredIdDocs;Lcom/sumsub/sns/core/data/model/remote/RemoteAction$Review;)Lcom/sumsub/sns/core/data/model/remote/RemoteAction;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getExternalActionId", "getCreatedAt", "Lcom/sumsub/sns/core/data/model/remote/RemoteAction$RequiredIdDocs;", "getRequiredIdDocs", "getId", "getApplicantId", "Lcom/sumsub/sns/core/data/model/FlowActionType;", "getType", "Lcom/sumsub/sns/core/data/model/remote/RemoteAction$Review;", "getReview", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/FlowActionType;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/remote/RemoteAction$RequiredIdDocs;Lcom/sumsub/sns/core/data/model/remote/RemoteAction$Review;)V", "RequiredIdDocs", "Review", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class RemoteAction {
    @SerializedName("applicantId")
    @NotNull
    private final String applicantId;
    @SerializedName("createdAt")
    @NotNull
    private final String createdAt;
    @SerializedName("externalActionId")
    @NotNull
    private final String externalActionId;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("requiredIdDocs")
    @NotNull
    private final RequiredIdDocs requiredIdDocs;
    @SerializedName(AvatarStatus.REVIEW)
    @NotNull
    private final Review review;
    @SerializedName("type")
    @NotNull
    private final FlowActionType type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001:\u0001\u0017B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/RemoteAction$RequiredIdDocs;", "", "", "Lcom/sumsub/sns/core/data/model/remote/RemoteAction$RequiredIdDocs$DocSetsItem;", "component1", "()Ljava/util/List;", "docSets", "copy", "(Ljava/util/List;)Lcom/sumsub/sns/core/data/model/remote/RemoteAction$RequiredIdDocs;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getDocSets", "<init>", "(Ljava/util/List;)V", "DocSetsItem", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class RequiredIdDocs {
        @SerializedName("docSets")
        @NotNull
        private final List<DocSetsItem> docSets;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B(\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000f\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\tHÆ\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u000bJ\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\bR%\u0010\u000f\u001a\u00020\t8\u0006@\u0007X\u0004ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010\u000b\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/RemoteAction$RequiredIdDocs$DocSetsItem;", "", "Lcom/sumsub/sns/core/data/model/DocumentType;", "component1", "()Lcom/sumsub/sns/core/data/model/DocumentType;", "", "", "component2", "()Ljava/util/List;", "Lcom/sumsub/sns/core/data/model/VideoRequiredType;", "component3-u2aduso", "()Ljava/lang/String;", "component3", "idDocSetType", "types", "videoRequired", "copy-5BEKOTA", "(Lcom/sumsub/sns/core/data/model/DocumentType;Ljava/util/List;Ljava/lang/String;)Lcom/sumsub/sns/core/data/model/remote/RemoteAction$RequiredIdDocs$DocSetsItem;", "copy", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sumsub/sns/core/data/model/DocumentType;", "getIdDocSetType", "Ljava/util/List;", "getTypes", "Ljava/lang/String;", "getVideoRequired-u2aduso", "<init>", "(Lcom/sumsub/sns/core/data/model/DocumentType;Ljava/util/List;Ljava/lang/String;Lt6/r/a/j;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class DocSetsItem {
            @SerializedName("idDocSetType")
            @NotNull
            private final DocumentType idDocSetType;
            @SerializedName("types")
            @NotNull
            private final List<String> types;
            @SerializedName("videoRequired")
            @NotNull
            private final String videoRequired;

            public DocSetsItem(DocumentType documentType, List<String> list, String str) {
                this.idDocSetType = documentType;
                this.types = list;
                this.videoRequired = str;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.sumsub.sns.core.data.model.remote.RemoteAction$RequiredIdDocs$DocSetsItem */
            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: copy-5BEKOTA$default  reason: not valid java name */
            public static /* synthetic */ DocSetsItem m234copy5BEKOTA$default(DocSetsItem docSetsItem, DocumentType documentType, List list, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    documentType = docSetsItem.idDocSetType;
                }
                if ((i & 2) != 0) {
                    list = docSetsItem.types;
                }
                if ((i & 4) != 0) {
                    str = docSetsItem.videoRequired;
                }
                return docSetsItem.m236copy5BEKOTA(documentType, list, str);
            }

            @NotNull
            public final DocumentType component1() {
                return this.idDocSetType;
            }

            @NotNull
            public final List<String> component2() {
                return this.types;
            }

            @NotNull
            /* renamed from: component3-u2aduso  reason: not valid java name */
            public final String m235component3u2aduso() {
                return this.videoRequired;
            }

            @NotNull
            /* renamed from: copy-5BEKOTA  reason: not valid java name */
            public final DocSetsItem m236copy5BEKOTA(@NotNull DocumentType documentType, @NotNull List<String> list, @NotNull String str) {
                Intrinsics.checkNotNullParameter(documentType, "idDocSetType");
                Intrinsics.checkNotNullParameter(list, "types");
                Intrinsics.checkNotNullParameter(str, "videoRequired");
                return new DocSetsItem(documentType, list, str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof DocSetsItem)) {
                    return false;
                }
                DocSetsItem docSetsItem = (DocSetsItem) obj;
                return Intrinsics.areEqual(this.idDocSetType, docSetsItem.idDocSetType) && Intrinsics.areEqual(this.types, docSetsItem.types) && Intrinsics.areEqual(Intrinsics.checkNotNullParameter(this.videoRequired, VKApiConst.VERSION), Intrinsics.checkNotNullParameter(docSetsItem.videoRequired, VKApiConst.VERSION));
            }

            @NotNull
            public final DocumentType getIdDocSetType() {
                return this.idDocSetType;
            }

            @NotNull
            public final List<String> getTypes() {
                return this.types;
            }

            @NotNull
            /* renamed from: getVideoRequired-u2aduso  reason: not valid java name */
            public final String m237getVideoRequiredu2aduso() {
                return this.videoRequired;
            }

            public int hashCode() {
                DocumentType documentType = this.idDocSetType;
                int i = 0;
                int hashCode = (documentType != null ? documentType.hashCode() : 0) * 31;
                List<String> list = this.types;
                int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
                String str = this.videoRequired;
                if (str != null) {
                    i = str.hashCode();
                }
                return hashCode2 + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("DocSetsItem(idDocSetType=");
                L.append(this.idDocSetType);
                L.append(", types=");
                L.append(this.types);
                L.append(", videoRequired=");
                L.append(VideoRequiredType.m227toStringimpl(this.videoRequired));
                L.append(")");
                return L.toString();
            }

            public DocSetsItem(DocumentType documentType, List list, String str, j jVar) {
                this.idDocSetType = documentType;
                this.types = list;
                this.videoRequired = str;
            }
        }

        public RequiredIdDocs(@NotNull List<DocSetsItem> list) {
            Intrinsics.checkNotNullParameter(list, "docSets");
            this.docSets = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.sumsub.sns.core.data.model.remote.RemoteAction$RequiredIdDocs */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RequiredIdDocs copy$default(RequiredIdDocs requiredIdDocs, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = requiredIdDocs.docSets;
            }
            return requiredIdDocs.copy(list);
        }

        @NotNull
        public final List<DocSetsItem> component1() {
            return this.docSets;
        }

        @NotNull
        public final RequiredIdDocs copy(@NotNull List<DocSetsItem> list) {
            Intrinsics.checkNotNullParameter(list, "docSets");
            return new RequiredIdDocs(list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof RequiredIdDocs) && Intrinsics.areEqual(this.docSets, ((RequiredIdDocs) obj).docSets);
            }
            return true;
        }

        @NotNull
        public final List<DocSetsItem> getDocSets() {
            return this.docSets;
        }

        public int hashCode() {
            List<DocSetsItem> list = this.docSets;
            if (list != null) {
                return list.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a.w(a.L("RequiredIdDocs(docSets="), this.docSets, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\b\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\"\u0010#J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJL\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\nJ\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b \u0010\u0004R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b!\u0010\n¨\u0006$"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/RemoteAction$Review;", "", "", "component1", "()Ljava/lang/Boolean;", "", "component2", "()Ljava/lang/Integer;", "", "component3", "()Ljava/lang/String;", "component4", "component5", "reprocessing", "notificationFailureCnt", "reviewStatus", "autoChecked", "createDate", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/sumsub/sns/core/data/model/remote/RemoteAction$Review;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getNotificationFailureCnt", "Ljava/lang/Boolean;", "getAutoChecked", "Ljava/lang/String;", "getCreateDate", "getReprocessing", "getReviewStatus", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Review {
        @SerializedName("autoChecked")
        @Nullable
        private final Boolean autoChecked;
        @SerializedName("createDate")
        @Nullable
        private final String createDate;
        @SerializedName("notificationFailureCnt")
        @Nullable
        private final Integer notificationFailureCnt;
        @SerializedName("reprocessing")
        @Nullable
        private final Boolean reprocessing;
        @SerializedName("reviewStatus")
        @Nullable
        private final String reviewStatus;

        public Review(@Nullable Boolean bool, @Nullable Integer num, @Nullable String str, @Nullable Boolean bool2, @Nullable String str2) {
            this.reprocessing = bool;
            this.notificationFailureCnt = num;
            this.reviewStatus = str;
            this.autoChecked = bool2;
            this.createDate = str2;
        }

        public static /* synthetic */ Review copy$default(Review review, Boolean bool, Integer num, String str, Boolean bool2, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = review.reprocessing;
            }
            if ((i & 2) != 0) {
                num = review.notificationFailureCnt;
            }
            if ((i & 4) != 0) {
                str = review.reviewStatus;
            }
            if ((i & 8) != 0) {
                bool2 = review.autoChecked;
            }
            if ((i & 16) != 0) {
                str2 = review.createDate;
            }
            return review.copy(bool, num, str, bool2, str2);
        }

        @Nullable
        public final Boolean component1() {
            return this.reprocessing;
        }

        @Nullable
        public final Integer component2() {
            return this.notificationFailureCnt;
        }

        @Nullable
        public final String component3() {
            return this.reviewStatus;
        }

        @Nullable
        public final Boolean component4() {
            return this.autoChecked;
        }

        @Nullable
        public final String component5() {
            return this.createDate;
        }

        @NotNull
        public final Review copy(@Nullable Boolean bool, @Nullable Integer num, @Nullable String str, @Nullable Boolean bool2, @Nullable String str2) {
            return new Review(bool, num, str, bool2, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Review)) {
                return false;
            }
            Review review = (Review) obj;
            return Intrinsics.areEqual(this.reprocessing, review.reprocessing) && Intrinsics.areEqual(this.notificationFailureCnt, review.notificationFailureCnt) && Intrinsics.areEqual(this.reviewStatus, review.reviewStatus) && Intrinsics.areEqual(this.autoChecked, review.autoChecked) && Intrinsics.areEqual(this.createDate, review.createDate);
        }

        @Nullable
        public final Boolean getAutoChecked() {
            return this.autoChecked;
        }

        @Nullable
        public final String getCreateDate() {
            return this.createDate;
        }

        @Nullable
        public final Integer getNotificationFailureCnt() {
            return this.notificationFailureCnt;
        }

        @Nullable
        public final Boolean getReprocessing() {
            return this.reprocessing;
        }

        @Nullable
        public final String getReviewStatus() {
            return this.reviewStatus;
        }

        public int hashCode() {
            Boolean bool = this.reprocessing;
            int i = 0;
            int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
            Integer num = this.notificationFailureCnt;
            int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
            String str = this.reviewStatus;
            int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            Boolean bool2 = this.autoChecked;
            int hashCode4 = (hashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
            String str2 = this.createDate;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode4 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Review(reprocessing=");
            L.append(this.reprocessing);
            L.append(", notificationFailureCnt=");
            L.append(this.notificationFailureCnt);
            L.append(", reviewStatus=");
            L.append(this.reviewStatus);
            L.append(", autoChecked=");
            L.append(this.autoChecked);
            L.append(", createDate=");
            return a.t(L, this.createDate, ")");
        }
    }

    public RemoteAction(@NotNull String str, @NotNull String str2, @NotNull FlowActionType flowActionType, @NotNull String str3, @NotNull String str4, @NotNull RequiredIdDocs requiredIdDocs2, @NotNull Review review2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "applicantId");
        Intrinsics.checkNotNullParameter(flowActionType, "type");
        Intrinsics.checkNotNullParameter(str3, "createdAt");
        Intrinsics.checkNotNullParameter(str4, "externalActionId");
        Intrinsics.checkNotNullParameter(requiredIdDocs2, "requiredIdDocs");
        Intrinsics.checkNotNullParameter(review2, AvatarStatus.REVIEW);
        this.id = str;
        this.applicantId = str2;
        this.type = flowActionType;
        this.createdAt = str3;
        this.externalActionId = str4;
        this.requiredIdDocs = requiredIdDocs2;
        this.review = review2;
    }

    public static /* synthetic */ RemoteAction copy$default(RemoteAction remoteAction, String str, String str2, FlowActionType flowActionType, String str3, String str4, RequiredIdDocs requiredIdDocs2, Review review2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = remoteAction.id;
        }
        if ((i & 2) != 0) {
            str2 = remoteAction.applicantId;
        }
        if ((i & 4) != 0) {
            flowActionType = remoteAction.type;
        }
        if ((i & 8) != 0) {
            str3 = remoteAction.createdAt;
        }
        if ((i & 16) != 0) {
            str4 = remoteAction.externalActionId;
        }
        if ((i & 32) != 0) {
            requiredIdDocs2 = remoteAction.requiredIdDocs;
        }
        if ((i & 64) != 0) {
            review2 = remoteAction.review;
        }
        return remoteAction.copy(str, str2, flowActionType, str3, str4, requiredIdDocs2, review2);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.applicantId;
    }

    @NotNull
    public final FlowActionType component3() {
        return this.type;
    }

    @NotNull
    public final String component4() {
        return this.createdAt;
    }

    @NotNull
    public final String component5() {
        return this.externalActionId;
    }

    @NotNull
    public final RequiredIdDocs component6() {
        return this.requiredIdDocs;
    }

    @NotNull
    public final Review component7() {
        return this.review;
    }

    @NotNull
    public final RemoteAction copy(@NotNull String str, @NotNull String str2, @NotNull FlowActionType flowActionType, @NotNull String str3, @NotNull String str4, @NotNull RequiredIdDocs requiredIdDocs2, @NotNull Review review2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "applicantId");
        Intrinsics.checkNotNullParameter(flowActionType, "type");
        Intrinsics.checkNotNullParameter(str3, "createdAt");
        Intrinsics.checkNotNullParameter(str4, "externalActionId");
        Intrinsics.checkNotNullParameter(requiredIdDocs2, "requiredIdDocs");
        Intrinsics.checkNotNullParameter(review2, AvatarStatus.REVIEW);
        return new RemoteAction(str, str2, flowActionType, str3, str4, requiredIdDocs2, review2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemoteAction)) {
            return false;
        }
        RemoteAction remoteAction = (RemoteAction) obj;
        return Intrinsics.areEqual(this.id, remoteAction.id) && Intrinsics.areEqual(this.applicantId, remoteAction.applicantId) && Intrinsics.areEqual(this.type, remoteAction.type) && Intrinsics.areEqual(this.createdAt, remoteAction.createdAt) && Intrinsics.areEqual(this.externalActionId, remoteAction.externalActionId) && Intrinsics.areEqual(this.requiredIdDocs, remoteAction.requiredIdDocs) && Intrinsics.areEqual(this.review, remoteAction.review);
    }

    @NotNull
    public final String getApplicantId() {
        return this.applicantId;
    }

    @NotNull
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @NotNull
    public final String getExternalActionId() {
        return this.externalActionId;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final RequiredIdDocs getRequiredIdDocs() {
        return this.requiredIdDocs;
    }

    @NotNull
    public final Review getReview() {
        return this.review;
    }

    @NotNull
    public final FlowActionType getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.applicantId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        FlowActionType flowActionType = this.type;
        int hashCode3 = (hashCode2 + (flowActionType != null ? flowActionType.hashCode() : 0)) * 31;
        String str3 = this.createdAt;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.externalActionId;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        RequiredIdDocs requiredIdDocs2 = this.requiredIdDocs;
        int hashCode6 = (hashCode5 + (requiredIdDocs2 != null ? requiredIdDocs2.hashCode() : 0)) * 31;
        Review review2 = this.review;
        if (review2 != null) {
            i = review2.hashCode();
        }
        return hashCode6 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("RemoteAction(id=");
        L.append(this.id);
        L.append(", applicantId=");
        L.append(this.applicantId);
        L.append(", type=");
        L.append(this.type);
        L.append(", createdAt=");
        L.append(this.createdAt);
        L.append(", externalActionId=");
        L.append(this.externalActionId);
        L.append(", requiredIdDocs=");
        L.append(this.requiredIdDocs);
        L.append(", review=");
        L.append(this.review);
        L.append(")");
        return L.toString();
    }
}
