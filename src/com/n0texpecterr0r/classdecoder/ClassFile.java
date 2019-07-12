package com.n0texpecterr0r.classdecoder;

import com.n0texpecterr0r.classdecoder.attribute.AttributeInfo;
import com.n0texpecterr0r.classdecoder.constantpool.CpInfo;
import com.n0texpecterr0r.classdecoder.fieldinfo.FieldInfo;
import com.n0texpecterr0r.classdecoder.methodinfo.MethodInfo;

public class ClassFile {
    private short minorVersion;
    private short majorVersion;
    private short constantCount;
    private CpInfo[] constantPool;
    private short accessFlags;
    private short thisClazz;
    private short superClazz;
    private short interfaceCount;
    private short[] interfaces;
    private short filedCount;
    private FieldInfo[] fields;
    private short methodCount;
    private MethodInfo[] methods;
    private short attributeCount;
    private AttributeInfo[] attributes;

    public short getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(short minorVersion) {
        this.minorVersion = minorVersion;
    }

    public short getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(short majorVersion) {
        this.majorVersion = majorVersion;
    }

    public short getConstantCount() {
        return constantCount;
    }

    public void setConstantCount(short constantCount) {
        this.constantCount = constantCount;
    }

    public CpInfo[] getConstantPool() {
        return constantPool;
    }

    public void setConstantPool(CpInfo[] constantPool) {
        this.constantPool = constantPool;
    }

    public short getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(short accessFlags) {
        this.accessFlags = accessFlags;
    }

    public short getThisClazz() {
        return thisClazz;
    }

    public void setThisClazz(short thisClazz) {
        this.thisClazz = thisClazz;
    }

    public short getSuperClazz() {
        return superClazz;
    }

    public void setSuperClazz(short superClazz) {
        this.superClazz = superClazz;
    }

    public short getInterfaceCount() {
        return interfaceCount;
    }

    public void setInterfaceCount(short interfaceCount) {
        this.interfaceCount = interfaceCount;
    }

    public short[] getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(short[] interfaces) {
        this.interfaces = interfaces;
    }

    public short getFiledCount() {
        return filedCount;
    }

    public void setFieldCount(short filedCount) {
        this.filedCount = filedCount;
    }

    public FieldInfo[] getFields() {
        return fields;
    }

    public void setFields(FieldInfo[] fields) {
        this.fields = fields;
    }

    public short getMethodCount() {
        return methodCount;
    }

    public void setMethodCount(short methodCount) {
        this.methodCount = methodCount;
    }

    public MethodInfo[] getMethods() {
        return methods;
    }

    public void setMethods(MethodInfo[] methods) {
        this.methods = methods;
    }

    public short getAttributeCount() {
        return attributeCount;
    }

    public void setAttributeCount(short attributeCount) {
        this.attributeCount = attributeCount;
    }

    public AttributeInfo[] getAttributes() {
        return attributes;
    }

    public void setAttributes(AttributeInfo[] attributes) {
        this.attributes = attributes;
    }
}
