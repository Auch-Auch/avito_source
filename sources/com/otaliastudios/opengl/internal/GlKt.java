package com.otaliastudios.opengl.internal;

import a2.g.r.g;
import android.opengl.GLES20;
import android.opengl.GLES30;
import androidx.annotation.RequiresApi;
import androidx.work.Data;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sumsub.sns.R2;
import com.vk.sdk.api.VKApiConst;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0015\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b_\u001a#\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\t\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006\u001a\u001b\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a#\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a+\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a+\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0019H\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a]\u0010(\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010$H\bø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a#\u0010*\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u0006\u001a#\u0010,\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\bø\u0001\u0000¢\u0006\u0004\b+\u0010\u0006\u001a#\u0010/\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010-\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\b.\u0010\u0012\u001a\u001b\u00102\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a;\u00107\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a#\u00109\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\bø\u0001\u0000¢\u0006\u0004\b8\u0010\u0006\u001a#\u0010;\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\bø\u0001\u0000¢\u0006\u0004\b:\u0010\u0006\u001a#\u0010>\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010<\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\b=\u0010\u0012\u001a+\u0010B\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\bA\u0010\u0017\u001a+\u0010E\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010C\u001a\u00020\n2\u0006\u0010<\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\bD\u0010\u0017\u001a\u001b\u0010G\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\bF\u00101\u001a#\u0010M\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\n2\u0006\u0010J\u001a\u00020IH\bø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001a\u001b\u0010O\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\bN\u0010\r\u001a\u001b\u0010Q\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\bP\u0010\r\u001a#\u0010U\u001a\n R*\u0004\u0018\u00010I0I2\u0006\u0010H\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a+\u0010Z\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010W\u001a\u00020VH\bø\u0001\u0000¢\u0006\u0004\bX\u0010Y\u001a\u0013\u0010[\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\b[\u0010\\\u001a#\u0010_\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\n2\u0006\u0010H\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\b^\u0010\u0012\u001a\u001b\u0010a\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\b`\u0010\r\u001a\u001b\u0010c\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\bb\u0010\r\u001a\u001b\u0010e\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\bd\u0010\r\u001a#\u0010g\u001a\n R*\u0004\u0018\u00010I0I2\u0006\u0010]\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\bf\u0010T\u001a+\u0010i\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010W\u001a\u00020VH\bø\u0001\u0000¢\u0006\u0004\bh\u0010Y\u001a\u001b\u0010k\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\bj\u0010\r\u001a\u001b\u0010m\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\bl\u0010\r\u001a#\u0010q\u001a\u00020\u00002\u0006\u0010]\u001a\u00020\n2\u0006\u0010n\u001a\u00020IH\bø\u0001\u0000¢\u0006\u0004\bo\u0010p\u001a#\u0010s\u001a\u00020\u00002\u0006\u0010]\u001a\u00020\n2\u0006\u0010n\u001a\u00020IH\bø\u0001\u0000¢\u0006\u0004\br\u0010p\u001aC\u0010z\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\n2\u0006\u0010u\u001a\u00020t2\u0006\u0010v\u001a\u00020\u00002\u0006\u0010w\u001a\u00020$H\bø\u0001\u0000¢\u0006\u0004\bx\u0010y\u001a5\u0010\u001a\u00020\u00042\u0006\u0010{\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010|\u001a\u00020t2\n\u0010\u0015\u001a\u00060}j\u0002`~H\b¢\u0006\u0005\b\u0010\u0001\u001a2\u0010\u001a\u00020\u00042\u0006\u0010{\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010|\u001a\u00020t2\u0007\u0010\u0015\u001a\u00030\u0001H\b¢\u0006\u0005\b\u0010\u0001\u001a/\u0010\u0001\u001a\u00020\u00042\u0006\u0010{\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0015\u001a\u00060}j\u0002`~H\b¢\u0006\u0006\b\u0001\u0010\u0001\u001a,\u0010\u0001\u001a\u00020\u00042\u0006\u0010{\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0015\u001a\u00030\u0001H\b¢\u0006\u0006\b\u0001\u0010\u0001\u001a%\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020VH\bø\u0001\u0000¢\u0006\u0005\b\u0001\u0010\u0006\u001a\u0015\u0010\u0001\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0005\b\u0001\u0010\\\u001a/\u0010\u0001\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0005\b\u0001\u0010\u0017\u001a8\u0010\u0001\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020$H\bø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001\" \u0010\u0001\u001a\u00020\u00008\u0000@\u0000XD¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010\\\"#\u0010\u0001\u001a\u00020\n8\u0000@\u0000X\u0004ø\u0001\u0000¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010\\\"#\u0010\u0001\u001a\u00020\n8\u0000@\u0000X\u0004ø\u0001\u0000¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010\\\"#\u0010\u0001\u001a\u00020\n8\u0000@\u0000X\u0004ø\u0001\u0000¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010\\\"#\u0010 \u0001\u001a\u00020\n8\u0000@\u0000X\u0004ø\u0001\u0000¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010\\\"#\u0010£\u0001\u001a\u00020\n8\u0000@\u0000X\u0004ø\u0001\u0000¢\u0006\u000f\n\u0006\b¡\u0001\u0010\u0001\u001a\u0005\b¢\u0001\u0010\\\"#\u0010¦\u0001\u001a\u00020\n8\u0000@\u0000X\u0004ø\u0001\u0000¢\u0006\u000f\n\u0006\b¤\u0001\u0010\u0001\u001a\u0005\b¥\u0001\u0010\\\"!\u0010«\u0001\u001a\u00020\u00198\u0000@\u0000XD¢\u0006\u0010\n\u0006\b§\u0001\u0010¨\u0001\u001a\u0006\b©\u0001\u0010ª\u0001\"!\u0010®\u0001\u001a\u00020\u00198\u0000@\u0000XD¢\u0006\u0010\n\u0006\b¬\u0001\u0010¨\u0001\u001a\u0006\b­\u0001\u0010ª\u0001\"#\u0010±\u0001\u001a\u00020\n8\u0000@\u0000X\u0004ø\u0001\u0000¢\u0006\u000f\n\u0006\b¯\u0001\u0010\u0001\u001a\u0005\b°\u0001\u0010\\\"#\u0010´\u0001\u001a\u00020\n8\u0000@\u0000X\u0004ø\u0001\u0000¢\u0006\u000f\n\u0006\b²\u0001\u0010\u0001\u001a\u0005\b³\u0001\u0010\\\" \u0010µ\u0001\u001a\u00020\u00008\u0000@\u0000XD¢\u0006\u000f\n\u0006\bµ\u0001\u0010\u0001\u001a\u0005\b¶\u0001\u0010\\\"#\u0010¹\u0001\u001a\u00020\n8\u0000@\u0000X\u0004ø\u0001\u0000¢\u0006\u000f\n\u0006\b·\u0001\u0010\u0001\u001a\u0005\b¸\u0001\u0010\\\"#\u0010¼\u0001\u001a\u00020\n8\u0000@\u0000X\u0004ø\u0001\u0000¢\u0006\u000f\n\u0006\bº\u0001\u0010\u0001\u001a\u0005\b»\u0001\u0010\\\"#\u0010¿\u0001\u001a\u00020\n8\u0000@\u0000X\u0004ø\u0001\u0000¢\u0006\u000f\n\u0006\b½\u0001\u0010\u0001\u001a\u0005\b¾\u0001\u0010\\\"#\u0010Â\u0001\u001a\u00020\n8\u0000@\u0000X\u0004ø\u0001\u0000¢\u0006\u000f\n\u0006\bÀ\u0001\u0010\u0001\u001a\u0005\bÁ\u0001\u0010\\\"#\u0010Å\u0001\u001a\u00020\n8\u0000@\u0000X\u0004ø\u0001\u0000¢\u0006\u000f\n\u0006\bÃ\u0001\u0010\u0001\u001a\u0005\bÄ\u0001\u0010\\\"#\u0010È\u0001\u001a\u00020\n8\u0000@\u0000X\u0004ø\u0001\u0000¢\u0006\u000f\n\u0006\bÆ\u0001\u0010\u0001\u001a\u0005\bÇ\u0001\u0010\\\"#\u0010Ë\u0001\u001a\u00020\n8\u0000@\u0001X\u0004ø\u0001\u0000¢\u0006\u000f\n\u0006\bÉ\u0001\u0010\u0001\u001a\u0005\bÊ\u0001\u0010\\\"#\u0010Î\u0001\u001a\u00020\n8\u0000@\u0000X\u0004ø\u0001\u0000¢\u0006\u000f\n\u0006\bÌ\u0001\u0010\u0001\u001a\u0005\bÍ\u0001\u0010\\\" \u0010Ï\u0001\u001a\u00020\u00008\u0000@\u0000XD¢\u0006\u000f\n\u0006\bÏ\u0001\u0010\u0001\u001a\u0005\bÐ\u0001\u0010\\\"#\u0010Ó\u0001\u001a\u00020\n8\u0000@\u0000X\u0004ø\u0001\u0000¢\u0006\u000f\n\u0006\bÑ\u0001\u0010\u0001\u001a\u0005\bÒ\u0001\u0010\\\" \u0010Ö\u0001\u001a\u00020\u00008\u0000@\u0000XD¢\u0006\u000f\n\u0006\bÔ\u0001\u0010\u0001\u001a\u0005\bÕ\u0001\u0010\\\"#\u0010Ù\u0001\u001a\u00020\n8\u0000@\u0000X\u0004ø\u0001\u0000¢\u0006\u000f\n\u0006\b×\u0001\u0010\u0001\u001a\u0005\bØ\u0001\u0010\\\"#\u0010Ü\u0001\u001a\u00020\n8\u0000@\u0000X\u0004ø\u0001\u0000¢\u0006\u000f\n\u0006\bÚ\u0001\u0010\u0001\u001a\u0005\bÛ\u0001\u0010\\\"#\u0010ß\u0001\u001a\u00020\n8\u0000@\u0000X\u0004ø\u0001\u0000¢\u0006\u000f\n\u0006\bÝ\u0001\u0010\u0001\u001a\u0005\bÞ\u0001\u0010\\\u0002\u0004\n\u0002\b\u0019¨\u0006à\u0001"}, d2 = {"", "count", "Lkotlin/UIntArray;", "array", "", "glGenTextures-JrK2_R0", "(I[I)V", "glGenTextures", "glDeleteTextures-JrK2_R0", "glDeleteTextures", "Lkotlin/UInt;", "unit", "glActiveTexture-WZ4Q5Ns", "(I)V", "glActiveTexture", "target", "texture", "glBindTexture-J1ME1BU", "(II)V", "glBindTexture", "parameter", "value", "glTexParameteri-Nkh28Cs", "(III)V", "glTexParameteri", "", "glTexParameterf-CEfty_Q", "(IIF)V", "glTexParameterf", FirebaseAnalytics.Param.LEVEL, "internalFormat", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "border", "format", "type", "Ljava/nio/Buffer;", "pixels", "glTexImage2D-pBdJQSo", "(IIIIIIIILjava/nio/Buffer;)V", "glTexImage2D", "glGenFramebuffers-JrK2_R0", "glGenFramebuffers", "glDeleteFramebuffers-JrK2_R0", "glDeleteFramebuffers", "framebuffer", "glBindFramebuffer-J1ME1BU", "glBindFramebuffer", "glCheckFramebufferStatus-WZ4Q5Ns", "(I)I", "glCheckFramebufferStatus", "attachment", "textureTarget", "glFramebufferTexture2D-fS6bbcI", "(IIIII)V", "glFramebufferTexture2D", "glGenBuffers-JrK2_R0", "glGenBuffers", "glDeleteBuffers-JrK2_R0", "glDeleteBuffers", "id", "glBindBuffer-J1ME1BU", "glBindBuffer", "size", "usage", "glBufferData-xK68qss", "glBufferData", FirebaseAnalytics.Param.INDEX, "glBindBufferBase-WZ9TVnA", "glBindBufferBase", "glCreateShader-WZ4Q5Ns", "glCreateShader", "shader", "", "source", "glShaderSource-MQkHMmk", "(ILjava/lang/String;)V", "glShaderSource", "glCompileShader-WZ4Q5Ns", "glCompileShader", "glDeleteShader-WZ4Q5Ns", "glDeleteShader", "kotlin.jvm.PlatformType", "glGetShaderInfoLog-WZ4Q5Ns", "(I)Ljava/lang/String;", "glGetShaderInfoLog", "", "result", "glGetShaderiv-77U-QhU", "(II[I)V", "glGetShaderiv", "glCreateProgram", "()I", "program", "glAttachShader-J1ME1BU", "glAttachShader", "glLinkProgram-WZ4Q5Ns", "glLinkProgram", "glUseProgram-WZ4Q5Ns", "glUseProgram", "glDeleteProgram-WZ4Q5Ns", "glDeleteProgram", "glGetProgramInfoLog-WZ4Q5Ns", "glGetProgramInfoLog", "glGetProgramiv-77U-QhU", "glGetProgramiv", "glEnableVertexAttribArray-WZ4Q5Ns", "glEnableVertexAttribArray", "glDisableVertexAttribArray-WZ4Q5Ns", "glDisableVertexAttribArray", "name", "glGetAttribLocation-MQkHMmk", "(ILjava/lang/String;)I", "glGetAttribLocation", "glGetUniformLocation-MQkHMmk", "glGetUniformLocation", "", "normalized", "stride", "pointer", "glVertexAttribPointer-DPIKzKM", "(IIIZILjava/nio/Buffer;)V", "glVertexAttribPointer", "location", "transpose", "Ljava/nio/FloatBuffer;", "Lcom/otaliastudios/opengl/types/FloatBuffer;", "glUniformMatrix4fv", "(IIZLjava/nio/FloatBuffer;)V", "", "(IIZ[F)V", "glUniform4fv", "(IILjava/nio/FloatBuffer;)V", "(II[F)V", "glGetIntegerv-TPoRFrE", "glGetIntegerv", "glGetError", "mode", InternalConstsKt.FIRST_IMAGE, "glDrawArrays-bBynSoI", "glDrawArrays", "indices", "glDrawElements-z2-TkIY", "(IIILjava/nio/Buffer;)V", "glDrawElements", AuthSource.BOOKING_ORDER, "I", "getGL_VIEWPORT", "GL_VIEWPORT", "r", "getGL_FRAMEBUFFER", "GL_FRAMEBUFFER", "h", "getGL_TRIANGLE_STRIP", "GL_TRIANGLE_STRIP", VKApiConst.VERSION, "getGL_LINK_STATUS", "GL_LINK_STATUS", "s", "getGL_FRAMEBUFFER_COMPLETE", "GL_FRAMEBUFFER_COMPLETE", "i", "getGL_TEXTURE0", "GL_TEXTURE0", "l", "getGL_TEXTURE_MAG_FILTER", "GL_TEXTURE_MAG_FILTER", "p", "F", "getGL_NEAREST", "()F", "GL_NEAREST", VKApiConst.Q, "getGL_LINEAR", "GL_LINEAR", "t", "getGL_COLOR_ATTACHMENT0", "GL_COLOR_ATTACHMENT0", "u", "getGL_COMPILE_STATUS", "GL_COMPILE_STATUS", "GL_NO_ERROR", "getGL_NO_ERROR", "x", "getGL_FRAGMENT_SHADER", "GL_FRAGMENT_SHADER", "c", "getGL_UNSIGNED_BYTE", "GL_UNSIGNED_BYTE", "f", "getGL_TRIANGLES", "GL_TRIANGLES", g.a, "getGL_TRIANGLE_FAN", "GL_TRIANGLE_FAN", "n", "getGL_TEXTURE_WRAP_T", "GL_TEXTURE_WRAP_T", "k", "getGL_TEXTURE_MIN_FILTER", "GL_TEXTURE_MIN_FILTER", AuthSource.SEND_ABUSE, "getGL_SHADER_STORAGE_BUFFER", "GL_SHADER_STORAGE_BUFFER", "j", "getGL_TEXTURE_EXTERNAL_OES", "GL_TEXTURE_EXTERNAL_OES", "GL_TRUE", "getGL_TRUE", "d", "getGL_FLOAT", "GL_FLOAT", "o", "getGL_CLAMP_TO_EDGE", "GL_CLAMP_TO_EDGE", "e", "getGL_RGBA", "GL_RGBA", "w", "getGL_VERTEX_SHADER", "GL_VERTEX_SHADER", AuthSource.OPEN_CHANNEL_LIST, "getGL_TEXTURE_WRAP_S", "GL_TEXTURE_WRAP_S", "egloo-metadata_release"}, k = 2, mv = {1, 4, 0})
public final class GlKt {
    @RequiresApi(21)
    public static final int a = UInt.m277constructorimpl(37074);
    public static final int b = 2978;
    public static final int c = UInt.m277constructorimpl(R2.styleable.MockView_mock_labelColor);
    public static final int d = UInt.m277constructorimpl(R2.styleable.Motion_motionPathRotate);
    public static final int e = UInt.m277constructorimpl(6408);
    public static final int f = UInt.m277constructorimpl(4);
    public static final int g = UInt.m277constructorimpl(6);
    public static final int h = UInt.m277constructorimpl(5);
    public static final int i = UInt.m277constructorimpl(33984);
    public static final int j = UInt.m277constructorimpl(36197);
    public static final int k = UInt.m277constructorimpl(10241);
    public static final int l = UInt.m277constructorimpl(Data.MAX_DATA_BYTES);
    public static final int m = UInt.m277constructorimpl(10242);
    public static final int n = UInt.m277constructorimpl(10243);
    public static final int o = 33071;
    public static final float p = ((float) 9728);
    public static final float q = ((float) 9729);
    public static final int r = UInt.m277constructorimpl(36160);
    public static final int s = UInt.m277constructorimpl(36053);
    public static final int t = UInt.m277constructorimpl(36064);
    public static final int u = UInt.m277constructorimpl(35713);
    public static final int v = UInt.m277constructorimpl(35714);
    public static final int w = UInt.m277constructorimpl(35633);
    public static final int x = UInt.m277constructorimpl(35632);

