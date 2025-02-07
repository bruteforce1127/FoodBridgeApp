package com.kucp1127.FoodBridge.CloudinaryConfiguraton;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dg6nwj26t",
                "api_key", "234841889476786",
                "api_secret", "OS7HxYgw7K6K2TjXaTAHshk12UI",
                "secure", true
        ));
    }
}

