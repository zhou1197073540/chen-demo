package com.exa.demo.example.AtomikosDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AtomikosSpringMybatisExample
{
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-atomikosDataSource.xml");
		JTAService jtaService = context.getBean("jtaService", JTAService.class);
		jtaService.saveMulDataSource();
	}
}