    public static final int getGL_CLAMP_TO_EDGE() {
        return o;
    }

    public static final int getGL_COLOR_ATTACHMENT0() {
        return t;
    }

    public static final int getGL_COMPILE_STATUS() {
        return u;
    }

    public static final int getGL_FLOAT() {
        return d;
    }

    public static final int getGL_FRAGMENT_SHADER() {
        return x;
    }

    public static final int getGL_FRAMEBUFFER() {
        return r;
    }

    public static final int getGL_FRAMEBUFFER_COMPLETE() {
        return s;
    }

    public static final float getGL_LINEAR() {
        return q;
    }

    public static final int getGL_LINK_STATUS() {
        return v;
    }

    public static final float getGL_NEAREST() {
        return p;
    }

    public static final int getGL_NO_ERROR() {
        return 0;
    }

    public static final int getGL_RGBA() {
        return e;
    }

    public static final int getGL_SHADER_STORAGE_BUFFER() {
        return a;
    }

    public static final int getGL_TEXTURE0() {
        return i;
    }

    public static final int getGL_TEXTURE_EXTERNAL_OES() {
        return j;
    }

    public static final int getGL_TEXTURE_MAG_FILTER() {
        return l;
    }

    public static final int getGL_TEXTURE_MIN_FILTER() {
        return k;
    }

