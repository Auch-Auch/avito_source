package com.avito.android.deep_linking.links;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.SearchParamsFactory;
import com.avito.android.util.Parcels;
import com.facebook.share.internal.ShareConstants;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import t6.n.e;
import t6.r.a.j;
import t6.y.l;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000f2\u00020\u0001:\u0004\u000f\u0010\u0011\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u0001\u0003\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/deep_linking/links/SaveSearchLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/SearchPushSubscription;", "c", "Lcom/avito/android/deep_linking/links/SearchPushSubscription;", "getSubscription", "()Lcom/avito/android/deep_linking/links/SearchPushSubscription;", "subscription", "Companion", BaseAnalyticKt.ANALYTIC_ACTION_EDIT, "Existing", "New", "Lcom/avito/android/deep_linking/links/SaveSearchLink$New;", "Lcom/avito/android/deep_linking/links/SaveSearchLink$Existing;", "Lcom/avito/android/deep_linking/links/SaveSearchLink$Edit;", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class SaveSearchLink extends DeepLink {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final SearchPushSubscription c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/deep_linking/links/SaveSearchLink$Companion;", "", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Lcom/avito/android/deep_linking/links/SaveSearchLinkType;", "type", "Lcom/avito/android/deep_linking/links/SearchPushSubscription;", "create", "(Landroid/net/Uri;Lcom/avito/android/deep_linking/links/SaveSearchLinkType;)Lcom/avito/android/deep_linking/links/SearchPushSubscription;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final SearchPushSubscription create(@NotNull Uri uri, @NotNull SaveSearchLinkType saveSearchLinkType) {
            String str;
            Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
            Intrinsics.checkNotNullParameter(saveSearchLinkType, "type");
            String access$get = SaveSearchLinkKt.access$get(uri, "filterId");
            String access$get2 = SaveSearchLinkKt.access$get(uri, "title");
            String access$get3 = SaveSearchLinkKt.access$get(uri, "description");
            String access$get4 = SaveSearchLinkKt.access$get(uri, "pushFrequency");
            Integer intOrNull = access$get4 != null ? l.toIntOrNull(access$get4) : null;
            String access$get5 = SaveSearchLinkKt.access$get(uri, "xHash");
            String decode = URLDecoder.decode(uri.toString(), "UTF-8");
            HashMap hashMap = new HashMap();
            List split$default = StringsKt__StringsKt.split$default((CharSequence) decode.toString(), new String[]{"&"}, false, 0, 6, (Object) null);
            Regex regex = new Regex("\\b(pushFrequencyOptions\\[[0-9]+])");
            Regex regex2 = new Regex("\\b(filter\\[[a-zA-Z0-9\\[\\]]+])");
            ArrayList<String> arrayList = new ArrayList();
            for (Object obj : split$default) {
                if (regex.containsMatchIn((String) obj)) {
                    arrayList.add(obj);
                }
            }
            for (String str2 : arrayList) {
                List split$default2 = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{"="}, false, 0, 6, (Object) null);
                hashMap.put(split$default2.get(0), split$default2.get(1));
            }
            StringBuilder sb = new StringBuilder();
            ArrayList<String> arrayList2 = new ArrayList();
            for (Object obj2 : split$default) {
                if (regex2.containsMatchIn((String) obj2)) {
                    arrayList2.add(obj2);
                }
            }
            for (String str3 : arrayList2) {
                sb.append(m.replaceFirst$default(m.replaceFirst$default(str3, "filter[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null));
                sb.append("&");
            }
            IntRange intRange = new IntRange(0, hashMap.size());
            ArrayList arrayList3 = new ArrayList(e.collectionSizeOrDefault(intRange, 10));
            Iterator it = intRange.iterator();
            while (true) {
                str = "";
                if (!it.hasNext()) {
                    break;
                }
                int nextInt = ((IntIterator) it).nextInt();
                String str4 = (String) hashMap.get("pushFrequencyOptions[" + nextInt + "][id]");
                int parseInt = str4 != null ? Integer.parseInt(str4) : 0;
                String str5 = (String) hashMap.get("pushFrequencyOptions[" + nextInt + "][title]");
                if (str5 != null) {
                    str = str5;
                }
                Intrinsics.checkNotNullExpressionValue(str, "pushFrequencyOptionsMap[…tions[$it][title]\"] ?: \"\"");
                arrayList3.add(new PushFrequencyOption(parseInt, str));
            }
            ArrayList arrayList4 = new ArrayList();
            for (Object obj3 : arrayList3) {
                if (!Intrinsics.areEqual(((PushFrequencyOption) obj3).getTitle(), str)) {
                    arrayList4.add(obj3);
                }
            }
            return new SearchPushSubscription(saveSearchLinkType, access$get, access$get2, access$get3, intOrNull, arrayList4, SearchParamsFactory.fromUri(Uri.parse(sb.toString())), access$get5);
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/deep_linking/links/SaveSearchLink$Edit;", "Lcom/avito/android/deep_linking/links/SaveSearchLink;", "", "d", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", MessageMetaInfo.COLUMN_PATH, "Lcom/avito/android/deep_linking/links/SearchPushSubscription;", "searchSubscription", "<init>", "(Lcom/avito/android/deep_linking/links/SearchPushSubscription;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Edit extends SaveSearchLink {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Edit> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String e = "/searchSubscription/edit";
        @NotNull
        public final String d = e;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/deep_linking/links/SaveSearchLink$Edit$Companion;", "", "", "PATH", "Ljava/lang/String;", "getPATH", "()Ljava/lang/String;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/deep_linking/links/SaveSearchLink$Edit;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            @NotNull
            public final String getPATH() {
                return Edit.e;
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, Edit> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Edit invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new Edit((SearchPushSubscription) a2.b.a.a.a.z1(SearchPushSubscription.class, parcel2));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Edit(@NotNull SearchPushSubscription searchPushSubscription) {
            super(searchPushSubscription, null);
            Intrinsics.checkNotNullParameter(searchPushSubscription, "searchSubscription");
        }

        @Override // com.avito.android.deep_linking.links.DeepLink
        @NotNull
        public String getPath() {
            return this.d;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/deep_linking/links/SaveSearchLink$Existing;", "Lcom/avito/android/deep_linking/links/SaveSearchLink;", "", "d", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", MessageMetaInfo.COLUMN_PATH, "Lcom/avito/android/deep_linking/links/SearchPushSubscription;", "searchSubscription", "<init>", "(Lcom/avito/android/deep_linking/links/SearchPushSubscription;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Existing extends SaveSearchLink {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Existing> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String e = "/searchSubscription/new/byFilterId";
        @NotNull
        public final String d = e;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/deep_linking/links/SaveSearchLink$Existing$Companion;", "", "", "PATH", "Ljava/lang/String;", "getPATH", "()Ljava/lang/String;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/deep_linking/links/SaveSearchLink$Existing;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            @NotNull
            public final String getPATH() {
                return Existing.e;
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, Existing> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Existing invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new Existing((SearchPushSubscription) a2.b.a.a.a.z1(SearchPushSubscription.class, parcel2));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Existing(@NotNull SearchPushSubscription searchPushSubscription) {
            super(searchPushSubscription, null);
            Intrinsics.checkNotNullParameter(searchPushSubscription, "searchSubscription");
        }

        @Override // com.avito.android.deep_linking.links.DeepLink
        @NotNull
        public String getPath() {
            return this.d;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/deep_linking/links/SaveSearchLink$New;", "Lcom/avito/android/deep_linking/links/SaveSearchLink;", "", "d", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", MessageMetaInfo.COLUMN_PATH, "Lcom/avito/android/deep_linking/links/SearchPushSubscription;", "searchSubscription", "<init>", "(Lcom/avito/android/deep_linking/links/SearchPushSubscription;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class New extends SaveSearchLink {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<New> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String e = "/searchSubscription/new/byParams";
        @NotNull
        public final String d = e;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/deep_linking/links/SaveSearchLink$New$Companion;", "", "", "PATH", "Ljava/lang/String;", "getPATH", "()Ljava/lang/String;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/deep_linking/links/SaveSearchLink$New;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            @NotNull
            public final String getPATH() {
                return New.e;
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, New> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public New invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new New((SearchPushSubscription) a2.b.a.a.a.z1(SearchPushSubscription.class, parcel2));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public New(@NotNull SearchPushSubscription searchPushSubscription) {
            super(searchPushSubscription, null);
            Intrinsics.checkNotNullParameter(searchPushSubscription, "searchSubscription");
        }

        @Override // com.avito.android.deep_linking.links.DeepLink
        @NotNull
        public String getPath() {
            return this.d;
        }
    }

    public SaveSearchLink(SearchPushSubscription searchPushSubscription, j jVar) {
        this.c = searchPushSubscription;
    }

    @NotNull
    public final SearchPushSubscription getSubscription() {
        return this.c;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelable(this.c, i);
    }
}
