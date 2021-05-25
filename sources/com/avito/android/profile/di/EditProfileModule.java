package com.avito.android.profile.di;

import a2.b.a.a.a;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.account.SessionChangeTracker;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.PerActivity;
import com.avito.android.di.module.SessionUpdateTrackerModule;
import com.avito.android.photo.BitmapFileProvider;
import com.avito.android.photo.BitmapFileProviderImpl;
import com.avito.android.photo_picker.BitmapTransformer;
import com.avito.android.photo_picker.BitmapTransformerImpl;
import com.avito.android.photo_picker.ExifExtraDataSerializer;
import com.avito.android.photo_picker.ExifExtraDataSerializerImpl;
import com.avito.android.photo_picker.legacy.api.UploadConverterProvider;
import com.avito.android.photo_picker.legacy.api.UploadConverterProviderImpl;
import com.avito.android.profile.edit.CameraDelegate;
import com.avito.android.profile.edit.EditProfileInteractor;
import com.avito.android.profile.edit.EditProfileInteractorImpl;
import com.avito.android.profile.edit.EditProfilePresenter;
import com.avito.android.profile.edit.EditProfilePresenterImpl;
import com.avito.android.profile.edit.EditProfileResourceProvider;
import com.avito.android.profile.edit.EditProfileResourceProviderImpl;
import com.avito.android.profile.edit.LocationInteractor;
import com.avito.android.profile.edit.LocationInteractorImpl;
import com.avito.android.profile.edit.LocationInteractorResourceProvider;
import com.avito.android.profile.edit.LocationInteractorResourceProviderImpl;
import com.avito.android.profile.edit.PhotoPickerCameraDelegate;
import com.avito.android.profile.edit.SaveProfileInteractor;
import com.avito.android.profile.edit.SaveProfileInteractorImpl;
import com.avito.android.profile.edit.adapter.AvatarItemBlueprint;
import com.avito.android.profile.edit.adapter.ErrorLabelItemBlueprint;
import com.avito.android.profile.edit.adapter.InputItemBlueprint;
import com.avito.android.profile.edit.adapter.LocationItemBlueprint;
import com.avito.android.profile.edit.adapter.LocationItemPresenter;
import com.avito.android.profile.edit.adapter.LocationItemPresenterImpl;
import com.avito.android.profile.edit.adapter.PhoneInputItemBlueprint;
import com.avito.android.profile.edit.adapter.SubLocationItemBlueprint;
import com.avito.android.profile.edit.adapter.TextItemBlueprint;
import com.avito.android.profile.edit.avatar.AvatarInteractor;
import com.avito.android.profile.edit.avatar.AvatarInteractorImpl;
import com.avito.android.profile.edit.refactoring.adapter.AvatarItemPresenter;
import com.avito.android.profile.edit.refactoring.adapter.AvatarItemPresenterImpl;
import com.avito.android.profile.edit.refactoring.adapter.EditProfileContentsComparator;
import com.avito.android.profile.edit.refactoring.adapter.EditProfileItem;
import com.avito.android.profile.edit.refactoring.adapter.ErrorLabelItemPresenter;
import com.avito.android.profile.edit.refactoring.adapter.ErrorLabelItemPresenterImpl;
import com.avito.android.profile.edit.refactoring.adapter.InputItemPresenter;
import com.avito.android.profile.edit.refactoring.adapter.InputItemPresenterImpl;
import com.avito.android.profile.edit.refactoring.adapter.PhoneInputItemPresenter;
import com.avito.android.profile.edit.refactoring.adapter.PhoneInputItemPresenterImpl;
import com.avito.android.profile.edit.refactoring.adapter.SubLocationItemPresenter;
import com.avito.android.profile.edit.refactoring.adapter.SubLocationItemPresenterImpl;
import com.avito.android.profile.edit.refactoring.adapter.TextItemPresenter;
import com.avito.android.profile.edit.refactoring.adapter.TextItemPresenterImpl;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator;
import com.avito.android.recycler.data_aware.SimpleEqualityComparator;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.Kundle;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.PrivatePhotosStorage;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000à\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001:\u0006¼\u0001½\u0001¾\u0001B\u000b\b\u0002¢\u0006\u0006\bº\u0001\u0010»\u0001JC\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010JC\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\"\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\"\u0010#J7\u0010)\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b)\u0010*J;\u00101\u001a\u00020\u00112\u0006\u0010,\u001a\u00020+2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\b2\u0006\u0010/\u001a\u00020.2\n\b\u0001\u00100\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u00020.2\u0006\u00104\u001a\u000203H\u0007¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u00020\n2\u0006\u00104\u001a\u000203H\u0001¢\u0006\u0004\b7\u00108J\u0017\u0010<\u001a\u00020\u00172\u0006\u00104\u001a\u000203H\u0001¢\u0006\u0004\b:\u0010;J\u001f\u0010B\u001a\u00020A2\u0006\u0010>\u001a\u00020=2\u0006\u0010@\u001a\u00020?H\u0007¢\u0006\u0004\bB\u0010CJ'\u0010J\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020F2\u0006\u0010I\u001a\u00020HH\u0007¢\u0006\u0004\bJ\u0010KJ\u0017\u0010N\u001a\u00020F2\u0006\u0010M\u001a\u00020LH\u0007¢\u0006\u0004\bN\u0010OJ'\u0010T\u001a\u00020D2\u0006\u0010Q\u001a\u00020P2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010S\u001a\u00020RH\u0007¢\u0006\u0004\bT\u0010UJ\u001f\u0010V\u001a\u00020 2\u0006\u0010Q\u001a\u00020P2\u0006\u0010S\u001a\u00020RH\u0007¢\u0006\u0004\bV\u0010WJ/\u0010]\u001a\u00020\u00062\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020Y0X2\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0006\u0010\\\u001a\u00020[H\u0007¢\u0006\u0004\b]\u0010^J\u0017\u0010a\u001a\u00020[2\u0006\u0010`\u001a\u00020_H\u0007¢\u0006\u0004\ba\u0010bJ\u0017\u0010e\u001a\u00020\u00062\u0006\u0010d\u001a\u00020cH\u0007¢\u0006\u0004\be\u0010fJ\u000f\u0010g\u001a\u00020_H\u0007¢\u0006\u0004\bg\u0010hJ\u001f\u0010j\u001a\u00020i2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010d\u001a\u00020cH\u0007¢\u0006\u0004\bj\u0010kJ\u0017\u0010m\u001a\u00020Y2\u0006\u0010l\u001a\u00020iH\u0007¢\u0006\u0004\bm\u0010nJG\u0010\u001a\u00020c2\u0006\u0010p\u001a\u00020o2\u0006\u0010r\u001a\u00020q2\u0006\u0010t\u001a\u00020s2\u0006\u0010v\u001a\u00020u2\u0006\u0010x\u001a\u00020w2\u0006\u0010z\u001a\u00020y2\u0006\u0010|\u001a\u00020{H\u0001¢\u0006\u0004\b}\u0010~J\u001c\u0010\u0001\u001a\u00020o2\b\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0013\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020s2\b\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0013\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020u2\b\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0013\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020q2\b\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0013\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010 \u0001\u001a\u00020w2\b\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0013\u0010£\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b¡\u0001\u0010¢\u0001J\u001c\u0010§\u0001\u001a\u00020y2\b\u0010\u0001\u001a\u00030¤\u0001H\u0001¢\u0006\u0006\b¥\u0001\u0010¦\u0001J\u0013\u0010ª\u0001\u001a\u00030¤\u0001H\u0001¢\u0006\u0006\b¨\u0001\u0010©\u0001J\u001c\u0010®\u0001\u001a\u00020{2\b\u0010\u0001\u001a\u00030«\u0001H\u0001¢\u0006\u0006\b¬\u0001\u0010­\u0001J\u0013\u0010±\u0001\u001a\u00030«\u0001H\u0001¢\u0006\u0006\b¯\u0001\u0010°\u0001RF\u0010·\u0001\u001a/\u0012\u000f\u0012\r ´\u0001*\u0005\u0018\u00010³\u00010³\u0001 ´\u0001*\u0016\u0012\u000f\u0012\r ´\u0001*\u0005\u0018\u00010³\u00010³\u0001\u0018\u00010²\u00010²\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bµ\u0001\u0010¶\u0001RF\u0010¹\u0001\u001a/\u0012\u000f\u0012\r ´\u0001*\u0005\u0018\u00010³\u00010³\u0001 ´\u0001*\u0016\u0012\u000f\u0012\r ´\u0001*\u0005\u0018\u00010³\u00010³\u0001\u0018\u00010²\u00010²\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010¶\u0001¨\u0006¿\u0001"}, d2 = {"Lcom/avito/android/profile/di/EditProfileModule;", "", "Lcom/avito/android/profile/edit/EditProfileInteractor;", "interactor", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/util/ErrorFormatter;", "errorFormatter", "Lcom/avito/android/util/Kundle;", "presenterState", "Lcom/avito/android/profile/edit/EditProfilePresenter;", "providePresenter", "(Lcom/avito/android/profile/edit/EditProfileInteractor;Lcom/avito/android/analytics/Analytics;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/ErrorFormatter;Lcom/avito/android/util/Kundle;)Lcom/avito/android/profile/edit/EditProfilePresenter;", "Lcom/avito/android/profile/edit/LocationInteractor;", "locationInteractor", "Lcom/avito/android/profile/edit/SaveProfileInteractor;", "saveProfileInteractor", "Lcom/avito/android/profile/edit/avatar/AvatarInteractor;", "avatarInteractor", "Lcom/avito/android/profile/edit/EditProfileResourceProvider;", "editProfileResourceProvider", "editProfileInteractorState", "provideInteractor", "(Lcom/avito/android/profile/edit/LocationInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/profile/edit/SaveProfileInteractor;Lcom/avito/android/profile/edit/avatar/AvatarInteractor;Lcom/avito/android/profile/edit/EditProfileResourceProvider;Lcom/avito/android/util/Kundle;)Lcom/avito/android/profile/edit/EditProfileInteractor;", "Lcom/avito/android/remote/ProfileApi;", "api", "Lcom/avito/android/photo_picker/legacy/api/UploadConverterProvider;", "uploadConverterProvider", "Lcom/avito/android/photo_picker/BitmapTransformer;", "bitmapTransformer", "provideAvatarInteractor", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/photo_picker/legacy/api/UploadConverterProvider;Lcom/avito/android/photo_picker/BitmapTransformer;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/profile/edit/avatar/AvatarInteractor;", "profileApi", "Lcom/avito/android/account/SessionChangeTracker;", "sessionChangeTracker", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "provideSaveProfileInteractor", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/profile/edit/LocationInteractor;Lcom/avito/android/account/SessionChangeTracker;Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/profile/edit/SaveProfileInteractor;", "Lcom/avito/android/remote/LocationApi;", "locationApi", "schedulers", "Lcom/avito/android/profile/edit/LocationInteractorResourceProvider;", "resourceProvider", "interactorState", "provideLocationInteractor", "(Lcom/avito/android/remote/LocationApi;Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/profile/edit/LocationInteractorResourceProvider;Lcom/avito/android/util/Kundle;)Lcom/avito/android/profile/edit/LocationInteractor;", "Landroid/content/Context;", "context", "provideLocationInteractorResourceProvider", "(Landroid/content/Context;)Lcom/avito/android/profile/edit/LocationInteractorResourceProvider;", "provideErrorFormatter$profile_release", "(Landroid/content/Context;)Lcom/avito/android/util/ErrorFormatter;", "provideErrorFormatter", "provideEditProfileResourceProvider$profile_release", "(Landroid/content/Context;)Lcom/avito/android/profile/edit/EditProfileResourceProvider;", "provideEditProfileResourceProvider", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/util/RandomKeyProvider;", "randomKeyProvider", "Lcom/avito/android/profile/edit/CameraDelegate;", "provideCameraDelegate", "(Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/util/RandomKeyProvider;)Lcom/avito/android/profile/edit/CameraDelegate;", "Lcom/avito/android/photo/BitmapFileProvider;", "bitmapFileProvider", "Lcom/avito/android/photo_picker/ExifExtraDataSerializer;", "exifExtraDataSerializer", "Lcom/avito/android/Features;", "features", "provideUploadConverter", "(Lcom/avito/android/photo/BitmapFileProvider;Lcom/avito/android/photo_picker/ExifExtraDataSerializer;Lcom/avito/android/Features;)Lcom/avito/android/photo_picker/legacy/api/UploadConverterProvider;", "Lcom/avito/android/photo_picker/ExifExtraDataSerializerImpl;", "serializer", "provideExifExtraDataSerializer", "(Lcom/avito/android/photo_picker/ExifExtraDataSerializerImpl;)Lcom/avito/android/photo_picker/ExifExtraDataSerializer;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/util/PrivatePhotosStorage;", "privatePhotosStorage", "provideBitmapFileProvider", "(Landroid/app/Application;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/PrivatePhotosStorage;)Lcom/avito/android/photo/BitmapFileProvider;", "provideBitmapTransformer", "(Landroid/app/Application;Lcom/avito/android/util/PrivatePhotosStorage;)Lcom/avito/android/photo_picker/BitmapTransformer;", "Ldagger/Lazy;", "Landroidx/recyclerview/widget/ListUpdateCallback;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "diffCalculator", "provideDataAwareAdapter", "(Ldagger/Lazy;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/data_aware/DiffCalculator;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "Lcom/avito/android/recycler/data_aware/ContentsComparator;", "contentsComparator", "provideDiffCalculator", "(Lcom/avito/android/recycler/data_aware/ContentsComparator;)Lcom/avito/android/recycler/data_aware/DiffCalculator;", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "provideAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideContentsComparator", "()Lcom/avito/android/recycler/data_aware/ContentsComparator;", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideRecyclerAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "provideListUpdateListener", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/ListUpdateCallback;", "Lcom/avito/android/profile/edit/adapter/AvatarItemBlueprint;", "avatarItemBlueprint", "Lcom/avito/android/profile/edit/adapter/InputItemBlueprint;", "inputItemBlueprint", "Lcom/avito/android/profile/edit/adapter/LocationItemBlueprint;", "locationItemBlueprint", "Lcom/avito/android/profile/edit/adapter/SubLocationItemBlueprint;", "subLocationItemBlueprint", "Lcom/avito/android/profile/edit/adapter/PhoneInputItemBlueprint;", "phoneInputItemBlueprint", "Lcom/avito/android/profile/edit/adapter/ErrorLabelItemBlueprint;", "errorLabelItemBlueprint", "Lcom/avito/android/profile/edit/adapter/TextItemBlueprint;", "textItemBlueprint", "provideItemBinder$profile_release", "(Lcom/avito/android/profile/edit/adapter/AvatarItemBlueprint;Lcom/avito/android/profile/edit/adapter/InputItemBlueprint;Lcom/avito/android/profile/edit/adapter/LocationItemBlueprint;Lcom/avito/android/profile/edit/adapter/SubLocationItemBlueprint;Lcom/avito/android/profile/edit/adapter/PhoneInputItemBlueprint;Lcom/avito/android/profile/edit/adapter/ErrorLabelItemBlueprint;Lcom/avito/android/profile/edit/adapter/TextItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Lcom/avito/android/profile/edit/refactoring/adapter/AvatarItemPresenter;", "presenter", "provideAvatarItemBlueprint$profile_release", "(Lcom/avito/android/profile/edit/refactoring/adapter/AvatarItemPresenter;)Lcom/avito/android/profile/edit/adapter/AvatarItemBlueprint;", "provideAvatarItemBlueprint", "provideAvatarItemPresenter$profile_release", "()Lcom/avito/android/profile/edit/refactoring/adapter/AvatarItemPresenter;", "provideAvatarItemPresenter", "Lcom/avito/android/profile/edit/adapter/LocationItemPresenter;", "provideLocationItemBlueprint$profile_release", "(Lcom/avito/android/profile/edit/adapter/LocationItemPresenter;)Lcom/avito/android/profile/edit/adapter/LocationItemBlueprint;", "provideLocationItemBlueprint", "provideLocationItemPresenter$profile_release", "()Lcom/avito/android/profile/edit/adapter/LocationItemPresenter;", "provideLocationItemPresenter", "Lcom/avito/android/profile/edit/refactoring/adapter/SubLocationItemPresenter;", "provideSubLocationItemBlueprint$profile_release", "(Lcom/avito/android/profile/edit/refactoring/adapter/SubLocationItemPresenter;)Lcom/avito/android/profile/edit/adapter/SubLocationItemBlueprint;", "provideSubLocationItemBlueprint", "provideSubLocationItemPresenter$profile_release", "()Lcom/avito/android/profile/edit/refactoring/adapter/SubLocationItemPresenter;", "provideSubLocationItemPresenter", "Lcom/avito/android/profile/edit/refactoring/adapter/InputItemPresenter;", "provideInputItemBlueprint$profile_release", "(Lcom/avito/android/profile/edit/refactoring/adapter/InputItemPresenter;)Lcom/avito/android/profile/edit/adapter/InputItemBlueprint;", "provideInputItemBlueprint", "provideInputItemPresenter$profile_release", "()Lcom/avito/android/profile/edit/refactoring/adapter/InputItemPresenter;", "provideInputItemPresenter", "Lcom/avito/android/profile/edit/refactoring/adapter/PhoneInputItemPresenter;", "providePhoneInputItemBlueprint$profile_release", "(Lcom/avito/android/profile/edit/refactoring/adapter/PhoneInputItemPresenter;)Lcom/avito/android/profile/edit/adapter/PhoneInputItemBlueprint;", "providePhoneInputItemBlueprint", "providePhoneInputItemPresenter$profile_release", "()Lcom/avito/android/profile/edit/refactoring/adapter/PhoneInputItemPresenter;", "providePhoneInputItemPresenter", "Lcom/avito/android/profile/edit/refactoring/adapter/ErrorLabelItemPresenter;", "provideErrorBlockItemBlueprint$profile_release", "(Lcom/avito/android/profile/edit/refactoring/adapter/ErrorLabelItemPresenter;)Lcom/avito/android/profile/edit/adapter/ErrorLabelItemBlueprint;", "provideErrorBlockItemBlueprint", "provideErrorBlockItemPresenter$profile_release", "()Lcom/avito/android/profile/edit/refactoring/adapter/ErrorLabelItemPresenter;", "provideErrorBlockItemPresenter", "Lcom/avito/android/profile/edit/refactoring/adapter/TextItemPresenter;", "provideTextItemBlueprint$profile_release", "(Lcom/avito/android/profile/edit/refactoring/adapter/TextItemPresenter;)Lcom/avito/android/profile/edit/adapter/TextItemBlueprint;", "provideTextItemBlueprint", "provideTextlockItemPresenter$profile_release", "()Lcom/avito/android/profile/edit/refactoring/adapter/TextItemPresenter;", "provideTextlockItemPresenter", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/PublishRelay;", "itemsChangedStream", AuthSource.SEND_ABUSE, "itemsClicksStream", "<init>", "()V", "EditProfileInteractorState", "InteractorState", "PresenterState", "profile_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {PhoneNumberFormatterModule.class, SessionUpdateTrackerModule.class})
public final class EditProfileModule {
    @NotNull
    public static final EditProfileModule INSTANCE = new EditProfileModule();
    public static final PublishRelay<EditProfileItem> a = PublishRelay.create();
    public static final PublishRelay<EditProfileItem> b = PublishRelay.create();

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile/di/EditProfileModule$EditProfileInteractorState;", "", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.CLASS)
    public @interface EditProfileInteractorState {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile/di/EditProfileModule$InteractorState;", "", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.CLASS)
    public @interface InteractorState {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile/di/EditProfileModule$PresenterState;", "", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.CLASS)
    public @interface PresenterState {
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final AdapterPresenter provideAdapterPresenter(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final AvatarInteractor provideAvatarInteractor(@NotNull ProfileApi profileApi, @NotNull UploadConverterProvider uploadConverterProvider, @NotNull BitmapTransformer bitmapTransformer, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(uploadConverterProvider, "uploadConverterProvider");
        Intrinsics.checkNotNullParameter(bitmapTransformer, "bitmapTransformer");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        return new AvatarInteractorImpl(profileApi, uploadConverterProvider, bitmapTransformer, schedulersFactory);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final AvatarItemBlueprint provideAvatarItemBlueprint$profile_release(@NotNull AvatarItemPresenter avatarItemPresenter) {
        Intrinsics.checkNotNullParameter(avatarItemPresenter, "presenter");
        return new AvatarItemBlueprint(avatarItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final AvatarItemPresenter provideAvatarItemPresenter$profile_release() {
        PublishRelay<EditProfileItem> publishRelay = a;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "itemsClicksStream");
        return new AvatarItemPresenterImpl(publishRelay);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final BitmapFileProvider provideBitmapFileProvider(@NotNull Application application, @NotNull Analytics analytics, @NotNull PrivatePhotosStorage privatePhotosStorage) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(privatePhotosStorage, "privatePhotosStorage");
        Context applicationContext = application.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "application.applicationContext");
        return new BitmapFileProviderImpl(applicationContext, analytics, privatePhotosStorage);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final BitmapTransformer provideBitmapTransformer(@NotNull Application application, @NotNull PrivatePhotosStorage privatePhotosStorage) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(privatePhotosStorage, "privatePhotosStorage");
        int dimensionPixelOffset = application.getResources().getDimensionPixelOffset(R.dimen.crop_viewport_padding);
        int displayHeight = Contexts.getDisplayHeight(application);
        int displayWidth = Contexts.getDisplayWidth(application);
        ContentResolver contentResolver = application.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "application.contentResolver");
        return new BitmapTransformerImpl(contentResolver, privatePhotosStorage, displayHeight, displayWidth, dimensionPixelOffset);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final CameraDelegate provideCameraDelegate(@NotNull ActivityIntentFactory activityIntentFactory, @NotNull RandomKeyProvider randomKeyProvider) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(randomKeyProvider, "randomKeyProvider");
        return new PhotoPickerCameraDelegate(activityIntentFactory, randomKeyProvider);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final ContentsComparator provideContentsComparator() {
        return new EditProfileContentsComparator();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final AdapterPresenter provideDataAwareAdapter(@NotNull Lazy<ListUpdateCallback> lazy, @NotNull AdapterPresenter adapterPresenter, @NotNull DiffCalculator diffCalculator) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(diffCalculator, "diffCalculator");
        return new DataAwareAdapterPresenterImpl(lazy, adapterPresenter, diffCalculator);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final DiffCalculator provideDiffCalculator(@NotNull ContentsComparator contentsComparator) {
        Intrinsics.checkNotNullParameter(contentsComparator, "contentsComparator");
        return new SimpleDiffCalculator(contentsComparator, new SimpleEqualityComparator(), true, null, 8, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final EditProfileResourceProvider provideEditProfileResourceProvider$profile_release(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        return new EditProfileResourceProviderImpl(resources);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final ErrorLabelItemBlueprint provideErrorBlockItemBlueprint$profile_release(@NotNull ErrorLabelItemPresenter errorLabelItemPresenter) {
        Intrinsics.checkNotNullParameter(errorLabelItemPresenter, "presenter");
        return new ErrorLabelItemBlueprint(errorLabelItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final ErrorLabelItemPresenter provideErrorBlockItemPresenter$profile_release() {
        return new ErrorLabelItemPresenterImpl();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final ErrorFormatter provideErrorFormatter$profile_release(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        return new ErrorFormatterImpl(resources);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final ExifExtraDataSerializer provideExifExtraDataSerializer(@NotNull ExifExtraDataSerializerImpl exifExtraDataSerializerImpl) {
        Intrinsics.checkNotNullParameter(exifExtraDataSerializerImpl, "serializer");
        return exifExtraDataSerializerImpl;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final InputItemBlueprint provideInputItemBlueprint$profile_release(@NotNull InputItemPresenter inputItemPresenter) {
        Intrinsics.checkNotNullParameter(inputItemPresenter, "presenter");
        return new InputItemBlueprint(inputItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final InputItemPresenter provideInputItemPresenter$profile_release() {
        PublishRelay<EditProfileItem> publishRelay = b;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "itemsChangedStream");
        return new InputItemPresenterImpl(publishRelay);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final EditProfileInteractor provideInteractor(@NotNull LocationInteractor locationInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull SaveProfileInteractor saveProfileInteractor, @NotNull AvatarInteractor avatarInteractor, @NotNull EditProfileResourceProvider editProfileResourceProvider, @EditProfileInteractorState @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(locationInteractor, "locationInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(saveProfileInteractor, "saveProfileInteractor");
        Intrinsics.checkNotNullParameter(avatarInteractor, "avatarInteractor");
        Intrinsics.checkNotNullParameter(editProfileResourceProvider, "editProfileResourceProvider");
        return new EditProfileInteractorImpl(locationInteractor, avatarInteractor, saveProfileInteractor, editProfileResourceProvider, schedulersFactory, kundle);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final ItemBinder provideItemBinder$profile_release(@NotNull AvatarItemBlueprint avatarItemBlueprint, @NotNull InputItemBlueprint inputItemBlueprint, @NotNull LocationItemBlueprint locationItemBlueprint, @NotNull SubLocationItemBlueprint subLocationItemBlueprint, @NotNull PhoneInputItemBlueprint phoneInputItemBlueprint, @NotNull ErrorLabelItemBlueprint errorLabelItemBlueprint, @NotNull TextItemBlueprint textItemBlueprint) {
        Intrinsics.checkNotNullParameter(avatarItemBlueprint, "avatarItemBlueprint");
        Intrinsics.checkNotNullParameter(inputItemBlueprint, "inputItemBlueprint");
        Intrinsics.checkNotNullParameter(locationItemBlueprint, "locationItemBlueprint");
        Intrinsics.checkNotNullParameter(subLocationItemBlueprint, "subLocationItemBlueprint");
        Intrinsics.checkNotNullParameter(phoneInputItemBlueprint, "phoneInputItemBlueprint");
        Intrinsics.checkNotNullParameter(errorLabelItemBlueprint, "errorLabelItemBlueprint");
        Intrinsics.checkNotNullParameter(textItemBlueprint, "textItemBlueprint");
        return new ItemBinder.Builder().registerItem(avatarItemBlueprint).registerItem(inputItemBlueprint).registerItem(locationItemBlueprint).registerItem(subLocationItemBlueprint).registerItem(phoneInputItemBlueprint).registerItem(errorLabelItemBlueprint).registerItem(textItemBlueprint).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final ListUpdateCallback provideListUpdateListener(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        return simpleRecyclerAdapter;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final LocationInteractor provideLocationInteractor(@NotNull LocationApi locationApi, @NotNull ProfileApi profileApi, @NotNull SchedulersFactory schedulersFactory, @NotNull LocationInteractorResourceProvider locationInteractorResourceProvider, @InteractorState @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(locationApi, "locationApi");
        Intrinsics.checkNotNullParameter(profileApi, "profileApi");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(locationInteractorResourceProvider, "resourceProvider");
        return new LocationInteractorImpl(locationApi, profileApi, schedulersFactory, locationInteractorResourceProvider, kundle);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final LocationInteractorResourceProvider provideLocationInteractorResourceProvider(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        return new LocationInteractorResourceProviderImpl(resources);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final LocationItemBlueprint provideLocationItemBlueprint$profile_release(@NotNull LocationItemPresenter locationItemPresenter) {
        Intrinsics.checkNotNullParameter(locationItemPresenter, "presenter");
        return new LocationItemBlueprint(locationItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final LocationItemPresenter provideLocationItemPresenter$profile_release() {
        PublishRelay<EditProfileItem> publishRelay = a;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "itemsClicksStream");
        return new LocationItemPresenterImpl(publishRelay);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final PhoneInputItemBlueprint providePhoneInputItemBlueprint$profile_release(@NotNull PhoneInputItemPresenter phoneInputItemPresenter) {
        Intrinsics.checkNotNullParameter(phoneInputItemPresenter, "presenter");
        return new PhoneInputItemBlueprint(phoneInputItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final PhoneInputItemPresenter providePhoneInputItemPresenter$profile_release() {
        PublishRelay<EditProfileItem> publishRelay = b;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "itemsChangedStream");
        return new PhoneInputItemPresenterImpl(InteropKt.toConsumerV3(publishRelay));
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final EditProfilePresenter providePresenter(@NotNull EditProfileInteractor editProfileInteractor, @NotNull Analytics analytics, @NotNull AdapterPresenter adapterPresenter, @NotNull SchedulersFactory schedulersFactory, @NotNull ErrorFormatter errorFormatter, @PresenterState @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(editProfileInteractor, "interactor");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        PublishRelay<EditProfileItem> publishRelay = a;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "itemsClicksStream");
        PublishRelay<EditProfileItem> publishRelay2 = b;
        Intrinsics.checkNotNullExpressionValue(publishRelay2, "itemsChangedStream");
        return new EditProfilePresenterImpl(analytics, editProfileInteractor, publishRelay, publishRelay2, adapterPresenter, errorFormatter, schedulersFactory, kundle);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final SimpleRecyclerAdapter provideRecyclerAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final SaveProfileInteractor provideSaveProfileInteractor(@NotNull ProfileApi profileApi, @NotNull LocationInteractor locationInteractor, @NotNull SessionChangeTracker sessionChangeTracker, @NotNull AccountStorageInteractor accountStorageInteractor, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(profileApi, "profileApi");
        Intrinsics.checkNotNullParameter(locationInteractor, "locationInteractor");
        Intrinsics.checkNotNullParameter(sessionChangeTracker, "sessionChangeTracker");
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        return new SaveProfileInteractorImpl(profileApi, accountStorageInteractor, sessionChangeTracker, locationInteractor, schedulersFactory);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final SubLocationItemBlueprint provideSubLocationItemBlueprint$profile_release(@NotNull SubLocationItemPresenter subLocationItemPresenter) {
        Intrinsics.checkNotNullParameter(subLocationItemPresenter, "presenter");
        return new SubLocationItemBlueprint(subLocationItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final SubLocationItemPresenter provideSubLocationItemPresenter$profile_release() {
        PublishRelay<EditProfileItem> publishRelay = a;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "itemsClicksStream");
        return new SubLocationItemPresenterImpl(publishRelay);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final TextItemBlueprint provideTextItemBlueprint$profile_release(@NotNull TextItemPresenter textItemPresenter) {
        Intrinsics.checkNotNullParameter(textItemPresenter, "presenter");
        return new TextItemBlueprint(textItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final TextItemPresenter provideTextlockItemPresenter$profile_release() {
        return new TextItemPresenterImpl();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final UploadConverterProvider provideUploadConverter(@NotNull BitmapFileProvider bitmapFileProvider, @NotNull ExifExtraDataSerializer exifExtraDataSerializer, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(bitmapFileProvider, "bitmapFileProvider");
        Intrinsics.checkNotNullParameter(exifExtraDataSerializer, "exifExtraDataSerializer");
        Intrinsics.checkNotNullParameter(features, "features");
        return new UploadConverterProviderImpl(bitmapFileProvider, exifExtraDataSerializer, features);
    }
}
