package com.avito.android.bottom_navigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 !2\u00020\u00012\u00020\u0002:\b\"!#$%&'(R\u001c\u0010\b\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0014\u001a\u00020\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u001a\u001a\u00020\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001d\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007R\u001c\u0010 \u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007\u0001\u0007)*+,-./¨\u00060"}, d2 = {"Lcom/avito/android/bottom_navigation/NavigationTab;", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "Landroid/os/Parcelable;", "", "d", "I", "getTabContainerId", "()I", "tabContainerId", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "", "e", "Z", "getNeedAuthorization", "()Z", "needAuthorization", "Lcom/avito/android/bottom_navigation/AddButtonState;", "f", "Lcom/avito/android/bottom_navigation/AddButtonState;", "getAddButtonState", "()Lcom/avito/android/bottom_navigation/AddButtonState;", "addButtonState", "c", "getIcon", "icon", AuthSource.BOOKING_ORDER, "getTitle", "title", "Companion", "ADD", "FAVORITES", "MESSAGE", "PROFILE", "PROFILE_SETTINGS", ViewHierarchyConstants.SEARCH, "USER_ADVERTS", "Lcom/avito/android/bottom_navigation/NavigationTab$SEARCH;", "Lcom/avito/android/bottom_navigation/NavigationTab$FAVORITES;", "Lcom/avito/android/bottom_navigation/NavigationTab$ADD;", "Lcom/avito/android/bottom_navigation/NavigationTab$USER_ADVERTS;", "Lcom/avito/android/bottom_navigation/NavigationTab$MESSAGE;", "Lcom/avito/android/bottom_navigation/NavigationTab$PROFILE;", "Lcom/avito/android/bottom_navigation/NavigationTab$PROFILE_SETTINGS;", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
public abstract class NavigationTab implements NavigationTabSetItem, Parcelable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a;
    public final int b;
    public final int c;
    public final int d;
    public final boolean e;
    @NotNull
    public final AddButtonState f;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/bottom_navigation/NavigationTab$ADD;", "Lcom/avito/android/bottom_navigation/NavigationTab;", "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
    public static final class ADD extends NavigationTab implements NavigationTabControlSetItem {
        public static final Parcelable.Creator<ADD> CREATOR = new Creator();
        @NotNull
        public static final ADD INSTANCE = new ADD();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ADD> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ADD createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    return ADD.INSTANCE;
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ADD[] newArray(int i) {
                return new ADD[i];
            }
        }

        public ADD() {
            super("ADD", R.string.tab_add, 0, R.id.tab_add, true, AddButtonState.ACTIVE, null);
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/bottom_navigation/NavigationTab$Companion;", "", "", "Lcom/avito/android/bottom_navigation/NavigationTab;", "getAll", "()Ljava/util/List;", "<init>", "()V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final List<NavigationTab> getAll() {
            return CollectionsKt__CollectionsKt.listOf((Object[]) new NavigationTab[]{SEARCH.INSTANCE, FAVORITES.INSTANCE, ADD.INSTANCE, USER_ADVERTS.INSTANCE, MESSAGE.INSTANCE, PROFILE.INSTANCE, PROFILE_SETTINGS.INSTANCE});
        }

        public Companion(j jVar) {
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/bottom_navigation/NavigationTab$FAVORITES;", "Lcom/avito/android/bottom_navigation/NavigationTab;", "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
    public static final class FAVORITES extends NavigationTab implements NavigationTabControlSetItem, NavigationTabProfileRedesignTestSetItem {
        public static final Parcelable.Creator<FAVORITES> CREATOR = new Creator();
        @NotNull
        public static final FAVORITES INSTANCE = new FAVORITES();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<FAVORITES> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final FAVORITES createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    return FAVORITES.INSTANCE;
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final FAVORITES[] newArray(int i) {
                return new FAVORITES[i];
            }
        }

        public FAVORITES() {
            super("FAVORITES", R.string.tab_favorites, R.drawable.bg_bn_tab_favorites, R.id.tab_favorites, false, AddButtonState.SMALL, null);
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
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/bottom_navigation/NavigationTab$MESSAGE;", "Lcom/avito/android/bottom_navigation/NavigationTab;", "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
    public static final class MESSAGE extends NavigationTab implements NavigationTabControlSetItem, NavigationTabProfileRedesignTestSetItem {
        public static final Parcelable.Creator<MESSAGE> CREATOR = new Creator();
        @NotNull
        public static final MESSAGE INSTANCE = new MESSAGE();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<MESSAGE> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final MESSAGE createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    return MESSAGE.INSTANCE;
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final MESSAGE[] newArray(int i) {
                return new MESSAGE[i];
            }
        }

        public MESSAGE() {
            super("MESSAGE", R.string.tab_message, R.drawable.bg_bn_tab_message, R.id.tab_message, true, AddButtonState.SMALL, null);
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
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/bottom_navigation/NavigationTab$PROFILE;", "Lcom/avito/android/bottom_navigation/NavigationTab;", "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
    public static final class PROFILE extends NavigationTab implements NavigationTabControlSetItem {
        public static final Parcelable.Creator<PROFILE> CREATOR = new Creator();
        @NotNull
        public static final PROFILE INSTANCE = new PROFILE();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<PROFILE> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final PROFILE createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    return PROFILE.INSTANCE;
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final PROFILE[] newArray(int i) {
                return new PROFILE[i];
            }
        }

        public PROFILE() {
            super("PROFILE", R.string.tab_profile, R.drawable.bg_bn_tab_profile, R.id.tab_profile, false, AddButtonState.SMALL, null);
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
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/bottom_navigation/NavigationTab$PROFILE_SETTINGS;", "Lcom/avito/android/bottom_navigation/NavigationTab;", "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
    public static final class PROFILE_SETTINGS extends NavigationTab implements NavigationTabProfileRedesignTestSetItem {
        public static final Parcelable.Creator<PROFILE_SETTINGS> CREATOR = new Creator();
        @NotNull
        public static final PROFILE_SETTINGS INSTANCE = new PROFILE_SETTINGS();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<PROFILE_SETTINGS> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final PROFILE_SETTINGS createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    return PROFILE_SETTINGS.INSTANCE;
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final PROFILE_SETTINGS[] newArray(int i) {
                return new PROFILE_SETTINGS[i];
            }
        }

        public PROFILE_SETTINGS() {
            super("PROFILE_SETTINGS", R.string.tab_profile, R.drawable.bg_bn_tab_profile, R.id.tab_profile, false, AddButtonState.SMALL, null);
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
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/bottom_navigation/NavigationTab$SEARCH;", "Lcom/avito/android/bottom_navigation/NavigationTab;", "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
    public static final class SEARCH extends NavigationTab implements NavigationTabControlSetItem, NavigationTabProfileRedesignTestSetItem {
        public static final Parcelable.Creator<SEARCH> CREATOR = new Creator();
        @NotNull
        public static final SEARCH INSTANCE = new SEARCH();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<SEARCH> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final SEARCH createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    return SEARCH.INSTANCE;
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final SEARCH[] newArray(int i) {
                return new SEARCH[i];
            }
        }

        public SEARCH() {
            super(ViewHierarchyConstants.SEARCH, R.string.tab_search, R.drawable.bg_bn_tab_search, R.id.tab_search, false, AddButtonState.BIG, null);
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
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/bottom_navigation/NavigationTab$USER_ADVERTS;", "Lcom/avito/android/bottom_navigation/NavigationTab;", "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
    public static final class USER_ADVERTS extends NavigationTab implements NavigationTabProfileRedesignTestSetItem {
        public static final Parcelable.Creator<USER_ADVERTS> CREATOR = new Creator();
        @NotNull
        public static final USER_ADVERTS INSTANCE = new USER_ADVERTS();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<USER_ADVERTS> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final USER_ADVERTS createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    return USER_ADVERTS.INSTANCE;
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final USER_ADVERTS[] newArray(int i) {
                return new USER_ADVERTS[i];
            }
        }

        public USER_ADVERTS() {
            super("USER_ADVERTS", R.string.tab_user_adverts, 0, R.id.tab_user_adverts, true, AddButtonState.ACTIVE_SMALL, null);
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

    public NavigationTab(String str, int i, int i2, int i3, boolean z, AddButtonState addButtonState, j jVar) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = z;
        this.f = addButtonState;
    }

    @Override // com.avito.android.bottom_navigation.NavigationTabSetItem
    @NotNull
    public AddButtonState getAddButtonState() {
        return this.f;
    }

    @Override // com.avito.android.bottom_navigation.NavigationTabSetItem
    public int getIcon() {
        return this.c;
    }

    @Override // com.avito.android.bottom_navigation.NavigationTabSetItem
    @NotNull
    public String getName() {
        return this.a;
    }

    @Override // com.avito.android.bottom_navigation.NavigationTabSetItem
    public boolean getNeedAuthorization() {
        return this.e;
    }

    @Override // com.avito.android.bottom_navigation.NavigationTabSetItem
    public int getTabContainerId() {
        return this.d;
    }

    @Override // com.avito.android.bottom_navigation.NavigationTabSetItem
    public int getTitle() {
        return this.b;
    }
}
