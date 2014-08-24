package net.matholic.study.config;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
	@Bean
	public DozerBeanMapper dozerMapper() {
		List<String> mappingFileUrls = new ArrayList<String>();
		mappingFileUrls.add("dozer-bean-mappings.xml");
		
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(mappingFileUrls);
		return mapper;
	}
}
