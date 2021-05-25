package com.avito.android.photo_picker.legacy.di;

import a2.b.a.a.a;
import a2.g.r.g;
import android.app.Activity;
import android.app.Application;
import android.content.ContentResolver;
import android.content.res.Resources;
import android.os.Looper;
import com.avito.android.Features;
import com.avito.android.PublishIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.PhotoPickerEventTracker;
import com.avito.android.computer_vision.ComputerVisionInteractor;
import com.avito.android.di.PerActivity;
import com.avito.android.permissions.ActivityPermissionHelper;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.photo.BitmapFileProvider;
import com.avito.android.photo.BitmapFileProviderImpl;
import com.avito.android.photo.ThumbnailProvider;
import com.avito.android.photo.ThumbnailProviderImpl;
import com.avito.android.photo_picker.ExifExtraDataSerializer;
import com.avito.android.photo_picker.ExifExtraDataSerializerImpl;
import com.avito.android.photo_picker.legacy.DeviceOrientationProvider;
import com.avito.android.photo_picker.legacy.DeviceOrientationProviderImpl;
import com.avito.android.photo_picker.legacy.GalleryResultsExtractor;
import com.avito.android.photo_picker.legacy.LegacyPhotoResizer;
import com.avito.android.photo_picker.legacy.PhotoDragAndDrop;
import com.avito.android.photo_picker.legacy.PhotoDragAndDropImpl;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.photo_picker.legacy.PhotoInteractorImpl;
import com.avito.android.photo_picker.legacy.PhotoPickerInteractor;
import com.avito.android.photo_picker.legacy.PhotoPickerInteractorState;
import com.avito.android.photo_picker.legacy.PhotoPickerPresenter;
import com.avito.android.photo_picker.legacy.PhotoPickerPresenterImpl;
import com.avito.android.photo_picker.legacy.PhotoPickerPresenterResourceProvider;
import com.avito.android.photo_picker.legacy.PhotoPickerPresenterResourceProviderImpl;
import com.avito.android.photo_picker.legacy.PhotoPickerPresenterState;
import com.avito.android.photo_picker.legacy.PhotoPickerView;
import com.avito.android.photo_picker.legacy.PhotoResizer;
import com.avito.android.photo_picker.legacy.RotationInteractor;
import com.avito.android.photo_picker.legacy.SimplePhotoResizer;
import com.avito.android.photo_picker.legacy.SingleCachePhotoInteractor;
import com.avito.android.photo_picker.legacy.StoppableRotationInteractor;
import com.avito.android.photo_picker.legacy.StoppableRotationInteractorImpl;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter;
import com.avito.android.photo_picker.legacy.details_list.DetailsBlueprintProvider;
import com.avito.android.photo_picker.legacy.details_list.DetailsBlueprintProviderImpl;
import com.avito.android.photo_picker.legacy.details_list.DisplayAnalyzer;
import com.avito.android.photo_picker.legacy.details_list.DisplayAnalyzerImpl;
import com.avito.android.photo_picker.legacy.details_list.EditorItemPresenter;
import com.avito.android.photo_picker.legacy.details_list.EditorItemPresenterImpl;
import com.avito.android.photo_picker.legacy.thumbnail_list.BasePhotoItem;
import com.avito.android.photo_picker.legacy.thumbnail_list.ThumbnailItemBluePrint;
import com.avito.android.photo_picker.legacy.thumbnail_list.ThumbnailItemPresenter;
import com.avito.android.photo_picker.legacy.thumbnail_list.ThumbnailItemPresenterImpl;
import com.avito.android.photo_picker.legacy.thumbnail_list.ThumbnailItemView;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistryImpl;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenterImpl;
import com.avito.android.recycler.responsive.ResponsiveRecyclerAdapter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.PrivatePhotosStorage;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Named;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ð\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\nÉ\u0001Ê\u0001Ë\u0001Ì\u0001Í\u0001Bq\u0012\b\u0010¾\u0001\u001a\u00030»\u0001\u0012\b\u0010®\u0001\u001a\u00030¡\u0001\u0012\b\u0010¤\u0001\u001a\u00030¡\u0001\u0012\n\u0010º\u0001\u001a\u0005\u0018\u00010·\u0001\u0012\n\u0010²\u0001\u001a\u0005\u0018\u00010¯\u0001\u0012\b\u0010Æ\u0001\u001a\u00030³\u0001\u0012\b\u0010¶\u0001\u001a\u00030³\u0001\u0012\b\u0010À\u0001\u001a\u00030¥\u0001\u0012\b\u0010¨\u0001\u001a\u00030¥\u0001\u0012\b\u0010Ä\u0001\u001a\u00030Á\u0001¢\u0006\u0006\bÇ\u0001\u0010È\u0001J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u0010\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u001a\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0001\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\rH\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ/\u0010'\u001a\u00020\u001c2\u001e\b\u0001\u0010$\u001a\u0018\u0012\t\u0012\u00070!¢\u0006\u0002\b\"\u0012\t\u0012\u00070#¢\u0006\u0002\b\"0 H\u0001¢\u0006\u0004\b%\u0010&J#\u0010,\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020#0 2\u0006\u0010)\u001a\u00020(H\u0001¢\u0006\u0004\b*\u0010+J\u0019\u00101\u001a\u00020.2\b\b\u0001\u0010-\u001a\u00020\u001cH\u0001¢\u0006\u0004\b/\u00100J!\u00108\u001a\u0002052\b\b\u0001\u00102\u001a\u00020.2\u0006\u00104\u001a\u000203H\u0001¢\u0006\u0004\b6\u00107J!\u0010=\u001a\u00020:2\u0006\u00109\u001a\u0002052\b\b\u0001\u0010-\u001a\u00020\u001cH\u0001¢\u0006\u0004\b;\u0010<J\u0019\u0010?\u001a\u00020.2\b\b\u0001\u0010-\u001a\u00020\u001cH\u0001¢\u0006\u0004\b>\u00100J#\u0010B\u001a\u00020:2\b\b\u0001\u00109\u001a\u00020.2\b\b\u0001\u0010-\u001a\u00020\u001cH\u0001¢\u0006\u0004\b@\u0010AJ\u0017\u0010H\u001a\u00020E2\u0006\u0010D\u001a\u00020CH\u0001¢\u0006\u0004\bF\u0010GJ\u001f\u0010P\u001a\u00020M2\u0006\u0010J\u001a\u00020I2\u0006\u0010L\u001a\u00020KH\u0001¢\u0006\u0004\bN\u0010OJW\u0010d\u001a\u00020a2\u0006\u0010Q\u001a\u00020M2\u0006\u0010S\u001a\u00020R2\u0006\u0010U\u001a\u00020T2\u0006\u0010W\u001a\u00020V2\u0006\u0010Y\u001a\u00020X2\u0006\u0010[\u001a\u00020Z2\u0006\u0010\\\u001a\u00020C2\u0006\u0010^\u001a\u00020]2\u0006\u0010`\u001a\u00020_H\u0001¢\u0006\u0004\bb\u0010cJ'\u0010i\u001a\u00020T2\u0006\u0010J\u001a\u00020I2\u0006\u0010f\u001a\u00020e2\u0006\u0010h\u001a\u00020gH\u0007¢\u0006\u0004\bi\u0010jJ\u0017\u0010k\u001a\u00020V2\u0006\u0010J\u001a\u00020IH\u0007¢\u0006\u0004\bk\u0010lJk\u0010v\u001a\u00020\u00122\b\b\u0001\u0010m\u001a\u00020.2\b\b\u0001\u0010n\u001a\u00020.2\u0006\u0010Q\u001a\u00020a2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\\\u001a\u00020C2\u0006\u0010f\u001a\u00020e2\u0006\u0010p\u001a\u00020o2\u0006\u0010[\u001a\u00020Z2\u0006\u0010r\u001a\u00020q2\u0006\u0010s\u001a\u00020XH\u0001¢\u0006\u0004\bt\u0010uJ\u000f\u0010z\u001a\u00020wH\u0001¢\u0006\u0004\bx\u0010yJ\u000f\u0010}\u001a\u00020oH\u0001¢\u0006\u0004\b{\u0010|J&\u0010\u0001\u001a\u00020(2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b~\u0010J\u001b\u0010\u0001\u001a\u00030\u00012\u0006\u0010J\u001a\u00020IH\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020\u00142\b\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0012H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0012\u0010\u0001\u001a\u000203H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0013\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0013\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020]2\b\u0010\u0001\u001a\u00030\u0001H\u0007¢\u0006\u0006\b\u0001\u0010 \u0001R\u001a\u0010¤\u0001\u001a\u00030¡\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u001a\u0010¨\u0001\u001a\u00030¥\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R\u001a\u0010¬\u0001\u001a\u00030©\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R\u001a\u0010®\u0001\u001a\u00030¡\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b­\u0001\u0010£\u0001R\u001c\u0010²\u0001\u001a\u0005\u0018\u00010¯\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R\u001a\u0010¶\u0001\u001a\u00030³\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R\u001c\u0010º\u0001\u001a\u0005\u0018\u00010·\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R\u001a\u0010¾\u0001\u001a\u00030»\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¼\u0001\u0010½\u0001R\u001a\u0010À\u0001\u001a\u00030¥\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¿\u0001\u0010§\u0001R\u001a\u0010Ä\u0001\u001a\u00030Á\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u001a\u0010Æ\u0001\u001a\u00030³\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÅ\u0001\u0010µ\u0001¨\u0006Î\u0001"}, d2 = {"Lcom/avito/android/photo_picker/legacy/di/PhotoPickerModule;", "", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/photo_picker/legacy/details_list/DisplayAnalyzer;", "provideDisplayAnalyzer$photo_picker_release", "(Lcom/avito/android/util/DeviceMetrics;)Lcom/avito/android/photo_picker/legacy/details_list/DisplayAnalyzer;", "provideDisplayAnalyzer", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;", "cameraItemPresenter", "Lcom/avito/android/photo_picker/legacy/details_list/EditorItemPresenter;", "editorItemPresenter", "displayAnalyzer", "Lcom/avito/android/photo_picker/legacy/details_list/DetailsBlueprintProvider;", "provideDetailsBluePrintProvider$photo_picker_release", "(Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;Lcom/avito/android/photo_picker/legacy/details_list/EditorItemPresenter;Lcom/avito/android/photo_picker/legacy/details_list/DisplayAnalyzer;)Lcom/avito/android/photo_picker/legacy/details_list/DetailsBlueprintProvider;", "provideDetailsBluePrintProvider", "Ldagger/Lazy;", "Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenter;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/photo_picker/legacy/StoppableRotationInteractor;", "rotationInteractor", "Lcom/avito/android/PublishIntentFactory$PhotoPickerMode;", "mode", "provideEditorItemPresenter$photo_picker_release", "(Ldagger/Lazy;Lcom/avito/android/photo_picker/legacy/StoppableRotationInteractor;Lcom/avito/android/PublishIntentFactory$PhotoPickerMode;)Lcom/avito/android/photo_picker/legacy/details_list/EditorItemPresenter;", "provideEditorItemPresenter", "detailsBlueprintProvider", "Lcom/avito/konveyor/ItemBinder;", "provideDetailsItemBinder$photo_picker_release", "(Lcom/avito/android/photo_picker/legacy/details_list/DetailsBlueprintProvider;)Lcom/avito/konveyor/ItemBinder;", "provideDetailsItemBinder", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/ThumbnailItemView;", "Lkotlin/jvm/JvmSuppressWildcards;", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/BasePhotoItem;", "itemBluePrint", "provideThumbnailsItemBinder$photo_picker_release", "(Lcom/avito/konveyor/blueprint/ItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideThumbnailsItemBinder", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/ThumbnailItemPresenter;", "itemPresenter", "provideThumbnailItemBlueprint$photo_picker_release", "(Lcom/avito/android/photo_picker/legacy/thumbnail_list/ThumbnailItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideThumbnailItemBlueprint", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "providesDetailsAdapterPresenter$photo_picker_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "providesDetailsAdapterPresenter", "delegate", "Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "registry", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "providesResponsiveAdapterPresenter$photo_picker_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;)Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "providesResponsiveAdapterPresenter", "adapterPresenter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideDetailsRecyclerAdapter$photo_picker_release", "(Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideDetailsRecyclerAdapter", "providesThumbnailsAdapterPresenter$photo_picker_release", "providesThumbnailsAdapterPresenter", "provideThumbnailsRecyclerAdapter$photo_picker_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideThumbnailsRecyclerAdapter", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/photo_picker/legacy/PhotoResizer;", "providePhotoSaver$photo_picker_release", "(Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/photo_picker/legacy/PhotoResizer;", "providePhotoSaver", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "providePhotoInteractor$photo_picker_release", "(Landroid/app/Application;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "providePhotoInteractor", "photoInteractor", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "sharedPhotosStorage", "Lcom/avito/android/photo/BitmapFileProvider;", "bitmapFileProvider", "Lcom/avito/android/photo/ThumbnailProvider;", "thumbnailProvider", "Lcom/avito/android/analytics/PhotoPickerEventTracker;", "tracker", "Lcom/avito/android/computer_vision/ComputerVisionInteractor;", "cvInteractor", "schedulersFactory", "Lcom/avito/android/photo_picker/ExifExtraDataSerializer;", "exifExtraDataSerializer", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractor;", "providePhotoPickerInteractor$photo_picker_release", "(Lcom/avito/android/photo_picker/legacy/PhotoInteractor;Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;Lcom/avito/android/photo/BitmapFileProvider;Lcom/avito/android/photo/ThumbnailProvider;Lcom/avito/android/analytics/PhotoPickerEventTracker;Lcom/avito/android/computer_vision/ComputerVisionInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/photo_picker/ExifExtraDataSerializer;Lcom/avito/android/Features;)Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractor;", "providePhotoPickerInteractor", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/PrivatePhotosStorage;", "privatePhotosStorage", "provideBitmapFileProvider", "(Landroid/app/Application;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/PrivatePhotosStorage;)Lcom/avito/android/photo/BitmapFileProvider;", "provideThumbnailProvider", "(Landroid/app/Application;)Lcom/avito/android/photo/ThumbnailProvider;", "detailsAdapterPresenter", "thumbnailsAdapterPresenter", "Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenterResourceProvider;", "resourceProvider", "Lcom/avito/android/util/RandomKeyProvider;", "keyProvider", "eventTracker", "providePhotoPickerPresenter$photo_picker_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractor;Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;Lcom/avito/android/photo_picker/legacy/StoppableRotationInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenterResourceProvider;Lcom/avito/android/computer_vision/ComputerVisionInteractor;Lcom/avito/android/util/RandomKeyProvider;Lcom/avito/android/analytics/PhotoPickerEventTracker;)Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenter;", "providePhotoPickerPresenter", "Lcom/avito/android/photo_picker/legacy/PhotoDragAndDrop;", "providePhotoDragAndDrop$photo_picker_release", "()Lcom/avito/android/photo_picker/legacy/PhotoDragAndDrop;", "providePhotoDragAndDrop", "providePhotoPickerPresenterResourceProvider$photo_picker_release", "()Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenterResourceProvider;", "providePhotoPickerPresenterResourceProvider", "providesPhotoItemPresenter$photo_picker_release", "(Ldagger/Lazy;Lcom/avito/android/photo_picker/legacy/StoppableRotationInteractor;)Lcom/avito/android/photo_picker/legacy/thumbnail_list/ThumbnailItemPresenter;", "providesPhotoItemPresenter", "Lcom/avito/android/photo_picker/legacy/DeviceOrientationProvider;", "provideOrientationProvider$photo_picker_release", "(Landroid/app/Application;)Lcom/avito/android/photo_picker/legacy/DeviceOrientationProvider;", "provideOrientationProvider", "orientationProvider", "provideStoppableRotationInteractor$photo_picker_release", "(Lcom/avito/android/photo_picker/legacy/DeviceOrientationProvider;)Lcom/avito/android/photo_picker/legacy/StoppableRotationInteractor;", "provideStoppableRotationInteractor", "presenter", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter$Listener;", "provideCameraItemPresenterListener$photo_picker_release", "(Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenter;)Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter$Listener;", "provideCameraItemPresenterListener", "Lcom/avito/android/photo_picker/legacy/RotationInteractor;", "provideRotationInteractor$photo_picker_release", "(Lcom/avito/android/photo_picker/legacy/StoppableRotationInteractor;)Lcom/avito/android/photo_picker/legacy/RotationInteractor;", "provideRotationInteractor", "provideResponsiveItemPresenterRegistry$photo_picker_release", "()Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "provideResponsiveItemPresenterRegistry", "Lcom/avito/android/photo_picker/legacy/GalleryResultsExtractor;", "provideGalleryResultsExtractor$photo_picker_release", "()Lcom/avito/android/photo_picker/legacy/GalleryResultsExtractor;", "provideGalleryResultsExtractor", "Lcom/avito/android/permissions/PermissionHelper;", "providePermissionHelper$photo_picker_release", "()Lcom/avito/android/permissions/PermissionHelper;", "providePermissionHelper", "Lcom/avito/android/photo_picker/ExifExtraDataSerializerImpl;", "serializer", "provideExifExtraDataSerializer", "(Lcom/avito/android/photo_picker/ExifExtraDataSerializerImpl;)Lcom/avito/android/photo_picker/ExifExtraDataSerializer;", "", "d", "Ljava/lang/String;", "typeId", "", "j", "Z", "withCrop", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "c", "operationId", "Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractorState;", "f", "Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractorState;", "interactorState", "", "h", "I", "maxPhotoCount", "Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenterState;", "e", "Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenterState;", "photoPickerPresenterState", "Landroid/app/Activity;", AuthSource.BOOKING_ORDER, "Landroid/app/Activity;", "activity", "i", "simplifiedUi", "Lcom/avito/android/photo_picker/legacy/PhotoPickerView$PhotoPickerLayoutConfig;", "k", "Lcom/avito/android/photo_picker/legacy/PhotoPickerView$PhotoPickerLayoutConfig;", "layoutConfig", g.a, "minPhotoCount", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenterState;Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractorState;IIZZLcom/avito/android/photo_picker/legacy/PhotoPickerView$PhotoPickerLayoutConfig;)V", "DetailsAdapter", "DetailsItemBinder", "ThumbnailBlueprint", "ThumbnailsAdapter", "ThumbnailsItemBinder", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PhotoPickerModule {
    public final Resources a;
    public final Activity b;
    public final String c;
    public final String d;
    public final PhotoPickerPresenterState e;
    public final PhotoPickerInteractorState f;
    public final int g;
    public final int h;
    public final boolean i;
    public final boolean j;
    public final PhotoPickerView.PhotoPickerLayoutConfig k;

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/legacy/di/PhotoPickerModule$DetailsAdapter;", "", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(AnnotationRetention.BINARY)
    public @interface DetailsAdapter {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/legacy/di/PhotoPickerModule$DetailsItemBinder;", "", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(AnnotationRetention.BINARY)
    public @interface DetailsItemBinder {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/legacy/di/PhotoPickerModule$ThumbnailBlueprint;", "", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(AnnotationRetention.BINARY)
    public @interface ThumbnailBlueprint {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/legacy/di/PhotoPickerModule$ThumbnailsAdapter;", "", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(AnnotationRetention.BINARY)
    public @interface ThumbnailsAdapter {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/legacy/di/PhotoPickerModule$ThumbnailsItemBinder;", "", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(AnnotationRetention.BINARY)
    public @interface ThumbnailsItemBinder {
    }

    public PhotoPickerModule(@NotNull Activity activity, @NotNull String str, @NotNull String str2, @Nullable PhotoPickerPresenterState photoPickerPresenterState, @Nullable PhotoPickerInteractorState photoPickerInteractorState, int i2, int i3, boolean z, boolean z2, @NotNull PhotoPickerView.PhotoPickerLayoutConfig photoPickerLayoutConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "operationId");
        Intrinsics.checkNotNullParameter(str2, "typeId");
        Intrinsics.checkNotNullParameter(photoPickerLayoutConfig, "layoutConfig");
        this.b = activity;
        this.c = str;
        this.d = str2;
        this.e = photoPickerPresenterState;
        this.f = photoPickerInteractorState;
        this.g = i2;
        this.h = i3;
        this.i = z;
        this.j = z2;
        this.k = photoPickerLayoutConfig;
        Resources resources = activity.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "activity.resources");
        this.a = resources;
    }

    @Provides
    @PerActivity
    @NotNull
    public final BitmapFileProvider provideBitmapFileProvider(@NotNull Application application, @NotNull Analytics analytics, @NotNull PrivatePhotosStorage privatePhotosStorage) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(privatePhotosStorage, "privatePhotosStorage");
        return new BitmapFileProviderImpl(application, analytics, privatePhotosStorage);
    }

    @Provides
    @PerActivity
    @NotNull
    public final CameraItemPresenter.Listener provideCameraItemPresenterListener$photo_picker_release(@NotNull PhotoPickerPresenter photoPickerPresenter) {
        Intrinsics.checkNotNullParameter(photoPickerPresenter, "presenter");
        return photoPickerPresenter;
    }

    @Provides
    @PerActivity
    @NotNull
    public final DetailsBlueprintProvider provideDetailsBluePrintProvider$photo_picker_release(@NotNull CameraItemPresenter cameraItemPresenter, @NotNull EditorItemPresenter editorItemPresenter, @NotNull DisplayAnalyzer displayAnalyzer) {
        Intrinsics.checkNotNullParameter(cameraItemPresenter, "cameraItemPresenter");
        Intrinsics.checkNotNullParameter(editorItemPresenter, "editorItemPresenter");
        Intrinsics.checkNotNullParameter(displayAnalyzer, "displayAnalyzer");
        return new DetailsBlueprintProviderImpl(cameraItemPresenter, editorItemPresenter, displayAnalyzer, this.i);
    }

    @Provides
    @NotNull
    @PerActivity
    @DetailsItemBinder
    public final ItemBinder provideDetailsItemBinder$photo_picker_release(@NotNull DetailsBlueprintProvider detailsBlueprintProvider) {
        Intrinsics.checkNotNullParameter(detailsBlueprintProvider, "detailsBlueprintProvider");
        return new ItemBinder.Builder().registerItem(detailsBlueprintProvider.provideCameraBluePrint()).registerItem(detailsBlueprintProvider.provideEditorBluePrint()).build();
    }

    @DetailsAdapter
    @Provides
    @NotNull
    @PerActivity
    public final SimpleRecyclerAdapter provideDetailsRecyclerAdapter$photo_picker_release(@NotNull ResponsiveAdapterPresenter responsiveAdapterPresenter, @DetailsItemBinder @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(responsiveAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        return new ResponsiveRecyclerAdapter(responsiveAdapterPresenter, itemBinder);
    }

    @Provides
    @NotNull
    public final DisplayAnalyzer provideDisplayAnalyzer$photo_picker_release(@NotNull DeviceMetrics deviceMetrics) {
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        return new DisplayAnalyzerImpl(deviceMetrics, this.b.getResources().getDimensionPixelSize(this.k.getThumbnailsListHeight()), this.k);
    }

    @Provides
    @NotNull
    @PerActivity
    public final EditorItemPresenter provideEditorItemPresenter$photo_picker_release(@NotNull Lazy<PhotoPickerPresenter> lazy, @NotNull StoppableRotationInteractor stoppableRotationInteractor, @Named("mode") @NotNull PublishIntentFactory.PhotoPickerMode photoPickerMode) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(stoppableRotationInteractor, "rotationInteractor");
        Intrinsics.checkNotNullParameter(photoPickerMode, "mode");
        return new EditorItemPresenterImpl(lazy, stoppableRotationInteractor, this.j, photoPickerMode);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ExifExtraDataSerializer provideExifExtraDataSerializer(@NotNull ExifExtraDataSerializerImpl exifExtraDataSerializerImpl) {
        Intrinsics.checkNotNullParameter(exifExtraDataSerializerImpl, "serializer");
        return exifExtraDataSerializerImpl;
    }

    @Provides
    @PerActivity
    @NotNull
    public final GalleryResultsExtractor provideGalleryResultsExtractor$photo_picker_release() {
        return new GalleryResultsExtractor();
    }

    @Provides
    @PerActivity
    @NotNull
    public final DeviceOrientationProvider provideOrientationProvider$photo_picker_release(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        return new DeviceOrientationProviderImpl(application);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PermissionHelper providePermissionHelper$photo_picker_release() {
        return new ActivityPermissionHelper(this.b);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PhotoDragAndDrop providePhotoDragAndDrop$photo_picker_release() {
        return new PhotoDragAndDropImpl();
    }

    @Provides
    @PerActivity
    @NotNull
    public final PhotoInteractor providePhotoInteractor$photo_picker_release(@NotNull Application application, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Looper mainLooper = application.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "application.mainLooper");
        ContentResolver contentResolver = application.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "application.contentResolver");
        return new PhotoInteractorImpl(mainLooper, buildInfo, contentResolver, null, 8, null);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PhotoPickerInteractor providePhotoPickerInteractor$photo_picker_release(@NotNull PhotoInteractor photoInteractor, @NotNull SharedPhotosStorage sharedPhotosStorage, @NotNull BitmapFileProvider bitmapFileProvider, @NotNull ThumbnailProvider thumbnailProvider, @NotNull PhotoPickerEventTracker photoPickerEventTracker, @NotNull ComputerVisionInteractor computerVisionInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull ExifExtraDataSerializer exifExtraDataSerializer, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(photoInteractor, "photoInteractor");
        Intrinsics.checkNotNullParameter(sharedPhotosStorage, "sharedPhotosStorage");
        Intrinsics.checkNotNullParameter(bitmapFileProvider, "bitmapFileProvider");
        Intrinsics.checkNotNullParameter(thumbnailProvider, "thumbnailProvider");
        Intrinsics.checkNotNullParameter(photoPickerEventTracker, "tracker");
        Intrinsics.checkNotNullParameter(computerVisionInteractor, "cvInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(exifExtraDataSerializer, "exifExtraDataSerializer");
        Intrinsics.checkNotNullParameter(features, "features");
        return new SingleCachePhotoInteractor(photoInteractor, sharedPhotosStorage, bitmapFileProvider, thumbnailProvider, this.c, this.d, photoPickerEventTracker, computerVisionInteractor, schedulersFactory, exifExtraDataSerializer, features, this.f);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PhotoPickerPresenter providePhotoPickerPresenter$photo_picker_release(@DetailsAdapter @NotNull AdapterPresenter adapterPresenter, @ThumbnailsAdapter @NotNull AdapterPresenter adapterPresenter2, @NotNull PhotoPickerInteractor photoPickerInteractor, @NotNull CameraItemPresenter cameraItemPresenter, @NotNull StoppableRotationInteractor stoppableRotationInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull Analytics analytics, @NotNull PhotoPickerPresenterResourceProvider photoPickerPresenterResourceProvider, @NotNull ComputerVisionInteractor computerVisionInteractor, @NotNull RandomKeyProvider randomKeyProvider, @NotNull PhotoPickerEventTracker photoPickerEventTracker) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "detailsAdapterPresenter");
        Intrinsics.checkNotNullParameter(adapterPresenter2, "thumbnailsAdapterPresenter");
        Intrinsics.checkNotNullParameter(photoPickerInteractor, "photoInteractor");
        Intrinsics.checkNotNullParameter(cameraItemPresenter, "cameraItemPresenter");
        Intrinsics.checkNotNullParameter(stoppableRotationInteractor, "rotationInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(photoPickerPresenterResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(computerVisionInteractor, "cvInteractor");
        Intrinsics.checkNotNullParameter(randomKeyProvider, "keyProvider");
        Intrinsics.checkNotNullParameter(photoPickerEventTracker, "eventTracker");
        return new PhotoPickerPresenterImpl(adapterPresenter, adapterPresenter2, photoPickerInteractor, cameraItemPresenter, stoppableRotationInteractor, photoPickerPresenterResourceProvider, schedulersFactory, this.g, this.h, analytics, this.i, this.j, computerVisionInteractor, randomKeyProvider, photoPickerEventTracker, this.e);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PhotoPickerPresenterResourceProvider providePhotoPickerPresenterResourceProvider$photo_picker_release() {
        return new PhotoPickerPresenterResourceProviderImpl(this.a);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PhotoResizer providePhotoSaver$photo_picker_release(@NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        if (this.i) {
            return new LegacyPhotoResizer(schedulersFactory, 95);
        }
        return new SimplePhotoResizer();
    }

    @Provides
    @PerActivity
    @NotNull
    public final CallableResponsiveItemPresenterRegistry provideResponsiveItemPresenterRegistry$photo_picker_release() {
        return new CallableResponsiveItemPresenterRegistryImpl();
    }

    @Provides
    @PerActivity
    @NotNull
    public final RotationInteractor provideRotationInteractor$photo_picker_release(@NotNull StoppableRotationInteractor stoppableRotationInteractor) {
        Intrinsics.checkNotNullParameter(stoppableRotationInteractor, "rotationInteractor");
        return stoppableRotationInteractor;
    }

    @Provides
    @PerActivity
    @NotNull
    public final StoppableRotationInteractor provideStoppableRotationInteractor$photo_picker_release(@NotNull DeviceOrientationProvider deviceOrientationProvider) {
        Intrinsics.checkNotNullParameter(deviceOrientationProvider, "orientationProvider");
        return new StoppableRotationInteractorImpl(deviceOrientationProvider);
    }

    @Provides
    @NotNull
    @ThumbnailBlueprint
    @PerActivity
    public final ItemBlueprint<ThumbnailItemView, BasePhotoItem> provideThumbnailItemBlueprint$photo_picker_release(@NotNull ThumbnailItemPresenter thumbnailItemPresenter) {
        Intrinsics.checkNotNullParameter(thumbnailItemPresenter, "itemPresenter");
        return new ThumbnailItemBluePrint(thumbnailItemPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ThumbnailProvider provideThumbnailProvider(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        ContentResolver contentResolver = application.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "application.contentResolver");
        return new ThumbnailProviderImpl(contentResolver);
    }

    @Provides
    @ThumbnailsItemBinder
    @NotNull
    @PerActivity
    public final ItemBinder provideThumbnailsItemBinder$photo_picker_release(@ThumbnailBlueprint @NotNull ItemBlueprint<ThumbnailItemView, BasePhotoItem> itemBlueprint) {
        Intrinsics.checkNotNullParameter(itemBlueprint, "itemBluePrint");
        return new ItemBinder.Builder().registerItem(itemBlueprint).build();
    }

    @Provides
    @ThumbnailsAdapter
    @NotNull
    @PerActivity
    public final SimpleRecyclerAdapter provideThumbnailsRecyclerAdapter$photo_picker_release(@ThumbnailsAdapter @NotNull AdapterPresenter adapterPresenter, @ThumbnailsItemBinder @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @DetailsAdapter
    @Provides
    @NotNull
    @PerActivity
    public final AdapterPresenter providesDetailsAdapterPresenter$photo_picker_release(@DetailsItemBinder @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @NotNull
    @PerActivity
    public final ThumbnailItemPresenter providesPhotoItemPresenter$photo_picker_release(@NotNull Lazy<PhotoPickerPresenter> lazy, @NotNull StoppableRotationInteractor stoppableRotationInteractor) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(stoppableRotationInteractor, "rotationInteractor");
        return new ThumbnailItemPresenterImpl(lazy, stoppableRotationInteractor);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ResponsiveAdapterPresenter providesResponsiveAdapterPresenter$photo_picker_release(@DetailsAdapter @NotNull AdapterPresenter adapterPresenter, @NotNull CallableResponsiveItemPresenterRegistry callableResponsiveItemPresenterRegistry) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "delegate");
        Intrinsics.checkNotNullParameter(callableResponsiveItemPresenterRegistry, "registry");
        return new ResponsiveAdapterPresenterImpl(adapterPresenter, callableResponsiveItemPresenterRegistry);
    }

    @Provides
    @ThumbnailsAdapter
    @NotNull
    @PerActivity
    public final AdapterPresenter providesThumbnailsAdapterPresenter$photo_picker_release(@ThumbnailsItemBinder @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }
}
