/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.system.jni

import org.lwjgl.generator.*
import java.nio.Buffer
import java.nio.ByteBuffer

val JNI_PACKAGE = "org.lwjgl.system.jni"

fun config() {
	packageInfo(
		JNI_PACKAGE,
		"Contains bindings to the Java Native Interface (JNI)."
	)
}

val jboolean = IntegerType("jboolean", PrimitiveMapping.BOOLEAN)
val jbyte = IntegerType("jbyte", PrimitiveMapping.BYTE)
val jchar = CharType("jchar", CharMapping.UTF16)
val jshort = IntegerType("jshort", PrimitiveMapping.SHORT)
val jint = IntegerType("jint", PrimitiveMapping.INT)
val jlong = IntegerType("jlong", PrimitiveMapping.LONG)

val jfloat = IntegerType("jfloat", PrimitiveMapping.FLOAT)
val jdouble = IntegerType("jdouble", PrimitiveMapping.DOUBLE)

val jbooleanArray = NativeType("jbooleanArray", TypeMapping("jbooleanArray", ByteArray::class, ByteArray::class))
val jbyteArray = NativeType("jbyteArray", TypeMapping("jbyteArray", ByteArray::class, ByteArray::class))
val jcharArray = NativeType("jcharArray", TypeMapping("jcharArray", CharArray::class, CharArray::class))
val jshortArray = NativeType("jshortArray", TypeMapping("jshortArray", ShortArray::class, ShortArray::class))
val jintArray = NativeType("jintArray", TypeMapping("jintArray", IntArray::class, IntArray::class))
val jlongArray = NativeType("jlongArray", TypeMapping("jlongArray", LongArray::class, LongArray::class))
val jfloatArray = NativeType("jfloatArray", TypeMapping("jfloatArray", FloatArray::class, FloatArray::class))
val jdoubleArray = NativeType("jdoubleArray", TypeMapping("jdoubleArray", DoubleArray::class, DoubleArray::class))

val jsize = typedef(jint, "jsize")

val jclass = "jclass".opaque_p

val jobject = NativeType("jobject", TypeMapping("jobject", Any::class.java, Any::class.java))
val jobject_p = "jobject".opaque_p

val jobjectRefType = "jobjectRefType".enumType

val jstring = NativeType("jstring", TypeMapping("jstring", String::class, String::class))
val java_nio_Buffer = NativeType("jobject", TypeMapping("jobject", Buffer::class, Buffer::class))
val java_nio_ByteBuffer = NativeType("jobject", TypeMapping("jobject", ByteBuffer::class, ByteBuffer::class))

val JNINativeMethod_p = struct(JNI_PACKAGE, "JNINativeMethod") {
	documentation = ""

	charUTF8_p.member("name", "")
	charUTF8_p.member("signature", "")
	opaque_p.member("fnPtr", "")
}.p