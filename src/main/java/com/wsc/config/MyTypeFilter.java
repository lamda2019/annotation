package com.wsc.config;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class MyTypeFilter implements TypeFilter {

    /**
     * metadataReader：读取到的当前正在扫描的类的信息
     * metadataReaderFactory:可以获取到其他任何类信息的
     */
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
            throws IOException {

        AnnotationMetadata am = metadataReader.getAnnotationMetadata();//获取当前类注解的信息
        ClassMetadata cm = metadataReader.getClassMetadata();//获取当前正在扫描的类的类信息
        Resource resource = metadataReader.getResource();//获取当前类资源（类的路径）

        String className = cm.getClassName();
        System.out.println("正在扫描的类： --->"+className);
        if(className.contains("controller")){
            return true;//加载到容器
        }
        return false;//不能加载到容器
    }

}