    public static final int getGL_TEXTURE_WRAP_S() {
        return m;
    }

    public static final int getGL_TEXTURE_WRAP_T() {
        return n;
    }

    public static final int getGL_TRIANGLES() {
        return f;
    }

    public static final int getGL_TRIANGLE_FAN() {
        return g;
    }

    public static final int getGL_TRIANGLE_STRIP() {
        return h;
    }

    public static final int getGL_TRUE() {
        return 1;
    }

    public static final int getGL_UNSIGNED_BYTE() {
        return c;
    }

    public static final int getGL_VERTEX_SHADER() {
        return w;
    }

    public static final int getGL_VIEWPORT() {
        return b;
    }

    /* renamed from: glActiveTexture-WZ4Q5Ns  reason: not valid java name */
    public static final void m152glActiveTextureWZ4Q5Ns(int i2) {
        GLES20.glActiveTexture(i2);
    }

    /* renamed from: glAttachShader-J1ME1BU  reason: not valid java name */
    public static final void m153glAttachShaderJ1ME1BU(int i2, int i3) {
        GLES20.glAttachShader(i2, i3);
    }

    /* renamed from: glBindBuffer-J1ME1BU  reason: not valid java name */
    public static final void m154glBindBufferJ1ME1BU(int i2, int i3) {
        GLES20.glBindBuffer(i2, i3);
    }

