package com.example.demo

import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = [
	"jdbc.driverClassName=org.h2.Driver",
	"spring.datasource.url=jdbc:h2:mem:myDb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE",
	"hibernate.dialect=org.hibernate.dialect.H2Dialect",
	"hibernate.hbm2ddl.auto=create",
	"spring.flyway.enabled=false"
])
@Sql(statements = ["DELETE FROM demo_user;",
	"""INSERT INTO demo_user (user_id, first_name, last_name, street, house_no, zip_code, city, state, birthday)
	VALUES ('22558c65-374e-4de9-a236-014f17814baa', 'Monika', 'Musterfrau', 'Fananenweg', '15', '70771', 'Leinfelden', 'BW', '1970-08-25');"""])
class DemoApplicationTests {

	@Autowired
	lateinit var mockMvc: MockMvc

	@Test
	fun requestUsers() {
		mockMvc.perform(get("/demo/users"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk)
				.andExpect(jsonPath("$[0].firstName", `is`("Monika")))
	}

}
