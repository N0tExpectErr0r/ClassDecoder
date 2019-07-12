package com.n0texpecterr0r.classdecoder;

import com.n0texpecterr0r.classdecoder.attribute.AttributeInfo;
import com.n0texpecterr0r.classdecoder.attribute.CodeAttribute;
import com.n0texpecterr0r.classdecoder.attribute.LineNumberAttribute;
import com.n0texpecterr0r.classdecoder.attribute.SourceFileAttribute;
import com.n0texpecterr0r.classdecoder.constantpool.CpInfo;

import java.io.DataInputStream;
import java.io.IOException;

public class AttributeFactory {
    public static AttributeInfo readAttribute(DataInputStream in) throws IOException {
        CpInfo[] constantPool = ClassDecoder.getConstantPool();
        short attributeNameIndex = in.readShort();
        int attributeLength = in.readInt();
        String attributeName = constantPool[attributeNameIndex-1].toString();
        AttributeInfo result = null;
        switch (attributeName) {
            case "ConstantValue":
                break;
            case "Code":
                result = new CodeAttribute();
                break;
            case "Exception":
                break;
            case "SourceFile":
                result = new SourceFileAttribute();
                break;
            case "LocalVariableTable":
                break;
            case "LineNumberTable":
                result = new LineNumberAttribute();
                break;
        }
        if (result == null) {
            throw new IOException("read Attribute failed");
        }
        result.read(in);
        return result;
    }
}