    /* renamed from: glBindBufferBase-WZ9TVnA  reason: not valid java name */
    public static final void m155glBindBufferBaseWZ9TVnA(int i2, int i3, int i4) {
        GLES30.glBindBufferBase(i2, i3, i4);
    }

    /* renamed from: glBindFramebuffer-J1ME1BU  reason: not valid java name */
    public static final void m156glBindFramebufferJ1ME1BU(int i2, int i3) {
        GLES20.glBindFramebuffer(i2, i3);
    }

    /* renamed from: glBindTexture-J1ME1BU  reason: not valid java name */
    public static final void m157glBindTextureJ1ME1BU(int i2, int i3) {
        GLES20.glBindTexture(i2, i3);
    }

    /* renamed from: glBufferData-xK68qss  reason: not valid java name */
    public static final void m158glBufferDataxK68qss(int i2, int i3, int i4) {
        GLES20.glBufferData(i2, i3, null, i4);
    }

    /* renamed from: glCheckFramebufferStatus-WZ4Q5Ns  reason: not valid java name */
    public static final int m159glCheckFramebufferStatusWZ4Q5Ns(int i2) {
        return UInt.m277constructorimpl(GLES20.glCheckFramebufferStatus(i2));
    }

    /* renamed from: glCompileShader-WZ4Q5Ns  reason: not valid java name */
    public static final void m160glCompileShaderWZ4Q5Ns(int i2) {
        GLES20.glCompileShader(i2);
    }

