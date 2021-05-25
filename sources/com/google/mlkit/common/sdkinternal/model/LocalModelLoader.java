package com.google.mlkit.common.sdkinternal.model;

import a2.b.a.a.a;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzan;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.LocalModel;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
@KeepForSdk
public class LocalModelLoader {
    public MappedByteBuffer a;
    public final Context b;
    public final LocalModel c;

    @KeepForSdk
    public LocalModelLoader(@NonNull Context context, @NonNull LocalModel localModel) {
        this.b = context;
        this.c = localModel;
    }

    @KeepForSdk
    public LocalModel getLocalModel() {
        return this.c;
    }

    @NonNull
    @KeepForSdk
    @WorkerThread
    public MappedByteBuffer load() throws MlKitException {
        Preconditions.checkNotNull(this.b, "Context can not be null");
        Preconditions.checkNotNull(this.c, "Model source can not be null");
        MappedByteBuffer mappedByteBuffer = this.a;
        if (mappedByteBuffer != null) {
            return mappedByteBuffer;
        }
        if (this.c.getAbsoluteFilePath() != null) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.c.getAbsoluteFilePath(), "r");
                try {
                    FileChannel channel = randomAccessFile.getChannel();
                    this.a = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
                    randomAccessFile.close();
                    return this.a;
                } catch (Throwable th) {
                    zzan.zza(th, th);
                }
            } catch (IOException e) {
                String valueOf = String.valueOf(this.c.getAbsoluteFilePath());
                throw new MlKitException(valueOf.length() != 0 ? "Can not open the local file: ".concat(valueOf) : new String("Can not open the local file: "), 14, e);
            }
        } else if (this.c.getAssetFilePath() != null) {
            String assetFilePath = this.c.getAssetFilePath();
            try {
                AssetFileDescriptor openFd = this.b.getAssets().openFd(assetFilePath);
                try {
                    this.a = new FileInputStream(openFd.getFileDescriptor()).getChannel().map(FileChannel.MapMode.READ_ONLY, openFd.getStartOffset(), openFd.getDeclaredLength());
                    openFd.close();
                    return this.a;
                } catch (Throwable th2) {
                    zzan.zza(th, th2);
                }
            } catch (IOException e2) {
                throw new MlKitException(a.s2(a.q0(assetFilePath, 186), "Can not load the file from asset: ", assetFilePath, ". Please double check your asset file name and ensure it's not compressed. See documentation for details how to use aaptOptions to skip file compression"), 14, e2);
            }
        } else {
            throw new MlKitException("Can not load the model. Either filePath or assetFilePath must be set for the model.", 14);
        }
        throw th;
        throw th;
    }
}
