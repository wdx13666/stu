package stu;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.stu.mp.mapper.EmployeeMapper;

public class Test {

	private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	private EmployeeMapper mapper =ioc.getBean(EmployeeMapper.class);
	@org.junit.Test
	public void testEnvironment() throws SQLException {
		javax.sql.DataSource ds = ioc.getBean("dataSource", javax.sql.DataSource.class);
		java.sql.Connection conn = ds.getConnection();
		System.err.println(conn);
	}
	
	@org.junit.Test
	public void  test(){
		mapper.deleteById(4);
	}

	
	@org.junit.Test
	public void testMP() {
		// 全局配置
		GlobalConfig config = new GlobalConfig();
		config.setActiveRecord(true) // 是否支持AR模式
				.setAuthor("wdx") // 作者
				.setOutputDir("E:\\software\\two\\eclipse\\workspace\\stu\\src\\main\\java") // 生成路径
				.setFileOverride(true)// 文件覆盖
				.setServiceName("%sService") // 设置生成的service接口名
				.setIdType(IdType.AUTO) // 主键策略
		;
		// 数据源配置
		DataSourceConfig dsConfig = new DataSourceConfig();
		dsConfig.setDbType(DbType.MYSQL).setUrl("jdbc:mysql://localhost:3306/mp").setDriverName("com.mysql.jdbc.Driver")
				.setUsername("root").setPassword("root");
		// 策略配置
		StrategyConfig stConfig = new StrategyConfig();
		stConfig.setCapitalMode(true) // 全局大写命名
				.setDbColumnUnderline(true) // 表名 字段名 是否使用下滑线命名
				.setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
				.setInclude("tbl_employee") // 生成的表
				.setTablePrefix("tbl_"); // 表前缀
		// 包名策略
		PackageConfig pkConfig = new PackageConfig();
		pkConfig.setParent("com.stu.mp").setController("controller").setEntity("beans").setService("service").setXml("mapper");
		AutoGenerator ag = new AutoGenerator().setGlobalConfig(config).setDataSource(dsConfig).setStrategy(stConfig)
				.setPackageInfo(pkConfig);
		ag.execute();
	}

}
