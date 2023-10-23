package fisherp.common;

import fisherp.MasterApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { MasterApplication.class })
public class CucumberSpingConfiguration {}
