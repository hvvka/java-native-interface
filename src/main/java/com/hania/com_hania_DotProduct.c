#include <stdio.h>
#include "com_hania_DotProduct.h"

/*
 * Class:     com_hania_DotProduct
 * Method:    multi01
 * Signature: ([Ljava/lang/Double;[Ljava/lang/Double;)Ljava/lang/Double;
 */
JNIEXPORT jobject JNICALL Java_com_hania_DotProduct_multi01(JNIEnv *env, jobject thisObj, jobjectArray a, jobjectArray b)
{
    jsize lengthA = (*env)->GetArrayLength(env, a);
    jsize lengthB = (*env)->GetArrayLength(env, b);
    int length = lengthA >= lengthB ? lengthB : lengthA;

    jclass doubleClass = (*env)->FindClass(env, "java/lang/Double");
    jmethodID doubleValue = (*env)->GetMethodID(env, doubleClass, "doubleValue", "()D");
    int i = 0;
    double result = 0.0, aDouble = 0.0, bDouble = 0.0;
    jobject aElement, bElement;

    while (i < length)
    {
        aElement = (*env)->GetObjectArrayElement(env, a, i);
        bElement = (*env)->GetObjectArrayElement(env, b, i);

        aDouble = (*env)->CallDoubleMethod(env, aElement, doubleValue);
        bDouble = (*env)->CallDoubleMethod(env, bElement, doubleValue);
        printf("A[%d]=%f\nB[%d]=%f\n", i, aDouble, i, bDouble);

        result += aDouble * bDouble;
        printf("Result: %f\n", result);
        ++i;
    }

    // Create Double class, get constructor and create Double object
    jmethodID initDouble = (*env)->GetMethodID(env, doubleClass, "<init>", "(D)V");

    if (NULL == initDouble)
    {
       printf("Failed to initialize Double object!\n");
       return a;
    }

    jobject newDoubleObj = (*env)->NewObject(env, doubleClass, initDouble, result);

    //clean references
    (*env)->DeleteLocalRef(env, a);
    (*env)->DeleteLocalRef(env, b);
    (*env)->DeleteLocalRef(env, aElement);
    (*env)->DeleteLocalRef(env, bElement);
    (*env)->DeleteLocalRef(env, doubleClass);

    return newDoubleObj;
}

/*
 * Class:     com_hania_DotProduct
 * Method:    multi02
 * Signature: ([Ljava/lang/Double;)Ljava/lang/Double;
 */
JNIEXPORT jobject JNICALL Java_com_hania_DotProduct_multi02(JNIEnv *env, jobject thisObj, jobjectArray a)
{
    jclass thisClass = (*env)->GetObjectClass(env, thisObj);
    jfieldID bID = (*env)->GetFieldID(env, thisClass, "b", "[Ljava/lang/Double;");
    if (bID == 0)
    {
        printf("Failed to read field b!\n");
        return a;
    }
    jobjectArray b = (*env)->GetObjectField(env, thisObj, bID);

    (*env)->DeleteLocalRef(env, thisClass);
    return Java_com_hania_DotProduct_multi01(env, thisObj, a, b);
}

/*
 * Class:     com_hania_DotProduct
 * Method:    multi03
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_hania_DotProduct_multi03(JNIEnv *env, jobject thisObj)
{
	jclass thisClass = (*env)->GetObjectClass(env, thisObj);
    jfieldID cID = (*env)->GetFieldID(env, thisClass, "c", "Ljava/lang/Double;");
    if (cID == 0)
    {
        printf("Failed to read field `c`!\n");
        return;
    }

    jmethodID multi04ID = (*env)->GetMethodID(env, thisClass, "multi04", "()V");
    if (multi04ID == 0)
    {
    	printf("Failed to read method multi04!\n");
    	return;
    }

    (*env)->CallVoidMethod(env, thisObj, multi04ID);
    jobject c = (*env)->GetObjectField(env, thisObj, cID);

    jclass doubleClass = (*env)->FindClass(env, "java/lang/Double");
    jmethodID doubleValue = (*env)->GetMethodID(env, doubleClass, "doubleValue", "()D");
    jdouble result = (*env)->CallDoubleMethod(env, c, doubleValue);
    printf("c=%f\n", result);

    (*env)->SetDoubleField(env, thisClass, cID, result);

    (*env)->DeleteLocalRef(env, thisClass);
    (*env)->DeleteLocalRef(env, thisObj);
    (*env)->DeleteLocalRef(env, doubleClass);
    (*env)->DeleteLocalRef(env, c);
}
