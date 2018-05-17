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
    int length = 0;

    if (lengthA >= lengthB) length = lengthB;
    else length = lengthA;

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

//        env->CallDoubleMethod(env->GetObjectArrayElement(arr, i), doubleValue)

//        jmethodID doubleValue = (*env)->GetMethodID(doubleClass, "booleanValue", "()Z");
//        bool booleanValue = (bool) env->CallBooleanMethod(valueObject, booleanValueMID);

//        jfieldID valueID = (*env)->GetFieldID(env, doubleClass, "value", "()D");

        result += aDouble * bDouble;
        printf("%d | Result: %f\n", i, result);
        ++i;
    }

//    jfieldID aID = ()

    // Create Double class, get constructor and create Double object
    jmethodID initDouble = (*env)->GetMethodID(env, doubleClass, "<init>", "(D)V");


    if (NULL == initDouble)
    {
       printf("DUPA\n");
       return a;
    }

    jobject newDoubleObj = (*env)->NewObject(env, doubleClass, initDouble, result);

    //Now set your integer into value attribute. For this, I would
    //recommend you to have a java setter and call it in the same way
    //as shown above

    //clean reference
//    (*env)->DeleteLocalRef(env, a);
//    (*env)->DeleteLocalRef(env, b);

     return newDoubleObj;
}

/*
 * Class:     com_hania_DotProduct
 * Method:    multi02
 * Signature: ([Ljava/lang/Double;)Ljava/lang/Double;
 */
JNIEXPORT jobject JNICALL Java_com_hania_DotProduct_multi02(JNIEnv *env, jobject thisObj, jobjectArray a)
{
    jclass doubleClass = (*env)->FindClass(env, "java/lang/Double");
    jmethodID initDouble = (*env)->GetMethodID(env, doubleClass, "<init>", "(D)V");

    jobject newDoubleObj = (*env)->NewObject(env, doubleClass, initDouble, 0.0);

    return newDoubleObj;
}

/*
 * Class:     com_hania_DotProduct
 * Method:    multi03
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_hania_DotProduct_multi03(JNIEnv *env, jobject thisObj)
{
    jclass thisClass = (*env)->GetObjectClass(env, thisObj);
//    jobject obj = (jobject) (*env)->CallObjectMethod(thisObje, jfindViewById, 3);
}
