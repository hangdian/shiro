package com.demo.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //shriofilterfactorybean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean( @Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
         //添加shiro的内置过滤器
        /*
            anon--无需认证就可以访问
            authc--必须认证才可以访问
            user--必须 拥有记住我  功能才能用
            perms--拥有对某个资源的权限才可以访问
            role--拥有某个角色权限才能访问
         */
        Map<String, String> filterMap= new LinkedHashMap<>();
        filterMap.put("/user/add","perms[user:add]");
        filterMap.put("/user/update","perms[user:update]");
        filterMap.put("/user/**","authc");
        //filterMap.put("/user/**","authc");
        bean.setFilterChainDefinitionMap(filterMap);

        //登录的请求
        bean.setLoginUrl("/toLogin");
        //未授权页面
        bean.setUnauthorizedUrl("/noauth");
        return bean;
    }
    //defaultwebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    //创建realm对象
    @Bean//注入
    public  UserRealm userRealm(){
        return new UserRealm();
    }

}
