package com.example.demo

import com.alibaba.druid.pool.DruidDataSource
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import javax.annotation.Resource

/**
 * 启动类
 */
@SpringBootApplication(exclude =[DataSourceAutoConfiguration::class])
 class DemoApplication {

    @Resource
    lateinit var env: Environment

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<DemoApplication>(*args)
        }
    }

    /**
     *   代码初始化 jdbc
     */
    //destroy-method="close"的作用是当数据库连接不使用的时候,就把该连接重新放到数据池中,方便下次使用调用.
    @Bean(destroyMethod = "close")
    fun dataSource(): DruidDataSource? {
        val dataSource = DruidDataSource()
        dataSource.setUrl(env.getProperty("spring.datasource.url"))
        dataSource.setUsername(env.getProperty("spring.datasource.username")) //用户名
        dataSource.setPassword(env.getProperty("spring.datasource.password")) //密码
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"))
        dataSource.setInitialSize(10) //初始化时建立物理连接的个数
        dataSource.setMaxActive(30) //最大连接池数量
        dataSource.setMinIdle(0) //最小连接池数量
        dataSource.setMaxWait(60000) //获取连接时最大等待时间，单位毫秒。
        dataSource.setValidationQuery("SELECT 1") //用来检测连接是否有效的sql
        dataSource.setTestOnBorrow(false) //申请连接时执行validationQuery检测连接是否有效
        dataSource.setTestWhileIdle(true) //建议配置为true，不影响性能，并且保证安全性。
        dataSource.setPoolPreparedStatements(false) //是否缓存preparedStatement，也就是PSCache
        return dataSource
    }

}