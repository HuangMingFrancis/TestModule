package com.example.ioc_compiler;

import java.util.HashMap;
import java.util.Map;

import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.Elements;

public class ParameterProxyInfo
{
    private String packageName;
    private String proxyClassName;
    private TypeElement typeElement;

    public Map<String, VariableElement> injectVariables = new HashMap<>();

    public static final String PROXY = "ParameterInject";

    public ParameterProxyInfo(Elements elementUtils, TypeElement classElement)
    {
        this.typeElement = classElement;
        PackageElement packageElement = elementUtils.getPackageOf(classElement);
        String packageName = packageElement.getQualifiedName().toString();
        //classname
        String className = ClassValidator.getClassName(classElement, packageName);
        this.packageName = packageName;
        this.proxyClassName = className + "$$" + PROXY;
    }


    public String generateJavaCode()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("// Generated code. Do not modify!\n");
        builder.append("package ").append(packageName).append(";\n\n");
        builder.append("import com.example.francis.bmodule.*;\n");
        builder.append("import com.example.francis.commonmodule.inject.ParameterInject;\n");
        builder.append('\n');

        builder.append("public class ").append(proxyClassName).append(" implements " + ParameterProxyInfo.PROXY + "<" + typeElement.getQualifiedName() + ">");
        builder.append(" {\n");

        generateMethods(builder);
        builder.append('\n');

        builder.append("}\n");
        return builder.toString();

    }
    private void generateMethods(StringBuilder builder)
    {

        builder.append("@Override\n ");
        builder.append("public void inject(" + typeElement.getQualifiedName() + " host) {\n");

        for (String id : injectVariables.keySet())
        {
            VariableElement element = injectVariables.get(id);
            String name = element.getSimpleName().toString();
            String type = element.asType().toString();
            builder.append("if(host.getIntent() != null){\n");
            builder.append("host." + name).append(" = ");
            builder.append("(" + type + ")(host.getIntent().getExtras().getSerializable( \"" + id + "\"));\n");
            builder.append("}\n");
        }
        builder.append("  }\n");

    }

    public String getProxyClassFullName()
    {
        return packageName + "." + proxyClassName;
    }

    public TypeElement getTypeElement()
    {
        return typeElement;
    }


}