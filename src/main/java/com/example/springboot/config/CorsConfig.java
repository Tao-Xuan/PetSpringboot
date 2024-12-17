package com.example.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration // 声明这是一个配置类，Spring Boot 会在启动时加载并应用这个配置。
public class CorsConfig {

    // 定义当前跨域请求的最大有效时长（单位为秒），这里设置为 1 天。
    private static final long MAX_AGE = 24 * 60 * 60;

    /**
     * 配置跨域过滤器，允许前端跨域访问。
     *
     * @return CorsFilter 跨域过滤器的实例
     */
    @Bean
    public CorsFilter corsFilter() {
        // 创建跨域配置源对象，用于存储和管理跨域配置。
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        // 创建跨域配置对象，用于设置具体的跨域规则。
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // 1. 允许所有来源的跨域请求
        //    "*" 表示允许任意域名（例如：http://localhost:3000 或其他域名）。
        //    在生产环境中建议替换为具体的前端地址（如 "http://example.com"）。
        corsConfiguration.addAllowedOrigin("*");

        // 2. 允许所有请求头
        //    "*" 表示前端可以发送任意的自定义请求头（如 Content-Type、Authorization）。
        corsConfiguration.addAllowedHeader("*");

        // 3. 允许所有的 HTTP 方法
        //    "*" 表示支持 GET、POST、PUT、DELETE 等所有方法。
        corsConfiguration.addAllowedMethod("*");

        // 4. 设置跨域请求的最大缓存时间
        //    指定浏览器在多长时间内不需要再次发送预检请求（单位为秒）。
        //    例如：如果一个请求通过了 CORS 检查，浏览器会缓存 86400 秒（即 1 天）。
        corsConfiguration.setMaxAge(MAX_AGE);

        // 5. 将上述跨域配置应用到所有路径
        //    "/**" 表示适用于应用中的所有接口路径。
        source.registerCorsConfiguration("/**", corsConfiguration);

        // 返回跨域过滤器实例，应用到整个项目中。
        return new CorsFilter(source);
    }
}
