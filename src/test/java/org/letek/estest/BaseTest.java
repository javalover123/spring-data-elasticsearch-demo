package org.letek.estest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public abstract class BaseTest extends AbstractJUnit4SpringContextTests {

}
