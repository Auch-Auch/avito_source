package com.avito.android.deep_linking.links;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u000f\u0010\u0011\u0012\u0013\u0014\u0015J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u0001\u0007\u0016\u0017\u0018\u0019\u001a\u001b\u001c¨\u0006\u001d"}, d2 = {"Lcom/avito/android/deep_linking/links/MyAdvertLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "c", "Ljava/lang/String;", "getItemId", "()Ljava/lang/String;", "itemId", "Activate", "Deactivate", "DeactivateBySoa", "Delete", BaseAnalyticKt.ANALYTIC_ACTION_EDIT, "Publish", "Restore", "Lcom/avito/android/deep_linking/links/MyAdvertLink$Edit;", "Lcom/avito/android/deep_linking/links/MyAdvertLink$Delete;", "Lcom/avito/android/deep_linking/links/MyAdvertLink$Restore;", "Lcom/avito/android/deep_linking/links/MyAdvertLink$Activate;", "Lcom/avito/android/deep_linking/links/MyAdvertLink$Deactivate;", "Lcom/avito/android/deep_linking/links/MyAdvertLink$Publish;", "Lcom/avito/android/deep_linking/links/MyAdvertLink$DeactivateBySoa;", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class MyAdvertLink extends DeepLink {
    @NotNull
    public final String c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016XD¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/avito/android/deep_linking/links/MyAdvertLink$Activate;", "Lcom/avito/android/deep_linking/links/MyAdvertLink;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "d", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", MessageMetaInfo.COLUMN_PATH, "", "e", "Z", "getShouldOpenApp", "()Z", "shouldOpenApp", "itemId", "<init>", "(Ljava/lang/String;Z)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Activate extends MyAdvertLink {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Activate> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String PATH = "/profile/item/activate";
        @NotNull
        public final String d = PATH;
        public final boolean e;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/deep_linking/links/MyAdvertLink$Activate$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/deep_linking/links/MyAdvertLink$Activate;", "CREATOR", "Landroid/os/Parcelable$Creator;", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, Activate> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Activate invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new Activate(a2.b.a.a.a.u2(parcel2, "readString()!!"), Parcels.readBool(parcel2));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Activate(@NotNull String str, boolean z) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "itemId");
            this.e = z;
        }

        @Override // com.avito.android.deep_linking.links.DeepLink
        @NotNull
        public String getPath() {
            return this.d;
        }

        public final boolean getShouldOpenApp() {
            return this.e;
        }

        @Override // com.avito.android.deep_linking.links.MyAdvertLink, com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            MyAdvertLink.super.writeToParcel(parcel, i);
            Parcels.writeBool(parcel, this.e);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/deep_linking/links/MyAdvertLink$Deactivate;", "Lcom/avito/android/deep_linking/links/MyAdvertLink;", "", "d", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", MessageMetaInfo.COLUMN_PATH, "itemId", "<init>", "(Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Deactivate extends MyAdvertLink {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Deactivate> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String PATH = "/profile/item/close";
        @NotNull
        public final String d = PATH;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/deep_linking/links/MyAdvertLink$Deactivate$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/deep_linking/links/MyAdvertLink$Deactivate;", "CREATOR", "Landroid/os/Parcelable$Creator;", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, Deactivate> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Deactivate invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new Deactivate(a2.b.a.a.a.u2(parcel2, "readString()!!"));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Deactivate(@NotNull String str) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "itemId");
        }

        @Override // com.avito.android.deep_linking.links.DeepLink
        @NotNull
        public String getPath() {
            return this.d;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016XD¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/avito/android/deep_linking/links/MyAdvertLink$DeactivateBySoa;", "Lcom/avito/android/deep_linking/links/MyAdvertLink;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "d", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", MessageMetaInfo.COLUMN_PATH, "e", "getReasonId", "reasonId", "itemId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class DeactivateBySoa extends MyAdvertLink {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<DeactivateBySoa> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String PATH = "/profile/item/close/soa";
        @NotNull
        public final String d = Publish.PATH;
        @NotNull
        public final String e;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/deep_linking/links/MyAdvertLink$DeactivateBySoa$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/deep_linking/links/MyAdvertLink$DeactivateBySoa;", "CREATOR", "Landroid/os/Parcelable$Creator;", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, DeactivateBySoa> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public DeactivateBySoa invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new DeactivateBySoa(a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeactivateBySoa(@NotNull String str, @NotNull String str2) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "itemId");
            Intrinsics.checkNotNullParameter(str2, "reasonId");
            this.e = str2;
        }

        @Override // com.avito.android.deep_linking.links.DeepLink
        @NotNull
        public String getPath() {
            return this.d;
        }

        @NotNull
        public final String getReasonId() {
            return this.e;
        }

        @Override // com.avito.android.deep_linking.links.MyAdvertLink, com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            MyAdvertLink.super.writeToParcel(parcel, i);
            parcel.writeString(this.e);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/deep_linking/links/MyAdvertLink$Delete;", "Lcom/avito/android/deep_linking/links/MyAdvertLink;", "", "d", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", MessageMetaInfo.COLUMN_PATH, "itemId", "<init>", "(Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Delete extends MyAdvertLink {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Delete> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String PATH = "/profile/item/delete";
        @NotNull
        public final String d = PATH;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/deep_linking/links/MyAdvertLink$Delete$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/deep_linking/links/MyAdvertLink$Delete;", "CREATOR", "Landroid/os/Parcelable$Creator;", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, Delete> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Delete invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new Delete(a2.b.a.a.a.u2(parcel2, "readString()!!"));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Delete(@NotNull String str) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "itemId");
        }

        @Override // com.avito.android.deep_linking.links.DeepLink
        @NotNull
        public String getPath() {
            return this.d;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B'\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016XD¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/avito/android/deep_linking/links/MyAdvertLink$Edit;", "Lcom/avito/android/deep_linking/links/MyAdvertLink;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "d", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", MessageMetaInfo.COLUMN_PATH, "f", "getFocusId", "focusId", "e", "getPostAction", "postAction", "itemId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Edit extends MyAdvertLink {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Edit> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String PATH = "/profile/item/edit";
        @NotNull
        public final String d;
        @Nullable
        public final String e;
        @Nullable
        public final String f;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/deep_linking/links/MyAdvertLink$Edit$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/deep_linking/links/MyAdvertLink$Edit;", "CREATOR", "Landroid/os/Parcelable$Creator;", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
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
                return new Edit(a2.b.a.a.a.u2(parcel2, "readString()!!"), parcel2.readString(), parcel2.readString());
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Edit(String str, String str2, String str3, int i, j jVar) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @Nullable
        public final String getFocusId() {
            return this.f;
        }

        @Override // com.avito.android.deep_linking.links.DeepLink
        @NotNull
        public String getPath() {
            return this.d;
        }

        @Nullable
        public final String getPostAction() {
            return this.e;
        }

        @Override // com.avito.android.deep_linking.links.MyAdvertLink, com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            MyAdvertLink.super.writeToParcel(parcel, i);
            parcel.writeString(this.e);
            parcel.writeString(this.f);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Edit(@NotNull String str, @Nullable String str2, @Nullable String str3) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "itemId");
            this.e = str2;
            this.f = str3;
            this.d = PATH;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/deep_linking/links/MyAdvertLink$Publish;", "Lcom/avito/android/deep_linking/links/MyAdvertLink;", "", "d", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", MessageMetaInfo.COLUMN_PATH, "itemId", "<init>", "(Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Publish extends MyAdvertLink {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Deactivate> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String PATH = "/profile/item/publish";
        @NotNull
        public final String d = PATH;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/deep_linking/links/MyAdvertLink$Publish$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/deep_linking/links/MyAdvertLink$Deactivate;", "CREATOR", "Landroid/os/Parcelable$Creator;", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, Deactivate> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Deactivate invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new Deactivate(a2.b.a.a.a.u2(parcel2, "readString()!!"));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Publish(@NotNull String str) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "itemId");
        }

        @Override // com.avito.android.deep_linking.links.DeepLink
        @NotNull
        public String getPath() {
            return this.d;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/deep_linking/links/MyAdvertLink$Restore;", "Lcom/avito/android/deep_linking/links/MyAdvertLink;", "", "d", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", MessageMetaInfo.COLUMN_PATH, "itemId", "<init>", "(Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Restore extends MyAdvertLink {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Restore> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final String d = "/profile/item/restore";

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/deep_linking/links/MyAdvertLink$Restore$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/deep_linking/links/MyAdvertLink$Restore;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, Restore> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Restore invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new Restore(a2.b.a.a.a.u2(parcel2, "readString()!!"));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Restore(@NotNull String str) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "itemId");
        }

        @Override // com.avito.android.deep_linking.links.DeepLink
        @NotNull
        public String getPath() {
            return this.d;
        }
    }

    public MyAdvertLink(String str, j jVar) {
        this.c = str;
    }

    @NotNull
    public final String getItemId() {
        return this.c;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.c);
    }
}
