import attribute.AttributeFactory;
import attribute.AttributeInfo;
import constantpool.CpFactory;
import constantpool.CpInfo;
import fieldinfo.FieldInfo;
import methodinfo.MethodInfo;

import java.io.*;

public class ClassDecoder {

    public void decode(String path) {
        try {
            DataInputStream in = new DataInputStream(new FileInputStream(new File(path)));
            ClassFile file = new ClassFile();
            in.skipBytes(4);
            file.setMinorVersion(in.readShort());
            file.setMajorVersion(in.readShort());

            short constantCount = in.readShort();
            file.setConstantCount(constantCount);
            CpInfo[] cpInfos = new CpInfo[constantCount - 1];
            for (int i = 0; i < constantCount - 1; i++) {
                cpInfos[i] = CpFactory.readCpInfo(in);
            }
            file.setConstantPool(cpInfos);

            file.setAccessFlags(in.readShort());
            file.setThisClazz(in.readShort());
            file.setSuperClazz(in.readShort());

            short interfaceCount = in.readShort();
            file.setInterfaceCount(interfaceCount);
            short[] interfaces = new short[interfaceCount];
            for (int i = 0; i < interfaceCount; i++) {
                interfaces[i] = in.readShort();
            }
            file.setInterfaces(interfaces);

            short fieldCount = in.readShort();
            file.setFieldCount(fieldCount);
            FieldInfo[] fields = new FieldInfo[fieldCount];
            for (int i = 0; i < fieldCount; i++) {
                fields[i] = FieldInfo.read(in);
            }
            file.setFields(fields);

            short methodCount = in.readShort();
            file.setMethodCount(methodCount);
            MethodInfo[] methods = new MethodInfo[methodCount];
            for (int i = 0; i < methodCount; i++) {
                methods[i] = MethodInfo.read(in);
            }
            file.setMethods(methods);

            short attributeCount = in.readShort();
            file.setAttributeCount(attributeCount);
            AttributeInfo[] attributes = new AttributeInfo[attributeCount];
            for (int i = 0; i < attributeCount; i++) {
                attributes[i] = AttributeFactory.readAttribute(in);
            }
            file.setAttributes(attributes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
