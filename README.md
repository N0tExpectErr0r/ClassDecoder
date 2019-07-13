# ClassDecoder
一个模仿javap的字节码解析工具，用于获取字节码文件所包含的信息。练手Demo，主要为了加深自己对Class文件结构的理解

**使用方式:**
```java
ClassFile classFile = new ClassDecoder().decode("Test.class");
```
**ClassFile结构:**
```java
public class ClassFile {
    private short minorVersion;           // 小版本号
    private short majorVersion;           // 大版本号
    private short constantCount;          // 常量池元素个数（实际要减一，常量池从1开始计数）
    private CpInfo[] constantPool;        // 常量池
    private AccessFlagInfo accessFlags;   // 类的AccessFlag
    private short thisClazz;              // 当前类名在常量池中的index
    private short superClazz;             // 父类名在常量池中的index
    private short interfaceCount;         // 继承的接口个数
    private short[] interfaces;           // 继承的接口名称在常量池中index集合
    private short fieldCount;             // 成员变量
    private FieldInfo[] fields;           // 成员变量信息数组
    private short methodCount;            // 方法个数
    private MethodInfo[] methods;         // 方法信息数组
    private short attributeCount;         // 类属性个数
    private AttributeInfo[] attributes;   // 类的属性数组
}
```
