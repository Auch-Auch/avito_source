package com.avito.android.publish.slots.contact_info;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.SellerRating;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.text.AttributedText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.webrtc.PeerConnectionFactory;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b+\b\b\u0018\u00002\u00020\u0001:\u0001`B\u0001\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010 \u001a\u00020\u000b\u0012\b\b\u0002\u0010!\u001a\u00020\u000b\u0012\b\b\u0002\u0010\"\u001a\u00020\u000b\u0012\b\b\u0002\u0010#\u001a\u00020\u000b\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010%\u001a\u00020\u000b\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b^\u0010_J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\rJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0014\u0010\rJ\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ¢\u0001\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020\u000b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010%\u001a\u00020\u000b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0018HÆ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b*\u0010\u0004J\u0010\u0010,\u001a\u00020+HÖ\u0001¢\u0006\u0004\b,\u0010-J\u001a\u00100\u001a\u00020\u000b2\b\u0010/\u001a\u0004\u0018\u00010.HÖ\u0003¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020+HÖ\u0001¢\u0006\u0004\b2\u0010-J \u00107\u001a\u0002062\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020+HÖ\u0001¢\u0006\u0004\b7\u00108R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010\u0004\"\u0004\b<\u0010=R\u0019\u0010%\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010\rR\u0019\u0010#\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010?\u001a\u0004\b#\u0010\rR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bB\u0010:\u001a\u0004\bC\u0010\u0004\"\u0004\bD\u0010=R\u0019\u0010!\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010?\u001a\u0004\b!\u0010\rR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bF\u0010:\u001a\u0004\bG\u0010\u0004\"\u0004\bH\u0010=R$\u0010\u001f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010\n\"\u0004\bL\u0010MR\u0019\u0010 \u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010?\u001a\u0004\b \u0010\rR\u001b\u0010'\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010\u001aR\u001b\u0010$\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010\u0013R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bU\u0010:\u001a\u0004\bV\u0010\u0004\"\u0004\bW\u0010=R$\u0010&\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010\u0017\"\u0004\b[\u0010\\R\u0019\u0010\"\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b]\u0010?\u001a\u0004\b\"\u0010\r¨\u0006a"}, d2 = {"Lcom/avito/android/publish/slots/contact_info/ContactsData;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "Lcom/avito/android/remote/model/Image;", "component5", "()Lcom/avito/android/remote/model/Image;", "", "component6", "()Z", "component7", "component8", "component9", "Lcom/avito/android/remote/model/category_parameters/AddressParameter;", "component10", "()Lcom/avito/android/remote/model/category_parameters/AddressParameter;", "component11", "Lcom/avito/android/publish/slots/contact_info/ContactsData$AnonymousNumber;", "component12", "()Lcom/avito/android/publish/slots/contact_info/ContactsData$AnonymousNumber;", "Lcom/avito/android/remote/model/SellerRating;", "component13", "()Lcom/avito/android/remote/model/SellerRating;", "phone", "name", "email", "manager", "avatar", "isShop", "isCompany", "isIncomplete", "isPro", "addressParameter", "canHidePhone", "anonymousNumber", "rating", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;ZZZZLcom/avito/android/remote/model/category_parameters/AddressParameter;ZLcom/avito/android/publish/slots/contact_info/ContactsData$AnonymousNumber;Lcom/avito/android/remote/model/SellerRating;)Lcom/avito/android/publish/slots/contact_info/ContactsData;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "Ljava/lang/String;", "getEmail", "setEmail", "(Ljava/lang/String;)V", "k", "Z", "getCanHidePhone", "i", AuthSource.SEND_ABUSE, "getPhone", "setPhone", g.a, AuthSource.BOOKING_ORDER, "getName", "setName", "e", "Lcom/avito/android/remote/model/Image;", "getAvatar", "setAvatar", "(Lcom/avito/android/remote/model/Image;)V", "f", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/remote/model/SellerRating;", "getRating", "j", "Lcom/avito/android/remote/model/category_parameters/AddressParameter;", "getAddressParameter", "d", "getManager", "setManager", "l", "Lcom/avito/android/publish/slots/contact_info/ContactsData$AnonymousNumber;", "getAnonymousNumber", "setAnonymousNumber", "(Lcom/avito/android/publish/slots/contact_info/ContactsData$AnonymousNumber;)V", "h", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;ZZZZLcom/avito/android/remote/model/category_parameters/AddressParameter;ZLcom/avito/android/publish/slots/contact_info/ContactsData$AnonymousNumber;Lcom/avito/android/remote/model/SellerRating;)V", "AnonymousNumber", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ContactsData implements Parcelable {
    public static final Parcelable.Creator<ContactsData> CREATOR = new Creator();
    @Nullable
    public String a;
    @Nullable
    public String b;
    @Nullable
    public String c;
    @Nullable
    public String d;
    @Nullable
    public Image e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    @Nullable
    public final AddressParameter j;
    public final boolean k;
    @Nullable
    public AnonymousNumber l;
    @Nullable
    public final SellerRating m;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/publish/slots/contact_info/ContactsData$AnonymousNumber;", "Landroid/os/Parcelable;", "<init>", "()V", "Empty", PeerConnectionFactory.TRIAL_ENABLED, "Lcom/avito/android/publish/slots/contact_info/ContactsData$AnonymousNumber$Empty;", "Lcom/avito/android/publish/slots/contact_info/ContactsData$AnonymousNumber$Enabled;", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class AnonymousNumber implements Parcelable {

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/slots/contact_info/ContactsData$AnonymousNumber$Empty;", "Lcom/avito/android/publish/slots/contact_info/ContactsData$AnonymousNumber;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends AnonymousNumber {
            public static final Parcelable.Creator<Empty> CREATOR = new Creator();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Empty> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Empty createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return new Empty();
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Empty[] newArray(int i) {
                    return new Empty[i];
                }
            }

            public Empty() {
                super(null);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeInt(1);
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0011¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001e\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/publish/slots/contact_info/ContactsData$AnonymousNumber$Enabled;", "Lcom/avito/android/publish/slots/contact_info/ContactsData$AnonymousNumber;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/text/AttributedText;", "getDescription", "()Lcom/avito/android/remote/model/text/AttributedText;", "description", "", "c", "Z", "getValue", "()Z", "setValue", "(Z)V", "value", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "<init>", "(Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Z)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class Enabled extends AnonymousNumber {
            public static final Parcelable.Creator<Enabled> CREATOR = new Creator();
            @NotNull
            public final AttributedText a;
            @NotNull
            public final String b;
            public boolean c;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Enabled> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Enabled createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Enabled((AttributedText) parcel.readParcelable(Enabled.class.getClassLoader()), parcel.readString(), parcel.readInt() != 0);
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Enabled[] newArray(int i) {
                    return new Enabled[i];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Enabled(@NotNull AttributedText attributedText, @NotNull String str, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(attributedText, "description");
                Intrinsics.checkNotNullParameter(str, "title");
                this.a = attributedText;
                this.b = str;
                this.c = z;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @NotNull
            public final AttributedText getDescription() {
                return this.a;
            }

            @NotNull
            public final String getTitle() {
                return this.b;
            }

            public final boolean getValue() {
                return this.c;
            }

            public final void setValue(boolean z) {
                this.c = z;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeParcelable(this.a, i);
                parcel.writeString(this.b);
                parcel.writeInt(this.c ? 1 : 0);
            }
        }

        public AnonymousNumber() {
        }

        public AnonymousNumber(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ContactsData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactsData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ContactsData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (Image) parcel.readParcelable(ContactsData.class.getClassLoader()), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, (AddressParameter) parcel.readParcelable(ContactsData.class.getClassLoader()), parcel.readInt() != 0, (AnonymousNumber) parcel.readParcelable(ContactsData.class.getClassLoader()), (SellerRating) parcel.readParcelable(ContactsData.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactsData[] newArray(int i) {
            return new ContactsData[i];
        }
    }

    public ContactsData() {
        this(null, null, null, null, null, false, false, false, false, null, false, null, null, 8191, null);
    }

    public ContactsData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Image image, boolean z, boolean z2, boolean z3, boolean z4, @Nullable AddressParameter addressParameter, boolean z5, @Nullable AnonymousNumber anonymousNumber, @Nullable SellerRating sellerRating) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = image;
        this.f = z;
        this.g = z2;
        this.h = z3;
        this.i = z4;
        this.j = addressParameter;
        this.k = z5;
        this.l = anonymousNumber;
        this.m = sellerRating;
    }

    public static /* synthetic */ ContactsData copy$default(ContactsData contactsData, String str, String str2, String str3, String str4, Image image, boolean z, boolean z2, boolean z3, boolean z4, AddressParameter addressParameter, boolean z5, AnonymousNumber anonymousNumber, SellerRating sellerRating, int i2, Object obj) {
        return contactsData.copy((i2 & 1) != 0 ? contactsData.a : str, (i2 & 2) != 0 ? contactsData.b : str2, (i2 & 4) != 0 ? contactsData.c : str3, (i2 & 8) != 0 ? contactsData.d : str4, (i2 & 16) != 0 ? contactsData.e : image, (i2 & 32) != 0 ? contactsData.f : z, (i2 & 64) != 0 ? contactsData.g : z2, (i2 & 128) != 0 ? contactsData.h : z3, (i2 & 256) != 0 ? contactsData.i : z4, (i2 & 512) != 0 ? contactsData.j : addressParameter, (i2 & 1024) != 0 ? contactsData.k : z5, (i2 & 2048) != 0 ? contactsData.l : anonymousNumber, (i2 & 4096) != 0 ? contactsData.m : sellerRating);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final AddressParameter component10() {
        return this.j;
    }

    public final boolean component11() {
        return this.k;
    }

    @Nullable
    public final AnonymousNumber component12() {
        return this.l;
    }

    @Nullable
    public final SellerRating component13() {
        return this.m;
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
    public final Image component5() {
        return this.e;
    }

    public final boolean component6() {
        return this.f;
    }

    public final boolean component7() {
        return this.g;
    }

    public final boolean component8() {
        return this.h;
    }

    public final boolean component9() {
        return this.i;
    }

    @NotNull
    public final ContactsData copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Image image, boolean z, boolean z2, boolean z3, boolean z4, @Nullable AddressParameter addressParameter, boolean z5, @Nullable AnonymousNumber anonymousNumber, @Nullable SellerRating sellerRating) {
        return new ContactsData(str, str2, str3, str4, image, z, z2, z3, z4, addressParameter, z5, anonymousNumber, sellerRating);
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
        if (!(obj instanceof ContactsData)) {
            return false;
        }
        ContactsData contactsData = (ContactsData) obj;
        return Intrinsics.areEqual(this.a, contactsData.a) && Intrinsics.areEqual(this.b, contactsData.b) && Intrinsics.areEqual(this.c, contactsData.c) && Intrinsics.areEqual(this.d, contactsData.d) && Intrinsics.areEqual(this.e, contactsData.e) && this.f == contactsData.f && this.g == contactsData.g && this.h == contactsData.h && this.i == contactsData.i && Intrinsics.areEqual(this.j, contactsData.j) && this.k == contactsData.k && Intrinsics.areEqual(this.l, contactsData.l) && Intrinsics.areEqual(this.m, contactsData.m);
    }

    @Nullable
    public final AddressParameter getAddressParameter() {
        return this.j;
    }

    @Nullable
    public final AnonymousNumber getAnonymousNumber() {
        return this.l;
    }

    @Nullable
    public final Image getAvatar() {
        return this.e;
    }

    public final boolean getCanHidePhone() {
        return this.k;
    }

    @Nullable
    public final String getEmail() {
        return this.c;
    }

    @Nullable
    public final String getManager() {
        return this.d;
    }

    @Nullable
    public final String getName() {
        return this.b;
    }

    @Nullable
    public final String getPhone() {
        return this.a;
    }

    @Nullable
    public final SellerRating getRating() {
        return this.m;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Image image = this.e;
        int hashCode5 = (hashCode4 + (image != null ? image.hashCode() : 0)) * 31;
        boolean z = this.f;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (hashCode5 + i4) * 31;
        boolean z2 = this.g;
        if (z2) {
            z2 = true;
        }
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = z2 ? 1 : 0;
        int i11 = (i7 + i8) * 31;
        boolean z3 = this.h;
        if (z3) {
            z3 = true;
        }
        int i12 = z3 ? 1 : 0;
        int i13 = z3 ? 1 : 0;
        int i14 = z3 ? 1 : 0;
        int i15 = (i11 + i12) * 31;
        boolean z4 = this.i;
        if (z4) {
            z4 = true;
        }
        int i16 = z4 ? 1 : 0;
        int i17 = z4 ? 1 : 0;
        int i18 = z4 ? 1 : 0;
        int i19 = (i15 + i16) * 31;
        AddressParameter addressParameter = this.j;
        int hashCode6 = (i19 + (addressParameter != null ? addressParameter.hashCode() : 0)) * 31;
        boolean z5 = this.k;
        if (!z5) {
            i3 = z5 ? 1 : 0;
        }
        int i20 = (hashCode6 + i3) * 31;
        AnonymousNumber anonymousNumber = this.l;
        int hashCode7 = (i20 + (anonymousNumber != null ? anonymousNumber.hashCode() : 0)) * 31;
        SellerRating sellerRating = this.m;
        if (sellerRating != null) {
            i2 = sellerRating.hashCode();
        }
        return hashCode7 + i2;
    }

    public final boolean isCompany() {
        return this.g;
    }

    public final boolean isIncomplete() {
        return this.h;
    }

    public final boolean isPro() {
        return this.i;
    }

    public final boolean isShop() {
        return this.f;
    }

    public final void setAnonymousNumber(@Nullable AnonymousNumber anonymousNumber) {
        this.l = anonymousNumber;
    }

    public final void setAvatar(@Nullable Image image) {
        this.e = image;
    }

    public final void setEmail(@Nullable String str) {
        this.c = str;
    }

    public final void setManager(@Nullable String str) {
        this.d = str;
    }

    public final void setName(@Nullable String str) {
        this.b = str;
    }

    public final void setPhone(@Nullable String str) {
        this.a = str;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ContactsData(phone=");
        L.append(this.a);
        L.append(", name=");
        L.append(this.b);
        L.append(", email=");
        L.append(this.c);
        L.append(", manager=");
        L.append(this.d);
        L.append(", avatar=");
        L.append(this.e);
        L.append(", isShop=");
        L.append(this.f);
        L.append(", isCompany=");
        L.append(this.g);
        L.append(", isIncomplete=");
        L.append(this.h);
        L.append(", isPro=");
        L.append(this.i);
        L.append(", addressParameter=");
        L.append(this.j);
        L.append(", canHidePhone=");
        L.append(this.k);
        L.append(", anonymousNumber=");
        L.append(this.l);
        L.append(", rating=");
        L.append(this.m);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeParcelable(this.e, i2);
        parcel.writeInt(this.f ? 1 : 0);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeParcelable(this.j, i2);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeParcelable(this.l, i2);
        parcel.writeParcelable(this.m, i2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ContactsData(String str, String str2, String str3, String str4, Image image, boolean z, boolean z2, boolean z3, boolean z4, AddressParameter addressParameter, boolean z5, AnonymousNumber anonymousNumber, SellerRating sellerRating, int i2, j jVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : image, (i2 & 32) != 0 ? false : z, (i2 & 64) != 0 ? false : z2, (i2 & 128) != 0 ? false : z3, (i2 & 256) != 0 ? false : z4, (i2 & 512) != 0 ? null : addressParameter, (i2 & 1024) == 0 ? z5 : false, (i2 & 2048) != 0 ? null : anonymousNumber, (i2 & 4096) == 0 ? sellerRating : null);
    }
}
