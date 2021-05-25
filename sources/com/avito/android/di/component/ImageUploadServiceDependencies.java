package com.avito.android.di.component;

import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.photo_picker.legacy.remote.PickerApi;
import com.avito.android.util.PrivatePhotosStorage;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.Messenger;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/di/component/ImageUploadServiceDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/photo_picker/legacy/remote/PickerApi;", "pickerApi", "()Lcom/avito/android/photo_picker/legacy/remote/PickerApi;", "Lru/avito/messenger/Messenger;", "Lru/avito/messenger/api/AvitoMessengerApi;", "messenger", "()Lru/avito/messenger/Messenger;", "Lcom/avito/android/util/PrivatePhotosStorage;", "privatePhotosStorage", "()Lcom/avito/android/util/PrivatePhotosStorage;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface ImageUploadServiceDependencies extends CoreComponentDependencies {
    @NotNull
    Messenger<AvitoMessengerApi> messenger();

    @NotNull
    PickerApi pickerApi();

    @Override // com.avito.android.photo_picker.legacy.di.PhotoPickerDependencies, com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.photo_wizard.di.WizardImageUploadDependencies
    @NotNull
    PrivatePhotosStorage privatePhotosStorage();
}
