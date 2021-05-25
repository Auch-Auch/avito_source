package com.avito.android.remote.model.messenger.context_actions;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.dialog.DialogDeepLinkActivityKt;
import com.avito.android.remote.model.RawJson;
import com.avito.android.util.Parcels;
import com.facebook.internal.AnalyticsEvents;
import com.google.common.net.HttpHeaders;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler;", "Landroid/os/Parcelable;", "<init>", "()V", HttpHeaders.LINK, "MethodCall", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$Link;", "Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall;", "Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$Unknown;", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class ContextActionHandler implements Parcelable {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0019\u0012\u0006\u0010\u0017\u001a\u00020\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\r\u0010\tJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\fR\u001c\u0010\u0017\u001a\u00020\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$Link;", "Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "deepLink", "Ljava/lang/String;", "getDeepLink", "link", "getLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Link extends ContextActionHandler {
        public static final Parcelable.Creator<Link> CREATOR = new Creator();
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String DEEPLINK = "deepLink";
        @NotNull
        public static final String TYPE = "link";
        @NotNull
        public static final String URL = "url";
        @SerializedName("deepLink")
        @Nullable
        private final String deepLink;
        @SerializedName("url")
        @NotNull
        private final String link;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$Link$Companion;", "", "", DialogDeepLinkActivityKt.DEEPLINK_ARG, "Ljava/lang/String;", "TYPE", "URL", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Link> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Link createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Link(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Link[] newArray(int i) {
                return new Link[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Link(@NotNull String str, @Nullable String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "link");
            this.link = str;
            this.deepLink = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Link)) {
                return false;
            }
            Link link2 = (Link) obj;
            return !(Intrinsics.areEqual(this.link, link2.link) ^ true) && !(Intrinsics.areEqual(this.deepLink, link2.deepLink) ^ true);
        }

        @Nullable
        public final String getDeepLink() {
            return this.deepLink;
        }

        @NotNull
        public final String getLink() {
            return this.link;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int hashCode = this.link.hashCode() * 31;
            String str = this.deepLink;
            return hashCode + (str != null ? str.hashCode() : 0);
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Link(link='");
            L.append(this.link);
            L.append("', deepLink=");
            return a.s(L, this.deepLink, ')');
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.link);
            parcel.writeString(this.deepLink);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 #2\u00020\u0001:\u0002#$B#\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b!\u0010\"J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\r\u0010\tJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u00020\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\fR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall;", "Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "method", "Ljava/lang/String;", "getMethod", "Lcom/avito/android/remote/model/RawJson;", "params", "Lcom/avito/android/remote/model/RawJson;", "getParams", "()Lcom/avito/android/remote/model/RawJson;", "Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall$Reaction;", MethodCall.REACTION, "Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall$Reaction;", "getReaction", "()Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall$Reaction;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/RawJson;Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall$Reaction;)V", "Companion", "Reaction", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class MethodCall extends ContextActionHandler {
        public static final Parcelable.Creator<MethodCall> CREATOR = new Creator();
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String METHOD = "method";
        @NotNull
        public static final String PARAMS = "params";
        @NotNull
        public static final String REACTION = "reaction";
        @NotNull
        public static final String TYPE = "method_call";
        @SerializedName("method")
        @NotNull
        private final String method;
        @SerializedName("params")
        @Nullable
        private final RawJson params;
        @SerializedName(REACTION)
        @Nullable
        private final Reaction reaction;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall$Companion;", "", "", "METHOD", "Ljava/lang/String;", "PARAMS", "REACTION", "TYPE", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<MethodCall> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final MethodCall createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                Reaction reaction = null;
                RawJson createFromParcel = parcel.readInt() != 0 ? RawJson.CREATOR.createFromParcel(parcel) : null;
                if (parcel.readInt() != 0) {
                    reaction = Reaction.CREATOR.createFromParcel(parcel);
                }
                return new MethodCall(readString, createFromParcel, reaction);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final MethodCall[] newArray(int i) {
                return new MethodCall[i];
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall$Reaction;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "text", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall$Reaction;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getText", "<init>", "(Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Reaction implements Parcelable {
            public static final Parcelable.Creator<Reaction> CREATOR = new Creator();
            @NotNull
            public static final Companion Companion = new Companion(null);
            @NotNull
            public static final String TEXT = "text";
            @SerializedName("text")
            @NotNull
            private final String text;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall$Reaction$Companion;", "", "", "TEXT", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(j jVar) {
                    this();
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Reaction> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Reaction createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Reaction(parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Reaction[] newArray(int i) {
                    return new Reaction[i];
                }
            }

            public Reaction(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "text");
                this.text = str;
            }

            public static /* synthetic */ Reaction copy$default(Reaction reaction, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = reaction.text;
                }
                return reaction.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.text;
            }

            @NotNull
            public final Reaction copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "text");
                return new Reaction(str);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // java.lang.Object
            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Reaction) && Intrinsics.areEqual(this.text, ((Reaction) obj).text);
                }
                return true;
            }

            @NotNull
            public final String getText() {
                return this.text;
            }

            @Override // java.lang.Object
            public int hashCode() {
                String str = this.text;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                return a.t(a.L("Reaction(text="), this.text, ")");
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.text);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MethodCall(@NotNull String str, @Nullable RawJson rawJson, @Nullable Reaction reaction2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "method");
            this.method = str;
            this.params = rawJson;
            this.reaction = reaction2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MethodCall)) {
                return false;
            }
            MethodCall methodCall = (MethodCall) obj;
            return !(Intrinsics.areEqual(this.method, methodCall.method) ^ true) && !(Intrinsics.areEqual(this.params, methodCall.params) ^ true) && !(Intrinsics.areEqual(this.reaction, methodCall.reaction) ^ true);
        }

        @NotNull
        public final String getMethod() {
            return this.method;
        }

        @Nullable
        public final RawJson getParams() {
            return this.params;
        }

        @Nullable
        public final Reaction getReaction() {
            return this.reaction;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int hashCode = this.method.hashCode() * 31;
            RawJson rawJson = this.params;
            int i = 0;
            int hashCode2 = (hashCode + (rawJson != null ? rawJson.hashCode() : 0)) * 31;
            Reaction reaction2 = this.reaction;
            if (reaction2 != null) {
                i = reaction2.hashCode();
            }
            return hashCode2 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("MethodCall(method='");
            L.append(this.method);
            L.append("', params=");
            L.append(this.params);
            L.append(", reaction=");
            L.append(this.reaction);
            L.append(')');
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.method);
            RawJson rawJson = this.params;
            if (rawJson != null) {
                parcel.writeInt(1);
                rawJson.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            Reaction reaction2 = this.reaction;
            if (reaction2 != null) {
                parcel.writeInt(1);
                reaction2.writeToParcel(parcel, 0);
                return;
            }
            parcel.writeInt(0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$Unknown;", "Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Unknown extends ContextActionHandler {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Unknown> CREATOR = Parcels.creator(ContextActionHandler$Unknown$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$Unknown$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$Unknown;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        public Unknown() {
            super(null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            return this == obj;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@Nullable Parcel parcel, int i) {
        }
    }

    private ContextActionHandler() {
    }

    public /* synthetic */ ContextActionHandler(j jVar) {
        this();
    }
}
