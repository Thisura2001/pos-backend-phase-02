package lk.ijse.posbackendphase02.Config;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "lk.ijse.posbackendphase02")
@EnableWebMvc
@MultipartConfig//handle the multiple file format
public class WebAppConfig {
}
