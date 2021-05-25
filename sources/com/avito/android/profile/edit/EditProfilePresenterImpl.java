package com.avito.android.profile.edit;

import a2.a.a.b2.e1.m;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.EditAvatarActionEvent;
import com.avito.android.analytics.event.SaveAvatarActionEvent;
import com.avito.android.krop.util.Transformation;
import com.avito.android.profile.edit.EditProfileInteractor;
import com.avito.android.profile.edit.EditProfilePresenter;
import com.avito.android.profile.edit.refactoring.adapter.EditProfileItem;
import com.avito.android.profile.edit.refactoring.adapter.EditProfileItemsKt;
import com.avito.android.profile.edit.refactoring.adapter.item.AvatarItem;
import com.avito.android.profile.edit.refactoring.adapter.item.LocationItem;
import com.avito.android.profile.edit.refactoring.adapter.item.SubLocationItem;
import com.avito.android.profile.edit.refactoring.avatar.ProfileAvatar;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.NameIdEntity;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.Parcels;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001^BW\u0012\u0006\u0010?\u001a\u00020=\u0012\u0006\u0010V\u001a\u00020T\u0012\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000f09\u0012\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u000f09\u0012\u0006\u0010C\u001a\u00020@\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010G\u001a\u00020D\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010%¢\u0006\u0004\b\\\u0010]J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u001d\u0010\f\u001a\u00020\u0002*\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0011\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J.\u0010\u0017\u001a\u00020\u00022\u001d\u0010\u0016\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0014\u0012\u0004\u0012\u00020\u00020\u0013¢\u0006\u0002\b\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u0017\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u0017\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J!\u0010,\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u00020\u00022\u0006\u00103\u001a\u000202H\u0016¢\u0006\u0004\b4\u00105R\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u00106R\u0016\u00108\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u00107R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000f098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010LR\u0016\u0010M\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u00107R\u0016\u0010P\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010OR\u0018\u0010S\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010RR\u0016\u0010V\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010UR\u001e\u0010X\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010WR\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u000f098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010;¨\u0006_"}, d2 = {"Lcom/avito/android/profile/edit/EditProfilePresenterImpl;", "Lcom/avito/android/profile/edit/EditProfilePresenter;", "", "i", "()V", "", "d", "()Z", "h", "f", "Lcom/avito/android/profile/edit/EditProfileView;", "withAnimation", a2.g.r.g.a, "(Lcom/avito/android/profile/edit/EditProfileView;Z)V", "", "Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;", "targetItems", AuthSource.BOOKING_ORDER, "(Ljava/util/List;)V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "changes", "c", "(Lkotlin/jvm/functions/Function1;)V", "e", AuthSource.SEND_ABUSE, "view", "attachView", "(Lcom/avito/android/profile/edit/EditProfileView;)V", "onBackPressed", "detachView", "Lcom/avito/android/profile/edit/EditProfilePresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/profile/edit/EditProfilePresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Lcom/avito/android/krop/util/Transformation;", "transformation", "onAvatarSelected", "(Landroid/net/Uri;Lcom/avito/android/krop/util/Transformation;)V", "Lcom/avito/android/remote/model/Location;", "location", "onLocationSelected", "(Lcom/avito/android/remote/model/Location;)V", "Lcom/avito/android/remote/model/NameIdEntity;", "entity", "onSubLocationSelected", "(Lcom/avito/android/remote/model/NameIdEntity;)V", "Lcom/avito/android/profile/edit/EditProfilePresenter$Router;", "Z", "isProfileChanged", "Lio/reactivex/Observable;", "j", "Lio/reactivex/Observable;", "itemClicksStream", "Lcom/avito/android/analytics/Analytics;", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "l", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/util/SchedulersFactory;", "n", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/ErrorFormatter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/ErrorFormatter;", "errorFormatter", "Lcom/avito/android/profile/edit/EditProfileView;", "isAvatarPickerShown", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/profile/edit/EditProfilePresenterImpl$LocationSelecting;", "Lcom/avito/android/profile/edit/EditProfilePresenterImpl$LocationSelecting;", "locationSelecting", "Lcom/avito/android/profile/edit/EditProfileInteractor;", "Lcom/avito/android/profile/edit/EditProfileInteractor;", "interactor", "Ljava/util/List;", "items", "k", "itemChangedStream", "state", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/profile/edit/EditProfileInteractor;Lio/reactivex/Observable;Lio/reactivex/Observable;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/util/ErrorFormatter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/Kundle;)V", "LocationSelecting", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class EditProfilePresenterImpl implements EditProfilePresenter {
    public EditProfilePresenter.Router a;
    public EditProfileView b;
    public List<? extends EditProfileItem> c;
    public boolean d;
    public boolean e;
    public LocationSelecting f;
    public final CompositeDisposable g;
    public final Analytics h;
    public final EditProfileInteractor i;
    public final Observable<EditProfileItem> j;
    public final Observable<EditProfileItem> k;
    public final AdapterPresenter l;
    public final ErrorFormatter m;
    public final SchedulersFactory n;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/avito/android/profile/edit/EditProfilePresenterImpl$LocationSelecting;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getSubLocationId", "()Ljava/lang/String;", "subLocationId", "Lcom/avito/android/remote/model/Location;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Location;", "getLocation", "()Lcom/avito/android/remote/model/Location;", "location", "<init>", "(Lcom/avito/android/remote/model/Location;Ljava/lang/String;)V", "Companion", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class LocationSelecting implements Parcelable {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<LocationSelecting> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @Nullable
        public final Location a;
        @Nullable
        public final String b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/profile/edit/EditProfilePresenterImpl$LocationSelecting$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/profile/edit/EditProfilePresenterImpl$LocationSelecting;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(t6.r.a.j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, LocationSelecting> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public LocationSelecting invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                Object readValue = parcel2.readValue(Location.class.getClassLoader());
                if (!(readValue instanceof Location)) {
                    readValue = null;
                }
                return new LocationSelecting((Location) readValue, parcel2.readString());
            }
        }

        public LocationSelecting() {
            this(null, null, 3, null);
        }

        public LocationSelecting(@Nullable Location location, @Nullable String str) {
            this.a = location;
            this.b = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final Location getLocation() {
            return this.a;
        }

        @Nullable
        public final String getSubLocationId() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeValue(this.a);
            parcel.writeString(this.b);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ LocationSelecting(Location location, String str, int i, t6.r.a.j jVar) {
            this((i & 1) != 0 ? null : location, (i & 2) != 0 ? null : str);
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        public a(int i, Object obj, Object obj2) {
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                ((EditProfilePresenterImpl) this.b).h.track(new EditAvatarActionEvent(2));
                EditProfilePresenterImpl.access$changeAvatar((EditProfilePresenterImpl) this.b, null);
                EditProfilePresenterImpl.access$closeAvatarPicker((EditProfilePresenterImpl) this.b, (EditProfileView) this.c);
            } else if (i == 1) {
                EditProfilePresenterImpl.access$closeAvatarPicker((EditProfilePresenterImpl) this.b, (EditProfileView) this.c);
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Consumer<EditProfileItem> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public b(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(EditProfileItem editProfileItem) {
            int i = this.a;
            if (i == 0) {
                EditProfileItem editProfileItem2 = editProfileItem;
                Intrinsics.checkNotNullExpressionValue(editProfileItem2, "it");
                EditProfilePresenterImpl.access$onItemClick((EditProfilePresenterImpl) this.b, editProfileItem2);
            } else if (i == 1) {
                ((EditProfilePresenterImpl) this.b).c(new a2.a.a.b2.e1.i(editProfileItem));
                ((EditProfilePresenterImpl) this.b).e();
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class c<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public c(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                ((EditProfilePresenterImpl) this.b).f();
            } else if (i == 1) {
                EditProfilePresenterImpl.access$onSaveClick((EditProfilePresenterImpl) this.b);
            } else if (i == 2) {
                ((EditProfilePresenterImpl) this.b).onBackPressed();
            } else if (i != 3) {
                throw null;
            } else if (((EditProfilePresenterImpl) this.b).f != null) {
                ((EditProfilePresenterImpl) this.b).i();
            } else {
                ((EditProfilePresenterImpl) this.b).h();
            }
        }
    }

    public static final class d<T> implements Consumer<ProfileAvatar> {
        public final /* synthetic */ EditProfilePresenterImpl a;

        public d(EditProfilePresenterImpl editProfilePresenterImpl) {
            this.a = editProfilePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ProfileAvatar profileAvatar) {
            EditProfilePresenterImpl.access$changeAvatar(this.a, profileAvatar);
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public final /* synthetic */ EditProfilePresenterImpl a;

        public e(EditProfilePresenterImpl editProfilePresenterImpl) {
            this.a = editProfilePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            EditProfileView editProfileView = this.a.b;
            if (editProfileView != null) {
                editProfileView.showAvatarError();
            }
        }
    }

    public static final class f<T> implements Consumer<Disposable> {
        public final /* synthetic */ EditProfilePresenterImpl a;

        public f(EditProfilePresenterImpl editProfilePresenterImpl) {
            this.a = editProfilePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            EditProfileView editProfileView = this.a.b;
            if (editProfileView != null) {
                editProfileView.showProgress();
            }
        }
    }

    public static final class g<T> implements Consumer<List<? extends EditProfileItem>> {
        public final /* synthetic */ EditProfilePresenterImpl a;

        public g(EditProfilePresenterImpl editProfilePresenterImpl) {
            this.a = editProfilePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(List<? extends EditProfileItem> list) {
            List<? extends EditProfileItem> list2 = list;
            EditProfilePresenterImpl editProfilePresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(list2, "items");
            editProfilePresenterImpl.b(list2);
            this.a.a();
            EditProfileView editProfileView = this.a.b;
            if (editProfileView != null) {
                editProfileView.showContent();
            }
        }
    }

    public static final class h<T> implements Consumer<Throwable> {
        public final /* synthetic */ EditProfilePresenterImpl a;

        public h(EditProfilePresenterImpl editProfilePresenterImpl) {
            this.a = editProfilePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            EditProfileView editProfileView = this.a.b;
            if (editProfileView != null) {
                editProfileView.showError();
            }
        }
    }

    public static final class i<T> implements Consumer<Disposable> {
        public final /* synthetic */ EditProfilePresenterImpl a;

        public i(EditProfilePresenterImpl editProfilePresenterImpl) {
            this.a = editProfilePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            EditProfileView editProfileView = this.a.b;
            if (editProfileView != null) {
                editProfileView.showProgress();
            }
            EditProfileView editProfileView2 = this.a.b;
            if (editProfileView2 != null) {
                editProfileView2.setSaveEnabled(false);
            }
        }
    }

    public static final class j implements Action {
        public final /* synthetic */ EditProfilePresenterImpl a;

        public j(EditProfilePresenterImpl editProfilePresenterImpl) {
            this.a = editProfilePresenterImpl;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.a.a();
        }
    }

    public static final class k<T> implements Consumer<EditProfileInteractor.LocationItems> {
        public final /* synthetic */ EditProfilePresenterImpl a;

        public k(EditProfilePresenterImpl editProfilePresenterImpl) {
            this.a = editProfilePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(EditProfileInteractor.LocationItems locationItems) {
            EditProfileInteractor.LocationItems locationItems2 = locationItems;
            this.a.f = null;
            EditProfilePresenterImpl editProfilePresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(locationItems2, "it");
            EditProfilePresenterImpl.access$updateLocationItems(editProfilePresenterImpl, locationItems2);
            EditProfileView editProfileView = this.a.b;
            if (editProfileView != null) {
                editProfileView.showContent();
            }
        }
    }

    public static final class l<T> implements Consumer<Throwable> {
        public final /* synthetic */ EditProfilePresenterImpl a;

        public l(EditProfilePresenterImpl editProfilePresenterImpl) {
            this.a = editProfilePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            EditProfileView editProfileView = this.a.b;
            if (editProfileView != null) {
                editProfileView.showError();
            }
        }
    }

    public EditProfilePresenterImpl(@NotNull Analytics analytics, @NotNull EditProfileInteractor editProfileInteractor, @NotNull Observable<EditProfileItem> observable, @NotNull Observable<EditProfileItem> observable2, @NotNull AdapterPresenter adapterPresenter, @NotNull ErrorFormatter errorFormatter, @NotNull SchedulersFactory schedulersFactory, @Nullable Kundle kundle) {
        Boolean bool;
        Boolean bool2;
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(editProfileInteractor, "interactor");
        Intrinsics.checkNotNullParameter(observable, "itemClicksStream");
        Intrinsics.checkNotNullParameter(observable2, "itemChangedStream");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.h = analytics;
        this.i = editProfileInteractor;
        this.j = observable;
        this.k = observable2;
        this.l = adapterPresenter;
        this.m = errorFormatter;
        this.n = schedulersFactory;
        LocationSelecting locationSelecting = null;
        this.c = kundle != null ? kundle.getParcelableList("items") : null;
        boolean z = false;
        this.d = (kundle == null || (bool2 = kundle.getBoolean("profile_changed")) == null) ? false : bool2.booleanValue();
        if (!(kundle == null || (bool = kundle.getBoolean("avatar_picker_shown")) == null)) {
            z = bool.booleanValue();
        }
        this.e = z;
        this.f = kundle != null ? (LocationSelecting) kundle.getParcelable("location_selecting") : locationSelecting;
        this.g = new CompositeDisposable();
    }

    public static final void access$applyErrors(EditProfilePresenterImpl editProfilePresenterImpl, Map map) {
        List<EditProfileItem> relateErrors;
        List<? extends EditProfileItem> list = editProfilePresenterImpl.c;
        if (list != null && (relateErrors = EditProfileItemsKt.relateErrors(list, map)) != null) {
            editProfilePresenterImpl.b(relateErrors);
        }
    }

    public static final void access$changeAvatar(EditProfilePresenterImpl editProfilePresenterImpl, ProfileAvatar profileAvatar) {
        List<? extends EditProfileItem> list = editProfilePresenterImpl.c;
        if (list != null) {
            AvatarItem changeAvatar = ((AvatarItem) EditProfileItemsKt.getItem(list, 3)).changeAvatar(profileAvatar);
            changeAvatar.setChanged(true);
            List<? extends EditProfileItem> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
            EditProfileItemsKt.replaceItem(mutableList, changeAvatar);
            editProfilePresenterImpl.b(mutableList);
            editProfilePresenterImpl.e();
        }
    }

    public static final void access$closeAvatarPicker(EditProfilePresenterImpl editProfilePresenterImpl, EditProfileView editProfileView) {
        editProfilePresenterImpl.e = false;
        editProfileView.hideAvatarPicker();
    }

    public static final void access$onItemClick(EditProfilePresenterImpl editProfilePresenterImpl, EditProfileItem editProfileItem) {
        Objects.requireNonNull(editProfilePresenterImpl);
        if (editProfileItem instanceof SubLocationItem) {
            EditProfilePresenter.Router router = editProfilePresenterImpl.a;
            if (router != null) {
                SubLocationItem subLocationItem = (SubLocationItem) editProfileItem;
                router.openSubLocationScreen(subLocationItem.getTitle(), editProfilePresenterImpl.i.getSubLocations(), subLocationItem.getSubLocation());
            }
        } else if (editProfileItem instanceof LocationItem) {
            EditProfilePresenter.Router router2 = editProfilePresenterImpl.a;
            if (router2 != null) {
                router2.openLocationScreen(((LocationItem) EditProfileItemsKt.getItem(editProfilePresenterImpl.c, 1)).getLocation());
            }
        } else if (!(editProfileItem instanceof AvatarItem)) {
        } else {
            if (((AvatarItem) editProfileItem).getAvatar() == null) {
                editProfilePresenterImpl.f();
                return;
            }
            EditProfileView editProfileView = editProfilePresenterImpl.b;
            if (editProfileView != null) {
                editProfilePresenterImpl.g(editProfileView, true);
            }
        }
    }

    public static final void access$onSaveClick(EditProfilePresenterImpl editProfilePresenterImpl) {
        List<? extends EditProfileItem> list = editProfilePresenterImpl.c;
        if (list != null) {
            EditProfileView editProfileView = editProfilePresenterImpl.b;
            if (editProfileView != null) {
                editProfileView.hideKeyboard();
            }
            CompositeDisposable compositeDisposable = editProfilePresenterImpl.g;
            Disposable subscribe = editProfilePresenterImpl.i.saveItems(list).observeOn(editProfilePresenterImpl.n.mainThread()).doOnSubscribe(new a2.a.a.b2.e1.j(editProfilePresenterImpl)).doAfterTerminate(new a2.a.a.b2.e1.k(editProfilePresenterImpl)).subscribe(new a2.a.a.b2.e1.l(editProfilePresenterImpl));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.saveItems(ite…          }\n            }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            if (editProfilePresenterImpl.d()) {
                editProfilePresenterImpl.h.track(new SaveAvatarActionEvent(2));
            }
        }
    }

    public static final void access$updateLocationItems(EditProfilePresenterImpl editProfilePresenterImpl, EditProfileInteractor.LocationItems locationItems) {
        Objects.requireNonNull(editProfilePresenterImpl);
        editProfilePresenterImpl.c(new m(locationItems));
        editProfilePresenterImpl.e();
    }

    public final void a() {
        EditProfileView editProfileView = this.b;
        if (editProfileView != null) {
            editProfileView.setSaveEnabled(this.d || this.i.needToSave());
        }
    }

    @Override // com.avito.android.profile.edit.EditProfilePresenter
    public void attachRouter(@NotNull EditProfilePresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.a = router;
        if (this.f != null) {
            EditProfileView editProfileView = this.b;
            if (editProfileView != null) {
                editProfileView.showError();
                return;
            }
            return;
        }
        h();
    }

    @Override // com.avito.android.profile.edit.EditProfilePresenter
    public void attachView(@NotNull EditProfileView editProfileView) {
        Intrinsics.checkNotNullParameter(editProfileView, "view");
        this.b = editProfileView;
        CompositeDisposable compositeDisposable = this.g;
        Disposable subscribe = this.j.subscribe(new b(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "itemClicksStream.subscri…onItemClick(it)\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.g;
        Disposable subscribe2 = this.k.subscribe(new b(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "itemChangedStream.subscr…rofileChanged()\n        }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.g;
        Disposable subscribe3 = editProfileView.deleteAvatarClicks().subscribe(new a(0, this, editProfileView));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.deleteAvatarClicks(…eAvatarPicker()\n        }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.g;
        Disposable subscribe4 = editProfileView.takePhotoClicks().subscribe(new c(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "view.takePhotoClicks().s…  onTakePhoto()\n        }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        CompositeDisposable compositeDisposable5 = this.g;
        Disposable subscribe5 = editProfileView.pickerEmptySpaceClicks().subscribe(new a(1, this, editProfileView));
        Intrinsics.checkNotNullExpressionValue(subscribe5, "view.pickerEmptySpaceCli…eAvatarPicker()\n        }");
        DisposableKt.plusAssign(compositeDisposable5, subscribe5);
        CompositeDisposable compositeDisposable6 = this.g;
        Disposable subscribe6 = editProfileView.saveClicks().subscribe(new c(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe6, "view.saveClicks().subscr…  onSaveClick()\n        }");
        DisposableKt.plusAssign(compositeDisposable6, subscribe6);
        CompositeDisposable compositeDisposable7 = this.g;
        Disposable subscribe7 = editProfileView.navigationClicks().subscribe(new c(2, this));
        Intrinsics.checkNotNullExpressionValue(subscribe7, "view.navigationClicks().…onBackPressed()\n        }");
        DisposableKt.plusAssign(compositeDisposable7, subscribe7);
        CompositeDisposable compositeDisposable8 = this.g;
        Disposable subscribe8 = editProfileView.refreshClicks().subscribe(new c(3, this));
        Intrinsics.checkNotNullExpressionValue(subscribe8, "view.refreshClicks().sub…)\n            }\n        }");
        DisposableKt.plusAssign(compositeDisposable8, subscribe8);
        if (this.e) {
            g(editProfileView, false);
        }
    }

    public final void b(List<? extends EditProfileItem> list) {
        this.c = list;
        a2.b.a.a.a.s1(list, this.l);
        EditProfileView editProfileView = this.b;
        if (editProfileView != null) {
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            int i2 = 0;
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if (next.hasBottomDivider()) {
                    EditProfileItem editProfileItem = (EditProfileItem) CollectionsKt___CollectionsKt.getOrNull(list, i3);
                    if (editProfileItem != null) {
                        z = editProfileItem.hasTopDivider();
                    }
                    if (z) {
                        arrayList.add(Integer.valueOf(i2));
                        i2 = i3;
                    }
                }
                i2 = -1;
                arrayList.add(Integer.valueOf(i2));
                i2 = i3;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Object next2 = it2.next();
                if (((Number) next2).intValue() != -1) {
                    arrayList2.add(next2);
                }
            }
            editProfileView.setDividers(arrayList2);
        }
    }

    public final void c(Function1<? super List<EditProfileItem>, Unit> function1) {
        List<? extends EditProfileItem> list = this.c;
        if (list != null) {
            List<? extends EditProfileItem> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
            function1.invoke(mutableList);
            if (!Intrinsics.areEqual(mutableList, list)) {
                b(mutableList);
            }
        }
    }

    public final boolean d() {
        List<? extends EditProfileItem> list = this.c;
        AvatarItem avatarItem = list != null ? (AvatarItem) EditProfileItemsKt.findItem(list, 3) : null;
        if (avatarItem != null) {
            return avatarItem.isChanged();
        }
        return false;
    }

    @Override // com.avito.android.profile.edit.EditProfilePresenter
    public void detachRouter() {
        this.a = null;
    }

    @Override // com.avito.android.profile.edit.EditProfilePresenter
    public void detachView() {
        this.g.clear();
        this.b = null;
    }

    public final void e() {
        this.d = true;
        a();
    }

    public final void f() {
        EditProfileView editProfileView = this.b;
        if (editProfileView != null) {
            this.e = false;
            editProfileView.hideAvatarPicker();
        }
        EditProfilePresenter.Router router = this.a;
        if (router != null) {
            router.openCameraScreen();
        }
        this.h.track(new EditAvatarActionEvent(3));
    }

    public final void g(EditProfileView editProfileView, boolean z) {
        boolean z2 = true;
        this.e = true;
        editProfileView.hideKeyboard();
        this.h.track(new EditAvatarActionEvent(1));
        if (((AvatarItem) EditProfileItemsKt.getItem(this.c, 3)).getAvatar() == null) {
            z2 = false;
        }
        editProfileView.showAvatarPicker(z2, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000f, code lost:
        if (r1 != null) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h() {
        /*
            r4 = this;
            io.reactivex.disposables.CompositeDisposable r0 = r4.g
            java.util.List<? extends com.avito.android.profile.edit.refactoring.adapter.EditProfileItem> r1 = r4.c
            if (r1 == 0) goto L_0x0012
            io.reactivex.Observable r1 = io.reactivex.Observable.just(r1)
            java.lang.String r2 = "Observable.just(this)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            if (r1 == 0) goto L_0x0012
            goto L_0x0022
        L_0x0012:
            com.avito.android.profile.edit.EditProfileInteractor r1 = r4.i
            io.reactivex.Observable r1 = r1.loadItems()
            com.avito.android.util.SchedulersFactory r2 = r4.n
            io.reactivex.Scheduler r2 = r2.mainThread()
            io.reactivex.Observable r1 = r1.observeOn(r2)
        L_0x0022:
            com.avito.android.profile.edit.EditProfilePresenterImpl$f r2 = new com.avito.android.profile.edit.EditProfilePresenterImpl$f
            r2.<init>(r4)
            io.reactivex.Observable r1 = r1.doOnSubscribe(r2)
            com.avito.android.profile.edit.EditProfilePresenterImpl$g r2 = new com.avito.android.profile.edit.EditProfilePresenterImpl$g
            r2.<init>(r4)
            com.avito.android.profile.edit.EditProfilePresenterImpl$h r3 = new com.avito.android.profile.edit.EditProfilePresenterImpl$h
            r3.<init>(r4)
            io.reactivex.disposables.Disposable r1 = r1.subscribe(r2, r3)
            java.lang.String r2 = "loadItems()\n            …howError()\n            })"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.profile.edit.EditProfilePresenterImpl.h():void");
    }

    public final void i() {
        LocationSelecting locationSelecting = this.f;
        if (locationSelecting != null) {
            this.i.updateLocation(locationSelecting.getLocation(), locationSelecting.getSubLocationId()).observeOn(this.n.mainThread()).doOnSubscribe(new i(this)).doAfterTerminate(new j(this)).subscribe(new k(this), new l(this));
        }
    }

    @Override // com.avito.android.profile.edit.EditProfilePresenter
    public void onAvatarSelected(@NotNull Uri uri, @Nullable Transformation transformation) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        CompositeDisposable compositeDisposable = this.g;
        Disposable subscribe = this.i.wrapAvatar(uri, transformation).observeOn(this.n.mainThread()).subscribe(new d(this), new e(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.wrapAvatar(ur…tarError()\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.profile.edit.EditProfilePresenter
    public void onBackPressed() {
        if (this.e) {
            EditProfileView editProfileView = this.b;
            if (editProfileView != null) {
                this.e = false;
                editProfileView.hideAvatarPicker();
                return;
            }
            return;
        }
        EditProfileView editProfileView2 = this.b;
        if (editProfileView2 != null) {
            editProfileView2.hideKeyboard();
        }
        EditProfilePresenter.Router router = this.a;
        if (router != null) {
            EditProfilePresenter.Router.DefaultImpls.close$default(router, false, 1, null);
        }
        if (d()) {
            this.h.track(new SaveAvatarActionEvent(1));
        }
    }

    @Override // com.avito.android.profile.edit.EditProfilePresenter
    public void onLocationSelected(@NotNull Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        this.f = new LocationSelecting(location, null, 2, null);
        i();
    }

    @Override // com.avito.android.profile.edit.EditProfilePresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelableList("items", this.c).putBoolean("avatar_picker_shown", Boolean.valueOf(this.e)).putBoolean("profile_changed", Boolean.valueOf(this.d)).putParcelable("location_selecting", this.f);
    }

    @Override // com.avito.android.profile.edit.EditProfilePresenter
    public void onSubLocationSelected(@NotNull NameIdEntity nameIdEntity) {
        Intrinsics.checkNotNullParameter(nameIdEntity, "entity");
        this.f = new LocationSelecting(null, nameIdEntity.getId(), 1, null);
        i();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EditProfilePresenterImpl(Analytics analytics, EditProfileInteractor editProfileInteractor, Observable observable, Observable observable2, AdapterPresenter adapterPresenter, ErrorFormatter errorFormatter, SchedulersFactory schedulersFactory, Kundle kundle, int i2, t6.r.a.j jVar) {
        this(analytics, editProfileInteractor, observable, observable2, adapterPresenter, errorFormatter, schedulersFactory, (i2 & 128) != 0 ? null : kundle);
    }
}
