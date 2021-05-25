package com.voximplant.sdk.internal.hardware;

import a2.b.a.a.a;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import com.voximplant.sdk.hardware.AudioFileUsage;
import com.voximplant.sdk.hardware.IAudioFile;
import com.voximplant.sdk.hardware.IAudioFileListener;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.SharedData;
import com.voximplant.sdk.internal.hardware.AudioFile;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class AudioFile implements IAudioFile, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener {
    public MediaPlayer a;
    public IAudioFileListener b;
    public String c;
    public boolean d;
    public boolean e;
    public ExecutorService f = Executors.newSingleThreadExecutor();

    public final int a(AudioFileUsage audioFileUsage) {
        int ordinal = audioFileUsage.ordinal();
        if (ordinal == 0) {
            return 3;
        }
        if (ordinal != 1) {
            return ordinal != 2 ? 0 : 6;
        }
        return 7;
    }

    public void b(boolean z) {
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer != null) {
            AudioFile audioFile = null;
            mediaPlayer.setOnPreparedListener(z ? this : null);
            this.a.setOnCompletionListener(z ? this : null);
            MediaPlayer mediaPlayer2 = this.a;
            if (z) {
                audioFile = this;
            }
            mediaPlayer2.setOnErrorListener(audioFile);
        }
    }

    public final void c() {
        Logger.i(this.c + Tracker.Events.CREATIVE_START);
        this.f.execute(new Runnable() { // from class: a2.t.a.c.p0.f
            @Override // java.lang.Runnable
            public final void run() {
                AudioFile audioFile = AudioFile.this;
                Objects.requireNonNull(audioFile);
                try {
                    audioFile.a.start();
                    audioFile.e = false;
                    IAudioFileListener iAudioFileListener = audioFile.b;
                    if (iAudioFileListener != null) {
                        Logger.i(audioFile.c + "Invoke onStart");
                        Executor callbackExecutor = SharedData.getCallbackExecutor();
                        if (callbackExecutor != null) {
                            callbackExecutor.execute(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0032: INVOKE  
                                  (r2v3 'callbackExecutor' java.util.concurrent.Executor)
                                  (wrap: a2.t.a.c.p0.a : 0x002f: CONSTRUCTOR  (r3v2 a2.t.a.c.p0.a) = 
                                  (r0v0 'audioFile' com.voximplant.sdk.internal.hardware.AudioFile)
                                  (r1v3 'iAudioFileListener' com.voximplant.sdk.hardware.IAudioFileListener)
                                 call: a2.t.a.c.p0.a.<init>(com.voximplant.sdk.internal.hardware.AudioFile, com.voximplant.sdk.hardware.IAudioFileListener):void type: CONSTRUCTOR)
                                 type: INTERFACE call: java.util.concurrent.Executor.execute(java.lang.Runnable):void in method: a2.t.a.c.p0.f.run():void, file: classes8.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:316)
                                	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002f: CONSTRUCTOR  (r3v2 a2.t.a.c.p0.a) = 
                                  (r0v0 'audioFile' com.voximplant.sdk.internal.hardware.AudioFile)
                                  (r1v3 'iAudioFileListener' com.voximplant.sdk.hardware.IAudioFileListener)
                                 call: a2.t.a.c.p0.a.<init>(com.voximplant.sdk.internal.hardware.AudioFile, com.voximplant.sdk.hardware.IAudioFileListener):void type: CONSTRUCTOR in method: a2.t.a.c.p0.f.run():void, file: classes8.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                                	... 33 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.t.a.c.p0.a, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                                	... 39 more
                                */
                            /*
                                this = this;
                                com.voximplant.sdk.internal.hardware.AudioFile r0 = com.voximplant.sdk.internal.hardware.AudioFile.this
                                java.util.Objects.requireNonNull(r0)
                                android.media.MediaPlayer r1 = r0.a     // Catch:{ IllegalStateException -> 0x003a }
                                r1.start()     // Catch:{ IllegalStateException -> 0x003a }
                                r1 = 0
                                r0.e = r1
                                com.voximplant.sdk.hardware.IAudioFileListener r1 = r0.b
                                if (r1 == 0) goto L_0x0058
                                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                r2.<init>()
                                java.lang.String r3 = r0.c
                                r2.append(r3)
                                java.lang.String r3 = "Invoke onStart"
                                r2.append(r3)
                                java.lang.String r2 = r2.toString()
                                com.voximplant.sdk.internal.Logger.i(r2)
                                java.util.concurrent.Executor r2 = com.voximplant.sdk.internal.SharedData.getCallbackExecutor()
                                if (r2 == 0) goto L_0x0036
                                a2.t.a.c.p0.a r3 = new a2.t.a.c.p0.a
                                r3.<init>(r0, r1)
                                r2.execute(r3)
                                goto L_0x0058
                            L_0x0036:
                                r1.onStart(r0)
                                goto L_0x0058
                            L_0x003a:
                                r1 = move-exception
                                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                r2.<init>()
                                java.lang.String r0 = r0.c
                                r2.append(r0)
                                java.lang.String r0 = "failed to start playing file: illegal state "
                                r2.append(r0)
                                java.lang.String r0 = r1.getMessage()
                                r2.append(r0)
                                java.lang.String r0 = r2.toString()
                                com.voximplant.sdk.internal.Logger.e(r0)
                            L_0x0058:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.p0.f.run():void");
                        }
                    });
                }

                public boolean initialize(Context context, Uri uri, AudioFileUsage audioFileUsage) {
                    if (context == null || uri == null) {
                        Logger.e("AudioFile: context or uri is null");
                        return false;
                    }
                    String uri2 = uri.toString();
                    StringBuilder L = a.L("AudioFile(");
                    L.append(uri2.substring(uri2.length() <= 10 ? 0 : uri2.length() - 10));
                    L.append("): ");
                    this.c = L.toString();
                    this.a = new MediaPlayer();
                    b(true);
                    try {
                        this.a.setDataSource(context, uri, (Map<String, String>) null);
                        this.a.setAudioAttributes(new AudioAttributes.Builder().setUsage(a(audioFileUsage)).setContentType(0).build());
                        this.a.prepareAsync();
                        return true;
                    } catch (IOException e2) {
                        Logger.e(this.c + "failed to set data source: " + e2.getMessage());
                        return false;
                    }
                }

                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    this.f.execute(new Runnable() { // from class: a2.t.a.c.p0.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            AudioFile audioFile = AudioFile.this;
                            if (Build.VERSION.SDK_INT >= 23 || !audioFile.a.isPlaying()) {
                                Logger.i(audioFile.c + "onCompletion: audio file has stopped playing");
                                IAudioFileListener iAudioFileListener = audioFile.b;
                                if (iAudioFileListener != null) {
                                    Logger.i(audioFile.c + "Invoke onStop");
                                    Executor callbackExecutor = SharedData.getCallbackExecutor();
                                    if (callbackExecutor != null) {
                                        callbackExecutor.execute(
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004c: INVOKE  
                                              (r2v5 'callbackExecutor' java.util.concurrent.Executor)
                                              (wrap: a2.t.a.c.p0.c : 0x0049: CONSTRUCTOR  (r3v2 a2.t.a.c.p0.c) = 
                                              (r0v0 'audioFile' com.voximplant.sdk.internal.hardware.AudioFile)
                                              (r1v3 'iAudioFileListener' com.voximplant.sdk.hardware.IAudioFileListener)
                                             call: a2.t.a.c.p0.c.<init>(com.voximplant.sdk.internal.hardware.AudioFile, com.voximplant.sdk.hardware.IAudioFileListener):void type: CONSTRUCTOR)
                                             type: INTERFACE call: java.util.concurrent.Executor.execute(java.lang.Runnable):void in method: a2.t.a.c.p0.i.run():void, file: classes8.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0049: CONSTRUCTOR  (r3v2 a2.t.a.c.p0.c) = 
                                              (r0v0 'audioFile' com.voximplant.sdk.internal.hardware.AudioFile)
                                              (r1v3 'iAudioFileListener' com.voximplant.sdk.hardware.IAudioFileListener)
                                             call: a2.t.a.c.p0.c.<init>(com.voximplant.sdk.internal.hardware.AudioFile, com.voximplant.sdk.hardware.IAudioFileListener):void type: CONSTRUCTOR in method: a2.t.a.c.p0.i.run():void, file: classes8.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                                            	... 33 more
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.t.a.c.p0.c, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                                            	... 39 more
                                            */
                                        /*
                                            this = this;
                                            com.voximplant.sdk.internal.hardware.AudioFile r0 = com.voximplant.sdk.internal.hardware.AudioFile.this
                                            int r1 = android.os.Build.VERSION.SDK_INT
                                            r2 = 23
                                            if (r1 >= r2) goto L_0x0011
                                            android.media.MediaPlayer r1 = r0.a
                                            boolean r1 = r1.isPlaying()
                                            if (r1 == 0) goto L_0x0011
                                            goto L_0x0053
                                        L_0x0011:
                                            java.lang.StringBuilder r1 = new java.lang.StringBuilder
                                            r1.<init>()
                                            java.lang.String r2 = r0.c
                                            r1.append(r2)
                                            java.lang.String r2 = "onCompletion: audio file has stopped playing"
                                            r1.append(r2)
                                            java.lang.String r1 = r1.toString()
                                            com.voximplant.sdk.internal.Logger.i(r1)
                                            com.voximplant.sdk.hardware.IAudioFileListener r1 = r0.b
                                            if (r1 == 0) goto L_0x0053
                                            java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                            r2.<init>()
                                            java.lang.String r3 = r0.c
                                            r2.append(r3)
                                            java.lang.String r3 = "Invoke onStop"
                                            r2.append(r3)
                                            java.lang.String r2 = r2.toString()
                                            com.voximplant.sdk.internal.Logger.i(r2)
                                            java.util.concurrent.Executor r2 = com.voximplant.sdk.internal.SharedData.getCallbackExecutor()
                                            if (r2 == 0) goto L_0x0050
                                            a2.t.a.c.p0.c r3 = new a2.t.a.c.p0.c
                                            r3.<init>(r0, r1)
                                            r2.execute(r3)
                                            goto L_0x0053
                                        L_0x0050:
                                            r1.onStop(r0)
                                        L_0x0053:
                                            return
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.p0.i.run():void");
                                    }
                                });
                            }

                            @Override // android.media.MediaPlayer.OnErrorListener
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                Logger.i(this.c + "onError: code: " + i + ", extra: " + i2);
                                IAudioFileListener iAudioFileListener = this.b;
                                if (iAudioFileListener == null) {
                                    return true;
                                }
                                Logger.i(this.c + "Invoke onStop");
                                Executor callbackExecutor = SharedData.getCallbackExecutor();
                                if (callbackExecutor != null) {
                                    callbackExecutor.execute(new Runnable(iAudioFileListener) { // from class: a2.t.a.c.p0.h
                                        public final /* synthetic */ IAudioFileListener b;

                                        {
                                            this.b = r2;
                                        }

                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            AudioFile audioFile = AudioFile.this;
                                            IAudioFileListener iAudioFileListener2 = this.b;
                                            Objects.requireNonNull(audioFile);
                                            iAudioFileListener2.onStop(audioFile);
                                        }
                                    });
                                    return true;
                                }
                                iAudioFileListener.onStop(this);
                                return true;
                            }

                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                Logger.i(this.c + "onPrepared");
                                this.f.execute(new Runnable() { // from class: a2.t.a.c.p0.j
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        AudioFile audioFile = AudioFile.this;
                                        audioFile.d = true;
                                        if (audioFile.e) {
                                            audioFile.c();
                                        }
                                        IAudioFileListener iAudioFileListener = audioFile.b;
                                        if (iAudioFileListener != null) {
                                            Logger.i(audioFile.c + "Invoke onPrepared");
                                            Executor callbackExecutor = SharedData.getCallbackExecutor();
                                            if (callbackExecutor != null) {
                                                callbackExecutor.execute(
                                                /*  JADX ERROR: Method code generation error
                                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0031: INVOKE  
                                                      (r2v2 'callbackExecutor' java.util.concurrent.Executor)
                                                      (wrap: a2.t.a.c.p0.k : 0x002e: CONSTRUCTOR  (r3v2 a2.t.a.c.p0.k) = 
                                                      (r0v0 'audioFile' com.voximplant.sdk.internal.hardware.AudioFile)
                                                      (r1v2 'iAudioFileListener' com.voximplant.sdk.hardware.IAudioFileListener)
                                                     call: a2.t.a.c.p0.k.<init>(com.voximplant.sdk.internal.hardware.AudioFile, com.voximplant.sdk.hardware.IAudioFileListener):void type: CONSTRUCTOR)
                                                     type: INTERFACE call: java.util.concurrent.Executor.execute(java.lang.Runnable):void in method: a2.t.a.c.p0.j.run():void, file: classes8.dex
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002e: CONSTRUCTOR  (r3v2 a2.t.a.c.p0.k) = 
                                                      (r0v0 'audioFile' com.voximplant.sdk.internal.hardware.AudioFile)
                                                      (r1v2 'iAudioFileListener' com.voximplant.sdk.hardware.IAudioFileListener)
                                                     call: a2.t.a.c.p0.k.<init>(com.voximplant.sdk.internal.hardware.AudioFile, com.voximplant.sdk.hardware.IAudioFileListener):void type: CONSTRUCTOR in method: a2.t.a.c.p0.j.run():void, file: classes8.dex
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                                                    	... 27 more
                                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.t.a.c.p0.k, state: NOT_LOADED
                                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                                                    	... 33 more
                                                    */
                                                /*
                                                    this = this;
                                                    com.voximplant.sdk.internal.hardware.AudioFile r0 = com.voximplant.sdk.internal.hardware.AudioFile.this
                                                    r1 = 1
                                                    r0.d = r1
                                                    boolean r1 = r0.e
                                                    if (r1 == 0) goto L_0x000c
                                                    r0.c()
                                                L_0x000c:
                                                    com.voximplant.sdk.hardware.IAudioFileListener r1 = r0.b
                                                    if (r1 == 0) goto L_0x0038
                                                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                                    r2.<init>()
                                                    java.lang.String r3 = r0.c
                                                    r2.append(r3)
                                                    java.lang.String r3 = "Invoke onPrepared"
                                                    r2.append(r3)
                                                    java.lang.String r2 = r2.toString()
                                                    com.voximplant.sdk.internal.Logger.i(r2)
                                                    java.util.concurrent.Executor r2 = com.voximplant.sdk.internal.SharedData.getCallbackExecutor()
                                                    if (r2 == 0) goto L_0x0035
                                                    a2.t.a.c.p0.k r3 = new a2.t.a.c.p0.k
                                                    r3.<init>(r0, r1)
                                                    r2.execute(r3)
                                                    goto L_0x0038
                                                L_0x0035:
                                                    r1.onPrepared(r0)
                                                L_0x0038:
                                                    return
                                                */
                                                throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.p0.j.run():void");
                                            }
                                        });
                                    }

                                    @Override // com.voximplant.sdk.hardware.IAudioFile
                                    public void play(boolean z) {
                                        Logger.i(this.c + "play: loop: " + z);
                                        this.f.execute(new Runnable(z) { // from class: a2.t.a.c.p0.d
                                            public final /* synthetic */ boolean b;

                                            {
                                                this.b = r2;
                                            }

                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                AudioFile audioFile = AudioFile.this;
                                                boolean z2 = this.b;
                                                MediaPlayer mediaPlayer = audioFile.a;
                                                if (mediaPlayer == null) {
                                                    Logger.e(audioFile.c + "failed to play file: MediaPlayer is not created");
                                                    return;
                                                }
                                                mediaPlayer.setLooping(z2);
                                                if (audioFile.d) {
                                                    audioFile.c();
                                                } else {
                                                    audioFile.e = true;
                                                }
                                            }
                                        });
                                    }

                                    @Override // com.voximplant.sdk.hardware.IAudioFile
                                    public void release() {
                                        Logger.i(this.c + "release");
                                        this.f.execute(new Runnable() { // from class: a2.t.a.c.p0.b
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                AudioFile audioFile = AudioFile.this;
                                                if (audioFile.a == null) {
                                                    Logger.e(audioFile.c + "release: MediaPlayer is not created");
                                                    return;
                                                }
                                                audioFile.b(false);
                                                audioFile.a.release();
                                                audioFile.a = null;
                                                audioFile.b = null;
                                            }
                                        });
                                    }

                                    @Override // com.voximplant.sdk.hardware.IAudioFile
                                    public void setAudioFileListener(IAudioFileListener iAudioFileListener) {
                                        this.b = iAudioFileListener;
                                    }

                                    @Override // com.voximplant.sdk.hardware.IAudioFile
                                    public void stop(boolean z) {
                                        Logger.i(this.c + "stop: pause: " + z);
                                        this.f.execute(new Runnable(z) { // from class: a2.t.a.c.p0.e
                                            public final /* synthetic */ boolean b;

                                            {
                                                this.b = r2;
                                            }

                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                AudioFile audioFile = AudioFile.this;
                                                boolean z2 = this.b;
                                                MediaPlayer mediaPlayer = audioFile.a;
                                                if (mediaPlayer == null) {
                                                    Logger.e(audioFile.c + "failed to stop playing file: MediaPlayer is not created");
                                                } else if (!mediaPlayer.isPlaying()) {
                                                    Logger.e(audioFile.c + "failed to stop playing file: MediaPlayer is not playing");
                                                } else {
                                                    if (z2) {
                                                        try {
                                                            audioFile.a.pause();
                                                        } catch (IllegalStateException e2) {
                                                            Logger.e(audioFile.c + "failed to stop playing file: illegal state: " + e2.getMessage());
                                                            return;
                                                        }
                                                    } else {
                                                        audioFile.a.stop();
                                                    }
                                                    IAudioFileListener iAudioFileListener = audioFile.b;
                                                    if (iAudioFileListener != null) {
                                                        Logger.i(audioFile.c + "Invoke onStop");
                                                        Executor callbackExecutor = SharedData.getCallbackExecutor();
                                                        if (callbackExecutor != null) {
                                                            callbackExecutor.execute(
                                                            /*  JADX ERROR: Method code generation error
                                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006f: INVOKE  
                                                                  (r2v4 'callbackExecutor' java.util.concurrent.Executor)
                                                                  (wrap: a2.t.a.c.p0.g : 0x006c: CONSTRUCTOR  (r3v2 a2.t.a.c.p0.g) = 
                                                                  (r0v0 'audioFile' com.voximplant.sdk.internal.hardware.AudioFile)
                                                                  (r1v1 'iAudioFileListener' com.voximplant.sdk.hardware.IAudioFileListener)
                                                                 call: a2.t.a.c.p0.g.<init>(com.voximplant.sdk.internal.hardware.AudioFile, com.voximplant.sdk.hardware.IAudioFileListener):void type: CONSTRUCTOR)
                                                                 type: INTERFACE call: java.util.concurrent.Executor.execute(java.lang.Runnable):void in method: a2.t.a.c.p0.e.run():void, file: classes8.dex
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                                                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:150)
                                                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:169)
                                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:146)
                                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                                                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                                                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                                                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                                                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                                                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006c: CONSTRUCTOR  (r3v2 a2.t.a.c.p0.g) = 
                                                                  (r0v0 'audioFile' com.voximplant.sdk.internal.hardware.AudioFile)
                                                                  (r1v1 'iAudioFileListener' com.voximplant.sdk.hardware.IAudioFileListener)
                                                                 call: a2.t.a.c.p0.g.<init>(com.voximplant.sdk.internal.hardware.AudioFile, com.voximplant.sdk.hardware.IAudioFileListener):void type: CONSTRUCTOR in method: a2.t.a.c.p0.e.run():void, file: classes8.dex
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                                                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                                                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                                                                	... 35 more
                                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.t.a.c.p0.g, state: NOT_LOADED
                                                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                                                                	... 41 more
                                                                */
                                                            /*
                                                                this = this;
                                                                com.voximplant.sdk.internal.hardware.AudioFile r0 = com.voximplant.sdk.internal.hardware.AudioFile.this
                                                                boolean r1 = r4.b
                                                                android.media.MediaPlayer r2 = r0.a
                                                                if (r2 != 0) goto L_0x0020
                                                                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                                                                r1.<init>()
                                                                java.lang.String r0 = r0.c
                                                                r1.append(r0)
                                                                java.lang.String r0 = "failed to stop playing file: MediaPlayer is not created"
                                                                r1.append(r0)
                                                                java.lang.String r0 = r1.toString()
                                                                com.voximplant.sdk.internal.Logger.e(r0)
                                                                goto L_0x0095
                                                            L_0x0020:
                                                                boolean r2 = r2.isPlaying()
                                                                if (r2 != 0) goto L_0x003d
                                                                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                                                                r1.<init>()
                                                                java.lang.String r0 = r0.c
                                                                r1.append(r0)
                                                                java.lang.String r0 = "failed to stop playing file: MediaPlayer is not playing"
                                                                r1.append(r0)
                                                                java.lang.String r0 = r1.toString()
                                                                com.voximplant.sdk.internal.Logger.e(r0)
                                                                goto L_0x0095
                                                            L_0x003d:
                                                                if (r1 == 0) goto L_0x0045
                                                                android.media.MediaPlayer r1 = r0.a     // Catch:{ IllegalStateException -> 0x0077 }
                                                                r1.pause()     // Catch:{ IllegalStateException -> 0x0077 }
                                                                goto L_0x004a
                                                            L_0x0045:
                                                                android.media.MediaPlayer r1 = r0.a     // Catch:{ IllegalStateException -> 0x0077 }
                                                                r1.stop()     // Catch:{ IllegalStateException -> 0x0077 }
                                                            L_0x004a:
                                                                com.voximplant.sdk.hardware.IAudioFileListener r1 = r0.b
                                                                if (r1 == 0) goto L_0x0095
                                                                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                                                r2.<init>()
                                                                java.lang.String r3 = r0.c
                                                                r2.append(r3)
                                                                java.lang.String r3 = "Invoke onStop"
                                                                r2.append(r3)
                                                                java.lang.String r2 = r2.toString()
                                                                com.voximplant.sdk.internal.Logger.i(r2)
                                                                java.util.concurrent.Executor r2 = com.voximplant.sdk.internal.SharedData.getCallbackExecutor()
                                                                if (r2 == 0) goto L_0x0073
                                                                a2.t.a.c.p0.g r3 = new a2.t.a.c.p0.g
                                                                r3.<init>(r0, r1)
                                                                r2.execute(r3)
                                                                goto L_0x0095
                                                            L_0x0073:
                                                                r1.onStop(r0)
                                                                goto L_0x0095
                                                            L_0x0077:
                                                                r1 = move-exception
                                                                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                                                r2.<init>()
                                                                java.lang.String r0 = r0.c
                                                                r2.append(r0)
                                                                java.lang.String r0 = "failed to stop playing file: illegal state: "
                                                                r2.append(r0)
                                                                java.lang.String r0 = r1.getMessage()
                                                                r2.append(r0)
                                                                java.lang.String r0 = r2.toString()
                                                                com.voximplant.sdk.internal.Logger.e(r0)
                                                            L_0x0095:
                                                                return
                                                            */
                                                            throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.p0.e.run():void");
                                                        }
                                                    });
                                                }

                                                public boolean initialize(String str, AudioFileUsage audioFileUsage) {
                                                    if (str == null || str.isEmpty()) {
                                                        Logger.e("AudioFile: url is null or empty");
                                                        return false;
                                                    }
                                                    StringBuilder L = a.L("AudioFile(");
                                                    L.append(str.substring(str.length() <= 10 ? 0 : str.length() - 10));
                                                    L.append("): ");
                                                    this.c = L.toString();
                                                    this.a = new MediaPlayer();
                                                    b(true);
                                                    try {
                                                        this.a.setDataSource(str);
                                                        this.a.setAudioAttributes(new AudioAttributes.Builder().setUsage(a(audioFileUsage)).setContentType(0).build());
                                                        this.a.prepareAsync();
                                                        return true;
                                                    } catch (IOException | IllegalArgumentException | IllegalStateException | SecurityException e2) {
                                                        Logger.e(this.c + "failed to set data source: " + e2.getMessage());
                                                        return false;
                                                    }
                                                }

                                                public boolean initialize(Context context, int i, AudioFileUsage audioFileUsage) {
                                                    if (context == null) {
                                                        Logger.e("AudioFile: context is invalid");
                                                        return false;
                                                    }
                                                    this.c = a.Q2("AudioFile(", i, "): ");
                                                    this.a = MediaPlayer.create(context, i, new AudioAttributes.Builder().setUsage(a(audioFileUsage)).setContentType(0).build(), ((AudioManager) context.getSystemService("audio")).generateAudioSessionId());
                                                    b(true);
                                                    if (this.a != null) {
                                                        return true;
                                                    }
                                                    Logger.e(this.c + "Failed to create media player");
                                                    return false;
                                                }
                                            }
