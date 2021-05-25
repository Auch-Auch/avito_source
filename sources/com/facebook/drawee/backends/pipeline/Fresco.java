package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import javax.annotation.Nullable;
public class Fresco {
    public static PipelineDraweeControllerBuilderSupplier a = null;
    public static volatile boolean b = false;

    public static PipelineDraweeControllerBuilderSupplier getDraweeControllerBuilderSupplier() {
        return a;
    }

    public static ImagePipeline getImagePipeline() {
        return getImagePipelineFactory().getImagePipeline();
    }

    public static ImagePipelineFactory getImagePipelineFactory() {
        return ImagePipelineFactory.getInstance();
    }

    public static boolean hasBeenInitialized() {
        return b;
    }

    public static void initialize(Context context) {
        initialize(context, null, null);
    }

    public static PipelineDraweeControllerBuilder newDraweeControllerBuilder() {
        return a.get();
    }

    public static void shutDown() {
        a = null;
        SimpleDraweeView.shutDown();
        ImagePipelineFactory.shutDown();
    }

    public static void initialize(Context context, @Nullable ImagePipelineConfig imagePipelineConfig) {
        initialize(context, imagePipelineConfig, null);
    }

    public static void initialize(Context context, @Nullable ImagePipelineConfig imagePipelineConfig, @Nullable DraweeConfig draweeConfig) {
        initialize(context, imagePipelineConfig, draweeConfig, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing() != false) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005e, code lost:
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing() == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006d, code lost:
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing() == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007c, code lost:
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing() == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008b, code lost:
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing() == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008d, code lost:
        com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void initialize(android.content.Context r5, @javax.annotation.Nullable com.facebook.imagepipeline.core.ImagePipelineConfig r6, @javax.annotation.Nullable com.facebook.drawee.backends.pipeline.DraweeConfig r7, boolean r8) {
        /*
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = "Fresco#initialize"
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection(r0)
        L_0x000b:
            boolean r0 = com.facebook.drawee.backends.pipeline.Fresco.b
            r1 = 1
            if (r0 == 0) goto L_0x0018
            java.lang.Class<com.facebook.drawee.backends.pipeline.Fresco> r0 = com.facebook.drawee.backends.pipeline.Fresco.class
            java.lang.String r2 = "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!"
            com.facebook.common.logging.FLog.w(r0, r2)
            goto L_0x001a
        L_0x0018:
            com.facebook.drawee.backends.pipeline.Fresco.b = r1
        L_0x001a:
            com.facebook.imagepipeline.core.NativeCodeSetup.setUseNativeCode(r8)
            boolean r8 = com.facebook.soloader.nativeloader.NativeLoader.isInitialized()
            if (r8 != 0) goto L_0x009b
            boolean r8 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r8 == 0) goto L_0x002e
            java.lang.String r8 = "Fresco.initialize->SoLoader.init"
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection(r8)
        L_0x002e:
            java.lang.String r8 = "com.facebook.imagepipeline.nativecode.NativeCodeInitializer"
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ ClassNotFoundException -> 0x007f, IllegalAccessException -> 0x0070, InvocationTargetException -> 0x0061, NoSuchMethodException -> 0x0052 }
            java.lang.String r0 = "init"
            java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch:{ ClassNotFoundException -> 0x007f, IllegalAccessException -> 0x0070, InvocationTargetException -> 0x0061, NoSuchMethodException -> 0x0052 }
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r4 = 0
            r2[r4] = r3     // Catch:{ ClassNotFoundException -> 0x007f, IllegalAccessException -> 0x0070, InvocationTargetException -> 0x0061, NoSuchMethodException -> 0x0052 }
            java.lang.reflect.Method r8 = r8.getMethod(r0, r2)     // Catch:{ ClassNotFoundException -> 0x007f, IllegalAccessException -> 0x0070, InvocationTargetException -> 0x0061, NoSuchMethodException -> 0x0052 }
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ ClassNotFoundException -> 0x007f, IllegalAccessException -> 0x0070, InvocationTargetException -> 0x0061, NoSuchMethodException -> 0x0052 }
            r1[r4] = r5     // Catch:{ ClassNotFoundException -> 0x007f, IllegalAccessException -> 0x0070, InvocationTargetException -> 0x0061, NoSuchMethodException -> 0x0052 }
            r8.invoke(r0, r1)     // Catch:{ ClassNotFoundException -> 0x007f, IllegalAccessException -> 0x0070, InvocationTargetException -> 0x0061, NoSuchMethodException -> 0x0052 }
            boolean r8 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r8 == 0) goto L_0x009b
            goto L_0x008d
        L_0x0050:
            r5 = move-exception
            goto L_0x0091
        L_0x0052:
            com.facebook.soloader.nativeloader.SystemDelegate r8 = new com.facebook.soloader.nativeloader.SystemDelegate     // Catch:{ all -> 0x0050 }
            r8.<init>()     // Catch:{ all -> 0x0050 }
            com.facebook.soloader.nativeloader.NativeLoader.init(r8)     // Catch:{ all -> 0x0050 }
            boolean r8 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r8 == 0) goto L_0x009b
            goto L_0x008d
        L_0x0061:
            com.facebook.soloader.nativeloader.SystemDelegate r8 = new com.facebook.soloader.nativeloader.SystemDelegate
            r8.<init>()
            com.facebook.soloader.nativeloader.NativeLoader.init(r8)
            boolean r8 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r8 == 0) goto L_0x009b
            goto L_0x008d
        L_0x0070:
            com.facebook.soloader.nativeloader.SystemDelegate r8 = new com.facebook.soloader.nativeloader.SystemDelegate
            r8.<init>()
            com.facebook.soloader.nativeloader.NativeLoader.init(r8)
            boolean r8 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r8 == 0) goto L_0x009b
            goto L_0x008d
        L_0x007f:
            com.facebook.soloader.nativeloader.SystemDelegate r8 = new com.facebook.soloader.nativeloader.SystemDelegate
            r8.<init>()
            com.facebook.soloader.nativeloader.NativeLoader.init(r8)
            boolean r8 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r8 == 0) goto L_0x009b
        L_0x008d:
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
            goto L_0x009b
        L_0x0091:
            boolean r6 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r6 == 0) goto L_0x009a
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x009a:
            throw r5
        L_0x009b:
            android.content.Context r5 = r5.getApplicationContext()
            if (r6 != 0) goto L_0x00a5
            com.facebook.imagepipeline.core.ImagePipelineFactory.initialize(r5)
            goto L_0x00a8
        L_0x00a5:
            com.facebook.imagepipeline.core.ImagePipelineFactory.initialize(r6)
        L_0x00a8:
            boolean r6 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r6 == 0) goto L_0x00b3
            java.lang.String r6 = "Fresco.initializeDrawee"
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection(r6)
        L_0x00b3:
            com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilderSupplier r6 = new com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilderSupplier
            r6.<init>(r5, r7)
            com.facebook.drawee.backends.pipeline.Fresco.a = r6
            com.facebook.drawee.view.SimpleDraweeView.initialize(r6)
            boolean r5 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r5 == 0) goto L_0x00c6
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x00c6:
            boolean r5 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r5 == 0) goto L_0x00cf
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.backends.pipeline.Fresco.initialize(android.content.Context, com.facebook.imagepipeline.core.ImagePipelineConfig, com.facebook.drawee.backends.pipeline.DraweeConfig, boolean):void");
    }
}
