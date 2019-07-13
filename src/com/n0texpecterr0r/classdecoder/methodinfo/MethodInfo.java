package com.n0texpecterr0r.classdecoder.methodinfo;

import com.n0texpecterr0r.classdecoder.AttributeFactory;
import com.n0texpecterr0r.classdecoder.accessflag.AccessFlagInfo;
import com.n0texpecterr0r.classdecoder.attribute.AttributeInfo;
import com.n0texpecterr0r.classdecoder.constantpool.CpInfo;

import java.io.DataInputStream;
import java.io.IOException;

public class MethodInfo {
    private AccessFlagInfo accessFlag;
    private short nameIndex;
    private short descriptorIndex;
    private short attributeCount;
    private AttributeInfo[] attributes;

    public AccessFlagInfo getAccessFlag() {
        return accessFlag;
    }

    public short getNameIndex() {
        return nameIndex;
    }

    public short getDescriptorIndex() {
        return descriptorIndex;
    }

    public short getAttributeCount() {
        return attributeCount;
    }

    public AttributeInfo[] getAttributes() {
        return attributes;
    }

    public static MethodInfo read(DataInputStream in) throws IOException {
        MethodInfo method = new MethodInfo();
        method.accessFlag = new AccessFlagInfo(AccessFlagInfo.TYPE_METHOD);
        method.accessFlag.read(in);
        method.nameIndex = in.readShort();
        method.descriptorIndex = in.readShort();
        method.attributeCount = in.readShort();
        method.attributes = new AttributeInfo[method.attributeCount];
        for (int i = 0; i < method.attributeCount; i++) {
            method.attributes[i] = AttributeFactory.readAttribute(in);
        }
        return method;
    }

    public String toString(CpInfo[] constantPool) {
        StringBuilder sb = new StringBuilder();
        sb.append("\tname: ").append(constantPool[nameIndex-1]).append("\n");
        sb.append("\tdescriptor: ").append(constantPool[descriptorIndex-1]).append("\n");
        sb.append("\tflags: ").append(accessFlag.toString()).append("\n");
        for (int i = 0; i < attributeCount; i++) {
            sb.append(attributes[i]).append("\n");
        }
        return sb.toString();
    }
}
