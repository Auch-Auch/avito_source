package com.avito.android.service_subscription.subscription_new;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.service_subscription.PackageAttribute;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/service_subscription/subscription_new/PackageAttributeViewData;", "Landroid/os/Parcelable;", "<init>", "()V", "Monster", "Regular", "Lcom/avito/android/service_subscription/subscription_new/PackageAttributeViewData$Regular;", "Lcom/avito/android/service_subscription/subscription_new/PackageAttributeViewData$Monster;", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public abstract class PackageAttributeViewData implements Parcelable {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0002,-B1\u0012\u0006\u0010\u0019\u001a\u00020\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b'\u0010(B\u0011\b\u0016\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b'\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0019\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u0019\u0010\u001f\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u00020 8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006."}, d2 = {"Lcom/avito/android/service_subscription/subscription_new/PackageAttributeViewData$Monster;", "Lcom/avito/android/service_subscription/subscription_new/PackageAttributeViewData;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/service_subscription/subscription_new/PackageAttributeViewData$Monster$Details;", "d", "Lcom/avito/android/service_subscription/subscription_new/PackageAttributeViewData$Monster$Details;", "getDetails", "()Lcom/avito/android/service_subscription/subscription_new/PackageAttributeViewData$Monster$Details;", ErrorBundle.DETAIL_ENTRY, "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getCount", "()Ljava/lang/String;", "count", AuthSource.SEND_ABUSE, "getTitle", "title", "Lcom/avito/android/service_subscription/subscription_new/PackageAttributeViewData$Monster$Summary;", "c", "Lcom/avito/android/service_subscription/subscription_new/PackageAttributeViewData$Monster$Summary;", "getSummary", "()Lcom/avito/android/service_subscription/subscription_new/PackageAttributeViewData$Monster$Summary;", ErrorBundle.SUMMARY_ENTRY, "", "e", "Z", "isExpanded", "()Z", "setExpanded", "(Z)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/service_subscription/subscription_new/PackageAttributeViewData$Monster$Summary;Lcom/avito/android/service_subscription/subscription_new/PackageAttributeViewData$Monster$Details;Z)V", "Lcom/avito/android/remote/model/service_subscription/PackageAttribute$Monster;", "attribute", "(Lcom/avito/android/remote/model/service_subscription/PackageAttribute$Monster;)V", "Details", "Summary", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
    public static final class Monster extends PackageAttributeViewData {
        public static final Parcelable.Creator<Monster> CREATOR = new Creator();
        @NotNull
        public final String a;
        @Nullable
        public final String b;
        @NotNull
        public final Summary c;
        @NotNull
        public final Details d;
        public boolean e;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Monster> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Monster createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Monster(parcel.readString(), parcel.readString(), Summary.CREATOR.createFromParcel(parcel), Details.CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Monster[] newArray(int i) {
                return new Monster[i];
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0018B#\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/avito/android/service_subscription/subscription_new/PackageAttributeViewData$Monster$Details;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getLocations", "()Ljava/util/List;", "locations", "Lcom/avito/android/service_subscription/subscription_new/PackageAttributeViewData$Monster$Details$Subcategory;", AuthSource.SEND_ABUSE, "getSubcategories", "subcategories", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "Subcategory", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
        public static final class Details implements Parcelable {
            public static final Parcelable.Creator<Details> CREATOR = new Creator();
            @NotNull
            public final List<Subcategory> a;
            @NotNull
            public final List<String> b;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Details> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Details createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    int readInt = parcel.readInt();
                    ArrayList arrayList = new ArrayList(readInt);
                    while (readInt != 0) {
                        arrayList.add(Subcategory.CREATOR.createFromParcel(parcel));
                        readInt--;
                    }
                    return new Details(arrayList, parcel.createStringArrayList());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Details[] newArray(int i) {
                    return new Details[i];
                }
            }

            @Parcelize
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/service_subscription/subscription_new/PackageAttributeViewData$Monster$Details$Subcategory;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", AuthSource.BOOKING_ORDER, "getMicrocategories", "microcategories", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
            public static final class Subcategory implements Parcelable {
                public static final Parcelable.Creator<Subcategory> CREATOR = new Creator();
                @NotNull
                public final String a;
                @Nullable
                public final String b;

                @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                public static class Creator implements Parcelable.Creator<Subcategory> {
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Subcategory createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "in");
                        return new Subcategory(parcel.readString(), parcel.readString());
                    }

                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Subcategory[] newArray(int i) {
                        return new Subcategory[i];
                    }
                }

                public Subcategory(@NotNull String str, @Nullable String str2) {
                    Intrinsics.checkNotNullParameter(str, "title");
                    this.a = str;
                    this.b = str2;
                }

                @Override // android.os.Parcelable
                public int describeContents() {
                    return 0;
                }

                @Nullable
                public final String getMicrocategories() {
                    return this.b;
                }

                @NotNull
                public final String getTitle() {
                    return this.a;
                }

                @Override // android.os.Parcelable
                public void writeToParcel(@NotNull Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.writeString(this.a);
                    parcel.writeString(this.b);
                }
            }

            public Details(@NotNull List<Subcategory> list, @NotNull List<String> list2) {
                Intrinsics.checkNotNullParameter(list, "subcategories");
                Intrinsics.checkNotNullParameter(list2, "locations");
                this.a = list;
                this.b = list2;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @NotNull
            public final List<String> getLocations() {
                return this.b;
            }

            @NotNull
            public final List<Subcategory> getSubcategories() {
                return this.a;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Iterator n0 = a2.b.a.a.a.n0(this.a, parcel);
                while (n0.hasNext()) {
                    ((Subcategory) n0.next()).writeToParcel(parcel, 0);
                }
                parcel.writeStringList(this.b);
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/service_subscription/subscription_new/PackageAttributeViewData$Monster$Summary;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getSubcategories", "()Ljava/lang/String;", "subcategories", AuthSource.BOOKING_ORDER, "getLocations", "locations", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
        public static final class Summary implements Parcelable {
            public static final Parcelable.Creator<Summary> CREATOR = new Creator();
            @NotNull
            public final String a;
            @NotNull
            public final String b;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Summary> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Summary createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Summary(parcel.readString(), parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Summary[] newArray(int i) {
                    return new Summary[i];
                }
            }

            public Summary(@NotNull String str, @NotNull String str2) {
                Intrinsics.checkNotNullParameter(str, "subcategories");
                Intrinsics.checkNotNullParameter(str2, "locations");
                this.a = str;
                this.b = str2;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @NotNull
            public final String getLocations() {
                return this.b;
            }

            @NotNull
            public final String getSubcategories() {
                return this.a;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.a);
                parcel.writeString(this.b);
            }
        }

        /* compiled from: kotlin-style lambda group */
        public static final class a extends Lambda implements Function1<String, CharSequence> {
            public static final a b = new a(0);
            public static final a c = new a(1);
            public final /* synthetic */ int a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(int i) {
                super(1);
                this.a = i;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(String str) {
                int i = this.a;
                if (i == 0) {
                    String str2 = str;
                    Intrinsics.checkNotNullParameter(str2, "it");
                    return str2;
                } else if (i == 1) {
                    String str3 = str;
                    Intrinsics.checkNotNullParameter(str3, "it");
                    return str3;
                } else {
                    throw null;
                }
            }
        }

        public static final class b extends Lambda implements Function1<PackageAttribute.Monster.Subcategory, CharSequence> {
            public static final b a = new b();

            public b() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public CharSequence invoke(PackageAttribute.Monster.Subcategory subcategory) {
                PackageAttribute.Monster.Subcategory subcategory2 = subcategory;
                Intrinsics.checkNotNullParameter(subcategory2, "it");
                return subcategory2.getTitle();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Monster(@NotNull String str, @Nullable String str2, @NotNull Summary summary, @NotNull Details details, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(summary, ErrorBundle.SUMMARY_ENTRY);
            Intrinsics.checkNotNullParameter(details, ErrorBundle.DETAIL_ENTRY);
            this.a = str;
            this.b = str2;
            this.c = summary;
            this.d = details;
            this.e = z;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final String getCount() {
            return this.b;
        }

        @NotNull
        public final Details getDetails() {
            return this.d;
        }

        @NotNull
        public final Summary getSummary() {
            return this.c;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
        }

        public final boolean isExpanded() {
            return this.e;
        }

        public final void setExpanded(boolean z) {
            this.e = z;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            this.c.writeToParcel(parcel, 0);
            this.d.writeToParcel(parcel, 0);
            parcel.writeInt(this.e ? 1 : 0);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Monster(@org.jetbrains.annotations.NotNull com.avito.android.remote.model.service_subscription.PackageAttribute.Monster r19) {
            /*
                r18 = this;
                java.lang.String r0 = "attribute"
                r1 = r19
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
                java.lang.String r2 = r19.getTitle()
                java.lang.String r3 = r19.getCount()
                com.avito.android.service_subscription.subscription_new.PackageAttributeViewData$Monster$Summary r4 = new com.avito.android.service_subscription.subscription_new.PackageAttributeViewData$Monster$Summary
                java.util.List r5 = r19.getSubcategories()
                com.avito.android.service_subscription.subscription_new.PackageAttributeViewData$Monster$b r11 = com.avito.android.service_subscription.subscription_new.PackageAttributeViewData.Monster.b.a
                java.lang.String r6 = ", "
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r12 = 30
                r13 = 0
                java.lang.String r0 = kotlin.collections.CollectionsKt___CollectionsKt.joinToString$default(r5, r6, r7, r8, r9, r10, r11, r12, r13)
                java.util.List r5 = r19.getLocations()
                com.avito.android.service_subscription.subscription_new.PackageAttributeViewData$Monster$a r11 = com.avito.android.service_subscription.subscription_new.PackageAttributeViewData.Monster.a.b
                java.lang.String r6 = ", "
                java.lang.String r5 = kotlin.collections.CollectionsKt___CollectionsKt.joinToString$default(r5, r6, r7, r8, r9, r10, r11, r12, r13)
                r4.<init>(r0, r5)
                java.util.List r0 = r19.getSubcategories()
                java.util.ArrayList r5 = new java.util.ArrayList
                r6 = 10
                int r6 = t6.n.e.collectionSizeOrDefault(r0, r6)
                r5.<init>(r6)
                java.util.Iterator r0 = r0.iterator()
            L_0x0046:
                boolean r6 = r0.hasNext()
                if (r6 == 0) goto L_0x0077
                java.lang.Object r6 = r0.next()
                com.avito.android.remote.model.service_subscription.PackageAttribute$Monster$Subcategory r6 = (com.avito.android.remote.model.service_subscription.PackageAttribute.Monster.Subcategory) r6
                com.avito.android.service_subscription.subscription_new.PackageAttributeViewData$Monster$Details$Subcategory r7 = new com.avito.android.service_subscription.subscription_new.PackageAttributeViewData$Monster$Details$Subcategory
                java.lang.String r8 = r6.getTitle()
                java.util.List r9 = r6.getMicrocategories()
                if (r9 == 0) goto L_0x006f
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                com.avito.android.service_subscription.subscription_new.PackageAttributeViewData$Monster$a r15 = com.avito.android.service_subscription.subscription_new.PackageAttributeViewData.Monster.a.c
                r16 = 30
                r17 = 0
                java.lang.String r10 = ", "
                java.lang.String r6 = kotlin.collections.CollectionsKt___CollectionsKt.joinToString$default(r9, r10, r11, r12, r13, r14, r15, r16, r17)
                goto L_0x0070
            L_0x006f:
                r6 = 0
            L_0x0070:
                r7.<init>(r8, r6)
                r5.add(r7)
                goto L_0x0046
            L_0x0077:
                java.util.List r0 = r19.getLocations()
                com.avito.android.service_subscription.subscription_new.PackageAttributeViewData$Monster$Details r6 = new com.avito.android.service_subscription.subscription_new.PackageAttributeViewData$Monster$Details
                r6.<init>(r5, r0)
                r0 = 0
                r1 = r18
                r5 = r6
                r6 = r0
                r1.<init>(r2, r3, r4, r5, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.service_subscription.subscription_new.PackageAttributeViewData.Monster.<init>(com.avito.android.remote.model.service_subscription.PackageAttribute$Monster):void");
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001d\u0010\u001eB\u0011\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b\u001d\u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000fR\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000f¨\u0006\""}, d2 = {"Lcom/avito/android/service_subscription/subscription_new/PackageAttributeViewData$Regular;", "Lcom/avito/android/service_subscription/subscription_new/PackageAttributeViewData;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getSubtitle", "()Ljava/lang/String;", MessengerShareContentUtility.SUBTITLE, "e", "getExpiration", "expiration", "c", "getDescription", "description", "d", "getCount", "count", AuthSource.SEND_ABUSE, "getTitle", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/remote/model/service_subscription/PackageAttribute$Regular;", "attribute", "(Lcom/avito/android/remote/model/service_subscription/PackageAttribute$Regular;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
    public static final class Regular extends PackageAttributeViewData {
        public static final Parcelable.Creator<Regular> CREATOR = new Creator();
        @Nullable
        public final String a;
        @Nullable
        public final String b;
        @Nullable
        public final String c;
        @Nullable
        public final String d;
        @Nullable
        public final String e;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Regular> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Regular createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Regular(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Regular[] newArray(int i) {
                return new Regular[i];
            }
        }

        public Regular(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
            super(null);
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final String getCount() {
            return this.d;
        }

        @Nullable
        public final String getDescription() {
            return this.c;
        }

        @Nullable
        public final String getExpiration() {
            return this.e;
        }

        @Nullable
        public final String getSubtitle() {
            return this.b;
        }

        @Nullable
        public final String getTitle() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Regular(@NotNull PackageAttribute.Regular regular) {
            this(regular.getTitle(), regular.getSubtitle(), regular.getDescription(), regular.getCount(), regular.getExpiration());
            Intrinsics.checkNotNullParameter(regular, "attribute");
        }
    }

    public PackageAttributeViewData() {
    }

    public PackageAttributeViewData(j jVar) {
    }
}
