package com.n0texpecterr0r.classdecoder.fieldinfo;

import com.n0texpecterr0r.classdecoder.AttributeFactory;
import com.n0texpecterr0r.classdecoder.accessflag.AccessFlagInfo;
import com.n0texpecterr0r.classdecoder.attribute.AttributeInfo;
import com.n0texpecterr0r.classdecoder.constantpool.CpInfo;
import sun.reflect.ConstantPool;

import java.io.DataInputStream;
import java.io.IOException;

public class FieldInfo {
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

    public static FieldInfo read(DataInputStream in) throws IOException {
        FieldInfo field = new FieldInfo();
        field.accessFlag = new AccessFlagInfo(AccessFlagInfo.TYPE_FIELD);
        field.accessFlag.read(in);
        field.nameIndex = in.readShort();
        field.descriptorIndex = in.readShort();
        field.attributeCount = in.readShort();
        field.attributes = new AttributeInfo[field.attributeCount];
        for (int i = 0; i < field.attributeCount; i++) {
            field.attributes[i] = AttributeFactory.readAttribute(in);
        }
        return field;
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
