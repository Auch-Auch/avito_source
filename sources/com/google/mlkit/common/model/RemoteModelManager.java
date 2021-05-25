package com.google.mlkit.common.model;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.inject.Provider;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class RemoteModelManager {
    public final Map<Class<? extends RemoteModel>, Provider<? extends RemoteModelManagerInterface<? extends RemoteModel>>> a = new HashMap();

    @KeepForSdk
    public static class RemoteModelManagerRegistration {
        public final Class<? extends RemoteModel> a;
        public final Provider<? extends RemoteModelManagerInterface<? extends RemoteModel>> b;

        @KeepForSdk
        public <RemoteT extends RemoteModel> RemoteModelManagerRegistration(Class<RemoteT> cls, Provider<? extends RemoteModelManagerInterface<RemoteT>> provider) {
            this.a = cls;
            this.b = provider;
        }
    }

    @KeepForSdk
    public RemoteModelManager(Set<RemoteModelManagerRegistration> set) {
        for (RemoteModelManagerRegistration remoteModelManagerRegistration : set) {
            this.a.put(remoteModelManagerRegistration.a, remoteModelManagerRegistration.b);
        }
    }

    @NonNull
    public static synchronized RemoteModelManager getInstance() {
        RemoteModelManager remoteModelManager;
        synchronized (RemoteModelManager.class) {
            remoteModelManager = (RemoteModelManager) MlKitContext.getInstance().get(RemoteModelManager.class);
        }
        return remoteModelManager;
    }

    public final RemoteModelManagerInterface<RemoteModel> a(Class<? extends RemoteModel> cls) {
        return (RemoteModelManagerInterface) this.a.get(cls).get();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.mlkit.common.model.RemoteModelManager */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public Task<Void> deleteDownloadedModel(@NonNull RemoteModel remoteModel) {
        Preconditions.checkNotNull(remoteModel, "RemoteModel cannot be null");
        return a(remoteModel.getClass()).deleteDownloadedModel(remoteModel);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.mlkit.common.model.RemoteModelManager */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public Task<Void> download(@NonNull RemoteModel remoteModel, @NonNull DownloadConditions downloadConditions) {
        Preconditions.checkNotNull(remoteModel, "RemoteModel cannot be null");
        Preconditions.checkNotNull(downloadConditions, "DownloadConditions cannot be null");
        if (this.a.containsKey(remoteModel.getClass())) {
            return a(remoteModel.getClass()).download(remoteModel, downloadConditions);
        }
        String simpleName = remoteModel.getClass().getSimpleName();
        return Tasks.forException(new MlKitException(a.s2(simpleName.length() + 70, "Feature model '", simpleName, "' doesn't have a corresponding modelmanager registered."), 13));
    }

    @NonNull
    public <T extends RemoteModel> Task<Set<T>> getDownloadedModels(@NonNull Class<T> cls) {
        return ((RemoteModelManagerInterface) this.a.get(cls).get()).getDownloadedModels();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.mlkit.common.model.RemoteModelManager */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public Task<Boolean> isModelDownloaded(@NonNull RemoteModel remoteModel) {
        Preconditions.checkNotNull(remoteModel, "RemoteModel cannot be null");
        return a(remoteModel.getClass()).isModelDownloaded(remoteModel);
    }
}
