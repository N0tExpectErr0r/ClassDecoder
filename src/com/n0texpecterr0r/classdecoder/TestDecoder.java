package com.n0texpecterr0r.classdecoder;

import com.n0texpecterr0r.classdecoder.attribute.AttributeInfo;
import com.n0texpecterr0r.classdecoder.constantpool.CpInfo;
import com.n0texpecterr0r.classdecoder.fieldinfo.FieldInfo;
import com.n0texpecterr0r.classdecoder.methodinfo.MethodInfo;

public class TestDecoder {
    public static void main(String[] args) {
        ClassFile classFile = new ClassDecoder().decode("Test.class");
        CpInfo[] constantPool = classFile.getConstantPool();
        System.out.println("this class: " + constantPool[classFile.getThisClazz() - 1]);
        System.out.println("super class: " + constantPool[classFile.getSuperClazz() - 1]);
        System.out.println("minor version: " + classFile.getMinorVersion());
        System.out.println("major version: " + classFile.getMajorVersion());
        System.out.println("flags: " + classFile.getAccessFlags().toString());
        System.out.println("Constant pool: ");
        for (int i = 0; i < classFile.getConstantCount() - 1; i++) {
            System.out.println("#" + (i + 1) + " = " + constantPool[i].toString(constantPool));
        }
        System.out.println("Interfaces: ");
        short[] interfaces = classFile.getInterfaces();
        for (int i = 0; i < classFile.getInterfaceCount(); i++) {
            System.out.println("#" + (i + 1) + " = " + "\t#" + interfaces[i] + "\t//" + constantPool[interfaces[i]]);
        }
        System.out.println("Fields: ");
        FieldInfo[] fieldInfos = classFile.getFields();
        for (int i = 0; i < classFile.getFieldCount(); i++) {
            System.out.println(fieldInfos[i].toString(constantPool));
        }
        System.out.println("Method: ");
        MethodInfo[] methodInfos = classFile.getMethods();
        for (int i = 0; i < classFile.getMethodCount(); i++) {
            System.out.println(methodInfos[i].toString(constantPool));
        }
        System.out.println("Attributes:");
        AttributeInfo[] attributeInfos = classFile.getAttributes();
        for (int i = 0; i < classFile.getAttributeCount(); i++) {
            System.out.println(attributeInfos[i].toString());
        }
    }
}
