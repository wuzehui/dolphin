package com.freetmp.mbg.plugin.page;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

/*
 * MySql数据库查询分页插件
 * @author Pin Liu
 * @编写日期 2014年11月26日下午12:43:50
 */
public class MySqlPaginationPlugin extends AbstractPaginationPlugin {
	
	public MySqlPaginationPlugin() {
		super();
	}
	
	@Override
	public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(
			XmlElement element, IntrospectedTable introspectedTable) {

		XmlElement isNotNullElement = new XmlElement("if"); 
		isNotNullElement.addAttribute(new Attribute("test", "limit != null and limit>=0 and offset != null"));
		isNotNullElement.addElement(new TextElement("limit #{offset} , #{limit}"));

		element.addElement(isNotNullElement);
		return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element,
				introspectedTable);
	}
	
	/*
	 * This plugin is always valid - no properties are required
	 */
	public boolean validate(List<String> warnings) {
		return true;
	}

}