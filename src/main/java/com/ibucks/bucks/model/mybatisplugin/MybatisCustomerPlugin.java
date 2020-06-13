package com.ibucks.bucks.model.mybatisplugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.plugins.MapperAnnotationPlugin;

import java.util.List;

public class MybatisCustomerPlugin extends MapperAnnotationPlugin {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze, IntrospectedTable introspectedTable) {
        interfaze.addImportedType(new FullyQualifiedJavaType("org.springframework.stereotype.Component"));
        interfaze.addAnnotation("@Component");
        return true;
    }
}
