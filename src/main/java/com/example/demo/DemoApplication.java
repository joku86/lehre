package com.example.demo;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.map.repository.config.EnableMapRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.demo.asynch.SleepAndDream;
import com.example.demo.retryable.Achiever;
import com.example.demo.validation.City;
import com.example.demo.validation.MyUserJPARepository;
import com.example.demo.validation.User;
import com.example.demo.validation.User2;
import com.example.demo.validation.UserRepository;
import com.example.demo.validation.UserService;

@SpringBootApplication
@EnableCaching
@EnableAsync
@EnableRetry
//@EnableMapRepositories
@EnableJpaRepositories
public class DemoApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

//	@Autowired
//	private UserRepository userRepository;

	@Autowired
	private MyUserJPARepository repository;

	@Autowired
	private EntityManager em;
	
	@Autowired
	UserService userService;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${my.name}")
	private String myName;
	@Value("${hallo.test}")
	private String propFile2e;

	@Autowired
	private MaConfProps props;

	@Autowired
	SleepAndDream proc;
//	@Autowired
//	Achiever archiever;

	@Bean
	@Scope("prototype")
	public Point createaRandomPoint() {
		return new Point(new Random().nextInt(300), 456);

	}

	public static void main(String[] args) {

		System.out.println("MAIN " + Thread.currentThread().getId());
		log.debug("debug level log");
		log.info("Info level log");
		log.error("Log mit Argumenten {}", 1);
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		// context.getBean(Prophet.class).getHash().md5("test");
		// context.getBean(Prophet.class).getHash().md5("test");
		Point point = context.getBean(Point.class).getLocation();
		Point point2 = context.getBean(Point.class).getLocation();

		System.out.println(point);
		System.out.println(point2);

	}

	@Override
	public void run(String... args) throws Exception {

//		System.out.println(Arrays.asList(args).toString());
//		System.out.println("RUN " + Thread.currentThread().getId());
//		log.info("Vor sleep1Seconds");
//		proc.sleep1Seconds();
//		log.info("Nach sleep1Seconds");
//		log.info("Vor sleep1SecondWithDream()");
//		Future<String> future = proc.sleep1SecondWithDream();
//		log.info("Nach sleep1SecondWithDream()");
//		TimeUnit.SECONDS.sleep(2);
//		System.out.println(future.get());
//
//		User user = new User();
//		user.username = "tesddddt";
//		user.email = "dddd";
//		try {
//			userService.addUser(user);
//		} catch (ConstraintViolationException e) {
//			Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
//			System.out.println(constraintViolations);
//		}
//
//		System.out.println("Vor dem Aufruf");
////		int i = archiever.tryIt();
////		System.out.println("Nach dem Aufruf ist i=" + i);
//
//		System.out.println("injezierte VAriable " + myName);
//		System.out.println("Auf Klasse aus der prop datei: " + props.getHomepage() + ", ");
//		System.out.println("Aus der datei names: " + propFile2e);
//
//		List<Map<String, Object>> queryForList = jdbcTemplate.queryForList(
//				"SELECT * FROM BORDERS where regexp_like(country1, '^D$') or regexp_like(country2, '^D$')");
//		double sum = queryForList.stream().map(map -> map.get("LENGTH")).mapToDouble(m -> (Double) m).sum();
//		System.out.println("Borderlength Germany" + sum);
//
//		userRepository.save(new User2(1L, "Chris", "a@b.com"));
//		userRepository.save(new User2(2L, "Cora", "a@b.com"));
//		userRepository.save(new User2(3L, "Geli", ""));
//		System.out.println("Gespeichert über UserRepository" + userRepository.findAll());
//
//		Sort sort = Sort.by(Sort.Order.desc("username"), new Sort.Order(Sort.Direction.ASC, "email"));
//
//		Iterable<User2> sortedPersons = userRepository.findAll(sort);
//		System.out.println("Sortiert ----------------------");
//		sortedPersons.forEach(System.out::println);
//		
		
		
		repository.save(new City("Aaa", "D","pro1",345,42.3D,25.5D));
		repository.save(new City("BBBB", "D","pro2",123,23.3D,45.5D));
	 
		//System.out.println("Gespeichert über jpa repository" + repository.findAll());
	}
}
