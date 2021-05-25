package com.avito.android.publish.new_advert;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.bottom_navigation.NavigationTabControlSetItem;
import com.avito.android.bottom_navigation.NavigationTabProfileRedesignTestSetItem;
import com.avito.android.bottom_navigation.ui.fragment.ShouldRetainCalledFrom;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b)\u0010*J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001b\u001a\u00020\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\"\u001a\u00020\u00108\u0016@\u0016XD¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014R\u001c\u0010(\u001a\u00020#8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/avito/android/publish/new_advert/AddFragmentData;", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "Lcom/avito/android/bottom_navigation/ui/fragment/ShouldRetainCalledFrom;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "calledFrom", "copyWithCalledFrom", "(Ljava/lang/String;)Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "", "d", "Z", "getShowNavigation", "()Z", "showNavigation", "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "getTabInControl", "()Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "tabInControl", "e", "Ljava/lang/String;", "getCalledFrom", "()Ljava/lang/String;", "c", "getNeedAuthorization", "needAuthorization", "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "getTabInProfileTest", "()Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "tabInProfileTest", "<init>", "(Ljava/lang/String;)V", "Companion", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class AddFragmentData implements TabFragmentFactory.Data, ShouldRetainCalledFrom {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AddFragmentData> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final NavigationTabControlSetItem a = NavigationTab.ADD.INSTANCE;
    @NotNull
    public final NavigationTabProfileRedesignTestSetItem b = NavigationTab.USER_ADVERTS.INSTANCE;
    public final boolean c = true;
    public final boolean d = true;
    @Nullable
    public final String e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/publish/new_advert/AddFragmentData$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/publish/new_advert/AddFragmentData;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, AddFragmentData> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public AddFragmentData invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new AddFragmentData(parcel2.readString());
        }
    }

    public AddFragmentData(@Nullable String str) {
        this.e = str;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.ShouldRetainCalledFrom
    @NotNull
    public TabFragmentFactory.Data copyWithCalledFrom(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "calledFrom");
        return new AddFragmentData(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getCalledFrom() {
        return this.e;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    public boolean getNeedAuthorization() {
        return this.c;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    public boolean getShowNavigation() {
        return this.d;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    @NotNull
    public NavigationTabControlSetItem getTabInControl() {
        return this.a;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    @NotNull
    public NavigationTabProfileRedesignTestSetItem getTabInProfileTest() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.e);
    }
}
