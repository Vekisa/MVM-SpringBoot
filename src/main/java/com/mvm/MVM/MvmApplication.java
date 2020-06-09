package com.mvm.MVM;

import com.mvm.MVM.cofiguration.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class MvmApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvmApplication.class, args);
	}

}