    public static final int glCreateProgram() {
        return UInt.m277constructorimpl(GLES20.glCreateProgram());
    }

    /* renamed from: glCreateShader-WZ4Q5Ns  reason: not valid java name */
    public static final int m161glCreateShaderWZ4Q5Ns(int i2) {
        return UInt.m277constructorimpl(GLES20.glCreateShader(i2));
    }

    /* renamed from: glDeleteBuffers-JrK2_R0  reason: not valid java name */
    public static final void m162glDeleteBuffersJrK2_R0(int i2, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "array");
        int r0 = UIntArray.m291getSizeimpl(iArr);
        int[] iArr2 = new int[r0];
        for (int i3 = 0; i3 < r0; i3++) {
            iArr2[i3] = UIntArray.m290getpVg5ArA(iArr, i3);
        }
        GLES20.glDeleteBuffers(i2, iArr2, 0);
        Unit unit = Unit.INSTANCE;
        int i4 = i2 + 0;
        for (int i5 = 0; i5 < i4; i5++) {
            UIntArray.m295setVXSXFK8(iArr, i5, UInt.m277constructorimpl(iArr2[i5]));
        }
    }

    /* renamed from: glDeleteFramebuffers-JrK2_R0  reason: not valid java name */
    public static final void m163glDeleteFramebuffersJrK2_R0(int i2, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "array");
        int r0 = UIntArray.m291getSizeimpl(iArr);
        int[] iArr2 = new int[r0];
        for (int i3 = 0; i3 < r0; i3++) {
            iArr2[i3] = UIntArray.m290getpVg5ArA(iArr, i3);
        }
        GLES20.glDeleteFramebuffers(i2, iArr2, 0);
        Unit unit = Unit.INSTANCE;
        int i4 = i2 + 0;
        for (int i5 = 0; i5 < i4; i5++) {
            UIntArray.m295setVXSXFK8(iArr, i5, UInt.m277constructorimpl(iArr2[i5]));
        }
    }

    /* renamed from: glDeleteProgram-WZ4Q5Ns  reason: not valid java name */
    public static final void m164glDeleteProgramWZ4Q5Ns(int i2) {
        GLES20.glDeleteProgram(i2);
    }

    /* renamed from: glDeleteShader-WZ4Q5Ns  reason: not valid java name */
    public static final void m165glDeleteShaderWZ4Q5Ns(int i2) {
        GLES20.glDeleteShader(i2);
    }

    /* renamed from: glDeleteTextures-JrK2_R0  reason: not valid java name */
    public static final void m166glDeleteTexturesJrK2_R0(int i2, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "array");
        int r0 = UIntArray.m291getSizeimpl(iArr);
        int[] iArr2 = new int[r0];
        for (int i3 = 0; i3 < r0; i3++) {
            iArr2[i3] = UIntArray.m290getpVg5ArA(iArr, i3);
        }
        GLES20.glDeleteTextures(i2, iArr2, 0);
        Unit unit = Unit.INSTANCE;
        int i4 = i2 + 0;
        for (int i5 = 0; i5 < i4; i5++) {
            UIntArray.m295setVXSXFK8(iArr, i5, UInt.m277constructorimpl(iArr2[i5]));
        }
    }

    /* renamed from: glDisableVertexAttribArray-WZ4Q5Ns  reason: not valid java name */
    public static final void m167glDisableVertexAttribArrayWZ4Q5Ns(int i2) {
        GLES20.glDisableVertexAttribArray(i2);
    }

    /* renamed from: glDrawArrays-bBynSoI  reason: not valid java name */
    public static final void m168glDrawArraysbBynSoI(int i2, int i3, int i4) {
        GLES20.glDrawArrays(i2, i3, i4);
    }

    /* renamed from: glDrawElements-z2-TkIY  reason: not valid java name */
    public static final void m169glDrawElementsz2TkIY(int i2, int i3, int i4, @NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "indices");
        GLES20.glDrawElements(i2, i3, i4, buffer);
    }

    /* renamed from: glEnableVertexAttribArray-WZ4Q5Ns  reason: not valid java name */
    public static final void m170glEnableVertexAttribArrayWZ4Q5Ns(int i2) {
        GLES20.glEnableVertexAttribArray(i2);
    }

    /* renamed from: glFramebufferTexture2D-fS6bbcI  reason: not valid java name */
    public static final void m171glFramebufferTexture2DfS6bbcI(int i2, int i3, int i4, int i5, int i6) {
        GLES20.glFramebufferTexture2D(i2, i3, i4, i5, i6);
    }

    /* renamed from: glGenBuffers-JrK2_R0  reason: not valid java name */
    public static final void m172glGenBuffersJrK2_R0(int i2, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "array");
        int r0 = UIntArray.m291getSizeimpl(iArr);
        int[] iArr2 = new int[r0];
        for (int i3 = 0; i3 < r0; i3++) {
            iArr2[i3] = UIntArray.m290getpVg5ArA(iArr, i3);
        }
        GLES20.glGenBuffers(i2, iArr2, 0);
        Unit unit = Unit.INSTANCE;
        int i4 = i2 + 0;
        for (int i5 = 0; i5 < i4; i5++) {
            UIntArray.m295setVXSXFK8(iArr, i5, UInt.m277constructorimpl(iArr2[i5]));
        }
    }

    /* renamed from: glGenFramebuffers-JrK2_R0  reason: not valid java name */
    public static final void m173glGenFramebuffersJrK2_R0(int i2, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "array");
        int r0 = UIntArray.m291getSizeimpl(iArr);
        int[] iArr2 = new int[r0];
        for (int i3 = 0; i3 < r0; i3++) {
            iArr2[i3] = UIntArray.m290getpVg5ArA(iArr, i3);
        }
        GLES20.glGenFramebuffers(i2, iArr2, 0);
        Unit unit = Unit.INSTANCE;
        int i4 = i2 + 0;
        for (int i5 = 0; i5 < i4; i5++) {
            UIntArray.m295setVXSXFK8(iArr, i5, UInt.m277constructorimpl(iArr2[i5]));
        }
    }

    /* renamed from: glGenTextures-JrK2_R0  reason: not valid java name */
    public static final void m174glGenTexturesJrK2_R0(int i2, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "array");
        int r0 = UIntArray.m291getSizeimpl(iArr);
        int[] iArr2 = new int[r0];
        for (int i3 = 0; i3 < r0; i3++) {
            iArr2[i3] = UIntArray.m290getpVg5ArA(iArr, i3);
        }
        GLES20.glGenTextures(i2, iArr2, 0);
        Unit unit = Unit.INSTANCE;
        int i4 = i2 + 0;
        for (int i5 = 0; i5 < i4; i5++) {
            UIntArray.m295setVXSXFK8(iArr, i5, UInt.m277constructorimpl(iArr2[i5]));
        }
    }

    /* renamed from: glGetAttribLocation-MQkHMmk  reason: not valid java name */
    public static final int m175glGetAttribLocationMQkHMmk(int i2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return GLES20.glGetAttribLocation(i2, str);
    }

    public static final int glGetError() {
        return UInt.m277constructorimpl(GLES20.glGetError());
    }

    /* renamed from: glGetIntegerv-TPoRFrE  reason: not valid java name */
    public static final void m176glGetIntegervTPoRFrE(int i2, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "array");
        GLES20.glGetIntegerv(i2, iArr, 0);
    }

    /* renamed from: glGetProgramInfoLog-WZ4Q5Ns  reason: not valid java name */
    public static final String m177glGetProgramInfoLogWZ4Q5Ns(int i2) {
        return GLES20.glGetProgramInfoLog(i2);
    }

    /* renamed from: glGetProgramiv-77U-QhU  reason: not valid java name */
    public static final void m178glGetProgramiv77UQhU(int i2, int i3, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "result");
        GLES20.glGetProgramiv(i2, i3, iArr, 0);
    }

    /* renamed from: glGetShaderInfoLog-WZ4Q5Ns  reason: not valid java name */
    public static final String m179glGetShaderInfoLogWZ4Q5Ns(int i2) {
        return GLES20.glGetShaderInfoLog(i2);
    }

    /* renamed from: glGetShaderiv-77U-QhU  reason: not valid java name */
    public static final void m180glGetShaderiv77UQhU(int i2, int i3, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "result");
        GLES20.glGetShaderiv(i2, i3, iArr, 0);
    }

    /* renamed from: glGetUniformLocation-MQkHMmk  reason: not valid java name */
    public static final int m181glGetUniformLocationMQkHMmk(int i2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return GLES20.glGetUniformLocation(i2, str);
    }

    /* renamed from: glLinkProgram-WZ4Q5Ns  reason: not valid java name */
    public static final void m182glLinkProgramWZ4Q5Ns(int i2) {
        GLES20.glLinkProgram(i2);
    }

    /* renamed from: glShaderSource-MQkHMmk  reason: not valid java name */
    public static final void m183glShaderSourceMQkHMmk(int i2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "source");
        GLES20.glShaderSource(i2, str);
    }

    /* renamed from: glTexImage2D-pBdJQSo  reason: not valid java name */
    public static final void m184glTexImage2DpBdJQSo(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, @Nullable Buffer buffer) {
        GLES20.glTexImage2D(i2, i3, i4, i5, i6, i7, i8, i9, buffer);
    }

    /* renamed from: glTexParameterf-CEfty_Q  reason: not valid java name */
    public static final void m185glTexParameterfCEfty_Q(int i2, int i3, float f2) {
        GLES20.glTexParameterf(i2, i3, f2);
    }

    /* renamed from: glTexParameteri-Nkh28Cs  reason: not valid java name */
    public static final void m186glTexParameteriNkh28Cs(int i2, int i3, int i4) {
        GLES20.glTexParameteri(i2, i3, i4);
    }

    public static final void glUniform4fv(int i2, int i3, @NotNull FloatBuffer floatBuffer) {
        Intrinsics.checkNotNullParameter(floatBuffer, "value");
        GLES20.glUniform4fv(i2, i3, floatBuffer);
    }

    public static final void glUniformMatrix4fv(int i2, int i3, boolean z, @NotNull FloatBuffer floatBuffer) {
        Intrinsics.checkNotNullParameter(floatBuffer, "value");
        GLES20.glUniformMatrix4fv(i2, i3, z, floatBuffer);
    }

    /* renamed from: glUseProgram-WZ4Q5Ns  reason: not valid java name */
    public static final void m187glUseProgramWZ4Q5Ns(int i2) {
        GLES20.glUseProgram(i2);
    }

    /* renamed from: glVertexAttribPointer-DPIKzKM  reason: not valid java name */
    public static final void m188glVertexAttribPointerDPIKzKM(int i2, int i3, int i4, boolean z, int i5, @NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "pointer");
        GLES20.glVertexAttribPointer(i2, i3, i4, z, i5, buffer);
    }

    public static final void glUniform4fv(int i2, int i3, @NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "value");
        GLES20.glUniform4fv(i2, i3, fArr, 0);
    }

    public static final void glUniformMatrix4fv(int i2, int i3, boolean z, @NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "value");
        GLES20.glUniformMatrix4fv(i2, i3, z, fArr, 0);
    }
}
